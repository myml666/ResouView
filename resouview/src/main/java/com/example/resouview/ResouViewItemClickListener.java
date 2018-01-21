package com.example.resouview;

import android.widget.TextView;

/**
 * Created by Administrator on 2018/1/15 0015.
 * Date 2018/1/15 0015
 */

public interface ResouViewItemClickListener {
    /**
     *
     * @param view 返回点击的TextView
     * @param index 返回点击item的索引默认从0开始
     */
    void onItemClick(TextView view,int index);
}
