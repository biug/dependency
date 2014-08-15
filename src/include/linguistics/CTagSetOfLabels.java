package include.linguistics;

import include.Tuple2;
import chinese.pos.CTag;

public class CTagSetOfLabels extends Tuple2<CTag, CSetOfTags> {
	
	public CTagSetOfLabels() {
		super();
	}
	
	public CTagSetOfLabels(final CTagSetOfLabels tag_tagset) {
		super((Tuple2<CTag, CSetOfTags>)tag_tagset);
	}
	
	public CTagSetOfLabels(final CTag tag, final CSetOfTags tagset) {
		super(tag, tagset);
	}

	@Override
	public CTag create_object1(CTag a) {
		return a;
	}

	@Override
	public CSetOfTags create_object2(CSetOfTags b) {
		return new CSetOfTags(b);
	}
	
}
