package include.linguistics;

public class DependencyTreeNode {
	public static final int DEPENDENCY_LINK_NO_HEAD = -1;
	
	public String word;
	public String tag;
	public int head;
	
	public DependencyTreeNode() {
		word = new String("");
		tag = new String("");
		head = DEPENDENCY_LINK_NO_HEAD;
	}
	
	public DependencyTreeNode(final String w, final String t, final int h) {
		word = new String(w);
		tag = new String(t);
		head = h;
	}
	
	@Override
	public boolean equals(Object o) {
		return word.equals(((DependencyTreeNode)o).word) &&
				tag.equals(((DependencyTreeNode)o).tag) &&
				head == ((DependencyTreeNode)o).head;
	}
}
