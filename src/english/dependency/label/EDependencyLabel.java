package english.dependency.label;



public final class EDependencyLabel {
	public static final String[] PENN_DEP_STRINGS = new String[] {
		"-NONE-",
		"ROOT",
		"AMOD",
		"DEP",
		"NMOD",
		"OBJ",
		"P",
		"PMOD",
		"PRD",
		"SBAR",
		"SUB",
		"VC",
		"VMOD"
	};

	public static final int PENN_DEP_NONE = 0;
	public static final int PENN_DEP_ROOT = 1;
	public static final int PENN_DEP_AMOD = 2;
	public static final int PENN_DEP_DEP = 3;
	public static final int PENN_DEP_NMOD = 4;
	public static final int PENN_DEP_OBJ = 5;
	public static final int PENN_DEP_P = 6;
	public static final int PENN_DEP_PMOD = 7;
	public static final int PENN_DEP_PRD = 8;
	public static final int PENN_DEP_SBAR = 9;
	public static final int PENN_DEP_SUB = 10;
	public static final int PENN_DEP_VC = 11;
	public static final int PENN_DEP_VMOD = 12;
	public static final int PENN_DEP_COUNT = 13;
	
	public static final int PENN_DEP_COUNT_BITS = 4;

	public static final int NONE = 0;
	public static final int ROOT = 1;
	public static final int FIRST = 1;
	public static final int COUNT = PENN_DEP_COUNT;
	public static final int MAX_COUNT = COUNT;
	public static final int SIZE = PENN_DEP_COUNT_BITS;

	protected int m_code;
	
	public EDependencyLabel(final String str) {
		load(str);
	}
	
	public void load(int u) {
		m_code = u;
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
	
	@Override
	public int hashCode() {
		return m_code;
	}
	
	@Override
	public boolean equals(final Object o) {
		return m_code == ((EDependencyLabel)o).m_code;
	}
	
	@Override
	public String toString() {
		return PENN_DEP_STRINGS[m_code];
	}
	
	public static String str(final int code) {
		return PENN_DEP_STRINGS[code];
	}
	
	public static int code(final String label) {
		for (int i = FIRST; i < COUNT; ++i) {
			if (PENN_DEP_STRINGS[i].equals(label)) {
				return i;
			}
		}
		return PENN_DEP_NONE;
	}
	
	
}
