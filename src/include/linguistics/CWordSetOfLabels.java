package include.linguistics;

import include.Tuple2;

public class CWordSetOfLabels extends Tuple2<CWord, CSetOfTags> {
	
	public CWordSetOfLabels() {
		super();
	}
	
	public CWordSetOfLabels(CWordSetOfLabels word_tagset) {
		super((Tuple2<CWord, CSetOfTags>)word_tagset);
	}

	@Override
	public CWord create_object1(CWord a) {
		return new CWord(a);
	}

	@Override
	public CSetOfTags create_object2(CSetOfTags b) {
		return new CSetOfTags(b);
	}

}
