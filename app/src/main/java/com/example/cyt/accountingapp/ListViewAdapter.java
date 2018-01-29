package com.example.cyt.accountingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by CYT on 2018/1/29.
 */

public class ListViewAdapter extends BaseAdapter {

    LinkedList<RecordBean> records = new LinkedList<>();

    private LayoutInflater layoutInflater;
    private Context mContext;

    public ListViewAdapter(Context mContext){
        this.mContext = mContext;
        layoutInflater = LayoutInflater.from(mContext);
    }

    public void setData(LinkedList<RecordBean> records){
        this.records = records;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return records.size();
    }

    @Override
    public Object getItem(int position) {
        return records.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.cell_list_view,parent,false);

            RecordBean recordBean = (RecordBean) getItem(position);
            viewHolder = new ViewHolder(convertView,recordBean);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }
}

class ViewHolder{

    TextView remarkTV;
    TextView timeTV;
    TextView amountTV;
    ImageView categoryIcon;

    public ViewHolder(View itemView,RecordBean record){
        remarkTV = itemView.findViewById(R.id.tv_remark);
        timeTV = itemView.findViewById(R.id.tv_time);
        amountTV = itemView.findViewById(R.id.tv_amount);
        categoryIcon = itemView.findViewById(R.id.imageview_category);



    }


}
