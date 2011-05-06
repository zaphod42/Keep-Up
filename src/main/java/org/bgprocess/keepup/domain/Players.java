package org.bgprocess.keepup.domain;

import java.util.Collection;
import java.util.UUID;

import org.bgprocess.keepup.examination.Candidate;
import org.bgprocess.keepup.examination.ExaminationRegistrar;
import org.bgprocess.keepup.examination.Examiner;
import org.codehaus.jackson.annotate.JsonProperty;

public class Players {
    private ExaminationRegistrar registrar = new ExaminationRegistrar(new Examiner() {
        @Override
        public void examine(Candidate candidate) {}
    });

    public synchronized String add(Player player) {
        player.score = 0;
        return registrar.signUp(player).toString();
    }

    public Player get(String id) {
        return (Player)registrar.whoIs(UUID.fromString(id));
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @JsonProperty("players")
    public Collection<Player> allPlayers() {
        return (Collection)registrar.candidates();
    }
}
