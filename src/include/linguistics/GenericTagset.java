package include.linguistics;

import include.Tokenizer;

public class GenericTagset extends Tokenizer {
	public GenericTagset() {
		super(0);
		lookup("-NONE-");
	}
}
