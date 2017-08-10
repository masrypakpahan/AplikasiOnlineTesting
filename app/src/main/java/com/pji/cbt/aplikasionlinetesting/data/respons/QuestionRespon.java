package com.pji.cbt.aplikasionlinetesting.data.respons;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.pji.cbt.aplikasionlinetesting.data.beans.Question;

import java.util.List;

/**
 * Created by Masry Pakpahan on 04/08/2017.
 */

public class QuestionRespon{
    @SerializedName("Questions")
@Expose
private List<Question> questions = null;

        public List<Question> getQuestions() {
            return questions;
        }
        public void setQuestions(List<Question> questions) {
            this.questions = questions;
        }

}