package com.example.amnuaychaipoosri.bg_parallax_carousel_view.activity.main.viewholder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.amnuaychaipoosri.bg_parallax_carousel_view.R;
import com.example.amnuaychaipoosri.bg_parallax_carousel_view.activity.main.adapter.CarouselItemAdapter;
import com.example.amnuaychaipoosri.bg_parallax_carousel_view.model.ItemsListModel.Item;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.List;



public class CarouselBgParallaxViewHolder extends RecyclerView.ViewHolder{
    public ImageView bgIv;
    public RecyclerView horizontalRv;
    public TextView titleTv;
    public LinearLayout li;
    public CarouselItemAdapter gridAdapter;
    public LinearLayoutManager linearLayoutManager;
//    private List<Item> items;
    public View alphaView;
    public CarouselBgParallaxViewHolder(View itemView) {
        super(itemView);

        alphaView = (View) itemView.findViewById(R.id.viewholder_carousel_bg_parallax_alpha_view);
        horizontalRv = (RecyclerView) itemView.findViewById(R.id.viewholder_carousel_bg_parallax_rv);
        titleTv = (TextView) itemView.findViewById(R.id.viewholder_carousel_bg_parallax_title_tv);
        li = (LinearLayout) itemView.findViewById(R.id.viewholder_carousel_bg_parallax_li);
        bgIv =  (ImageView) itemView.findViewById(R.id.viewholder_carousel_bg_parallax_bg_iv);
        linearLayoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        horizontalRv.setLayoutManager(linearLayoutManager);
        horizontalRv.setHasFixedSize(true);
        horizontalRv.setNestedScrollingEnabled(false);
        SnapHelper snapHelperStart = new GravitySnapHelper(Gravity.START);
        snapHelperStart.attachToRecyclerView(horizontalRv);


    }
    public void setCarouselAdapter(Context context, List<Item> items, boolean isInvisibleStart) {
//        this.items = items;
        gridAdapter = new CarouselItemAdapter(context, isInvisibleStart);
        gridAdapter.setDao(items);
        horizontalRv.setAdapter(gridAdapter);
    }

    public void updateGridAdapter(List<Item> items) {
//        this.items = items;
        gridAdapter.setDao(items);
        gridAdapter.notifyDataSetChanged();
    }

}
