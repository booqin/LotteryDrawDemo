package me.boqin.lotterydrawdemo;

import com.leochuan.ScaleLayoutManager;

import android.content.Context;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * TODO
 * Created by BoQin on 2018/6/24.
 * Modified by BoQin
 *
 * @Version
 */
public class MyLayoutManager extends ScaleLayoutManager{

    public MyLayoutManager(Context context, int itemSpace) {
        super(context, itemSpace);
    }

    public MyLayoutManager(Context context, int itemSpace, int orientation) {
        super(context, itemSpace, orientation);
    }

    public MyLayoutManager(Context context, int itemSpace, int orientation, boolean reverseLayout) {
        super(context, itemSpace, orientation, reverseLayout);
    }

    public MyLayoutManager(Builder builder) {
        super(builder);
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        int offsetPosition;
//        if (true) {
            int currentPosition = this.getCurrentPosition();
            int total = this.getItemCount();
            int targetPosition;
            int d1;
            int d2;
            if (position < currentPosition) {
                d1 = currentPosition - position;
                d2 = total - currentPosition + position;
                targetPosition = d1 < d2 ? currentPosition - d1 : currentPosition + d2;
            } else {
                d1 = position - currentPosition;
                d2 = currentPosition + total - position;
                targetPosition = d1 < d2 ? currentPosition + d1 : currentPosition - d2;
            }

            offsetPosition = this.getOffsetToPosition(targetPosition);
//        } else {
//            offsetPosition = this.getOffsetToPosition(position);
//        }

//        recyclerView.smoothScrollBy(offsetPosition, 0, new AccelerateDecelerateInterpolator());
        LinearSmoothScroller smoothScroller = new LinearSmoothScroller(recyclerView.getContext()){
            @Override
            protected int calculateTimeForScrolling(int dx) {
                return 1000;
            }
        };
        smoothScroller.setTargetPosition(position);
        startSmoothScroll(smoothScroller);
    }


}
