package com.somiran.lall.everlaw;

public class Score {

    String winner;
    String looser;

    int winnerScore;
    int looserScore;

    int diff = winnerScore - looserScore;

    Score(String winner, int winnerScore, String looser, int looserScore) {
        this.winner = winner;
        this.winnerScore = winnerScore;
        this.looser = looser;
        this.looserScore = looserScore;
        this.diff = winnerScore - looserScore;
    }
}
