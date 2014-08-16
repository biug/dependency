package chinese.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.Word;
import include.linguistics.chinese.WordCTagCTag;
import chinese.pos.CTag;

@SuppressWarnings("serial")
public class WordCTagCTagMap extends PackedScoreMap<WordCTagCTag> {

	public WordCTagCTagMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public WordCTagCTag loadKeyFromString(String str) {
		String[] args = str.split(" , ");
		return new WordCTagCTag(new Word(args[0].substring(1, args[0].length() - 1)), new CTag(args[1]), new CTag(args[2]));
	}

	@Override
	public String generateStringFromKey(WordCTagCTag key) {
		return "[" + key.first().toString() + "] , " + key.second().toString() + " , " + key.third().toString();
	}

	@Override
	public WordCTagCTag allocate_key(WordCTagCTag key) {
		return new WordCTagCTag(key);
	}


}
