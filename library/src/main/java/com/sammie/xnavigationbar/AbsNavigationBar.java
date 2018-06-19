package com.sammie.xnavigationbar;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class AbsNavigationBar<P extends AbsNavigationBar.Builder.NavigationParams> implements INavigation{

    private P mParam;
    private View mView;

    public AbsNavigationBar(P param){
        mParam = param;
        createAndBind();
    }

    protected String getString(int res){
        return mParam.context.getResources().getString(res);
    }

    protected int getColor(int res){
        return ContextCompat.getColor(mParam.context,res);
    }

    protected P getParam(){
        return mParam;
    }


    /**
     * 设置文本
     * @param viewId
     * @param text
     */
    protected void setText(int viewId, CharSequence text) {
        TextView tv = findViewById(viewId);
        if (tv != null) {
            tv.setText(text);
        }
    }

    /**
     * 设置点击事件
     * @param viewId
     * @param listener
     */
    protected void setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = findViewById(viewId);
        if (view != null) {
            view.setOnClickListener(listener);
        }
    }


    /**
     * 设置背景资源
     * @param viewId
     * @param resourceId
     */
    protected void setImageResource(int viewId, int resourceId) {
        ImageView imageView = findViewById(viewId);
        if (imageView != null) {
            imageView.setImageResource(resourceId);
        }
    }

    protected <T extends View> T findViewById(int id) {
        return (T) mView.findViewById(id);
    }

    private void createAndBind(){
        if(null != mParam){
            return;
        }
        mView = LayoutInflater.from(mParam.context).inflate(bindLayoutId(),mParam.parent,false);
        mParam.parent.addView(mView,0);
        applyView();
    }

    public abstract static class Builder{
        public abstract AbsNavigationBar create();

        public static class NavigationParams{
            public Context context;
            public ViewGroup parent;

            public NavigationParams(Context context, ViewGroup parent) {
                this.context = context;
                this.parent = parent;
            }
        }
    }
}
