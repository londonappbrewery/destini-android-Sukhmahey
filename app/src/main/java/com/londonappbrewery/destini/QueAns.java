package com.londonappbrewery.destini;

public class QueAns {
    int mQuestion;
    int mUpText;
    int mDownText;

    QueAns(int question,int upText,int downText){
        mQuestion =question;
        mUpText=upText;
        mDownText =downText;
    }
    QueAns(int question){
        mQuestion = question;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }

    public int getUpText() {
        return mUpText;
    }

    public void setUpText(int upText) {
        mUpText = upText;
    }

    public int getDownText() {
        return mDownText;
    }

    public void setDownText(int downText) {
        mDownText = downText;
    }
}
