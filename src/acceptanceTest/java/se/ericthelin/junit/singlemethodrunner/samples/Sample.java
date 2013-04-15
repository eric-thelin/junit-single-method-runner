package se.ericthelin.junit.singlemethodrunner.samples;

import java.io.File;

import se.ericthelin.junit.singlemethodrunner.SystemProperty;
import se.ericthelin.junit.singlemethodrunner.util.StringExtensions;

public enum Sample {
    GRADLE, GRADLE_MULTI_PROJECT;

    public File getRootDirectory() {
	return new File(SystemProperty.EXAMPLES_DIRECTORY.getValue(),
		StringExtensions.toHyphenatedLowerCase(name()));
    }
}
