package include.linguistics;


public final class Lemma {
	protected int m_nHash;
	
	protected static StringTokenizer tokenizer = new StringTokenizer();
	
	public static final int NONE = 0;
	public static final int EMPTY = 1;
	
	public Lemma() {
		clear();
	}
	
	public Lemma(final String s) {
		m_nHash = tokenizer.lookup(s);
	}
	
	public Lemma(final String s, boolean bModify) {
		m_nHash = bModify ? tokenizer.lookup(s) : tokenizer.find(s, NONE);
	}
	
	public Lemma(final Lemma w) {
		m_nHash = w.m_nHash;
	}
	
	public Lemma(final int n) {
		m_nHash = n;
	}
	
	@Override
	public int hashCode() {
		return m_nHash;
	}
	
	@Override
	public boolean equals(final Object o) {
		return m_nHash == ((Lemma)o).m_nHash;
	}
	
	public void copy(final Lemma w) {
		m_nHash = w.m_nHash;
	}
	
	public void setString(final String s) {
		m_nHash = tokenizer.find(s, NONE);
	}
	
	@Override
	public String toString() {
		return tokenizer.key(m_nHash);
	}
	
	public void load(final String s) {
		m_nHash = tokenizer.lookup(s);
	}
	
	public boolean empty() {
		return m_nHash == EMPTY;
	}
	
	public boolean none() {
		return m_nHash == NONE;
	}
	
	public void clear() {
		m_nHash = EMPTY;
	}
}
