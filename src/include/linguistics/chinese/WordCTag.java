package include.linguistics.chinese;

import include.Tuple2;
import include.linguistics.Word;
import chinese.pos.CTag;

public class WordCTag extends Tuple2<Word, CTag> {
	
	public WordCTag() {
		super();
	}
	
	public WordCTag(final WordCTag word_tag) {
		super((Tuple2<Word, CTag>)word_tag);
	}
	
	public WordCTag(Word word, CTag tag) {
		super(word, tag);
	}

	@Override
	public Word create_object1(Word a) {
		return a;
	}

	@Override
	public CTag create_object2(CTag b) {
		return b;
	}
	
}
