package chinese.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.chinese.CTagSet2;

@SuppressWarnings("serial")
public class CTagSet2Map extends PackedScoreMap<CTagSet2> {

	public CTagSet2Map(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CTagSet2 loadKeyFromString(String str) {
		CTagSet2 ts = new CTagSet2();
		ts.load(str);
		return ts;
	}

	@Override
	public String generateStringFromKey(CTagSet2 key) {
		return "[ " + key.toString() + " ]";
	}

	@Override
	public CTagSet2 allocate_key(CTagSet2 key) {
		return new CTagSet2(key);
	}
}
