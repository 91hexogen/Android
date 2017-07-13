package com.example.p1colo.animation;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

public class AnimationActivity
        extends AppCompatActivity
        implements View.OnClickListener, Animation.AnimationListener{

    Button animationsObjekt;
    ConstraintLayout layout;
    AnimationSet animationSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        animationsObjekt = (Button)findViewById(R.id.button);
        layout = (ConstraintLayout)findViewById(R.id.my_layout);

        animationSet =
                (AnimationSet)AnimationUtils.loadAnimation(this, R.anim.my_animation);

        //animationsObjekt.clearAnimation();
        //animationsObjekt.startAnimation(animationSet);


        animationsObjekt.setOnClickListener(this);

        animationSet.setAnimationListener(this);

        //layout.startAnimation(animationSet);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                animationsObjekt.clearAnimation();
                animationsObjekt.startAnimation(animationSet);
                break;
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {
        Toast.makeText(getApplicationContext(), "START ANIMATION", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Toast.makeText(getApplicationContext(), "END ANIMATION", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
