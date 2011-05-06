package org.bgprocess.keepup.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class ExaminationRegistrarTest {
    @Test public void
    hasNoCandidatesInTheBeginning() {
        ExaminationRegistrar registrar = new ExaminationRegistrar();
        assertThat(registrar.numberRegistered(), is(0));
    }
}
