package common.parser.implementations.arceager;

import include.learning.perceptron.PackedScore;
import include.learning.perceptron.PackedScoreMap;
import include.learning.perceptron.Score;
import include.linguistics.CWord;

import java.util.Iterator;

@SuppressWarnings("serial")
public class CWordMap extends PackedScoreMap<CWord> {

	public CWordMap(String input_name, int table_size) {
		super(input_name, table_size);
	}

	@Override
	public CWord loadKeyFromString(String str) {
		return new CWord(str);
	}

	@Override
	public String generateStringFromKey(CWord key) {
		return "[" + key.toString() + "]";
	}
	
	/*
	 * DEBUG
	 */
	public void print() {
		System.out.println(this.name);
		Iterator<java.util.Map.Entry<CWord, PackedScore>> itr = this.entrySet().iterator();
		while (itr.hasNext()) {
			java.util.Map.Entry<CWord, PackedScore> entry = itr.next();
			if (!entry.getValue().empty()) {
				System.out.print("[" + entry.getKey().toString() + "]");
				System.out.print("\t:\t");
				System.out.print("{ ");
				Iterator<java.util.Map.Entry<Integer, Score>> itr0 = entry.getValue().scores.entrySet().iterator();
				while (itr0.hasNext()) {
					java.util.Map.Entry<Integer, Score> entry0 = itr0.next();
					if (!entry0.getValue().zero()) {
						System.out.print(entry0.getKey());
						System.out.print(" : ");
						System.out.print(entry0.getValue().current + " / " + entry0.getValue().total);
						if (itr0.hasNext()) System.out.print(" , ");
					}
				}
				System.out.println(" }");
			}
		}
		System.out.println();
	}
	
}
