package com.example.demoframent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_xem_frag_1, btn_xem_frag_2;
    FragmentManager fm;
    Frag111 frag111;
    Frag222 frag222;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_xem_frag_1 = findViewById(R.id.btn_xem_frag_1);
        btn_xem_frag_2 = findViewById(R.id.btn_xem_frag_2);
        // Khởi tạo biến fm quản lý danh sách các fragment đang hoạt động
        fm = getSupportFragmentManager();
        frag111 = new Frag111();
        frag222 = new Frag222();

        // Khi vào activity cho hiển thị 1 fragment mặc định
        fm.beginTransaction().add(R.id.frag_container01, frag111, "f1").commit();
        // Chạy thử ứng dụng trước khi viết bấm nút
        btn_xem_frag_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().replace(R.id.frag_container01, frag111, "f1").commit();

                // Cách 1: Gửi dữ liệu vào Frag 111
//                frag111.NhanDuLieuTuActivity("Dữ liệu từ Activity");
                // Cách 2: sử dụng tìm theo tag tham khảo ở nút bấm 2
                Frag111 tmp = (Frag111) fm.findFragmentByTag("f1");
                tmp.NhanDuLieuTuActivity("Activity xin chào bằng tag");

            }
        });

        btn_xem_frag_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().replace(R.id.frag_container01, frag222, "f2").commit();
            }
        });

    }

    public void NhanDuLieuTuFrag111 (String duLieu) {
        // Gắn tạm vào tên nút bấm
        btn_xem_frag_1.setTag(duLieu);
    }
}