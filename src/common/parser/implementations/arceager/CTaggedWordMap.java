package common.parser.implementations.arceager;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.CTaggedWord;

@SuppressWarnings("serial")
public class CTaggedWordMap extends PackedScoreMap<CTaggedWord> {

	public CTaggedWordMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CTaggedWord loadKeyFromString(String str) {
		int middle = str.lastIndexOf(CTaggedWord.sSeparator);
		return new CTaggedWord(str.substring(0, middle), str.substring(middle+1));
	}

	@Override
	public String generateStringFromKey(CTaggedWord key) {
		return key.word.toString() + CTaggedWord.sSeparator + key.tag.toString();
	}

}
