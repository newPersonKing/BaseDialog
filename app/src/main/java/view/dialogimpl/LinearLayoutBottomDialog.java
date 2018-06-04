package view.dialogimpl;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gy.mydialogmaster.R;

import view.BaseDialog;

public class LinearLayoutBottomDialog extends BaseDialog {

    private int itemLayout;

    private LinearLayout contentLinear;

    public LinearLayoutBottomDialog(@LayoutRes int itemLayoutId, @NonNull Context context) {
        super(context);
        itemLayout=itemLayoutId;
    }

    public LinearLayoutBottomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected LinearLayoutBottomDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected View getContentView() {
        View view=View.inflate(getContext(),R.layout.layout_linear_bottom_dialog,null);
        contentLinear=view.findViewById(R.id.content_linear);
        TextView cancle=view.findViewById(R.id.cancle);
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return view;
    }

    public LinearLayoutBottomDialog addItemView(@LayoutRes int itemLayout,ItemCallBack callBack){
        View itemView=View.inflate(getContext(),itemLayout,null);
        contentLinear.addView(itemView);
        callBack.setViewMessage(itemView);
        return this;
    }

    public LinearLayoutBottomDialog addItemView(ItemCallBack callBack){
        View itemVieww=View.inflate(getContext(),itemLayout,null);
        contentLinear.addView(itemVieww);
        callBack.setViewMessage(itemVieww);
        return this;
    }

    public interface ItemCallBack{
        /*给view设置资源  也可以设置监听*/
        void setViewMessage(View view);
    }
}
