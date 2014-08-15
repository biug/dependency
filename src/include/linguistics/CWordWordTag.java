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
	
	public CWordWordTag(CWord word1, CWord word2, CTag tag) {
		super(word1, word2, tag);
	}

	@Override
	public CWord create_object1(CWord a) {
		return a;
	}

	@Override
	public CWord create_object2(CWord b) {
		return b;
	}

	@Override
	public CTag create_object3(CTag c) {
		return c;
	}

}
