package com.kharidlo.service.demo;

import org.junit.Assert;
import org.junit.Test;

public class DemoTest {
    @Test
    public void shouldReturnTrue(){
        Demo demo=new Demo();
        Assert.assertTrue(demo.testMethod());
    }
}
