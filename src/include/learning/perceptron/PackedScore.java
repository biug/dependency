package include.learning.perceptron;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class PackedScore {
	public LinkedHashMap<Integer, Score> scores;
	
	public PackedScore() {
		scores = new LinkedHashMap<Integer, Score>();
	}
	
	public int score(final int index, final int n) {
		Score s = scores.get(new Integer(index));
		if (s != null) {
			return s.score(n);
		} else {
			return 0;
		}
	}
	
	public void updateCurrent(final int index, final int added, final int round) {
		Integer i = new Integer(index);
		Score s = scores.get(i);
		if (s == null) {
			s = new Score();
			scores.put(i, s);
		}
		s.updateCurrent(added, round);
	}
	
	public void updateAverage(final int round) {
		Iterator<Entry<Integer, Score>> itr = scores.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<Integer, Score> entry = (Entry<Integer, Score>)itr.next();
			((entry.getValue())).updateAverage(round);
		}
	}
	
	public void reset() {
		Iterator<Entry<Integer, Score>> itr = scores.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<Integer, Score> entry = (Entry<Integer, Score>)itr.next();
			((entry.getValue())).reset();
		}
	}
	
	public boolean empty() {
		Iterator<Entry<Integer, Score>> itr = scores.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<Integer, Score> entry = (Entry<Integer, Score>)itr.next();
			if (!(entry.getValue()).zero()) {
				return false;
			}
		}
		return true;
	}
	
	public void add(PackedScoreType o, final int which) {
		Iterator<Entry<Integer, Score>> itr = scores.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<Integer, Score> entry = (Entry<Integer, Score>)itr.next();
			o.addOne(entry.getKey().intValue(), entry.getValue().score(which));
		}
	}
	
	public Score find(final int index) {
		Score s = scores.get(new Integer(index));
		if (s == null) {
			s = new Score();
			scores.put(new Integer(index), s);
		}
		return s;
	}
	
	public void loadPackedScoreFromString(String str) {
		String[] args = str.split("#");
		scores.put(new Integer(Integer.parseInt(args[0])),
				new Score(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
	}
	
	public void savePackedScoreToFile(BufferedWriter bw) throws IOException {
		Iterator<Entry<Integer, Score>> itr = scores.entrySet().iterator();
		bw.write("{ ");
		boolean notstart = false;
		while (itr.hasNext()) {
			Entry<Integer, Score> entry = (Entry<Integer, Score>)itr.next();
			if (!entry.getValue().zero()) {
				if (notstart) bw.write(" , ");
				notstart = true;
				bw.write(entry.getKey().intValue() + " : " + entry.getValue().current + " / " + entry.getValue().total);
			}
		}
		bw.write(" }");
	}
	
}
