package com.example.jh.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jinhui on 2018/6/10.
 * Email:1004260403@qq.com
 * <p>
 * //自定义适配器（通过继承BaseAdapter）
 */
public class MyAdapter extends BaseAdapter {

    Context context;//声明适配器中引用的上下文
    //将需要引用的图片和文字分别封装成数组
    int[] images = {
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    String[] names = {"功能1", "功能2", "功能3", "功能4", "功能5", "功能6",
            "功能7", "功能8", "功能9", "功能10", "功能11", "功能12",
            "功能13", "功能14", "功能15"};
    private int Type_One = 1;
    private int Type_Two = 2;

    //通过构造方法初始化上下文
    public MyAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return names.length;//images也可以
    }

    @Override
    public Object getItem(int position) {
        return names[position];//images也可以
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if ((position / 4) % 2 == 0){
            return Type_One;
        }else {
            return Type_Two;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        if ((position / 4) % 2 == 0){
             v = LayoutInflater.from(context).inflate(R.layout.item_layout, null);
            //通过布局填充器LayoutInflater填充网格单元格内的布局

            //使用findViewById分别找到单元格内布局的图片以及文字
            ImageView iv = (ImageView) v.findViewById(R.id.iv);
            TextView tv = (TextView) v.findViewById(R.id.tv);
            //引用数组内元素设置布局内图片以及文字的内容
            iv.setImageResource(images[position]);
            tv.setText(names[position]);
            //返回值一定为单元格整体布局v
        }else {
             v = LayoutInflater.from(context).inflate(R.layout.item_layout1, null);
            ImageView iv = (ImageView) v.findViewById(R.id.iv);
            TextView tv = (TextView) v.findViewById(R.id.tv);
            //引用数组内元素设置布局内图片以及文字的内容
            iv.setImageResource(images[position]);
            tv.setText(names[position]);
            //返回值一定为单元格整体布局v
        }
        return v;
    }
}