package english.parser.implementations.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.english.ETagSet2;

@SuppressWarnings("serial")
public final class ETagSet2Map extends PackedScoreMap<ETagSet2> {
	public ETagSet2Map(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public ETagSet2 loadKeyFromString(final String str) {
		ETagSet2 ts = new ETagSet2();
		ts.load(str);
		return ts;
	}

	@Override
	public String generateStringFromKey(final ETagSet2 key) {
		return "[ " + key.toString() + " ]";
	}

	@Override
	public ETagSet2 allocate_key(final ETagSet2 key) {
		return new ETagSet2(key);
	}
}
