package com.example.thin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thin.R;
import com.example.thin.activity.SearchResultActivity;
import com.example.thin.base.adapter.BaseRecyclerAdapter;
import com.example.thin.base.adapter.BaseViewHolder;

/**
 * @Author: xingyan
 * @Date: 2019/10/24
 * @Desc:
 */
public class SearchRvAdapter extends BaseRecyclerAdapter<String, SearchRvAdapter.MyViewHolder> {
    private Context context;

    public SearchRvAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getItemLayout(int viewType) {
        return R.layout.item_search_gv;
    }

    @Override
    public int getViewType(int position) {
        return 0;
    }

    @Override
    public MyViewHolder getViewHolder(View view, int viewType) {
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.tvSearchContent.setText(getItemData(i));

        myViewHolder.tvSearchContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchResultActivity.open(context, getItemData(i));
            }
        });
    }

    protected class MyViewHolder extends BaseViewHolder {
        private TextView tvSearchContent;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSearchContent = itemView.findViewById(R.id.tv_search_content);
        }
    }
}
