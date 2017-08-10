package com.pji.cbt.aplikasionlinetesting.ui.activities;

import android.content.Intent;
import android.os.Handler;
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

import com.pji.cbt.aplikasionlinetesting.network.API;
import com.pji.cbt.aplikasionlinetesting.network.RestUser;

import com.pji.cbt.aplikasionlinetesting.data.respons.ResponTesterUser;
import com.pji.cbt.aplikasionlinetesting.ui.adapter.TesterAdapter;
import com.pji.cbt.aplikasionlinetesting.util.DividerItemDecoration;
import com.pji.cbt.aplikasionlinetesting.util.RecyclerViewItemClickListener;

import cbt.pji.cbt.aplikasionlinetesting.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TesterUserActivity extends AppCompatActivity implements RecyclerViewItemClickListener {
    private RecyclerView rvTestUser;
    private SwipeRefreshLayout swipeRefreshLayout;

    private int userId;
    private String name;
    private LinearLayoutManager linearLayoutManager;
    private TesterAdapter testerAdapter;
    private ResponTesterUser responTesterUser;


    private API api;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testuser);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle (name);
        actionBar.setDisplayHomeAsUpEnabled(true);

        rvTestUser = (RecyclerView) findViewById(R.id.rv_testuser);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh);

        linearLayoutManager = new LinearLayoutManager(this);
        testerAdapter = new TesterAdapter(this);
        testerAdapter.setRecyclerViewItemClickListener(this);

        rvTestUser.setLayoutManager(linearLayoutManager);
        rvTestUser.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rvTestUser.setAdapter(testerAdapter);

        swipeRefreshLayout.setColorSchemeResources(R.color.amber_400);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                                                    @Override
                                                    public void onRefresh() {
                                                        refreshData();
                                                    }
                                                }
        );

        Intent mIntent = getIntent();
        userId = mIntent.getIntExtra("userId", 0);
        name = mIntent.getStringExtra("username");
        loadData(userId);
    }
    private void loadData(final int userId) {
        if (swipeRefreshLayout != null)
            swipeRefreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    swipeRefreshLayout.setRefreshing(true);
                }
            });

        Callback<ResponTesterUser> categoryCallback = new Callback<ResponTesterUser>() {
            @Override
            public void onResponse(Call<ResponTesterUser> call, Response<ResponTesterUser> response) {
                responTesterUser = response.body();
                if (response.code()== 200) {
                    if(responTesterUser != null) {
                        testerAdapter.addAll(responTesterUser.getTestuser());
                    }
                    else{
                        Toast.makeText(TesterUserActivity.this, "sorry the data is empty", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(TesterUserActivity.this, "cannot accses Data", Toast.LENGTH_SHORT).show();
                }
                if (swipeRefreshLayout != null)

                    swipeRefreshLayout.setRefreshing(false);
            }
            @Override
            public void onFailure(Call<ResponTesterUser> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "AKSES KE SERVER GAGAL" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        };

        api = RestUser.getRestUser();
        Call<ResponTesterUser> CallTest = api.getCategoryy(userId);
        CallTest.enqueue(categoryCallback);
    }
    private void refreshData() {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                testerAdapter.clear();
                loadData(userId);
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
        QuestionActivity.start(this, testerAdapter.getItem(position));
    }
}