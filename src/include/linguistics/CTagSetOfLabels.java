package include.linguistics;

import include.Tuple2;
import chinese.pos.CTag;

public class CTagSetOfLabels extends Tuple2<CTag, CSetOfTags> {
	
	public CTagSetOfLabels() {
		super();
	}
	
	public CTagSetOfLabels(CTagSetOfLabels tag_tagset) {
		super((Tuple2<CTag, CSetOfTags>)tag_tagset);
	}

	@Override
	public CTag create_object1(CTag a) {
		return new CTag(a);
	}

	@Override
	public CSetOfTags create_object2(CSetOfTags b) {
		return new CSetOfTags(b);
	}
	
}
