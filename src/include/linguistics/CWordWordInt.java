package include.linguistics;

import include.Tuple3;

public class CWordWordInt extends Tuple3<CWord, CWord, Integer> {
	
	public CWordWordInt() {
		super();
	}
	
	public CWordWordInt(CWordWordInt word_word_int) {
		super((Tuple3<CWord, CWord, Integer>)word_word_int);
	}

	@Override
	public CWord create_object1(CWord a) {
		return new CWord(a);
	}

	@Override
	public CWord create_object2(CWord b) {
		return new CWord(b);
	}

	@Override
	public Integer create_object3(Integer c) {
		return new Integer(c);
	}

}
