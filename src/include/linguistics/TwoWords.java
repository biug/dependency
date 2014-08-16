package include.linguistics;

import include.Bigram;

public class TwoWords extends Bigram<Word> {
	
	public TwoWords() {
		super();
	}
	
	public TwoWords(final TwoWords twowords) {
		super((Bigram<Word>)twowords);
	}
	
	public TwoWords(Word w1, Word w2) {
		super(w1, w2);
	}

	@Override
	protected Word create_unigram(Word u) {
		return u;
	}

}
