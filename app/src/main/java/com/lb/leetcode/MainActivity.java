package com.lb.leetcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerButton();
    }

    private void registerButton() {
        List<Integer> buttons = new ArrayList<>();
        buttons.add(R.id.leetcode1004);
        buttons.add(R.id.leetcode697);
        buttons.add(R.id.leetcode1438);
        buttons.add(R.id.leetcode766);
        buttons.add(R.id.leetcode1052);
        StaticFun.buttonRegister(buttons,this,this);
    }

    @Override
    public void onClick(View v) {
        int quesNumber = 0;
        Intent intent = new Intent(this, SolutionActivity.class);
        switch (v.getId()){
            case R.id.leetcode1004:
                quesNumber = 1004;
                break;
            case R.id.leetcode697:
                quesNumber = 697;
                break;
            case R.id.leetcode1438:
                quesNumber = 1438;
                break;
            case R.id.leetcode766:
                quesNumber = 766;
                break;
            case R.id.leetcode1052:
                quesNumber = 1052;
                break;
        }
        intent.putExtra("quesNumber",quesNumber);
        startActivity(intent);
    }
}