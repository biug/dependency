package common.parser.implementations.arceager;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.CTaggedWord;
import include.linguistics.CTwoTaggedWords;

@SuppressWarnings("serial")
public class CTwoTaggedWordsMap extends PackedScoreMap<CTwoTaggedWords> {

	public CTwoTaggedWordsMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CTwoTaggedWords loadKeyFromString(String str) {
		String[] args = str.split(" , ");
		int middle0 = args[0].lastIndexOf("_");
		String arg00 = args[0].substring(0, middle0);
		String arg01 = args[0].substring(middle0 + 1);
		int middle1 = args[1].lastIndexOf("_");
		String arg10 = args[1].substring(0, middle1);
		String arg11 = args[1].substring(middle1 + 1);
		return new CTwoTaggedWords(new CTaggedWord(arg00, arg01), new CTaggedWord(arg10, arg11));
	}

	@Override
	public String generateStringFromKey(CTwoTaggedWords key) {
		return key.first().word.toString() + "_" + key.first().tag.toString() +
				" , " +
				key.second().word.toString() + "_" + key.second().tag.toString();
	}

	@Override
	public CTwoTaggedWords allocate_key(CTwoTaggedWords key) {
		return new CTwoTaggedWords(key);
	}

}
