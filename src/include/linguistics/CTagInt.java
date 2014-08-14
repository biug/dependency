package include.linguistics;

import include.Tuple2;
import chinese.pos.CTag;

public class CTagInt extends Tuple2<CTag, Integer> {
	
	public CTagInt() {
		super();
	}
	
	public CTagInt(CTagInt tag_int) {
		super((Tuple2<CTag, Integer>)tag_int);
	}

	@Override
	public CTag create_object1(CTag a) {
		return new CTag(a);
	}

	@Override
	public Integer create_object2(Integer b) {
		return new Integer(b);
	}
	
}
