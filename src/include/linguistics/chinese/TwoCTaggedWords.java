package include.linguistics.chinese;

import include.Bigram;

public final class TwoCTaggedWords extends Bigram<CTaggedWord> {
	
	public TwoCTaggedWords() {
		super();
	}
	
	public TwoCTaggedWords(final TwoCTaggedWords twotaggedwords) {
		super((Bigram<CTaggedWord>)twotaggedwords);
	}
	
	public TwoCTaggedWords(final CTaggedWord w1, final CTaggedWord w2) {
		super(w1, w2);
	}

	@Override
	protected CTaggedWord create_unigram(final CTaggedWord u) {
		return new CTaggedWord(u);
	}

}
