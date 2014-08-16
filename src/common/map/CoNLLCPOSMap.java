package common.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.CoNLLCPOS;

@SuppressWarnings("serial")
public class CoNLLCPOSMap extends PackedScoreMap<CoNLLCPOS> {

	public CoNLLCPOSMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CoNLLCPOS loadKeyFromString(String str) {
		CoNLLCPOS ccpos = new CoNLLCPOS();
		ccpos.load(str);
		return ccpos;
	}

	@Override
	public String generateStringFromKey(CoNLLCPOS key) {
		return key.toString();
	}

	@Override
	public CoNLLCPOS allocate_key(CoNLLCPOS key) {
		return new CoNLLCPOS(key);
	}

}
