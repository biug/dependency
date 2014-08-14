package common.parser.implementations.arceager;

import include.AgendaSimple;
import include.BiString;
import include.LabeledAgendaBeam;
import include.learning.perceptron.PackedScoreType;
import include.learning.perceptron.Score;
import include.linguistics.CSetOfTags;
import include.linguistics.CTagInt;
import include.linguistics.CTagSetOfLabels;
import include.linguistics.CTagTagInt;
import include.linguistics.CTaggedWord;
import include.linguistics.CTwoTaggedWords;
import include.linguistics.CTwoWords;
import include.linguistics.CWord;
import include.linguistics.CWordInt;
import include.linguistics.CWordSetOfLabels;
import include.linguistics.CWordTag;
import include.linguistics.CWordTagTag;
import include.linguistics.CWordWordInt;
import include.linguistics.CWordWordTag;
import include.linguistics.LabeledDependencyTreeNode;
import include.linguistics.TagSet2;
import include.linguistics.TagSet3;
import include.linguistics.TwoStringVector;

import java.util.Iterator;
import java.util.LinkedList;

import chinese.dependency.label.CDependencyLabel;
import chinese.pos.CTag;

import common.parser.DepParserBase;
import common.parser.LabeledDependencyParser;

public class CDepParser extends DepParserBase {
	
	private LabeledAgendaBeam m_Agenda;
	private AgendaSimple m_Beam;
	
	private LinkedList<CTaggedWord> m_lCache;
	private LinkedList<CDependencyLabel> m_lCacheLabel;
	
	private int m_nTrainingRound;
	private int m_nTotalErrors;
	private int m_nScoreIndex;
	
	public static int n1_index;
	public static int n2_index;
	public static int n3_index;
	
	public static int st_n0_dist;
	
	public static CTwoTaggedWords st_word_tag_n0_word_tag;
	public static CTwoWords st_word_n0_word;
	
	public static CWordTag word_tag;
	public static CWordInt word_int;
	public static CTagInt tag_int;
	public static CWordTagTag word_tag_tag;
	public static CWordWordTag word_word_tag;
	public static CWordWordInt word_word_int;
	public static CTagTagInt tag_tag_int;
	public static CWordSetOfLabels word_tagset;
	public static CTagSetOfLabels tag_tagset;
	
	public static CLabeledStateItem itemForState;
	public static CLabeledStateItem itemForStates;
	public static PackedScoreType empty;
	
	public static CLabeledStateItem pCandidate;
	public static CLabeledStateItem correctState;
	public static PackedScoreType packed_scores;
	
	public static LabeledDependencyParser emptyParser;
	
	public static TwoStringVector trainSentence;
	public static LabeledDependencyParser[] outParser;
	
	private final int encodeTags(final CTag tag1, final CTag tag2) {
		return ((tag1.hashCode() << (CTag.SIZE)) | (tag2.hashCode()));
	}
	
	private final int encodeTags(final CTag tag1, final CTag tag2, final CTag tag3) {
		return ((tag1.hashCode() << (CTag.SIZE * 2)) | (tag2.hashCode() << (CTag.SIZE)) | (tag3.hashCode()));
	}
	
	private final int minVal(final int n1, final int n2) {
		return n1 < n2 ? n1 : n2; 
	}

	public CDepParser(String sFeatureDBPath, boolean bTrain, boolean bCoNLL) {
		super(sFeatureDBPath, bTrain, bCoNLL);
		m_Agenda = new LabeledAgendaBeam(Macros.AGENDA_SIZE);
		m_Beam = new AgendaSimple(Macros.AGENDA_SIZE);
		m_weights = new CWeight(sFeatureDBPath, bTrain);
		m_nTrainingRound = 0;
		m_nTotalErrors = 0;
		m_nScoreIndex = bTrain ? Score.eNonAverage : Score.eAverage;
		
		st_word_tag_n0_word_tag = new CTwoTaggedWords();
		st_word_n0_word = new CTwoWords();
		
		word_tag = new CWordTag();
		word_int = new CWordInt();
		tag_int = new CTagInt();
		word_tag_tag = new CWordTagTag();
		word_word_tag = new CWordWordTag();
		word_word_int = new CWordWordInt();
		tag_tag_int = new CTagTagInt();
		word_tagset = new CWordSetOfLabels();
		tag_tagset = new CTagSetOfLabels();
		
		empty = new PackedScoreType(Action.MAX);
		
		packed_scores = new PackedScoreType(Action.MAX);
		
		emptyParser = new LabeledDependencyParser();
		
		trainSentence = new TwoStringVector();
		
		m_lCache = new LinkedList<CTaggedWord>();
		m_lCacheLabel = new LinkedList<CDependencyLabel>();
		
		itemForState = new CLabeledStateItem();
		itemForStates = new CLabeledStateItem(m_lCache);
		pCandidate = new CLabeledStateItem(m_lCache);
		correctState = new CLabeledStateItem(m_lCache);
		
		outParser = new LabeledDependencyParser[1];
		outParser[0] = new LabeledDependencyParser();
	}
	
