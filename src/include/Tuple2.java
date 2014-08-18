package include;

public abstract class Tuple2<A, B> {
	protected int m_nHash;
	protected A m_object1;
	protected B m_object2;
	
	public abstract A create_object1(final A a);
	public abstract B create_object2(final B b);
	
	public Tuple2() {
		m_nHash = 0;
		m_object1 = null;
		m_object2 = null;
	}
	
	public Tuple2(final Tuple2<A, B> tuple) {
		m_object1 = create_object1(tuple.m_object1);
		m_object2 = create_object2(tuple.m_object2);
		computehash();
	}
	
	public Tuple2(final A w1, final B w2) {
		m_object1 = create_object1(w1);
		m_object2 = create_object2(w2);
		computehash();
	}
	
	public final void refer(final A w1, final B w2) {
		m_object1 = w1;
		m_object2 = w2;
		computehash();
	}
	
	public final A first() {
		return m_object1;
	}
	
	public final B second() {
		return m_object2;
	}
	
	@Override
	public final int hashCode() {
		return m_nHash;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public final boolean equals(final Object o) {
		Tuple2<A, B> tuple = (Tuple2<A, B>)o;
		return m_object1.equals(tuple.m_object1) &&
				m_object2.equals(tuple.m_object2);
	}
	
	protected final void computehash() {
		m_nHash = (m_object1.hashCode() << 5) - m_object1.hashCode() + m_object2.hashCode(); 
	}
}
