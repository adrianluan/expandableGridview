package com.example.fuxinl.example1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;

import java.util.List;

/**
 * Created by fuxinl on 5/25/17.
 */

public class BookAdapter extends ExpandableRecyclerAdapter<Book, Detail, BookViewHolder, DetailViewHolder> {

    private LayoutInflater mInflater;
    private List<Book> mBooklist;


    public BookAdapter(Context context, @NonNull List<Book> bookList) {
        super(bookList);
        Log.e("dadasasasd", bookList.toString());


        mBooklist = bookList;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public BookViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        View bookView = mInflater.inflate(R.layout.book_view, parentViewGroup, false);
        return new BookViewHolder(bookView);
    }

    @NonNull
    @Override
    public DetailViewHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
        View detailView = mInflater.inflate(R.layout.detail_view, childViewGroup, false);
        return new DetailViewHolder(detailView);
    }

    @Override
    public void onBindParentViewHolder(@NonNull BookViewHolder bookViewHolder, int parentPosition, @NonNull Book book) {
        bookViewHolder.bind(book);
    }

    @Override
    public void onBindChildViewHolder(@NonNull DetailViewHolder detailViewHolder, int parentPosition, int childPosition, @NonNull Detail detail) {
        detailViewHolder.bind(detail);
    }




}
