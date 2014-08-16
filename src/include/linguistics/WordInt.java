package include.linguistics;

import include.Tuple2;

public final class WordInt extends Tuple2<Word, Integer> {
	
	public WordInt() {
		super();
	}
	
	public WordInt(final WordInt word_int) {
		super((Tuple2<Word, Integer>)word_int);
	}
	
	public WordInt(final Word word, final Integer i) {
		super(word, i);
	}

	@Override
	public Word create_object1(final Word a) {
		return a;
	}

	@Override
	public Integer create_object2(final Integer b) {
		return b;
	}

}
