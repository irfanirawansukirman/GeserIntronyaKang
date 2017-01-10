package com.iriras.simpleonboarding;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.widget.ImageButton;

import com.iriras.geser_intronya_kang.R;

/**
 * Created by irfan on 09/01/17.
 */

public class FinishButton extends ImageButton {
    public static final int STYLE_NEXT = 0;
    public static final int STYLE_DONE = 1;
    public int mColor = 0;
    public int mButtonStyle;

    public Drawable mNextDrawable;
    public Drawable mDoneDrawable;

    public FinishButton(Context context) {
        super(context);
        initialized(context);
        showNextButton(true);
    }

    public FinishButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialized(context);
        showNextButton(true);
    }

    @SuppressLint("NewApi")
    private void initialized(Context mContext){
        setBackgroundResource(R.drawable.next_done_button_selector);
        mNextDrawable = ContextCompat.getDrawable(mContext, getDoneDrawable());
        mDoneDrawable = ContextCompat.getDrawable(mContext, getNextDrawable());

        if (mColor == 0){
            mColor = ContextCompat.getColor(mContext, R.color.next_done_icon_color);
        }

        if(Utils.isLollipop()){
            mNextDrawable.setTint(mColor);
            mDoneDrawable.setTint(mColor);
        } else {
            mNextDrawable = DrawableCompat.wrap(mNextDrawable);
            mDoneDrawable = DrawableCompat.wrap(mDoneDrawable);

            DrawableCompat.setTint(mNextDrawable, mColor);
            DrawableCompat.setTint(mDoneDrawable, mColor);
        }

        setImageDrawable(mButtonStyle == STYLE_NEXT ? mNextDrawable : mDoneDrawable);
    }

    private int getDoneDrawable(){
        return Utils.isLollipop() ? R.drawable.done_to_next : R.drawable.next;
    }

    private int getNextDrawable(){
        return Utils.isLollipop() ? R.drawable.next_to_done : R.drawable.done;
    }

    /**
     * Set the color of the button icon.
     * @param color Color for the button icon.
     */
    public void setColor(int color){
        mColor = color;
        tintDrawables();
    }

    private void tintDrawables(){
        if (Utils.isLollipop()){
            mNextDrawable.setTint(mColor);
            mDoneDrawable.setTint(mColor);
        } else {
            mNextDrawable = DrawableCompat.wrap(mNextDrawable);
            mDoneDrawable = DrawableCompat.wrap(mDoneDrawable);

            DrawableCompat.setTint(mNextDrawable, mColor);
            DrawableCompat.setTint(mDoneDrawable, mColor);
        }
    }

    /**
     * Toggle the current button style, changing the icon
     * and animating the change if the device supports it.
     */
    public void toggle(){
        //toggle the button style
        mButtonStyle = (mButtonStyle == STYLE_NEXT) ? STYLE_DONE : STYLE_NEXT;

        //set image drawable depending on the button style
        setImageDrawable(mButtonStyle == STYLE_NEXT ? mNextDrawable : mDoneDrawable);

        //attempt to animate the button if we are on lollipop or above
        if (Utils.isLollipop()){
            Drawable mDrawable = getDrawable();
            if (mDrawable instanceof Animatable){
                Animatable mAnimatable = (Animatable) mDrawable;
                if (mAnimatable.isRunning()){
                    mAnimatable.stop();
                }
                mAnimatable.start();
            }
        }
    }

    /**
     * Get the current button style.
     * @return STYLE_NEXT if the Next button is currently shown, STYLE_DONE
     * if the Done button is currently shown.
     */
    public int getButtonStyle(){
        return mButtonStyle;
    }

    /**
     * Show the Next button.
     * @param animate True if the icon change should be animated, false otherwise.
     */
    public void showNextButton(boolean animate){
        if (animate){
            mButtonStyle = STYLE_DONE;
            toggle();
        } else {
            mButtonStyle = STYLE_NEXT;
            setImageDrawable(mNextDrawable);
        }
    }

    /**
     * Show the Done button.
     * @param animate True if the icon change should be animated, false otherwise.
     */
    public void showDoneButton(boolean animate){
        if (animate){
            mButtonStyle = STYLE_NEXT;
            toggle();
        } else {
            mButtonStyle = STYLE_DONE;
            setImageDrawable(mDoneDrawable);
        }
    }
}
