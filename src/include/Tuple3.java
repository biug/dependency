package include;

public abstract class Tuple3<A, B, C> {
	protected int m_nHash;
	protected A m_object1;
	protected B m_object2;
	protected C m_object3;
	
	public abstract A create_object1(A a);
	public abstract B create_object2(B b);
	public abstract C create_object3(C c);
	
	public Tuple3() {
		m_nHash = 0;
		m_object1 = null;
		m_object2 = null;
		m_object3 = null;
	}
	
	public Tuple3(final Tuple3<A, B, C> tuple) {
		m_object1 = create_object1(tuple.m_object1);
		m_object2 = create_object2(tuple.m_object2);
		m_object3 = create_object3(tuple.m_object3);
		computehash();
	}
	
	public Tuple3(final A w1, final B w2, final C w3) {
		m_object1 = create_object1(w1);
		m_object2 = create_object2(w2);
		m_object3 = create_object3(w3);
		computehash();
	}
	
	public final void refer(final A w1, final B w2, final C w3) {
		m_object1 = w1;
		m_object2 = w2;
		m_object3 = w3;
		computehash();
	}
	
	public final A first() {
		return m_object1;
	}
	
	public final B second() {
		return m_object2;
	}
	
	public final C third() {
		return m_object3;
	}
	
	@Override
	public final int hashCode() {
		return m_nHash;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public final boolean equals(final Object o) {
		Tuple3<A, B, C> tuple = (Tuple3<A, B, C>)o;
		return m_object1.equals(tuple.m_object1) &&
				m_object2.equals(tuple.m_object2) &&
				m_object3.equals(tuple.m_object3);
	}
	
	protected final void computehash() {
		m_nHash = (m_object1.hashCode() << 5) - m_object1.hashCode() +
				(m_object2.hashCode() << 5) - (m_object2.hashCode() << 1) - m_object2.hashCode() +
				m_object3.hashCode(); 
	}
}
