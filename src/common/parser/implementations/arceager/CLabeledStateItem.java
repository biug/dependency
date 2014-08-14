package common.parser.implementations.arceager;

import include.linguistics.CSetOfTags;
import include.linguistics.CTaggedWord;
import include.linguistics.LabeledDependencyTreeNode;
import include.linguistics.TwoStringVector;

import java.util.Iterator;
import java.util.LinkedList;

import chinese.dependency.label.CDependencyLabel;
import common.parser.LabeledDependencyParser;

public class CLabeledStateItem {
	public final int OFF_STACK = 0;
	public final int ON_STACK_SHIFT = 1;
	public final int ON_STACK_ARCRIGHT = 2;
	
	protected LinkedList<Integer> m_Stack;
	protected LinkedList<Integer> m_HeadStack;
	protected int m_nNextWord;
	protected int[] m_lHeads;
	protected int[] m_lDepsL;
	protected int[] m_lDepsR;
	protected int[] m_lDepNumL;
	protected int[] m_lDepNumR;
	
	protected CSetOfTags m_lDepTagL[];
	protected CSetOfTags m_lDepTagR[];
	protected int m_lSibling[];
	
	protected int m_nLastAction;
	protected LinkedList<CTaggedWord> m_lCache;
	
	public int score;
	
	protected int m_lLabels[];
	
	public void printstate(int len) {
		System.out.println(m_Stack);
		System.out.println(m_HeadStack);
		System.out.println(m_nNextWord);
		System.out.print(m_lHeads[0]); for (int i = 1; i <= m_nNextWord; ++i) System.out.print(" " + m_lHeads[i]); System.out.println();
		System.out.print(m_lDepsL[0]); for (int i = 1; i <= m_nNextWord; ++i) System.out.print(" " + m_lDepsL[i]); System.out.println();
		System.out.print(m_lDepsR[0]); for (int i = 1; i <= m_nNextWord; ++i) System.out.print(" " + m_lDepsR[i]); System.out.println();
		System.out.print(m_lDepNumL[0]); for (int i = 1; i <= m_nNextWord; ++i) System.out.print(" " + m_lDepNumL[i]); System.out.println();
		System.out.print(m_lDepNumR[0]); for (int i = 1; i <= m_nNextWord; ++i) System.out.print(" " + m_lDepNumR[i]); System.out.println();
		m_lDepTagL[0].print(""); for (int i = 1; i <= m_nNextWord; ++i) m_lDepTagL[i].print(" "); System.out.println();
		m_lDepTagR[0].print(""); for (int i = 1; i <= m_nNextWord; ++i) m_lDepTagR[i].print(" "); System.out.println();
		System.out.print(m_lSibling[0]); for (int i = 1; i <= m_nNextWord; ++i) System.out.print(" " + m_lSibling[i]); System.out.println();
		System.out.print(m_lLabels[0]); for (int i = 1; i <= m_nNextWord; ++i) System.out.print(" " + m_lLabels[i]); System.out.println();
		System.out.println(m_nLastAction);
		System.out.println("score = " + score);
	}
	
	public CLabeledStateItem() {
		m_Stack = new LinkedList<Integer>();
		m_HeadStack = new LinkedList<Integer>();
		m_lHeads = new int[Macros.MAX_SENTENCE_SIZE];
		m_lDepsL = new int[Macros.MAX_SENTENCE_SIZE];
		m_lDepsR = new int[Macros.MAX_SENTENCE_SIZE];
		m_lDepNumL = new int[Macros.MAX_SENTENCE_SIZE];
		m_lDepNumR = new int[Macros.MAX_SENTENCE_SIZE];
		m_lDepTagL = new CSetOfTags[Macros.MAX_SENTENCE_SIZE];
		m_lDepTagR = new CSetOfTags[Macros.MAX_SENTENCE_SIZE];
		for (int i = 0; i < Macros.MAX_SENTENCE_SIZE; ++i) {
			m_lDepTagL[i] = new CSetOfTags();
			m_lDepTagR[i] = new CSetOfTags();
		}
		m_lSibling = new int[Macros.MAX_SENTENCE_SIZE];
		m_lCache = null;
		m_lLabels = new int[Macros.MAX_SENTENCE_SIZE];
		clear();
	}
	
