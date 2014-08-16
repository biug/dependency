package english.parser.implementations.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.english.ETagETagInt;
import english.pos.ETag;

@SuppressWarnings("serial")
public final class ETagETagIntMap extends PackedScoreMap<ETagETagInt> {
	public ETagETagIntMap(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public ETagETagInt loadKeyFromString(final String str) {
		String[] args = str.split(" , ");
		return new ETagETagInt(new ETag(args[0]), new ETag(args[1]), Integer.valueOf(args[2]));
	}

	@Override
	public String generateStringFromKey(final ETagETagInt key) {
		return key.first().toString() + " , " + key.second().toString() + " , " + key.third().toString();
	}

	@Override
	public ETagETagInt allocate_key(final ETagETagInt key) {
		return new ETagETagInt(key);
	}
}
