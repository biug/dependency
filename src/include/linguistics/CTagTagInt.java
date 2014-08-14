package include.linguistics;

import include.Tuple3;
import chinese.pos.CTag;

public class CTagTagInt extends Tuple3<CTag, CTag, Integer> {
	
	public CTagTagInt() {
		super();
	}
	
	public CTagTagInt(CTagTagInt tag_tag_int) {
		super((Tuple3<CTag, CTag, Integer>)tag_tag_int);
	}

	@Override
	public CTag create_object1(CTag a) {
		return new CTag(a);
	}

	@Override
	public CTag create_object2(CTag b) {
		return new CTag(b);
	}

	@Override
	public Integer create_object3(Integer c) {
		return new Integer(c);
	}

}
