package com.pji.cbt.aplikasionlinetesting.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pji.cbt.aplikasionlinetesting.data.beans.Category;
import com.pji.cbt.aplikasionlinetesting.data.beans.Testuser;
import com.pji.cbt.aplikasionlinetesting.util.RecyclerViewItemClickListener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;

import cbt.pji.cbt.aplikasionlinetesting.R;

/**
 * Created by Masry Pakpahan on 25/07/2017.
 */

public class CategoryAdapter  extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{

private List<Category> categoryList;
private Context context;

public CategoryAdapter(Context context) {
        this.context = context;
    categoryList= new ArrayList<>();
        }

private void add(Category item) {
    categoryList.add(item);
        notifyItemInserted(categoryList.size() - 1);
        }

public void addAll(List<Category> category) {
        for (Category category1: category) {
        add(category1);
        }
        }

public void remove(Category item) {
        int position = categoryList.indexOf(item);
        if (position > -1) {
            categoryList.remove(position);
        notifyItemRemoved(position);
        }
        }

public void clear() {
        while (getItemCount() > 0) {
        remove(getItem(0));
        }
        }

public Category getItem(int positon){
        return categoryList.get(positon);
        }

@Override
public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listcategory, parent, false);
        return new CategoryViewHolder(view);
        }

@Override
public void onBindViewHolder(CategoryViewHolder holder, int position) {
final Category category = categoryList.get(position);
    holder.questioncategory.setText( category.getQuestionCategory());
    holder.questiontype.setText(category.getQuestionType());
    holder.time.setText(String.valueOf(Integer.valueOf(category.getTimeLimit())));
    holder.time.setText(context.getResources().getString(R.string.timelimit, category.getTimeLimit()));
    holder.description.setText(category.getDescription());
}
@Override
public int getItemCount() {
        return categoryList.size();
}

static class CategoryViewHolder extends RecyclerView.ViewHolder {

    TextView questioncategory;
    TextView questiontype;
    TextView description;
    TextView time;

    public CategoryViewHolder(View itemView) {
        super(itemView);

        questioncategory= (TextView) itemView.findViewById(R.id.questionCategory);
        questiontype = (TextView) itemView.findViewById(R.id.questionType);
       description = (TextView) itemView.findViewById(R.id.description);
       time = (TextView) itemView.findViewById(R.id.timeLimit);

    }
}
}