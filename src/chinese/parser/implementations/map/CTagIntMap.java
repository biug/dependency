package chinese.parser.implementations.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.chinese.CTagInt;
import chinese.pos.CTag;

@SuppressWarnings("serial")
public final class CTagIntMap extends PackedScoreMap<CTagInt> {

	public CTagIntMap(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CTagInt loadKeyFromString(final String str) {
		String[] args = str.split(" , ");
		return new CTagInt(new CTag(args[0]), Integer.valueOf(args[1]));
	}

	@Override
	public String generateStringFromKey(final CTagInt key) {
		return key.first().toString() + " , " + key.second().toString();
	}

	@Override
	public CTagInt allocate_key(final CTagInt key) {
		return new CTagInt(key);
	}

}
