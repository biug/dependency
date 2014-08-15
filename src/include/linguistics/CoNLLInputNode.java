package include.linguistics;

public class CoNLLInputNode extends DependencyTreeNode {
	public int id;
	public String word;
	public String lemma;
	public String ctag;
	public String tag;
	public String feats;
	
	public CoNLLInputNode() {
		id = -1;
	}
	
	public CoNLLInputNode(final int d, final String w, final String l, final String c, final String t, final String f) {
		id = d;
		word = w;
		lemma = l;
		ctag = c;
		tag = t;
		feats = f;
	}
}
