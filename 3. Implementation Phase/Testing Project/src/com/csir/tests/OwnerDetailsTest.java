package com.csir.tests;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.junit.Test;

public class OwnerDetailsTest {

	@Test
	public final void test() throws JSONException {
	
		ServiceClientWrapper obj = new ServiceClientWrapper();
		//String result = obj.getOwnerDetails(1).toString();
		//System.out.println(result);
		assertNull(obj.owners);
		
	}

}
