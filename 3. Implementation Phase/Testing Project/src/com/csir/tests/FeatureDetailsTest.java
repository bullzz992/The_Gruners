package com.csir.tests;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.junit.Test;

public class FeatureDetailsTest {

	@Test
	public final void testGetFeatureDetails() throws JSONException {
		ServiceClientWrapper obj = new ServiceClientWrapper();
		//String result = obj.getFeatureDetails(1).getString("make");
		assertNull(obj.vehicles);
		
	}

}
