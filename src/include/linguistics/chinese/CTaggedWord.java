package include.linguistics.chinese;

import include.linguistics.Word;
import chinese.pos.CTag;

public final class CTaggedWord {
	
	public static final CTag empty_tag = new CTag(CTag.NONE);
	
	public Word word;
	public CTag tag;
	
	public CTaggedWord() {
		word = new Word();
		tag = new CTag();
	}
	
	public CTaggedWord(final String s, final String t) {
		word = new Word(s);
		tag = new CTag(t);
	}
	
	public CTaggedWord(final Word w, final CTag t) {
		word = w;
		tag = t;
	}
	
	public CTaggedWord(final CTaggedWord w) {
		word = w.word;
		tag = w.tag;
	}
	
	@Override
	public boolean equals(final Object o) {
		CTaggedWord tw = (CTaggedWord)o;
		return word.equals(tw.word) && tag.equals(tw.tag);
	}
	
	@Override
	public int hashCode() {
		return ((word.hashCode()) << CTag.SIZE) | (tag.hashCode());
	}
	
	public void load(final Word w, final CTag t) {
		word = w;
		tag = t;
	}
	
	public void load(final Word w) {
		word = w;
		tag = empty_tag;
	}
}
