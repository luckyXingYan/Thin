package com.example.thin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.thin.bean.HomeDataBean;
import com.example.thin.view.BannerView;
import com.example.thin.view.BaseHomeLayout;
import com.example.thin.view.HomeFootView;
import com.example.thin.view.HotView;
import com.example.thin.view.TopTypeView;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class HomeAdapter extends RecyclerView.Adapter {
    private enum HomePageType {

        TYPE(0),
        BANNER(1),
        HOT(2),
        FOOT(3);

        private int value;

        HomePageType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    private BannerView bannerView;

    private HomeDataBean data = new HomeDataBean();

    private Context context;

    public HomeAdapter(Context context) {
        this.context = context;
    }

    public void setData(HomeDataBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setBannerStopAutoPlay(boolean autoPlay) {
        if (bannerView != null) {
            bannerView.setBannerStopAutoPlay(autoPlay);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        HomePageType type = HomePageType.values()[i];
        MyViewHolder myViewHolder = null;
        switch (type) {
            case TYPE:
                myViewHolder = new MyViewHolder(new TopTypeView(context));
                break;
            case BANNER:
                bannerView = new BannerView(context);
                myViewHolder = new MyViewHolder(bannerView);
                break;
            case HOT:
                myViewHolder = new MyViewHolder(new HotView(context));
                break;
            case FOOT:
                myViewHolder = new MyViewHolder(new HomeFootView(context));
                break;
        }
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (data == null) return;
        if (i == HomePageType.TYPE.getValue()) {
            ((MyViewHolder) viewHolder).setData(data.url);
        } else if (i == HomePageType.BANNER.getValue()) {
            ((MyViewHolder) viewHolder).setData(data.url);
        } else if (i == HomePageType.HOT.getValue()) {
            ((MyViewHolder) viewHolder).setData(data.url);
        } else if (i == HomePageType.FOOT.getValue()) {
            ((MyViewHolder) viewHolder).setData(data.url);
        }
    }

    @Override
    public int getItemCount() {
        return HomePageType.values().length;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    protected class MyViewHolder<T> extends RecyclerView.ViewHolder {
        private BaseHomeLayout itemView;

        public MyViewHolder(@NonNull BaseHomeLayout itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        public void setData(T data) {
            itemView.setData(data);
        }
    }
}
