package include.linguistics.english;

import english.pos.ETag;

public class ETagSet {
	private int size;
	
	protected int m_nHash;
	
	public ETagSet(final int s) {
		size = s;
		m_nHash = 0;
	}
	
	public ETagSet(final ETagSet tagset) {
		size = tagset.size;
		m_nHash = tagset.m_nHash;
	}
	
	public ETagSet(final int s, final int hash) {
		size = s;
		m_nHash = hash;
	}
	
	private final void attach(final int c) {
		m_nHash = ((m_nHash << ETag.SIZE) | c);
	}
	
	@Override
	public final int hashCode() {
		return m_nHash;
	}
	
	@Override
	public final boolean equals(final Object o) {
		return m_nHash == ((ETagSet)o).m_nHash;
	}
	
	@Override
	public String toString() {
		String retval = "";
		int hs = m_nHash;
		for (int i = 0; i < size; ++i) {
			if (!retval.isEmpty()) {
				retval = " " + retval;
			}
			retval = ETag.str(hs & ((1 << ETag.SIZE) - 1)) + retval;
			hs >>= ETag.SIZE;
		}
		return retval;
	}
	
	public final void load(final String s) {
		clear();
		String[] args = s.substring(2, s.length() - 2).split(" ");
		for (int i = 0; i < size; ++i) {
			this.attach(ETag.code(args[i]));
		}
	}
	
	public final void load(final int i) {
		m_nHash = i;
	}
	
	public final void clear() {
		m_nHash = 0;
	}
}
