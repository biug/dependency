package english.parser.implementations.arceager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import common.parser.WeightBase;
import common.parser.implementations.map.CoNLLCPOSMap;
import common.parser.implementations.map.CoNLLFeatsMap;
import common.parser.implementations.map.IntMap;
import common.parser.implementations.map.LemmaMap;
import common.parser.implementations.map.TwoWordsMap;
import common.parser.implementations.map.WordIntMap;
import common.parser.implementations.map.WordMap;
import common.parser.implementations.map.WordWordIntMap;

import english.dependency.label.EDependencyLabel;
import english.parser.implementations.map.ETagESetOfLabelsMap;
import english.parser.implementations.map.ETagETagIntMap;
import english.parser.implementations.map.ETagIntMap;
import english.parser.implementations.map.ETagMap;
import english.parser.implementations.map.ETagSet2Map;
import english.parser.implementations.map.ETagSet3Map;
import english.parser.implementations.map.ETaggedWordMap;
import english.parser.implementations.map.TwoETaggedWordsMap;
import english.parser.implementations.map.WordESetOfLabelsMap;
import english.parser.implementations.map.WordETagETagMap;
import english.parser.implementations.map.WordWordETagMap;

public final class EWeight extends WeightBase {
	public static final int DEP_TABLE_SIZE = 1 << 17;
	
	public WordMap m_mapSTw;
	public ETagMap m_mapSTt;
	public ETaggedWordMap m_mapSTwt;

	public WordMap m_mapN0w;
	public ETagMap m_mapN0t;
	public ETaggedWordMap m_mapN0wt;

	public WordMap m_mapN1w;
	public ETagMap m_mapN1t;
	public ETaggedWordMap m_mapN1wt;

	public WordMap m_mapN2w;
	public ETagMap m_mapN2t;
	public ETaggedWordMap m_mapN2wt;

	public WordMap m_mapSTHw;
	public ETagMap m_mapSTHt;
	public IntMap m_mapSTi;

	public WordMap m_mapSTHHw;
	public ETagMap m_mapSTHHt;
	public IntMap m_mapSTHi;

	public WordMap m_mapSTLDw;
	public ETagMap m_mapSTLDt;
	public IntMap m_mapSTLDi;

	public WordMap m_mapSTRDw;
	public ETagMap m_mapSTRDt;
	public IntMap m_mapSTRDi;

	public WordMap m_mapN0LDw;
	public ETagMap m_mapN0LDt;
	public IntMap m_mapN0LDi;

	public WordMap m_mapSTL2Dw;
	public ETagMap m_mapSTL2Dt;
	public IntMap m_mapSTL2Di;

	public WordMap m_mapSTR2Dw;
	public ETagMap m_mapSTR2Dt;
	public IntMap m_mapSTR2Di;

	public WordMap m_mapN0L2Dw;
	public ETagMap m_mapN0L2Dt;
	public IntMap m_mapN0L2Di;

	public WordMap m_mapHTw;
	public ETagMap m_mapHTt;
	public ETaggedWordMap m_mapHTwt;

	public TwoETaggedWordsMap m_mapSTwtN0wt;
	public WordWordETagMap m_mapSTwtN0w;
	public WordWordETagMap m_mapSTwN0wt;
	public WordETagETagMap m_mapSTtN0wt;
	public WordETagETagMap m_mapSTwtN0t;
	public TwoWordsMap m_mapSTwN0w;
	
	public ETagSet2Map m_mapSTtN0t;
	public ETagSet2Map m_mapN0tN1t;
	public ETagSet3Map m_mapN0tN1tN2t;
	public ETagSet3Map m_mapSTtN0tN1t;
	public ETagSet3Map m_mapSTtN0tN0LDt;
	public ETagSet3Map m_mapN0tN0LDtN0L2Dt;
	public ETagSet3Map m_mapSTHtSTtN0t;
	public ETagSet3Map m_mapHTtHT2tN0t;
	public ETagSet3Map m_mapSTHHtSTHtSTt;
	public ETagSet3Map m_mapSTtSTLDtN0t;
	public ETagSet3Map m_mapSTtSTLDtSTL2Dt;
	public ETagSet3Map m_mapSTtSTRDtN0t;
	public ETagSet3Map m_mapSTtSTRDtSTR2Dt;

