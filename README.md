JUnit Single Method Runner
==========================
> A JUnit runner that runs a single test method of any standard JUnit 4 test class

As a [JUnit](http://junit.org) user, you sometimes want to run a single method of a test class, not the whole class. In particular, this is useful when debugging a failing test. If you are using an IDE this use case is probably supported by the UI. However, not all tests can easily be run from an IDE, and not all developers do use an IDE. One option is to put an `@Ignore` annotation on all the test methods that you want to exclude. However, if the class has many test methods, this can be quite cumbersome. Moreover, you must remember to remove the ignore annotations after the editing session. Failing to do so will permanently remove the ignored test from your test suite.

This project provides a JUnit runner that runs a user specified test method of any regular JUnit 4 test class on the classpath. The test method is specified as a Java system property at runtime.
The project includes [an example](samples/gradle) that illustrates how you would integrate [the runner](src/main/java/se/ericthelin/junit/singlemethodrunner/SingleTestMethodRunner.java) into a Gradle build. Using [the example build script](samples/gradle/build.gradle) you would run a single test method like so:

    gradle test -Dtest.method=com.example.StubbedTest.success

When executed, the command above would run the `success` method of the `StubbedTest` class in the `com.example` package. 

In general, the steps required to run a single test method are as follows:

1. Add the code in [src/main](src/main) to your classpath
2. Annotate an empty class with `@RunWith(SingleMethodRunner.class)`
3. Run the empty class with the system property `test.method` set to the fully qualified name of the test method that you want to run.
