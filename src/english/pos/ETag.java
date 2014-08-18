package english.pos;



public final class ETag {
	public final static String[] PENN_TAG_STRINGS = {
		"-NONE-",
		"-BEGIN-",
		"-END-",
		"$", "``", "''",
		"-LRB-", "-RRB-", ",",
		".", ":", "#",
		"CC", "CD", "DT", "EX", "FW",
		"IN", "JJ", "JJR", "JJS", "LS",
		"MD", "NN", "NNP", "NNPS", "NNS",
		"PDT", "POS", "PRP", "PRP$",
		"RB", "RBR", "RBS", "RP",
		"SYM", "TO", "UH",
		"VB", "VBD", "VBG", "VBN", "VBP", "VBZ",
		"WDT", "WP", "WP$", "WRB"
	};

	public final static int PENN_TAG_NONE = 0;
	public final static int PENN_TAG_BEGIN = 1;
	public final static int PENN_TAG_END = 2;
	public final static int PENN_TAG_DOLLAR = 3;
	public final static int PENN_TAG_L_QUOTE = 4;
	public final static int PENN_TAG_R_QUOTE = 5;
	public final static int PENN_TAG_L_BRACKET = 6;
	public final static int PENN_TAG_R_BRACKET = 7;
	public final static int PENN_TAG_COMMA = 8;
	public final static int PENN_TAG_PERIOD = 9;
	public final static int PENN_TAG_COLUM = 10;
	public final static int PENN_TAG_SHART = 11;
	public final static int PENN_TAG_CC = 12;
	public final static int PENN_TAG_CD = 13;
	public final static int PENN_TAG_DT = 14;
	public final static int PENN_TAG_EX = 15;
	public final static int PENN_TAG_FW = 16;
	public final static int PENN_TAG_IN = 17;
	public final static int PENN_TAG_ADJECTIVE = 18;
	public final static int PENN_TAG_ADJECTIVE_COMPARATIVE = 19;
	public final static int PENN_TAG_ADJECTIVE_SUPERLATIVE = 20;
	public final static int PENN_TAG_LS = 21;
	public final static int PENN_TAG_MD = 22;
	public final static int PENN_TAG_NOUN = 23;
	public final static int PENN_TAG_NOUN_PROPER = 24;
	public final static int PENN_TAG_NOUN_PROPER_PLURAL = 25;
	public final static int PENN_TAG_NOUN_PLURAL = 26;
	public final static int PENN_TAG_PDT = 27;
	public final static int PENN_TAG_POS = 28;
	public final static int PENN_TAG_PRP = 29;
	public final static int PENN_TAG_PRP_DOLLAR = 30;
	public final static int PENN_TAG_ADVERB = 31;
	public final static int PENN_TAG_ADVERB_COMPARATIVE = 32;
	public final static int PENN_TAG_ADVERB_SUPERLATIVE = 33;
	public final static int PENN_TAG_RP = 34;
	public final static int PENN_TAG_SYM = 35;
	public final static int PENN_TAG_TO = 36;
	public final static int PENN_TAG_UH = 37;
	public final static int PENN_TAG_VERB = 38;
	public final static int PENN_TAG_VERB_PAST = 39;
	public final static int PENN_TAG_VERB_PROG = 40;
	public final static int PENN_TAG_VERB_PAST_PARTICIPATE = 41;
	public final static int PENN_TAG_VERB_PRES = 42;
	public final static int PENN_TAG_VERB_THIRD_SINGLE = 43;
	public final static int PENN_TAG_WDT = 44;
	public final static int PENN_TAG_WP = 45;
	public final static int PENN_TAG_WP_DOLLAR = 46;
	public final static int PENN_TAG_WRB = 47;
	public final static int PENN_TAG_COUNT = 48;
	
	public final static boolean[] PENN_TAG_CLOSED = {
		false,
		true,
		true,
		true, true, true,
		true, true, true,
		true, true, true,
		true, false, true, true, false,
		true, false, false, false, false,
		true, false, false, false, false,
		true, true, true, true,
		false, false, false, false,
		false, true, false,
		false, false, false, false, false, false,
		true, true, true, true
	};
	
	public final static int PENN_TAG_FIRST = 3;
	public final static int PENN_TAG_COUNT_BITS = 6;
	
	
	public final long PENN_TAG_MUST_SEE = (((long)1 << PENN_TAG_SYM) | ((long)1 << PENN_TAG_FW) | ((long)1 << PENN_TAG_CD) | ((long)1 << PENN_TAG_LS) | ((long)1 << PENN_TAG_NOUN_PROPER) | ((long)1 << PENN_TAG_NOUN_PROPER_PLURAL));

	public static final int NONE = PENN_TAG_NONE;
	public static final int SENTENCE_BEGIN = PENN_TAG_BEGIN;
	public static final int SENTENCE_END = PENN_TAG_END;
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
		m_code = PENN_TAG_NONE;
		for (int i = 0; i < PENN_TAG_COUNT; ++i) {
			if (PENN_TAG_STRINGS[i].equals(s)) {
				m_code = i;
				return;
			}
		}		
	}
	
	public static String str(final int t) {
		return PENN_TAG_STRINGS[t];
	}
	
	public static int code(final String s) {
		for (int i = 1; i < PENN_TAG_COUNT; ++i) {
			if (PENN_TAG_STRINGS[i].equals(s)) {
				return i;
			}
		}
		return PENN_TAG_NONE;
	}
}
