package chinese.parser.implementations.arceager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import chinese.dependency.label.CDependencyLabel;
import chinese.map.CTagCSetOfLabelsMap;
import chinese.map.CTagCTagIntMap;
import chinese.map.CTagIntMap;
import chinese.map.CTagMap;
import chinese.map.CTagSet2Map;
import chinese.map.CTagSet3Map;
import chinese.map.CTaggedWordMap;
import chinese.map.TwoCTaggedWordsMap;
import chinese.map.WordCSetOfLabelsMap;
import chinese.map.WordCTagCTagMap;
import chinese.map.WordWordCTagMap;
import common.map.CoNLLCPOSMap;
import common.map.CoNLLFeatsMap;
import common.map.IntMap;
import common.map.LemmaMap;
import common.map.TwoWordsMap;
import common.map.WordIntMap;
import common.map.WordMap;
import common.map.WordWordIntMap;
import common.parser.WeightBase;

public final class CWeight extends WeightBase {
	public static final int DEP_TABLE_SIZE = 1 << 17;
	
	public WordMap m_mapSTw;
	public CTagMap m_mapSTt;
	public CTaggedWordMap m_mapSTwt;

	public WordMap m_mapN0w;
	public CTagMap m_mapN0t;
	public CTaggedWordMap m_mapN0wt;

	public WordMap m_mapN1w;
	public CTagMap m_mapN1t;
	public CTaggedWordMap m_mapN1wt;

	public WordMap m_mapN2w;
	public CTagMap m_mapN2t;
	public CTaggedWordMap m_mapN2wt;

	public WordMap m_mapSTHw;
	public CTagMap m_mapSTHt;
	public IntMap m_mapSTi;

	public WordMap m_mapSTHHw;
	public CTagMap m_mapSTHHt;
	public IntMap m_mapSTHi;

	public WordMap m_mapSTLDw;
	public CTagMap m_mapSTLDt;
	public IntMap m_mapSTLDi;

	public WordMap m_mapSTRDw;
	public CTagMap m_mapSTRDt;
	public IntMap m_mapSTRDi;

	public WordMap m_mapN0LDw;
	public CTagMap m_mapN0LDt;
	public IntMap m_mapN0LDi;

	public WordMap m_mapSTL2Dw;
	public CTagMap m_mapSTL2Dt;
	public IntMap m_mapSTL2Di;

	public WordMap m_mapSTR2Dw;
	public CTagMap m_mapSTR2Dt;
	public IntMap m_mapSTR2Di;

	public WordMap m_mapN0L2Dw;
	public CTagMap m_mapN0L2Dt;
	public IntMap m_mapN0L2Di;

	public WordMap m_mapHTw;
	public CTagMap m_mapHTt;
	public CTaggedWordMap m_mapHTwt;

	public TwoCTaggedWordsMap m_mapSTwtN0wt;
	public WordWordCTagMap m_mapSTwtN0w;
	public WordWordCTagMap m_mapSTwN0wt;
	public WordCTagCTagMap m_mapSTtN0wt;
	public WordCTagCTagMap m_mapSTwtN0t;
	public TwoWordsMap m_mapSTwN0w;
	
	public CTagSet2Map m_mapSTtN0t;
	public CTagSet2Map m_mapN0tN1t;
	public CTagSet3Map m_mapN0tN1tN2t;
	public CTagSet3Map m_mapSTtN0tN1t;
	public CTagSet3Map m_mapSTtN0tN0LDt;
	public CTagSet3Map m_mapN0tN0LDtN0L2Dt;
	public CTagSet3Map m_mapSTHtSTtN0t;
	public CTagSet3Map m_mapHTtHT2tN0t;
	public CTagSet3Map m_mapSTHHtSTHtSTt;
	public CTagSet3Map m_mapSTtSTLDtN0t;
	public CTagSet3Map m_mapSTtSTLDtSTL2Dt;
	public CTagSet3Map m_mapSTtSTRDtN0t;
	public CTagSet3Map m_mapSTtSTRDtSTR2Dt;

	public WordIntMap m_mapSTwd;
	public CTagIntMap m_mapSTtd;
	public WordIntMap m_mapN0wd;
	public CTagIntMap m_mapN0td;
	public WordWordIntMap m_mapSTwN0wd;
	public CTagCTagIntMap m_mapSTtN0td;

	public WordIntMap m_mapSTwra;
	public CTagIntMap m_mapSTtra;
	public WordIntMap m_mapSTwla;
	public CTagIntMap m_mapSTtla;
	public WordIntMap m_mapN0wla;
	public CTagIntMap m_mapN0tla;

	public WordCSetOfLabelsMap m_mapSTwrp;
	public CTagCSetOfLabelsMap m_mapSTtrp;
	public WordCSetOfLabelsMap m_mapSTwlp;
	public CTagCSetOfLabelsMap m_mapSTtlp;
	public WordCSetOfLabelsMap m_mapN0wlp;
	public CTagCSetOfLabelsMap m_mapN0tlp;

