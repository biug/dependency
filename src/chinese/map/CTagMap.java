package chinese.map;

import include.learning.perceptron.PackedScoreMap;
import chinese.pos.CTag;

@SuppressWarnings("serial")
public class CTagMap extends PackedScoreMap<CTag> {

	public CTagMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CTag loadKeyFromString(String str) {
		return new CTag(str);
	}

	@Override
	public String generateStringFromKey(CTag key) {
		return key.toString();
	}

	@Override
	public CTag allocate_key(CTag key) {
		return key;
	}

}
