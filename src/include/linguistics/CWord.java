package include.linguistics;

public class CWord {
	protected int m_nHash;
	protected String m_sString;
	
	public CWord() {
		m_nHash = "".hashCode();
		m_sString = new String("");
	}
	
	public CWord(final String s) {
		m_nHash = s.hashCode();
		m_sString = new String(s);
	}
	
	public CWord(final CWord w) {
		m_nHash = w.m_nHash;
		m_sString = new String(w.m_sString);
	}
	
	@Override
	public int hashCode() {
		return m_nHash;
	}
	
	@Override
	public boolean equals(Object o) {
		return m_sString.equals(((CWord)o).m_sString);
	}
	
	public void setString(final String s) {
		m_nHash = s.hashCode();
		m_sString = new String(s);
	}
	
	@Override
	public String toString() {
		return m_sString;
	}
	
	public boolean empty() {
		return m_sString.isEmpty();
	}
	
	public boolean unknown() {
		return false;
	}
}
