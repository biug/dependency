package english.parser.implementations.arceager;


public class ELabeledAction {
	public final static int NO_ACTION = 0;
	public final static int SHIFT = 1;
	public final static int REDUCE = 2;
	public final static int ARC_LEFT = 3;
	public final static int ARC_RIGHT = 4;
	public final static int POP_ROOT = 5;
	public final static int MAX = POP_ROOT + 1;	
	
	public static int encodeAction(final int action) {
		return action;
	}
}
