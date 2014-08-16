package include.linguistics.chinese;

import include.Tuple2;
import include.linguistics.Word;

public final class WordCSetOfLabels extends Tuple2<Word, CSetOfTags> {
	
	public WordCSetOfLabels() {
		super();
	}
	
	public WordCSetOfLabels(final WordCSetOfLabels word_tagset) {
		super((Tuple2<Word, CSetOfTags>)word_tagset);
	}
	
	public WordCSetOfLabels(final Word word, final CSetOfTags tagset) {
		super(word, tagset);
	}

	@Override
	public Word create_object1(final Word a) {
		return a;
	}

	@Override
	public CSetOfTags create_object2(final CSetOfTags b) {
		return new CSetOfTags(b);
	}

}