	public CLabeledStateItem(LinkedList<CTaggedWord> cache) {
		m_Stack = new LinkedList<Integer>();
		m_HeadStack = new LinkedList<Integer>();
		m_lHeads = new int[Macros.MAX_SENTENCE_SIZE];
		m_lDepsL = new int[Macros.MAX_SENTENCE_SIZE];
		m_lDepsR = new int[Macros.MAX_SENTENCE_SIZE];
		m_lDepNumL = new int[Macros.MAX_SENTENCE_SIZE];
		m_lDepNumR = new int[Macros.MAX_SENTENCE_SIZE];
		m_lDepTagL = new CSetOfTags[Macros.MAX_SENTENCE_SIZE];
		m_lDepTagR = new CSetOfTags[Macros.MAX_SENTENCE_SIZE];
		for (int i = 0; i < Macros.MAX_SENTENCE_SIZE; ++i) {
			m_lDepTagL[i] = new CSetOfTags();
			m_lDepTagR[i] = new CSetOfTags();
		}
		m_lSibling = new int[Macros.MAX_SENTENCE_SIZE];
		m_lCache = cache;
		m_lLabels = new int[Macros.MAX_SENTENCE_SIZE];
		clear();
	}
	
	public boolean more(final CLabeledStateItem item) {
		return score > item.score;
	}
	
	public boolean less(final CLabeledStateItem item) {
		return score < item.score;
	}
	
	@Override
	public boolean equals(Object o) {
		if (m_nNextWord != ((CLabeledStateItem)o).m_nNextWord) {
			return false;
		}
		for (int i = 0; i < m_nNextWord; ++i) {
			if (m_lHeads[i] != ((CLabeledStateItem)o).m_lHeads[i]) {
				return false;
			}
		}
		for (int i = 0; i < m_nNextWord; ++i) {
			if (m_lLabels[i] != ((CLabeledStateItem)o).m_lLabels[i]) {
				return false;
			}
		}
		if (m_Stack.size() != ((CLabeledStateItem)o).m_Stack.size()) {
			return false;
		}
		if (m_Stack.size() > 0 && m_Stack.getLast().intValue() != ((CLabeledStateItem)o).m_Stack.getLast().intValue()) {
			return false;
		}
		return true;
	}
	
	public int stacksize() {
		return m_Stack.size();
	}
	
	public boolean stackempty() {
		return m_Stack.isEmpty();
	}
	
	public int stacktop() {
		return m_Stack.getLast().intValue();
	}
	
	public int stackbottom() {
		return m_Stack.getFirst().intValue();
	}
	
	public int stackitem(final int index) {
		return m_Stack.get(index).intValue();
	}
	
	public boolean headstackempty() {
		return m_HeadStack.isEmpty();
	}
	
	public int headstacktop() {
		return m_HeadStack.getLast().intValue();
	}
	
	public int headstackitem(final int index) {
		return m_HeadStack.get(index).intValue();
	}
	
	public int headstacksize() {
		return m_HeadStack.size();
	}
	
	public boolean afterreduce() {
		return Action.getUnlabeledAction(m_nLastAction) == Action.REDUCE;
	}
	
	public int head(final int index) {
		return m_lHeads[index];
	}
	
	public int leftdep(final int index) {
		return m_lDepsL[index];
	}
	
	public int rightdep(final int index) {
		return m_lDepsR[index];
	}
	
	public int sibling(final int index) {
		return m_lSibling[index];
	}
	
	public int size() {
		return m_nNextWord;
	}
	
	public int leftarity(final int index) {
		return m_lDepNumL[index];
	}
	
	public int rightarity(final int index) {
		return m_lDepNumR[index];
	}
	
	public CSetOfTags lefttagset(final int index) {
		return m_lDepTagL[index];
	}
	
	public CSetOfTags righttagset(final int index) {
		return m_lDepTagR[index];
	}
	
	public int label(final int index) {
		return m_lLabels[index];
	}
	
