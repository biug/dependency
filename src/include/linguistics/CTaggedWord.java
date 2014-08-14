package include.linguistics;

import chinese.pos.CTag;

public class CTaggedWord {
	public final static String sSeparator = "_";
	
	public CWord word;
	public CTag tag;
	
	public CTaggedWord() {
		word = new CWord();
		tag = new CTag();
	}
	
	public CTaggedWord(final String s, final String t) {
		word = new CWord(s);
		tag = new CTag(t);
	}
	
	public CTaggedWord(final CWord w, final CTag t) {
		word = new CWord(w);
		tag = new CTag(t);
	}
	
	public CTaggedWord(final CTaggedWord w) {
		word = new CWord(w.word);
		tag = new CTag(w.tag);
	}
	
	@Override
	public boolean equals(Object o) {
		return word.equals(((CTaggedWord)o).word) && tag.equals(((CTaggedWord)o).tag);
	}
	
	@Override
	public int hashCode() {
		return ((word.hashCode()) << CTag.SIZE) | (tag.hashCode());
	}
	
	public void load(final CWord w, final CTag t) {
		word = new CWord(w);
		tag = new CTag(t);
	}
	
	public void load(final CWord w) {
		word = new CWord(w);
		tag = new CTag(CTag.NONE);
	}
}
