package english.parser.implementations.arceager;

import include.AgendaSimple;
import include.BiString;
import include.english.ELabeledAgendaBeam;
import include.learning.perceptron.PackedScoreType;
import include.learning.perceptron.Score;
import include.linguistics.LabeledDependencyTreeNode;
import include.linguistics.TwoStringVector;
import include.linguistics.TwoWords;
import include.linguistics.Word;
import include.linguistics.WordInt;
import include.linguistics.WordWordInt;
import include.linguistics.english.ESetOfLabels;
import include.linguistics.english.ETagESetOfLabels;
import include.linguistics.english.ETagETagInt;
import include.linguistics.english.ETagInt;
import include.linguistics.english.ETagSet2;
import include.linguistics.english.ETagSet3;
import include.linguistics.english.ETaggedWord;
import include.linguistics.english.TwoETaggedWords;
import include.linguistics.english.WordESetOfLabels;
import include.linguistics.english.WordETagETag;
import include.linguistics.english.WordWordETag;

import java.util.ArrayList;
import java.util.Iterator;

import common.parser.DepParserBase;
import common.parser.LabeledDependencyParser;
import common.parser.implementations.arceager.ScoredAction;

import english.dependency.label.EDependencyLabel;
import english.pos.ETag;

public final class EDepParser extends DepParserBase {
	
	private ELabeledAgendaBeam m_Agenda;
	private AgendaSimple m_Beam;
	
	private ArrayList<ETaggedWord> m_lCache;
	private ArrayList<EDependencyLabel> m_lCacheLabel;
	
	private int m_nTrainingRound;
	private int m_nTotalErrors;
	private int m_nScoreIndex;
	
	private ELabeledStateItem itemForState;
	private ELabeledStateItem itemForStates;
	
	private ELabeledStateItem pCandidate;
	private ELabeledStateItem correctState;
	private PackedScoreType packed_scores;
	
	private TwoStringVector trainSentence;
	
	private LabeledDependencyParser emptyParser;
	
	private LabeledDependencyParser[] outParser;
	
	private TwoETaggedWords st_word_tag_n0_word_tag;
	private TwoWords st_word_n0_word;
	
	private WordInt word_int;
	private ETagInt tag_int;
	private WordETagETag word_tag_tag;
	private WordWordETag word_word_tag;
	private WordWordInt word_word_int;
	private ETagETagInt tag_tag_int;
	private WordESetOfLabels word_tagset;
	private ETagESetOfLabels tag_tagset;
	private ETagSet2 set_of_2_tags;
	private ETagSet3 set_of_3_tags;
	
	private ScoredAction scoredaction;
	
	public static final ETaggedWord empty_taggedword = new ETaggedWord();
	public static final ESetOfLabels empty_setoftags = new ESetOfLabels();
	
	private int encodeTags(final ETag tag1, final ETag tag2) {
		return ((tag1.hashCode() << (ETag.SIZE)) | (tag2.hashCode()));
	}
	
	private int encodeTags(final ETag tag1, final ETag tag2, final ETag tag3) {
		return ((tag1.hashCode() << (ETag.SIZE << 1)) | (tag2.hashCode() << (ETag.SIZE)) | (tag3.hashCode()));
	}
	
	private int minVal(final int n1, final int n2) {
		return n1 < n2 ? n1 : n2; 
	}

	public EDepParser(final String sFeatureDBPath, final boolean bTrain, final boolean bCoNLL) {
		super(sFeatureDBPath, bTrain, bCoNLL);
		
		m_Agenda = new ELabeledAgendaBeam(EMacros.AGENDA_SIZE);
		m_Beam = new AgendaSimple(EMacros.AGENDA_SIZE);
		
		m_lCache = new ArrayList<ETaggedWord>();
		m_lCacheLabel = new ArrayList<EDependencyLabel>();
		
		m_weights = new EWeight(sFeatureDBPath, bTrain);
		m_nTrainingRound = 0;
		m_nTotalErrors = 0;
		m_nScoreIndex = bTrain ? Score.eNonAverage : Score.eAverage;
		
		itemForState = new ELabeledStateItem();
		itemForStates = new ELabeledStateItem(m_lCache);
		pCandidate = new ELabeledStateItem(m_lCache);
		correctState = new ELabeledStateItem(m_lCache);
		
		packed_scores = new PackedScoreType(ELabeledAction.MAX);
		
		trainSentence = new TwoStringVector();
		
		emptyParser = new LabeledDependencyParser();
		
		outParser = new LabeledDependencyParser[1];
		outParser[0] = new LabeledDependencyParser();
		
		st_word_tag_n0_word_tag = new TwoETaggedWords();
		st_word_n0_word = new TwoWords();
		
		word_int = new WordInt();
		tag_int = new ETagInt();
		word_tag_tag = new WordETagETag();
		word_word_tag = new WordWordETag();
		word_word_int = new WordWordInt();
		tag_tag_int = new ETagETagInt();
		word_tagset = new WordESetOfLabels();
		tag_tagset = new ETagESetOfLabels();
		set_of_2_tags = new ETagSet2();
		set_of_3_tags = new ETagSet3();
		
		scoredaction = new ScoredAction();
	}
	
