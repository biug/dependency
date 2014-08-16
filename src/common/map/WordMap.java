package common.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.Word;

@SuppressWarnings("serial")
public class WordMap extends PackedScoreMap<Word> {

	public WordMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public Word loadKeyFromString(String str) {
		return new Word(str.substring(1, str.length() - 1));
	}

	@Override
	public String generateStringFromKey(Word key) {
		return "[" + key.toString() + "]";
	}

	@Override
	public Word allocate_key(Word key) {
		return key;
	}
	
}
