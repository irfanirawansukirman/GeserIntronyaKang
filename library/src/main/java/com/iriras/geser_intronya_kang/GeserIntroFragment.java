package com.iriras.geser_intronya_kang;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;

/**
 * Created by irfan on 09/01/17.
 */

public class GeserIntroFragment extends BaseIntroFragment {
    private static final String TITLE = "title";
    private static final String TITLE_COLOR = "titleColor";
    private static final String DESCRIPTION = "description";
    private static final String DESCRIPTION_COLOR = "descriptionColor";
    private static final String LAYOUT_ID = "layoutId";
    private static final String DRAWABLE_ID = "drawableId";
    private static final String RESOURCE_ID_TYPE = "resourceIdType";

    //parameter title, description
    public static GeserIntroFragment newInstance(String title,
                                                 String description) {

        Bundle args = new Bundle();

        GeserIntroFragment fragment = new GeserIntroFragment();
        args.putString(TITLE, title);
        args.putString(DESCRIPTION, description);
        fragment.setArguments(args);
        return fragment;
    }

    //parameter title, description, resource id, resource id type
    public static GeserIntroFragment newInstance(String title,
                                                 String description,
                                                 int resourceId,
                                                 int resourceIdType) {

        Bundle args = new Bundle();

        GeserIntroFragment fragment = new GeserIntroFragment();
        args.putString(TITLE, title);
        args.putString(DESCRIPTION, description);
        args.putInt(RESOURCE_ID_TYPE, resourceIdType);
        args.putInt(resourceIdType == RESOURCE_TYPE_LAYOUT ? LAYOUT_ID : DRAWABLE_ID, resourceId);
        fragment.setArguments(args);
        return fragment;
    }

    //parameter title, title color, description, description color
    public static GeserIntroFragment newInstance(String title,
                                                 int titleColor,
                                                 String description,
                                                 int descriptionColor) {

        Bundle args = new Bundle();

        GeserIntroFragment fragment = new GeserIntroFragment();
        args.putString(TITLE, title);
        args.putInt(TITLE_COLOR, titleColor);
        args.putString(DESCRIPTION, description);
        args.putInt(DESCRIPTION_COLOR, descriptionColor);
        fragment.setArguments(args);
        return fragment;
    }

    //parameter title, title color, description, description color, resource id, resource id type
    public static GeserIntroFragment newInstance(String title,
                                                 int titleColor,
                                                 String description,
                                                 int descriptionColor,
                                                 int resourceId,
                                                 int resourceIdType) {

        Bundle args = new Bundle();

        GeserIntroFragment fragment = new GeserIntroFragment();
        args.putString(TITLE, title);
        args.putInt(TITLE_COLOR, titleColor);
        args.putString(DESCRIPTION, description);
        args.putInt(DESCRIPTION_COLOR, descriptionColor);
        args.putInt(RESOURCE_ID_TYPE, resourceIdType);
        args.putInt(resourceIdType == RESOURCE_TYPE_LAYOUT ? LAYOUT_ID : DRAWABLE_ID, resourceId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected String getTitle() {
        return getArguments().getString(TITLE);
    }

    @Override
    protected int getTitleColor() {
        if (getArguments().containsKey(TITLE_COLOR)){
            return getArguments().getInt(TITLE_COLOR);
        }
        return ContextCompat.getColor(getContext(), R.color.title_color);
    }

    @Override
    protected String getDescription() {
        return getArguments().getString(DESCRIPTION);
    }

    @Override
    protected int getDescriptionColor() {
        if (getArguments().containsKey(DESCRIPTION_COLOR)){
            return getArguments().getInt(DESCRIPTION_COLOR);
        }
        return ContextCompat.getColor(getContext(), R.color.description_color);
    }

    @Override
    protected int getLayoutId() {
        if (getArguments().containsKey(LAYOUT_ID)){
            return getArguments().getInt(LAYOUT_ID);
        }
        return 0;
    }

    @Override
    protected int getDrawableId() {
        if (getArguments().containsKey(DRAWABLE_ID)){
            return getArguments().getInt(DRAWABLE_ID);
        }
        return 0;
    }

    @Override
    protected int getResourceType() {
        if (getArguments().containsKey(RESOURCE_ID_TYPE)){
            return getArguments().getInt(RESOURCE_ID_TYPE);
        }
        return 0;
    }
}
