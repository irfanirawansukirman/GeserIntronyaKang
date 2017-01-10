package com.iriras.simpleonboarding;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.iriras.geser_intronya_kang.R;

/**
 * Created by irfan on 06/01/17.
 */

public abstract class BoardingActivity extends AppCompatActivity {

    private final ArgbEvaluator mArgbEvaluator = new ArgbEvaluator();
    private ViewPager mViewPager;
    private Button mSkipButton;
    private FinishButton mNextButton;
    private IntroScreenPagerAdapter mPagerAdapter;
    private LinearLayout mProgressLayout;
    private boolean mShowSkipButton;
    private boolean mShowNextButton;
    private int mProgressCircleColor;
    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(R.style.IntroActivity_Theme);
        setContentView(R.layout.boarding_activity);
        mContext = this;
        //set up the progress linearlayout
        mProgressLayout = (LinearLayout) findViewById(R.id.lin_geser_progress);

        //set up the back button
        mSkipButton = (Button) findViewById(R.id.btn_geser_skip);
        mSkipButton.setOnClickListener(mOnSkipClickListener);

        //set up the next button
        mNextButton = (FinishButton) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(mOnNextClickListener);

        //set up the viewpager
        mViewPager = (ViewPager) findViewById(R.id.viewpager_geser);

        //set up the pager adapter
        mPagerAdapter = new IntroScreenPagerAdapter(getSupportFragmentManager());
        mViewPager.addOnPageChangeListener(mOnPageChangeListener);

        //set a custom animation PageTransformer
        mViewPager.setPageTransformer(false, new CustomAnimationPageTransformer());

        //call the initialize mthod to add intro screens
        initialized();

        //setup progress layout with circles
        setupProgressLayout();

        //set up viewpager
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setCurrentItem(0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //remove the onPageChangeListener when the activity is destroyed
        mViewPager.removeOnPageChangeListener(mOnPageChangeListener);
    }

    private void setupProgressLayout() {
        int circleSize = Utils.convertDpToPixel(this, 8);
        int circleMargin = Utils.convertDpToPixel(this, 4);

        for (int i = 1; i < mPagerAdapter.getCount(); i++) {
            ImageView mImgView = new ImageView(this);
            mImgView.setBackgroundResource(R.drawable.progress_circle);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(circleSize, circleSize);
            params.setMargins(circleMargin, 0, circleMargin, 0);
            mImgView.setLayoutParams(params);

            mProgressLayout.addView(mImgView);
        }

        //select the first item
        setProgressSelection(0);
    }

    //onClickListener for skip button
    private final View.OnClickListener mOnSkipClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //skip button pressed callback
            onSkipPressed();
        }
    };

    //onClickListener for next button
    private final View.OnClickListener mOnNextClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int currentItem = mViewPager.getCurrentItem();

            //navigate to the next page in the ViewPager if we're not at the and already
            if (currentItem < mPagerAdapter.getCount() - 1) {
                mViewPager.setCurrentItem(currentItem + 1, true);

                //next button pressed callback
                onNextPressed(mViewPager.getCurrentItem());
            } else {
                //done button pressed callback
                onDonePressed();
            }
        }
    };

    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (position < mPagerAdapter.getCount() - 1) {
                //set the background color of the viewpager based on the scroll offset
                mViewPager.setBackgroundColor((Integer) mArgbEvaluator.evaluate(positionOffset,
                        mPagerAdapter.getBackgroundColorForPage(position),
                        mPagerAdapter.getBackgroundColorForPage(position + 1)));
            }
        }

        @Override
        public void onPageSelected(int position) {
            //check if the current viewpager position is at the end
            if (position == mPagerAdapter.getCount() - 1) {
                //show the done button
                mNextButton.showDoneButton(true);

                //hide the skip button
                mSkipButton.setVisibility(View.INVISIBLE);
            } else {
                if (mNextButton.getButtonStyle() == FinishButton.STYLE_DONE) {
                    mNextButton.showNextButton(true);
                }

                if (mShowSkipButton && mSkipButton.getVisibility() != View.VISIBLE) {
                    mSkipButton.setVisibility(View.VISIBLE);
                }
            }

            setProgressSelection(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    protected void setProgressSelection(int position) {
        for (int i = 0; i < mProgressLayout.getChildCount(); i++) {
            mProgressLayout.getChildAt(i).setBackgroundResource(i == position ?
                    R.drawable.progress_circle_selected :
                    R.drawable.progress_circle);

            if (mProgressCircleColor == 0) {
                mProgressCircleColor = ContextCompat.getColor(this, R.color.progress_circle_color);
            }

            mProgressLayout.getChildAt(i).getBackground().setColorFilter(mProgressCircleColor, PorterDuff.Mode.SRC_IN);
        }
    }

    /**
     * Set the color of the progress circles at the bottom
     * of the intro screen.
     *
     * @param color Progress circle color to set.
     */
    protected void setProgressCircleColor(int color) {
        mProgressCircleColor = color;
    }

    //for initialization
    protected abstract void initialized();

    /**
     * Add an intro screen (Fragment) to the ViewPager.
     *
     * @param introScreen Fragment to add.
     */
    protected void addOnBoardingPage(BaseIntroFragment introScreen, int backGroundColor) {
        mPagerAdapter.addFragment(introScreen, backGroundColor);
    }

    /**
     * Determine if the "Next" button should be shown. Default is true.
     *
     * @param showNextButton True if visible, false otherwise.
     */
    protected void setShowNextButton(boolean showNextButton) {
        mShowNextButton = showNextButton;
        mNextButton.setVisibility(mShowNextButton ? View.VISIBLE : View.GONE);
    }

    /**
     * Determine if the "Skip" button should be shown. Default is true.
     *
     * @param showSkipButton True if visible, false otherwise.
     */
    protected void setShowSkipButton(boolean showSkipButton) {
        mShowSkipButton = showSkipButton;
        mSkipButton.setVisibility(mShowSkipButton ? View.VISIBLE : View.GONE);
    }

    /**
     * Set the text color of the Skip button. Default color is white (#F0F0F0).
     *
     * @param color Text color to set.
     */
    protected void setSkipButtonTextColor(int color) {
        mSkipButton.setTextColor(color);
    }

    /**
     * Set the background color of the Next / Done button. The selected color
     * will be 25 percent opaque. Default color is white (#FFFFFF).
     *
     * @param color Background color for the Next / Done button.
     */
    protected void setNextButtonBackgroundColor(int color) {
        mNextButton.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_IN);
    }

    /**
     * Set the color of the arrow / done icon for the Next / Done button.
     * Default color is white (#F0F0F0).
     *
     * @param color
     */
    protected void setNextButtonIconColor(int color) {
        mNextButton.setColor(color);
    }

    //callback when skip button is pressed
    protected abstract void onSkipPressed();

    /**
     * Callback when the "Next" button is pressed.
     *
     * @param pagePosition Zero-based index of the current page position.
     */
    protected abstract void onNextPressed(int pagePosition);

    //callback when done button is pressed
    protected abstract void onDonePressed();
}
