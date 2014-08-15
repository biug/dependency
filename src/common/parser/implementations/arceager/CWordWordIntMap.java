package common.parser.implementations.arceager;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.CWord;
import include.linguistics.CWordWordInt;

@SuppressWarnings("serial")
public class CWordWordIntMap extends PackedScoreMap<CWordWordInt> {

	public CWordWordIntMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CWordWordInt loadKeyFromString(String str) {
		String[] args = str.split(" , ");
		return new CWordWordInt(new CWord(args[0].substring(1, args[0].length() - 1)), new CWord(args[1].substring(1, args[1].length() - 1)), Integer.valueOf(args[2]));
	}

	@Override
	public String generateStringFromKey(CWordWordInt key) {
		return "[" + key.first().toString() + "] , [" + key.second().toString() + "] , " + key.third().toString();
	}

	@Override
	public CWordWordInt allocate_key(CWordWordInt key) {
		return new CWordWordInt(key);
	}

}
