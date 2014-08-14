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
		CWordInt cwi = new CWordInt();
		String[] args = str.split(sSplit);
		cwi.allocate(new CWord(args[0]), new Integer(args[1]));
		return cwi;
	}

	@Override
	public String generateStringFromKey(CWordInt key) {
		return "[" + key.first().toString() + "] , " + key.second().toString();
	}

}
