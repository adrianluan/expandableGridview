package com.example.fuxinl.example1;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ChildViewHolder;

/**
 * Created by fuxinl on 5/25/17.
 */

public class DetailViewHolder extends ChildViewHolder {


    private TextView authorTv;
    private TextView DescTv;

    /**
     * Default constructor.
     *
     * @param itemView The {@link View} being hosted in this ViewHolder
     */
    public DetailViewHolder(@NonNull View itemView) {
        super(itemView);
        authorTv = (TextView) itemView.findViewById(R.id.author_name);
        DescTv = (TextView) itemView.findViewById(R.id.desc);
    }


    public void bind(@NonNull Detail detail) {
        authorTv.setText(detail.getAuthor());
        DescTv.setText(detail.getDesc());
    }



}
