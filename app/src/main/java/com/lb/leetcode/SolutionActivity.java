package com.lb.leetcode;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SolutionActivity extends Activity implements View.OnClickListener {

    EditText editText;
    EditText editText1;
    Button submit;
    TextView res;
    int quesNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leetcode_activity);
        quesNumber = getIntent().getIntExtra("quesNumber",-1);
        registerView();
    }

    private void registerView() {
        editText = findViewById(R.id.edit_text);
        editText1 = findViewById(R.id.edit_text1);
        submit = StaticFun.buttonRegister(R.id.submit,this,this);
        res = findViewById(R.id.res);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.submit){
            String e = editText.getText().toString();
            String e1 = editText1.getText().toString();
            String s = "";
            switch (quesNumber){
                case 1004:
                    Solution1004 solution1004 = new Solution1004();
                    s += solution1004.solution(e,e1,this);
//                    s += solution1004.longestOnes(a,k);
            }
            res.setText(s);
        }
    }

}
