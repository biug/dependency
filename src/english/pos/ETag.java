package english.pos;

import include.linguistics.LabeledDependencyTreeNode;
import include.linguistics.english.ETaggedWord;

import java.util.ArrayList;

import english.dependency.label.EDependencyLabel;


public final class ETag {
	public final static String[] PENN_TAG_STRINGS = {
		"-NONE-",
		"-BEGIN-",
		"-END-",
		"$", "``", "''",
		"-LRB-", "-RRB-", ",",
		".", ":", "#",
		"CC", "CD", "DT", "EX", "FW",
		"IN", "JJ", "JJR", "JJS", "LS",
		"MD", "NN", "NNP", "NNPS", "NNS",
		"PDT", "POS", "PRP", "PRP$",
		"RB", "RBR", "RBS", "RP",
		"SYM", "TO", "UH",
		"VB", "VBD", "VBG", "VBN", "VBP", "VBZ",
		"WDT", "WP", "WP$", "WRB"
	};

	public final static int PENN_TAG_NONE = 0;
	public final static int PENN_TAG_BEGIN = 1;
	public final static int PENN_TAG_END = 2;
	public final static int PENN_TAG_DOLLAR = 3;
	public final static int PENN_TAG_L_QUOTE = 4;
	public final static int PENN_TAG_R_QUOTE = 5;
	public final static int PENN_TAG_L_BRACKET = 6;
	public final static int PENN_TAG_R_BRACKET = 7;
	public final static int PENN_TAG_COMMA = 8;
	public final static int PENN_TAG_PERIOD = 9;
	public final static int PENN_TAG_COLUM = 10;
	public final static int PENN_TAG_SHART = 11;
	public final static int PENN_TAG_CC = 12;
	public final static int PENN_TAG_CD = 13;
	public final static int PENN_TAG_DT = 14;
	public final static int PENN_TAG_EX = 15;
	public final static int PENN_TAG_FW = 16;
	public final static int PENN_TAG_IN = 17;
	public final static int PENN_TAG_ADJECTIVE = 18;
	public final static int PENN_TAG_ADJECTIVE_COMPARATIVE = 19;
	public final static int PENN_TAG_ADJECTIVE_SUPERLATIVE = 20;
	public final static int PENN_TAG_LS = 21;
	public final static int PENN_TAG_MD = 22;
	public final static int PENN_TAG_NOUN = 23;
	public final static int PENN_TAG_NOUN_PROPER = 24;
	public final static int PENN_TAG_NOUN_PROPER_PLURAL = 25;
	public final static int PENN_TAG_NOUN_PLURAL = 26;
	public final static int PENN_TAG_PDT = 27;
	public final static int PENN_TAG_POS = 28;
	public final static int PENN_TAG_PRP = 29;
	public final static int PENN_TAG_PRP_DOLLAR = 30;
	public final static int PENN_TAG_ADVERB = 31;
	public final static int PENN_TAG_ADVERB_COMPARATIVE = 32;
	public final static int PENN_TAG_ADVERB_SUPERLATIVE = 33;
	public final static int PENN_TAG_RP = 34;
	public final static int PENN_TAG_SYM = 35;
	public final static int PENN_TAG_TO = 36;
	public final static int PENN_TAG_UH = 37;
	public final static int PENN_TAG_VERB = 38;
	public final static int PENN_TAG_VERB_PAST = 39;
	public final static int PENN_TAG_VERB_PROG = 40;
	public final static int PENN_TAG_VERB_PAST_PARTICIPATE = 41;
	public final static int PENN_TAG_VERB_PRES = 42;
	public final static int PENN_TAG_VERB_THIRD_SINGLE = 43;
	public final static int PENN_TAG_WDT = 44;
	public final static int PENN_TAG_WP = 45;
	public final static int PENN_TAG_WP_DOLLAR = 46;
	public final static int PENN_TAG_WRB = 47;
	public final static int PENN_TAG_COUNT = 48;
	
