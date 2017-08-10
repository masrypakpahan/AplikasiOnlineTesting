package com.pji.cbt.aplikasionlinetesting.data.beans;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Masry Pakpahan on 04/08/2017.
 */

public class Question implements Parcelable
{

    @SerializedName("idQuestion")
    @Expose
    private Integer idQuestion;
    @SerializedName("orderingQuestion")
    @Expose
    private Integer orderingQuestion;
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("category")
    @Expose
    private Category category;
    public final static Parcelable.Creator<Question> CREATOR = new Creator<Question>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Question createFromParcel(Parcel in) {
            Question instance = new Question();
            instance.idQuestion = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.orderingQuestion = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.question = ((String) in.readValue((String.class.getClassLoader())));

            instance.category = ((Category) in.readValue((Category.class.getClassLoader())));
            return instance;
        }

        public Question[] newArray(int size) {
            return (new Question[size]);
        }

    }
            ;

    public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Integer getOrderingQuestion() {
        return orderingQuestion;
    }

    public void setOrderingQuestion(Integer orderingQuestion) {
        this.orderingQuestion = orderingQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(idQuestion);
        dest.writeValue(orderingQuestion);
        dest.writeValue(question);
        dest.writeValue(category);
    }

    public int describeContents() {
        return 0;
    }

}