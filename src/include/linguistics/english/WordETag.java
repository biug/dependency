package include.linguistics.english;

import include.Tuple2;
import include.linguistics.Word;
import english.pos.ETag;

public final class WordETag extends Tuple2<Word, ETag> {
	public WordETag() {
		super();
	}
	
	public WordETag(final WordETag word_tag) {
		super(word_tag.m_object1, word_tag.m_object2);
	}
	
	public WordETag(final Word word, final ETag tag) {
		super(word, tag);
	}

	@Override
	public Word create_object1(final Word a) {
		return a;
	}

	@Override
	public ETag create_object2(final ETag b) {
		return b;
	}
}
