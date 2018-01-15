package com.example.resouview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/1/15 0015.
 * Date 2018/1/15 0015
 */

public class MyResouView extends LinearLayout {
    private String resouwords[];
    private ResouViewItemClickListener mResouViewItemClickListener;
    private int loopFlag=0;
    public ResouViewItemClickListener getResouViewItemClickListener() {
        return mResouViewItemClickListener;
    }

    public void setResouViewItemClickListener(ResouViewItemClickListener resouViewItemClickListener) {
        mResouViewItemClickListener = resouViewItemClickListener;
    }

    public String[] getResouwords() {
        return resouwords;
    }

    public void setResouwords(String[] resouwords) {
        loopFlag=0;
        this.resouwords = resouwords;
        initloopFlag();
        this.removeAllViews();
        initView();
    }

    private void initloopFlag() {
        if(resouwords.length%4>0){
            loopFlag+=1;
        }
        loopFlag=loopFlag+(resouwords.length/4);
    }

    public MyResouView(Context context) {
        this(context,null);
    }

    public MyResouView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyResouView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setOrientation(VERTICAL);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.resou);
        if(typedArray!=null){
            CharSequence[] textArray = typedArray.getTextArray(R.styleable.resou_stringarr);
            Log.e("sadsad",textArray[0]+"");
            if(textArray.length>0){
                resouwords=new String[textArray.length];
                for(int x=0;x<textArray.length;x++){
                    resouwords[x]=textArray[x]+"";
                }
                initloopFlag();
                initView();
            }
        }
    }
    private void initView() {
        LinearLayout linearlayout;
        TextView textView;
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams paramsTextView=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        paramsTextView.setMargins(10,0,0,0);
        params.topMargin=2;
        params.bottomMargin=2;
        for(int x=0;x<loopFlag;x++){
            linearlayout=new LinearLayout(getContext());
            linearlayout.setOrientation(HORIZONTAL);
            linearlayout.setLayoutParams(params);
            if(x==loopFlag-1&&resouwords.length%4!=0){
                for (int y = 0; y < resouwords.length%4; y++) {
                    textView = new TextView(getContext());
                    textView.setLayoutParams(paramsTextView);
                    textView.setText(resouwords[x*4+y]);
                    textView.setPadding(10, 6, 10, 6);
                    textView.setBackground(getResources().getDrawable(R.drawable.resou_selector));
                    textView.setTextColor(getResources().getColorStateList(R.color.tvcolor_selector));
                    textView.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mResouViewItemClickListener != null) {
                                mResouViewItemClickListener.onItemClick((TextView) v);
                            }
                        }
                    });
                    linearlayout.addView(textView);
                }
            }else {
                for (int y = 0; y < 4; y++) {
                    textView = new TextView(getContext());
                    textView.setLayoutParams(paramsTextView);
                    textView.setText(resouwords[x*4+y]);
                    textView.setPadding(10, 6, 10, 6);
                    textView.setTextColor(getResources().getColorStateList(R.color.tvcolor_selector));
                    textView.setBackground(getResources().getDrawable(R.drawable.resou_selector));
                    textView.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mResouViewItemClickListener != null) {
                                mResouViewItemClickListener.onItemClick((TextView) v);
                            }
                        }
                    });
                    linearlayout.addView(textView);
                }
            }
            this.addView(linearlayout);
        }


    }

}
