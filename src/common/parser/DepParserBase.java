package common.parser;

import include.linguistics.TwoStringVector;

public abstract class DepParserBase {
	protected WeightBase m_weights;
	
	protected boolean m_bTrain;
	protected boolean m_bCoNLL;
	
	protected SuperTag m_supertags;
	
	public DepParserBase(final String sFeatureDBPath, final boolean bTrain, final boolean bCoNLL) {
		m_bTrain = bTrain;
		m_bCoNLL = bCoNLL;
		m_supertags = null;
		m_weights = null;
	}
	
	public final void setRules(final boolean bRules) {
		m_weights.setRules(bRules);
	}
	
	public final void setSuperTags(final SuperTag supertags) {
		m_supertags = supertags;
	}
	
	public abstract void parse(final TwoStringVector sentence, final LabeledDependencyParser[] retval, final int nBest, long[] scores);
	public abstract void train(final LabeledDependencyParser correct, final int round);
	
	public abstract void finishtraning();
	
}
