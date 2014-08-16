package chinese.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.Word;
import include.linguistics.chinese.WordCTag;
import chinese.pos.CTag;

@SuppressWarnings("serial")
public class WordCTagMap extends PackedScoreMap<WordCTag> {

	public WordCTagMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public WordCTag loadKeyFromString(String str) {
		String[] args = str.split("_");
		return new WordCTag(new Word(args[0]), new CTag(args[1]));
	}

	@Override
	public String generateStringFromKey(WordCTag key) {
		return key.first().toString() + "_" + key.second().toString();
	}

	@Override
	public WordCTag allocate_key(WordCTag key) {
		return new WordCTag(key);
	}

	
}
