package se.ericthelin.junit.singlemethodrunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.junit.runner.Description;

public class TestMethodReferenceTest {

    @Test
    public void parsesPattern() throws ClassNotFoundException {
	assertThat(
		new TestMethodReference("java.lang.Object.toString")
			.toDescription(),
		is(Description.createTestDescription("java.lang.Object",
			"toString")));
    }

    @Test(expected = NullPointerException.class)
    public void rejectsMissingPattern() throws ClassNotFoundException {
	new TestMethodReference(null);
    }

    @Test(expected = IllegalTestMethodPatternException.class)
    public void rejectsPatternWithNoDot() throws ClassNotFoundException {
	new TestMethodReference("stringWithNoDots");
    }

    @Test(expected = IllegalTestMethodPatternException.class)
    public void rejectsPatternThatEndsWithADot() throws ClassNotFoundException {
	new TestMethodReference("com.example.Foo.");
    }
}
