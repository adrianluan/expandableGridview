package com.example.fuxinl.example1;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ParentViewHolder;

/**
 * Created by fuxinl on 5/25/17.
 */

public class BookViewHolder extends ParentViewHolder{

    TextView tv;
    /**
     * Default constructor.
     *
     * @param itemView The {@link View} being hosted in this ViewHolder
     */
    public BookViewHolder(@NonNull View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(R.id.tv);
    }

    public void bind(@NonNull Book book) {
        tv.setText(book.getName());
    }



}
