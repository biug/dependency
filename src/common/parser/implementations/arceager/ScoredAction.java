package common.parser.implementations.arceager;

public class ScoredAction {
	public int action;
	public int score;
	
	public ScoredAction() {
		action = 0;
		score = 0;
	}
	
	public ScoredAction(final int a, final int s) {
		action = a;
		score = s;
	}
	
	public boolean more(final ScoredAction sa) {
		return score > sa.score;
	}
	
	public boolean less(final ScoredAction sa) {
		return score < sa.score;
	}
	
	@Override
	public boolean equals(Object o) {
		return score == ((ScoredAction)o).score;
	}
	
	@Override
	public int hashCode() {
		return score;
	}
}
