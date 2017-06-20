package com.example.lzp.updaterecycle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

/**
 * Created by lzp on 2017/6/19.
 */

public class ExamMainTagItemAdapter extends RecyclerView.Adapter<ExamMainTagItemAdapter.MyViewHolder>{

    private Context context;
    private TagOnSeletedListener tagOnSeletedListener;
    private List<String> allTags;

    public ExamMainTagItemAdapter(Context context, List<String> allTags, TagOnSeletedListener tagOnSeletedListener){
        this.context = context;
        this.tagOnSeletedListener = tagOnSeletedListener;
        this.allTags = allTags;
    }

//    public ExamMainTagItemAdapter(Context context, List<String> allTags){
//        this.context = context;
//        this.allTags = allTags;
//    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycle, parent, false);
        ExamMainTagItemAdapter.MyViewHolder myViewHoldder = new ExamMainTagItemAdapter.MyViewHolder(view);
        return myViewHoldder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.btnTagItem.setText(allTags.get(position));
        holder.btnTagItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tagOnSeletedListener.onSeleted(position, holder);
//                holder.btnTagItem.setTextColor(context.getResources().getColor(R.color.colorPrimary));
//                holder.btnTagItem.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.btn_rectangle_selected));
            }
        });

        if(((MainActivity)context).getIsSelected()){
            holder.btnTagItem.setTextColor(context.getResources().getColor(R.color.colorPrimary));
        }else{
            holder.btnTagItem.setTextColor(context.getResources().getColor(R.color.colorAccent));
        }
    }

    @Override
    public int getItemCount() {
        return allTags.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        public Button btnTagItem;

        public MyViewHolder(View itemView) {
            super(itemView);
            btnTagItem = (Button) itemView.findViewById(R.id.button);
        }
    }

    //选择指定筛选的标签接口
    public static interface TagOnSeletedListener{
        public void onSeleted(int position, MyViewHolder holdder);
    }

    public void setTagOnSeletedListener(TagOnSeletedListener tagOnSeletedListener){
        this.tagOnSeletedListener = tagOnSeletedListener;
    }
}
