package include;

public abstract class Bigram<Unigram> {

	protected int m_nHash;
	protected Unigram m_unigram1;
	protected Unigram m_unigram2;
	
	protected abstract Unigram create_unigram(Unigram u);
	
	public Bigram() {
		m_nHash = 0;
		m_unigram1 = null;
		m_unigram2 = null;
	}
	
	public Bigram(Bigram<Unigram> bi) {
		m_unigram1 = create_unigram(bi.m_unigram1);
		m_unigram2 = create_unigram(bi.m_unigram2);
		computehash();
	}
	
	public Bigram(final Unigram u1, final Unigram u2) {
		m_unigram1 = create_unigram(u1);
		m_unigram2 = create_unigram(u2);
		computehash();
	}
	
	public void refer(final Unigram s1, final Unigram s2) {
		m_unigram1 = s1;
		m_unigram2 = s2;
		computehash();
	}
	
	public final Unigram first() {
		return m_unigram1;
	}
	
	public final Unigram second() {
		return m_unigram2;
	}
	
	@Override
	public int hashCode() {
		return m_nHash;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		return m_unigram1.equals(((Bigram<Unigram>)o).m_unigram1) &&
				m_unigram2.equals(((Bigram<Unigram>)o).m_unigram2);
	}
	
	protected void computehash() {
		m_nHash = (m_unigram1.hashCode() << 5) - m_unigram1.hashCode() + m_unigram2.hashCode();
	}
}
