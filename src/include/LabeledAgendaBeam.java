package include;

import common.parser.implementations.arceager.CLabeledStateItem;

public class LabeledAgendaBeam {
	private int m_nMaxSize;
	private CLabeledStateItem m_lBeam[][];
	private int m_nBeamSize[];
	private int m_nGenerator;
	private int m_nGenerated;
	private int m_nGeneratorIndex;
	
	private void swap(final int which, final int index1, final int index2) {
		CLabeledStateItem sa = m_lBeam[which][index1];
		m_lBeam[which][index1] = m_lBeam[which][index2];
		m_lBeam[which][index2] = sa;
	}
	
	private void push_heap(final int which, int base) {
		CLabeledStateItem[] items = m_lBeam[which];
		while (base > 0) {
			if (items[(base - 1) >> 1].more(items[base])) {
				swap(which, base, (base - 1) >> 1);
				base = (base - 1) >> 1;
			} else {
				break;
			}
		}
	}
	
	private void pop_heap(final int which) {
		if (m_nBeamSize[which] <= 0) return;
		CLabeledStateItem[] items = m_lBeam[which];
		swap(which, 0, --m_nBeamSize[which]);
		CLabeledStateItem item = items[0];
		int index = 0, child = 1;
		while (child < m_nBeamSize[which]) {
			if (child + 1 < m_nBeamSize[which] && !items[child + 1].more(items[child])) {
				++child;
			}
			items[index] = items[child];
			index = child;
			child = (child << 1) + 1;
		}
		m_lBeam[which][index] = item;
		push_heap(which, index);
	}
	
	public LabeledAgendaBeam(int nBeamSize) {
		m_nMaxSize = nBeamSize;
		m_lBeam = new CLabeledStateItem[2][];
		m_lBeam[0] = new CLabeledStateItem[m_nMaxSize];
		m_lBeam[1] = new CLabeledStateItem[m_nMaxSize];
		for (int i = 0; i < m_nMaxSize; ++i) {
			m_lBeam[0][i] = new CLabeledStateItem();
			m_lBeam[1][i] = new CLabeledStateItem();
		}
		m_nBeamSize = new int[2];
		clear();
	}
	
	public void clear(int which) {
		m_nBeamSize[which] = 0;
	}
	
	public void clear() {
		m_nBeamSize[0] = 0;
		m_nBeamSize[1] = 0;
		m_nGenerator = 0;
		m_nGenerated = 1;
	}
	
	public CLabeledStateItem generatorStart() {
		if (m_nBeamSize[m_nGenerator] != 0) {
			m_nGeneratorIndex = 0;
			return m_lBeam[m_nGenerator][m_nGeneratorIndex];
		} else {
			return null;
		}
	}
	
	public CLabeledStateItem generatorNext() {
		++m_nGeneratorIndex;
		if (m_nGeneratorIndex >= m_nBeamSize[m_nGenerator]) {
			return null;
		}
		return m_lBeam[m_nGenerator][m_nGeneratorIndex];
	}
	
	public int generatorSize() {
		return m_nBeamSize[m_nGenerator];
	}
	
	public int candidateSize() {
		return m_nBeamSize[m_nGenerated];
	}
	
	public CLabeledStateItem candidateItem() {
		if (m_nBeamSize[m_nGenerated] == m_nMaxSize) {
			pop_heap(m_nGenerated);
		}
		return m_lBeam[m_nGenerated][m_nBeamSize[m_nGenerated]++];
	}
	
	public void pushCandidate() {
		push_heap(m_nGenerated, m_nBeamSize[m_nGenerated] - 1);
	}
	
	public void pushCandidate(final CLabeledStateItem item) {
		if (m_nBeamSize[m_nGenerated] == m_nMaxSize) {
			if (!item.more(m_lBeam[m_nGenerated][0])) {
				return;
			}
			pop_heap(m_nGenerated);
		}
		m_lBeam[m_nGenerated][m_nBeamSize[m_nGenerated]].copy(item);
		push_heap(m_nGenerated, m_nBeamSize[m_nGenerated]++);
	}
	
	public void nextRound() {
		m_nGenerator = 1 - m_nGenerator;
		m_nGenerated = 1 - m_nGenerated;
		clear(m_nGenerated);
	}
	
	public CLabeledStateItem bestGenerator() {
		CLabeledStateItem[] items = m_lBeam[m_nGenerator];
		CLabeledStateItem item = items[0];
		for (int i = 1, max_size = m_nBeamSize[m_nGenerator]; i < max_size; ++i) {
			if (item.less(items[i])) {
				item = items[i];
			}
		}
		return item;
	}
	
	public CLabeledStateItem generator(int n) {
		if (n >= m_nBeamSize[m_nGenerator]) {
			return null;
		}
		return m_lBeam[m_nGenerator][n];
	}
	
	public void sortGenerators() {
		int size = m_nBeamSize[m_nGenerator];
		while (m_nBeamSize[m_nGenerator] > 0) {
			pop_heap(m_nGenerator);
		}
		m_nBeamSize[m_nGenerator] = size;
	}
	
	public void print(int len) {
		for (int i = 0, max_size = m_nBeamSize[m_nGenerator]; i < max_size; ++i) {
			m_lBeam[m_nGenerator][i].printstate(len);
		}
	}
}
