package chinese.parser.implementations.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.Word;
import include.linguistics.chinese.WordWordCTag;
import chinese.pos.CTag;

@SuppressWarnings("serial")
public final class WordWordCTagMap extends PackedScoreMap<WordWordCTag> {

	public WordWordCTagMap(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public WordWordCTag loadKeyFromString(final String str) {
		String[] args = str.split(" , ");
		return new WordWordCTag(new Word(args[0].substring(1, args[0].length() - 1)), new Word(args[1].substring(1, args[1].length() - 1)), new CTag(args[2]));
	}

	@Override
	public String generateStringFromKey(final WordWordCTag key) {
		return "[" + key.first().toString() + "] , [" + key.second().toString() + "] , " + key.third().toString();
	}

	@Override
	public WordWordCTag allocate_key(final WordWordCTag key) {
		return new WordWordCTag(key);
	}

}
