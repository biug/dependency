package include.linguistics;

public class LabeledDependencyTreeNode extends DependencyTreeNode {
	public String label;
	
	public LabeledDependencyTreeNode() {
		super();
		label = "";
	}
	
	public LabeledDependencyTreeNode(final String w, final String t, final int h, final String l) {
		super(w, t, h);
		label = l;
	}
	
	@Override
	public boolean equals(Object o) {
		return super.equals(o) && label.equals(((LabeledDependencyTreeNode)o).label);
	}
}
