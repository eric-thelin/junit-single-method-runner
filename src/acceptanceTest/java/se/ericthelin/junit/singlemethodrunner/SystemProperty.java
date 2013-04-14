package se.ericthelin.junit.singlemethodrunner;

import se.ericthelin.junit.singlemethodrunner.util.StringExtensions;

public enum SystemProperty {
    SAMPLES_DIRECTORY;

    public String getName() {
	return StringExtensions.toLowerCamelCase(name());
    }

    public String getValue() {
	if (tryToGetValue() == null) {
	    throw new MissingSystemPropertyException(this);
	}

	return tryToGetValue();
    }

    private String tryToGetValue() {
	return System.getProperty(getName());
    }

    @Override
    public String toString() {
	return this.getName();
    }
}
