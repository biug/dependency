package common.parser.implementations.arceager;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.CTagInt;
import chinese.pos.CTag;

@SuppressWarnings("serial")
public class CTagIntMap extends PackedScoreMap<CTagInt> {

	public CTagIntMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CTagInt loadKeyFromString(String str) {
		CTagInt cti = new CTagInt();
		String[] args = str.split(sSplit);
		cti.allocate(new CTag(args[0]), new Integer(args[1]));
		return cti;
	}

	@Override
	public String generateStringFromKey(CTagInt key) {
		return key.first().toString() + " , " + key.second().toString();
	}

}
