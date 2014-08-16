package english.parser.implementations.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.Word;
import include.linguistics.english.WordETagETag;
import english.pos.ETag;

@SuppressWarnings("serial")
public final class WordETagETagMap extends PackedScoreMap<WordETagETag> {

	public WordETagETagMap(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public WordETagETag loadKeyFromString(final String str) {
		String[] args = str.split(" , ");
		return new WordETagETag(new Word(args[0].substring(1, args[0].length() - 1)), new ETag(args[1]), new ETag(args[2]));
	}

	@Override
	public String generateStringFromKey(final WordETagETag key) {
		return "[" + key.first().toString() + "] , " + key.second().toString() + " , " + key.third().toString();
	}

	@Override
	public WordETagETag allocate_key(final WordETagETag key) {
		return new WordETagETag(key);
	}


}
