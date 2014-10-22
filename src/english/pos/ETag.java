package english.pos;

import java.util.HashMap;
import java.util.Map;



public final class ETag {
	public final static String[] PENN_TAG_STRINGS = {
		"-NONE-",
		"NN",
		"JJ",
		"NP",
		"RRB",
		"WRB",
		"LS",
		"PRP",
		"DT",
		"NNP",
		"FW",
		"NNS",
		"JJS",
		"JJR",
		"UH",
		"MD",
		"VBD",
		"WP",
		"VBG",
		"SO",
		"CC",
		"CD",
		"PDT",
		"RBS",
		"VBN",
		"RBR",
		"#",
		"$",
		"IN",
		"VBP",
		"WDT",
		"SYM",
		"SBAR",
		"NNPS",
		"WP$",
		",",
		"VB",
		".",
		"VBZ",
		"RB",
		"AS",
		"PRP$",
		"EX",
		"POS",
		":",
		"TO",
		";",
		"LRB",
		"RP"
	};
	
	public final static Map<String, Integer> PENN_TAG_MAP = new HashMap<String, Integer>();
	static {
		PENN_TAG_MAP.put("-NONE-", new Integer(0));
		PENN_TAG_MAP.put("NN", new Integer(1));
		PENN_TAG_MAP.put("JJ", new Integer(2));
		PENN_TAG_MAP.put("NP", new Integer(3));
		PENN_TAG_MAP.put("RRB", new Integer(4));
		PENN_TAG_MAP.put("WRB", new Integer(5));
		PENN_TAG_MAP.put("LS", new Integer(6));
		PENN_TAG_MAP.put("PRP", new Integer(7));
		PENN_TAG_MAP.put("DT", new Integer(8));
		PENN_TAG_MAP.put("NNP", new Integer(9));
		PENN_TAG_MAP.put("FW", new Integer(10));
		PENN_TAG_MAP.put("NNS", new Integer(11));
		PENN_TAG_MAP.put("JJS", new Integer(12));
		PENN_TAG_MAP.put("JJR", new Integer(13));
		PENN_TAG_MAP.put("UH", new Integer(14));
		PENN_TAG_MAP.put("MD", new Integer(15));
		PENN_TAG_MAP.put("VBD", new Integer(16));
		PENN_TAG_MAP.put("WP", new Integer(17));
		PENN_TAG_MAP.put("VBG", new Integer(18));
		PENN_TAG_MAP.put("SO", new Integer(19));
		PENN_TAG_MAP.put("CC", new Integer(20));
		PENN_TAG_MAP.put("CD", new Integer(21));
		PENN_TAG_MAP.put("PDT", new Integer(22));
		PENN_TAG_MAP.put("RBS", new Integer(23));
		PENN_TAG_MAP.put("VBN", new Integer(24));
		PENN_TAG_MAP.put("RBR", new Integer(25));
		PENN_TAG_MAP.put("#", new Integer(26));
		PENN_TAG_MAP.put("$", new Integer(27));
		PENN_TAG_MAP.put("IN", new Integer(28));
		PENN_TAG_MAP.put("VBP", new Integer(29));
		PENN_TAG_MAP.put("WDT", new Integer(30));
		PENN_TAG_MAP.put("SYM", new Integer(31));
		PENN_TAG_MAP.put("SBAR", new Integer(32));
		PENN_TAG_MAP.put("NNPS", new Integer(33));
		PENN_TAG_MAP.put("WP$", new Integer(34));
		PENN_TAG_MAP.put(",", new Integer(35));
		PENN_TAG_MAP.put("VB", new Integer(36));
		PENN_TAG_MAP.put(".", new Integer(37));
		PENN_TAG_MAP.put("VBZ", new Integer(38));
		PENN_TAG_MAP.put("RB", new Integer(39));
		PENN_TAG_MAP.put("AS", new Integer(40));
		PENN_TAG_MAP.put("PRP$", new Integer(41));
		PENN_TAG_MAP.put("EX", new Integer(42));
		PENN_TAG_MAP.put("POS", new Integer(43));
		PENN_TAG_MAP.put(":", new Integer(44));
		PENN_TAG_MAP.put("TO", new Integer(45));
		PENN_TAG_MAP.put(";", new Integer(46));
		PENN_TAG_MAP.put("LRB", new Integer(47));
		PENN_TAG_MAP.put("RP", new Integer(48));
	}

	public final static int PENN_TAG_NONE = 0;
	public final static int PENN_TAG_COUNT = 49;
	
	public final static int PENN_TAG_FIRST = 1;
	public final static int PENN_TAG_COUNT_BITS = 6;
	
	public static final int NONE = PENN_TAG_NONE;
	public static final int COUNT = PENN_TAG_COUNT;
	public static final int MAX_COUNT = PENN_TAG_COUNT;
	public static final int SIZE = PENN_TAG_COUNT_BITS;
	public static final int FIRST = PENN_TAG_FIRST;
	public static final int LAST = PENN_TAG_COUNT - 1;
	
	protected int m_code; // unsigned
	
	public ETag() {
		m_code = NONE;
	}
	
	public ETag(int t) {
		m_code = t;
	}
	
	public ETag(final ETag t) {
		m_code = t.m_code;
	}
	
	public ETag(final String s) {
		load(s);
	}
	
	@Override
	public int hashCode() {
		return m_code;
	}
	
	@Override
	public boolean equals(final Object t) {
		return m_code == ((ETag)t).m_code;
	}
	
	@Override
	public String toString() {
		return PENN_TAG_STRINGS[m_code];
	}

	public void load(final int i) {
		m_code = i;
	}
	
	public void load(String s) {
		Integer i = PENN_TAG_MAP.get(s);
		m_code = i == null ? PENN_TAG_NONE : i.intValue();	
	}
	
	public static String str(final int t) {
		return PENN_TAG_STRINGS[t];
	}
	
	public static int code(final String s) {
		Integer i = PENN_TAG_MAP.get(s);
		return i == null ? PENN_TAG_NONE : i.intValue();
	}
}
