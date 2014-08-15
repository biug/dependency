package common.parser.implementations.arceager;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.CWord;
import include.linguistics.CWordWordTag;
import chinese.pos.CTag;

@SuppressWarnings("serial")
public class CWordWordTagMap extends PackedScoreMap<CWordWordTag> {

	public CWordWordTagMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CWordWordTag loadKeyFromString(String str) {
		String[] args = str.split(" , ");
		return new CWordWordTag(new CWord(args[0].substring(1, args[0].length() - 1)), new CWord(args[1].substring(1, args[1].length() - 1)), new CTag(args[2]));
	}

	@Override
	public String generateStringFromKey(CWordWordTag key) {
		return "[" + key.first().toString() + "] , [" + key.second().toString() + "] , " + key.third().toString();
	}

	@Override
	public CWordWordTag allocate_key(CWordWordTag key) {
		return new CWordWordTag(key);
	}

}
