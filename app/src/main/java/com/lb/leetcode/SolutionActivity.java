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
                    break;
//                    s += solution1004.longestOnes(a,k);
                case 697:
                    Solution697 solution697 = new Solution697();
                    s += solution697.solution(e,this);
                    break;
                case 1438:
                    Solution1438 solution1438 = new Solution1438();
                    s += solution1438.solution(e,e1,this);
                    break;
                case 766:
                    Solution766 solution766 = new Solution766();
                    int [][] matrix = {{1,2,3},{4,1,2},{5,4,1}};
                    s += solution766.isToeplitzMatrix(matrix);
                    break;
            }
            res.setText(s);
        }
    }

}
