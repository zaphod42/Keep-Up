package org.bgprocess.keepup.domain;

public class ExaminationRegistrar {
    private int numberRegistered = 0;

    public int numberRegistered() {
        return numberRegistered;
    }

    public void signUp(Player player) {
        numberRegistered += 1;
    }
}
