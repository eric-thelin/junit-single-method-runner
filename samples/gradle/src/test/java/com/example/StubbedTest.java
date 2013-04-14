package com.example;

import static org.junit.Assert.fail;

import org.junit.Test;

public class StubbedTest {

    @Test
    public void success() {
    }

    @Test
    public void failure() {
	fail("Expected");
    }
}
