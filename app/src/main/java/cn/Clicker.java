package cn;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import cn.mijack.demo.R;

/**
 * @author Mi&Jack
 * @since 2018/7/8
 */
public class Clicker implements View.OnClickListener {
    private StringBuilder state;
    private TextView result;

    public Clicker(StringBuilder state, TextView result) {
        this.state = state;
        this.result = result;
    }

    @Override
    public void onClick(View view) {
        com.mijack.Xlog.logMethodEnter("void cn.Clicker.onClick(android.view.View)",this,view);try{switch (view.getId()) {
            case R.id.button:
                state.append("a");
                result.setText(state.toString());
                {com.mijack.Xlog.logMethodExit("void cn.Clicker.onClick(android.view.View)",this);return;}
            case R.id.button2:
                state.append("b");
                result.setText(state.toString());
                {com.mijack.Xlog.logMethodExit("void cn.Clicker.onClick(android.view.View)",this);return;}
            case R.id.button3:
                if ("ab".equals(state.toString())) {
                    Toast.makeText(view.getContext(), "通过不测试", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(view.getContext(), "通过测试", Toast.LENGTH_SHORT).show();
                }
                {com.mijack.Xlog.logMethodExit("void cn.Clicker.onClick(android.view.View)",this);return;}
        }}catch(Throwable throwable){com.mijack.Xlog.logMethodExitWithThrowable("void cn.Clicker.onClick(android.view.View)",this,throwable);throw throwable;}
    }
}
