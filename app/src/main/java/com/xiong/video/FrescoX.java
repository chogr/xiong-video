package com.xiong.video;

import android.content.Context;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * FrescoX
 * Created by 杨超 on 2016/5/2.
 */
public class FrescoX {
    private static GenericDraweeHierarchy getHierarchy(Context context) {
        GenericDraweeHierarchyBuilder builder =
                new GenericDraweeHierarchyBuilder(context.getResources());
        return builder
                .setFadeDuration(300)
                .build();
    }

    public static void duang(Context context, SimpleDraweeView simpleDraweeView) {
        simpleDraweeView.setHierarchy(getHierarchy(context));
    }
}
