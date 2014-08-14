package main;

public class Test {
	public int m;
	public int n;
	
	public Test() {
		m = 0;
		n = 0;
	}
	
	public Test(int m0, int n0) {
		m = m0;
		n = n0;
	}
	
	public void increase() {
		++m;
		++n;
	}
}
