package common.parser.implementations.arceager;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.TagSet4;

@SuppressWarnings("serial")
public class TagSet4Map extends PackedScoreMap<TagSet4> {

	public TagSet4Map(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public TagSet4 loadKeyFromString(String str) {
		TagSet4 ts = new TagSet4();
		ts.load(str);
		return ts;
	}

	@Override
	public String generateStringFromKey(TagSet4 key) {
		return "[ " + key.toString() + " ]";
	}
}
