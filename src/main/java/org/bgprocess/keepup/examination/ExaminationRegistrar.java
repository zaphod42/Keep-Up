package org.bgprocess.keepup.examination;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ExaminationRegistrar {
    private final Map<UUID, Candidate> candidates = new HashMap<UUID, Candidate>();
    private final Examiner examiner;

    public ExaminationRegistrar(Examiner examiner) {
        this.examiner = examiner;
    }

    public int numberRegistered() {
        return candidates.size();
    }

    public UUID signUp(Candidate candidate) {
        UUID id = UUID.randomUUID();
        candidates.put(id, candidate);
        examiner.examine(candidate);
        return id;
    }

    public Collection<Candidate> candidates() {
        return candidates.values();
    }

    public Candidate whoIs(UUID id) {
        return candidates.get(id);
    }
}
