package com.example.jh.gridview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * GridView属性设置解析：

 anroid:numColumns="3"GridView的列数设置为3
 android:columnWidth="90dp",每列的宽度，也就是Item的宽度
 android:stretMode="columnWidth" 缩放与列宽大小同步
 android:verticalSpacing="10dp" 两行之间的边距
 android:horizontalSpacing="10dp" 两列之间的边距
 */
public class MainActivity extends AppCompatActivity {

    private GridView gv;//声明GridView视图

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv = (GridView) findViewById(R.id.gv);
        gv.setAdapter(new MyAdapter(this));//通过设置适配器实现网格内布局
        //为每个单元格（item）添加单击事件
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view.findViewById(R.id.tv);
                Toast t =Toast.makeText(MainActivity.this,tv.getText().toString(),Toast.LENGTH_SHORT);
                t.setGravity(Gravity.TOP,0,0);
                t.show();
            }
        });
    }


}