	public EDepParser(final String sFeatureDBPath, final boolean bTrain) {
		super(sFeatureDBPath, bTrain, false);
		
		m_Agenda = new ELabeledAgendaBeam(EMacros.AGENDA_SIZE);
		m_Beam = new AgendaSimple(EMacros.AGENDA_SIZE);
		
		m_lCache = new ArrayList<ETaggedWord>();
		m_lCacheLabel = new ArrayList<EDependencyLabel>();
		
		m_weights = new EWeight(sFeatureDBPath, bTrain);
		m_nTrainingRound = 0;
		m_nTotalErrors = 0;
		m_nScoreIndex = bTrain ? Score.eNonAverage : Score.eAverage;
		
		itemForState = new ELabeledStateItem();
		itemForStates = new ELabeledStateItem(m_lCache);
		pCandidate = new ELabeledStateItem(m_lCache);
		correctState = new ELabeledStateItem(m_lCache);
		
		packed_scores = new PackedScoreType(ELabeledAction.MAX);
		
		trainSentence = new TwoStringVector();
		
		emptyParser = new LabeledDependencyParser();
		
		outParser = new LabeledDependencyParser[1];
		outParser[0] = new LabeledDependencyParser();
		
		m_lCache = new ArrayList<ETaggedWord>();
		m_lCacheLabel = new ArrayList<EDependencyLabel>();
		
		st_word_tag_n0_word_tag = new TwoETaggedWords();
		st_word_n0_word = new TwoWords();
		
		word_int = new WordInt();
		tag_int = new ETagInt();
		word_tag_tag = new WordETagETag();
		word_word_tag = new WordWordETag();
		word_word_int = new WordWordInt();
		tag_tag_int = new ETagETagInt();
		word_tagset = new WordESetOfLabels();
		tag_tagset = new ETagESetOfLabels();
		set_of_2_tags = new ETagSet2();
		set_of_3_tags = new ETagSet3();
		
		scoredaction = new ScoredAction();
	}
	
