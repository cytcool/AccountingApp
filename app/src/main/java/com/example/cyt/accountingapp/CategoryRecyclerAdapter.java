package com.example.cyt.accountingapp;

/**
 * Created by CYT on 2018/2/1.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.LinkedList;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    private LayoutInflater mInfiater;
    private Context mContext;

    private LinkedList<CategoryResBean> cellList = GlobalUtil.getInstance().costRes;

    public String getSelected() {
        return selected;
    }

    private String selected = "";


    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

class CategoryViewHolder extends RecyclerView.ViewHolder{

    RelativeLayout background;
    ImageView imageView;
    TextView textView;

    public CategoryViewHolder(View itemView) {
        super(itemView);
        background = (RelativeLayout) itemView.findViewById(R.id.cell_background);
        imageView = (ImageView) itemView.findViewById(R.id.imageView_category);
        textView = (TextView) itemView.findViewById(R.id.textView_category);
    }
}