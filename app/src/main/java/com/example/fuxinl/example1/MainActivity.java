package com.example.fuxinl.example1;

import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {


    private BookAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Book> bookList = new ArrayList<>();
        for(char i = 'a'; i < 'h'; i++){
                List<Detail> list2 = new ArrayList<>();
                list2.add(new Detail(i+"","Desc: This is a great book"));
                bookList.add(new Book(i+"", list2));
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mAdapter = new BookAdapter(this, bookList);
        mAdapter.setExpandCollapseListener(new ExpandableRecyclerAdapter.ExpandCollapseListener() {
            private int lastExpandedPosition = -1;
            @UiThread
            @Override
            public void onParentExpanded(int parentPosition) {
                Toast.makeText(MainActivity.this,
                        lastExpandedPosition+" "+parentPosition,
                        Toast.LENGTH_SHORT)
                        .show();
                if (lastExpandedPosition != -1
                        && parentPosition != lastExpandedPosition) {
                    mAdapter.collapseParent(lastExpandedPosition);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lastExpandedPosition = parentPosition;


            }


            @UiThread
            @Override
            public void onParentCollapsed(int parentPosition) {

            }
        });



        recyclerView.setAdapter(mAdapter);
        GridLayoutManager glm = new GridLayoutManager(this,3);
        glm.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int t = mAdapter.getItemViewType(position);
                switch(t) {
                    case ExpandableRecyclerAdapter.TYPE_CHILD:
                        return 3;
                    default:
                        return 1;
                }
            }
        });
        recyclerView.setLayoutManager(glm);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mAdapter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mAdapter.onRestoreInstanceState(savedInstanceState);
    }
}
