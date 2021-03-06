package com.example.hongaer.splash01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {
    int[] imgRes = new int[]{
            R.mipmap.guide_1,
            R.mipmap.guide_2,
            R.mipmap.guide_3,
            R.mipmap.guide_4
    };
    private List<View> mViewList = new ArrayList<>();

    private ViewPager mVpGuide;
    private  Button mBtnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initData();
        mBtnStart= (Button) findViewById(R.id.btn_start);
        mVpGuide= (ViewPager) findViewById(R.id.viewpager);
        MyPagerAdapter adapter = new MyPagerAdapter();
        mVpGuide.setAdapter(adapter);
        mVpGuide.setOnPageChangeListener(new MyListner());
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent();
//                intent.setClass(GuideActivity.this,MainActivity.class);
//                startActivity(intent);
               startActivity(new Intent(GuideActivity.this,MainActivity.class));
                finish();



            }
        });

    }

    private void initData() {
        for(int i=0;i<imgRes.length;i++){
            View inflate= getLayoutInflater().inflate(R.layout.guide_item,null);
            ImageView ivGuide= (ImageView) inflate.findViewById(R.id.iv_guide);
            ivGuide.setBackgroundResource(imgRes[i]);
            mViewList.add(inflate);



        }

    }

    class MyPagerAdapter extends PagerAdapter {
        @Override

        public Object instantiateItem(ViewGroup container, int position) {

            View view = mViewList.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));
        }

        public int getCount() {
            return  mViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
    class MyListner implements ViewPager.OnPageChangeListener{
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (position == imgRes.length -1){
                mBtnStart.setVisibility(View.VISIBLE);
                Animation animation = AnimationUtils.loadAnimation(GuideActivity.this, R.anim.anim_guide_btn_start);
                mBtnStart.startAnimation(animation);

            }else{
                mBtnStart.setVisibility(View.GONE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
