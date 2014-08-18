package include.linguistics.chinese;

import include.Tuple2;
import include.linguistics.Word;
import chinese.pos.CTag;

public final class WordCTag extends Tuple2<Word, CTag> {
	
	public WordCTag() {
		super();
	}
	
	public WordCTag(final WordCTag word_tag) {
		refer(word_tag.m_object1, word_tag.m_object2);
	}
	
	public WordCTag(final Word word, final CTag tag) {
		super(word, tag);
	}

	@Override
	public Word create_object1(final Word a) {
		return a;
	}

	@Override
	public CTag create_object2(final CTag b) {
		return b;
	}
	
}
