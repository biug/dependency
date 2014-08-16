package common.map;

import include.learning.perceptron.PackedScoreMap;
import include.linguistics.Lemma;

@SuppressWarnings("serial")
public class LemmaMap extends PackedScoreMap<Lemma> {

	public LemmaMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public Lemma loadKeyFromString(String str) {
		return new Lemma(str);
	}

	@Override
	public String generateStringFromKey(Lemma key) {
		return "[" + key.toString() + "]";
	}

	@Override
	public Lemma allocate_key(Lemma key) {
		return new Lemma(key);
	}

}