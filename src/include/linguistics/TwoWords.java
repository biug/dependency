package include.linguistics;

import include.Bigram;

public final class TwoWords extends Bigram<Word> {
	
	public TwoWords() {
		super();
	}
	
	public TwoWords(final TwoWords twowords) {
		super((Bigram<Word>)twowords);
	}
	
	public TwoWords(final Word w1, final Word w2) {
		super(w1, w2);
	}

	@Override
	protected Word create_unigram(final Word u) {
		return u;
	}

}