	public LemmaMap m_mapSTl;
	public CoNLLCPOSMap m_mapSTc;
	public CoNLLFeatsMap m_mapSTf;

	public LemmaMap m_mapN0l;
	public CoNLLCPOSMap m_mapN0c;
	public CoNLLFeatsMap m_mapN0f;

	public LemmaMap m_mapN1l;
	public CoNLLCPOSMap m_mapN1c;
	public CoNLLFeatsMap m_mapN1f;
	
	public CWeight(final String sPath, final boolean bTrain) {
		super(sPath, bTrain);
		m_mapSTw = new WordMap("StackWord", DEP_TABLE_SIZE);
		m_mapSTt = new CTagMap("StackTag", DEP_TABLE_SIZE);
		m_mapSTwt = new CTaggedWordMap("StackWordTag", DEP_TABLE_SIZE);

		m_mapN0w = new WordMap("NextWord", DEP_TABLE_SIZE);
		m_mapN0t = new CTagMap("NextTag", DEP_TABLE_SIZE);
		m_mapN0wt = new CTaggedWordMap("NextWordTag", DEP_TABLE_SIZE);

		m_mapN1w = new WordMap("Next+1Word", DEP_TABLE_SIZE);
		m_mapN1t = new CTagMap("Next+1Tag", DEP_TABLE_SIZE);
		m_mapN1wt = new CTaggedWordMap("Next+1WordTag", DEP_TABLE_SIZE);

		m_mapN2w = new WordMap("Next+2Word", DEP_TABLE_SIZE);
		m_mapN2t = new CTagMap("Next+2Tag", DEP_TABLE_SIZE);
		m_mapN2wt = new CTaggedWordMap("Next+2WordTag", DEP_TABLE_SIZE);

		m_mapSTHw = new WordMap("StackHeadWord", DEP_TABLE_SIZE);
		m_mapSTHt = new CTagMap("StackHeadTag", DEP_TABLE_SIZE);
		m_mapSTi = new IntMap("StackLabel", DEP_TABLE_SIZE);

		m_mapSTHHw = new WordMap("StackHeadHeadWord", DEP_TABLE_SIZE);
		m_mapSTHHt = new CTagMap("StackHeadHeadTag", DEP_TABLE_SIZE);
		m_mapSTHi = new IntMap("StackLabel", DEP_TABLE_SIZE);

		m_mapSTLDw = new WordMap("StackLDWord", DEP_TABLE_SIZE);
		m_mapSTLDt = new CTagMap("StackLDTag", DEP_TABLE_SIZE);
		m_mapSTLDi = new IntMap("StackLDLabel", DEP_TABLE_SIZE);

		m_mapSTRDw = new WordMap("StackRDWord", DEP_TABLE_SIZE);
		m_mapSTRDt = new CTagMap("StackRDTag", DEP_TABLE_SIZE);
		m_mapSTRDi = new IntMap("StackRDLabel", DEP_TABLE_SIZE);

		m_mapN0LDw = new WordMap("NextLDWord", DEP_TABLE_SIZE);
		m_mapN0LDt = new CTagMap("NextLDTag", DEP_TABLE_SIZE);
		m_mapN0LDi = new IntMap("NextLDLabel", DEP_TABLE_SIZE);

		m_mapSTL2Dw = new WordMap("StackL2DWord", DEP_TABLE_SIZE);
		m_mapSTL2Dt = new CTagMap("StackL2DTag", DEP_TABLE_SIZE);
		m_mapSTL2Di = new IntMap("StackL2DLabel", DEP_TABLE_SIZE);

		m_mapSTR2Dw = new WordMap("StackR2DWord", DEP_TABLE_SIZE);
		m_mapSTR2Dt = new CTagMap("StackR2DTag", DEP_TABLE_SIZE);
		m_mapSTR2Di = new IntMap("StackR2DLabel", DEP_TABLE_SIZE);

		m_mapN0L2Dw = new WordMap("NextL2DWord", DEP_TABLE_SIZE);
		m_mapN0L2Dt = new CTagMap("NextL2DTag", DEP_TABLE_SIZE);
		m_mapN0L2Di = new IntMap("NextL2DLabel", DEP_TABLE_SIZE);

		m_mapHTw = new WordMap("HeadStackWord", DEP_TABLE_SIZE);
		m_mapHTt = new CTagMap("HeadStackTag", DEP_TABLE_SIZE);
		m_mapHTwt = new CTaggedWordMap("HeadStackWordTag", DEP_TABLE_SIZE);

		m_mapSTwtN0wt = new TwoCTaggedWordsMap("StackWordTagNextWordTag", DEP_TABLE_SIZE);
		m_mapSTwtN0w = new WordWordCTagMap("StackWordTagNextWord", DEP_TABLE_SIZE);
		m_mapSTwN0wt = new WordWordCTagMap("StackWordNextWordTag", DEP_TABLE_SIZE);
		m_mapSTtN0wt = new WordCTagCTagMap("StackTagNextWordTag", DEP_TABLE_SIZE);
		m_mapSTwtN0t = new WordCTagCTagMap("StackWordTagNextTag", DEP_TABLE_SIZE);
		m_mapSTwN0w = new TwoWordsMap("StackWordNextWord", DEP_TABLE_SIZE);
		m_mapSTtN0t = new CTagSet2Map("StackTagNextTag", DEP_TABLE_SIZE);
		
		m_mapN0tN1t = new CTagSet2Map("NextTagNext+1Tag", DEP_TABLE_SIZE);
		m_mapN0tN1tN2t = new CTagSet3Map("NextTagTrigram", DEP_TABLE_SIZE);
		m_mapSTtN0tN1t = new CTagSet3Map("StackTagNextTagNext+1Tag", DEP_TABLE_SIZE);
		m_mapSTtN0tN0LDt = new CTagSet3Map("StackTagNextTagNextLDTag", DEP_TABLE_SIZE);
		m_mapN0tN0LDtN0L2Dt = new CTagSet3Map("StackTagNextTagNextLDTagNextTagNextL2DTag", DEP_TABLE_SIZE);
		m_mapSTHtSTtN0t = new CTagSet3Map("StackHeadTagStackTagNextTag", DEP_TABLE_SIZE);
		m_mapHTtHT2tN0t = new CTagSet3Map("HeadStackTagHeadStack2TagNextTag", DEP_TABLE_SIZE);
		m_mapSTHHtSTHtSTt = new CTagSet3Map("StackHeadHeadTagStackHeadTagStackTag", DEP_TABLE_SIZE);
		m_mapSTtSTLDtN0t = new CTagSet3Map("StackTagStackLDTagNextTag", DEP_TABLE_SIZE);
		m_mapSTtSTLDtSTL2Dt = new CTagSet3Map("StackTagStackLDTagStackL2DTag", DEP_TABLE_SIZE);
		m_mapSTtSTRDtN0t = new CTagSet3Map("StackTagStackRDTagNextTag", DEP_TABLE_SIZE);
		m_mapSTtSTRDtSTR2Dt = new CTagSet3Map("StackTagStackRDTagStackR2DTag", DEP_TABLE_SIZE);

		m_mapSTwd = new WordIntMap("StackWordDist", DEP_TABLE_SIZE);
		m_mapSTtd = new CTagIntMap("StackTagDist", DEP_TABLE_SIZE);
		m_mapN0wd = new WordIntMap("NextWordDist", DEP_TABLE_SIZE);
		m_mapN0td = new CTagIntMap("NextTagDist", DEP_TABLE_SIZE);
		m_mapSTwN0wd = new WordWordIntMap("StackWordNextWordDist", DEP_TABLE_SIZE);
		m_mapSTtN0td = new CTagCTagIntMap("StackTagNextTagDist", DEP_TABLE_SIZE);

		m_mapSTwra = new WordIntMap("StackWordRightArity", DEP_TABLE_SIZE);
		m_mapSTtra = new CTagIntMap("StackTagRightArity", DEP_TABLE_SIZE);
		m_mapSTwla = new WordIntMap("StackWordLeftArity", DEP_TABLE_SIZE);
		m_mapSTtla = new CTagIntMap("StackTagLeftArity", DEP_TABLE_SIZE);
		m_mapN0wla = new WordIntMap("NextWordRightArity", DEP_TABLE_SIZE);
		m_mapN0tla = new CTagIntMap("NextTagRightArity", DEP_TABLE_SIZE);

		m_mapSTwrp = new WordCSetOfLabelsMap("StackWordRightSetoftags", DEP_TABLE_SIZE);
		m_mapSTtrp = new CTagCSetOfLabelsMap("StackTagRightSetoftags", DEP_TABLE_SIZE);
		m_mapSTwlp = new WordCSetOfLabelsMap("StackWordLeftSetoftags", DEP_TABLE_SIZE);
		m_mapSTtlp = new CTagCSetOfLabelsMap("StackTagLeftSetoftags", DEP_TABLE_SIZE);
		m_mapN0wlp = new WordCSetOfLabelsMap("Next0WordLeftSetoftags", DEP_TABLE_SIZE);
		m_mapN0tlp = new CTagCSetOfLabelsMap("Next0TagLeftSetoftags", DEP_TABLE_SIZE);

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
			for (int i = CDependencyLabel.FIRST; i < CDependencyLabel.COUNT; ++i) {
				bw.write(CDependencyLabel.PENN_DEP_STRINGS[i] + " ");
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
