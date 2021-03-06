package me.boqin.lotterydrawdemo;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.leochuan.ScaleLayoutManager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    LinearLayoutManager mLinearLayoutManager;
    VirtualAdapter mAdapter;

    RecyclerView mTabRV;

    Button mButton;
    private ScaleLayoutManager mScaleLayoutManager;

    private String[] dataSet = {"a", "b", "c", "b", "c", "b", "b", "c", "b", "b", "c", "b", "c", "b", "c"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rv);
        mButton = findViewById(R.id.bt);

        mLinearLayoutManager = new LinearLayoutManager(this, HORIZONTAL, true);
        List<String> virtualInfos = new ArrayList<>();
        for(int i=0 ; i<11; i++){
            virtualInfos.add("11");
        }
        mScaleLayoutManager = new ScaleLayoutManager.Builder(this, 10)
                .setOrientation(HORIZONTAL)
                .build();
        mScaleLayoutManager.setInfinite(true);
        //        ViewPagerLayoutManager viewPagerLayoutManager = new

        mAdapter = new VirtualAdapter(virtualInfos);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mScaleLayoutManager);

        mScaleLayoutManager.setSmoothScrollInterpolator(new DecelerateInterpolator(1.5f));
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScaleLayoutManager.smoothScrollToPosition(mRecyclerView,  null, 37);
            }
        });

        mTabRV = findViewById(R.id.tab_rv);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        TabAdapter tabAdapter = new TabAdapter();
        tabAdapter.setDateSet(Arrays.asList(dataSet));
        mTabRV.setLayoutManager(gridLayoutManager);
        mTabRV.setAdapter(tabAdapter);

    }
}
