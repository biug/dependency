package include.linguistics;

public final class LabeledDependencyTreeNode extends DependencyTreeNode {
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
	public final boolean equals(final Object o) {
		return super.equals(o) && label.equals(((LabeledDependencyTreeNode)o).label);
	}
	
	@Override
	public final String toString() {
		return word + "\t" + tag +  "\t" + Integer.toString(head) + "\t" + label;
	}
}
