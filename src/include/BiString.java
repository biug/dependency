package include;


public class BiString extends Bigram<String> {
	
	public BiString(String s1, String s2) {
		m_unigram1 = s1;
		m_unigram2 = s2;
	}

	@Override
	protected final String create_unigram(String u) {
		return u;
	}

}
