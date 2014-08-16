package common.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.Word;
import include.linguistics.WordInt;

@SuppressWarnings("serial")
public class WordIntMap extends PackedScoreMap<WordInt> {

	public WordIntMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public WordInt loadKeyFromString(String str) {
		String[] args = str.split(" , ");
		return new WordInt(new Word(args[0].substring(1, args[0].length() - 1)), Integer.valueOf(args[1]));
	}

	@Override
	public String generateStringFromKey(WordInt key) {
		return "[" + key.first().toString() + "] , " + key.second().toString();
	}

	@Override
	public WordInt allocate_key(WordInt key) {
		return new WordInt(key);
	}

}
