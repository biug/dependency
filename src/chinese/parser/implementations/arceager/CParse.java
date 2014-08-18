package chinese.parser.implementations.arceager;

import include.SentenceReader;
import include.linguistics.TwoStringVector;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import common.parser.LabeledDependencyParser;

public final class CParse {
	public void process(final String sInputFile, final String sOutputFile, final String sFeatureFile, final int nBest, final boolean bScores) {
		System.out.println("Parsing started");
		
		long time_start = System.currentTimeMillis();
		
		CDepParser parser = new CDepParser(sFeatureFile, false);
		SentenceReader input_reader = new SentenceReader(sInputFile);
		try {
			BufferedWriter os = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(sOutputFile)), "UTF-8"));
			BufferedWriter os_scores = null;
			int[] scores = null;
			TwoStringVector input_sent = new TwoStringVector();
			LabeledDependencyParser[] output_sent = null;
			
			if (bScores) {
				scores = new int[nBest];
				os_scores = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(sOutputFile + ".scores")), "UTF-8"));
			}
			
			output_sent = new LabeledDependencyParser[nBest];
			for (int index = 0; index < nBest; ++index) {
				output_sent[index] = new LabeledDependencyParser();
			}
			
			while (input_reader.readTaggedSentence(input_sent, "_")) {
				if (input_sent.size() > CMacros.MAX_SENTENCE_SIZE) {
					for (int index = 0; index < nBest; ++index) {
						output_sent[index].clear();
						if (bScores) {
							scores[index] = 0;
						}
					}
				} else {
					parser.parse(input_sent, output_sent, nBest, scores);
				}
				for (int index = 0; index < nBest; ++index) {
					output_sent[index].writeSentenceToOutputStream(os);
					if (bScores) {
						os_scores.write(scores[index]);
						os_scores.newLine();
					}
				}
			}
			os.close();
			if (bScores) {
				os_scores.close();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Parsing has finished successfully. Total time taken is: " + ((System.currentTimeMillis() - time_start) / 1000.0));
	}
}
