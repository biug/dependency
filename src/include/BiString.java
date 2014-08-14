package include;


public class BiString extends Bigram<String> {

	@Override
	protected String create_unigram(String u) {
		return new String("");
	}
	
	public BiString() {
		m_unigram1 = "";
		m_unigram2 = "";
	}
	
	public BiString(String s1, String s2) {
		m_unigram1 = new String(s1);
		m_unigram2 = new String(s2);
	}

}
