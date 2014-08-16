package include.linguistics.chinese;

import include.Bigram;

public class TwoCTaggedWords extends Bigram<CTaggedWord> {
	
	public TwoCTaggedWords() {
		super();
	}
	
	public TwoCTaggedWords(TwoCTaggedWords twotaggedwords) {
		super((Bigram<CTaggedWord>)twotaggedwords);
	}
	
	public TwoCTaggedWords(CTaggedWord w1, CTaggedWord w2) {
		super(w1, w2);
	}

	@Override
	protected CTaggedWord create_unigram(CTaggedWord u) {
		return new CTaggedWord(u);
	}

}
