package org.bgprocess.keepup.webinterface;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.bgprocess.keepup.webinterface.data.Player;
import org.bgprocess.keepup.webinterface.data.Players;

@Path("players")
public class PlayersResource {
    @Context private Players players;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Players list() {
        return players;
    }
    
    @PUT
    public Response addPlayer(Player player, @Context UriInfo uri) {
        String id = players.add(player);
        return Response.noContent()
                       .contentLocation(uri.getAbsolutePathBuilder().path(PlayersResource.class, "getPlayer").build(id))
                       .build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Player getPlayer(@PathParam("id") String id) {
        return players.get(id);
    }
}
