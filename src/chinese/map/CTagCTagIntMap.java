package chinese.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.chinese.CTagCTagInt;
import chinese.pos.CTag;

@SuppressWarnings("serial")
public final class CTagCTagIntMap extends PackedScoreMap<CTagCTagInt> {

	public CTagCTagIntMap(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CTagCTagInt loadKeyFromString(final String str) {
		String[] args = str.split(" , ");
		return new CTagCTagInt(new CTag(args[0]), new CTag(args[1]), Integer.valueOf(args[2]));
	}

	@Override
	public String generateStringFromKey(final CTagCTagInt key) {
		return key.first().toString() + " , " + key.second().toString() + " , " + key.third().toString();
	}

	@Override
	public CTagCTagInt allocate_key(final CTagCTagInt key) {
		return new CTagCTagInt(key);
	}

}
