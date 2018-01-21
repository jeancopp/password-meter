package br.com.coppieters.score.decremental;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.com.coppieters.utils.Regex;

@Component
@Profile("prod")
public class RussianLetterOnlyScoreCalculator implements LetterOnly{

	private final Logger LOG = Logger.getLogger(getClass());
	
	public RussianLetterOnlyScoreCalculator() {
		LOG.info("Injetando RussianLetterOnly");
	}
	
	@Override
	public Integer apply(String t) {
		return t.replaceAll(Regex.LetterIgnoreCase.getRegex(), "").length() > 0 ? 0 : t.length() ;//	-n	
	}
}

