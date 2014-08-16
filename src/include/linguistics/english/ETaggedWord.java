package include.linguistics.english;

import include.linguistics.Word;
import english.pos.ETag;

public final class ETaggedWord {

	public Word word;
	public ETag tag;
	
	public ETaggedWord() {
		word = new Word();
		tag = new ETag();
	}
	
	public ETaggedWord(final String s, final String t) {
		word = new Word(s);
		tag = new ETag(t);
	}
	
	public ETaggedWord(final Word w, final ETag t) {
		word = w;
		tag = t;
	}
	
	public ETaggedWord(final ETaggedWord w) {
		word = w.word;
		tag = w.tag;
	}
	
	@Override
	public boolean equals(final Object o) {
		return word.equals(((ETaggedWord)o).word) && tag.equals(((ETaggedWord)o).tag);
	}
	
	@Override
	public int hashCode() {
		return ((word.hashCode()) << ETag.SIZE) | (tag.hashCode());
	}
	
	public void load(final Word w, final ETag t) {
		word = w;
		tag = t;
	}
	
	public void load(final Word w) {
		word = w;
		tag = new ETag(ETag.NONE);
	}
}
