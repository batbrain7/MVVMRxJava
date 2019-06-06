package com.example.mohitkumar.footballapp2;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.mohitkumar.footballapp2.Utils.Utils;
import com.example.mohitkumar.footballapp2.core.main.CardPagerAdapter;
import com.example.mohitkumar.footballapp2.core.main.ShadowTransformer;
import com.example.mohitkumar.footballapp2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private CardPagerAdapter cardPagerAdapter;
    private ShadowTransformer shadowTransformer;
    public static final String TAG = "FOOTBALL MAIN ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Utils.fillMap(this);
        setup();
    }

    private void setup() {
        Log.d(TAG, "IN HERE");
        mainBinding.viewPager.setPageMargin(-80);
        cardPagerAdapter = new CardPagerAdapter(this);
        Utils.insertCardAdapter(this, cardPagerAdapter);
        shadowTransformer = new ShadowTransformer(mainBinding.viewPager, cardPagerAdapter);
        mainBinding.viewPager.setAdapter(cardPagerAdapter);
        mainBinding.viewPager.setPageTransformer(false, shadowTransformer);
        mainBinding.viewPager.setOffscreenPageLimit(3);
    }
}
