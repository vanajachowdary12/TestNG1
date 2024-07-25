package com.hyr.dpTests;

import java.util.Set;

import java.util.HashSet;
import java.util.Iterator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BasicTest2 {
	@Test(dataProvider = "dp1")
	public void TestLogin(Object[] s) throws Exception {
		System.out.println(s[0] + " >> " + s[1]);
	}

	@DataProvider()
	public Iterator<Object[]> dp1() {
		Set<Object[]> data = new HashSet<>();
		data.add(new Object[] { "Yadagiri", 123 });
		data.add(new Object[] { "Jhon", 456 });
		return data.iterator();
	}
}
