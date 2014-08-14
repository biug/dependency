package common.parser.implementations.arceager;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.CSetOfTags;
import include.linguistics.CWord;
import include.linguistics.CWordSetOfLabels;
import chinese.dependency.label.CDependencyLabel;

@SuppressWarnings("serial")
public class CWordSetOfLabelsMap extends PackedScoreMap<CWordSetOfLabels> {
	public static CDependencyLabel sCDL = new CDependencyLabel();

	public CWordSetOfLabelsMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CWordSetOfLabels loadKeyFromString(String str) {
		CWordSetOfLabels cwsol = new CWordSetOfLabels();
		String[] args = str.split(sSplit);
		CSetOfTags sot = new CSetOfTags();
		sot.clear();
		for (int i = 1; i < args.length; ++i) {
			sCDL.load(args[i]);
			sot.add(sCDL);
		}
		cwsol.allocate(new CWord(args[0]), sot);
		return cwsol;
	}

	@Override
	public String generateStringFromKey(CWordSetOfLabels key) {
		String retval = "[" + key.first().toString() + "] , [ ";
		CSetOfTags sot = key.second();
		for (int i = 0; i < CDependencyLabel.COUNT; ++i) {
			sCDL.load(i);
			if (sot.contains(sCDL)) {
				retval += (sCDL.toString() + " ");
			}
		}
		return retval + "]";
	}

}
