package example.com.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        checkBox = (CheckBox) findViewById(R.id.checkBox);

    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(MainActivity.this, "onPauseMethod", Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPreferences = getPreferences(0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("CHECKBOX_VALUE", checkBox.isChecked());
        editor.apply();

    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(MainActivity.this, "onResumeMethod", Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPreferences = getPreferences(0);
        Boolean checked = sharedPreferences.getBoolean("CHECKBOX_VALUE", false);
        checkBox.setChecked(checked);
    }
}
