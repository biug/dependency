package include;

public abstract class Bigram<Unigram> {

	protected int m_nHash;
	protected Unigram m_unigram1;
	protected Unigram m_unigram2;
	protected boolean m_bAllocated;
	
	protected abstract Unigram create_unigram(Unigram u);
	
	public Bigram() {
		m_nHash = 0;
		m_unigram1 = null;
		m_unigram2 = null;
		m_bAllocated = false;
	}
	
	public Bigram(final Bigram<Unigram> w) {
		if (w.m_bAllocated) {
			m_unigram1 = create_unigram(w.m_unigram1);
			m_unigram2 = create_unigram(w.m_unigram2);
			m_nHash = w.m_nHash;
			m_bAllocated = true;
		} else {
			m_unigram1 = w.m_unigram1;
			m_unigram2 = w.m_unigram2;
			m_nHash = w.m_nHash;
			m_bAllocated = false;
		}
	}
	
	public void allocate(final Unigram w1, final Unigram w2) {
		clear();
		m_unigram1 = create_unigram(w1);
		m_unigram2 = create_unigram(w2);
		computehash();
		m_bAllocated = true;
	}
	
	public void refer(final Unigram s1, final Unigram s2) {
		m_unigram1 = s1;
		m_unigram2 = s2;
		computehash();
		m_bAllocated = false;
	}
	
	public void clear() {
		m_nHash = 0;
		m_unigram1 = null;
		m_unigram2 = null;
		m_bAllocated = false;
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
