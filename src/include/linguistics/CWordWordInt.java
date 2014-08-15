package include.linguistics;

import include.Tuple3;

public class CWordWordInt extends Tuple3<CWord, CWord, Integer> {
	
	public CWordWordInt() {
		super();
	}
	
	public CWordWordInt(CWordWordInt word_word_int) {
		super((Tuple3<CWord, CWord, Integer>)word_word_int);
	}
	
	public CWordWordInt(CWord word1, CWord word2, Integer i) {
		super(word1, word2, i);
	}

	@Override
	public CWord create_object1(CWord a) {
		return a;
	}

	@Override
	public CWord create_object2(CWord b) {
		return b;
	}

	@Override
	public Integer create_object3(Integer c) {
		return c;
	}

}
