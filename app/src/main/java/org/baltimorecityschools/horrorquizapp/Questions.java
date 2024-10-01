package org.baltimorecityschools.horrorquizapp;

public class Questions {

    private String qText;
    private boolean correctAns;

    public Questions() {
        qText = " ";
        correctAns = false;
    }

    public Questions(String sqText, boolean scorrectAns) {
        correctAns = scorrectAns;
        qText = sqText;
    }

    public  String getqText() {return qText;}
    public boolean getcorrectAns() {return correctAns;}

    public  void setqText(String newQtext) {qText = newQtext; }
    public void setCorrectAns(Boolean newcorrectAns) {correctAns = newcorrectAns;}

    @Override
    public String toString() {
        return "Questions{" +
                "qText='" + qText + '\'' +
                ", correctAns=" + correctAns +
                '}';
    }
}
