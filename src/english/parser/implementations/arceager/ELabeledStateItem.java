package english.parser.implementations.arceager;

import include.linguistics.LabeledDependencyTreeNode;
import include.linguistics.TwoStringVector;
import include.linguistics.english.ESetOfLabels;
import include.linguistics.english.ETaggedWord;

import java.util.ArrayList;

import common.parser.LabeledDependencyParser;

import english.dependency.label.EDependencyLabel;

public class ELabeledStateItem {
	public final int OFF_STACK = 0;
	public final int ON_STACK_SHIFT = 1;
	public final int ON_STACK_ARCRIGHT = 2;
	
	private int stack_back;
	private int headstack_back;
	
	protected ArrayList<Integer> m_Stack;
	protected ArrayList<Integer> m_HeadStack;
	protected int m_nNextWord;
	protected int[] m_lHeads;
	protected int[] m_lDepsL;
	protected int[] m_lDepsR;
	protected int[] m_lDepNumL;
	protected int[] m_lDepNumR;
	
	protected ESetOfLabels m_lDepTagL[];
	protected ESetOfLabels m_lDepTagR[];
	protected int m_lSibling[];
	
	protected int m_nLastAction;
	protected ArrayList<ETaggedWord> m_lCache;
	
	public long score;
	
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
	
	public ELabeledStateItem() {
		stack_back = -1;
		headstack_back = -1;
		m_Stack = new ArrayList<Integer>();
		m_HeadStack = new ArrayList<Integer>();
		m_lHeads = new int[EMacros.MAX_SENTENCE_SIZE];
		m_lDepsL = new int[EMacros.MAX_SENTENCE_SIZE];
		m_lDepsR = new int[EMacros.MAX_SENTENCE_SIZE];
		m_lDepNumL = new int[EMacros.MAX_SENTENCE_SIZE];
		m_lDepNumR = new int[EMacros.MAX_SENTENCE_SIZE];
		m_lDepTagL = new ESetOfLabels[EMacros.MAX_SENTENCE_SIZE];
		m_lDepTagR = new ESetOfLabels[EMacros.MAX_SENTENCE_SIZE];
		for (int i = 0; i < EMacros.MAX_SENTENCE_SIZE; ++i) {
			m_lDepTagL[i] = new ESetOfLabels();
			m_lDepTagR[i] = new ESetOfLabels();
		}
		m_lSibling = new int[EMacros.MAX_SENTENCE_SIZE];
		m_lCache = null;
		m_lLabels = new int[EMacros.MAX_SENTENCE_SIZE];
		clear();
	}
	
	public ELabeledStateItem(ArrayList<ETaggedWord> cache) {
		stack_back = -1;
		headstack_back = -1;
		m_Stack = new ArrayList<Integer>();
		m_HeadStack = new ArrayList<Integer>();
		m_lHeads = new int[EMacros.MAX_SENTENCE_SIZE];
		m_lDepsL = new int[EMacros.MAX_SENTENCE_SIZE];
		m_lDepsR = new int[EMacros.MAX_SENTENCE_SIZE];
		m_lDepNumL = new int[EMacros.MAX_SENTENCE_SIZE];
		m_lDepNumR = new int[EMacros.MAX_SENTENCE_SIZE];
		m_lDepTagL = new ESetOfLabels[EMacros.MAX_SENTENCE_SIZE];
		m_lDepTagR = new ESetOfLabels[EMacros.MAX_SENTENCE_SIZE];
		for (int i = 0; i < EMacros.MAX_SENTENCE_SIZE; ++i) {
			m_lDepTagL[i] = new ESetOfLabels();
			m_lDepTagR[i] = new ESetOfLabels();
		}
		m_lSibling = new int[EMacros.MAX_SENTENCE_SIZE];
		m_lCache = cache;
		m_lLabels = new int[EMacros.MAX_SENTENCE_SIZE];
		clear();
	}
	
	public final boolean more(final ELabeledStateItem item) {
		return score > item.score;
	}
	
	public final boolean less(final ELabeledStateItem item) {
		return score < item.score;
	}
	
	@Override
	public boolean equals(Object o) {
		ELabeledStateItem item = (ELabeledStateItem)o;
		if (m_nNextWord != item.m_nNextWord) {
			return false;
		}
		for (int i = 0; i < m_nNextWord; ++i) {
			if (m_lHeads[i] != item.m_lHeads[i]) {
				return false;
			}
		}
		for (int i = 0; i < m_nNextWord; ++i) {
			if (m_lLabels[i] != item.m_lLabels[i]) {
				return false;
			}
		}
		if (stack_back != item.stack_back) {
			return false;
		}
		if (stack_back > 0 && m_Stack.get(stack_back).intValue() != item.m_Stack.get(stack_back).intValue()) {
			return false;
		}
		return true;
	}
	
