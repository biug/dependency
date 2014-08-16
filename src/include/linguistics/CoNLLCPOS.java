package include.linguistics;


public final class CoNLLCPOS extends GenericTag {

	public static GenericTagset tagset = new GenericTagset();
	
	public CoNLLCPOS() {
		super();
	}
	
	public CoNLLCPOS(final String s) {
		load(s);
	}
	
	public CoNLLCPOS(final int i) {
		super(i);
	}
	
	public CoNLLCPOS(final CoNLLCPOS c) {
		super(c);
	}
	
	@Override
	public void load(final String s) {
		if (s.isEmpty()) {
			m_code = NONE;
		} else {
			m_code = tagset.lookup(s);
		}
	}
	
	@Override
	public String toString() {
		return tagset.key(m_code);
	}

}
