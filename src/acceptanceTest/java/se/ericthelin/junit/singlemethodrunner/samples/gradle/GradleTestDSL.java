package se.ericthelin.junit.singlemethodrunner.samples.gradle;

import java.io.File;

import se.ericthelin.junit.singlemethodrunner.samples.Sample;

public class GradleTestDSL {

    public static String outputOf(GradleRun gradleRun) {
	return gradleRun.perform();
    }

    public static GradleRun aGradleRun() {
	return new GradleRun();
    }

    public static File rootDirectoryOf(Sample sample) {
	return sample.getRootDirectory();
    }
}
