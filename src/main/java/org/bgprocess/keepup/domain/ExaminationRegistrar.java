package org.bgprocess.keepup.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ExaminationRegistrar {
    private final Set<Candidate> candidates = new HashSet<Candidate>();
    private final Examiner examiner;

    public ExaminationRegistrar(Examiner examiner) {
        this.examiner = examiner;
    }

    public int numberRegistered() {
        return candidates.size();
    }

    public void signUp(Candidate candidate) {
        candidates.add(candidate);
        examiner.examine(candidate);
    }

    public Collection<Candidate> candidates() {
        return candidates;
    }
}
