package include.linguistics;

import include.Bigram;

public class CTwoTaggedWords extends Bigram<CTaggedWord> {
	
	public CTwoTaggedWords() {
		super();
	}
	
	public CTwoTaggedWords(CTwoTaggedWords twotaggedwords) {
		super((Bigram<CTaggedWord>)twotaggedwords);
	}
	
	public CTwoTaggedWords(CTaggedWord w1, CTaggedWord w2) {
		super(w1, w2);
	}

	@Override
	protected CTaggedWord create_unigram(CTaggedWord u) {
		return new CTaggedWord(u);
	}

}
