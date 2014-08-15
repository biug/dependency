package common.parser.implementations.arceager;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.CSetOfTags;
import include.linguistics.CTagSetOfLabels;
import chinese.dependency.label.CDependencyLabel;
import chinese.pos.CTag;

@SuppressWarnings("serial")
public class CTagSetOfLabelsMap extends PackedScoreMap<CTagSetOfLabels> {

	public CTagSetOfLabelsMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CTagSetOfLabels loadKeyFromString(String str) {
		String[] args = str.split(" , ");
		CSetOfTags tagset = new CSetOfTags();
		String[] subargs = args[1].substring(2, args[1].length() - 1).split(" ");
		if (!subargs[0].isEmpty()) {
			for (int i = 0; i < subargs.length; ++i) {
				tagset.add(CDependencyLabel.code(subargs[i]));
			}
		}
		return new CTagSetOfLabels(new CTag(args[0]), tagset);
	}

	@Override
	public String generateStringFromKey(CTagSetOfLabels key) {
		String retval = key.first().toString() + " , [ ";
		CSetOfTags sot = key.second();
		for (int label = 0; label < CDependencyLabel.COUNT; ++label) {
			if (sot.contains(label)) {
				retval += (CDependencyLabel.str(label) + " ");
			}
		}
		return retval + "]";
	}

	@Override
	public CTagSetOfLabels allocate_key(CTagSetOfLabels key) {
		return new CTagSetOfLabels(key);
	}

}
