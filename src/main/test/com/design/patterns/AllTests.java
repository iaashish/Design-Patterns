package com.design.patterns;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ testFileFreq.class, testFileGrep.class, testFileWordCount.class })
public class AllTests {

}
