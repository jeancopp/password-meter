package br.com.coppieters.score.decremental;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.com.coppieters.utils.Regex;

@Component
@Profile("dev")
public class AmericanLetterOnlyScoreCalculator implements LetterOnly{
	private final Logger LOG = Logger.getLogger(getClass());
	
	public AmericanLetterOnlyScoreCalculator() {
		LOG.info("Injetando AmericanLetterOnly");
	}

	@Override
	public Integer apply(String t) {
		return t.replaceAll(Regex.LetterIgnoreCase.getRegex(), "").length() > 0 ? 0 : t.length() ;//	-n
	}

}
