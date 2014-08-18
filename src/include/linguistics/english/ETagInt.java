package include.linguistics.english;

import include.Tuple2;
import english.pos.ETag;

public final class ETagInt extends Tuple2<ETag, Integer> {
	public ETagInt() {
		super();
	}
	
	public ETagInt(final ETagInt tag_int) {
		refer(tag_int.m_object1, tag_int.m_object2);
	}
	
	public ETagInt(final ETag tag, final Integer i) {
		super(tag, i);
	}

	@Override
	public ETag create_object1(final ETag a) {
		return a;
	}

	@Override
	public Integer create_object2(final Integer b) {
		return b;
	}
}
