package org.bgprocess.keepup.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class ExaminationRegistrarTest {
    @Test public void
    hasNoCandidatesInTheBeginning() {
        ExaminationRegistrar registrar = new ExaminationRegistrar();
        assertThat(registrar.numberRegistered(), is(0));
    }
    
    @Test public void
    aSignedUpCandidateIncreasesTheNumberOfRegistered() {
        ExaminationRegistrar registrar = new ExaminationRegistrar();
        
        registrar.signUp(new Candidate());
        
        assertThat(registrar.numberRegistered(), is(1));
    }
    
    @Test public void
    providesAListOfTheRegisteredCandidates() {
        Candidate candidate = new Candidate();
        ExaminationRegistrar registrar = new ExaminationRegistrar();
        
        registrar.signUp(candidate);
        
        assertThat(registrar.candidates(), hasItem(candidate));
    }
}