	public CDepParser(String sFeatureDBPath, boolean bTrain) {
		super(sFeatureDBPath, bTrain, false);
		m_Agenda = new LabeledAgendaBeam(Macros.AGENDA_SIZE);
		m_Beam = new AgendaSimple(Macros.AGENDA_SIZE);
		m_weights = new CWeight(sFeatureDBPath, bTrain);
		m_nTrainingRound = 0;
		m_nTotalErrors = 0;
		m_nScoreIndex = bTrain ? Score.eNonAverage : Score.eAverage;
		
		st_word_tag_n0_word_tag = new CTwoTaggedWords();
		st_word_n0_word = new CTwoWords();
		
		word_tag = new CWordTag();
		word_int = new CWordInt();
		tag_int = new CTagInt();
		word_tag_tag = new CWordTagTag();
		word_word_tag = new CWordWordTag();
		word_word_int = new CWordWordInt();
		tag_tag_int = new CTagTagInt();
		word_tagset = new CWordSetOfLabels();
		tag_tagset = new CTagSetOfLabels();
		
		empty = new PackedScoreType(Action.MAX);
		
		packed_scores = new PackedScoreType(Action.MAX);
		
		emptyParser = new LabeledDependencyParser();
		
		trainSentence = new TwoStringVector();
		
		m_lCache = new LinkedList<CTaggedWord>();
		m_lCacheLabel = new LinkedList<CDependencyLabel>();
		
		itemForState = new CLabeledStateItem();
		itemForStates = new CLabeledStateItem(m_lCache);
		pCandidate = new CLabeledStateItem(m_lCache);
		correctState = new CLabeledStateItem(m_lCache);
		
		outParser = new LabeledDependencyParser[1];
		outParser[0] = new LabeledDependencyParser();
	}
	
