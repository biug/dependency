package common.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.TwoWords;
import include.linguistics.Word;

@SuppressWarnings("serial")
public class TwoWordsMap extends PackedScoreMap<TwoWords> {

	public TwoWordsMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public TwoWords loadKeyFromString(String str) {
		String[] args = str.split(" , ");
		return new TwoWords(new Word(args[0].substring(1, args[0].length() - 1)), new Word(args[1].substring(1, args[1].length() - 1)));
	}

	@Override
	public String generateStringFromKey(TwoWords key) {
		return "[" + key.first().toString() + "] , [" + key.second().toString() + "]";
	}

	@Override
	public TwoWords allocate_key(TwoWords key) {
		return new TwoWords(key);
	}

}
