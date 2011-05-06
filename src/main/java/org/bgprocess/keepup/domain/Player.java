package org.bgprocess.keepup.domain;

import java.net.URI;

import org.bgprocess.keepup.examination.Candidate;

public class Player implements Candidate {
    public String name;
    public URI url;
    public int score;
}
