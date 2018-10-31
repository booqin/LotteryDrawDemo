package me.boqin.lotterydrawdemo;

import java.util.ArrayList;
import java.util.List;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * TODO
 * Created by BoQin on 2018/7/13.
 * Modified by BoQin
 *
 * @Version
 */
public class TabAdapter extends RecyclerView.Adapter{

    private List<String> mDateSet;

    public TabAdapter(){
        mDateSet = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(
            @NonNull
                    ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = new TabViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tab, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(
            @NonNull
                    RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDateSet.size();
    }

    public void setDateSet(List<String> list){
        mDateSet.addAll(list);
    }

}
