package include.linguistics;

import include.Tuple3;
import include.linguistics.CWord;
import chinese.pos.CTag;

public class CWordTagTag extends Tuple3<CWord, CTag, CTag> {
	
	public CWordTagTag() {
		super();
	}
	
	public CWordTagTag(CWordTagTag word_tag_tag) {
		super((Tuple3<CWord, CTag, CTag>)word_tag_tag);
	}

	@Override
	public CWord create_object1(CWord a) {
		return new CWord(a);
	}

	@Override
	public CTag create_object2(CTag b) {
		return new CTag(b);
	}

	@Override
	public CTag create_object3(CTag c) {
		return new CTag(c);
	}

}
