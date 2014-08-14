package include.linguistics;

import include.Bigram;

public class CTwoTaggedWords extends Bigram<CTaggedWord> {
	
	public CTwoTaggedWords() {
		super();
	}
	
	public CTwoTaggedWords(CTwoTaggedWords bi) {
		super((Bigram<CTaggedWord>)bi);
	}

	@Override
	protected CTaggedWord create_unigram(CTaggedWord u) {
		return new CTaggedWord(u);
	}

}
