package main;

import java.io.IOException;

import common.parser.Parse;
import common.parser.Train;

public class Main {
	public static void train(String sInputFile, String sFeatureFile, int nRound) {
		long start = System.currentTimeMillis();
		Train train = new Train();
		final int training_rounds = nRound;
		System.out.println("Training started");
		for (int i = 0; i < training_rounds; ++i) {
			try {
				train.auto_train(sInputFile, sFeatureFile, false);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.print("Training has finished successfully. ");
		System.out.println("Total time taken is: " + ((System.currentTimeMillis() - start) / 1000.0));
	}
	public static void parse(String sInputFile, String sOutputFile, String sFeatureFile) {
		Parse parse = new Parse();
		parse.process(sInputFile, sOutputFile, sFeatureFile, 1, false);
	}
	public static void main(String[] args) {
		if (args[0].equals("train")) {
			train(args[1], args[2], Integer.parseInt(args[3]));
		} else if (args[0].equals("parse")) {
			parse(args[1], args[2], args[3]);
		}
	}
}
