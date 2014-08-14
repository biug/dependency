package common.parser.implementations.arceager;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.CTwoWords;
import include.linguistics.CWord;

@SuppressWarnings("serial")
public class CTwoWordsMap extends PackedScoreMap<CTwoWords> {

	public CTwoWordsMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CTwoWords loadKeyFromString(String str) {
		CTwoWords ctw = new CTwoWords();
		String[] args = str.split(sSplit);
		ctw.allocate(new CWord(args[0]), new CWord(args[1]));
		return ctw;
	}

	@Override
	public String generateStringFromKey(CTwoWords key) {
		return "[" + key.first().toString() + "] , [" + key.second().toString() + "]";
	}

}
