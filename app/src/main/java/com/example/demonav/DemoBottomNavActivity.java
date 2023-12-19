package com.example.demonav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class DemoBottomNavActivity extends AppCompatActivity {
    BottomNavigationView bottomNav01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_bottom_nav);
        bottomNav01 = findViewById(R.id.bottom_nav01);

        // Khi mới vào màn hình thì nên hiển thị mặc định fragment
        getSupportFragmentManager().beginTransaction().add(R.id.frag_container002, new Frag111()).commit();

        // Sự kiện bấm menu
        bottomNav01.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fr;
                if (item.getItemId() == R.id.home01) {
                    // Quay về activity main
                    finish();   // vì activity này được khởi động từ activity main, nên chỉ cần finish
                    return true; // thoát khỏi hàm luôn
                } else if (item.getItemId() == R.id.chat) {
                    fr = new Frag111();
                } else {
                    fr = new Frag222();
                }
                // Cập nhật fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.frag_container002, fr).commit();

                return true;
            }
        });

    }
}