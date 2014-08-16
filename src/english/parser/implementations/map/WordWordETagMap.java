package english.parser.implementations.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.Word;
import include.linguistics.english.WordWordETag;
import english.pos.ETag;

@SuppressWarnings("serial")
public final class WordWordETagMap extends PackedScoreMap<WordWordETag> {

	public WordWordETagMap(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public WordWordETag loadKeyFromString(final String str) {
		String[] args = str.split(" , ");
		return new WordWordETag(new Word(args[0].substring(1, args[0].length() - 1)), new Word(args[1].substring(1, args[1].length() - 1)), new ETag(args[2]));
	}

	@Override
	public String generateStringFromKey(final WordWordETag key) {
		return "[" + key.first().toString() + "] , [" + key.second().toString() + "] , " + key.third().toString();
	}

	@Override
	public WordWordETag allocate_key(final WordWordETag key) {
		return new WordWordETag(key);
	}

}
