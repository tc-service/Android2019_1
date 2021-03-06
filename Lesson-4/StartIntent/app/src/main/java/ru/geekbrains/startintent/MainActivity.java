package ru.geekbrains.startintent;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private final static String TEXT = "PARAM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText text = findViewById(R.id.editText);
        Button runEcho = findViewById(R.id.button);
        runEcho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uriStr = String.format("example://intent/%s", text.getText().toString());
                Uri uri = Uri.parse(uriStr);
                Intent runEchoIntent = new Intent(Intent.ACTION_VIEW, uri);
                ActivityInfo activityInfo =
                        runEchoIntent.resolveActivityInfo(getPackageManager(),
                                runEchoIntent.getFlags());
                if (activityInfo != null) {
                    startActivity(runEchoIntent);
                }
            }
        });
    }
}
