package com.example.demonav;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag111 extends Fragment {
    TextView tv01;
    Button btn01;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
// xoá cái này đi        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.layout_frag111, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // ánh xạ view
        tv01 = view.findViewById(R.id.tv01);
        btn01 = view.findViewById(R.id.btn_01);

        // tương tác nút bấm
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Bạn bấm nút ở Frag 111", Toast.LENGTH_SHORT).show();
                tv01.setText("Đã bấm nút Frag 111");

                // gửi dữ liệu sang activity
//                ( (MainActivity) getActivity() ).NhanDuLieuTuFrag111( "Frag1111 xin chào");

                // gợi ý code gửi sang frag222:
                Frag222 frag222 = (Frag222) getActivity().getSupportFragmentManager().findFragmentByTag("f2");
                // Gọi hàm nhận dữ liệu ở Frag222, bên Frag222 phải cần viết hàm public nhận dữ liệu
//                frag222.nhanDuLieu.....
//                áp dụng ở ví dụ đầu fragment dễ quan sát hơn

            }
        });
    }

    public void NhanDuLieuTuActivity(String chuoi) {
        tv01.setText("DuLieuActivity: " + chuoi);
    }


}
