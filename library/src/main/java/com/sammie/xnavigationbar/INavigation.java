package com.sammie.xnavigationbar;

/**
* 导航条规范
* @author ZhangWeijun
* @time 2018/6/19 10:53
*/
public interface INavigation {

    /**
     * 绑定布局
     */
    public int bindLayoutId();

    /**
     * 给View设置参数
     */
    public void applyView();
}
