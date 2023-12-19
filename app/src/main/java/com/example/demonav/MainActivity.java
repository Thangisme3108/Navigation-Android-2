package com.example.demonav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout001;
    Toolbar mtoolbar001;
    NavigationView nav001;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ
        drawerLayout001 = findViewById(R.id.drawerLayout001);
        mtoolbar001 = findViewById(R.id.mtoolbar001);
        nav001 = findViewById(R.id.nav001);

        // Gắn toolbar vào activity
        setSupportActionBar( mtoolbar001 );
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        // Viết code tương tác đóng mở menu
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout001,
                mtoolbar001,
                R.string.open,
                R.string.close  // vào file values/string thêm 2 thẻ string đặt tên open và close
                                //              <string name="open">Open</string>
                                //              <string name="close">Close</string>
        );

        // Cài đặt cập nhật trạng thái
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();
        drawerLayout001.addDrawerListener(drawerToggle);

        // Viết code xử lý lựa chọn menu
        nav001.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fr;
                if (item.getItemId() == R.id.home) {
                    // Trang chính hiển thị frag111
                    fr = new Frag111();
                    mtoolbar001.setTitle("Màn hình HOME");
                } else if (item.getItemId() == R.id.qlsp) {
                    fr = new Frag222();
                    mtoolbar001.setTitle("Màn hình quản lý sản phẩm");
                } else if (item.getItemId() == R.id.setting) {
                    // Chuyển sang activity mới
                    startActivity(new Intent(MainActivity.this, DemoBottomNavActivity.class));
                    return true;    // thoát khỏi màn
                } else {
                    fr = new Frag111();; // để tạm bằng frag111
                    mtoolbar001.setTitle(item.getTitle());
                }

                // Sau khi kiểm tra hết các trường hợp replace fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.frag_container001, fr).commit();
                drawerLayout001.close(); // đóng menu

                return true;
            }
        });
    }


}