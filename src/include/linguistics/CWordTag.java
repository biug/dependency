package include.linguistics;

import include.Tuple2;
import chinese.pos.CTag;

public class CWordTag extends Tuple2<CWord, CTag> {

	@Override
	public CWord create_object1(CWord a) {
		return new CWord(a);
	}

	@Override
	public CTag create_object2(CTag b) {
		return new CTag(b);
	}
	
}
