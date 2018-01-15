package com.example.administrator.myresouview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.resouview.MyResouView;
import com.example.resouview.ResouViewItemClickListener;

public class MainActivity extends AppCompatActivity {
    EditText med;
    private MyResouView mMyResouView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        med= (EditText) findViewById(R.id.myedit);
        mMyResouView = (MyResouView) findViewById(R.id.myview);
        mMyResouView.setResouViewItemClickListener(new ResouViewItemClickListener() {
            @Override
            public void onItemClick(TextView view) {
                med.setText(view.getText());
            }
        });
        med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyResouView.setResouwords(new String[]{"街头健身","阿斯达四大","血之骑","的实时大","是多大的"});
            }
        });
    }
}
