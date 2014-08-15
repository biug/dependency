package common.parser.implementations.arceager;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.CWord;
import include.linguistics.CWordTagTag;
import chinese.pos.CTag;

@SuppressWarnings("serial")
public class CWordTagTagMap extends PackedScoreMap<CWordTagTag> {

	public CWordTagTagMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CWordTagTag loadKeyFromString(String str) {
		String[] args = str.split(" , ");
		return new CWordTagTag(new CWord(args[0].substring(1, args[0].length() - 1)), new CTag(args[1]), new CTag(args[2]));
	}

	@Override
	public String generateStringFromKey(CWordTagTag key) {
		return "[" + key.first().toString() + "] , " + key.second().toString() + " , " + key.third().toString();
	}

	@Override
	public CWordTagTag allocate_key(CWordTagTag key) {
		return new CWordTagTag(key);
	}


}
