package com.general5.drawingapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;


public class MainActivity extends ActionBarActivity {
    private DrawingView drawingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        this.drawingView = (DrawingView)findViewById(R.id.drawing_view);

        findViewById(R.id.delete_button).setOnClickListener(deleteDrawing);
    }

    View.OnClickListener deleteDrawing = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            drawingView.delete();
        }
    };
}
