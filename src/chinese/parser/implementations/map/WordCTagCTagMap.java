package chinese.parser.implementations.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.Word;
import include.linguistics.chinese.WordCTagCTag;
import chinese.pos.CTag;

@SuppressWarnings("serial")
public final class WordCTagCTagMap extends PackedScoreMap<WordCTagCTag> {

	public WordCTagCTagMap(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public WordCTagCTag loadKeyFromString(final String str) {
		String[] args = str.split(" , ");
		return new WordCTagCTag(new Word(args[0].substring(1, args[0].length() - 1)), new CTag(args[1]), new CTag(args[2]));
	}

	@Override
	public String generateStringFromKey(final WordCTagCTag key) {
		return "[" + key.first().toString() + "] , " + key.second().toString() + " , " + key.third().toString();
	}

	@Override
	public WordCTagCTag allocate_key(final WordCTagCTag key) {
		return new WordCTagCTag(key);
	}


}
