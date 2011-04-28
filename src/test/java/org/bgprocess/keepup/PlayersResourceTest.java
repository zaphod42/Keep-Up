package org.bgprocess.keepup;

import static org.junit.Assert.assertEquals;

import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;

import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;


public class PlayersResourceTest extends JerseyTest{
	public PlayersResourceTest() {
		super(new WebAppDescriptor.Builder("javax.ws.rs.Application", KeepUp.class.getName())
			.initParam(JSONConfiguration.FEATURE_POJO_MAPPING, "true")
			.build());
	}
	
	@Test public void
	hasNoPlayersAtFirst() throws Exception {
		JSONObject players = new JSONObject(resource().path("/players").get(String.class));
		
		assertEquals(0, players.getJSONArray("players").length());
	}
}
