package include.linguistics;

public class CoNLLOutputNode extends CoNLLInputNode {
	public int head;
	public String label;
	public int phead;
	public String plabel;
	
	public CoNLLOutputNode() {
		head = DependencyTreeNode.DEPENDENCY_LINK_NO_HEAD;
		phead = DependencyTreeNode.DEPENDENCY_LINK_NO_HEAD;
	}
	
	public CoNLLOutputNode(final int d, final String w, final String l, final String c, final String t, final String f, final int h, final String la, final int p, final String pl) {
		super(d, w, l, c, t, f);
		head = h;
		label = la;
		phead = p;
		plabel = pl;
	}
}
