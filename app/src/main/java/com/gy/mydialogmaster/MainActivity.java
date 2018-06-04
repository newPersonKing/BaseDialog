package com.gy.mydialogmaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import view.BaseDialog;
import view.dialogimpl.LinearLayoutBottomDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    public void showDialog(){
        LinearLayoutBottomDialog dialog=new LinearLayoutBottomDialog(R.layout.layout_dialog_item,this);

        dialog.addItemView(new LinearLayoutBottomDialog.ItemCallBack() {
            @Override
            public void setViewMessage(View view) {
                 /*这里使用默认布局 也可以设置监听*/
            }
        }).addItemView(R.layout.layout_dialog_item_1, new LinearLayoutBottomDialog.ItemCallBack() {
            @Override
            public void setViewMessage(View view) {
                /*这里使用自己的布局 可以给view进行设置*/
            }
        }).setGravity(Gravity.BOTTOM)/*设置位置*/
        .setAnimType(BaseDialog.AnimInType.BOTTOM)/*设置动画*/
        .setDimAmount(0.2f)/*设置阴影*/
        .setWidthandHeight(100,200)/*设置宽高*/
        .isCanceledOnTouchOutside(false);/*设置点击外部是否小时*/

        dialog.show();
    }
}