	public WordIntMap m_mapSTwd;
	public ETagIntMap m_mapSTtd;
	public WordIntMap m_mapN0wd;
	public ETagIntMap m_mapN0td;
	public WordWordIntMap m_mapSTwN0wd;
	public ETagETagIntMap m_mapSTtN0td;

	public WordIntMap m_mapSTwra;
	public ETagIntMap m_mapSTtra;
	public WordIntMap m_mapSTwla;
	public ETagIntMap m_mapSTtla;
	public WordIntMap m_mapN0wla;
	public ETagIntMap m_mapN0tla;

	public WordESetOfLabelsMap m_mapSTwrp;
	public ETagESetOfLabelsMap m_mapSTtrp;
	public WordESetOfLabelsMap m_mapSTwlp;
	public ETagESetOfLabelsMap m_mapSTtlp;
	public WordESetOfLabelsMap m_mapN0wlp;
	public ETagESetOfLabelsMap m_mapN0tlp;

	public LemmaMap m_mapSTl;
	public CoNLLCPOSMap m_mapSTc;
	public CoNLLFeatsMap m_mapSTf;

	public LemmaMap m_mapN0l;
	public CoNLLCPOSMap m_mapN0c;
	public CoNLLFeatsMap m_mapN0f;

	public LemmaMap m_mapN1l;
	public CoNLLCPOSMap m_mapN1c;
	public CoNLLFeatsMap m_mapN1f;
	
