package include.learning.perceptron;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

@SuppressWarnings("serial")
// remove "m_zero"
public abstract class PackedScoreMap<K> extends HashMap<K, PackedScore> {
	public static final String sSplit = ",";
	
	public String name;
	public int count;

	public PackedScoreMap(String input_name, int table_size) {
		super();
		name = input_name;
		count = 0;
	}
	
	public void getScore(PackedScoreType o, final K key, final int which) {
		PackedScore ps = super.get(key);
		if (ps != null) {
			ps.add(o, which);
		}
	}
	
	public void updateScore(final K key, final int index, final int amount, final int round) {
		PackedScore ps = super.get(key);
		if (ps == null) {
			ps = new PackedScore();
			super.put(allocate_key(key), ps);
		}
		ps.updateCurrent(index, amount, round);
	}
	
	public void getOrUpdateScore(PackedScoreType out, final K key, final int index, final int which, final int amount, final int round) {
		if (amount == 0) {
			PackedScore ps = super.get(key);
			if (ps != null) {
				ps.add(out, which);
			}
		} else {
			this.updateScore(key, index, amount, round);
		}
	}
	
	public void getOrUpdateScore(PackedScoreType out, final K key, final int index, final int which, final int amount) {
		this.getOrUpdateScore(out, key, index, which, amount, 0);
	}
	
	public void getOrUpdateScore(PackedScoreType out, final K key, final int index, final int which) {
		this.getScore(out, key, which);
	}
	
	public void computeAverage(int round) {
		count = 0;
		Iterator<java.util.Map.Entry<K, PackedScore>> iter = this.entrySet().iterator();
		while (iter.hasNext()) {
			java.util.Map.Entry<K, PackedScore> entry = iter.next();
			((entry.getValue())).updateAverage(round);
			++count;
		}
	}
	
	public void clearScore() {
		Iterator<java.util.Map.Entry<K, PackedScore>> iter = this.entrySet().iterator();
		while (iter.hasNext()) {
			java.util.Map.Entry<K, PackedScore> entry = iter.next();
			((entry.getValue())).reset();
		}
	}
	
	public void loadScoresFromFileStream(BufferedReader br) throws IOException {
		String s = br.readLine();
		if (!(s.substring(0, this.name.length()).equals(this.name))) {
			System.out.println("score_map " + this.name + " not matched");
			return;
		}
		while (!(s = br.readLine()).isEmpty()) {
			int colon_index = s.indexOf(":");
			K key = loadKeyFromString(s.substring(0, colon_index - 1));
			PackedScore ps = new PackedScore();
			ps.loadPackedScoreFromString(s.substring(colon_index + 2));
			super.put(key, ps);
		}
	}
	
	public void saveScoresToFileStream(BufferedWriter bw) throws IOException {
		if (this.count != 0) {
			bw.write(this.name + " " + this.count);
		} else {
			bw.write(this.name);
		}
		bw.newLine();
		Iterator<java.util.Map.Entry<K, PackedScore>> itr = super.entrySet().iterator();
		while (itr.hasNext()) {
			java.util.Map.Entry<K, PackedScore> entry = itr.next();
			if (!entry.getValue().empty()) {
				bw.write(generateStringFromKey(entry.getKey()));
				bw.write("\t:\t");
				entry.getValue().savePackedScoreToFile(bw);
				bw.newLine();
			}
		}
		bw.newLine();
	}
	
	public abstract K allocate_key(K key);
	public abstract K loadKeyFromString(String str);
	public abstract String generateStringFromKey(K key);
}
