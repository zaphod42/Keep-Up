package org.bgprocess.keepup.examination;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

import org.bgprocess.keepup.examination.Candidate;
import org.bgprocess.keepup.examination.ExaminationRegistrar;
import org.bgprocess.keepup.examination.Examiner;
import org.junit.Test;
import org.mockito.Mockito;

public class ExaminationRegistrarTest {
    private Examiner examiner = Mockito.mock(Examiner.class);
    private Candidate candidate = Mockito.mock(Candidate.class);
    private ExaminationRegistrar registrar = new ExaminationRegistrar(examiner);

    @Test public void
    hasNoCandidatesInTheBeginning() {
        assertThat(registrar.numberRegistered(), is(0));
    }
    
    @Test public void
    aSignedUpCandidateIncreasesTheNumberOfRegistered() {
        registrar.signUp(candidate);
        
        assertThat(registrar.numberRegistered(), is(1));
    }
    
    @Test public void
    providesAListOfTheRegisteredCandidates() {
        registrar.signUp(candidate);
        
        assertThat(registrar.candidates(), hasItem(candidate));
    }
    
    @Test public void
    notifiesTheExaminerOfTheNewCandidate() {
        registrar.signUp(candidate);
        
        Mockito.verify(examiner).examine(candidate);
    }
}
