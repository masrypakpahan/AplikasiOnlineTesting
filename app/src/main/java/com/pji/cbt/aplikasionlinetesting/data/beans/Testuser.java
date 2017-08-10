package com.pji.cbt.aplikasionlinetesting.data.beans;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Masry Pakpahan on 01/08/2017.
 */

public class Testuser
{

    @SerializedName("testId")
    @Expose
    private Integer testId;
    @SerializedName("started")
    @Expose
    private Object started;
    @SerializedName("ended")
    @Expose
    private Object ended;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("users")
    @Expose
    private Object users;
    @SerializedName("categories")
    @Expose
    private Categories categories;

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Object getStarted() {
        return started;
    }

    public void setStarted(Object started) {
        this.started = started;
    }

    public Object getEnded() {
        return ended;
    }

    public void setEnded(Object ended) {
        this.ended = ended;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getUsers() {
        return users;
    }

    public void setUsers(Object users) {
        this.users = users;
    }

    public Categories getCategories(){
        return categories;
    }

    public void setCategories(Categories categories){
        this.categories = categories;
    }

    public class Categories{
        @SerializedName("idCategory")
        @Expose
        private Integer idCategory;
        @SerializedName("questionCategory")
        @Expose
        private String questionCategory;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("questionType")
        @Expose
        private String questionType;
        @SerializedName("timeLimit")
        @Expose
        private Integer timeLimit;

        public Integer getIdCategory() {
            return idCategory;
        }

        public void setIdCategory(Integer idCategory) {
            this.idCategory = idCategory;
        }

        public Categories withIdCategory(Integer idCategory) {
            this.idCategory = idCategory;
            return this;
        }

        public String getQuestionCategory() {
            return questionCategory;
        }

        public void setQuestionCategory(String questionCategory) {
            this.questionCategory = questionCategory;
        }

        public Categories withQuestionCategory(String questionCategory) {
            this.questionCategory = questionCategory;
            return this;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Categories withDescription(String description) {
            this.description = description;
            return this;
        }

        public String getQuestionType() {
            return questionType;
        }

        public void setQuestionType(String questionType) {
            this.questionType = questionType;
        }

        public Categories withQuestionType(String questionType) {
            this.questionType = questionType;
            return this;
        }

        public Integer getTimeLimit() {
            return timeLimit;
        }

        public void setTimeLimit(Integer timeLimit) {
            this.timeLimit = timeLimit;
        }

        public Categories withTimeLimit(Integer timeLimit) {
            this.timeLimit = timeLimit;
            return this;
        }

    }

}