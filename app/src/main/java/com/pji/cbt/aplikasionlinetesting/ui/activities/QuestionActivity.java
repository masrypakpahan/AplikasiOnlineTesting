package com.pji.cbt.aplikasionlinetesting.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.pji.cbt.aplikasionlinetesting.data.beans.Testuser;
import com.pji.cbt.aplikasionlinetesting.network.API;
import com.pji.cbt.aplikasionlinetesting.network.RestUser;
import com.pji.cbt.aplikasionlinetesting.data.beans.Category;
import com.pji.cbt.aplikasionlinetesting.data.respons.QuestionRespon;
import com.pji.cbt.aplikasionlinetesting.ui.adapter.QuestionAdapter;
import com.pji.cbt.aplikasionlinetesting.util.DividerItemDecoration;
import com.pji.cbt.aplikasionlinetesting.util.RecyclerViewItemClickListener;

import cbt.pji.cbt.aplikasionlinetesting.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class QuestionActivity extends AppCompatActivity implements RecyclerViewItemClickListener {
    private RecyclerView rvTestUser;
    private SwipeRefreshLayout swipeRefreshLayout;

    private LinearLayoutManager linearLayoutManager;
    private QuestionAdapter questionAdapter;
    private QuestionRespon questionRespon;
    private Category category;


    private API api;


   public static void start(Context context, Testuser test) {
        Intent intent = new Intent(context,QuestionActivity.class);
        intent.putExtra(QuestionActivity.class.getSimpleName()  , (Parcelable) test);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        category = getIntent().getParcelableExtra(TesterUserActivity.class.getSimpleName());
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle (category.getQuestionCategory());
        actionBar.setDisplayHomeAsUpEnabled(true);

        rvTestUser = (RecyclerView) findViewById(R.id.rv_question);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh);

        linearLayoutManager = new LinearLayoutManager(this);
         questionAdapter = new QuestionAdapter(this);
        questionAdapter.setRecyclerViewItemClickListener(this);

        rvTestUser.setLayoutManager(linearLayoutManager);
        rvTestUser.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rvTestUser.setAdapter(questionAdapter);

        swipeRefreshLayout.setColorSchemeResources(R.color.amber_400);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                                                    @Override
                                                    public void onRefresh() {
                                                        refreshData();
                                                    }
                                                }
        );

        loadData(category.getIdCategory());
    }
    private void loadData(int idCategory) {
        if (swipeRefreshLayout != null)
            swipeRefreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    swipeRefreshLayout.setRefreshing(true);
                }
            });

        Callback<QuestionRespon> categoryCallback = new Callback<QuestionRespon>() {
            @Override
            public void onResponse(Call<QuestionRespon> call, Response<QuestionRespon> response) {
                questionRespon = response.body();
                if (response.code()== 200) {
                    if(questionRespon!= null) {
                        questionAdapter.addAll(questionRespon.getQuestions());
                    }
                    else{
                        Toast.makeText(QuestionActivity.this, "sorry the data is empty", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(QuestionActivity.this, "cannot accses Data", Toast.LENGTH_SHORT).show();
                }
                if (swipeRefreshLayout != null)

                    swipeRefreshLayout.setRefreshing(false);
            }
            @Override
            public void onFailure(Call<QuestionRespon> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "AKSES KE SERVER GAGAL" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        };

        api = RestUser.getRestUser();

        Call<QuestionRespon> Callquestion = api.getQuestion(idCategory);
        Callquestion.enqueue(categoryCallback);
    }
    private void refreshData() {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                questionAdapter.clear();
                loadData(category.getIdCategory());
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onItemClick(int position, View view) {

    }
}