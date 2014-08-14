package include.linguistics;

import include.Tuple3;
import chinese.pos.CTag;

public class CWordWordTag extends Tuple3<CWord, CWord, CTag> {
	
	public CWordWordTag() {
		super();
	}
	
	public CWordWordTag(CWordWordTag word_word_tag) {
		super((Tuple3<CWord, CWord, CTag>)word_word_tag);
	}

	@Override
	public CWord create_object1(CWord a) {
		return new CWord(a);
	}

	@Override
	public CWord create_object2(CWord b) {
		return new CWord(b);
	}

	@Override
	public CTag create_object3(CTag c) {
		return new CTag(c);
	}

}
