package include.linguistics;

import chinese.dependency.label.CDependencyLabel;

public class CSetOfTags {
	private int h_code;
	
	public void print(String s) {
		System.out.print(s + "[ ");
		for (int label = 0; label < CDependencyLabel.COUNT; ++label) {
			if (this.contains(label)) System.out.print(CDependencyLabel.str(label) + " ");
		}
		System.out.print("]");
	}
	
	public CSetOfTags() {
		h_code = 0;
	}
	
	public CSetOfTags(final CSetOfTags tags) {
		h_code = tags.h_code;
	}
	
	public void add(final CDependencyLabel tag) {
		h_code |= (1 << tag.hashCode());
	}
	
	public void add(final int code) {
		h_code |= (1 << code);
	}
	
	public void remove(final CDependencyLabel tag) {
		h_code &= ~(1 << tag.hashCode());
	}
	
	public void remove(final int code) {
		h_code &= ~(1 << code);
	}
	
	public void clear() {
		h_code = 0;
	}
	
	public boolean contains(final CDependencyLabel tag) {
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
	public boolean equals(Object o) {
		return h_code == ((CSetOfTags)o).h_code;
	}
	
	public void set(CSetOfTags csot) {
		h_code = csot.h_code;
	}
}
