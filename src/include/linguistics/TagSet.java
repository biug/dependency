package include.linguistics;

import chinese.pos.CTag;

public class TagSet {
	public static CTag ct = new CTag();
	public final static String sSplit = ",";
	
	private int size;
	
	protected int m_nHash;
	
	public TagSet(final int s) {
		size = s;
		m_nHash = 0;
	}
	
	public TagSet(final int s, final int hash) {
		size = s;
		m_nHash = hash;
	}
	
	private void attach(final CTag i) {
		m_nHash = ((m_nHash << CTag.SIZE) | i.hashCode());
	}
	
	@Override
	public int hashCode() {
		return m_nHash;
	}
	
	@Override
	public boolean equals(Object o) {
		return m_nHash == ((TagSet)o).m_nHash;
	}
	
	@Override
	public String toString() {
		String retval = new String("");
		int hs = m_nHash;
		int tc;
		for (int i = 0; i < size; ++i) {
			if (!retval.isEmpty()) {
				retval = " " + retval;
			}
			tc = hs & ((1 << CTag.SIZE) - 1);
			retval = (new CTag(tc)).toString() + retval;
			hs >>= CTag.SIZE;
		}
		return retval;
	}
	
	public void load(final String s) {
		clear();
		String[] args = s.split(sSplit);
		for (int i = 0; i < size; ++i) {
			ct.load(args[i]);
			this.attach(ct);
		}
	}
	
	public void load(final int i) {
		m_nHash = i;
	}
	
	public void clear() {
		m_nHash = 0;
	}
}
