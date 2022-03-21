package com.zeyu.w6_p1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements fragment_top.fragmentTopListener, fragment_bottom.fragmentBottomListener{

    private fragment_top top;
    private fragment_bottom btm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        top = new fragment_top();
        btm = new fragment_bottom();
        getSupportFragmentManager().beginTransaction().replace(R.id.container_top, top).replace(R.id.container_btm, btm).commit();


    }

    @Override
    public void onMsgSent(CharSequence cs) {
        btm.updateTV(cs);
    }


}