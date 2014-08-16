package include.linguistics.english;

import include.Tuple2;
import english.pos.ETag;

public final class ETagInt extends Tuple2<ETag, Integer> {
	public ETagInt() {
		super();
	}
	
	public ETagInt(final ETagInt tag_int) {
		super((Tuple2<ETag, Integer>)tag_int);
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
