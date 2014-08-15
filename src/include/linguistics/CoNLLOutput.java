package include.linguistics;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class CoNLLOutput extends ArrayList<CoNLLOutputNode> {
	public CoNLLOutput() {
		super();
		this.clear();
	}
	
	public void clear() {
		super.clear();
		super.add(new CoNLLOutputNode(0, "", "", "-BEGIN-", "-BEGIN-", "", DependencyTreeNode.DEPENDENCY_LINK_NO_HEAD, "", DependencyTreeNode.DEPENDENCY_LINK_NO_HEAD, ""));
	}
	
	public void copy(final CoNLLOutput input) {
		if (this.size() > input.size()) {
			this.removeRange(this.size(), input.size());
		}
		for (int i = 0; i < this.size(); ++i) {
			this.set(i, input.get(i));
		}
	}
	
	public void fromCoNLLInput(final CoNLLInput input) {
		if (this.size() > input.size()) {
			this.removeRange(this.size(), input.size());
		}
		for (int i = 0; i < this.size(); ++i) {
			this.set(i, (CoNLLOutputNode)(input.get(i)));
		}
	}
	
	public void copyDependencyHeads(final DependencyTree input) {
		for (int i = 0; i < input.size(); ++i) {
			this.get(i).head = input.get(i).head;
		}
	}
	
	public void copyDependencyHeads(final LabeledDependencyTree input) {
		for (int i = 0; i < input.size(); ++i) {
			this.get(i).head = input.get(i).head;
			this.get(i).label = input.get(i).label;
		}
	}
	
	public void toDependencyTree(final DependencyTree out) {
		out.clear();
		for (int i = 0; i < this.size(); ++i) {
			out.add(new DependencyTreeNode(this.get(i).word, this.get(i).tag, this.get(i).head));
		}
	}
	
	public void toDependencyTree(final LabeledDependencyTree out) {
		out.clear();
		for (int i = 0; i < this.size(); ++i) {
			out.add(new LabeledDependencyTreeNode(this.get(i).word, this.get(i).tag, this.get(i).head, this.get(i).label));
		}
	}
	
	public void toLabeledDependencyTree(final LabeledDependencyTree out) {
		out.clear();
		for (int i = 0; i < this.size(); ++i) {
			out.add(new LabeledDependencyTreeNode(this.get(i).word, this.get(i).tag, this.get(i).head, this.get(i).label));
		}
	}
}
