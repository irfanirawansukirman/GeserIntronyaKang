package com.iriras.geserintronyakang;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.iriras.geser_intronya_kang.BaseIntroFragment;
import com.iriras.geser_intronya_kang.CustomAnimationPageTransformerDelegate;

/**
 * Created by miche on 04-04-2016.
 */
public class AnimationIntroFragment extends BaseIntroFragment implements CustomAnimationPageTransformerDelegate {

    private View mViewGeser;

    @Override
    protected String getTitle() {
        return "Custom animation";
    }

    @Override
    protected int getTitleColor() {
        return Color.WHITE;
    }

    @Override
    protected String getDescription() {
        return "This is pretty cool!";
    }

    @Override
    protected int getDescriptionColor() {
        return Color.WHITE;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.image_layout;
    }

    @Override
    protected int getDrawableId() {
        return 0;
    }

    @Override
    protected int getResourceType() {
        return RESOURCE_TYPE_LAYOUT;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // We MUST call the super method in order for
        // the library to set up the intro page
        super.onViewCreated(view, savedInstanceState);

        mViewGeser = view.findViewById(R.id.img_logo);
    }

    @Override
    public void onPageSelected() {
        // Animate a jump
        ObjectAnimator animation = ObjectAnimator.ofFloat(mViewGeser, "translationY",
                -20f, 20f, -20f, 20f, -20f, 20f, 0f);
        animation.setDuration(1000);
        animation.start();
    }

    @Override
    public void onPageScrolled(View page, float position) {
        int pageWidth = page.getWidth();
        float absPosition = Math.abs(position);
        float pageWidthTimesPosition = pageWidth * absPosition;

        mViewGeser.setTranslationX(pageWidthTimesPosition / 4f);
        mViewGeser.setTranslationY(-pageWidthTimesPosition / 2f);
        mViewGeser.setRotation(-35 * absPosition);
        mViewGeser.setAlpha(1f - absPosition);
    }

    @Override
    public void onPageInvisible(float position) {}
}
