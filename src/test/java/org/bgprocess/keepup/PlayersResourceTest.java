package org.bgprocess.keepup;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse;
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
	
	@Test public void
	afterAPlayerIsAddedItShowsUpInTheList() throws Exception {
		resource().path("/players").put(new JSONObject().accumulate("name", "bob and joe").accumulate("url", "http://example.com"));
		
		JSONObject playersResponse = new JSONObject(resource().path("/players").get(String.class));
		
		JSONArray players = playersResponse.getJSONArray("players");
		assertEquals(1, players.length());
		assertEquals("bob and joe", players.getJSONObject(0).get("name"));
		assertEquals("http://example.com", players.getJSONObject(0).get("url"));
	}

	@Test public void
	theUrlToTheAddedPlayerIsReturned() throws Exception {
		ClientResponse response = resource().path("/players").put(ClientResponse.class, new JSONObject().accumulate("name", "bob and joe").accumulate("url", "http://example.com"));
		
		JSONObject player = resource().uri(new URI(response.getHeaders().getFirst("Content-Location"))).get(JSONObject.class);
		
		assertEquals("bob and joe", player.get("name"));
		assertEquals("http://example.com", player.get("url"));
	}
}
