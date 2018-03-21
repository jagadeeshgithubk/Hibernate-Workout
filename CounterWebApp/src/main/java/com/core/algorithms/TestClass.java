package com.core.algorithms;

import java.util.ArrayList;
import java.util.List;


interface BaseI { void method(); }
class BaseC
{
public void method()
{
System.out.println("Inside BaseC::method");
}
}
class TestClass extends BaseC implements BaseI
{
public static void main(String []s)
{
(new TestClass()).method();
}
}
