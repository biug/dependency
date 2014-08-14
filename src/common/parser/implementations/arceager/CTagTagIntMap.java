package common.parser.implementations.arceager;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.CTagTagInt;
import chinese.pos.CTag;

@SuppressWarnings("serial")
public class CTagTagIntMap extends PackedScoreMap<CTagTagInt> {

	public CTagTagIntMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CTagTagInt loadKeyFromString(String str) {
		CTagTagInt ctti = new CTagTagInt();
		String[] args = str.split(sSplit);
		ctti.allocate(new CTag(args[0]), new CTag(args[1]), new Integer(args[2]));
		return ctti;
	}

	@Override
	public String generateStringFromKey(CTagTagInt key) {
		return key.first().toString() + " , " + key.second().toString() + " , " + key.third().toString();
	}

}
