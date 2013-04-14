package se.ericthelin.junit.singlemethodrunner.samples;

import java.io.File;

import se.ericthelin.junit.singlemethodrunner.SystemProperty;
import se.ericthelin.junit.singlemethodrunner.util.StringExtensions;

public enum Sample {
    GRADLE;

    public File getRootDirectory() {
	return new File(SystemProperty.SAMPLES_DIRECTORY.getValue(),
		StringExtensions.toLowerCamelCase(name()));
    }
}