	public EWeight(final String sPath, final boolean bTrain) {
		super(sPath, bTrain);
		m_mapSTw = new WordMap("StackWord", DEP_TABLE_SIZE);
		m_mapSTt = new ETagMap("StackTag", DEP_TABLE_SIZE);
		m_mapSTwt = new ETaggedWordMap("StackWordTag", DEP_TABLE_SIZE);

		m_mapN0w = new WordMap("NextWord", DEP_TABLE_SIZE);
		m_mapN0t = new ETagMap("NextTag", DEP_TABLE_SIZE);
		m_mapN0wt = new ETaggedWordMap("NextWordTag", DEP_TABLE_SIZE);

		m_mapN1w = new WordMap("Next+1Word", DEP_TABLE_SIZE);
		m_mapN1t = new ETagMap("Next+1Tag", DEP_TABLE_SIZE);
		m_mapN1wt = new ETaggedWordMap("Next+1WordTag", DEP_TABLE_SIZE);

		m_mapN2w = new WordMap("Next+2Word", DEP_TABLE_SIZE);
		m_mapN2t = new ETagMap("Next+2Tag", DEP_TABLE_SIZE);
		m_mapN2wt = new ETaggedWordMap("Next+2WordTag", DEP_TABLE_SIZE);

		m_mapSTHw = new WordMap("StackHeadWord", DEP_TABLE_SIZE);
		m_mapSTHt = new ETagMap("StackHeadTag", DEP_TABLE_SIZE);
		m_mapSTi = new IntMap("StackLabel", DEP_TABLE_SIZE);

		m_mapSTHHw = new WordMap("StackHeadHeadWord", DEP_TABLE_SIZE);
		m_mapSTHHt = new ETagMap("StackHeadHeadTag", DEP_TABLE_SIZE);
		m_mapSTHi = new IntMap("StackLabel", DEP_TABLE_SIZE);

		m_mapSTLDw = new WordMap("StackLDWord", DEP_TABLE_SIZE);
		m_mapSTLDt = new ETagMap("StackLDTag", DEP_TABLE_SIZE);
		m_mapSTLDi = new IntMap("StackLDLabel", DEP_TABLE_SIZE);

		m_mapSTRDw = new WordMap("StackRDWord", DEP_TABLE_SIZE);
		m_mapSTRDt = new ETagMap("StackRDTag", DEP_TABLE_SIZE);
		m_mapSTRDi = new IntMap("StackRDLabel", DEP_TABLE_SIZE);

		m_mapN0LDw = new WordMap("NextLDWord", DEP_TABLE_SIZE);
		m_mapN0LDt = new ETagMap("NextLDTag", DEP_TABLE_SIZE);
		m_mapN0LDi = new IntMap("NextLDLabel", DEP_TABLE_SIZE);

		m_mapSTL2Dw = new WordMap("StackL2DWord", DEP_TABLE_SIZE);
		m_mapSTL2Dt = new ETagMap("StackL2DTag", DEP_TABLE_SIZE);
		m_mapSTL2Di = new IntMap("StackL2DLabel", DEP_TABLE_SIZE);

		m_mapSTR2Dw = new WordMap("StackR2DWord", DEP_TABLE_SIZE);
		m_mapSTR2Dt = new ETagMap("StackR2DTag", DEP_TABLE_SIZE);
		m_mapSTR2Di = new IntMap("StackR2DLabel", DEP_TABLE_SIZE);

		m_mapN0L2Dw = new WordMap("NextL2DWord", DEP_TABLE_SIZE);
		m_mapN0L2Dt = new ETagMap("NextL2DTag", DEP_TABLE_SIZE);
		m_mapN0L2Di = new IntMap("NextL2DLabel", DEP_TABLE_SIZE);

		m_mapHTw = new WordMap("HeadStackWord", DEP_TABLE_SIZE);
		m_mapHTt = new ETagMap("HeadStackTag", DEP_TABLE_SIZE);
		m_mapHTwt = new ETaggedWordMap("HeadStackWordTag", DEP_TABLE_SIZE);

		m_mapSTwtN0wt = new TwoETaggedWordsMap("StackWordTagNextWordTag", DEP_TABLE_SIZE);
		m_mapSTwtN0w = new WordWordETagMap("StackWordTagNextWord", DEP_TABLE_SIZE);
		m_mapSTwN0wt = new WordWordETagMap("StackWordNextWordTag", DEP_TABLE_SIZE);
		m_mapSTtN0wt = new WordETagETagMap("StackTagNextWordTag", DEP_TABLE_SIZE);
		m_mapSTwtN0t = new WordETagETagMap("StackWordTagNextTag", DEP_TABLE_SIZE);
		m_mapSTwN0w = new TwoWordsMap("StackWordNextWord", DEP_TABLE_SIZE);
		m_mapSTtN0t = new ETagSet2Map("StackTagNextTag", DEP_TABLE_SIZE);
		
		m_mapN0tN1t = new ETagSet2Map("NextTagNext+1Tag", DEP_TABLE_SIZE);
		m_mapN0tN1tN2t = new ETagSet3Map("NextTagTrigram", DEP_TABLE_SIZE);
		m_mapSTtN0tN1t = new ETagSet3Map("StackTagNextTagNext+1Tag", DEP_TABLE_SIZE);
		m_mapSTtN0tN0LDt = new ETagSet3Map("StackTagNextTagNextLDTag", DEP_TABLE_SIZE);
		m_mapN0tN0LDtN0L2Dt = new ETagSet3Map("StackTagNextTagNextLDTagNextTagNextL2DTag", DEP_TABLE_SIZE);
		m_mapSTHtSTtN0t = new ETagSet3Map("StackHeadTagStackTagNextTag", DEP_TABLE_SIZE);
		m_mapHTtHT2tN0t = new ETagSet3Map("HeadStackTagHeadStack2TagNextTag", DEP_TABLE_SIZE);
		m_mapSTHHtSTHtSTt = new ETagSet3Map("StackHeadHeadTagStackHeadTagStackTag", DEP_TABLE_SIZE);
		m_mapSTtSTLDtN0t = new ETagSet3Map("StackTagStackLDTagNextTag", DEP_TABLE_SIZE);
		m_mapSTtSTLDtSTL2Dt = new ETagSet3Map("StackTagStackLDTagStackL2DTag", DEP_TABLE_SIZE);
		m_mapSTtSTRDtN0t = new ETagSet3Map("StackTagStackRDTagNextTag", DEP_TABLE_SIZE);
		m_mapSTtSTRDtSTR2Dt = new ETagSet3Map("StackTagStackRDTagStackR2DTag", DEP_TABLE_SIZE);

		m_mapSTwd = new WordIntMap("StackWordDist", DEP_TABLE_SIZE);
		m_mapSTtd = new ETagIntMap("StackTagDist", DEP_TABLE_SIZE);
		m_mapN0wd = new WordIntMap("NextWordDist", DEP_TABLE_SIZE);
		m_mapN0td = new ETagIntMap("NextTagDist", DEP_TABLE_SIZE);
		m_mapSTwN0wd = new WordWordIntMap("StackWordNextWordDist", DEP_TABLE_SIZE);
		m_mapSTtN0td = new ETagETagIntMap("StackTagNextTagDist", DEP_TABLE_SIZE);

		m_mapSTwra = new WordIntMap("StackWordRightArity", DEP_TABLE_SIZE);
		m_mapSTtra = new ETagIntMap("StackTagRightArity", DEP_TABLE_SIZE);
		m_mapSTwla = new WordIntMap("StackWordLeftArity", DEP_TABLE_SIZE);
		m_mapSTtla = new ETagIntMap("StackTagLeftArity", DEP_TABLE_SIZE);
		m_mapN0wla = new WordIntMap("NextWordRightArity", DEP_TABLE_SIZE);
		m_mapN0tla = new ETagIntMap("NextTagRightArity", DEP_TABLE_SIZE);

		m_mapSTwrp = new WordESetOfLabelsMap("StackWordRightSetoftags", DEP_TABLE_SIZE);
		m_mapSTtrp = new ETagESetOfLabelsMap("StackTagRightSetoftags", DEP_TABLE_SIZE);
		m_mapSTwlp = new WordESetOfLabelsMap("StackWordLeftSetoftags", DEP_TABLE_SIZE);
		m_mapSTtlp = new ETagESetOfLabelsMap("StackTagLeftSetoftags", DEP_TABLE_SIZE);
		m_mapN0wlp = new WordESetOfLabelsMap("Next0WordLeftSetoftags", DEP_TABLE_SIZE);
		m_mapN0tlp = new ETagESetOfLabelsMap("Next0TagLeftSetoftags", DEP_TABLE_SIZE);

		m_mapSTl = new LemmaMap("StackLemma", DEP_TABLE_SIZE);
		m_mapSTc = new CoNLLCPOSMap("StackCPOS", DEP_TABLE_SIZE);
		m_mapSTf = new CoNLLFeatsMap("StackFeats", DEP_TABLE_SIZE);

		m_mapN0l = new LemmaMap("NextLemma", DEP_TABLE_SIZE);
		m_mapN0c = new CoNLLCPOSMap("NextCPOS", DEP_TABLE_SIZE);
		m_mapN0f = new CoNLLFeatsMap("NextFeats", DEP_TABLE_SIZE);

		m_mapN1l = new LemmaMap("Next+1Lemma", DEP_TABLE_SIZE);
		m_mapN1c = new CoNLLCPOSMap("Next+1CPOS", DEP_TABLE_SIZE);
		m_mapN1f = new CoNLLFeatsMap("Next+1Feats", DEP_TABLE_SIZE);
		
		loadScores();
	}
	
