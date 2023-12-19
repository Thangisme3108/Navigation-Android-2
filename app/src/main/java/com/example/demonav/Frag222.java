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

public class Frag222 extends Fragment {
    TextView tv02;
    Button btn02;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
// xoá cái này đi        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.layout_frag222, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // ánh xạ view
        tv02 = view.findViewById(R.id.tv02);
        btn02 = view.findViewById(R.id.btn_02);

        // tương tác nút bấm
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Bạn bấm nút ở Frag 222", Toast.LENGTH_SHORT).show();
                tv02.setText("Đã bấm nút Frag 222");
            }
        });
    }
}
