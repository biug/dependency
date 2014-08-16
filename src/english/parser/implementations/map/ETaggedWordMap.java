package english.parser.implementations.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.english.ETaggedWord;

@SuppressWarnings("serial")
public final class ETaggedWordMap extends PackedScoreMap<ETaggedWord> {
	public ETaggedWordMap(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public ETaggedWord loadKeyFromString(final String str) {
		int middle = str.lastIndexOf("_");
		return new ETaggedWord(str.substring(0, middle), str.substring(middle+1));
	}

	@Override
	public String generateStringFromKey(final ETaggedWord key) {
		return key.word.toString() + "_" + key.tag.toString();
	}

	@Override
	public ETaggedWord allocate_key(final ETaggedWord key) {
		return new ETaggedWord(key);
	}
}
