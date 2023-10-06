package com.stu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnGo;
    TextView lblCreate, lblResume, lblStart, lblReStart;

    int start, restart, create, resume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent lastIntent = getIntent();

        create = lastIntent.getIntExtra("create", 0);
        resume = lastIntent.getIntExtra("resume", 0);
        start = lastIntent.getIntExtra("start", 0);
        restart = lastIntent.getIntExtra("restart", 0);
        int upCreate = create + 1;

        lastIntent.putExtra("create", upCreate);

        btnGo = findViewById(R.id.button);
        lblCreate = findViewById(R.id.r1);
        lblResume = findViewById(R.id.r2);
        lblStart = findViewById(R.id.r3);
        lblReStart = findViewById(R.id.r4);

        lblCreate.setText(String.valueOf(upCreate));
        lblResume.setText(String.valueOf(resume));
        lblStart.setText(String.valueOf(start));
        lblReStart.setText(String.valueOf(restart));

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
                myIntent.putExtra("create", upCreate);
                myIntent.putExtra("resume", resume);
                myIntent.putExtra("start", start);
                myIntent.putExtra("restart", restart);
                startActivity(myIntent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        start = start + 1;
        lblStart.setText(String.valueOf(start));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        restart = restart + 1;
        lblReStart.setText(String.valueOf(restart));
    }

    @Override
    protected void onResume() {
        super.onResume();
        resume = resume + 1;
        lblResume.setText(String.valueOf(resume));
    }
}