package common.parser;

import include.linguistics.LabeledDependencyTree;
import include.linguistics.LabeledDependencyTreeNode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Iterator;

@SuppressWarnings("serial")
public final class LabeledDependencyParser extends LabeledDependencyTree {
	public boolean readSentenceFromInputStream(BufferedReader br) throws IOException {
		this.clear();
		String line;
		line = br.readLine();
		while (line != null && !line.isEmpty()) {
			String[] args = line.split("\t");
			this.add(new LabeledDependencyTreeNode(args[0], args[1], Integer.parseInt(args[2]), args[3]));
			line = br.readLine();
		}
		return line != null;
	}
	public void writeSentenceToOutputStream(BufferedWriter bw) throws IOException {
		Iterator<LabeledDependencyTreeNode> itr = this.iterator();
		while (itr.hasNext()) {
			LabeledDependencyTreeNode node = itr.next();
			bw.write(node.toString());
			bw.newLine();
		}
		bw.newLine();
	}
}
