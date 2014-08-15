package main;

import java.io.IOException;

import common.parser.Train;

public class Main {	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Train train = new Train();
		final int training_rounds = Integer.parseInt(args[2]);
		System.out.println("Training started");
		for (int i = 0; i < training_rounds; ++i) {
			try {
				train.auto_train(args[0], args[1], false);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Training has finished successfully.");
		System.out.println("total use " + (System.currentTimeMillis() - start) / 1000.0 + " ms");
	}
}
