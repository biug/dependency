package chinese.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.chinese.CTaggedWord;

@SuppressWarnings("serial")
public final class CTaggedWordMap extends PackedScoreMap<CTaggedWord> {

	public CTaggedWordMap(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CTaggedWord loadKeyFromString(final String str) {
		int middle = str.lastIndexOf("_");
		return new CTaggedWord(str.substring(0, middle), str.substring(middle+1));
	}

	@Override
	public String generateStringFromKey(final CTaggedWord key) {
		return key.word.toString() + "_" + key.tag.toString();
	}

	@Override
	public CTaggedWord allocate_key(final CTaggedWord key) {
		return new CTaggedWord(key);
	}

}