	public void getOrUpdateStackScore(CLabeledStateItem item, PackedScoreType retval, final int action, int amount, int round) {
		final int st_index = item.stackempty() ? -1 : item.stacktop();
//		System.out.println(st_index); //DEBUG
		final int sth_index = st_index == -1 ? -1 : item.head(st_index);
		final int sthh_index = sth_index == -1 ? -1 : item.head(sth_index);
		final int stld_index = st_index == -1 ? -1 : item.leftdep(st_index);
		final int strd_index = st_index == -1 ? -1 : item.rightdep(st_index);
		final int stl2d_index = stld_index == -1 ? -1 : item.sibling(stld_index);
		final int str2d_index = strd_index == -1 ? -1 : item.sibling(strd_index);
		final int n0_index = ((item.size() == m_lCache.size()) ? -1 : item.size());
		final int n0ld_index = n0_index == -1 ? -1 : item.leftdep(n0_index);
		final int n0l2d_index = n0ld_index == -1 ? -1 : item.sibling(n0ld_index);
		n1_index = ((n0_index + 1 < m_lCache.size()) ? n0_index + 1 : -1);
		n2_index = ((n0_index + 2 < m_lCache.size()) ? n0_index + 2 : -1);
		n3_index = ((n0_index + 3 < m_lCache.size()) ? n0_index + 3 : -1);
		
		final CTaggedWord st_word_tag = st_index == -1 ? new CTaggedWord() : new CTaggedWord(m_lCache.get(st_index));
		final CTaggedWord sth_word_tag = sth_index == -1 ? new CTaggedWord() : new CTaggedWord(m_lCache.get(sth_index));
		final CTaggedWord sthh_word_tag = sthh_index == -1 ? new CTaggedWord() : new CTaggedWord(m_lCache.get(sthh_index));
		final CTaggedWord stld_word_tag = stld_index == -1 ? new CTaggedWord() : new CTaggedWord(m_lCache.get(stld_index));
		final CTaggedWord strd_word_tag = strd_index == -1 ? new CTaggedWord() : new CTaggedWord(m_lCache.get(strd_index));
		final CTaggedWord stl2d_word_tag = stl2d_index == -1 ? new CTaggedWord() : new CTaggedWord(m_lCache.get(stl2d_index));
		final CTaggedWord str2d_word_tag = str2d_index == -1 ? new CTaggedWord() : new CTaggedWord(m_lCache.get(str2d_index));
		final CTaggedWord n0_word_tag = n0_index == -1 ? new CTaggedWord() : new CTaggedWord(m_lCache.get(n0_index));
		final CTaggedWord n0ld_word_tag = n0ld_index == -1 ? new CTaggedWord() : new CTaggedWord(m_lCache.get(n0ld_index));
		final CTaggedWord n0l2d_word_tag = n0l2d_index == -1 ? new CTaggedWord() : new CTaggedWord(m_lCache.get(n0l2d_index));
		final CTaggedWord n1_word_tag = n1_index == -1 ? new CTaggedWord() : new CTaggedWord(m_lCache.get(n1_index));
		final CTaggedWord n2_word_tag = n2_index == -1 ? new CTaggedWord() : new CTaggedWord(m_lCache.get(n2_index));
		
		final CWord st_word = new CWord(st_word_tag.word);
		final CWord sth_word = new CWord(sth_word_tag.word);
		final CWord sthh_word = new CWord(sthh_word_tag.word);
		final CWord stld_word = new CWord(stld_word_tag.word);
		final CWord strd_word = new CWord(strd_word_tag.word);
		final CWord stl2d_word = new CWord(stl2d_word_tag.word);
		final CWord str2d_word = new CWord(str2d_word_tag.word);
		final CWord n0_word = new CWord(n0_word_tag.word);
		final CWord n0ld_word = new CWord(n0ld_word_tag.word);
		final CWord n0l2d_word = new CWord(n0l2d_word_tag.word);
		final CWord n1_word = new CWord(n1_word_tag.word);
		final CWord n2_word = new CWord(n2_word_tag.word);
		
		final CTag st_tag = new CTag(st_word_tag.tag);
		final CTag sth_tag = new CTag(sth_word_tag.tag);
		final CTag sthh_tag = new CTag(sthh_word_tag.tag);
		final CTag stld_tag = new CTag(stld_word_tag.tag);
		final CTag strd_tag = new CTag(strd_word_tag.tag);
		final CTag stl2d_tag = new CTag(stl2d_word_tag.tag);
		final CTag str2d_tag = new CTag(str2d_word_tag.tag);
		final CTag n0_tag = new CTag(n0_word_tag.tag);
		final CTag n0ld_tag = new CTag(n0ld_word_tag.tag);
		final CTag n0l2d_tag = new CTag(n0l2d_word_tag.tag);
		final CTag n1_tag = new CTag(n1_word_tag.tag);
		final CTag n2_tag = new CTag(n2_word_tag.tag);
		
		final int st_label = st_index == -1 ? CDependencyLabel.NONE : item.label(st_index);
		final int sth_label = sth_index == -1 ? CDependencyLabel.NONE : item.label(sth_index);
		final int stld_label = stld_index == -1 ? CDependencyLabel.NONE : item.label(stld_index);
		final int strd_label = strd_index == -1 ? CDependencyLabel.NONE : item.label(strd_index);
		final int stl2d_label = stl2d_index == -1 ? CDependencyLabel.NONE : item.label(stl2d_index);
		final int str2d_label = str2d_index == -1 ? CDependencyLabel.NONE : item.label(strd_index);
		final int n0ld_label = n0ld_index == -1 ? CDependencyLabel.NONE : item.label(n0ld_index);
		final int n0l2d_label = n0l2d_index == -1 ? CDependencyLabel.NONE : item.label(n0l2d_index);
		
		st_n0_dist = Macros.encodeLinkDistance(st_index, n0_index);
		
		final int st_rarity = st_index == -1 ? 0 : item.rightarity(st_index);
		final int st_larity = st_index == -1 ? 0 : item.leftarity(st_index);
		final int n0_larity = n0_index == -1 ? 0 : item.leftarity(n0_index);
		
		final CSetOfTags st_rtagset = st_index == -1 ? new CSetOfTags() : new CSetOfTags(item.righttagset(st_index));
		final CSetOfTags st_ltagset = st_index == -1 ? new CSetOfTags() : new CSetOfTags(item.lefttagset(st_index));
		final CSetOfTags n0_ltagset = n0_index == -1 ? new CSetOfTags() : new CSetOfTags(item.lefttagset(n0_index));
		
		if (amount == 0) {
			st_word_tag_n0_word_tag.refer(st_word_tag, n0_word_tag);
			st_word_n0_word.refer(st_word, n0_word);
		} else {
			st_word_tag_n0_word_tag.allocate(st_word_tag, n0_word_tag);
			st_word_n0_word.allocate(st_word, n0_word);			
		}
		
		CWeight cweight = (CWeight)m_weights;
		
		if (st_index != -1) {
//			System.out.println("st 1"); //DEBUG
			cweight.m_mapSTw.getOrUpdateScore(retval, new CWord(st_word), action, m_nScoreIndex, amount, round);
			cweight.m_mapSTt.getOrUpdateScore(retval, new CTag(st_tag), action, m_nScoreIndex, amount, round);
			cweight.m_mapSTwt.getOrUpdateScore(retval, new CTaggedWord(st_word_tag), action, m_nScoreIndex, amount, round);
		}

		if (n0_index != -1) {
//			System.out.println("n0 1"); //DEBUG
			cweight.m_mapN0w.getOrUpdateScore(retval, new CWord(n0_word), action, m_nScoreIndex, amount, round);
			cweight.m_mapN0t.getOrUpdateScore(retval, new CTag(n0_tag), action, m_nScoreIndex, amount, round);
			cweight.m_mapN0wt.getOrUpdateScore(retval, new CTaggedWord(n0_word_tag), action, m_nScoreIndex, amount, round);
		}

		if (n1_index != -1) {
//			System.out.println("n1 1"); //DEBUG
			cweight.m_mapN1w.getOrUpdateScore(retval, new CWord(n1_word), action, m_nScoreIndex, amount, round);
			cweight.m_mapN1t.getOrUpdateScore(retval, new CTag(n1_tag), action, m_nScoreIndex, amount, round);
			cweight.m_mapN1wt.getOrUpdateScore(retval, new CTaggedWord(n1_word_tag), action, m_nScoreIndex, amount, round);
		}

		if (n2_index != -1) {
//			System.out.println("n2 1"); //DEBUG
			cweight.m_mapN2w.getOrUpdateScore(retval, new CWord(n2_word), action, m_nScoreIndex, amount, round);
			cweight.m_mapN2t.getOrUpdateScore(retval, new CTag(n2_tag), action, m_nScoreIndex, amount, round);
			cweight.m_mapN2wt.getOrUpdateScore(retval, new CTaggedWord(n2_word_tag), action, m_nScoreIndex, amount, round);
		}

		if (sth_index != -1) {
//			System.out.println("sth 1"); //DEBUG
			cweight.m_mapSTHw.getOrUpdateScore(retval, new CWord(sth_word), action, m_nScoreIndex, amount, round);
			cweight.m_mapSTHt.getOrUpdateScore(retval, new CTag(sth_tag), action, m_nScoreIndex, amount, round);
			cweight.m_mapSTi.getOrUpdateScore(retval, new Integer(st_label), action, m_nScoreIndex, amount, round);
		}

		if (sthh_index != -1) {
//			System.out.println("sthh 1"); //DEBUG
			cweight.m_mapSTHHw.getOrUpdateScore(retval, new CWord(sthh_word), action, m_nScoreIndex, amount, round);
			cweight.m_mapSTHHt.getOrUpdateScore(retval, new CTag(sthh_tag), action, m_nScoreIndex, amount, round);
			cweight.m_mapSTHi.getOrUpdateScore(retval, new Integer(sth_label), action, m_nScoreIndex, amount, round);
		}

		if (stld_index != -1) {
//			System.out.println("stld 1" + stld_index); //DEBUG
			cweight.m_mapSTLDw.getOrUpdateScore(retval, new CWord(stld_word), action, m_nScoreIndex, amount, round);
			cweight.m_mapSTLDt.getOrUpdateScore(retval, new CTag(stld_tag), action, m_nScoreIndex, amount, round);
			cweight.m_mapSTLDi.getOrUpdateScore(retval, new Integer(stld_label), action, m_nScoreIndex, amount, round);
		}

		if (strd_index != -1) {
//			System.out.println("strd 1"); //DEBUG
			cweight.m_mapSTRDw.getOrUpdateScore(retval, new CWord(strd_word), action, m_nScoreIndex, amount, round);
			cweight.m_mapSTRDt.getOrUpdateScore(retval, new CTag(strd_tag), action, m_nScoreIndex, amount, round);
			cweight.m_mapSTRDi.getOrUpdateScore(retval, new Integer(strd_label), action, m_nScoreIndex, amount, round);
		}

		if (n0ld_index != -1) {
//			System.out.println("n0ld 1"); //DEBUG
			cweight.m_mapN0LDw.getOrUpdateScore(retval, new CWord(n0ld_word), action, m_nScoreIndex, amount, round);
			cweight.m_mapN0LDt.getOrUpdateScore(retval, new CTag(n0ld_tag), action, m_nScoreIndex, amount, round);
			cweight.m_mapN0LDi.getOrUpdateScore(retval, new Integer(n0ld_label), action, m_nScoreIndex, amount, round);
		}

		if (stl2d_index != -1) {
//			System.out.println("stl2d 1"); //DEBUG
			cweight.m_mapSTL2Dw.getOrUpdateScore(retval, new CWord(stl2d_word), action, m_nScoreIndex, amount, round);
			cweight.m_mapSTL2Dt.getOrUpdateScore(retval, new CTag(stl2d_tag), action, m_nScoreIndex, amount, round);
			cweight.m_mapSTL2Di.getOrUpdateScore(retval, new Integer(stl2d_label), action, m_nScoreIndex, amount, round);
		}

		if (str2d_index != -1) {
//			System.out.println("str2d 1"); //DEBUG
			cweight.m_mapSTR2Dw.getOrUpdateScore(retval, new CWord(str2d_word), action, m_nScoreIndex, amount, round);
			cweight.m_mapSTR2Dt.getOrUpdateScore(retval, new CTag(str2d_tag), action, m_nScoreIndex, amount, round);
			cweight.m_mapSTR2Di.getOrUpdateScore(retval, new Integer(str2d_label), action, m_nScoreIndex, amount, round);
		}

		if (n0l2d_index != -1) {
//			System.out.println("n0l2d 1"); //DEBUG
			cweight.m_mapN0L2Dw.getOrUpdateScore(retval, new CWord(n0l2d_word), action, m_nScoreIndex, amount, round);
			cweight.m_mapN0L2Dt.getOrUpdateScore(retval, new CTag(n0l2d_tag), action, m_nScoreIndex, amount, round);
			cweight.m_mapN0L2Di.getOrUpdateScore(retval, new Integer(n0l2d_label), action, m_nScoreIndex, amount, round);
		}

		if (st_index != -1) {
//			System.out.println("st 2"); //DEBUG
			cweight.m_mapSTwtN0wt.getOrUpdateScore(retval, new CTwoTaggedWords(st_word_tag_n0_word_tag), action, m_nScoreIndex, amount, round);
			if (amount == 0) word_word_tag.refer(st_word, n0_word, st_tag); else word_word_tag.allocate(st_word, n0_word, st_tag);
			cweight.m_mapSTwtN0w.getOrUpdateScore(retval, new CWordWordTag(word_word_tag), action, m_nScoreIndex, amount, round); 
			if (amount == 0) word_word_tag.refer(st_word, n0_word, n0_tag); else word_word_tag.allocate(st_word, n0_word, n0_tag);
			cweight.m_mapSTwN0wt.getOrUpdateScore(retval, new CWordWordTag(word_word_tag), action, m_nScoreIndex, amount, round); 
			if (amount == 0) word_tag_tag.refer(st_word, st_tag, n0_tag); else word_tag_tag.allocate(st_word, st_tag, n0_tag);
			cweight.m_mapSTwtN0t.getOrUpdateScore(retval, new CWordTagTag(word_tag_tag), action, m_nScoreIndex, amount, round); 
			if (amount == 0) word_tag_tag.refer(n0_word, st_tag, n0_tag); else word_tag_tag.allocate(n0_word, st_tag, n0_tag);
			cweight.m_mapSTtN0wt.getOrUpdateScore(retval, new CWordTagTag(word_tag_tag), action, m_nScoreIndex, amount, round);
			cweight.m_mapSTwN0w.getOrUpdateScore(retval, new CTwoWords(st_word_n0_word), action, m_nScoreIndex, amount, round); 
			cweight.m_mapSTtN0t.getOrUpdateScore(retval, new TagSet2(encodeTags(st_tag, n0_tag)), action, m_nScoreIndex, amount, round); 
		}

		if (st_index != -1 && n0_index != -1) {
//			System.out.println("st&n0 1"); //DEBUG
			cweight.m_mapN0tN1t.getOrUpdateScore(retval, new TagSet2(encodeTags(n0_tag, n1_tag)), action, m_nScoreIndex, amount, round); 
			cweight.m_mapN0tN1tN2t.getOrUpdateScore(retval, new TagSet3(encodeTags(n0_tag, n1_tag, n2_tag)), action, m_nScoreIndex, amount, round); 
			cweight.m_mapSTtN0tN1t.getOrUpdateScore(retval, new TagSet3(encodeTags(st_tag, n0_tag, n1_tag)), action, m_nScoreIndex, amount, round); 
			cweight.m_mapSTtN0tN0LDt.getOrUpdateScore(retval, new TagSet3(encodeTags(st_tag, n0_tag, n0ld_tag)), action, m_nScoreIndex, amount, round); 
			cweight.m_mapN0tN0LDtN0L2Dt.getOrUpdateScore(retval, new TagSet3(encodeTags(n0_tag, n0ld_tag, n0l2d_tag)), action, m_nScoreIndex, amount, round); 
		}
		if (st_index != -1) {
//			System.out.println("st 3"); //DEBUG
			cweight.m_mapSTHtSTtN0t.getOrUpdateScore(retval, new TagSet3(encodeTags(sth_tag, st_tag, n0_tag)), action, m_nScoreIndex, amount, round); 
			cweight.m_mapSTHHtSTHtSTt.getOrUpdateScore(retval, new TagSet3(encodeTags(sthh_tag, sth_tag, st_tag)), action, m_nScoreIndex, amount, round); 
			cweight.m_mapSTtSTLDtN0t.getOrUpdateScore(retval, new TagSet3(encodeTags(st_tag, stld_tag, n0_tag)), action, m_nScoreIndex, amount, round); 
			cweight.m_mapSTtSTLDtSTL2Dt.getOrUpdateScore(retval, new TagSet3(encodeTags(st_tag, stld_tag, stl2d_tag)), action, m_nScoreIndex, amount, round); 
			cweight.m_mapSTtSTRDtN0t.getOrUpdateScore(retval, new TagSet3(encodeTags(st_tag, strd_tag, n0_tag)), action, m_nScoreIndex, amount, round); 
			cweight.m_mapSTtSTRDtSTR2Dt.getOrUpdateScore(retval, new TagSet3(encodeTags(st_tag, strd_tag, str2d_tag)), action, m_nScoreIndex, amount, round); 
		}

		if (st_index != -1 && n0_index != -1) {
//			System.out.println("st&n0 2"); //DEBUG
			if (amount == 0) word_int.refer(st_word, st_n0_dist); else word_int.allocate(st_word, st_n0_dist);
			cweight.m_mapSTwd.getOrUpdateScore(retval, new CWordInt(word_int), action, m_nScoreIndex, amount, round);
			if (amount == 0) tag_int.refer(st_tag, st_n0_dist); else tag_int.allocate(st_tag, st_n0_dist);
			cweight.m_mapSTtd.getOrUpdateScore(retval, new CTagInt(tag_int), action, m_nScoreIndex, amount, round);
			if (amount == 0) word_int.refer(n0_word, st_n0_dist); else word_int.allocate(n0_word, st_n0_dist);
			cweight.m_mapN0wd.getOrUpdateScore(retval, new CWordInt(word_int), action, m_nScoreIndex, amount, round);
			if (amount == 0) tag_int.refer(n0_tag, st_n0_dist); else tag_int.allocate(n0_tag, st_n0_dist);
			cweight.m_mapN0td.getOrUpdateScore(retval, new CTagInt(tag_int), action, m_nScoreIndex, amount, round);
			if (amount == 0) word_word_int.refer(st_word, n0_word, st_n0_dist); else word_word_int.allocate(st_word, n0_word, st_n0_dist);
			cweight.m_mapSTwN0wd.getOrUpdateScore(retval, new CWordWordInt(word_word_int), action, m_nScoreIndex, amount, round);
			if (amount == 0) tag_tag_int.refer(st_tag, n0_tag, st_n0_dist); else tag_tag_int.allocate(st_tag, n0_tag, st_n0_dist);
			cweight.m_mapSTtN0td.getOrUpdateScore(retval, new CTagTagInt(tag_tag_int), action, m_nScoreIndex, amount, round); 
		}

		if (st_index != -1) {
//			System.out.println("st 4"); //DEBUG
			if (amount == 0) word_int.refer(st_word, st_rarity); else word_int.allocate(st_word, st_rarity);
			cweight.m_mapSTwra.getOrUpdateScore(retval, new CWordInt(word_int), action, m_nScoreIndex, amount, round);
			if (amount == 0) tag_int.refer(st_tag, st_rarity); else tag_int.allocate(st_tag, st_rarity);
			cweight.m_mapSTtra.getOrUpdateScore(retval, new CTagInt(tag_int), action, m_nScoreIndex, amount, round);
			if (amount == 0) word_int.refer(st_word, st_larity); else word_int.allocate(st_word, st_larity);
			cweight.m_mapSTwla.getOrUpdateScore(retval, new CWordInt(word_int), action, m_nScoreIndex, amount, round);
			if (amount == 0) tag_int.refer(st_tag, st_larity); else tag_int.allocate(st_tag, st_larity);
			cweight.m_mapSTtla.getOrUpdateScore(retval, new CTagInt(tag_int), action, m_nScoreIndex, amount, round);
		}

		if (n0_index != -1) {
//			System.out.println("n0 2"); //DEBUG
			if (amount == 0) word_int.refer(n0_word, n0_larity); else word_int.allocate(n0_word, n0_larity);
			cweight.m_mapN0wla.getOrUpdateScore(retval, new CWordInt(word_int), action, m_nScoreIndex, amount, round);
			if (amount == 0) tag_int.refer(n0_tag, n0_larity); else tag_int.allocate(n0_tag, n0_larity);
			cweight.m_mapN0tla.getOrUpdateScore(retval, new CTagInt(tag_int), action, m_nScoreIndex, amount, round);
		}

		if (st_index != -1){
//			System.out.println("st 5"); //DEBUG
			if (amount == 0) word_tagset.refer(st_word, st_rtagset); else word_tagset.allocate(st_word, st_rtagset);
			cweight.m_mapSTwrp.getOrUpdateScore(retval, new CWordSetOfLabels(word_tagset), action, m_nScoreIndex, amount, round);
			if (amount == 0) tag_tagset.refer(st_tag, st_rtagset); else tag_tagset.allocate(st_tag, st_rtagset);
			cweight.m_mapSTtrp.getOrUpdateScore(retval, new CTagSetOfLabels(tag_tagset), action, m_nScoreIndex, amount, round);

			if (amount == 0) word_tagset.refer(st_word, st_ltagset); else word_tagset.allocate(st_word, st_ltagset);
			cweight.m_mapSTwlp.getOrUpdateScore(retval, new CWordSetOfLabels(word_tagset), action, m_nScoreIndex, amount, round);
			if (amount == 0) tag_tagset.refer(st_tag, st_ltagset); else tag_tagset.allocate(st_tag, st_ltagset);
			cweight.m_mapSTtlp.getOrUpdateScore(retval, new CTagSetOfLabels(tag_tagset), action, m_nScoreIndex, amount, round);
		}

		if (n0_index != -1){
//			System.out.println("n0 3"); //DEBUG
			if (amount == 0) word_tagset.refer(n0_word, n0_ltagset); else word_tagset.allocate(n0_word, n0_ltagset);
			cweight.m_mapN0wlp.getOrUpdateScore(retval, new CWordSetOfLabels(word_tagset), action, m_nScoreIndex, amount, round);
			if (amount == 0) tag_tagset.refer(n0_tag, n0_ltagset); else tag_tagset.allocate(n0_tag, n0_ltagset);
			cweight.m_mapN0tlp.getOrUpdateScore(retval, new CTagSetOfLabels(tag_tagset), action, m_nScoreIndex, amount, round);
		}
	}

