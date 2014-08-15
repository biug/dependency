package common.parser.implementations.arceager;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.CWord;
import include.linguistics.CWordTag;
import chinese.pos.CTag;

@SuppressWarnings("serial")
public class CWordTagMap extends PackedScoreMap<CWordTag> {

	public CWordTagMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CWordTag loadKeyFromString(String str) {
		String[] args = str.split("_");
		return new CWordTag(new CWord(args[0]), new CTag(args[1]));
	}

	@Override
	public String generateStringFromKey(CWordTag key) {
		return key.first().toString() + "_" + key.second().toString();
	}

	@Override
	public CWordTag allocate_key(CWordTag key) {
		return new CWordTag(key);
	}

	
}
