package com.example.curly.thietbionline.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;
import android.widget.ViewFlipper;

import com.example.curly.thietbionline.R;
import com.example.curly.thietbionline.adapter.LoaispAdapter;
import com.example.curly.thietbionline.model.Loaisp;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewmanhinhchinh;
    NavigationView navigationView;
    ListView listViewmanhinhchinh;
    DrawerLayout drawerLayout;
    ArrayList<Loaisp> mangloaisp;
    LoaispAdapter loaispAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        Actionbar();
        ActionViewFlipper();
    }

    private void ActionViewFlipper() {
        ArrayList<String> mangquancao = new ArrayList<>();
        mangquancao.add("http://media.techz.vn/upload/2019/01/28/image-techz-1548662000.jpg");
        mangquancao.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXhQfP6sKttqij-LFa-bTM09hiyaxZVrXCCvEd2BDu9rZm8-xzAA");
        mangquancao.add("http://medianews.netnews.vn:8080/netnews/archive/images/2018092616/tinngan_043234_419557404_0.jpg");
        mangquancao.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfSun2F2ZVW2D7AZIdQcUh56UMYvujK5jdi8qbYW26-Jy5KVWE5A");
        for(int i=0;i<mangquancao.size();i++){
            ImageView imgv= new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(mangquancao.get(i)).into(imgv);
            imgv.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imgv);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation a_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in);
        Animation a_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out);
        viewFlipper.setInAnimation(a_slide_in);
        viewFlipper.setOutAnimation(a_slide_out);
    }

    private void Actionbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }


    private void Anhxa() {
        toolbar = findViewById(R.id.toolbarmanhinhchinh);
        viewFlipper = findViewById(R.id.viewFlipper);
        recyclerViewmanhinhchinh = findViewById(R.id.recyclerview);
        navigationView = findViewById(R.id.navigationview);
        listViewmanhinhchinh = findViewById(R.id.listmanhinhchinh);
        drawerLayout = findViewById(R.id.drawerlayout);
        mangloaisp = new ArrayList<>();
        loaispAdapter = new LoaispAdapter(mangloaisp,getApplication());
        listViewmanhinhchinh.setAdapter(loaispAdapter);
    }
}
