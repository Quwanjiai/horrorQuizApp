package org.baltimorecityschools.horrorquizapp;

public class Questions {

    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String qText;
    private String correctAns;

    public Questions() {
        qText = " ";
        correctAns = " ";
        choiceA = " ";
        choiceB = " ";
        choiceC = " ";
        choiceD = " ";
    }

    public Questions(String sqText, String scorrectAns, String schoiceA, String schoiceB,String schoiceC,String schoiceD) {
        correctAns = scorrectAns;
        qText = sqText;
        choiceA = schoiceA;
        choiceB = schoiceB;
        choiceC = schoiceC;
        choiceD = schoiceD;
    }

    public  String getqText() {return qText;}

    public String getChoiceA() {
        return choiceA;
    }

    public void setChoiceA(String choiceA) {
        this.choiceA = choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public void setChoiceB(String choiceB) {
        this.choiceB = choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public void setChoiceC(String choiceC) {
        this.choiceC = choiceC;
    }

    public String getChoiceD() {
        return choiceD;
    }

    public void setChoiceD(String choiceD) {
        this.choiceD = choiceD;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public  void setqText(String newQtext) {qText = newQtext; }
    public void setCorrectAns(String newcorrectAns) {correctAns = newcorrectAns;}

    @Override
    public String toString() {
        return "Questions{" +
                "qText='" + qText + '\'' +
                ", correctAns=" + correctAns +
                '}';
    }
}
