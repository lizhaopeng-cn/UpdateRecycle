package com.example.lzp.updaterecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTagItem;
    private boolean isSelected;
    private List<String> allTags;
    private ExamMainTagItemAdapter examMainTagItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvTagItem = (RecyclerView) findViewById(R.id.recycleView);
        allTags = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            allTags.add(""+i);
        }

        rvTagItem.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        examMainTagItemAdapter = new ExamMainTagItemAdapter(this, allTags, new ExamMainTagItemAdapter.TagOnSeletedListener() {
            @Override
            public void onSeleted(int position, ExamMainTagItemAdapter.MyViewHolder holdder) {
                isSelected = true;
                for(int i = 0; i < examMainTagItemAdapter.getItemCount(); i++){
                    examMainTagItemAdapter.onBindViewHolder(holdder,i);
                }
                examMainTagItemAdapter.notifyDataSetChanged();
            }
        });
        rvTagItem.setAdapter(examMainTagItemAdapter);
    }

    public boolean getIsSelected(){
        return isSelected;
    }

    public void setIsSelected(boolean isSelected){
        this.isSelected = isSelected;
    }
}
