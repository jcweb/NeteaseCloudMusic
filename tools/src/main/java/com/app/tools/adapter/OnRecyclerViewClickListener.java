package com.app.tools.adapter;

/*
@description：recyclerView item点击监听时间
Created by chenjie on 2018/10/30.
*/

import android.view.View;

public interface OnRecyclerViewClickListener {
    /**
     * 点击item监听时间
     * @param view View
     * @param position position
     */
    void onItemClick(View view, int position);

    /**
     * 长按监听时间
     * @param view View
     * @param position position
     */
    void onItemLongClick(View view, int position);
}
