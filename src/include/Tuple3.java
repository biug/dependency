package include;

public abstract class Tuple3<A, B, C> {
	protected int m_nHash;
	protected A m_object1;
	protected B m_object2;
	protected C m_object3;
	protected boolean m_bAllocated;
	
	public abstract A create_object1(A a);
	public abstract B create_object2(B b);
	public abstract C create_object3(C c);
	
	public Tuple3() {
		m_nHash = 0;
		m_object1 = null;
		m_object2 = null;
		m_object3 = null;
		m_bAllocated = false;
	}
	
	public Tuple3(Tuple3<A, B, C> w) {
		m_nHash = w.m_nHash;
		if (w.m_bAllocated) {
			m_object1 = create_object1(w.m_object1);
			m_object2 = create_object2(w.m_object2);
			m_object3 = create_object3(w.m_object3);
			m_bAllocated = true;
		} else {
			m_object1 = w.m_object1;
			m_object2 = w.m_object2;
			m_object3 = w.m_object3;
			m_bAllocated = false;
		}
	}
	
	public void allocate(final A w1, final B w2, final C w3) {
		clear();
		m_object1 = create_object1(w1);
		m_object2 = create_object2(w2);
		m_object3 = create_object3(w3);
		computehash();
		m_bAllocated = true;
	}
	
	public void refer(final A w1, final B w2, final C w3) {
		m_object1 = w1;
		m_object2 = w2;
		m_object3 = w3;
		computehash();
		m_bAllocated = false;
	}
	
	public void clear() {
		m_bAllocated = false;
		m_object1 = null;
		m_object2 = null;
		m_object3 = null;
		m_nHash = 0;
	}
	
	public A first() {
		return m_object1;
	}
	
	public B second() {
		return m_object2;
	}
	
	public C third() {
		return m_object3;
	}
	
	@Override
	public int hashCode() {
		return m_nHash;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		return m_object1.equals(((Tuple3<A, B, C>)o).m_object1) &&
				m_object2.equals(((Tuple3<A, B, C>)o).m_object2) &&
				m_object3.equals(((Tuple3<A, B, C>)o).m_object3);
	}
	
	protected void computehash() {
		m_nHash = (m_object1.hashCode() << 5) - m_object1.hashCode() +
				(m_object2.hashCode() << 5) - (m_object2.hashCode() << 1) - m_object2.hashCode() +
				m_object3.hashCode(); 
	}
}
