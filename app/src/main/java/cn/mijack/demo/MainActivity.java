package cn.mijack.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mijack.IStatable;

import java.lang.reflect.Member;
import java.lang.reflect.Method;

import cn.Clicker;
import cn.XlogStater;

/**
 * @author Mi&Jack
 */
public class MainActivity extends Activity implements IStatable {
    StringBuilder state = new StringBuilder();
    private Button button;
    private Button button2;
    private Button button3;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        result = findViewById(R.id.result);
        Clicker clicker = new Clicker(state, result);
        button.setOnClickListener(clicker);
        button2.setOnClickListener(clicker);
        button3.setOnClickListener(clicker);
    }

    @Override
    public String getState() {
        return state.toString();
    }
}
