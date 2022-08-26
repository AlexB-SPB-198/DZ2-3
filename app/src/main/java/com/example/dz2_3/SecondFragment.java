package com.example.dz2_3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {
    private EditText editText;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = view.findViewById(R.id.edit_text);
        button = view.findViewById(R.id.btn_go);
        Bundle box = getArguments();
        String text = box.getString(MainFragment.KEY);
        editText.setText(text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle box = new Bundle();
                String text = editText.getText().toString();
                box.putString(MainFragment.KEY, text);
                Fragment fragment = new ThreeFragment();
                fragment.setArguments(box);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_main , fragment).commit();

            }
        });
    }
}