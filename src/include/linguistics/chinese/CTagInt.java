package include.linguistics.chinese;

import include.Tuple2;
import chinese.pos.CTag;

public final class CTagInt extends Tuple2<CTag, Integer> {
	
	public CTagInt() {
		super();
	}
	
	public CTagInt(final CTagInt tag_int) {
		refer(tag_int.m_object1, tag_int.m_object2);
	}
	
	public CTagInt(final CTag tag, final Integer i) {
		super(tag, i);
	}

	@Override
	public CTag create_object1(final CTag a) {
		return a;
	}

	@Override
	public Integer create_object2(final Integer b) {
		return b;
	}
	
}
