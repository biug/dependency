package chinese.pos;

public final class CTag {
	public final static String PENN_TAG_STRINGS[] = {
		   "-NONE-",
		   "-BEGIN-",
		   "-END-",
		   "NN", "VV", 
		   "NR", "AD", 
		   "P", "CD", "M", "JJ", 
		   "DEC", "DEG", 
		   "NT", "CC", "VA", "LC",  
		   "PN", "DT", "VC", "AS", "VE", 
		   "OD", 
		   "ETC", "MSP", "CS", "BA", 
		   "DEV", "SB", "SP", "LB", 
		   "FW", "DER", "PU", 
	};
	
	public final static int PENN_TAG_NONE = 0;
	public final static int PENN_TAG_BEGIN = 1;
	public final static int PENN_TAG_END = 2;
	public final static int PENN_TAG_NN = 3;
	public final static int PENN_TAG_VV = 4;
	public final static int PENN_TAG_NR = 5;
	public final static int PENN_TAG_AD = 6;
	public final static int PENN_TAG_P = 7;
	public final static int PENN_TAG_CD = 8;
	public final static int PENN_TAG_M = 9;
	public final static int PENN_TAG_JJ = 10;
	public final static int PENN_TAG_DEC = 11;
	public final static int PENN_TAG_DEG = 12;
	public final static int PENN_TAG_NT = 13;
	public final static int PENN_TAG_CC = 14;
	public final static int PENN_TAG_VA = 15;
	public final static int PENN_TAG_LC = 16;
	public final static int PENN_TAG_PN = 17;
	public final static int PENN_TAG_DT = 18;
	public final static int PENN_TAG_VC = 19;
	public final static int PENN_TAG_AS = 20;
	public final static int PENN_TAG_VE = 21;
	public final static int PENN_TAG_OD = 22;
	public final static int PENN_TAG_ETC = 23;
	public final static int PENN_TAG_MSP = 24;
	public final static int PENN_TAG_CS = 25;
	public final static int PENN_TAG_BA = 26;
	public final static int PENN_TAG_DEV = 27;
	public final static int PENN_TAG_SB = 28;
	public final static int PENN_TAG_SP = 29;
	public final static int PENN_TAG_LB = 30;
	public final static int PENN_TAG_FW = 31;
	public final static int PENN_TAG_DER = 32;
	public final static int PENN_TAG_PU = 33;
	public final static int PENN_TAG_COUNT = 34;
	
	public final static int PENN_TAG_FIRST = 3;
	public final static int PENN_TAG_COUNT_BITS = 6;
	
	public static final char TAG_SEPARATOR = '_';
	
	public static final int SENTENCE_BEGIN = PENN_TAG_BEGIN;
	public static final int SENTENCE_END = PENN_TAG_END;
	public static final int COUNT = PENN_TAG_COUNT;
	public static final int NONE = PENN_TAG_NONE;
	public static final int SIZE = PENN_TAG_COUNT_BITS;
	public static final int FIRST = PENN_TAG_FIRST;
	public static final int LAST = PENN_TAG_COUNT - 1;
	
	protected int m_code; // unsigned
	
	public CTag() {
		m_code = NONE;
	}
	
	public CTag(int t) {
		m_code = t;
	}
	
	public CTag(final CTag t) {
		m_code = t.m_code;
	}
	
	public CTag(final String s) {
		load(s);
	}
	
	@Override
	public int hashCode() {
		return m_code;
	}
	
	@Override
	public final String toString() {
		return PENN_TAG_STRINGS[m_code];
	}
	
	public void load(final String s) {
		for (int i = 0; i < PENN_TAG_COUNT; ++i) {
			if (PENN_TAG_STRINGS[i].equals(s)) {
				m_code = i;
				return;
			}
		}
	}
	
	@Override
	public boolean equals(final Object t) {
		return m_code == ((CTag)t).m_code;
	}
	
	public final static String str(final int t) {
		return PENN_TAG_STRINGS[t];
	}
	
	public final static int code(final String s) {
		for (int i = 0; i < PENN_TAG_COUNT; ++i) {
			if (PENN_TAG_STRINGS[i].equals(s)) {
				return i;
			}
		}
		return NONE;
	}
	
}
