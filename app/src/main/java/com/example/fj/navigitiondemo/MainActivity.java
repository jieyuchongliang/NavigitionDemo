package com.example.fj.navigitiondemo;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.example.fj.navigitiondemo.fragment.CommunicateFragment;
import com.example.fj.navigitiondemo.fragment.DiscoverFragment;
import com.example.fj.navigitiondemo.fragment.HomeFragment;
import com.example.fj.navigitiondemo.fragment.MeFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private BottomNavigationBar mBottomNavigationBar;
    private HomeFragment homeFragment;
    private CommunicateFragment communicateFragment;
    private MeFragment meFragment;
    private DiscoverFragment discoverFragment;
    private String number;
    private TextBadgeItem badgeItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        initDot();//初始化消息红点儿的方法。
        mBottomNavigationBar
                .setMode(BottomNavigationBar.MODE_FIXED)//Mode和BackgroundStyle分别有三种，分别包含一种Default模式(FIXED+STATIC,FIXED+RIPPLE,SHIFTING+RIPPLE,SHIFTING+STATIC).
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                //setActiveColor在BACKGROUND_STYLE_STATIC下，表示选中Item的图标和文本颜色。而在BACKGROUND_STYLE_RIPPLE下，表示整个容器的背景色。默认Theme's Primary Color,
                //setInActiveColor表示未选中Item中的图标和文本颜色。默认为 Color.LTGRAY,
                //setBarBackgroundColor在BACKGROUND_STYLE_STATIC下，表示整个容器的背景色。而在BACKGROUND_STYLE_RIPPLE下，表示选中Item的图标和文本颜色。默认 Color.WHITE
                .setBarBackgroundColor(R.color.navigationWithe)//设置底部导航栏颜色
                .addItem(getBottomNavigationItem())
                .addItem(new BottomNavigationItem(R.drawable.ic_toke, "沟通"))
                .addItem(new BottomNavigationItem(R.drawable.ic_faxian, "发现"))
                .addItem(new BottomNavigationItem(R.drawable.ic_me, "我的"))
                .setFirstSelectedPosition(0)//设置默认选择item
                .setInActiveColor(R.color.common)//未被选中的item的颜色
                .setActiveColor(R.color.select)//被选中的item的颜色
                .initialise();//初始化.所有的设置需在调用该方法前完成**重要**

        mBottomNavigationBar.setTabSelectedListener(this);//设置item状态的监听。
        setDefaultFragment();//默认显示的fragment
    }



    private void setDefaultFragment() {
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        homeFragment = HomeFragment.newInstance("home");
        transaction.replace(R.id.layFrame,homeFragment);
        transaction.commit();
    }

    @Override
    public void onTabSelected(int i) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (i) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = HomeFragment.newInstance("首页");
                }
                transaction.replace(R.id.layFrame,homeFragment).commit();
                break;
            case 1:
                if (communicateFragment == null) {
                    communicateFragment = CommunicateFragment.newInstance("沟通");
                }
                transaction.replace(R.id.layFrame,communicateFragment).commit();
                break;
            case 2:
                if (discoverFragment == null) {
                    discoverFragment = DiscoverFragment.newInstance("发现");
                }
                transaction.replace(R.id.layFrame,discoverFragment).commit();
                break;
            case 3:
                if (meFragment == null) {
                    meFragment = MeFragment.newInstance("我的");
                }
                transaction.replace(R.id.layFrame,meFragment).commit();
                break;
        }
    }

    @Override
    public void onTabUnselected(int i) {

    }

    @Override
    public void onTabReselected(int i) {

    }

    private void initDot() {
        badgeItem = new TextBadgeItem();
        badgeItem.setHideOnSelect(true)
                .setText(number)
                .setBorderWidth(0);
    }

    public BottomNavigationItem getBottomNavigationItem() {
        if (number != null){
            return new BottomNavigationItem(R.drawable.ic_home, "主页").setBadgeItem(badgeItem);
        }else {
            return new BottomNavigationItem(R.drawable.ic_home, "主页");
        }
    }
}
