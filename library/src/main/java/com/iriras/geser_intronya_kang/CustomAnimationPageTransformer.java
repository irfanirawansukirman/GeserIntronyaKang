package com.iriras.geser_intronya_kang;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by irfan on 09/01/17.
 */

public class CustomAnimationPageTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        if (page instanceof CustomAnimationPageTransformerDelegate){
            CustomAnimationPageTransformerDelegate delegate = (CustomAnimationPageTransformerDelegate) page.getTag();

            if (position == 0.0f){
                //page is selected
                delegate.onPageSelected();
            } else if (position <= -1.0f || position >= 1.0f) {
                //page is not visible to user
                delegate.onPageInvisible(position);
            } else {
                //page is being scrolled
                delegate.onPageScrolled(page, position);
            }
        }
    }
}
