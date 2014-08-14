package include;

import java.util.LinkedHashMap;
import java.util.Vector;

public class Tokenizer {
	
	protected LinkedHashMap<String, Integer> m_mapTokens;
	protected Vector<String> m_vecKeys;
	protected int m_nWaterMark;
	protected int m_nStartingToken;
	
	public Tokenizer(int nTokenStartsFrom) {
		m_vecKeys = new Vector<String>();
		m_mapTokens = new LinkedHashMap<String, Integer>();
		m_nWaterMark = m_nStartingToken = nTokenStartsFrom;
	}
	
	public int lookup(final String key) {
		int retval;
		boolean bNew = m_mapTokens.containsKey(key);
		if (bNew) {
			retval = m_mapTokens.get(key);
		} else {
			retval = m_nWaterMark;
			m_mapTokens.put(key, new Integer(retval));
		}
		return retval;
	}
	
	public int find(final String key, final int val) {
		if (m_mapTokens.containsKey(key)) {
			return m_mapTokens.get(key);
		} else {
			return val;
		}
	}
	
	public final String key(final int token) {
		return m_vecKeys.get(token - m_nStartingToken);
	}
	
	public final int count() {
		return m_nWaterMark;
	}
}
