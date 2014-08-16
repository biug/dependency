package common.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.CoNLLFeats;

@SuppressWarnings("serial")
public class CoNLLFeatsMap extends PackedScoreMap<CoNLLFeats> {

	public CoNLLFeatsMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CoNLLFeats loadKeyFromString(String str) {
		CoNLLFeats cf = new CoNLLFeats();
		cf.load(str);
		return cf;
	}

	@Override
	public String generateStringFromKey(CoNLLFeats key) {
		return key.toString();
	}

	@Override
	public CoNLLFeats allocate_key(CoNLLFeats key) {
		return new CoNLLFeats(key);
	}

}
