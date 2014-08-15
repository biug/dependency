package common.parser.implementations.arceager;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.TagSet3;

@SuppressWarnings("serial")
public class TagSet3Map extends PackedScoreMap<TagSet3> {

	public TagSet3Map(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public TagSet3 loadKeyFromString(String str) {
		TagSet3 ts = new TagSet3();
		ts.load(str);
		return ts;
	}

	@Override
	public String generateStringFromKey(TagSet3 key) {
		return "[ " + key.toString() + " ]";
	}

	@Override
	public TagSet3 allocate_key(TagSet3 key) {
		return new TagSet3(key);
	}
}
