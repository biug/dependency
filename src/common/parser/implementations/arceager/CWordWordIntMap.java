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
		CWordWordInt cwwi = new CWordWordInt();
		String[] args = str.split(sSplit);
		cwwi.allocate(new CWord(args[0]), new CWord(args[1]), new Integer(args[2]));
		return cwwi;
	}

	@Override
	public String generateStringFromKey(CWordWordInt key) {
		return "[" + key.first().toString() + "] , [" + key.second().toString() + "] , " + key.third().toString();
	}

}
