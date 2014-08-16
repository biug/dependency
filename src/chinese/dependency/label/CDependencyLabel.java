package chinese.dependency.label;

public final class CDependencyLabel {
	
	public static final String[] PENN_DEP_STRINGS = new String[] {
	   "-NONE-",
	   "ROOT", 
	   "AMOD",
	   "NMOD", 
	   "PMOD", 
	   "VMOD", 
	   "SBJ", 
	   "OBJ", 
	   "POBJ", 
	   "VRD", 
	   "DEC", 
	   "DEG", 
	   "DEV", 
	   "LC", 
	   "M", 
	   "PRN", 
	   "VC", 
	   "COOR", 
	   "CS"
	};
	
	public static final int PENN_DEP_NONE = 0;
	public static final int PENN_DEP_ROOT = 1;
	public static final int PENN_DEP_AMOD = 2;
	public static final int PENN_DEP_NMOD = 3;
	public static final int PENN_DEP_PMOD = 4;
	public static final int PENN_DEP_VMOD = 5;
	public static final int PENN_DEP_SBJ = 6;
	public static final int PENN_DEP_OBJ = 7;
	public static final int PENN_DEP_POBJ = 8;
	public static final int PENN_DEP_VRD = 9;
	public static final int PENN_DEP_DEC = 10;
	public static final int PENN_DEP_DEG = 11;
	public static final int PENN_DEP_DEV = 12;
	public static final int PENN_DEP_LC = 13;
	public static final int PENN_DEP_M = 14;
	public static final int PENN_DEP_PRN = 15;
	public static final int PENN_DEP_VC = 16;
	public static final int PENN_DEP_COOR = 17;
	public static final int PENN_DEP_CS = 18;
	public static final int PENN_DEP_COUNT = 19;
	
	public static final int PENN_DEP_COUNT_BITS = 5;
	
	public static final int NONE = 0;
	public static final int ROOT = 1;
	public static final int FIRST = 1;
	public static final int COUNT = PENN_DEP_COUNT;
	public static final int MAX_COUNT = COUNT;
	public static final int SIZE = PENN_DEP_COUNT_BITS;
	
	protected int m_code;
	
	public CDependencyLabel() {
		m_code = NONE;
	}
	
	public CDependencyLabel(final int code) {
		m_code = code;
	}
	
	public CDependencyLabel(final String str) {
		load(str);
	}
	
	@Override
	public int hashCode() {
		return m_code;
	}
	
	@Override
	public boolean equals(final Object o) {
		return m_code == ((CDependencyLabel)o).m_code;
	}
	
	public void load(final String str) {
		m_code = PENN_DEP_NONE;
		for (int i = FIRST; i < COUNT; ++i) {
			if (PENN_DEP_STRINGS[i].equals(str)) {
				m_code = i;
				return;
			}
		}
	}
	
	public void load(final int u) {
		m_code = u;
	}
	
	@Override
	public String toString() {
		return PENN_DEP_STRINGS[m_code];
	}
	
	public final static String str(final int code) {
		return PENN_DEP_STRINGS[code];
	}
	
	public final static int code(final String label) {
		for (int i = FIRST; i < COUNT; ++i) {
			if (PENN_DEP_STRINGS[i].equals(label)) {
				return i;
			}
		}
		return PENN_DEP_NONE;
	}
}