	@Override
	public void loadScores() {
		long time_start = System.currentTimeMillis();
		System.out.print("Loading scores...");
		System.out.flush();
		File file = new File(m_sRecordPath);
		if (!file.exists()) {
			System.out.println("empty.");
			return;
		}
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			br.readLine();
			br.readLine();
			br.readLine();
			
			m_mapSTw.loadScoresFromFileStream(br);
			m_mapSTt.loadScoresFromFileStream(br);
			m_mapSTwt.loadScoresFromFileStream(br);

			m_mapN0w.loadScoresFromFileStream(br);
			m_mapN0t.loadScoresFromFileStream(br);
			m_mapN0wt.loadScoresFromFileStream(br);

			m_mapN1w.loadScoresFromFileStream(br);
			m_mapN1t.loadScoresFromFileStream(br);
			m_mapN1wt.loadScoresFromFileStream(br);

			m_mapN2w.loadScoresFromFileStream(br);
			m_mapN2t.loadScoresFromFileStream(br);
			m_mapN2wt.loadScoresFromFileStream(br);

			m_mapSTHw.loadScoresFromFileStream(br);
			m_mapSTHt.loadScoresFromFileStream(br);
			m_mapSTi.loadScoresFromFileStream(br);

			m_mapSTHHw.loadScoresFromFileStream(br);
			m_mapSTHHt.loadScoresFromFileStream(br);
			m_mapSTHi.loadScoresFromFileStream(br);

			m_mapSTLDw.loadScoresFromFileStream(br);
			m_mapSTLDt.loadScoresFromFileStream(br);
			m_mapSTLDi.loadScoresFromFileStream(br);

			m_mapSTRDw.loadScoresFromFileStream(br);
			m_mapSTRDt.loadScoresFromFileStream(br);
			m_mapSTRDi.loadScoresFromFileStream(br);

			m_mapN0LDw.loadScoresFromFileStream(br);
			m_mapN0LDt.loadScoresFromFileStream(br);
			m_mapN0LDi.loadScoresFromFileStream(br);

			m_mapSTL2Dw.loadScoresFromFileStream(br);
			m_mapSTL2Dt.loadScoresFromFileStream(br);
			m_mapSTL2Di.loadScoresFromFileStream(br);

			m_mapSTR2Dw.loadScoresFromFileStream(br);
			m_mapSTR2Dt.loadScoresFromFileStream(br);
			m_mapSTR2Di.loadScoresFromFileStream(br);

			m_mapN0L2Dw.loadScoresFromFileStream(br);
			m_mapN0L2Dt.loadScoresFromFileStream(br);
			m_mapN0L2Di.loadScoresFromFileStream(br);

			m_mapHTw.loadScoresFromFileStream(br);
			m_mapHTt.loadScoresFromFileStream(br);
			m_mapHTwt.loadScoresFromFileStream(br);

			m_mapSTwtN0wt.loadScoresFromFileStream(br);
			m_mapSTwtN0w.loadScoresFromFileStream(br);
			m_mapSTwN0wt.loadScoresFromFileStream(br);
			m_mapSTtN0wt.loadScoresFromFileStream(br);
			m_mapSTwtN0t.loadScoresFromFileStream(br);
			m_mapSTwN0w.loadScoresFromFileStream(br);
			m_mapSTtN0t.loadScoresFromFileStream(br);

			m_mapN0tN1t.loadScoresFromFileStream(br);
			m_mapN0tN1tN2t.loadScoresFromFileStream(br);
			m_mapSTtN0tN1t.loadScoresFromFileStream(br);
			m_mapSTtN0tN0LDt.loadScoresFromFileStream(br);
			m_mapN0tN0LDtN0L2Dt.loadScoresFromFileStream(br);
			m_mapSTHtSTtN0t.loadScoresFromFileStream(br);
			m_mapHTtHT2tN0t.loadScoresFromFileStream(br);
			m_mapSTHHtSTHtSTt.loadScoresFromFileStream(br);
			m_mapSTtSTLDtN0t.loadScoresFromFileStream(br);
			m_mapSTtSTLDtSTL2Dt.loadScoresFromFileStream(br);
			m_mapSTtSTRDtN0t.loadScoresFromFileStream(br);
			m_mapSTtSTRDtSTR2Dt.loadScoresFromFileStream(br);

			m_mapSTwd.loadScoresFromFileStream(br);
			m_mapSTtd.loadScoresFromFileStream(br);
			m_mapN0wd.loadScoresFromFileStream(br);
			m_mapN0td.loadScoresFromFileStream(br);
			m_mapSTwN0wd.loadScoresFromFileStream(br);
			m_mapSTtN0td.loadScoresFromFileStream(br);

			m_mapSTwra.loadScoresFromFileStream(br);
			m_mapSTtra.loadScoresFromFileStream(br);
			m_mapSTwla.loadScoresFromFileStream(br);
			m_mapSTtla.loadScoresFromFileStream(br);
			m_mapN0wla.loadScoresFromFileStream(br);
			m_mapN0tla.loadScoresFromFileStream(br);

			m_mapSTwrp.loadScoresFromFileStream(br);
			m_mapSTtrp.loadScoresFromFileStream(br);
			m_mapSTwlp.loadScoresFromFileStream(br);
			m_mapSTtlp.loadScoresFromFileStream(br);
			m_mapN0wlp.loadScoresFromFileStream(br);
			m_mapN0tlp.loadScoresFromFileStream(br);

			m_mapSTl.loadScoresFromFileStream(br);
			m_mapSTc.loadScoresFromFileStream(br);
			m_mapSTf.loadScoresFromFileStream(br);

			m_mapN0l.loadScoresFromFileStream(br);
			m_mapN0c.loadScoresFromFileStream(br);
			m_mapN0f.loadScoresFromFileStream(br);

			m_mapN1l.loadScoresFromFileStream(br);
			m_mapN1c.loadScoresFromFileStream(br);
			m_mapN1f.loadScoresFromFileStream(br);
			
			if (br.readLine().equals("Rules=1")) {
				setRules(true);
			} else {
				setRules(false);
			}
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("done. (" + ((System.currentTimeMillis() - time_start) / 1000.0) + "s)");
	}
	
