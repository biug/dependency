package include.linguistics;

import include.Tuple3;
import include.linguistics.CWord;
import chinese.pos.CTag;

public class CWordTagTag extends Tuple3<CWord, CTag, CTag> {
	
	public CWordTagTag() {
		super();
	}
	
	public CWordTagTag(final CWordTagTag word_tag_tag) {
		super((Tuple3<CWord, CTag, CTag>)word_tag_tag);
	}
	
	public CWordTagTag(CWord word, CTag tag1, CTag tag2) {
		super(word, tag1, tag2);
	}

	@Override
	public CWord create_object1(CWord a) {
		return a;
	}

	@Override
	public CTag create_object2(CTag b) {
		return b;
	}

	@Override
	public CTag create_object3(CTag c) {
		return c;
	}

}
