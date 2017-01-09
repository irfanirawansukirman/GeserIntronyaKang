package com.iriras.geser_intronya_kang;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;

/**
 * Created by irfan on 09/01/17.
 */

public class Utils {

    private Utils() {
    }

    /**
     * Converts dp units to pixel units.
     *
     * @param mContext Context
     * @param dp       Units in dp to convert to pixels.
     * @return dp unit converted to pixels.
     */
    public static int convertDpToPixel(Context mContext, int dp) {
        Resources mResources = mContext.getResources();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, mResources.getDisplayMetrics());
    }

    /**
     * Determine if the device has Lollipop (Android 5.0) or greater.
     *
     * @return True if Android 5.0+, false otherwise.
     */
    public static boolean isLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }
}
