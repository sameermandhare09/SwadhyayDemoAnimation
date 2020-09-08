package com.example.textviwanimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.daimajia.androidanimations.library.sliders.SlideInRightAnimator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    TextView txtView;
    ConstraintLayout splash_screen;
    List<Drawable> mImageUrl = new ArrayList<android.graphics.drawable.Drawable>();
    //private ImageLoader mImageLoader =  new ImageLoader(MainActivity.this);
    //MainActivity activity = new MainActivity();
    //ImageLoader imageLoader=new ImageLoader(activity.getApplicationContext());


    private static int SPLASH_TIME_OUT = 5000;
    //Hooks
    View first,second,third,fourth,fifth;
    private TimerTask task,task1;

    //Animations
    Animation topAnimantion1,topAnimantion2,topAnimantion3,topAnimantion4,
            topAnimantion5;
    ImageView img_title,img_title_icon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  /*      txtView = findViewById(R.id.txtView);
        splash_screen = findViewById(R.id.splash_screen);
        mImageUrl.add(getDrawable(R.drawable.img_15));
        mImageUrl.add(getDrawable(R.drawable.img_14));
        mImageUrl.add(getDrawable(R.drawable.img_13));
        mImageUrl.add(getDrawable(R.drawable.img_12));
        mImageUrl.add(getDrawable(R.drawable.img_11));
        */

/*

        YoYo.with(Techniques.FlipOutY)
        .duration(2000)
        .playOn(txtView);

        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                if (i < mImageUrl.size()) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            splash_screen.setBackground(mImageUrl.get(i));
                            i++;
                        }
                    });
                } else {
                    i = 0;
                }
            }
        }, 0, 2000);
*/




//Hooks
        first = findViewById(R.id.first_line);
        second = findViewById(R.id.second_line);
        third = findViewById(R.id.third_line);
        fourth = findViewById(R.id.fourth_line);
        fifth = findViewById(R.id.fifth_line);
        img_title = findViewById(R.id.img_title);
        img_title_icon = findViewById(R.id.img_title_icon);
        //sixth = findViewById(R.id.sixth_line);

        //slogan = findViewById(R.id.tagLine);


        //Animation Calls
        topAnimantion1 = AnimationUtils.loadAnimation(this, R.anim.top_animation1);
        topAnimantion2 = AnimationUtils.loadAnimation(this, R.anim.top_animation2);
        topAnimantion3 = AnimationUtils.loadAnimation(this, R.anim.top_animation3);
        topAnimantion4 = AnimationUtils.loadAnimation(this, R.anim.top_animation4);
        topAnimantion5 = AnimationUtils.loadAnimation(this, R.anim.top_animation5);


        //-----------Setting Animations to the elements of SplashScreen-------- -
        first.setAnimation(topAnimantion5);
//        first.setScrollBarFadeDuration(2000);
        second.setAnimation(topAnimantion4);
        third.setAnimation(topAnimantion3);
        fourth.setAnimation(topAnimantion2);
        fifth.setAnimation(topAnimantion1);
        //sixth.setAnimation(topAnimantion);
       // a.setAnimation(middleAnimation);
        //slogan.setAnimation(bottomAnimation);

        task = new TimerTask() {
            @Override
            public void run() {
                collapse(img_title);

            }
        };

        Timer t = new Timer();
        t.schedule(task, 8000);

        task1 = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                finish();


            }
        };
        Timer t1 = new Timer();
        t1.schedule(task1, 10000);

    }



    public void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();
        final int initialWidth = v.getMeasuredWidth();

        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if(interpolatedTime == 500){
                    v.setVisibility(View.GONE);

                }else{
                  /*  v.getLayoutParams().height = initialHeight - (int)(initialHeight * interpolatedTime);
                    v.requestLayout();*/

                    v.getLayoutParams().width = initialWidth - (int)(initialWidth * interpolatedTime);
                    v.requestLayout();

                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }


        };

        // Collapse speed of 1dp/ms
//        a.setDuration((int)(initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        a.setDuration((int)(initialWidth / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);




    }


}