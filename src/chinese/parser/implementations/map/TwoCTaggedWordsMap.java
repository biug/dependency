package chinese.parser.implementations.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.chinese.CTaggedWord;
import include.linguistics.chinese.TwoCTaggedWords;

@SuppressWarnings("serial")
public final class TwoCTaggedWordsMap extends PackedScoreMap<TwoCTaggedWords> {

	public TwoCTaggedWordsMap(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public TwoCTaggedWords loadKeyFromString(final String str) {
		String[] args = str.split(" , ");
		int middle0 = args[0].lastIndexOf("_");
		String arg00 = args[0].substring(0, middle0);
		String arg01 = args[0].substring(middle0 + 1);
		int middle1 = args[1].lastIndexOf("_");
		String arg10 = args[1].substring(0, middle1);
		String arg11 = args[1].substring(middle1 + 1);
		return new TwoCTaggedWords(new CTaggedWord(arg00, arg01), new CTaggedWord(arg10, arg11));
	}

	@Override
	public String generateStringFromKey(final TwoCTaggedWords key) {
		return key.first().word.toString() + "_" + key.first().tag.toString() +
				" , " +
				key.second().word.toString() + "_" + key.second().tag.toString();
	}

	@Override
	public TwoCTaggedWords allocate_key(final TwoCTaggedWords key) {
		return new TwoCTaggedWords(key);
	}

}
