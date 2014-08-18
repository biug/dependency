package include.linguistics.chinese;

import include.Tuple2;
import include.linguistics.Word;

public final class WordCSetOfLabels extends Tuple2<Word, CSetOfLabels> {
	
	public WordCSetOfLabels() {
		super();
	}
	
	public WordCSetOfLabels(final WordCSetOfLabels word_tagset) {
		refer(word_tagset.m_object1, word_tagset.m_object2);
	}
	
	public WordCSetOfLabels(final Word word, final CSetOfLabels tagset) {
		super(word, tagset);
	}

	@Override
	public Word create_object1(final Word a) {
		return a;
	}

	@Override
	public CSetOfLabels create_object2(final CSetOfLabels b) {
		return b;
	}

}
