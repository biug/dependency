package include.learning.perceptron;

public class PackedScoreType {
	private int packed_size;
	
	protected int scores[];
	
	public PackedScoreType(int size) {
		packed_size = size;
		scores = new int[size];
	}
	
	public void reset() {
		for (int index = 0; index < packed_size; ++index) {
			scores[index] = 0;
		}
	}
	
	public boolean empty() {
		for (int index = 0; index < packed_size; ++index) {
			if (scores[index] != 0) {
				return false;
			}
		}
		return true;
	}
	
	public int at(final int index) {
		return scores[index];
	}
	
	public void set(final int index, final int score) {
		scores[index] = score;
	}
	
	public void addOne(final int index, final int score) {
		scores[index] += score;
	}
	
	public void add(final PackedScoreType i) {
		for (int index = 0; index < packed_size; ++index) {
			scores[index] += i.scores[index];
		}
	}
}
