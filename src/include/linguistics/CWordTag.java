package include.linguistics;

import include.Tuple2;
import chinese.pos.CTag;

public class CWordTag extends Tuple2<CWord, CTag> {
	
	public CWordTag() {
		super();
	}
	
	public CWordTag(final CWordTag word_tag) {
		super((Tuple2<CWord, CTag>)word_tag);
	}
	
	public CWordTag(CWord word, CTag tag) {
		super(word, tag);
	}

	@Override
	public CWord create_object1(CWord a) {
		return a;
	}

	@Override
	public CTag create_object2(CTag b) {
		return b;
	}
	
}
