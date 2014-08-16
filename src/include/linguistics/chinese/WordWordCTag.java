package include.linguistics.chinese;

import include.Tuple3;
import include.linguistics.Word;
import chinese.pos.CTag;

public class WordWordCTag extends Tuple3<Word, Word, CTag> {
	
	public WordWordCTag() {
		super();
	}
	
	public WordWordCTag(WordWordCTag word_word_tag) {
		super((Tuple3<Word, Word, CTag>)word_word_tag);
	}
	
	public WordWordCTag(Word word1, Word word2, CTag tag) {
		super(word1, word2, tag);
	}

	@Override
	public Word create_object1(Word a) {
		return a;
	}

	@Override
	public Word create_object2(Word b) {
		return b;
	}

	@Override
	public CTag create_object3(CTag c) {
		return c;
	}

}
