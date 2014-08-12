package com.example.textswitcher;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {
    private TextSwitcher switcher;
    private int curStr;
    private String[] string = new String[] {
            "A",
            "B",
            "C",
            "D"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        switcher = (TextSwitcher)findViewById(R.id.textSwitcher);
        switcher.setFactory(new ViewFactory() {
            
            @Override
            public View makeView() {
                TextView tv = new TextView(MainActivity.this);
                tv.setTextSize(250);
                tv.setTextColor(Color.GREEN);
                return tv;
            }
        });
        
        next(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void next(View view) {
        switcher.setText(string[curStr++ % string.length]);
    }

}
