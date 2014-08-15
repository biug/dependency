package include.linguistics;

import include.Tuple2;

public class CWordInt extends Tuple2<CWord, Integer> {
	
	public CWordInt() {
		super();
	}
	
	public CWordInt(CWordInt word_int) {
		super((Tuple2<CWord, Integer>)word_int);
	}
	
	public CWordInt(CWord word, Integer i) {
		super(word, i);
	}

	@Override
	public CWord create_object1(CWord a) {
		return a;
	}

	@Override
	public Integer create_object2(Integer b) {
		return b;
	}

}
