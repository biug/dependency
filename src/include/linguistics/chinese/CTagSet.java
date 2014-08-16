package include.linguistics.chinese;

import chinese.pos.CTag;

public class CTagSet {	
	private int size;
	
	protected int m_nHash;
	
	public CTagSet(final int s) {
		size = s;
		m_nHash = 0;
	}
	
	public CTagSet(final CTagSet tagset) {
		size = tagset.size;
		m_nHash = tagset.m_nHash;
	}
	
	public CTagSet(final int s, final int hash) {
		size = s;
		m_nHash = hash;
	}
	
	private void attach(int c) {
		m_nHash = ((m_nHash << CTag.SIZE) | c);
	}
	
	@Override
	public int hashCode() {
		return m_nHash;
	}
	
	@Override
	public boolean equals(Object o) {
		return m_nHash == ((CTagSet)o).m_nHash;
	}
	
	@Override
	public String toString() {
		String retval = "";
		int hs = m_nHash;
		for (int i = 0; i < size; ++i) {
			if (!retval.isEmpty()) {
				retval = " " + retval;
			}
			retval = CTag.str(hs & ((1 << CTag.SIZE) - 1)) + retval;
			hs >>= CTag.SIZE;
		}
		return retval;
	}
	
	public void load(final String s) {
		clear();
		String[] args = s.substring(2, s.length() - 2).split(" ");
		for (int i = 0; i < size; ++i) {
			this.attach(CTag.code(args[i]));
		}
	}
	
	public void load(final int i) {
		m_nHash = i;
	}
	
	public void clear() {
		m_nHash = 0;
	}
}
