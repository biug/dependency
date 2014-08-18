package english.parser.implementations.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.english.ESetOfLabels;
import include.linguistics.english.ETagESetOfLabels;
import english.dependency.label.EDependencyLabel;
import english.pos.ETag;

@SuppressWarnings("serial")
public final class ETagESetOfLabelsMap extends PackedScoreMap<ETagESetOfLabels> {
	
	public ETagESetOfLabelsMap(final String input_name, final int table_size) {
		super(input_name, table_size);
	}

	@Override
	public ETagESetOfLabels loadKeyFromString(final String str) {
		String[] args = str.split(" , ");
		ESetOfLabels tagset = new ESetOfLabels();
		String[] subargs = args[1].substring(2, args[1].length() - 1).split(" ");
		if (!subargs[0].isEmpty()) {
			for (int i = 0; i < subargs.length; ++i) {
				tagset.add(EDependencyLabel.code(subargs[i]));
			}
		}
		return new ETagESetOfLabels(new ETag(args[0]), tagset);
	}

	@Override
	public String generateStringFromKey(final ETagESetOfLabels key) {
		String retval = key.first().toString() + " , [ ";
		ESetOfLabels sot = key.second();
		for (int label = 0; label < EDependencyLabel.COUNT; ++label) {
			if (sot.contains(label)) {
				retval += (EDependencyLabel.str(label) + " ");
			}
		}
		return retval + "]";
	}

	@Override
	public ETagESetOfLabels allocate_key(final ETagESetOfLabels key) {
		return new ETagESetOfLabels(key);
	}
}
