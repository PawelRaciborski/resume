package com.wec.resume.view;

import android.animation.Animator;


public abstract class BaseAnimatorListener implements Animator.AnimatorListener {
    @Override
    public void onAnimationStart(Animator animation) {
        //no-op
    }

    @Override
    public void onAnimationEnd(Animator animation) {
        //no-op
    }

    @Override
    public void onAnimationCancel(Animator animation) {
        //no-op
    }

    @Override
    public void onAnimationRepeat(Animator animation) {
        //no-op
    }
}
