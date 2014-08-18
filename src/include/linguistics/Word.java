package include.linguistics;

public final class Word {
	public final static int UNKNOWN = 0;
	public final static int EMPTY = 1;
	
	public static StringTokenizer tokenizer = new StringTokenizer();
	
	protected int m_nHash;
	
	public Word() {
		m_nHash = EMPTY;
	}
	
	public Word(final String s) {
		m_nHash = tokenizer.lookup(s);
	}
	
	public Word(final Word w) {
		m_nHash = w.m_nHash;
	}
	
	public Word(final int n) {
		m_nHash = n;
	}
	
	@Override
	public int hashCode() {
		return m_nHash;
	}
	
	@Override
	public boolean equals(final Object o) {
		return m_nHash == ((Word)o).m_nHash;
	}
	
	public void setString(final String s) {
		m_nHash = tokenizer.find(s, UNKNOWN);
	}
	
	public void load(final String s) {
		m_nHash = tokenizer.lookup(s);
	}
	
	@Override
	public String toString() {
		return tokenizer.key(m_nHash);
	}
	
	public boolean empty() {
		return m_nHash == EMPTY;
	}
	
	public boolean unknown() {
		return m_nHash == UNKNOWN;
	}
}
