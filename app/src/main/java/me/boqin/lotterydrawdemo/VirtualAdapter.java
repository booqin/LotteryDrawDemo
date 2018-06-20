package me.boqin.lotterydrawdemo;

import java.util.ArrayList;
import java.util.List;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * TODO
 * Created by BoQin on 2018/6/18.
 * Modified by BoQin
 *
 * @Version
 */
public class VirtualAdapter extends RecyclerView.Adapter{

    private List<String> mDateSet;

    public VirtualAdapter(List<String> list){
        mDateSet = new ArrayList<>();
        mDateSet.addAll(list);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(
            @NonNull
                    ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_virtual, parent, false);
        return new VirtualHolder(view);
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

    private class VirtualHolder extends RecyclerView.ViewHolder{

        public VirtualHolder(View itemView) {
            super(itemView);
        }
    }
}
