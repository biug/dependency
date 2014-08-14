package common.parser.implementations.arceager;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.TagSet2;

@SuppressWarnings("serial")
public class TagSet2Map extends PackedScoreMap<TagSet2> {

	public TagSet2Map(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public TagSet2 loadKeyFromString(String str) {
		TagSet2 ts = new TagSet2();
		ts.load(str);
		return ts;
	}

	@Override
	public String generateStringFromKey(TagSet2 key) {
		return "[ " + key.toString() + " ]";
	}
}
