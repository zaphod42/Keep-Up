package org.bgprocess.keepup.webinterface;

import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import org.bgprocess.keepup.domain.Players;

import com.sun.jersey.spi.inject.SingletonTypeInjectableProvider;


@Provider
public class PlayersProvider extends SingletonTypeInjectableProvider<Context, Players> {
    public PlayersProvider() {
        super(Players.class, new Players());
    }
}
