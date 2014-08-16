package common.parser.implementations.arceager;

public final class ScoredAction {
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
	
	@Override
	public boolean equals(final Object o) {
		return score == ((ScoredAction)o).score;
	}
	
	@Override
	public int hashCode() {
		return score;
	}
	
	public void copy(final ScoredAction sa) {
		action = sa.action;
		score = sa.score;
	}
}
