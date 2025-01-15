package org.baltimorecityschools.horrorquizapp;

public class HighScoreEN implements Comparable{

    private String nameRK;
    private int score;
    //private String date;

    public HighScoreEN() {
        nameRK = " ";
        score = 0;
        //date = " ";
    }

    public HighScoreEN(String snameRK, int sscore, String sdate) {
        nameRK = snameRK;
        score = sscore;
        //date = sdate;
    }

    public HighScoreEN(String snameRK, int sscore) {
        nameRK = snameRK;
        score = sscore;
    }

    public String getNameRK() {
        return nameRK;
    }

    public void setNameRK(String nameRK) {
        this.nameRK = nameRK;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    //public String getDate() {
        //return date;
    //}

   // public void setDate(String date) {
        //this.date = date;
    //}

    @Override
    public String toString() {
        return "HighScoreEN{" +
                "nameRK='" + nameRK + '\'' +
                ", score=" + score +
                //", date='" + date + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        HighScoreEN other = (HighScoreEN)o;
        return other.score-this.score;
    }
}
