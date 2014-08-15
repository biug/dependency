package include.linguistics;

public class CWord {
	protected String m_sString;
	
	public CWord() {
		m_sString = "";
	}
	
	public CWord(final String s) {
		m_sString = s;
	}
	
	public CWord(final CWord w) {
		m_sString = w.m_sString;
	}
	
	@Override
	public int hashCode() {
		return m_sString.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		return m_sString.equals(((CWord)o).m_sString);
	}
	
	public void setString(final String s) {
		m_sString = s;
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