	public final static boolean[] PENN_TAG_CLOSED = {
		false,
		true,
		true,
		true, true, true,
		true, true, true,
		true, true, true,
		true, false, true, true, false,
		true, false, false, false, false,
		true, false, false, false, false,
		true, true, true, true,
		false, false, false, false,
		false, true, false,
		false, false, false, false, false, false,
		true, true, true, true
	};
	
	public final static int PENN_TAG_FIRST = 3;
	public final static int PENN_TAG_COUNT_BITS = 6;
	
	
	public final long PENN_TAG_MUST_SEE = (((long)1 << PENN_TAG_SYM) | ((long)1 << PENN_TAG_FW) | ((long)1 << PENN_TAG_CD) | ((long)1 << PENN_TAG_LS) | ((long)1 << PENN_TAG_NOUN_PROPER) | ((long)1 << PENN_TAG_NOUN_PROPER_PLURAL));

	public static final int NONE = PENN_TAG_NONE;
	public static final int SENTENCE_BEGIN = PENN_TAG_BEGIN;
	public static final int SENTENCE_END = PENN_TAG_END;
	public static final int COUNT = PENN_TAG_COUNT;
	public static final int MAX_COUNT = PENN_TAG_COUNT;
	public static final int SIZE = PENN_TAG_COUNT_BITS;
	public static final int FIRST = PENN_TAG_FIRST;
	public static final int LAST = PENN_TAG_COUNT - 1;
	
	protected int m_code; // unsigned
	
	public ETag() {
		m_code = NONE;
	}
	
	public ETag(int t) {
		m_code = t;
	}
	
	public ETag(final ETag t) {
		m_code = t.m_code;
	}
	
	public ETag(final String s) {
		load(s);
	}
	
	@Override
	public int hashCode() {
		return m_code;
	}
	
	@Override
	public boolean equals(final Object t) {
		return m_code == ((ETag)t).m_code;
	}
	
	@Override
	public String toString() {
		return PENN_TAG_STRINGS[m_code];
	}

	public void load(final int i) {
		m_code = i;
	}
	
	public void load(String s) {
		m_code = PENN_TAG_NONE;
		for (int i = 0; i < PENN_TAG_COUNT; ++i) {
			if (PENN_TAG_STRINGS[i].equals(s)) {
				m_code = i;
				return;
			}
		}		
	}
	
	public static String str(final int t) {
		return PENN_TAG_STRINGS[t];
	}
	
	public static int code(final String s) {
		for (int i = 0; i < PENN_TAG_COUNT; ++i) {
			if (PENN_TAG_STRINGS[i].equals(s)) {
				return i;
			}
		}
		return NONE;
	}
	
