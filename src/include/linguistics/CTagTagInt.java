package include.linguistics;

import include.Tuple3;
import chinese.pos.CTag;

public class CTagTagInt extends Tuple3<CTag, CTag, Integer> {
	
	public CTagTagInt() {
		super();
	}
	
	public CTagTagInt(final CTagTagInt tag_tag_int) {
		super((Tuple3<CTag, CTag, Integer>)tag_tag_int);
	}
	
	public CTagTagInt(CTag tag1, CTag tag2, Integer i) {
		super(tag1, tag2, i);
	}

	@Override
	public CTag create_object1(CTag a) {
		return a;
	}

	@Override
	public CTag create_object2(CTag b) {
		return b;
	}

	@Override
	public Integer create_object3(Integer c) {
		return c;
	}

}
