package common.parser.implementations.arceager;

import include.learning.perceptron.PackedScoreMap;

@SuppressWarnings("serial")
public class IntMap extends PackedScoreMap<Integer> {

	public IntMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public Integer loadKeyFromString(String str) {
		return new Integer(str);
	}

	@Override
	public String generateStringFromKey(Integer key) {
		return key.toString();
	}

}
