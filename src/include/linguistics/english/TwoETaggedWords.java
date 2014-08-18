package include.linguistics.english;

import include.Bigram;

public final class TwoETaggedWords extends Bigram<ETaggedWord> {
	public TwoETaggedWords() {
		super();
	}
	
	public TwoETaggedWords(final TwoETaggedWords twotaggedwords) {
		refer(twotaggedwords.m_unigram1, twotaggedwords.m_unigram2);
	}
	
	public TwoETaggedWords(final ETaggedWord w1, final ETaggedWord w2) {
		super(w1, w2);
	}

	@Override
	protected ETaggedWord create_unigram(final ETaggedWord u) {
		return u;
	}
}