	public void getOrUpdateStackScore(final ELabeledStateItem item, PackedScoreType retval, final int action, final int amount, final int round) {
		
		final int st_index = item.stackempty() ? -1 : item.stacktop();
		final int sth_index = st_index == -1 ? -1 : item.head(st_index);
		final int sthh_index = sth_index == -1 ? -1 : item.head(sth_index);
		final int stld_index = st_index == -1 ? -1 : item.leftdep(st_index);
		final int strd_index = st_index == -1 ? -1 : item.rightdep(st_index);
		final int stl2d_index = stld_index == -1 ? -1 : item.sibling(stld_index);
		final int str2d_index = strd_index == -1 ? -1 : item.sibling(strd_index);
		final int n0_index = ((item.size() == m_lCache.size()) ? -1 : item.size());
		final int n0ld_index = n0_index == -1 ? -1 : item.leftdep(n0_index);
		final int n0l2d_index = n0ld_index == -1 ? -1 : item.sibling(n0ld_index);
		final int n1_index = ((n0_index + 1 < m_lCache.size()) ? n0_index + 1 : -1);
		final int n2_index = ((n0_index + 2 < m_lCache.size()) ? n0_index + 2 : -1);
		
		final ETaggedWord st_word_tag = st_index == -1 ? empty_taggedword : m_lCache.get(st_index);
		final ETaggedWord sth_word_tag = sth_index == -1 ? empty_taggedword : m_lCache.get(sth_index);
		final ETaggedWord sthh_word_tag = sthh_index == -1 ? empty_taggedword : m_lCache.get(sthh_index);
		final ETaggedWord stld_word_tag = stld_index == -1 ? empty_taggedword : m_lCache.get(stld_index);
		final ETaggedWord strd_word_tag = strd_index == -1 ? empty_taggedword : m_lCache.get(strd_index);
		final ETaggedWord stl2d_word_tag = stl2d_index == -1 ? empty_taggedword : m_lCache.get(stl2d_index);
		final ETaggedWord str2d_word_tag = str2d_index == -1 ? empty_taggedword : m_lCache.get(str2d_index);
		final ETaggedWord n0_word_tag = n0_index == -1 ? empty_taggedword : m_lCache.get(n0_index);
		final ETaggedWord n0ld_word_tag = n0ld_index == -1 ? empty_taggedword : m_lCache.get(n0ld_index);
		final ETaggedWord n0l2d_word_tag = n0l2d_index == -1 ? empty_taggedword : m_lCache.get(n0l2d_index);
		final ETaggedWord n1_word_tag = n1_index == -1 ? empty_taggedword : m_lCache.get(n1_index);
		final ETaggedWord n2_word_tag = n2_index == -1 ? empty_taggedword : m_lCache.get(n2_index);
		
		final Word st_word = st_word_tag.word;
		final Word sth_word = sth_word_tag.word;
		final Word sthh_word = sthh_word_tag.word;
		final Word stld_word = stld_word_tag.word;
		final Word strd_word = strd_word_tag.word;
		final Word stl2d_word = stl2d_word_tag.word;
		final Word str2d_word = str2d_word_tag.word;
		final Word n0_word = n0_word_tag.word;
		final Word n0ld_word = n0ld_word_tag.word;
		final Word n0l2d_word = n0l2d_word_tag.word;
		final Word n1_word = n1_word_tag.word;
		final Word n2_word = n2_word_tag.word;
		
		final ETag st_tag = st_word_tag.tag;
		final ETag sth_tag = sth_word_tag.tag;
		final ETag sthh_tag = sthh_word_tag.tag;
		final ETag stld_tag = stld_word_tag.tag;
		final ETag strd_tag = strd_word_tag.tag;
		final ETag stl2d_tag = stl2d_word_tag.tag;
		final ETag str2d_tag = str2d_word_tag.tag;
		final ETag n0_tag = n0_word_tag.tag;
		final ETag n0ld_tag = n0ld_word_tag.tag;
		final ETag n0l2d_tag = n0l2d_word_tag.tag;
		final ETag n1_tag = n1_word_tag.tag;
		final ETag n2_tag = n2_word_tag.tag;
		
		final int st_label = st_index == -1 ? EDependencyLabel.NONE : item.label(st_index);
		final int sth_label = sth_index == -1 ? EDependencyLabel.NONE : item.label(sth_index);
		final int stld_label = stld_index == -1 ? EDependencyLabel.NONE : item.label(stld_index);
		final int strd_label = strd_index == -1 ? EDependencyLabel.NONE : item.label(strd_index);
		final int stl2d_label = stl2d_index == -1 ? EDependencyLabel.NONE : item.label(stl2d_index);
		final int str2d_label = str2d_index == -1 ? EDependencyLabel.NONE : item.label(strd_index); //PROBLEM!
		final int n0ld_label = n0ld_index == -1 ? EDependencyLabel.NONE : item.label(n0ld_index);
		final int n0l2d_label = n0l2d_index == -1 ? EDependencyLabel.NONE : item.label(n0l2d_index);
		
		final int st_n0_dist = EMacros.encodeLinkDistance(st_index, n0_index);
		
		final int st_rarity = st_index == -1 ? 0 : item.rightarity(st_index);
		final int st_larity = st_index == -1 ? 0 : item.leftarity(st_index);
		final int n0_larity = n0_index == -1 ? 0 : item.leftarity(n0_index);
		
		final ESetOfLabels st_rtagset = st_index == -1 ? empty_setoftags : item.righttagset(st_index);
		final ESetOfLabels st_ltagset = st_index == -1 ? empty_setoftags : item.lefttagset(st_index);
		final ESetOfLabels n0_ltagset = n0_index == -1 ? empty_setoftags : item.lefttagset(n0_index);
		
		EWeight eweight = (EWeight)m_weights;
		
		if (st_index != -1) {
			eweight.m_mapSTw.getOrUpdateScore(retval, st_word, action, m_nScoreIndex, amount, round);
			eweight.m_mapSTt.getOrUpdateScore(retval, st_tag, action, m_nScoreIndex, amount, round);
			eweight.m_mapSTwt.getOrUpdateScore(retval, st_word_tag, action, m_nScoreIndex, amount, round);
		}

		if (n0_index != -1) {
			eweight.m_mapN0w.getOrUpdateScore(retval, n0_word, action, m_nScoreIndex, amount, round);
			eweight.m_mapN0t.getOrUpdateScore(retval, n0_tag, action, m_nScoreIndex, amount, round);
			eweight.m_mapN0wt.getOrUpdateScore(retval, n0_word_tag, action, m_nScoreIndex, amount, round);
		}

		if (n1_index != -1) {
			eweight.m_mapN1w.getOrUpdateScore(retval, n1_word, action, m_nScoreIndex, amount, round);
			eweight.m_mapN1t.getOrUpdateScore(retval, n1_tag, action, m_nScoreIndex, amount, round);
			eweight.m_mapN1wt.getOrUpdateScore(retval, n1_word_tag, action, m_nScoreIndex, amount, round);
		}

		if (n2_index != -1) {
			eweight.m_mapN2w.getOrUpdateScore(retval, n2_word, action, m_nScoreIndex, amount, round);
			eweight.m_mapN2t.getOrUpdateScore(retval, n2_tag, action, m_nScoreIndex, amount, round);
			eweight.m_mapN2wt.getOrUpdateScore(retval, n2_word_tag, action, m_nScoreIndex, amount, round);
		}

		if (sth_index != -1) {
			eweight.m_mapSTHw.getOrUpdateScore(retval, sth_word, action, m_nScoreIndex, amount, round);
			eweight.m_mapSTHt.getOrUpdateScore(retval, sth_tag, action, m_nScoreIndex, amount, round);
			eweight.m_mapSTi.getOrUpdateScore(retval, Integer.valueOf(st_label), action, m_nScoreIndex, amount, round);
		}

		if (sthh_index != -1) {
			eweight.m_mapSTHHw.getOrUpdateScore(retval, sthh_word, action, m_nScoreIndex, amount, round);
			eweight.m_mapSTHHt.getOrUpdateScore(retval, sthh_tag, action, m_nScoreIndex, amount, round);
			eweight.m_mapSTHi.getOrUpdateScore(retval, Integer.valueOf(sth_label), action, m_nScoreIndex, amount, round);
		}

		if (stld_index != -1) {
			eweight.m_mapSTLDw.getOrUpdateScore(retval, stld_word, action, m_nScoreIndex, amount, round);
			eweight.m_mapSTLDt.getOrUpdateScore(retval, stld_tag, action, m_nScoreIndex, amount, round);
			eweight.m_mapSTLDi.getOrUpdateScore(retval, Integer.valueOf(stld_label), action, m_nScoreIndex, amount, round);
		}

		if (strd_index != -1) {
			eweight.m_mapSTRDw.getOrUpdateScore(retval, strd_word, action, m_nScoreIndex, amount, round);
			eweight.m_mapSTRDt.getOrUpdateScore(retval, strd_tag, action, m_nScoreIndex, amount, round);
			eweight.m_mapSTRDi.getOrUpdateScore(retval, Integer.valueOf(strd_label), action, m_nScoreIndex, amount, round);
		}

		if (n0ld_index != -1) {
			eweight.m_mapN0LDw.getOrUpdateScore(retval, n0ld_word, action, m_nScoreIndex, amount, round);
			eweight.m_mapN0LDt.getOrUpdateScore(retval, n0ld_tag, action, m_nScoreIndex, amount, round);
			eweight.m_mapN0LDi.getOrUpdateScore(retval, Integer.valueOf(n0ld_label), action, m_nScoreIndex, amount, round);
		}

		if (stl2d_index != -1) {
			eweight.m_mapSTL2Dw.getOrUpdateScore(retval, stl2d_word, action, m_nScoreIndex, amount, round);
			eweight.m_mapSTL2Dt.getOrUpdateScore(retval, stl2d_tag, action, m_nScoreIndex, amount, round);
			eweight.m_mapSTL2Di.getOrUpdateScore(retval, Integer.valueOf(stl2d_label), action, m_nScoreIndex, amount, round);
		}

		if (str2d_index != -1) {
			eweight.m_mapSTR2Dw.getOrUpdateScore(retval, str2d_word, action, m_nScoreIndex, amount, round);
			eweight.m_mapSTR2Dt.getOrUpdateScore(retval, str2d_tag, action, m_nScoreIndex, amount, round);
			eweight.m_mapSTR2Di.getOrUpdateScore(retval, Integer.valueOf(str2d_label), action, m_nScoreIndex, amount, round);
		}

		if (n0l2d_index != -1) {
			eweight.m_mapN0L2Dw.getOrUpdateScore(retval, n0l2d_word, action, m_nScoreIndex, amount, round);
			eweight.m_mapN0L2Dt.getOrUpdateScore(retval, n0l2d_tag, action, m_nScoreIndex, amount, round);
			eweight.m_mapN0L2Di.getOrUpdateScore(retval, Integer.valueOf(n0l2d_label), action, m_nScoreIndex, amount, round);
		}

		if (st_index != -1) {
			st_word_tag_n0_word_tag.refer(st_word_tag, n0_word_tag);
			eweight.m_mapSTwtN0wt.getOrUpdateScore(retval, st_word_tag_n0_word_tag, action, m_nScoreIndex, amount, round);
			word_word_tag.refer(st_word, n0_word, st_tag);
			eweight.m_mapSTwtN0w.getOrUpdateScore(retval, word_word_tag, action, m_nScoreIndex, amount, round);
			word_word_tag.refer(st_word, n0_word, n0_tag);
			eweight.m_mapSTwN0wt.getOrUpdateScore(retval, word_word_tag, action, m_nScoreIndex, amount, round);
			word_tag_tag.refer(st_word, st_tag, n0_tag);
			eweight.m_mapSTwtN0t.getOrUpdateScore(retval, word_tag_tag, action, m_nScoreIndex, amount, round);
			word_tag_tag.refer(n0_word, st_tag, n0_tag);
			eweight.m_mapSTtN0wt.getOrUpdateScore(retval, word_tag_tag, action, m_nScoreIndex, amount, round);
			st_word_n0_word.refer(st_word, n0_word);
			eweight.m_mapSTwN0w.getOrUpdateScore(retval, st_word_n0_word, action, m_nScoreIndex, amount, round);
			set_of_2_tags.load(encodeTags(st_tag, n0_tag));
			eweight.m_mapSTtN0t.getOrUpdateScore(retval, set_of_2_tags, action, m_nScoreIndex, amount, round);
		}

		if (st_index != -1 && n0_index != -1) {
			set_of_2_tags.load(encodeTags(n0_tag, n1_tag));
			eweight.m_mapN0tN1t.getOrUpdateScore(retval, set_of_2_tags, action, m_nScoreIndex, amount, round);
			set_of_3_tags.load(encodeTags(n0_tag, n1_tag, n2_tag));
			eweight.m_mapN0tN1tN2t.getOrUpdateScore(retval, set_of_3_tags, action, m_nScoreIndex, amount, round);
			set_of_3_tags.load(encodeTags(st_tag, n0_tag, n1_tag));
			eweight.m_mapSTtN0tN1t.getOrUpdateScore(retval, set_of_3_tags, action, m_nScoreIndex, amount, round);
			set_of_3_tags.load(encodeTags(st_tag, n0_tag, n0ld_tag));
			eweight.m_mapSTtN0tN0LDt.getOrUpdateScore(retval, set_of_3_tags, action, m_nScoreIndex, amount, round);
			set_of_3_tags.load(encodeTags(n0_tag, n0ld_tag, n0l2d_tag));
			eweight.m_mapN0tN0LDtN0L2Dt.getOrUpdateScore(retval, set_of_3_tags, action, m_nScoreIndex, amount, round);
		}
		
		if (st_index != -1) {
			set_of_3_tags.load(encodeTags(sth_tag, st_tag, n0_tag));
			eweight.m_mapSTHtSTtN0t.getOrUpdateScore(retval, set_of_3_tags, action, m_nScoreIndex, amount, round);
			set_of_3_tags.load(encodeTags(sthh_tag, sth_tag, st_tag));
			eweight.m_mapSTHHtSTHtSTt.getOrUpdateScore(retval, set_of_3_tags, action, m_nScoreIndex, amount, round);
			set_of_3_tags.load(encodeTags(st_tag, stld_tag, n0_tag));
			eweight.m_mapSTtSTLDtN0t.getOrUpdateScore(retval, set_of_3_tags, action, m_nScoreIndex, amount, round);
			set_of_3_tags.load(encodeTags(st_tag, stld_tag, stl2d_tag));
			eweight.m_mapSTtSTLDtSTL2Dt.getOrUpdateScore(retval, set_of_3_tags, action, m_nScoreIndex, amount, round);
			set_of_3_tags.load(encodeTags(st_tag, strd_tag, n0_tag));
			eweight.m_mapSTtSTRDtN0t.getOrUpdateScore(retval, set_of_3_tags, action, m_nScoreIndex, amount, round);
			set_of_3_tags.load(encodeTags(st_tag, strd_tag, str2d_tag));
			eweight.m_mapSTtSTRDtSTR2Dt.getOrUpdateScore(retval, set_of_3_tags, action, m_nScoreIndex, amount, round);
		}

		if (st_index != -1 && n0_index != -1) {
			word_int.refer(st_word, st_n0_dist);
			eweight.m_mapSTwd.getOrUpdateScore(retval, word_int, action, m_nScoreIndex, amount, round);
			tag_int.refer(st_tag, st_n0_dist);
			eweight.m_mapSTtd.getOrUpdateScore(retval, tag_int, action, m_nScoreIndex, amount, round);
			word_int.refer(n0_word, st_n0_dist);
			eweight.m_mapN0wd.getOrUpdateScore(retval, word_int, action, m_nScoreIndex, amount, round);
			tag_int.refer(n0_tag, st_n0_dist);
			eweight.m_mapN0td.getOrUpdateScore(retval, tag_int, action, m_nScoreIndex, amount, round);
			word_word_int.refer(st_word, n0_word, st_n0_dist);
			eweight.m_mapSTwN0wd.getOrUpdateScore(retval, word_word_int, action, m_nScoreIndex, amount, round);
			tag_tag_int.refer(st_tag, n0_tag, st_n0_dist);
			eweight.m_mapSTtN0td.getOrUpdateScore(retval, tag_tag_int, action, m_nScoreIndex, amount, round);
		}

		if (st_index != -1) {
			word_int.refer(st_word, st_rarity);
			eweight.m_mapSTwra.getOrUpdateScore(retval, word_int, action, m_nScoreIndex, amount, round);
			tag_int.refer(st_tag, st_rarity);
			eweight.m_mapSTtra.getOrUpdateScore(retval, tag_int, action, m_nScoreIndex, amount, round);
			word_int.refer(st_word, st_larity);
			eweight.m_mapSTwla.getOrUpdateScore(retval, word_int, action, m_nScoreIndex, amount, round);
			tag_int.refer(st_tag, st_larity);
			eweight.m_mapSTtla.getOrUpdateScore(retval, tag_int, action, m_nScoreIndex, amount, round);
		}

		if (n0_index != -1) {
			word_int.refer(n0_word, n0_larity);
			eweight.m_mapN0wla.getOrUpdateScore(retval, word_int, action, m_nScoreIndex, amount, round);
			tag_int.refer(n0_tag, n0_larity);
			eweight.m_mapN0tla.getOrUpdateScore(retval, tag_int, action, m_nScoreIndex, amount, round);
		}

		if (st_index != -1){
			word_tagset.refer(st_word, st_rtagset);
			eweight.m_mapSTwrp.getOrUpdateScore(retval, word_tagset, action, m_nScoreIndex, amount, round);
			tag_tagset.refer(st_tag, st_rtagset);
			eweight.m_mapSTtrp.getOrUpdateScore(retval, tag_tagset, action, m_nScoreIndex, amount, round);
			word_tagset.refer(st_word, st_ltagset);
			eweight.m_mapSTwlp.getOrUpdateScore(retval, word_tagset, action, m_nScoreIndex, amount, round);
			tag_tagset.refer(st_tag, st_ltagset);
			eweight.m_mapSTtlp.getOrUpdateScore(retval, tag_tagset, action, m_nScoreIndex, amount, round);
		}

		if (n0_index != -1){
			word_tagset.refer(n0_word, n0_ltagset);
			eweight.m_mapN0wlp.getOrUpdateScore(retval, word_tagset, action, m_nScoreIndex, amount, round);
			tag_tagset.refer(n0_tag, n0_ltagset);
			eweight.m_mapN0tlp.getOrUpdateScore(retval, tag_tagset, action, m_nScoreIndex, amount, round);
		}
	}

