package common.parser;

import common.parser.implementations.arceager.Macros;

public class SuperTag {
	public static final int HL = 0;
	public static final int HR = 1;
	public static final int DL = 2;
	public static final int DR = 3;
	public static final int RT = 4;
	
	protected int[] m_tags;
	protected int m_size;
	
	public SuperTag() {
		m_tags = new int[Macros.MAX_SENTENCE_SIZE];
	}
	
	public boolean canShift(final int dep) {
		return (m_tags[dep] & (1 << HR)) != 0;
	}
	
	public boolean canArcLeft(final int head, final int dep) {
		return ((m_tags[head] & (1 << DL)) | (m_tags[dep] & (1 << HR))) != 0;
	}
	
	public boolean canArcRight(final int head, final int dep) {
		return ((m_tags[head] & (1 << DR)) | (m_tags[dep] & (1 << HL))) != 0;
	}
	
	public void setSentenceSize(final int size) {
		m_size = size;
	}
	
	public final int getSentenceSize() {
		return m_size;
	}
}
