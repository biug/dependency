package include.linguistics.english;

import include.Tuple2;
import include.linguistics.english.ESetOfLabels;
import english.pos.ETag;

public final class ETagESetOfLabels extends Tuple2<ETag, ESetOfLabels> {
	
	public ETagESetOfLabels() {
		super();
	}
	
	public ETagESetOfLabels(final ETagESetOfLabels tag_tagset) {
		super((Tuple2<ETag, ESetOfLabels>)tag_tagset);
	}
	
	public ETagESetOfLabels(final ETag tag, final ESetOfLabels tagset) {
		super(tag, tagset);
	}

	@Override
	public ETag create_object1(final ETag a) {
		return a;
	}

	@Override
	public ESetOfLabels create_object2(final ESetOfLabels b) {
		return new ESetOfLabels(b);
	}
	
}
