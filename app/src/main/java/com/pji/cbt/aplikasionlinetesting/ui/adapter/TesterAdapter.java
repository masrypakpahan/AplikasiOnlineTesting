package com.pji.cbt.aplikasionlinetesting.ui.adapter;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pji.cbt.aplikasionlinetesting.data.beans.Testuser;
import com.pji.cbt.aplikasionlinetesting.util.RecyclerViewItemClickListener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cbt.pji.cbt.aplikasionlinetesting.R;

/**
 * Created by Masry Pakpahan on 25/07/2017.
 */

public class TesterAdapter extends RecyclerView.Adapter<TesterAdapter.TestViewHolder> {

    public List<Testuser>testDataList;
    private Context context;
    private RecyclerViewItemClickListener recyclerViewItemClickListener;

    public TesterAdapter(Context context) {
        this.context = context;
        testDataList = new ArrayList<>();
    }

    public void add(Testuser item) {
        testDataList.add(item);
        notifyItemInserted(testDataList.size() -1);
    }

    public  void addAll(List<Testuser> testDataList){
        for(Testuser categoryData : testDataList){
            add(categoryData);

        }
    }

    public void remove(Testuser item) {
        int position = testDataList.indexOf(item);
        if (position > -1) {testDataList.remove(position);
            notifyItemRemoved(position);
        }
    }
    public void clear() {
        while (getItemCount()> 0) {
            remove(getItem(0));
        }
    }

    public Testuser getItem(int positon)

    {
        return testDataList.get(positon);
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listtestuser, parent, false);
        final TestViewHolder testViewHolder = new TestViewHolder (view);
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
    public void onBindViewHolder(TestViewHolder holder, int position) {
        final Testuser testuserData = testDataList.get(position);
        holder.questionCategory.setText(Html.fromHtml(testuserData.getCategories().getQuestionCategory()));
        holder.questionType.setText(testuserData.getCategories().getDescription());
        holder.description.setText(testuserData.getCategories().getQuestionType());

    }
    @Override
    public int getItemCount()
    {
        return testDataList.size();
    }

    public void setRecyclerViewItemClickListener(RecyclerViewItemClickListener recyclerViewItemClickListener) {
        this.recyclerViewItemClickListener = recyclerViewItemClickListener;
    }

    static class TestViewHolder  extends RecyclerView.ViewHolder {
        TextView questionCategory;
        TextView questionType;
        TextView description;


        public TestViewHolder(View itemView) {
            super(itemView);
            questionCategory= (TextView) itemView.findViewById(R.id.questionCategory);
            questionType = (TextView) itemView.findViewById(R.id.questionType);
            description = (TextView) itemView.findViewById(R.id.description);
            // status = (TextView) itemView.findViewById(R.id.status);
        }

    }
}