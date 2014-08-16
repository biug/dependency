package include.linguistics.english;

import include.Tuple3;
import include.linguistics.Word;
import english.pos.ETag;

public final class WordWordETag extends Tuple3<Word, Word, ETag> {
	
	public WordWordETag() {
		super();
	}
	
	public WordWordETag(final WordWordETag word_word_tag) {
		super((Tuple3<Word, Word, ETag>)word_word_tag);
	}
	
	public WordWordETag(final Word word1, final Word word2, final ETag tag) {
		super(word1, word2, tag);
	}

	@Override
	public Word create_object1(final Word a) {
		return a;
	}

	@Override
	public Word create_object2(final Word b) {
		return b;
	}

	@Override
	public ETag create_object3(final ETag c) {
		return c;
	}

}