	@Override
	public void saveScores() {
		System.out.println("Saving scores...");
		System.out.flush();
		File file = new File(m_sRecordPath);
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
			bw.write("Dependency labels:");
			bw.newLine();
			for (int i = EDependencyLabel.FIRST; i < EDependencyLabel.COUNT; ++i) {
				bw.write(EDependencyLabel.PENN_DEP_STRINGS[i] + " ");
			}
			bw.newLine();
			bw.newLine();
			
			m_mapSTw.saveScoresToFileStream(bw);
			m_mapSTt.saveScoresToFileStream(bw);
			m_mapSTwt.saveScoresToFileStream(bw);

			m_mapN0w.saveScoresToFileStream(bw);
			m_mapN0t.saveScoresToFileStream(bw);
			m_mapN0wt.saveScoresToFileStream(bw);

			m_mapN1w.saveScoresToFileStream(bw);
			m_mapN1t.saveScoresToFileStream(bw);
			m_mapN1wt.saveScoresToFileStream(bw);

			m_mapN2w.saveScoresToFileStream(bw);
			m_mapN2t.saveScoresToFileStream(bw);
			m_mapN2wt.saveScoresToFileStream(bw);

			m_mapSTHw.saveScoresToFileStream(bw);
			m_mapSTHt.saveScoresToFileStream(bw);
			m_mapSTi.saveScoresToFileStream(bw);

			m_mapSTHHw.saveScoresToFileStream(bw);
			m_mapSTHHt.saveScoresToFileStream(bw);
			m_mapSTHi.saveScoresToFileStream(bw);

			m_mapSTLDw.saveScoresToFileStream(bw);
			m_mapSTLDt.saveScoresToFileStream(bw);
			m_mapSTLDi.saveScoresToFileStream(bw);

			m_mapSTRDw.saveScoresToFileStream(bw);
			m_mapSTRDt.saveScoresToFileStream(bw);
			m_mapSTRDi.saveScoresToFileStream(bw);

			m_mapN0LDw.saveScoresToFileStream(bw);
			m_mapN0LDt.saveScoresToFileStream(bw);
			m_mapN0LDi.saveScoresToFileStream(bw);

			m_mapSTL2Dw.saveScoresToFileStream(bw);
			m_mapSTL2Dt.saveScoresToFileStream(bw);
			m_mapSTL2Di.saveScoresToFileStream(bw);

			m_mapSTR2Dw.saveScoresToFileStream(bw);
			m_mapSTR2Dt.saveScoresToFileStream(bw);
			m_mapSTR2Di.saveScoresToFileStream(bw);

			m_mapN0L2Dw.saveScoresToFileStream(bw);
			m_mapN0L2Dt.saveScoresToFileStream(bw);
			m_mapN0L2Di.saveScoresToFileStream(bw);

			m_mapHTw.saveScoresToFileStream(bw);
			m_mapHTt.saveScoresToFileStream(bw);
			m_mapHTwt.saveScoresToFileStream(bw);

			m_mapSTwtN0wt.saveScoresToFileStream(bw);
			m_mapSTwtN0w.saveScoresToFileStream(bw);
			m_mapSTwN0wt.saveScoresToFileStream(bw);
			m_mapSTtN0wt.saveScoresToFileStream(bw);
			m_mapSTwtN0t.saveScoresToFileStream(bw);
			m_mapSTwN0w.saveScoresToFileStream(bw);
			m_mapSTtN0t.saveScoresToFileStream(bw);

			m_mapN0tN1t.saveScoresToFileStream(bw);
			m_mapN0tN1tN2t.saveScoresToFileStream(bw);
			m_mapSTtN0tN1t.saveScoresToFileStream(bw);
			m_mapSTtN0tN0LDt.saveScoresToFileStream(bw);
			m_mapN0tN0LDtN0L2Dt.saveScoresToFileStream(bw);
			m_mapSTHtSTtN0t.saveScoresToFileStream(bw);
			m_mapHTtHT2tN0t.saveScoresToFileStream(bw);
			m_mapSTHHtSTHtSTt.saveScoresToFileStream(bw);
			m_mapSTtSTLDtN0t.saveScoresToFileStream(bw);
			m_mapSTtSTLDtSTL2Dt.saveScoresToFileStream(bw);
			m_mapSTtSTRDtN0t.saveScoresToFileStream(bw);
			m_mapSTtSTRDtSTR2Dt.saveScoresToFileStream(bw);

			m_mapSTwd.saveScoresToFileStream(bw);
			m_mapSTtd.saveScoresToFileStream(bw);
			m_mapN0wd.saveScoresToFileStream(bw);
			m_mapN0td.saveScoresToFileStream(bw);
			m_mapSTwN0wd.saveScoresToFileStream(bw);
			m_mapSTtN0td.saveScoresToFileStream(bw);

			m_mapSTwra.saveScoresToFileStream(bw);
			m_mapSTtra.saveScoresToFileStream(bw);
			m_mapSTwla.saveScoresToFileStream(bw);
			m_mapSTtla.saveScoresToFileStream(bw);
			m_mapN0wla.saveScoresToFileStream(bw);
			m_mapN0tla.saveScoresToFileStream(bw);

			m_mapSTwrp.saveScoresToFileStream(bw);
			m_mapSTtrp.saveScoresToFileStream(bw);
			m_mapSTwlp.saveScoresToFileStream(bw);
			m_mapSTtlp.saveScoresToFileStream(bw);
			m_mapN0wlp.saveScoresToFileStream(bw);
			m_mapN0tlp.saveScoresToFileStream(bw);

			m_mapSTl.saveScoresToFileStream(bw);
			m_mapSTc.saveScoresToFileStream(bw);
			m_mapSTf.saveScoresToFileStream(bw);

			m_mapN0l.saveScoresToFileStream(bw);
			m_mapN0c.saveScoresToFileStream(bw);
			m_mapN0f.saveScoresToFileStream(bw);

			m_mapN1l.saveScoresToFileStream(bw);
			m_mapN1c.saveScoresToFileStream(bw);
			m_mapN1f.saveScoresToFileStream(bw);
			
			if (m_bRules) {
				bw.write("Rules=1");
			} else {
				bw.write("Rules=0");
			}
			bw.newLine();
			
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("done.");
	}
	
