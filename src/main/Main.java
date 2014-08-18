package main;

import java.io.IOException;

import chinese.parser.implementations.arceager.CParse;
import chinese.parser.implementations.arceager.CTrain;
import english.parser.implementations.arceager.EParse;
import english.parser.implementations.arceager.ETrain;

public class Main {
	public static void entrain(final String sInputFile, final String sFeatureFile, final int nRound) {
		long start = System.currentTimeMillis();
		ETrain train = new ETrain();
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
	public static void enparse(final String sInputFile, final String sOutputFile, final String sFeatureFile) {
		EParse parse = new EParse();
		parse.process(sInputFile, sOutputFile, sFeatureFile, 1, false);
	}
	public static void chtrain(final String sInputFile, final String sFeatureFile, final int nRound) {
		long start = System.currentTimeMillis();
		CTrain train = new CTrain();
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
	public static void chparse(final String sInputFile, final String sOutputFile, final String sFeatureFile) {
		CParse parse = new CParse();
		parse.process(sInputFile, sOutputFile, sFeatureFile, 1, false);
	}
	public static void main(String[] args) {
		if (args[0].equals("en")) {
			if (args[1].equals("train")) {
				entrain(args[2], args[3], Integer.parseInt(args[4]));
			} else if (args[1].equals("parse")) {
				enparse(args[2], args[3], args[4]);
			}
		}
		if (args[0].equals("ch")) {
			if (args[1].equals("train")) {
				chtrain(args[2], args[3], Integer.parseInt(args[4]));
			} else if (args[1].equals("parse")) {
				chparse(args[2], args[3], args[4]);
			}
		}
	}
}
