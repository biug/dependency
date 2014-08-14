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
		CWordWordTag cwwt = new CWordWordTag();
		String[] args = str.split(sSplit);
		cwwt.allocate(new CWord(args[0]), new CWord(args[1]), new CTag(args[2]));
		return cwwt;
	}

	@Override
	public String generateStringFromKey(CWordWordTag key) {
		return "[" + key.first().toString() + "] , [" + key.second().toString() + "] , " + key.third().toString();
	}

}
