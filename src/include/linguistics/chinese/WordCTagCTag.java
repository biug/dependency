package include.linguistics.chinese;

import include.Tuple3;
import include.linguistics.Word;
import chinese.pos.CTag;

public class WordCTagCTag extends Tuple3<Word, CTag, CTag> {
	
	public WordCTagCTag() {
		super();
	}
	
	public WordCTagCTag(final WordCTagCTag word_tag_tag) {
		super((Tuple3<Word, CTag, CTag>)word_tag_tag);
	}
	
	public WordCTagCTag(Word word, CTag tag1, CTag tag2) {
		super(word, tag1, tag2);
	}

	@Override
	public Word create_object1(Word a) {
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
