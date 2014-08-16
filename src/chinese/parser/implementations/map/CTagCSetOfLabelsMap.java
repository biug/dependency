package chinese.parser.implementations.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.chinese.CSetOfLabels;
import include.linguistics.chinese.CTagCSetOfLabels;
import chinese.dependency.label.CDependencyLabel;
import chinese.pos.CTag;

@SuppressWarnings("serial")
public final class CTagCSetOfLabelsMap extends PackedScoreMap<CTagCSetOfLabels> {

	public CTagCSetOfLabelsMap(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CTagCSetOfLabels loadKeyFromString(final String str) {
		String[] args = str.split(" , ");
		CSetOfLabels tagset = new CSetOfLabels();
		String[] subargs = args[1].substring(2, args[1].length() - 1).split(" ");
		if (!subargs[0].isEmpty()) {
			for (int i = 0; i < subargs.length; ++i) {
				tagset.add(CDependencyLabel.code(subargs[i]));
			}
		}
		return new CTagCSetOfLabels(new CTag(args[0]), tagset);
	}

	@Override
	public String generateStringFromKey(final CTagCSetOfLabels key) {
		String retval = key.first().toString() + " , [ ";
		CSetOfLabels sot = key.second();
		for (int label = 0; label < CDependencyLabel.COUNT; ++label) {
			if (sot.contains(label)) {
				retval += (CDependencyLabel.str(label) + " ");
			}
		}
		return retval + "]";
	}

	@Override
	public CTagCSetOfLabels allocate_key(final CTagCSetOfLabels key) {
		return new CTagCSetOfLabels(key);
	}

}