	public final int stacksize() {
		return stack_back + 1;
	}
	
	public final boolean stackempty() {
		return stack_back == -1;
	}
	
	public final int stacktop() {
		return m_Stack.get(stack_back).intValue();
	}
	
	public final int stackbottom() {
		return m_Stack.get(0).intValue();
	}
	
	public final int stackitem(final int index) {
		return m_Stack.get(index).intValue();
	}
	
	public final boolean headstackempty() {
		return headstack_back == -1;
	}
	
	public final int headstacktop() {
		return m_HeadStack.get(headstack_back).intValue();
	}
	
	public final int headstackitem(final int index) {
		return m_HeadStack.get(index).intValue();
	}
	
	public final int headstacksize() {
		return headstack_back + 1;
	}
	
	public final boolean afterreduce() {
		return ELabeledAction.getUnlabeledAction(m_nLastAction) == ELabeledAction.REDUCE;
	}
	
	public final int head(final int index) {
		return m_lHeads[index];
	}
	
	public final int leftdep(final int index) {
		return m_lDepsL[index];
	}
	
	public final int rightdep(final int index) {
		return m_lDepsR[index];
	}
	
	public final int sibling(final int index) {
		return m_lSibling[index];
	}
	
	public final int size() {
		return m_nNextWord;
	}
	
	public final int leftarity(final int index) {
		return m_lDepNumL[index];
	}
	
	public final int rightarity(final int index) {
		return m_lDepNumR[index];
	}
	
	public final ESetOfLabels lefttagset(final int index) {
		return m_lDepTagL[index];
	}
	
	public final ESetOfLabels righttagset(final int index) {
		return m_lDepTagR[index];
	}
	
	public final int label(final int index) {
		return m_lLabels[index];
	}
	
	public void clear() {
		m_nNextWord = 0;
		stack_back = -1;
		headstack_back = -1;
		m_Stack.clear();
		m_HeadStack.clear();
		score = 0;
		m_nLastAction = ELabeledAction.NO_ACTION;
		ClearNext();
	}
	
	public void ArcLeft(int lab) {
		int left = m_Stack.get(stack_back).intValue();
		m_Stack.remove(stack_back--);
		m_HeadStack.remove(headstack_back--);
		m_lHeads[left] = m_nNextWord;
		m_lLabels[left] = lab;
		m_lDepTagL[m_nNextWord].add(lab);
		m_lSibling[left] = m_lDepsL[m_nNextWord];
		m_lDepsL[m_nNextWord] = left;
		++m_lDepNumL[m_nNextWord];
		m_nLastAction = ELabeledAction.encodeAction(ELabeledAction.ARC_LEFT, lab);
	}
	
	public void ArcRight(int lab) {
		int left = m_Stack.get(stack_back++).intValue();
		m_Stack.add(Integer.valueOf(m_nNextWord));
		m_lHeads[m_nNextWord] = left;
		m_lLabels[m_nNextWord] = lab;
		m_lDepTagR[left].add(lab);
		m_lSibling[m_nNextWord] = m_lDepsR[left];
		m_lDepsR[left] = m_nNextWord++;
		++m_lDepNumR[left];
		ClearNext();
		m_nLastAction = ELabeledAction.encodeAction(ELabeledAction.ARC_RIGHT, lab);
	}

	public void Shift() {
		++stack_back;
		m_Stack.add(Integer.valueOf(m_nNextWord));
		++headstack_back;
		m_HeadStack.add(Integer.valueOf(m_nNextWord++));
		ClearNext();
		m_nLastAction = ELabeledAction.encodeAction(ELabeledAction.SHIFT);
	}
	
	public void Reduce() {
		m_Stack.remove(stack_back--);
		m_nLastAction = ELabeledAction.encodeAction(ELabeledAction.REDUCE);
	}
	
	public void PopRoot() {
		m_lLabels[m_Stack.get(stack_back).intValue()] = EDependencyLabel.ROOT;
		m_nLastAction = ELabeledAction.encodeAction(ELabeledAction.POP_ROOT);
		m_Stack.remove(stack_back--);
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
		m_lLabels[m_nNextWord] = EDependencyLabel.NONE;
	}
	
	public void Move(final int ac) {
		switch (ELabeledAction.getUnlabeledAction(ac)) {
		case ELabeledAction.NO_ACTION:
			return;
		case ELabeledAction.SHIFT:
			Shift();
			return;
		case ELabeledAction.REDUCE:
			Reduce();
			return;
		case ELabeledAction.ARC_LEFT:
			ArcLeft(ELabeledAction.getLabel(ac));
			return;
		case ELabeledAction.ARC_RIGHT:
			ArcRight(ELabeledAction.getLabel(ac));
			return;
		case ELabeledAction.POP_ROOT:
			PopRoot();
			return;
		}
	}
	
