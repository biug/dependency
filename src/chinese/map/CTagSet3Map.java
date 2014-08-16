package chinese.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.chinese.CTagSet3;

@SuppressWarnings("serial")
public final class CTagSet3Map extends PackedScoreMap<CTagSet3> {

	public CTagSet3Map(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CTagSet3 loadKeyFromString(final String str) {
		CTagSet3 ts = new CTagSet3();
		ts.load(str);
		return ts;
	}

	@Override
	public String generateStringFromKey(final CTagSet3 key) {
		return "[ " + key.toString() + " ]";
	}

	@Override
	public CTagSet3 allocate_key(final CTagSet3 key) {
		return new CTagSet3(key);
	}
}
