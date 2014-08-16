package chinese.parser.implementations.map;

import include.learning.perceptron.PackedScoreMap;
import chinese.pos.CTag;

@SuppressWarnings("serial")
public final class CTagMap extends PackedScoreMap<CTag> {

	public CTagMap(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CTag loadKeyFromString(final String str) {
		return new CTag(str);
	}

	@Override
	public String generateStringFromKey(final CTag key) {
		return key.toString();
	}

	@Override
	public CTag allocate_key(final CTag key) {
		return key;
	}

}