	public void getOrUpdateStackScore(CLabeledStateItem item, PackedScoreType retval, final int action) {
		getOrUpdateStackScore(item, retval, action, 0, 0);
	}
	
	public void updateScoreForState(final CLabeledStateItem from, final CLabeledStateItem outout, final int amount, int len) {
		itemForState.copy(from);
		while (!itemForState.equals(outout)) {
			int action = itemForState.FollowMove(outout);
			getOrUpdateStackScore(itemForState, empty, action, amount, m_nTrainingRound);
			itemForState.Move(action);
		}
	}
	
	public void updateScoreForStates(final CLabeledStateItem outout, final CLabeledStateItem correct, int amount_add, int amount_subtract, int len) {
		itemForStates.clear();
		while (!itemForStates.equals(outout)) {
			int action = itemForStates.FollowMove(outout);
			int correct_action = itemForStates.FollowMove(correct);
			if (action == correct_action) {
				itemForStates.Move(action);
			} else {
				break;
			}
		}
		updateScoreForState(itemForStates, correct, amount_add, len);
		updateScoreForState(itemForStates, outout, amount_subtract, len);
		++m_nTotalErrors;
	}
	
	public void reduce(final CLabeledStateItem item, final PackedScoreType scores, boolean isprint) {
		ScoredAction scoredaction = new ScoredAction();
		scoredaction.action = Action.REDUCE;
		scoredaction.score = item.score + scores.at(scoredaction.action);
		if (isprint) {
			System.out.println("reduce " + scoredaction.action + " " + scoredaction.score);
		}
		m_Beam.insertItem(scoredaction);
	}
	
