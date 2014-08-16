package include.linguistics;

import include.Tuple2;

public class WordInt extends Tuple2<Word, Integer> {
	
	public WordInt() {
		super();
	}
	
	public WordInt(WordInt word_int) {
		super((Tuple2<Word, Integer>)word_int);
	}
	
	public WordInt(Word word, Integer i) {
		super(word, i);
	}

	@Override
	public Word create_object1(Word a) {
		return a;
	}

	@Override
	public Integer create_object2(Integer b) {
		return b;
	}

}
