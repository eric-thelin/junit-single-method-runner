package se.ericthelin.junit.singlemethodrunner.samples.gradle;

import java.io.ByteArrayOutputStream;
import java.io.File;

import org.gradle.tooling.BuildException;
import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.ProjectConnection;

public class GradleRun {

    private File directory = new File(".");
    private String[] tasks = {};
    private String[] jvmArguments = {};

    public GradleRun in(File directory) {
	this.directory = directory;

	return this;
    }

    public GradleRun forTasks(String... tasks) {
	this.tasks = tasks;

	return this;
    }

    public GradleRun withJVMArguments(String... jvmArguments) {
	this.jvmArguments = jvmArguments;

	return this;
    }

    public String perform() {
	return performWith(GradleConnector.newConnector());
    }

    private String performWith(GradleConnector connector) {
	ProjectConnection connection = connector.forProjectDirectory(directory)
		.connect();

	try {
	    return performWith(connection);
	} finally {
	    connection.close();
	}
    }

    private String performWith(ProjectConnection connection) {
	ByteArrayOutputStream standardOut = new ByteArrayOutputStream();

	try {
	    connection.newBuild().forTasks(tasks).setJvmArguments(jvmArguments)
		    .setStandardOutput(standardOut).run();
	} catch (BuildException e) {

	}

	return standardOut.toString();
    }
}
