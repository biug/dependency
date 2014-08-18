package include.linguistics;

import include.Tuple3;

public final class WordWordInt extends Tuple3<Word, Word, Integer> {
	
	public WordWordInt() {
		super();
	}
	
	public WordWordInt(WordWordInt word_word_int) {
		refer(word_word_int.m_object1, word_word_int.m_object2, word_word_int.m_object3);
	}
	
	public WordWordInt(final Word word1, final Word word2, final Integer i) {
		super(word1, word2, i);
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
	public Integer create_object3(final Integer c) {
		return c;
	}

}