	public boolean StandardMoveStep(final LabeledDependencyParser tree, final ArrayList<EDependencyLabel> m_lCacheLabel) {
		int top;
		if (m_nNextWord == (int)(tree.size())) {
			if (stack_back > 0) {
				Reduce();
				return false;
			} else {
				PopRoot();
				return false;
			}
		}
		if (stack_back >= 0) {
			top = m_Stack.get(stack_back).intValue();
			while (!(m_lHeads[top] == LabeledDependencyTreeNode.DEPENDENCY_LINK_NO_HEAD)) {
				top = m_lHeads[top];
			}
			if (tree.get(top).head == m_nNextWord) {
				if (top == m_Stack.get(stack_back).intValue()) {
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
			top = m_Stack.get(stack_back).intValue();
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
		assert (stack_back == -1);
	}
	
	public int FollowMove(final ELabeledStateItem item) {
		int top;
		if (m_nNextWord == item.m_nNextWord) {
			top = m_Stack.get(stack_back).intValue();
			if (item.m_lHeads[top] == m_nNextWord) {
				return ELabeledAction.encodeAction(ELabeledAction.ARC_LEFT, item.m_lLabels[top]);
			} else if (item.m_lHeads[top] != LabeledDependencyTreeNode.DEPENDENCY_LINK_NO_HEAD) {
				return ELabeledAction.encodeAction(ELabeledAction.REDUCE);
			} else {
				return ELabeledAction.encodeAction(ELabeledAction.POP_ROOT);
			}
		}
		if (stack_back >= 0) {
			top = m_Stack.get(stack_back).intValue();
			while (!(m_lHeads[top] == LabeledDependencyTreeNode.DEPENDENCY_LINK_NO_HEAD)) {
				top = m_lHeads[top];
			}
			if (item.head(top) == m_nNextWord) {
				if (top == m_Stack.get(stack_back).intValue()) {
					return ELabeledAction.encodeAction(ELabeledAction.ARC_LEFT, item.m_lLabels[top]);
				} else {
					return ELabeledAction.encodeAction(ELabeledAction.REDUCE);
				}
			}
		}
		if (item.head(m_nNextWord) == LabeledDependencyTreeNode.DEPENDENCY_LINK_NO_HEAD ||
				item.head(m_nNextWord) > m_nNextWord) {
			return ELabeledAction.encodeAction(ELabeledAction.SHIFT);
		} else {
			top = m_Stack.get(stack_back).intValue();
			if (item.head(m_nNextWord) == top) {
				return ELabeledAction.encodeAction(ELabeledAction.ARC_RIGHT, item.m_lLabels[m_nNextWord]);
			} else {
				return ELabeledAction.encodeAction(ELabeledAction.REDUCE);
			}
		}
	}
	
	public void GenerateTree(final TwoStringVector input, LabeledDependencyParser output) {
		output.clear();
		for (int i = 0, input_size = this.size(); i < input_size; ++i) {
			output.add(new LabeledDependencyTreeNode(input.get(i).first(), input.get(i).second(), m_lHeads[i], EDependencyLabel.str(m_lLabels[i])));
		}
	}
	
	public void copy(final ELabeledStateItem item) {
		stack_back = item.stack_back;
		m_Stack.clear();
		m_Stack.addAll(item.m_Stack);
		headstack_back = item.headstack_back;
		m_HeadStack.clear();
		m_HeadStack.addAll(item.m_HeadStack);
		m_nNextWord = item.m_nNextWord;
		m_nLastAction = item.m_nLastAction;
		m_lCache = item.m_lCache;
		score = item.score;
		int length = m_nNextWord + 1;
		System.arraycopy(item.m_lHeads, 0, m_lHeads, 0, length);
		System.arraycopy(item.m_lDepsL, 0, m_lDepsL, 0, length);
		System.arraycopy(item.m_lDepsR, 0, m_lDepsR, 0, length);
		System.arraycopy(item.m_lDepNumL, 0, m_lDepNumL, 0, length);
		System.arraycopy(item.m_lDepNumR, 0, m_lDepNumR, 0, length);
		System.arraycopy(item.m_lSibling, 0, m_lSibling, 0, length);
		System.arraycopy(item.m_lLabels, 0, m_lLabels, 0, length);
		for (int i = 0; i < length; ++i) {
			m_lDepTagL[i].set(item.m_lDepTagL[i]);
			m_lDepTagR[i].set(item.m_lDepTagR[i]);
		}
	}
}
