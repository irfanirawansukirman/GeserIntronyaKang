package com.iriras.simpleonboarding;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;

public class GeserActivity extends BoardingActivity {
    @Override
    protected void initialized() {
        addOnBoardingPage(BoardingIntroFragment.addItemIntoScreen("Lorem",
                ContextCompat.getColor(mContext, R.color.material_blue_grey),
                getString(R.string.dummy),
                ContextCompat.getColor(mContext, R.color.material_blue_grey),
                R.drawable.new_onboard1,
                BoardingIntroFragment.RESOURCE_TYPE_DRAWABLE),
                ContextCompat.getColor(this, R.color.skip_text_color));

        addOnBoardingPage(BoardingIntroFragment.addItemIntoScreen("Lorem",
                ContextCompat.getColor(mContext, R.color.material_blue_grey),
                getString(R.string.dummy),
                ContextCompat.getColor(mContext, R.color.material_blue_grey),
                R.drawable.new_onboard2,
                BoardingIntroFragment.RESOURCE_TYPE_DRAWABLE),
                ContextCompat.getColor(this, R.color.skip_text_color));

        addOnBoardingPage(BoardingIntroFragment.addItemIntoScreen("Lorem",
                ContextCompat.getColor(mContext, R.color.material_blue_grey),
                getString(R.string.dummy),
                ContextCompat.getColor(mContext, R.color.material_blue_grey),
                R.drawable.new_onboard3,
                BoardingIntroFragment.RESOURCE_TYPE_DRAWABLE),
                ContextCompat.getColor(this, R.color.skip_text_color));

        setShowSkipButton(true);
        setShowNextButton(true);
        setSkipButtonTextColor(ContextCompat.getColor(mContext, R.color.material_blue));
        setNextButtonBackgroundColor(ContextCompat.getColor(mContext, R.color.material_blue));
        setNextButtonIconColor(Color.WHITE);
        setProgressCircleColor(ContextCompat.getColor(mContext, R.color.material_blue));
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
