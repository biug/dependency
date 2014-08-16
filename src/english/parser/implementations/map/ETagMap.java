package english.parser.implementations.map;

import include.learning.perceptron.PackedScoreMap;
import english.pos.ETag;

@SuppressWarnings("serial")
public final class ETagMap extends PackedScoreMap<ETag> {

	public ETagMap(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public ETag loadKeyFromString(final String str) {
		return new ETag(str);
	}

	@Override
	public String generateStringFromKey(final ETag key) {
		return key.toString();
	}

	@Override
	public ETag allocate_key(final ETag key) {
		return key;
	}

}
