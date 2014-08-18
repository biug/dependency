package include.linguistics.chinese;

import include.Tuple3;
import include.linguistics.Word;
import chinese.pos.CTag;

public final class WordCTagCTag extends Tuple3<Word, CTag, CTag> {
	
	public WordCTagCTag() {
		super();
	}
	
	public WordCTagCTag(final WordCTagCTag word_tag_tag) {
		refer(word_tag_tag.m_object1, word_tag_tag.m_object2, word_tag_tag.m_object3);
	}
	
	public WordCTagCTag(final Word word, final CTag tag1, final CTag tag2) {
		super(word, tag1, tag2);
	}

	@Override
	public Word create_object1(final Word a) {
		return a;
	}

	@Override
	public CTag create_object2(final CTag b) {
		return b;
	}

	@Override
	public CTag create_object3(final CTag c) {
		return c;
	}

}
