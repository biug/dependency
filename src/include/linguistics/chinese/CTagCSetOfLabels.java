package include.linguistics.chinese;

import include.Tuple2;
import chinese.pos.CTag;

public final class CTagCSetOfLabels extends Tuple2<CTag, CSetOfLabels> {
	
	public CTagCSetOfLabels() {
		super();
	}
	
	public CTagCSetOfLabels(final CTagCSetOfLabels tag_tagset) {
		refer(tag_tagset.m_object1, tag_tagset.m_object2);
	}
	
	public CTagCSetOfLabels(final CTag tag, final CSetOfLabels tagset) {
		super(tag, tagset);
	}

	@Override
	public CTag create_object1(final CTag a) {
		return a;
	}

	@Override
	public CSetOfLabels create_object2(final CSetOfLabels b) {
		return b;
	}
	
}