	public void arcleft(final CLabeledStateItem item, final PackedScoreType scores, boolean isprint) {
		ScoredAction scoredaction = new ScoredAction();
		for (int i = CDependencyLabel.FIRST; i < CDependencyLabel.COUNT; ++i) {
			scoredaction.action = Action.encodeAction(Action.ARC_LEFT, i);
			scoredaction.score = item.score + scores.at(scoredaction.action);
			if (isprint) {
				System.out.println("arcleft " + i + " " + scoredaction.action + " " + scoredaction.score);
			}
			m_Beam.insertItem(scoredaction);
		}
	}
	
	public void arcright(final CLabeledStateItem item, final PackedScoreType scores, boolean isprint) {
		ScoredAction scoredaction = new ScoredAction();
		for (int i = CDependencyLabel.FIRST; i < CDependencyLabel.COUNT; ++i) {
			scoredaction.action = Action.encodeAction(Action.ARC_RIGHT, i);
			scoredaction.score = item.score + scores.at(scoredaction.action);
			if (isprint) {
				System.out.println("arcright " + i + " " + scoredaction.action + " " + scoredaction.score);
			}
			m_Beam.insertItem(scoredaction);
		}
	}
	
	public void shift(final CLabeledStateItem item, final PackedScoreType scores, boolean isprint) {
		ScoredAction scoredaction = new ScoredAction();
		scoredaction.action = Action.SHIFT;
		scoredaction.score = item.score + scores.at(scoredaction.action);
		if (isprint) {
			System.out.println("shift " + scoredaction.action + " " + scoredaction.score);
		}
		m_Beam.insertItem(scoredaction);
	}
	
