package common.parser.implementations.arceager;

public class Macros {

	public final static int AGENDA_SIZE = 64;
	public final static int MAX_SENTENCE_SIZE = 256;
	public final static int MAX_SENTENCE_SIZE_BITS = 8;
	public final static int ARITY_DIRECTION_LEFT = 0;
	public final static int ARITY_DIRECTION_RIGHT = 1;
	
	public static int encodeLinkDistance(final int head_index, final int dep_index) {
		int diff;
		diff = head_index - dep_index;
		if (diff < 0) {
			diff = -diff;
		}
		if (diff > 10) {
			diff = 6;
		} else if (diff > 5) {
			diff = 5;
		}
		return diff;
	}
	
}
