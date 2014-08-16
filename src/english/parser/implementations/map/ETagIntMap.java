package english.parser.implementations.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.english.ETagInt;
import english.pos.ETag;

@SuppressWarnings("serial")
public final class ETagIntMap extends PackedScoreMap<ETagInt> {
	public ETagIntMap(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public ETagInt loadKeyFromString(final String str) {
		String[] args = str.split(" , ");
		return new ETagInt(new ETag(args[0]), Integer.valueOf(args[1]));
	}

	@Override
	public String generateStringFromKey(final ETagInt key) {
		return key.first().toString() + " , " + key.second().toString();
	}

	@Override
	public ETagInt allocate_key(final ETagInt key) {
		return new ETagInt(key);
	}
}
