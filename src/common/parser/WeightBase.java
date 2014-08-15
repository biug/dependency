package common.parser;

public abstract class WeightBase {
	protected boolean m_bTrain;
	protected boolean m_bModified;
	protected String m_sRecordPath;
	protected boolean m_bRules;
	
	public WeightBase(final String sFile, boolean bTrain) {
		m_bTrain = bTrain;
		m_sRecordPath = sFile;
		m_bRules = false;
		m_bModified = false;
	}
	
	public void setRules(final boolean bRules) {
		m_bRules = bRules;
	}
	
	public boolean rules() {
		return m_bRules;
	}
	
	public abstract void loadScores();
	public abstract void saveScores();
}
