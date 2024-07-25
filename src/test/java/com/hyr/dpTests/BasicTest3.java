package com.hyr.dpTests;

import org.testng.annotations.Test;

public class BasicTest3 {
	@Test(dataProvider = "dp1", dataProviderClass = DataSupplier.class)
	public void TestLogin(String s) throws Exception {
		System.out.println(s);
	}
	
}