	public static boolean canAssignLabel(final ArrayList<ETaggedWord> sent, final int head, final int dep, final int label) {
		if (head == LabeledDependencyTreeNode.DEPENDENCY_LINK_NO_HEAD) {
			return label == EDependencyLabel.PENN_DEP_ROOT;
		}
		final int head_tag = sent.get(head).tag.hashCode();
		final int dep_tag = sent.get(dep).tag.hashCode();
		switch (label) {
		case EDependencyLabel.PENN_DEP_ROOT:
			return false;
		case EDependencyLabel.PENN_DEP_AMOD: 
			return (head_tag == PENN_TAG_NOUN_PLURAL ||
					head_tag == PENN_TAG_CD ||
					head_tag == PENN_TAG_IN ||
					head_tag == PENN_TAG_DOLLAR ||
					head_tag == PENN_TAG_DT ||
					head_tag == PENN_TAG_WRB ||
					head_tag == PENN_TAG_ADVERB_SUPERLATIVE ||
					head_tag == PENN_TAG_ADVERB ||
					head_tag == PENN_TAG_ADJECTIVE_SUPERLATIVE ||
					head_tag == PENN_TAG_VERB_PAST_PARTICIPATE ||
					head_tag == PENN_TAG_ADJECTIVE ||
					head_tag == PENN_TAG_ADVERB_COMPARATIVE ||
					head_tag == PENN_TAG_ADJECTIVE_COMPARATIVE ||
					head_tag == PENN_TAG_NOUN);
		case EDependencyLabel.PENN_DEP_DEP: 
			return true;
		case EDependencyLabel.PENN_DEP_NMOD: 
			return (head_tag == PENN_TAG_NOUN_PLURAL ||
					head_tag == PENN_TAG_CD ||
					head_tag == PENN_TAG_IN ||
					head_tag == PENN_TAG_DOLLAR ||
					head_tag == PENN_TAG_WDT ||
					head_tag == PENN_TAG_FW ||
					head_tag == PENN_TAG_DT ||
					head_tag == PENN_TAG_WRB ||
					head_tag == PENN_TAG_ADVERB ||
					head_tag == PENN_TAG_UH ||
					head_tag == PENN_TAG_VERB_PROG ||
					head_tag == PENN_TAG_ADJECTIVE_SUPERLATIVE ||
					head_tag == PENN_TAG_PRP ||
					head_tag == PENN_TAG_ADJECTIVE ||
					head_tag == PENN_TAG_WP ||
					head_tag == PENN_TAG_NOUN_PROPER_PLURAL ||
					head_tag == PENN_TAG_POS ||
					head_tag == PENN_TAG_ADJECTIVE_COMPARATIVE ||
					head_tag == PENN_TAG_NOUN_PROPER ||
					head_tag == PENN_TAG_NOUN ||
					head_tag == PENN_TAG_WP_DOLLAR);
		case EDependencyLabel.PENN_DEP_OBJ: 
			return (head_tag == PENN_TAG_VERB_PAST ||
					head_tag == PENN_TAG_VERB_PAST_PARTICIPATE ||
					head_tag == PENN_TAG_VERB ||
					head_tag == PENN_TAG_VERB_PRES ||
					head_tag == PENN_TAG_VERB_THIRD_SINGLE ||
					head_tag == PENN_TAG_VERB_PROG);
		case EDependencyLabel.PENN_DEP_P: 
			return (dep_tag == PENN_TAG_R_QUOTE ||
					dep_tag == PENN_TAG_SHART ||
					dep_tag == PENN_TAG_L_QUOTE ||
					dep_tag == PENN_TAG_L_BRACKET ||
					dep_tag == PENN_TAG_PERIOD ||
					dep_tag == PENN_TAG_COMMA ||
					dep_tag == PENN_TAG_R_BRACKET ||
					dep_tag == PENN_TAG_DOLLAR ||
					dep_tag == PENN_TAG_COLUM);
		case EDependencyLabel.PENN_DEP_PMOD: 
			return (head_tag == PENN_TAG_ADVERB ||
					head_tag == PENN_TAG_VERB_PROG ||
					head_tag == PENN_TAG_TO ||
					head_tag == PENN_TAG_CC ||
					head_tag == PENN_TAG_VERB_PAST_PARTICIPATE ||
					head_tag == PENN_TAG_IN ||
					head_tag == PENN_TAG_FW);
		case EDependencyLabel.PENN_DEP_PRD: 
			return (head_tag == PENN_TAG_VERB_PROG ||
					head_tag == PENN_TAG_VERB ||
					head_tag == PENN_TAG_VERB_THIRD_SINGLE ||
					head_tag == PENN_TAG_VERB_PAST ||
					head_tag == PENN_TAG_VERB_PAST_PARTICIPATE ||
					head_tag == PENN_TAG_VERB_PRES);
		case EDependencyLabel.PENN_DEP_SBAR: 
			return (head_tag == PENN_TAG_DT ||
					head_tag == PENN_TAG_IN ||
					head_tag == PENN_TAG_WRB ||
					head_tag == PENN_TAG_WP_DOLLAR ||
					head_tag == PENN_TAG_WP ||
					head_tag == PENN_TAG_WDT);
		case EDependencyLabel.PENN_DEP_SUB: 
			return(head_tag == PENN_TAG_MD ||
					head_tag == PENN_TAG_IN ||
					head_tag == PENN_TAG_VERB_PROG ||
					head_tag == PENN_TAG_VERB ||
					head_tag == PENN_TAG_VERB_THIRD_SINGLE ||
					head_tag == PENN_TAG_VERB_PAST ||
					head_tag == PENN_TAG_VERB_PAST_PARTICIPATE ||
					head_tag == PENN_TAG_ADJECTIVE ||
					head_tag == PENN_TAG_NOUN ||
					head_tag == PENN_TAG_VERB_PRES);
		case EDependencyLabel.PENN_DEP_VC: 
			return (head_tag == PENN_TAG_VERB_PAST ||
					head_tag == PENN_TAG_MD ||
					head_tag == PENN_TAG_VERB_PAST_PARTICIPATE ||
					head_tag == PENN_TAG_VERB ||
					head_tag == PENN_TAG_VERB_PRES ||
					head_tag == PENN_TAG_VERB_THIRD_SINGLE ||
					head_tag == PENN_TAG_VERB_PROG);
		case EDependencyLabel.PENN_DEP_VMOD:
			return (head_tag == PENN_TAG_NOUN_PLURAL ||
					head_tag == PENN_TAG_MD ||
					head_tag == PENN_TAG_IN ||
					head_tag == PENN_TAG_VERB_PROG ||
					head_tag == PENN_TAG_VERB ||
					head_tag == PENN_TAG_VERB_THIRD_SINGLE ||
					head_tag == PENN_TAG_VERB_PAST ||
					head_tag == PENN_TAG_VERB_PAST_PARTICIPATE ||
					head_tag == PENN_TAG_ADJECTIVE ||
					head_tag == PENN_TAG_NOUN ||
					head_tag == PENN_TAG_VERB_PRES);
		}
		return false;
	}
	
