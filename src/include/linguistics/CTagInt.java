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
	
	public CTagInt(CTag tag, Integer i) {
		super(tag, i);
	}

	@Override
	public CTag create_object1(CTag a) {
		return a;
	}

	@Override
	public Integer create_object2(Integer b) {
		return b;
	}
	
}
