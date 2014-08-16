package chinese.parser.implementations.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.Word;
import include.linguistics.chinese.WordCTag;
import chinese.pos.CTag;

@SuppressWarnings("serial")
public final class WordCTagMap extends PackedScoreMap<WordCTag> {

	public WordCTagMap(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public WordCTag loadKeyFromString(final String str) {
		String[] args = str.split("_");
		return new WordCTag(new Word(args[0]), new CTag(args[1]));
	}

	@Override
	public String generateStringFromKey(final WordCTag key) {
		return key.first().toString() + "_" + key.second().toString();
	}

	@Override
	public WordCTag allocate_key(final WordCTag key) {
		return new WordCTag(key);
	}

	
}