	public void poproot(final CLabeledStateItem item, final PackedScoreType scores, boolean isprint) {
		ScoredAction scoredaction = new ScoredAction();
		scoredaction.action = Action.POP_ROOT;
		scoredaction.score = item.score + scores.at(scoredaction.action);
		if (isprint) {
			System.out.println("poproot " + scoredaction.action + " " + scoredaction.score);
		}
		m_Beam.insertItem(scoredaction);
	}
	
	public void reduce(final CLabeledStateItem item, final PackedScoreType scores) {
		ScoredAction scoredaction = new ScoredAction();
		scoredaction.action = Action.REDUCE;
		scoredaction.score = item.score + scores.at(scoredaction.action);
		m_Beam.insertItem(scoredaction);
	}
	
	public void arcleft(final CLabeledStateItem item, final PackedScoreType scores) {
		ScoredAction scoredaction = new ScoredAction();
		for (int i = CDependencyLabel.FIRST; i < CDependencyLabel.COUNT; ++i) {
			scoredaction.action = Action.encodeAction(Action.ARC_LEFT, i);
			scoredaction.score = item.score + scores.at(scoredaction.action);
			m_Beam.insertItem(scoredaction);
		}
	}
	
	public void arcright(final CLabeledStateItem item, final PackedScoreType scores) {
		ScoredAction scoredaction = new ScoredAction();
		for (int i = CDependencyLabel.FIRST; i < CDependencyLabel.COUNT; ++i) {
			scoredaction.action = Action.encodeAction(Action.ARC_RIGHT, i);
			scoredaction.score = item.score + scores.at(scoredaction.action);
			m_Beam.insertItem(scoredaction);
		}
	}
	
