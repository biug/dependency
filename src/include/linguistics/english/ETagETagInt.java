package include.linguistics.english;

import english.pos.ETag;
import include.Tuple3;
import include.linguistics.english.ETagETagInt;

public final class ETagETagInt extends Tuple3<ETag, ETag, Integer> {
	
	public ETagETagInt() {
		super();
	}
	
	public ETagETagInt(final ETagETagInt tag_tag_int) {
		refer(tag_tag_int.m_object1, tag_tag_int.m_object2, tag_tag_int.m_object3);
	}
	
	public ETagETagInt(final ETag tag1, final ETag tag2, final Integer i) {
		super(tag1, tag2, i);
	}

	@Override
	public ETag create_object1(final ETag a) {
		return a;
	}

	@Override
	public ETag create_object2(final ETag b) {
		return b;
	}

	@Override
	public Integer create_object3(final Integer c) {
		return c;
	}
}
