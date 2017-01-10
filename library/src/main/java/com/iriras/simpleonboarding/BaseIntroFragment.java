package com.iriras.simpleonboarding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.iriras.geser_intronya_kang.R;

/**
 * Created by irfan on 09/01/17.
 */

public abstract class BaseIntroFragment extends Fragment {

    public static final int RESOURCE_TYPE_LAYOUT = 0;
    public static final int RESOURCE_TYPE_DRAWABLE = 1;

    //get title
    protected abstract String getTitle();

    //get title color
    protected abstract int getTitleColor();

    //get description
    protected abstract String getDescription();

    //get description color
    protected abstract int getDescriptionColor();

    //get layout id
    protected abstract int getLayoutId();

    //get drawable id
    protected abstract int getDrawableId();

    //get resource id type
    protected abstract int getResourceType();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.boarding_page, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //set the view layer to a hardware rendering layer
        view.setLayerType(View.LAYER_TYPE_HARDWARE, null);

        //set a tag on the view so we can use it for custom animations
        view.setTag(this);

        //title
        TextView mTitle = (TextView) view.findViewById(R.id.titles);
        mTitle.setText(getTitle());
        mTitle.setTextColor(getTitleColor());

        //description
        TextView mDescription = (TextView) view.findViewById(R.id.description);
        mDescription.setText(getDescription());
        mDescription.setTextColor(getTitleColor());

        /// ViewStub
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.viewstub);
        switch (getResourceType()) {
            // If the resource ID represents a layout ID,
            // inflate the layout based on the ID
            case RESOURCE_TYPE_LAYOUT:
                if (getLayoutId() != 0) {
                    viewStub.setLayoutResource(getLayoutId());
                    viewStub.inflate();
                }
                break;

            case RESOURCE_TYPE_DRAWABLE:
                viewStub.setLayoutResource(R.layout.boarding_drawable);
                viewStub.inflate();

                ImageView mImageView = (ImageView) view.findViewById(R.id.imageview);
                mImageView.setImageResource(getDrawableId());
                break;
        }
    }
}
