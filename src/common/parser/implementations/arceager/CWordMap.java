package common.parser.implementations.arceager;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.CWord;

@SuppressWarnings("serial")
public class CWordMap extends PackedScoreMap<CWord> {

	public CWordMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CWord loadKeyFromString(String str) {
		return new CWord(str.substring(1, str.length() - 1));
	}

	@Override
	public String generateStringFromKey(CWord key) {
		return "[" + key.toString() + "]";
	}

	@Override
	public CWord allocate_key(CWord key) {
		return key;
	}
	
}
