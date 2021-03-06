package common.parser.implementations.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.TwoWords;
import include.linguistics.Word;

@SuppressWarnings("serial")
public final class TwoWordsMap extends PackedScoreMap<TwoWords> {

	public TwoWordsMap(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public TwoWords loadKeyFromString(final String str) {
		String[] args = str.split(" , ");
		return new TwoWords(new Word(args[0].substring(1, args[0].length() - 1)), new Word(args[1].substring(1, args[1].length() - 1)));
	}

	@Override
	public String generateStringFromKey(final TwoWords key) {
		return "[" + key.first().toString() + "] , [" + key.second().toString() + "]";
	}

	@Override
	public TwoWords allocate_key(final TwoWords key) {
		return new TwoWords(key);
	}

}
