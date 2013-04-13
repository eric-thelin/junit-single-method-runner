package se.ericthelin.junit.singlemethodrunner;

import org.junit.runner.Description;

public class TestMethodReference {

    private final Class<?> testClass;
    private final String methodName;

    public TestMethodReference(String value) throws ClassNotFoundException {
	int indexOfLastDot = value.lastIndexOf('.');

	if (indexOfLastDot < 0 || indexOfLastDot >= value.length() - 1) {
	    throw new IllegalTestMethodPatternException(value);
	}

	testClass = Class.forName(value.substring(0, indexOfLastDot));
	methodName = value.substring(indexOfLastDot + 1);
    }

    public Description toDescription() {
	return Description.createTestDescription(testClass, methodName);
    }

    public Class<?> getTestClass() {
	return testClass;
    }
}
