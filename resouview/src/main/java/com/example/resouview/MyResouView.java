package com.example.resouview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/1/15 0015.
 * Date 2018/1/15 0015
 */

public class MyResouView extends LinearLayout {
    private static String mResouwords[]={};
    private ResouViewItemClickListener mResouViewItemClickListener;
    private int mMWidth;
    private float lineWidth=0;
    private int mStrokeWidth=2,mTextSize=12;
    private boolean setBackgroundFlag=false;
    private int normalBackgroundColor=Color.WHITE,pressBackgroundColor=Color.GRAY,normalStrokeColor=Color.GRAY,pressStrokeColor=Color.WHITE,normalTextColor=Color.BLACK,pressTextColor=Color.WHITE;
    private StateListDrawable mBackgrounddrawable;
    private StateListDrawable mTextDrawable;

    public ResouViewItemClickListener getResouViewItemClickListener() {
        return mResouViewItemClickListener;
    }

    public int getNormalBackgroundColor() {
        return normalBackgroundColor;
    }

    public int getTextSize() {
        return mTextSize;
    }

    public void setTextSize(int textSize) {
        mTextSize = textSize;
    }

    public void setNormalBackgroundColor(int normalBackgroundColor) {
        this.normalBackgroundColor = normalBackgroundColor;
    }

    public int getPressBackgroundColor() {
        return pressBackgroundColor;
    }

    public void setPressBackgroundColor(int pressBackgroundColor) {
        this.pressBackgroundColor = pressBackgroundColor;
    }

    public int getNormalStrokeColor() {
        return normalStrokeColor;
    }

    public void setNormalStrokeColor(int normalStrokeColor) {
        this.normalStrokeColor = normalStrokeColor;
    }

    public int getPressStrokeColor() {
        return pressStrokeColor;
    }

    public void setPressStrokeColor(int pressStrokeColor) {
        this.pressStrokeColor = pressStrokeColor;
    }

    /**
     *
     * @param resouViewItemClickListener item点击事件
     */
    public void setResouViewItemClickListener(ResouViewItemClickListener resouViewItemClickListener) {
        mResouViewItemClickListener = resouViewItemClickListener;
    }

    public String[] getResouwords() {
        return mResouwords;
    }

    /**
     *
     * @param resouwords 需要传入的热搜词数组
     */
    public void setResouwords(String[] resouwords) {
        mResouwords = resouwords;
        new Handler().postDelayed(new Runnable(){
            public void run() {
                mMWidth = getWidth();
                removeAllViews();
                lineWidth=0;
                initView();
            }
        }, 100);
    }
    public MyResouView(Context context) {
        this(context,null);
    }

    public int getNormalTextColor() {
        return normalTextColor;
    }

    public void setNormalTextColor(int normalTextColor) {
        this.normalTextColor = normalTextColor;
    }

    public int getPressTextColor() {
        return pressTextColor;
    }

    public int getStrokeWidth() {
        return mStrokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        mStrokeWidth = strokeWidth;
    }

    public void setPressTextColor(int pressTextColor) {
        this.pressTextColor = pressTextColor;
    }

    public MyResouView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyResouView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setOrientation(VERTICAL);
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        mMWidth = getWidth();
        removeAllViews();
        initView();
    }
    private ColorStateList createColorStateList(int normal, int pressed) {
        int[] colors = new int[] { pressed, normal };
        int[][] states = new int[2][];
        states[0] = new int[] { android.R.attr.state_pressed};
        states[1] = new int[] { -android.R.attr.state_pressed};
        ColorStateList colorList = new ColorStateList(states, colors);
        return colorList;
    }
    private void initView() {
        LinearLayout linearlayout;
        TextView textView;
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams paramsTextView=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        paramsTextView.setMargins(10,0,0,0);
        params.topMargin=2;
        params.bottomMargin=2;
        linearlayout=new LinearLayout(getContext());
        linearlayout.setLayoutParams(params);
        linearlayout.setOrientation(HORIZONTAL);
        if(mResouwords.length>0){
            for(int x=0;x<mResouwords.length;x++){
                textView = new TextView(getContext());
                textView.setLayoutParams(paramsTextView);
                textView.setText(mResouwords[x]);
                textView.setPadding(12, 6, 12, 6);
                textView.setTextSize(mTextSize);
                mBackgrounddrawable = new StateListDrawable();
                GradientDrawable myGrad_unpress = (GradientDrawable) getResources().getDrawable(R.drawable.resouback_unpress);
                GradientDrawable myGrad_press = (GradientDrawable) getResources().getDrawable(R.drawable.resouback_pressed);
                myGrad_unpress.setColor(normalBackgroundColor);
                myGrad_press.setColor(pressBackgroundColor);
                myGrad_press.setStroke(mStrokeWidth,pressStrokeColor);
                myGrad_unpress.setStroke(mStrokeWidth,normalStrokeColor);
                myGrad_press.setDither(true);
                myGrad_unpress.setDither(true);
                myGrad_press.setUseLevel(true);
                myGrad_unpress.setUseLevel(true);
                mBackgrounddrawable.addState(new int[]{-android.R.attr.state_pressed},myGrad_unpress);
                mBackgrounddrawable.addState(new int[]{android.R.attr.state_pressed},myGrad_press);
                mTextDrawable = new StateListDrawable();
                GradientDrawable myGrad_textunpress = (GradientDrawable) getResources().getDrawable(R.drawable.resouback_unpress);
                GradientDrawable myGrad_textpress = (GradientDrawable) getResources().getDrawable(R.drawable.resouback_pressed);
                myGrad_textunpress.setColor(normalBackgroundColor);
                myGrad_textpress.setColor(pressBackgroundColor);
                myGrad_textpress.setDither(true);
                myGrad_textunpress.setDither(true);
                myGrad_textpress.setUseLevel(true);
                myGrad_textunpress.setUseLevel(true);
                mTextDrawable.addState(new int[]{-android.R.attr.state_pressed},myGrad_textunpress);
                mTextDrawable.addState(new int[]{android.R.attr.state_pressed},myGrad_textpress);
                textView.setBackground(mBackgrounddrawable);
                textView.setTextColor(createColorStateList(normalTextColor,pressTextColor));
                final int finalX = x;
                textView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mResouViewItemClickListener != null) {
                            mResouViewItemClickListener.onItemClick((TextView) v, finalX);
                        }
                    }
                });
                textView.measure(0,0);
                lineWidth+=textView.getMeasuredWidth()+10;
                if(lineWidth>mMWidth){
                    if(linearlayout!=null){
                        this.addView(linearlayout);
                    }
                    linearlayout=new LinearLayout(getContext());
                    linearlayout.setLayoutParams(params);
                    lineWidth=0;
                }
                linearlayout.addView(textView);
            }
            this.addView(linearlayout);
        }
    }

}
