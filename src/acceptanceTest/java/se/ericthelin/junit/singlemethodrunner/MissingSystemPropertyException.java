package se.ericthelin.junit.singlemethodrunner;


public class MissingSystemPropertyException extends RuntimeException {

    public MissingSystemPropertyException(SystemProperty systemProperty) {
	super(String
		.format("System property \"%s\" is not set", systemProperty));
    }
}
