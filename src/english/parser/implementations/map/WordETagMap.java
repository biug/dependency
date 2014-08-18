package english.parser.implementations.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.Word;
import include.linguistics.english.WordETag;
import english.pos.ETag;

@SuppressWarnings("serial")
public final class WordETagMap extends PackedScoreMap<WordETag> {

	public WordETagMap(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public WordETag loadKeyFromString(final String str) {
		String[] args = str.split("/");
		return new WordETag(new Word(args[0]), new ETag(args[1]));
	}

	@Override
	public String generateStringFromKey(final WordETag key) {
		return key.first().toString() + "/" + key.second().toString();
	}

	@Override
	public WordETag allocate_key(final WordETag key) {
		return new WordETag(key);
	}

	
}
