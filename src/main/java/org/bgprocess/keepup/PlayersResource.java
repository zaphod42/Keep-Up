package org.bgprocess.keepup;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("players")
public class PlayersResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Players list() {
		return Players.instance();
	}
	
	@PUT
	public Response addPlayer(Player player, @Context UriInfo uri) {
		int id = Players.instance().add(player);
		return Response.noContent()
					   .contentLocation(uri.getAbsolutePathBuilder().path(PlayersResource.class, "getPlayer").build(id))
					   .build();
	}
	
	@GET
	@Path("/{id: \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Player getPlayer(@PathParam("id") int id) {
		return Players.instance().get(id);
	}
}
