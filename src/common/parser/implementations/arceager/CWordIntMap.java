package common.parser.implementations.arceager;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.CWord;
import include.linguistics.CWordInt;

@SuppressWarnings("serial")
public class CWordIntMap extends PackedScoreMap<CWordInt> {

	public CWordIntMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CWordInt loadKeyFromString(String str) {
		String[] args = str.split(" , ");
		return new CWordInt(new CWord(args[0].substring(1, args[0].length() - 1)), Integer.valueOf(args[1]));
	}

	@Override
	public String generateStringFromKey(CWordInt key) {
		return "[" + key.first().toString() + "] , " + key.second().toString();
	}

	@Override
	public CWordInt allocate_key(CWordInt key) {
		return new CWordInt(key);
	}

}
