package chinese.parser.implementations.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.Word;
import include.linguistics.chinese.CSetOfLabels;
import include.linguistics.chinese.WordCSetOfLabels;
import chinese.dependency.label.CDependencyLabel;

@SuppressWarnings("serial")
public final class WordCSetOfLabelsMap extends PackedScoreMap<WordCSetOfLabels> {

	public WordCSetOfLabelsMap(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public WordCSetOfLabels loadKeyFromString(final String str) {
		String[] args = str.split(" , ");
		CSetOfLabels tagset = new CSetOfLabels();
		String[] subargs = args[1].substring(2, args[1].length() - 1).split(" ");
		if (!subargs[0].isEmpty()) {
			for (int i = 0; i < subargs.length; ++i) {
				tagset.add(CDependencyLabel.code(subargs[i]));
			}
		}
		return new WordCSetOfLabels(new Word(args[0].substring(1, args[0].length() - 1)), tagset);
	}

	@Override
	public String generateStringFromKey(final WordCSetOfLabels key) {
		String retval = "[" + key.first().toString() + "] , [ ";
		CSetOfLabels sot = key.second();
		for (int label = 0; label < CDependencyLabel.COUNT; ++label) {
			if (sot.contains(label)) {
				retval += (CDependencyLabel.str(label) + " ");
			}
		}
		return retval + "]";
	}

	@Override
	public WordCSetOfLabels allocate_key(final WordCSetOfLabels key) {
		return new WordCSetOfLabels(key);
	}

}