	public void clear() {
		m_nNextWord = 0;
		m_Stack.clear();
		m_HeadStack.clear();
		score = 0;
		m_nLastAction = Action.NO_ACTION;
		ClearNext();
	}
	
	public void ArcLeft(int lab) {
		int left = m_Stack.getLast().intValue();
		m_Stack.removeLast();
		m_HeadStack.removeLast();
		m_lHeads[left] = m_nNextWord;
		m_lLabels[left] = lab;
		m_lDepTagL[m_nNextWord].add(new CDependencyLabel(lab));
		m_lSibling[left] = m_lDepsL[m_nNextWord];
		m_lDepsL[m_nNextWord] = left;
		++m_lDepNumL[m_nNextWord];
		m_nLastAction = Action.encodeAction(Action.ARC_LEFT, lab);
	}
	
	public void ArcRight(int lab) {
		int left = m_Stack.getLast().intValue();
		m_Stack.add(new Integer(m_nNextWord));
		m_lHeads[m_nNextWord] = left;
		m_lLabels[m_nNextWord] = lab;
		m_lDepTagR[left].add(new CDependencyLabel(lab));
		m_lSibling[m_nNextWord] = m_lDepsR[left];
		m_lDepsR[left] = m_nNextWord;
		++m_lDepNumR[left];
		++m_nNextWord;
		ClearNext();
		m_nLastAction = Action.encodeAction(Action.ARC_RIGHT, lab);
	}

	public void Shift() {
		m_Stack.add(new Integer(m_nNextWord));
		m_HeadStack.add(new Integer(m_nNextWord));
		++m_nNextWord;
		ClearNext();
		m_nLastAction = Action.encodeAction(Action.SHIFT);
	}
	
	public void Reduce() {
		m_Stack.removeLast();
		m_nLastAction = Action.encodeAction(Action.REDUCE);
	}
	
	public void PopRoot() {
		m_lLabels[m_Stack.getLast().intValue()] = CDependencyLabel.ROOT;
		m_nLastAction = Action.encodeAction(Action.POP_ROOT);
		m_Stack.removeLast();
	}
	
	public void ClearNext() {
		m_lHeads[m_nNextWord] = LabeledDependencyTreeNode.DEPENDENCY_LINK_NO_HEAD;
		m_lDepsL[m_nNextWord] = LabeledDependencyTreeNode.DEPENDENCY_LINK_NO_HEAD;
		m_lDepsR[m_nNextWord] = LabeledDependencyTreeNode.DEPENDENCY_LINK_NO_HEAD;
		m_lDepNumL[m_nNextWord] = 0;
		m_lDepNumR[m_nNextWord] = 0;
		m_lDepTagL[m_nNextWord].clear();
		m_lDepTagR[m_nNextWord].clear();
		m_lSibling[m_nNextWord] = LabeledDependencyTreeNode.DEPENDENCY_LINK_NO_HEAD;
		m_lLabels[m_nNextWord] = CDependencyLabel.NONE;
	}
	
	public void Move(final int ac) {
		switch (Action.getUnlabeledAction(ac)) {
		case Action.NO_ACTION:
			return;
		case Action.SHIFT:
			Shift();
			return;
		case Action.REDUCE:
			Reduce();
			return;
		case Action.ARC_LEFT:
			ArcLeft(Action.getLabel(ac));
			return;
		case Action.ARC_RIGHT:
			ArcRight(Action.getLabel(ac));
			return;
		case Action.POP_ROOT:
			PopRoot();
			return;
		}
	}
	