	public void getOrUpdateStackScore(final ELabeledStateItem item, PackedScoreType retval, final int action) {
		getOrUpdateStackScore(item, retval, action, 0, 0);
	}
	
	public void updateScoreForState(final ELabeledStateItem from, final ELabeledStateItem output, final int amount, final int len) {
		itemForState.copy(from);
		while (!itemForState.equals(output)) {
			int action = itemForState.FollowMove(output);
			getOrUpdateStackScore(itemForState, null, action, amount, m_nTrainingRound);
			itemForState.Move(action);
		}
	}
	
	public void updateScoreForStates(final ELabeledStateItem output, final ELabeledStateItem correct, final int amount_add, final int amount_subtract, final int len) {
		itemForStates.clear();
		while (!itemForStates.equals(output)) {
			int action = itemForStates.FollowMove(output);
			int correct_action = itemForStates.FollowMove(correct);
			if (action == correct_action) {
				itemForStates.Move(action);
			} else {
				break;
			}
		}
		updateScoreForState(itemForStates, correct, amount_add, len);
		updateScoreForState(itemForStates, output, amount_subtract, len);
		++m_nTotalErrors;
	}
//	
//	public void reduce(final ELabeledStateItem item, final PackedScoreType scores, final boolean isprint) {
//		scoredaction.action = LabeledAction.REDUCE;
//		scoredaction.score = item.score + scores.at(scoredaction.action);
//		if (isprint) {
//			System.out.println("reduce " + scoredaction.action + " " + scoredaction.score);
//		}
//		m_Beam.insertItem(scoredaction);
//	}
//	
//	public void arcleft(final ELabeledStateItem item, final PackedScoreType scores, final boolean isprint) {
//		for (int i = EDependencyLabel.FIRST; i < EDependencyLabel.COUNT; ++i) {
//			scoredaction.action = LabeledAction.encodeAction(LabeledAction.ARC_LEFT, i);
//			scoredaction.score = item.score + scores.at(scoredaction.action);
//			if (isprint) {
//				System.out.println("arcleft " + i + " " + scoredaction.action + " " + scoredaction.score);
//			}
//			m_Beam.insertItem(scoredaction);
//		}
//	}
//	
//	public void arcright(final ELabeledStateItem item, final PackedScoreType scores, final boolean isprint) {
//		for (int i = EDependencyLabel.FIRST; i < EDependencyLabel.COUNT; ++i) {
//			scoredaction.action = LabeledAction.encodeAction(LabeledAction.ARC_RIGHT, i);
//			scoredaction.score = item.score + scores.at(scoredaction.action);
//			if (isprint) {
//				System.out.println("arcright " + i + " " + scoredaction.action + " " + scoredaction.score);
//			}
//			m_Beam.insertItem(scoredaction);
//		}
//	}
//	
//	public void shift(final ELabeledStateItem item, final PackedScoreType scores, final boolean isprint) {
//		scoredaction.action = LabeledAction.SHIFT;
//		scoredaction.score = item.score + scores.at(scoredaction.action);
//		if (isprint) {
//			System.out.println("shift " + scoredaction.action + " " + scoredaction.score);
//		}
//		m_Beam.insertItem(scoredaction);
//	}
//	
//	public void poproot(final ELabeledStateItem item, final PackedScoreType scores, final boolean isprint) {
//		scoredaction.action = LabeledAction.POP_ROOT;
//		scoredaction.score = item.score + scores.at(scoredaction.action);
//		if (isprint) {
//			System.out.println("poproot " + scoredaction.action + " " + scoredaction.score);
//		}
//		m_Beam.insertItem(scoredaction);
//	}
	
