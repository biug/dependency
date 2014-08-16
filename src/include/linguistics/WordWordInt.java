package include.linguistics;

import include.Tuple3;

public class WordWordInt extends Tuple3<Word, Word, Integer> {
	
	public WordWordInt() {
		super();
	}
	
	public WordWordInt(WordWordInt word_word_int) {
		super((Tuple3<Word, Word, Integer>)word_word_int);
	}
	
	public WordWordInt(Word word1, Word word2, Integer i) {
		super(word1, word2, i);
	}

	@Override
	public Word create_object1(Word a) {
		return a;
	}

	@Override
	public Word create_object2(Word b) {
		return b;
	}

	@Override
	public Integer create_object3(Integer c) {
		return c;
	}

}
