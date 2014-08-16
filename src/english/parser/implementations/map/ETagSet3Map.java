package english.parser.implementations.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.english.ETagSet3;

@SuppressWarnings("serial")
public final class ETagSet3Map extends PackedScoreMap<ETagSet3> {
	public ETagSet3Map(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public ETagSet3 loadKeyFromString(final String str) {
		ETagSet3 ts = new ETagSet3();
		ts.load(str);
		return ts;
	}

	@Override
	public String generateStringFromKey(final ETagSet3 key) {
		return "[ " + key.toString() + " ]";
	}

	@Override
	public ETagSet3 allocate_key(final ETagSet3 key) {
		return new ETagSet3(key);
	}
}
