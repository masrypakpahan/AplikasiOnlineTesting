package com.pji.cbt.aplikasionlinetesting.data.beans;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Masry Pakpahan on 01/08/2017.
 */

public class Category implements Parcelable
{

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
    public final static Parcelable.Creator<Category> CREATOR = new Creator<Category>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Category createFromParcel(Parcel in) {
            Category instance = new Category();
            instance.idCategory = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.questionCategory = ((String) in.readValue((String.class.getClassLoader())));
            instance.description = ((String) in.readValue((String.class.getClassLoader())));
            instance.questionType = ((String) in.readValue((String.class.getClassLoader())));
            instance.timeLimit = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Category[] newArray(int size) {
            return (new Category[size]);
        }

    }
            ;

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getQuestionCategory() {
        return questionCategory;
    }

    public void setQuestionCategory(String questionCategory) {
        this.questionCategory = questionCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(idCategory);
        dest.writeValue(questionCategory);
        dest.writeValue(description);
        dest.writeValue(questionType);
        dest.writeValue(timeLimit);
    }

    public int describeContents() {
        return 0;
    }

}