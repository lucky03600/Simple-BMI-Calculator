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
public class BMIFragment extends Fragment {

EditText height,weight;
Button calculate,clear;
TextView resultBmi;



    public BMIFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View view = inflater.inflate(R.layout.fragment_bmi, container, false);
        height=(EditText)view.findViewById(R.id.height);
        weight=(EditText)view.findViewById(R.id.weight);
        calculate=(Button)view.findViewById(R.id.calculate);
        resultBmi=(TextView)view.findViewById(R.id.result_bmi);
        clear=(Button)view.findViewById(R.id.clearall_btn);

        RelativeLayout relativeLayout=view.findViewById(R.id.layout1);
        AnimationDrawable animationDrawable=(AnimationDrawable)relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();



        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                height.setText("");
                weight.setText("");
                resultBmi.setText("");
                height.requestFocus();
            }
        });

        return view;

    }

    private void calculateBMI() {
        if (height.getText().length()>0 && weight.getText().length()>0)
        {
            Float heightStr=Float.parseFloat(height.getText().toString())/100;
            Float weightStr=Float.parseFloat(weight.getText().toString());

            final Float bmi=weightStr/(heightStr*heightStr);

            displayBMI(bmi);

        }
        else
        {
            Toast.makeText(getActivity(), "Please enter both the fields.", Toast.LENGTH_SHORT).show();
        }


    }

    private void displayBMI(Float bmi) {
        if (bmi<15f)
        {
            resultBmi.setText(bmi +"\n Very Severely Underweight");
            Toast.makeText(getActivity(), "Underweight", Toast.LENGTH_SHORT).show();

        }
        else if (bmi>=15f && bmi<16f)
        {
            resultBmi.setText(bmi+"\n Severely Underweight");
            Toast.makeText(getActivity(), "Underweight", Toast.LENGTH_SHORT).show();
        }
        else if (bmi>=16f && bmi<18.5f)
        {
            resultBmi.setText(bmi+"\n Underweight");
            Toast.makeText(getActivity(), " Underweight", Toast.LENGTH_SHORT).show();
        }
        else if (bmi>=18.5f && bmi<25f)
        {
            resultBmi.setText(bmi+"\n Normal");
            Toast.makeText(getActivity(), "Healthy weight", Toast.LENGTH_SHORT).show();
        }
        else if (bmi>=25f && bmi<30f)
        {
            resultBmi.setText(bmi+"\n Overweight");
            Toast.makeText(getActivity(), "Overweight", Toast.LENGTH_SHORT).show();
        }
        else if (bmi>=30f && bmi<35f)
        {
            resultBmi.setText(bmi+"\n Obese Class I");
            Toast.makeText(getActivity(), "Moderately Obese", Toast.LENGTH_SHORT).show();
        }
        else if (bmi>=35f && bmi<40f)
        {
            resultBmi.setText(bmi+"\n Obese Class II");
            Toast.makeText(getActivity(), "Severely Obese", Toast.LENGTH_SHORT).show();
        }
        else if (bmi>=40f && bmi<45f)
        {
            resultBmi.setText(bmi+"\n Obese Class III");
            Toast.makeText(getActivity(), "Severely Obese", Toast.LENGTH_SHORT).show();
        }
        else if (bmi>=45f && bmi<50f)
        {
            resultBmi.setText(bmi+"\n Obese Class IV");
            Toast.makeText(getActivity(), "Morbidly Obese", Toast.LENGTH_SHORT).show();
        }
        else if (bmi>=50f && bmi<60f)
        {
            resultBmi.setText(bmi+"\n Obese Class V");
            Toast.makeText(getActivity(), "Super Obese", Toast.LENGTH_SHORT).show();
        }
        else
        {
            resultBmi.setText(bmi+"\n Obese Class VI");
            Toast.makeText(getActivity(), "Hyper Obese", Toast.LENGTH_SHORT).show();
        }


    }

}
