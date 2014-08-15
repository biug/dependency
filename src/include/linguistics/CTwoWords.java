package include.linguistics;

import include.Bigram;

public class CTwoWords extends Bigram<CWord> {
	
	public CTwoWords() {
		super();
	}
	
	public CTwoWords(final CTwoWords twowords) {
		super((Bigram<CWord>)twowords);
	}
	
	public CTwoWords(CWord w1, CWord w2) {
		super(w1, w2);
	}

	@Override
	protected CWord create_unigram(CWord u) {
		return u;
	}

}
