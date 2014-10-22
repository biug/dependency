package include.linguistics.english;

import java.util.HashSet;
import java.util.Set;

import english.dependency.label.EDependencyLabel;

public final class ESetOfLabels {
	private Set<Integer> s_labset;
	
	public void print(final String s) {
		System.out.print(s + "[ ");
		for (Integer lab : s_labset) {
			System.out.print(EDependencyLabel.str(lab.intValue()) + " ");
		}
		System.out.print("]");
	}
	
	public ESetOfLabels() {
		s_labset = new HashSet<Integer>();
	}
	
	public ESetOfLabels(final ESetOfLabels tags) {
		s_labset.clear();
		s_labset.addAll(tags.s_labset);
	}
	
	public void add(final EDependencyLabel tag) {
		s_labset.add(new Integer(tag.hashCode()));
	}
	
	public void add(final int code) {
		s_labset.add(new Integer(code));
	}
	
	public void remove(final EDependencyLabel tag) {
		s_labset.remove(new Integer(tag.hashCode()));
	}
	
	public void remove(final int code) {
		s_labset.remove(new Integer(code));
	}
	
	public void clear() {
		s_labset.clear();
	}
	
	public boolean contains(final EDependencyLabel tag) {
		return s_labset.contains(new Integer(tag.hashCode()));
	}
	
	public boolean contains(final int code) {
		return s_labset.contains(new Integer(code));
	}
	
	@Override
	public int hashCode() {
		return s_labset.hashCode();
	}
	
	@Override
	public boolean equals(final Object o) {
		return s_labset.equals(((ESetOfLabels)o).s_labset);
	}
	
	public void set(final ESetOfLabels tagset) {
		s_labset.clear();
		s_labset.addAll(tagset.s_labset);
	}
}
