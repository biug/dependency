package common.parser.implementations.arceager;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.CSetOfTags;
import include.linguistics.CTagSetOfLabels;
import chinese.dependency.label.CDependencyLabel;
import chinese.pos.CTag;

@SuppressWarnings("serial")
public class CTagSetOfLabelsMap extends PackedScoreMap<CTagSetOfLabels> {
	public static CDependencyLabel sCDL = new CDependencyLabel();

	public CTagSetOfLabelsMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CTagSetOfLabels loadKeyFromString(String str) {
		CTagSetOfLabels ctsol = new CTagSetOfLabels();
		String[] args = str.split(sSplit);
		CSetOfTags sot = new CSetOfTags();
		sot.clear();
		for (int i = 1; i < args.length; ++i) {
			sCDL.load(args[i]);
			sot.add(sCDL);
		}
		ctsol.allocate(new CTag(args[0]), sot);
		return ctsol;
	}

	@Override
	public String generateStringFromKey(CTagSetOfLabels key) {
		String retval = key.first().toString() + " , [ ";
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
