package common.parser;

import include.linguistics.LabeledDependencyTree;
import include.linguistics.LabeledDependencyTreeNode;

import java.io.BufferedReader;
import java.io.IOException;

@SuppressWarnings("serial")
public class LabeledDependencyParser extends LabeledDependencyTree {
	public boolean readSentenceFromInputStream(BufferedReader br) throws IOException {
		this.clear();
		String line;
		line = br.readLine();
		while (line != null && !line.isEmpty()) {
			String[] args = line.split("\\s+");
			this.add(new LabeledDependencyTreeNode(args[0], args[1], Integer.parseInt(args[2]), args[3]));
			line = br.readLine();
		}
		return line != null;
	}
}
