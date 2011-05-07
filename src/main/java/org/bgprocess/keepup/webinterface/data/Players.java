package org.bgprocess.keepup.webinterface.data;

import java.util.Collection;
import java.util.UUID;

import org.bgprocess.keepup.examination.Candidate;
import org.bgprocess.keepup.examination.ExaminationRegistrar;
import org.bgprocess.keepup.examination.Examiner;
import org.bgprocess.keepup.examination.MarkingSheet;
import org.codehaus.jackson.annotate.JsonProperty;

public class Players {
    private ExaminationRegistrar registrar = new ExaminationRegistrar(new Examiner() {
        @Override
        public void examine(Candidate candidate, MarkingSheet marks) {}
    });

    public synchronized String add(Player player) {
        UUID id = registrar.signUp(player);
        player.registeredAs(id, registrar);
        return id.toString();
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
