package common.parser.implementations.arceager;

public final class LabeledAction {
	public final static int NO_ACTION = 0;
	public final static int SHIFT = 1;
	public final static int REDUCE = 2;
	public final static int ARC_LEFT = 3;
	public final static int ARC_RIGHT = 4;
	public final static int POP_ROOT = 5;
	public final static int LABEL_AL_FIRST = 6;
	public final static int LABEL_AR_FIRST = LABEL_AL_FIRST + Macros.DEP_LABEL_COUNT - 1;
	public final static int MAX = LABEL_AR_FIRST + Macros.DEP_LABEL_COUNT - 1;
	
	public static int encodeAction(final int action, final int label) {
		if (action == ARC_LEFT) {
			return label == 0 ? ARC_LEFT : LABEL_AL_FIRST + label - 1;
		} else if (action == ARC_RIGHT) {
			return label == 0 ? ARC_RIGHT : LABEL_AR_FIRST + label - 1;
		} else {
			return action;
		}
	}
	
	public static int encodeAction(final int action) {
		return action;
	}
	
	public static int getUnlabeledAction(final int action) {
		if (action < LABEL_AL_FIRST) {
			return action;
		} else if (action < LABEL_AR_FIRST) {
			return ARC_LEFT;
		} else {
			return ARC_RIGHT;
		}
	}
	
	public static int getLabel(final int action) {
		if (action < LABEL_AL_FIRST) {
			return 0;
		} else if (action < LABEL_AR_FIRST) {
			return action - LABEL_AL_FIRST + 1;
		} else {
			return action - LABEL_AR_FIRST + 1;
		}
	}
}
