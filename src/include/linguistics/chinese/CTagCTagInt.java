package include.linguistics.chinese;

import include.Tuple3;
import chinese.pos.CTag;

public final class CTagCTagInt extends Tuple3<CTag, CTag, Integer> {
	
	public CTagCTagInt() {
		super();
	}
	
	public CTagCTagInt(final CTagCTagInt tag_tag_int) {
		super((Tuple3<CTag, CTag, Integer>)tag_tag_int);
	}
	
	public CTagCTagInt(final CTag tag1, final CTag tag2, final Integer i) {
		super(tag1, tag2, i);
	}

	@Override
	public CTag create_object1(final CTag a) {
		return a;
	}

	@Override
	public CTag create_object2(final CTag b) {
		return b;
	}

	@Override
	public Integer create_object3(final Integer c) {
		return c;
	}

}