	public static boolean hasLeftHead(final int tag) {
		switch (tag) {
			case PENN_TAG_PRP_DOLLAR:
			case PENN_TAG_SHART:
			case PENN_TAG_POS:
			case PENN_TAG_L_BRACKET:
			case PENN_TAG_LS:
			case PENN_TAG_EX:
				return true;
			default:
				return false;
		}
	}
	
	public static boolean hasRight(final int tag) {
		switch (tag) {
			case PENN_TAG_WDT:
			case PENN_TAG_RP:
			case PENN_TAG_PERIOD:
			case PENN_TAG_WP_DOLLAR:
			case PENN_TAG_R_BRACKET:
				return true;
			default:
				return false;
		}
	}
	
	public static boolean canBeRoot(final int tag) {
		return (tag == PENN_TAG_VERB_PROG || tag == PENN_TAG_VERB_PAST || tag == PENN_TAG_VERB_PAST_PARTICIPATE || tag == PENN_TAG_VERB_PRES || tag == PENN_TAG_WDT || tag == PENN_TAG_ADJECTIVE || tag == PENN_TAG_WP || tag == PENN_TAG_VERB_THIRD_SINGLE || tag == PENN_TAG_DT || tag == PENN_TAG_DOLLAR || tag == PENN_TAG_NOUN || tag == PENN_TAG_FW || tag == PENN_TAG_POS || tag == PENN_TAG_TO || tag == PENN_TAG_ADVERB || tag == PENN_TAG_NOUN_PLURAL || tag == PENN_TAG_NOUN_PROPER || tag == PENN_TAG_VERB || tag == PENN_TAG_WRB || tag == PENN_TAG_CC || tag == PENN_TAG_ADVERB_COMPARATIVE || tag == PENN_TAG_CD || tag == PENN_TAG_IN || tag == PENN_TAG_WP_DOLLAR || tag == PENN_TAG_MD || tag == PENN_TAG_NOUN_PROPER_PLURAL || tag == PENN_TAG_ADJECTIVE_COMPARATIVE || tag == PENN_TAG_SYM || tag == PENN_TAG_UH);
	}
}
