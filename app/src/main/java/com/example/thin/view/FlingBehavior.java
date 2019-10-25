package com.example.thin.view;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

public class FlingBehavior extends AppBarLayout.Behavior {

    public FlingBehavior() {

    }

    public FlingBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, float velocityX, float velocityY) {

//    LogUtils.logd("FlingBehavior", "onNestedFling  velocityY=" + velocityY);

//        if (child.getTag(R.id.status_bar_top) != null) {
//
//            int verticalOffset = (int) child.getTag(R.id.status_bar_top);
//
//            if (child.getTotalScrollRange() - Math.abs(verticalOffset) > 0) {
//
////          onTouchEvent(parent, child, ev);
//
//                onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, false);
//
//                return true;
//
//            }
//
//        }

        return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);

    }

    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, float velocityX, float velocityY, boolean consumed) {

//    LogUtils.logd("FlingBehavior", "onNestedFling  velocityY=" + velocityY);

//        if (child.getTag(R.id.status_bar_top) != null) {
//
//            int verticalOffset = (int) child.getTag(R.id.status_bar_top);
//
//            if (target instanceof RecyclerView && velocityY < 0){
//
//                final RecyclerView recyclerView = (RecyclerView) target;
//
//                if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
//
//                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
//
//                    if (linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
//
//                        if (child.getTotalScrollRange() - Math.abs(verticalOffset) > 0) {
//
//                            consumed = false;
//
//                        }
//
//                    }
//
//                }
//
//            }
//        }

        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);

    }
}
