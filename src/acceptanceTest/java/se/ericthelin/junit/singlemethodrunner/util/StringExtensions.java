package se.ericthelin.junit.singlemethodrunner.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringExtensions {

    private static final Set<Character> WORD_SEPARATOR_CHARACTERS = new HashSet<>(
	    Arrays.asList(' ', '_'));

    public static String toLowerCamelCase(String subject) {
	if (subject.isEmpty()) {
	    return subject;
	}

	StringBuilder result = new StringBuilder(subject.length());

	boolean lastCharacterWasSeparator = true;

	for (int i = 0; i < subject.length(); i++) {
	    char c = subject.charAt(i);
	    if (WORD_SEPARATOR_CHARACTERS.contains(c)) {
		lastCharacterWasSeparator = true;
	    } else {

		result.append(transformedCharacter(c,
			isStartOfNextWord(result, lastCharacterWasSeparator)));

		lastCharacterWasSeparator = false;
	    }
	}

	return result.toString();
    }

    private static char transformedCharacter(char c, boolean startOfNextWord) {
	if (startOfNextWord) {
	    return Character.toUpperCase(c);
	} else {
	    return Character.toLowerCase(c);
	}
    }

    private static boolean isStartOfNextWord(StringBuilder result,
	    boolean lastCharacterWasSeparator) {
	return result.length() != 0 && lastCharacterWasSeparator;
    }
}
