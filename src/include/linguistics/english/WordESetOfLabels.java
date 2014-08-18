package include.linguistics.english;

import include.Tuple2;
import include.linguistics.Word;

public final class WordESetOfLabels extends Tuple2<Word, ESetOfLabels> {
	public WordESetOfLabels() {
		super();
	}
	
	public WordESetOfLabels(final WordESetOfLabels word_tagset) {
		refer(word_tagset.m_object1, word_tagset.m_object2);
	}
	
	public WordESetOfLabels(final Word word, final ESetOfLabels tagset) {
		super(word, tagset);
	}

	@Override
	public Word create_object1(final Word a) {
		return a;
	}

	@Override
	public ESetOfLabels create_object2(final ESetOfLabels b) {
		return b;
	}
}
