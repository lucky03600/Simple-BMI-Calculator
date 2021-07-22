package com.lakeskluckysimplebmi.simplebmicalculator;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleFragment extends Fragment {

    EditText no1, no2;
    Button add,sub,mult,div,clear;
    TextView result;

    public SimpleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_simple, container, false);
        no1=(EditText)view.findViewById(R.id.editText1);
        no2=(EditText)view.findViewById(R.id.editText2);
        add=(Button)view.findViewById(R.id.addition);
        sub=(Button)view.findViewById(R.id.subtraction);
        mult=(Button)view.findViewById(R.id.multiplication);
        div=(Button)view.findViewById(R.id.division);
        clear=(Button)view.findViewById(R.id.clear_btn);
        result=(TextView)view.findViewById(R.id.result);

        RelativeLayout relativeLayout=view.findViewById(R.id.layout);
        AnimationDrawable animationDrawable=(AnimationDrawable)relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (no1.getText().length()>0 && no2.getText().length()>0)
                {
                    Double input1=Double.parseDouble(no1.getText().toString());
                    Double input2=Double.parseDouble(no2.getText().toString());

                    final Double res=input1+input2;
                    result.setText(Double.toString(res));

                }
                else
                {
                    Toast.makeText(getActivity(), "Please enter both the fields.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (no1.getText().length()>0 && no2.getText().length()>0)
                {
                    Double input1=Double.parseDouble(no1.getText().toString());
                    Double input2=Double.parseDouble(no2.getText().toString());

                    final Double res=input1-input2;
                    result.setText(Double.toString(res));

                }
                else
                {
                    Toast.makeText(getActivity(), "Please enter both the fields.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (no1.getText().length()>0 && no2.getText().length()>0)
                {
                    Double input1=Double.parseDouble(no1.getText().toString());
                    Double input2=Double.parseDouble(no2.getText().toString());

                    final Double res=input1*input2;
                    result.setText(Double.toString(res));

                }
                else
                {
                    Toast.makeText(getActivity(), "Please enter both the fields.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (no1.getText().length()>0 && no2.getText().length()>0)
                {
                    Double input1=Double.parseDouble(no1.getText().toString());
                    Double input2=Double.parseDouble(no2.getText().toString());

                    final Double res=input1/input2;
                    result.setText(Double.toString(res));

                }
                else
                {
                    Toast.makeText(getActivity(), "Please enter both the fields.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                no1.setText("");
                no2.setText("");
                result.setText("0.00");

                no1.requestFocus();
            }
        });
        return view;
    }

}