	public boolean StandardMoveStep(final LabeledDependencyParser tree, final LinkedList<CDependencyLabel> m_lCacheLabel) {
		int top;
		if (m_nNextWord == (int)(tree.size())) {
			if (m_Stack.size() > 1) {
				Reduce();
				return false;
			} else {
				PopRoot();
				return false;
			}
		}
		if (m_Stack.size() > 0) {
			top = m_Stack.getLast().intValue();
			while (!(m_lHeads[top] == LabeledDependencyTreeNode.DEPENDENCY_LINK_NO_HEAD)) {
				top = m_lHeads[top];
			}
			if (tree.get(top).head == m_nNextWord) {
				if (top == m_Stack.getLast().intValue()) {
					ArcLeft(m_lCacheLabel.get(top).hashCode());
					return false;
				} else {
					Reduce();
					return false;
				}
			}
		}
		if (tree.get(m_nNextWord).head == LabeledDependencyTreeNode.DEPENDENCY_LINK_NO_HEAD ||
				tree.get(m_nNextWord).head > m_nNextWord) {
			Shift();
			return true;
		} else {
			top = m_Stack.getLast().intValue();
			if (tree.get(m_nNextWord).head == top) {
				ArcRight(m_lCacheLabel.get(m_nNextWord).hashCode());
				return true;
			} else {
				Reduce();
				return false;
			}
		}
	}
	
	public void StandardFinish() {
		assert (m_Stack.size() == 0);
	}
	
	public int FollowMove(final CLabeledStateItem item) {
		int top;
		if (m_nNextWord == item.m_nNextWord) {
			top = m_Stack.getLast().intValue();
			if (item.m_lHeads[top] == m_nNextWord) {
				return Action.encodeAction(Action.ARC_LEFT, item.m_lLabels[top]);
			} else if (item.m_lHeads[top] != LabeledDependencyTreeNode.DEPENDENCY_LINK_NO_HEAD) {
				return Action.encodeAction(Action.REDUCE);
			} else {
				return Action.encodeAction(Action.POP_ROOT);
			}
		}
		if (m_Stack.size() > 0) {
			top = m_Stack.getLast().intValue();
			while (!(m_lHeads[top] == LabeledDependencyTreeNode.DEPENDENCY_LINK_NO_HEAD)) {
				top = m_lHeads[top];
			}
			if (item.head(top) == m_nNextWord) {
				if (top == m_Stack.getLast().intValue()) {
					return Action.encodeAction(Action.ARC_LEFT, item.m_lLabels[top]);
				} else {
					return Action.encodeAction(Action.REDUCE);
				}
			}
		}
		if (item.head(m_nNextWord) == LabeledDependencyTreeNode.DEPENDENCY_LINK_NO_HEAD ||
				item.head(m_nNextWord) > m_nNextWord) {
			return Action.encodeAction(Action.SHIFT);
		} else {
			top = m_Stack.getLast().intValue();
			if (item.head(m_nNextWord) == top) {
				return Action.encodeAction(Action.ARC_RIGHT, item.m_lLabels[m_nNextWord]);
			} else {
				return Action.encodeAction(Action.REDUCE);
			}
		}
	}
	
	public void GenerateTree(final TwoStringVector input, LabeledDependencyParser output) {
		output.clear();
		for (int i = 0; i < size(); ++i) {
			output.add(new LabeledDependencyTreeNode(input.get(i).first(), input.get(i).second(), m_lHeads[i], new CDependencyLabel(m_lLabels[i]).toString()));
		}
	}
	
	public void copy(final CLabeledStateItem item) {
		Iterator<Integer> itr;
		m_Stack.clear();
		itr = item.m_Stack.iterator();
		while (itr.hasNext()) {
			m_Stack.add(new Integer(itr.next().intValue()));
		}
		m_HeadStack.clear();
		itr = item.m_HeadStack.iterator();
		while (itr.hasNext()) {
			m_HeadStack.add(new Integer(itr.next().intValue()));
		}
		m_nNextWord = item.m_nNextWord;
		m_nLastAction = item.m_nLastAction;
		m_lCache = item.m_lCache;
		score = item.score;
		for (int i = 0; i <= m_nNextWord; ++i) {
			m_lHeads[i] = item.m_lHeads[i];
			m_lDepsL[i] = item.m_lDepsL[i]; 
			m_lDepsR[i] = item.m_lDepsR[i];
			m_lDepNumL[i] = item.m_lDepNumL[i];
			m_lDepNumR[i] = item.m_lDepNumR[i];
			m_lDepTagL[i].set(item.m_lDepTagL[i]);
			m_lDepTagR[i].set(item.m_lDepTagR[i]);
			m_lSibling[i] = item.m_lSibling[i];
			m_lLabels[i] = item.m_lLabels[i];
		}
	}
}
