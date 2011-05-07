package org.bgprocess.keepup.examination;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

import java.util.UUID;

import org.bgprocess.keepup.examination.Candidate;
import org.bgprocess.keepup.examination.ExaminationRegistrar;
import org.bgprocess.keepup.examination.Examiner;
import org.hamcrest.Matchers;
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
        
        Mockito.verify(examiner).examine(Mockito.eq(candidate), Mockito.isA(MarkingSheet.class));
    }
    
    @Test public void
    providesAnIdentifierForTheCandidate() {
        UUID id = registrar.signUp(candidate);
        
        assertThat(registrar.whoIs(id), Matchers.sameInstance(candidate));
    }
    
    @Test public void
    candidateStartsWithBaselineResults() {
        UUID id = registrar.signUp(candidate);
        ExaminationResults results = registrar.resultsFor(id);
        
        assertThat(results.score(), is(0));
        assertThat(results.questionsAnswered(), is(0));
    }
    
    @Test public void
    anExaminersMarksAreReflectedInTheCandidatesResults() {
        Examiner examiner = new Examiner() {
            @Override public void examine(Candidate candidate, MarkingSheet marks) {
                marks.recordCorrectAnswerWorth(2);
            }
        };
        ExaminationRegistrar registrar = new ExaminationRegistrar(examiner);
        
        UUID id = registrar.signUp(candidate);
        
        ExaminationResults results = registrar.resultsFor(id);
        
        assertThat(results.score(), is(2));
        assertThat(results.questionsAnswered(), is(1));
    }
}
