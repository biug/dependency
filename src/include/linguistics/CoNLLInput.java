package include.linguistics;

import include.BiString;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class CoNLLInput extends ArrayList<CoNLLInputNode> {
	public CoNLLInput() {
		super();
		this.clear();
	}
	
	public void clear() {
		super.clear();
		super.add(new CoNLLInputNode(0, "", "", "-BEGIN-", "-BEGIN-", ""));
	}
	
	public void toTwoStringVector(TwoStringVector out) {
		out.clear();
		for (int i = 0; i < this.size(); ++i) {
			out.add(new BiString(this.get(i).word, this.get(i).tag));
		}
	}
}
