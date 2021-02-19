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
        }
        intent.putExtra("quesNumber",quesNumber);
        startActivity(intent);
    }
}