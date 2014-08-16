package include.linguistics.chinese;

import include.Tuple2;
import include.linguistics.Word;

public class WordCSetOfLabels extends Tuple2<Word, CSetOfTags> {
	
	public WordCSetOfLabels() {
		super();
	}
	
	public WordCSetOfLabels(final WordCSetOfLabels word_tagset) {
		super((Tuple2<Word, CSetOfTags>)word_tagset);
	}
	
	public WordCSetOfLabels(Word word, CSetOfTags tagset) {
		super(word, tagset);
	}

	@Override
	public Word create_object1(Word a) {
		return a;
	}

	@Override
	public CSetOfTags create_object2(CSetOfTags b) {
		return new CSetOfTags(b);
	}

}
