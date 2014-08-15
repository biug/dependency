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
		String[] args = str.split(" , ");
		return new CTwoWords(new CWord(args[0].substring(1, args[0].length() - 1)), new CWord(args[1].substring(1, args[1].length() - 1)));
	}

	@Override
	public String generateStringFromKey(CTwoWords key) {
		return "[" + key.first().toString() + "] , [" + key.second().toString() + "]";
	}

	@Override
	public CTwoWords allocate_key(CTwoWords key) {
		return new CTwoWords(key);
	}

}
