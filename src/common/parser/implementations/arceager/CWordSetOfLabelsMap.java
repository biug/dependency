package common.parser.implementations.arceager;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.CSetOfTags;
import include.linguistics.CWord;
import include.linguistics.CWordSetOfLabels;
import chinese.dependency.label.CDependencyLabel;

@SuppressWarnings("serial")
public class CWordSetOfLabelsMap extends PackedScoreMap<CWordSetOfLabels> {

	public CWordSetOfLabelsMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CWordSetOfLabels loadKeyFromString(String str) {
		String[] args = str.split(" , ");
		CSetOfTags tagset = new CSetOfTags();
		String[] subargs = args[1].substring(2, args[1].length() - 1).split(" ");
		if (!subargs[0].isEmpty()) {
			for (int i = 0; i < subargs.length; ++i) {
				tagset.add(CDependencyLabel.code(subargs[i]));
			}
		}
		return new CWordSetOfLabels(new CWord(args[0].substring(1, args[0].length() - 1)), tagset);
	}

	@Override
	public String generateStringFromKey(CWordSetOfLabels key) {
		String retval = "[" + key.first().toString() + "] , [ ";
		CSetOfTags sot = key.second();
		for (int label = 0; label < CDependencyLabel.COUNT; ++label) {
			if (sot.contains(label)) {
				retval += (CDependencyLabel.str(label) + " ");
			}
		}
		return retval + "]";
	}

	@Override
	public CWordSetOfLabels allocate_key(CWordSetOfLabels key) {
		return new CWordSetOfLabels(key);
	}

}
