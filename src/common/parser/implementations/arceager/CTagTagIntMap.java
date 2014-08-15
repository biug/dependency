package common.parser.implementations.arceager;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.CTagTagInt;
import chinese.pos.CTag;

@SuppressWarnings("serial")
public class CTagTagIntMap extends PackedScoreMap<CTagTagInt> {

	public CTagTagIntMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CTagTagInt loadKeyFromString(String str) {
		String[] args = str.split(" , ");
		return new CTagTagInt(new CTag(args[0]), new CTag(args[1]), Integer.valueOf(args[2]));
	}

	@Override
	public String generateStringFromKey(CTagTagInt key) {
		return key.first().toString() + " , " + key.second().toString() + " , " + key.third().toString();
	}

	@Override
	public CTagTagInt allocate_key(CTagTagInt key) {
		return new CTagTagInt(key);
	}

}
