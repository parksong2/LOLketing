package com.ezen.lolketing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ezen.lolketing.Fragment.OutlineFragment;
import com.ezen.lolketing.Fragment.PrizeFragment;
import com.ezen.lolketing.Fragment.ProgressFragment;
import com.google.android.material.tabs.TabLayout;

public class LeagueInfoActivity extends AppCompatActivity {

    TextView seat_guide;
    TextView game_schedule;
    private TabLayout tabs;
    private ViewPager viewPager;
    private LeagueInfoAdapter leagueInfoAdapter;

    OutlineFragment outlineFragment;
    ProgressFragment progressFragment;
    PrizeFragment prizeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_info);

        // 프래그먼트 연결
        outlineFragment = new OutlineFragment();
        progressFragment = new ProgressFragment();
        prizeFragment = new PrizeFragment();

        // 좌석안내 클릭시 이벤트
        seat_guide = findViewById(R.id.seat_guide);
        seat_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LeagueInfoActivity.this, "좌석안내 클릭됨", Toast.LENGTH_SHORT).show();
                Log.e("test1", "좌석안내 선택됨");

                Intent intentSeat = new Intent(getApplicationContext(), SeatGuideActivity.class);
                intentSeat.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intentSeat);
            }
        });

        // 경기일정 클릭시 이벤트
        game_schedule = findViewById(R.id.game_schedule);
        game_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LeagueInfoActivity.this, "경기일정 클릭됨", Toast.LENGTH_SHORT).show();
                Log.e("test2", "경기일정 선택됨");

                Intent intentGame = new Intent(getApplicationContext(), GameScheduleActivity.class);
                intentGame.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intentGame);
            }
        });

        // 탭레이아웃, 뷰페이저
        tabs = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        // 뷰페이저 어답터
        leagueInfoAdapter = new LeagueInfoAdapter(getSupportFragmentManager(), tabs.getTabCount());
        viewPager.setAdapter(leagueInfoAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    } // onCreate()


} // class