	public void reduce(final ELabeledStateItem item, final PackedScoreType scores) {
		scoredaction.action = ELabeledAction.REDUCE;
		scoredaction.score = item.score + scores.at(scoredaction.action);
		m_Beam.insertItem(scoredaction);
	}
	
	public void arcleft(final ELabeledStateItem item, final PackedScoreType scores) {
		for (int label = EDependencyLabel.FIRST; label < EDependencyLabel.COUNT; ++label) {
			if (m_weights.rules() || ETag.canAssignLabel(m_lCache, item.size(), item.stacktop(), label)) {
				scoredaction.action = ELabeledAction.encodeAction(ELabeledAction.ARC_LEFT, label);
				scoredaction.score = item.score + scores.at(scoredaction.action);
				m_Beam.insertItem(scoredaction);
			}
		}
	}
	
	public void arcright(final ELabeledStateItem item, final PackedScoreType scores) {
		for (int label = EDependencyLabel.FIRST; label < EDependencyLabel.COUNT; ++label) {
			if (m_weights.rules() || ETag.canAssignLabel(m_lCache, item.size(), item.stacktop(), label)) {
				scoredaction.action = ELabeledAction.encodeAction(ELabeledAction.ARC_RIGHT, label);
				scoredaction.score = item.score + scores.at(scoredaction.action);
				m_Beam.insertItem(scoredaction);
			}
		}
	}
	
