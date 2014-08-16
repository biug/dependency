package common.parser.implementations.arceager;

import include.linguistics.LabeledDependencyTreeNode;
import include.linguistics.TwoStringVector;
import include.linguistics.chinese.CSetOfTags;
import include.linguistics.chinese.CTaggedWord;

import java.util.ArrayList;

import chinese.dependency.label.CDependencyLabel;
import common.parser.LabeledDependencyParser;

public class CLabeledStateItem {
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
	
	protected CSetOfTags m_lDepTagL[];
	protected CSetOfTags m_lDepTagR[];
	protected int m_lSibling[];
	
	protected int m_nLastAction;
	protected ArrayList<CTaggedWord> m_lCache;
	
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
		stack_back = -1;
		headstack_back = -1;
		m_Stack = new ArrayList<Integer>();
		m_HeadStack = new ArrayList<Integer>();
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
	
	public CLabeledStateItem(ArrayList<CTaggedWord> cache) {
		stack_back = -1;
		headstack_back = -1;
		m_Stack = new ArrayList<Integer>();
		m_HeadStack = new ArrayList<Integer>();
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
	
	public final boolean more(final CLabeledStateItem item) {
		return score > item.score;
	}
	
	public final boolean less(final CLabeledStateItem item) {
		return score < item.score;
	}
	
	@Override
	public boolean equals(Object o) {
		CLabeledStateItem item = (CLabeledStateItem)o;
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
		return Action.getUnlabeledAction(m_nLastAction) == Action.REDUCE;
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
	
	public final CSetOfTags lefttagset(final int index) {
		return m_lDepTagL[index];
	}
	
	public final CSetOfTags righttagset(final int index) {
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
		m_nLastAction = Action.NO_ACTION;
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
		m_nLastAction = Action.encodeAction(Action.ARC_LEFT, lab);
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
		m_nLastAction = Action.encodeAction(Action.ARC_RIGHT, lab);
	}

	public void Shift() {
		++stack_back;
		m_Stack.add(Integer.valueOf(m_nNextWord));
		++headstack_back;
		m_HeadStack.add(Integer.valueOf(m_nNextWord++));
		ClearNext();
		m_nLastAction = Action.encodeAction(Action.SHIFT);
	}
	
	public void Reduce() {
		m_Stack.remove(stack_back--);
		m_nLastAction = Action.encodeAction(Action.REDUCE);
	}
	
	public void PopRoot() {
		m_lLabels[m_Stack.get(stack_back).intValue()] = CDependencyLabel.ROOT;
		m_nLastAction = Action.encodeAction(Action.POP_ROOT);
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
	
	public boolean StandardMoveStep(final LabeledDependencyParser tree, final ArrayList<CDependencyLabel> m_lCacheLabel) {
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
	
	public int FollowMove(final CLabeledStateItem item) {
		int top;
		if (m_nNextWord == item.m_nNextWord) {
			top = m_Stack.get(stack_back).intValue();
			if (item.m_lHeads[top] == m_nNextWord) {
				return Action.encodeAction(Action.ARC_LEFT, item.m_lLabels[top]);
			} else if (item.m_lHeads[top] != LabeledDependencyTreeNode.DEPENDENCY_LINK_NO_HEAD) {
				return Action.encodeAction(Action.REDUCE);
			} else {
				return Action.encodeAction(Action.POP_ROOT);
			}
		}
		if (stack_back >= 0) {
			top = m_Stack.get(stack_back).intValue();
			while (!(m_lHeads[top] == LabeledDependencyTreeNode.DEPENDENCY_LINK_NO_HEAD)) {
				top = m_lHeads[top];
			}
			if (item.head(top) == m_nNextWord) {
				if (top == m_Stack.get(stack_back).intValue()) {
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
			top = m_Stack.get(stack_back).intValue();
			if (item.head(m_nNextWord) == top) {
				return Action.encodeAction(Action.ARC_RIGHT, item.m_lLabels[m_nNextWord]);
			} else {
				return Action.encodeAction(Action.REDUCE);
			}
		}
	}
	
	public void GenerateTree(final TwoStringVector input, LabeledDependencyParser output) {
		output.clear();
		for (int i = 0, input_size = this.size(); i < input_size; ++i) {
			output.add(new LabeledDependencyTreeNode(input.get(i).first(), input.get(i).second(), m_lHeads[i], CDependencyLabel.str(m_lLabels[i])));
		}
	}
	
	public void copy(final CLabeledStateItem item) {
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
