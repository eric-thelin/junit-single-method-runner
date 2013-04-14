package se.ericthelin.junit.singlemethodrunner.util;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;

import java.util.ArrayList;
import java.util.Collection;

import org.hamcrest.Matcher;

public class StringMatchers {

    public static Matcher<? super String> containsAll(String... substrings) {
	Collection<Matcher<? super String>> submatchers = new ArrayList<>(
		substrings.length);

	for (String subString : substrings) {
	    submatchers.add(containsString(subString));
	}

	return allOf(submatchers);
    }
}
