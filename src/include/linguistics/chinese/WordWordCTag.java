package include.linguistics.chinese;

import include.Tuple3;
import include.linguistics.Word;
import chinese.pos.CTag;

public final class WordWordCTag extends Tuple3<Word, Word, CTag> {
	
	public WordWordCTag() {
		super();
	}
	
	public WordWordCTag(final WordWordCTag word_word_tag) {
		refer(word_word_tag.m_object1, word_word_tag.m_object2, word_word_tag.m_object3);
	}
	
	public WordWordCTag(final Word word1, final Word word2, final CTag tag) {
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
	public CTag create_object3(final CTag c) {
		return c;
	}

}
