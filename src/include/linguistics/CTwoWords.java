package include.linguistics;

import include.Bigram;

public class CTwoWords extends Bigram<CWord> {
	
	public CTwoWords() {
		super();
	}
	
	public CTwoWords(CTwoWords bi) {
		super((Bigram<CWord>)bi);
	}


	@Override
	protected CWord create_unigram(CWord u) {
		return new CWord(u);
	}

}
