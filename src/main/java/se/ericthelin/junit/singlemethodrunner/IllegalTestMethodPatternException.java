package se.ericthelin.junit.singlemethodrunner;

public class IllegalTestMethodPatternException extends RuntimeException {

    public IllegalTestMethodPatternException(String testMethodPattern) {
	super(String.format("Illegal test method pattern: %s",
		testMethodPattern));
    }
}
