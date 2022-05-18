package com.example.quizi;

import java.util.List;

public class quizzQuestions {
    private String question,option1,option2,option3,option4,ans;
    private String userSelectAns;

    public quizzQuestions(String question, String option1, String option2, String option3, String option4, String ans, String userSelectAns) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.ans = ans;
        this.userSelectAns = userSelectAns;
    }


    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getAns() {
        return ans;
    }

    public String getUserSelectAns() {
        return userSelectAns;
    }

    public void setUserSelectAns(String userSelectAns) {
        this.userSelectAns = userSelectAns;
    }
}
