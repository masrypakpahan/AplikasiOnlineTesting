package com.pji.cbt.aplikasionlinetesting.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.pji.cbt.aplikasionlinetesting.data.beans.Category;
import com.pji.cbt.aplikasionlinetesting.data.beans.Question;
import com.pji.cbt.aplikasionlinetesting.data.beans.Testuser;
import com.pji.cbt.aplikasionlinetesting.util.RecyclerViewItemClickListener;

import java.util.ArrayList;
import java.util.List;

import cbt.pji.cbt.aplikasionlinetesting.R;

/**
 * Created by Masry Pakpahan on 07/08/2017.
 */

public class QuestionAdapter  extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

public List<Question>question;
private Context context;
private RecyclerViewItemClickListener recyclerViewItemClickListener;

public QuestionAdapter(Context context) {
        this.context = context;
    question = new ArrayList<>();
        }
public void add(Question item) {
    question.add(item);
        notifyItemInserted(question.size() -1);
        }
public  void addAll(List<Question> testDataList){
        for(Question quest : testDataList){
        add(quest);
        }
        }


public void remove(Question item) {
        int position = question.indexOf(item);
        if (position > -1) {question.remove(position);
        notifyItemRemoved(position);
        }
        }
public void clear() {
        while (getItemCount()> 0) {
        remove(getItem(0));
        }
        }

public Question getItem(int positon)

        {
        return question.get(positon);
        }

@Override
public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
        View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.activity_questions, parent, false);
final QuestionViewHolder testViewHolder = new QuestionViewHolder(view);
        testViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        int adapterPos = testViewHolder.getAdapterPosition();
        if (adapterPos != RecyclerView.NO_POSITION) {
        if (recyclerViewItemClickListener != null) {
        recyclerViewItemClickListener.onItemClick(adapterPos, testViewHolder.itemView);
        }
        }
        }
        });
        return testViewHolder;
        }
@Override
public void onBindViewHolder(QuestionAdapter.QuestionViewHolder holder, int position) {
    final Question question1 = question.get(position);
    holder.Question.setText(Html.fromHtml(String.valueOf(Integer.valueOf(question1.getQuestion()))));
   // holder.user.setText(context.getResources().getString(R.string.user, testuserData.getUsers()));

}

@Override
public int getItemCount()
        {
        return question.size();
        }

public void setRecyclerViewItemClickListener(RecyclerViewItemClickListener recyclerViewItemClickListener) {
        this.recyclerViewItemClickListener = recyclerViewItemClickListener;
        }


static class QuestionViewHolder  extends RecyclerView.ViewHolder {
        TextView Question;
        RadioButton ch1;
        RadioButton ch2;
        RadioButton ch3;
        RadioButton ch4;
        RadioButton ch5;

        public QuestionViewHolder(View itemView) {
            super(itemView);
            Question= (TextView) itemView.findViewById(R.id.tvQuestion);
            ch1=(RadioButton) itemView.findViewById(R.id.rbOptionA);
            ch2=(RadioButton) itemView.findViewById(R.id.rbOptionB);
            ch3=(RadioButton) itemView.findViewById(R.id.rbOptionC);
            ch4=(RadioButton) itemView.findViewById(R.id.rbOptionD);
            ch5=(RadioButton) itemView.findViewById(R.id.rbOptionE);

        }
    }
}