package common.parser.implementations.arceager;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.CTagInt;
import chinese.pos.CTag;

@SuppressWarnings("serial")
public class CTagIntMap extends PackedScoreMap<CTagInt> {

	public CTagIntMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CTagInt loadKeyFromString(String str) {
		String[] args = str.split(" , ");
		return new CTagInt(new CTag(args[0]), Integer.valueOf(args[1]));
	}

	@Override
	public String generateStringFromKey(CTagInt key) {
		return key.first().toString() + " , " + key.second().toString();
	}

	@Override
	public CTagInt allocate_key(CTagInt key) {
		return new CTagInt(key);
	}

}
