package com.pji.cbt.aplikasionlinetesting.ui.activities;

        import android.content.Context;
        import android.content.Intent;
        import android.support.annotation.Nullable;
        import android.support.v4.widget.SwipeRefreshLayout;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.text.Html;
        import android.view.MenuItem;
        import android.view.View;

        import com.pji.cbt.aplikasionlinetesting.data.beans.Category;
        import com.pji.cbt.aplikasionlinetesting.data.beans.Testuser;
        import com.pji.cbt.aplikasionlinetesting.ui.adapter.CategoryAdapter;
        import com.pji.cbt.aplikasionlinetesting.util.RecyclerViewItemClickListener;


        import cbt.pji.cbt.aplikasionlinetesting.R;

    public class CategoryActivity extends AppCompatActivity implements RecyclerViewItemClickListener{

        private RecyclerView rc_Category;

        private LinearLayoutManager linearLayoutManager;
        private CategoryAdapter categoryAdapter;
        private Testuser testuser;
        private Category category;


        public static void start(Context context, Testuser tester) {
            Intent intent = new Intent(context, CategoryActivity.class);
           // intent.putExtra(CategoryActivity.class.getSimpleName() + ".category", tester);
            context.startActivity(intent);
        }

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_category);

            testuser = getIntent().getParcelableExtra(CategoryActivity.class.getSimpleName() + ".category");

            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle(Html.fromHtml(String.valueOf(testuser.getTestId())));
            actionBar.setDisplayHomeAsUpEnabled(true);

            rc_Category = (RecyclerView) findViewById(R.id.rv_category);

            linearLayoutManager = new LinearLayoutManager(this);
            categoryAdapter = new CategoryAdapter(this);

            rc_Category.setLayoutManager(linearLayoutManager);
            rc_Category.setAdapter(categoryAdapter);

          //  categoryAdapter.addAll(testuser.getCategories());
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
        public void onItemClick(int position,View view) {
            QuestionActivity.start(this,categoryAdapter.getItem(position));
        }
    }