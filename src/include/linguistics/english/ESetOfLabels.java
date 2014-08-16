package include.linguistics.english;

import english.dependency.label.EDependencyLabel;

public final class ESetOfLabels {
	private int h_code;
	
	public void print(final String s) {
		System.out.print(s + "[ ");
		for (int label = 0; label < EDependencyLabel.COUNT; ++label) {
			if (this.contains(label)) System.out.print(EDependencyLabel.str(label) + " ");
		}
		System.out.print("]");
	}
	
	public ESetOfLabels() {
		h_code = 0;
	}
	
	public ESetOfLabels(final ESetOfLabels tags) {
		h_code = tags.h_code;
	}
	
	public void add(final EDependencyLabel tag) {
		h_code |= (1 << tag.hashCode());
	}
	
	public void add(final int code) {
		h_code |= (1 << code);
	}
	
	public void remove(final EDependencyLabel tag) {
		h_code &= ~(1 << tag.hashCode());
	}
	
	public void remove(final int code) {
		h_code &= ~(1 << code);
	}
	
	public void clear() {
		h_code = 0;
	}
	
	public boolean contains(final EDependencyLabel tag) {
		return (h_code & (1 << tag.hashCode())) != 0;
	}
	
	public boolean contains(final int code) {
		return (h_code & (1 << code)) != 0;
	}
	
	@Override
	public int hashCode() {
		return h_code;
	}
	
	@Override
	public boolean equals(final Object o) {
		return h_code == ((ESetOfLabels)o).h_code;
	}
	
	public void set(final ESetOfLabels tagset) {
		h_code = tagset.h_code;
	}
}
