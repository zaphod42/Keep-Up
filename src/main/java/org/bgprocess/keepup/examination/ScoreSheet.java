package org.bgprocess.keepup.examination;

public class ScoreSheet implements ExaminationResults, MarkingSheet {
    private int score;
    private int correctlyAnswered;
    
    @Override
    public void recordCorrectAnswerWorth(int score) {
        correctlyAnswered += 1;
        this.score += score;
    }

    @Override
    public int score() {
        return score;
    }

    @Override
    public int questionsAnswered() {
        return correctlyAnswered;
    }
}
