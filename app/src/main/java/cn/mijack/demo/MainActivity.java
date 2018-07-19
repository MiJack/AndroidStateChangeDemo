package cn.mijack.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


import cn.Clicker;

/**
 * @author Mi&Jack
 */
public class MainActivity extends Activity  {
    StringBuilder state = new StringBuilder();
    private Button button;
    private Button button2;
    private Button button3;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        com.mijack.Xlog.logMethodEnter("void cn.mijack.demo.MainActivity.onCreate(android.os.Bundle)",this,savedInstanceState);try{super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        result = findViewById(R.id.result);
        Clicker clicker = new Clicker(state, result);
        button.setOnClickListener(clicker);
        button2.setOnClickListener(clicker);
        button3.setOnClickListener(clicker);com.mijack.Xlog.logMethodExit("void cn.mijack.demo.MainActivity.onCreate(android.os.Bundle)",this);}catch(Throwable throwable){com.mijack.Xlog.logMethodExitWithThrowable("void cn.mijack.demo.MainActivity.onCreate(android.os.Bundle)",this,throwable);throw throwable;}
    }

}
