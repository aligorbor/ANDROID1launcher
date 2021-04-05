package ru.geekbrains.android1.calclauncher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String CALC_STRING = "CALC_STRING";
    private static final String URI_STRING = "calculator://intent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText text = findViewById(R.id.editText);
        Button runEcho = findViewById(R.id.button);
        runEcho.setOnClickListener(v -> {
            Uri uri = Uri.parse(URI_STRING);
            Intent runCalculatorIntent = new Intent(Intent.ACTION_VIEW, uri);
            runCalculatorIntent.putExtra(CALC_STRING, text.getText().toString());
            ActivityInfo activityInfo = runCalculatorIntent.resolveActivityInfo(getPackageManager(),
                    runCalculatorIntent.getFlags());
            if (activityInfo != null) {
                startActivity(runCalculatorIntent);
            }
        });

    }
}