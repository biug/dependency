package include.linguistics;

import include.Tuple2;

public class CWordSetOfLabels extends Tuple2<CWord, CSetOfTags> {
	
	public CWordSetOfLabels() {
		super();
	}
	
	public CWordSetOfLabels(final CWordSetOfLabels word_tagset) {
		super((Tuple2<CWord, CSetOfTags>)word_tagset);
	}
	
	public CWordSetOfLabels(CWord word, CSetOfTags tagset) {
		super(word, tagset);
	}

	@Override
	public CWord create_object1(CWord a) {
		return a;
	}

	@Override
	public CSetOfTags create_object2(CSetOfTags b) {
		return new CSetOfTags(b);
	}

}
