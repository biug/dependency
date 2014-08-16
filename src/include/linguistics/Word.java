package include.linguistics;

public class Word {
	protected String m_sString;
	
	public Word() {
		m_sString = "";
	}
	
	public Word(final String s) {
		m_sString = s;
	}
	
	public Word(final Word w) {
		m_sString = w.m_sString;
	}
	
	@Override
	public int hashCode() {
		return m_sString.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		return m_sString.equals(((Word)o).m_sString);
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
