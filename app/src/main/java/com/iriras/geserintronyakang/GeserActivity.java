package com.iriras.geserintronyakang;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;

import com.iriras.geser_intronya_kang.GeserIntroActivity;
import com.iriras.geser_intronya_kang.GeserIntroFragment;

public class GeserActivity extends GeserIntroActivity {


    @Override
    protected void initialized() {
        String description = "This is a very long and detailed description about absolutely nothing in particular.";

        // Custom intro screen
        addBoardingPage(
                new AnimationIntroFragment(),
                ContextCompat.getColor(this, R.color.material_indigo)
        );

        // Intro screen with title and description
        addBoardingPage(
                GeserIntroFragment.newInstance("Title 0", description),
                ContextCompat.getColor(this, R.color.material_blue)
        );

        // Intro screen with title, description and a custom layout
        addBoardingPage(
                GeserIntroFragment.newInstance("Title 3", description, R.layout.geser_rangka_layout,
                        GeserIntroFragment.RESOURCE_TYPE_LAYOUT),
                ContextCompat.getColor(this, R.color.material_orange)
        );

        // Intro screen with title, description and custom colors for both
        addBoardingPage(
                GeserIntroFragment.newInstance("Title 1", Color.WHITE, description, Color.WHITE),
                ContextCompat.getColor(this, R.color.material_indigo)
        );

        // Intro screen with title, description and custom colors for both
        addBoardingPage(
                GeserIntroFragment.newInstance("Title 2", Color.WHITE, description, Color.WHITE),
                ContextCompat.getColor(this, R.color.material_indigo)
        );

        addBoardingPage(
                GeserIntroFragment.newInstance("Title 3", description, R.drawable.user,
                        GeserIntroFragment.RESOURCE_TYPE_DRAWABLE),
                ContextCompat.getColor(this, R.color.material_green)
        );

        setShowSkipButton(true);
        setShowNextButton(true);
        setSkipButtonTextColor(Color.WHITE);
        setNextButtonBackgroundColor(Color.WHITE);
        setNextButtonIconColor(Color.WHITE);
        setProgressCircleColor(Color.WHITE);
    }

    @Override
    protected void onSkipPressed() {

    }

    @Override
    protected void onNextPressed(int pagePosition) {

    }

    @Override
    protected void onDonePressed() {

    }
}
