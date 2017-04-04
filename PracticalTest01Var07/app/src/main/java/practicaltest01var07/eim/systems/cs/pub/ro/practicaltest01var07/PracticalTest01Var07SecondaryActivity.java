package practicaltest01var07.eim.systems.cs.pub.ro.practicaltest01var07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class PracticalTest01Var07SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_secondary);
        Log.d("label", "ceva");

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("allTerms")) {
            String allTerms = intent.getStringExtra("allTerms");
            setResult(4234, null);
        } else {
            setResult(0, null);
        }
    }
}
