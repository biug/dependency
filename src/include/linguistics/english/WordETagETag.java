package include.linguistics.english;

import include.Tuple3;
import include.linguistics.Word;
import english.pos.ETag;

public final class WordETagETag extends Tuple3<Word, ETag, ETag> {
	public WordETagETag() {
		super();
	}
	
	public WordETagETag(final WordETagETag word_tag_tag) {
		refer(word_tag_tag.m_object1, word_tag_tag.m_object2, word_tag_tag.m_object3);
	}
	
	public WordETagETag(final Word word, final ETag tag1, final ETag tag2) {
		super(word, tag1, tag2);
	}

	@Override
	public Word create_object1(final Word a) {
		return a;
	}

	@Override
	public ETag create_object2(final ETag b) {
		return b;
	}

	@Override
	public ETag create_object3(final ETag c) {
		return c;
	}
}
