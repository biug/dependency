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
		CWordTagTag cwtt = new CWordTagTag();
		String[] args = str.split(sSplit);
		cwtt.allocate(new CWord(args[0]), new CTag(args[1]), new CTag(args[2]));
		return cwtt;
	}

	@Override
	public String generateStringFromKey(CWordTagTag key) {
		return "[" + key.first().toString() + "] , " + key.second().toString() + " , " + key.third().toString();
	}


}
