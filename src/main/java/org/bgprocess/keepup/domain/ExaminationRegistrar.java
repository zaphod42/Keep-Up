package org.bgprocess.keepup.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ExaminationRegistrar {
    private final Set<Candidate> candidates = new HashSet<Candidate>();

    public int numberRegistered() {
        return candidates.size();
    }

    public void signUp(Candidate candidate) {
        candidates.add(candidate);
    }

    public Collection<Candidate> candidates() {
        return candidates;
    }
}
