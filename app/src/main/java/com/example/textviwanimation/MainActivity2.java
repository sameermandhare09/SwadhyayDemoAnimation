package com.example.textviwanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class MainActivity2 extends AppCompatActivity {
    Button button;
    Animation animation1,animation2,animation3,animation4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = findViewById(R.id.button);

        //Animation Calls
        animation1 = AnimationUtils.loadAnimation(this, R.anim.bottom_animation1);
        animation2 = AnimationUtils.loadAnimation(this, R.anim.bottom_animation2);
        animation3 = AnimationUtils.loadAnimation(this, R.anim.bottom_animation3);
        animation4 = AnimationUtils.loadAnimation(this, R.anim.bottom_animation4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                popupWindow();

               /* Intent intent  = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);*/
            }
        });
    }

    /*void bottomShit(){
        Sampler.Value displayMetrics = DisplayMetrics();

        WindowManager windowManager = WindowManager
        WindowManager.defaultDisplay.getMetrics(displayMetrics);

        //To get an beautiful curve, Optimal value is screenWidth/6
        CurvedBottomSheet((displayMetrics.widthPixels/6).toFloat(),view = bottom_sheet).init();

    }*/

    void popupWindow(){
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View customView = inflater.inflate(R.layout.popup_window,null);
        PopupWindow pw = new PopupWindow(
                customView,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                true
                );

        View v1 = customView.findViewById(R.id.first_line);
        View v2 = customView.findViewById(R.id.second_line);
        View v3 = customView.findViewById(R.id.third_line);
        View v4 = customView.findViewById(R.id.fifth_line);
        LinearLayout lnr_info = customView.findViewById(R.id.lnr_info);

        //-----------Setting Animations to the elements
        v4.setAnimation(animation1);
        v3.setAnimation(animation2);
        v2.setAnimation(animation3);
        v1.setAnimation(animation4);
        lnr_info.setAnimation(animation4);

        pw.showAtLocation(this.findViewById(R.id.cl), Gravity.BOTTOM, 0, 0);


    }
}