	public void shift(final ELabeledStateItem item, final PackedScoreType scores) {
		scoredaction.action = ELabeledAction.SHIFT;
		scoredaction.score = item.score + scores.at(scoredaction.action);
		m_Beam.insertItem(scoredaction);
	}
	
	public void poproot(final ELabeledStateItem item, final PackedScoreType scores) {
		scoredaction.action = ELabeledAction.POP_ROOT;
		scoredaction.score = item.score + scores.at(scoredaction.action);
		m_Beam.insertItem(scoredaction);
	}
	
	public void work(final int round, final boolean bTrain, final TwoStringVector sentence, LabeledDependencyParser[] retval, final LabeledDependencyParser correct, final int nBest, int[] scores) {
		final int length = sentence.size();
		ELabeledStateItem pGenerator;
		
		boolean bCorrect = false;
		
		m_lCache.clear();
		for (int index = 0; index < length; ++index) {
			m_lCache.add(new ETaggedWord(sentence.get(index).first(), sentence.get(index).second()));
		}
		
		m_Agenda.clear();
		pCandidate.clear();
		m_Agenda.pushCandidate(pCandidate);
		m_Agenda.nextRound();
		if (bTrain) correctState.clear();
		
		m_lCacheLabel.clear();
		if (bTrain) {
			for (int index = 0; index < length; ++index) {
				m_lCacheLabel.add(new EDependencyLabel(correct.get(index).label));
			}
		}
		for (int index = 0; index < (length << 1); ++index) {
			
			if (bTrain) bCorrect = false;
			
			pGenerator = m_Agenda.generatorStart();
			
			for (int j = 0, agenda_size = m_Agenda.generatorSize(); j < agenda_size; ++j) {
				m_Beam.clear();
				packed_scores.reset();
				getOrUpdateStackScore(pGenerator, packed_scores, ELabeledAction.NO_ACTION);
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
					if ((!pGenerator.stackempty())) {
						if (pGenerator.head(pGenerator.stacktop()) != LabeledDependencyTreeNode.DEPENDENCY_LINK_NO_HEAD) {
							reduce(pGenerator, packed_scores);
						} else {
							arcleft(pGenerator, packed_scores);
						}
					}
				}
				
				for (int i = 0, beam_size = m_Beam.size(); i < beam_size; ++i) {
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
		for (int i = 0, retval_size = minVal(m_Agenda.generatorSize(), nBest); i < retval_size; ++i) {
			pGenerator = m_Agenda.generator(i);
			if (pGenerator != null) {
				pGenerator.GenerateTree(sentence, retval[i]);
				if (scores != null) scores[i] = pGenerator.score;
			}
		}
	}

	@Override
	public void parse(final TwoStringVector sentence, LabeledDependencyParser[] retval,
			final int nBest, int[] scores) {
		for (int i = 0; i < nBest; ++i) {
			retval[i].clear();
			if (scores != null) scores[i] = 0;
		}
		work(0, false, sentence, retval, emptyParser, nBest, scores);
	}

	@Override
	public void train(final LabeledDependencyParser correct, final int round) {
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
		((EWeight)m_weights).computeAverageFeatureWeights(m_nTrainingRound);
		((EWeight)m_weights).saveScores();
		System.out.println("Total number of training errors are: " + m_nTotalErrors);
	}

}
