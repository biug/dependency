package english.parser.implementations.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.Word;
import include.linguistics.english.ESetOfLabels;
import include.linguistics.english.WordESetOfLabels;
import english.dependency.label.EDependencyLabel;

@SuppressWarnings("serial")
public final class WordESetOfLabelsMap extends PackedScoreMap<WordESetOfLabels> {

	public WordESetOfLabelsMap(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public WordESetOfLabels loadKeyFromString(final String str) {
		String[] args = str.split(" , ");
		ESetOfLabels tagset = new ESetOfLabels();
		String[] subargs = args[1].substring(2, args[1].length() - 1).split(" ");
		if (!subargs[0].isEmpty()) {
			for (int i = 0; i < subargs.length; ++i) {
				tagset.add(EDependencyLabel.code(subargs[i]));
			}
		}
		return new WordESetOfLabels(new Word(args[0].substring(1, args[0].length() - 1)), tagset);
	}

	@Override
	public String generateStringFromKey(final WordESetOfLabels key) {
		String retval = "[" + key.first().toString() + "] , [ ";
		ESetOfLabels sot = key.second();
		for (int label = 0; label < EDependencyLabel.COUNT; ++label) {
			if (sot.contains(label)) {
				retval += (EDependencyLabel.str(label) + " ");
			}
		}
		return retval + "]";
	}

	@Override
	public WordESetOfLabels allocate_key(final WordESetOfLabels key) {
		return new WordESetOfLabels(key);
	}

}
