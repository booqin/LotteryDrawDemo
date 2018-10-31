package me.boqin.lotterydrawdemo;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.animation.Interpolator;

/**
 * TODO
 * Created by BoQin on 2018/6/24.
 * Modified by BoQin
 *
 * @Version
 */
public class MyAccelerateDecelerateInterpolator implements Interpolator {

    @Override
    public float getInterpolation(float input) {
        return (float)(Math.cos((input + 1) * Math.PI) / 4.0f) + 0.25f;
    }
}
