package com.example.textviwanimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;

import java.util.Timer;
import java.util.TimerTask;

import static com.daimajia.androidanimations.library.BaseViewAnimator.DURATION;

public class MainActivity3 extends AppCompatActivity implements ViewTreeObserver.OnScrollChangedListener  {

  /*  RelativeLayout rl_footer;
    ImageView iv_header;*/
    boolean isBottom = true;
    Button btn1;
    LinearLayout rl_footer;
    Animation animSlideDown ;
    Animation slideUpAnimation, slideDownAnimation;
    NestedScrollView scroll;
    View line_view;
    private TimerTask task;
//    private ArrowLayout mArrowLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        animSlideDown = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
        rl_footer = findViewById(R.id.rl_footer);
        scroll = findViewById(R.id.scroll);
        line_view = findViewById(R.id.line_view);
//        mArrowLayout = (ArrowLayout) findViewById(R.id.arrow_layout);
//        scroll.setFillViewport(true);
        scroll.fullScroll(View.FOCUS_DOWN);
        slideUpAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up_animation);
//        scroll.startAnimation(slideUpAnimation);
        int[] location = new int[2];
        int[] coords = {0,0};
        scroll.getLocationOnScreen(coords);
        int x = location[0];
        int y = location[1];

        int absoluteTop = coords[1];
        int absoluteBottom = coords[1] + rl_footer.getHeight();

        Log.e("x" ," "+x);
        Log.e("y" ," "+y);

        Log.e("absoluteTop" ," "+absoluteTop);
        Log.e("absoluteBottom" ," "+absoluteBottom);

//        rl_footer.startAnimation(slideUpAnimation);
//        slideUp(rl_footer);



//        scroll.fullScroll(ScrollView.FOCUS_DOWN);

        scroll.post(new Runnable() {
            @Override
            public void run() {
                scroll.fullScroll(ScrollView.FOCUS_DOWN);
                //scroll.scrollTo(0, 0);

            }
        });

        ValueAnimator anim = ValueAnimator.ofInt(line_view.getMeasuredHeight(), -100);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = line_view.getLayoutParams();
                layoutParams.height = val;
                line_view.setLayoutParams(layoutParams);
            }
        });
        anim.setDuration(DURATION);
        anim.start();

        // slideToTop(scroll);
//        slideToTop(line_view);
/*

        task = new TimerTask() {
            @Override
            public void run() {
                scroll.startAnimation(slideUpAnimation);

            }
        };

        Timer t = new Timer();
        t.schedule(task, 1000);
*/


//        mArrowLayout.animateArrows(1000);

/*


        new CountDownTimer(2000,20){
            @Override
            public void onTick(long millisUntilFinished) {
               scroll.scrollTo(0,(int) (2000 - millisUntilFinished) );
//                scroll.scrollTo(0, 0);

            }
            @Override
            public void onFinish() {

            }
        }.start();



*/



//        scroll.fullScroll(View.FOCUS_DOWN);
//        scroll.setAnimation(animSlideDown);
        //SlideToAbove();
//        SlideToDown();

       /* rl_footer = (RelativeLayout) findViewById(R.id.rl_footer);
        iv_header = (ImageView) findViewById(R.id.iv_up_arrow);*/
/*
        iv_header.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                iv_header.setImageResource(R.drawable.down_arrow);
                iv_header.setPadding(0, 10, 0, 0);
                rl_footer.setBackgroundResource(R.drawable.up_manu_bar);
                if (isBottom) {
                    SlideToAbove();
                    isBottom = false;
                } else {
                    iv_header.setImageResource(R.drawable.up_arrow);
                    iv_header.setPadding(0, 0, 0, 10);
                    rl_footer.setBackgroundResource(R.drawable.down_manu_bar1);
                    SlideToDown();
                    isBottom = true;
                }

            }
        });*/
    }

    public static void slideToTop(View view){
        TranslateAnimation animate = new TranslateAnimation(0,0,view.getHeight(),0);
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
        view.setVisibility(View.VISIBLE);
    }

/*    @Override
    protected void onResume() {
        super.onResume();
        overridePendingTransition(R.anim.slide_in_up, R.anim.stay);
    }*/



    public static void slideUp(final View view) {
        view.post(new Runnable() {
            @Override
            public void run() {
                final int height = view.getHeight();
                ValueAnimator valueAnimator = ObjectAnimator.ofInt(height, 0);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int value = (int) animation.getAnimatedValue();
                        if (value > 0) {
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            layoutParams.height = value;
                            view.setLayoutParams(layoutParams);
                        }else{
//                            view.setVisibility(View.GONE);
                        }
                    }
                });
                valueAnimator.start();
            }
        });

    }


    public void SlideToAbove() {
        Animation slide = null;
        slide = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, -5.0f);

        slide.setDuration(400);
        slide.setFillAfter(true);
        slide.setFillEnabled(true);

        rl_footer.startAnimation(slide);

        slide.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                rl_footer.clearAnimation();



            }

        });

    }


    public void SlideToDown() {
        Animation slide = null;
        slide = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 5.2f);

        slide.setDuration(400);
        slide.setFillAfter(true);
        slide.setFillEnabled(true);
        rl_footer.startAnimation(slide);

        slide.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                rl_footer.clearAnimation();



            }

        });

    }


    @Override
    public void onScrollChanged() {
        View view = scroll.getChildAt(scroll.getChildCount() - 1);
        int topDetector = scroll.getScrollY();
        int bottomDetector = view.getBottom() - (scroll.getHeight() + scroll.getScrollY());
        if(bottomDetector == 0 ){
            Toast.makeText(getBaseContext(),"Scroll View bottom reached",Toast.LENGTH_SHORT).show();
        }
        if(topDetector <= 0){
            Toast.makeText(getBaseContext(),"Scroll View top reached",Toast.LENGTH_SHORT).show();
        }
    }
}