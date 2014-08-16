package chinese.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.chinese.CTagSet2;

@SuppressWarnings("serial")
public final class CTagSet2Map extends PackedScoreMap<CTagSet2> {

	public CTagSet2Map(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CTagSet2 loadKeyFromString(final String str) {
		CTagSet2 ts = new CTagSet2();
		ts.load(str);
		return ts;
	}

	@Override
	public String generateStringFromKey(final CTagSet2 key) {
		return "[ " + key.toString() + " ]";
	}

	@Override
	public CTagSet2 allocate_key(final CTagSet2 key) {
		return new CTagSet2(key);
	}
}
