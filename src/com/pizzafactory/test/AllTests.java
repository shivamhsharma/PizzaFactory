package com.pizzafactory.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ OrderServiceTest.class })
public class AllTests {

}