	public void computeAverageFeatureWeights(final int round) {
		System.out.println("Computing averaged (total) feature vector...");
		System.out.flush();

		m_mapSTw.computeAverage(round);
		m_mapSTt.computeAverage(round);
		m_mapSTwt.computeAverage(round);

		m_mapN0w.computeAverage(round);
		m_mapN0t.computeAverage(round);
		m_mapN0wt.computeAverage(round);

		m_mapN1w.computeAverage(round);
		m_mapN1t.computeAverage(round);
		m_mapN1wt.computeAverage(round);

		m_mapN2w.computeAverage(round);
		m_mapN2t.computeAverage(round);
		m_mapN2wt.computeAverage(round);

		m_mapSTHw.computeAverage(round);
		m_mapSTHt.computeAverage(round);
		m_mapSTi.computeAverage(round);

		m_mapSTHHw.computeAverage(round);
		m_mapSTHHt.computeAverage(round);
		m_mapSTHi.computeAverage(round);

		m_mapSTLDw.computeAverage(round);
		m_mapSTLDt.computeAverage(round);
		m_mapSTLDi.computeAverage(round);

		m_mapSTRDw.computeAverage(round);
		m_mapSTRDt.computeAverage(round);
		m_mapSTRDi.computeAverage(round);

		m_mapN0LDw.computeAverage(round);
		m_mapN0LDt.computeAverage(round);
		m_mapN0LDi.computeAverage(round);

		m_mapSTL2Dw.computeAverage(round);
		m_mapSTL2Dt.computeAverage(round);
		m_mapSTL2Di.computeAverage(round);

		m_mapSTR2Dw.computeAverage(round);
		m_mapSTR2Dt.computeAverage(round);
		m_mapSTR2Di.computeAverage(round);

		m_mapN0L2Dw.computeAverage(round);
		m_mapN0L2Dt.computeAverage(round);
		m_mapN0L2Di.computeAverage(round);

		m_mapHTw.computeAverage(round);
		m_mapHTt.computeAverage(round);
		m_mapHTwt.computeAverage(round);

		m_mapSTwtN0wt.computeAverage(round);
		m_mapSTwtN0w.computeAverage(round);
		m_mapSTwN0wt.computeAverage(round);
		m_mapSTtN0wt.computeAverage(round);
		m_mapSTwtN0t.computeAverage(round);
		m_mapSTwN0w.computeAverage(round);
		m_mapSTtN0t.computeAverage(round);

		m_mapN0tN1t.computeAverage(round);
		m_mapN0tN1tN2t.computeAverage(round);
		m_mapSTtN0tN1t.computeAverage(round);
		m_mapSTtN0tN0LDt.computeAverage(round);
		m_mapN0tN0LDtN0L2Dt.computeAverage(round);
		m_mapSTHtSTtN0t.computeAverage(round);
		m_mapHTtHT2tN0t.computeAverage(round);
		m_mapSTHHtSTHtSTt.computeAverage(round);
		m_mapSTtSTLDtN0t.computeAverage(round);
		m_mapSTtSTLDtSTL2Dt.computeAverage(round);
		m_mapSTtSTRDtN0t.computeAverage(round);
		m_mapSTtSTRDtSTR2Dt.computeAverage(round);

		m_mapSTwd.computeAverage(round);
		m_mapSTtd.computeAverage(round);
		m_mapN0wd.computeAverage(round);
		m_mapN0td.computeAverage(round);
		m_mapSTwN0wd.computeAverage(round);
		m_mapSTtN0td.computeAverage(round);

		m_mapSTwra.computeAverage(round);
		m_mapSTtra.computeAverage(round);
		m_mapSTwla.computeAverage(round);
		m_mapSTtla.computeAverage(round);
		m_mapN0wla.computeAverage(round);
		m_mapN0tla.computeAverage(round);

		m_mapSTwrp.computeAverage(round);
		m_mapSTtrp.computeAverage(round);
		m_mapSTwlp.computeAverage(round);
		m_mapSTtlp.computeAverage(round);
		m_mapN0wlp.computeAverage(round);
		m_mapN0tlp.computeAverage(round);

		m_mapSTl.computeAverage(round);
		m_mapSTc.computeAverage(round);
		m_mapSTf.computeAverage(round);

		m_mapN0l.computeAverage(round);
		m_mapN0c.computeAverage(round);
		m_mapN0f.computeAverage(round);

		m_mapN1l.computeAverage(round);
		m_mapN1c.computeAverage(round);
		m_mapN1f.computeAverage(round);
		
		System.out.println("done.");
	}
}