	public void shift(final CLabeledStateItem item, final PackedScoreType scores) {
		ScoredAction scoredaction = new ScoredAction();
		scoredaction.action = Action.SHIFT;
		scoredaction.score = item.score + scores.at(scoredaction.action);
		m_Beam.insertItem(scoredaction);
	}
	
	public void poproot(final CLabeledStateItem item, final PackedScoreType scores) {
		ScoredAction scoredaction = new ScoredAction();
		scoredaction.action = Action.POP_ROOT;
		scoredaction.score = item.score + scores.at(scoredaction.action);
		m_Beam.insertItem(scoredaction);
	}
	
	public void work(int round, final boolean bTrain, final TwoStringVector sentence, LabeledDependencyParser[] retval, LabeledDependencyParser correct, int nBest, int[] scores) {
		final int length = sentence.size();
		CLabeledStateItem pGenerator;
		
		boolean bCorrect = false;
		
		m_lCache.clear();
		for (int index = 0; index < length; ++index) {
			m_lCache.add(new CTaggedWord(sentence.get(index).first(), sentence.get(index).second()));
		}
		
		m_Agenda.clear();
		pCandidate.clear();
		m_Agenda.pushCandidate(pCandidate);
		m_Agenda.nextRound();
		if (bTrain) correctState.clear();
		
		m_lCacheLabel.clear();
		if (bTrain) {
			for (int index = 0; index < length; ++index) {
				m_lCacheLabel.add(new CDependencyLabel(correct.get(index).label));
			}
		}
		for (int index = 0; index < (length * 2); ++index) {
			
			if (bTrain) bCorrect = false;
			
			pGenerator = m_Agenda.generatorStart();
			
			for (int j = 0; j < m_Agenda.generatorSize(); ++j) {
				
				m_Beam.clear();
				packed_scores.reset();
				getOrUpdateStackScore(pGenerator, packed_scores, Action.NO_ACTION);
				if (pGenerator.size() == length) {
					if (pGenerator.stacksize() > 1) {
						reduce(pGenerator, packed_scores);
					} else {
						poproot(pGenerator, packed_scores);
					}
				} else {
					if (!pGenerator.afterreduce()) {
						if ((pGenerator.size() < length - 1 || pGenerator.stackempty())) {
							shift(pGenerator, packed_scores);
						}
					}
					if (!pGenerator.stackempty()) {
						if ((pGenerator.size() < length - 1 || pGenerator.headstacksize() == 1)) {
							arcright(pGenerator, packed_scores);
						}
					}
					if ((!m_bCoNLL && !pGenerator.stackempty())) {
						if (pGenerator.head(pGenerator.stacktop()) != LabeledDependencyTreeNode.DEPENDENCY_LINK_NO_HEAD) {
							reduce(pGenerator, packed_scores);
						} else {
							arcleft(pGenerator, packed_scores);
						}
					}
				}
				
				for (int i = 0; i < m_Beam.size(); ++i) {
					pCandidate.copy(pGenerator);
					pCandidate.score = m_Beam.item(i).score;
					pCandidate.Move(m_Beam.item(i).action);
					m_Agenda.pushCandidate(pCandidate);
				}
				if (bTrain && pGenerator.equals(correctState)) {
					bCorrect = true;
				}
				
				pGenerator = m_Agenda.generatorNext();
			}
			if (bTrain) {
				if (!bCorrect) {
					updateScoreForStates(m_Agenda.bestGenerator(), correctState, 1, -1, length);
					return;
				}
				correctState.StandardMoveStep(correct, m_lCacheLabel);
			}
			m_Agenda.nextRound();
		}
		if (bTrain) {
			correctState.StandardFinish();
			if (!m_Agenda.bestGenerator().equals(correctState)) {
				updateScoreForStates(m_Agenda.bestGenerator(), correctState, 1, -1, length);
				return;
			}
		}
		m_Agenda.sortGenerators();
		for (int i = 0; i < minVal(m_Agenda.generatorSize(), nBest); ++i) {
			pGenerator = m_Agenda.generator(i);
			if (pGenerator != null) {
				pGenerator.GenerateTree(sentence, retval[i]);
				if (scores != null) scores[i] = pGenerator.score;
			}
		}
	}

	@Override
	public void parse(TwoStringVector sentence, LabeledDependencyParser[] retval,
			int nBest, int[] scores) {
		for (int i = 0; i < nBest; ++i) {
			retval[i].clear();
			if (scores != null) scores[i] = 0;
		}
		work(0, false, sentence, retval, emptyParser, nBest, scores);
	}

	@Override
	public void train(LabeledDependencyParser correct, int round) {
		trainSentence.clear();
		if (correct != null) {
			Iterator<LabeledDependencyTreeNode> itr = correct.iterator();
			while (itr.hasNext()) {
				LabeledDependencyTreeNode node = itr.next();
				trainSentence.add(new BiString(node.word, node.tag));
			}
		}
		m_nTrainingRound = round;
		work(round, true, trainSentence, outParser, correct, 1, null);
	}

	@Override
	public void finishtraning() {
		((CWeight)m_weights).computeAverageFeatureWeights(m_nTrainingRound);
		((CWeight)m_weights).saveScores();
		System.out.println("Total number of training errors are: " + m_nTotalErrors);
	}

}
