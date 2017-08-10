package com.pji.cbt.aplikasionlinetesting.ui.activities;



/**
 * Created by Masry Pakpahan on 16/06/2017.
 */

public class questionn {
    private String Question[] =
            {
                    "1. tahun berapa berdiri google?",
                    "2. Aplikasi android diimplementasikan berdasarkan prinsip?",
                    "3. siapakan nama presiden indonesia?"
            };
    private  String Choices[][]={
            {"2002", "2005","2004","2006"},
            {"least privileges", "most priveleges","uniq privileges" ,"none of the above"},
            {"Joko Liber", "Joko widodo","joko sevacus","joko tingkir"}
    };
    private  String correctAnswer[]=
            {
            "2005","least privileges","Joko widodo"
    };
    public   int getLength(){
        return Question.length;
    }
    public String getChoice (int index, int Num)
    {
        String choice = Choices[index][Num-1];
        return choice;
    }
    public  String getQuestion(int a)
    {
        String question = Question[a];
        return question;
    }
    public String getCorrectAnswer(int a) {
        String answer = correctAnswer[a];
        return answer;
    }
}