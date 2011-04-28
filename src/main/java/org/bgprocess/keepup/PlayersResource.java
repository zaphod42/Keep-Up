package org.bgprocess.keepup;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("players")
public class PlayersResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Players list() {
		return new Players();
	}
}
