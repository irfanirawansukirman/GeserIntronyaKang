package com.iriras.simpleonboarding;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;

public class GeserActivity extends GeserIntroActivity {
    @Override
    protected void initialized() {
        addOnBoardingPage(GeserIntroFragment.addItemIntoScreen("Lorem",
                ContextCompat.getColor(mContext, R.color.material_blue_grey),
                getString(R.string.dummy),
                ContextCompat.getColor(mContext, R.color.material_blue_grey),
                R.drawable.new_onboard1,
                GeserIntroFragment.RESOURCE_TYPE_DRAWABLE),
                ContextCompat.getColor(this, R.color.skip_text_color));

        addOnBoardingPage(GeserIntroFragment.addItemIntoScreen("Lorem",
                ContextCompat.getColor(mContext, R.color.material_blue_grey),
                getString(R.string.dummy),
                ContextCompat.getColor(mContext, R.color.material_blue_grey),
                R.drawable.new_onboard2,
                GeserIntroFragment.RESOURCE_TYPE_DRAWABLE),
                ContextCompat.getColor(this, R.color.skip_text_color));

        addOnBoardingPage(GeserIntroFragment.addItemIntoScreen("Lorem",
                ContextCompat.getColor(mContext, R.color.material_blue_grey),
                getString(R.string.dummy),
                ContextCompat.getColor(mContext, R.color.material_blue_grey),
                R.drawable.new_onboard3,
                GeserIntroFragment.RESOURCE_TYPE_DRAWABLE),
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
