package org.bgprocess.keepup.webinterface.data;

import java.net.URI;
import java.util.UUID;

import org.bgprocess.keepup.examination.Candidate;
import org.bgprocess.keepup.examination.ExaminationRegistrar;
import org.codehaus.jackson.annotate.JsonProperty;

public class Player implements Candidate {
    public UUID id;
    public String name;
    public URI url;
    
    private ExaminationRegistrar registrar;
    
    @JsonProperty("score")
    public int score() {
        return registrar.resultsFor(id).score();
    }
    
    public void registeredAs(UUID id, ExaminationRegistrar registrar) {
        this.registrar = registrar;
        this.id = id;
    }
}
