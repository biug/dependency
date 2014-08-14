package include.linguistics;

import include.Tuple2;

public class CWordInt extends Tuple2<CWord, Integer> {
	
	public CWordInt() {
		super();
	}
	
	public CWordInt(CWordInt word_int) {
		super((Tuple2<CWord, Integer>)word_int);
	}

	@Override
	public CWord create_object1(CWord a) {
		return new CWord(a);
	}

	@Override
	public Integer create_object2(Integer b) {
		return new Integer(b);
	}

}
