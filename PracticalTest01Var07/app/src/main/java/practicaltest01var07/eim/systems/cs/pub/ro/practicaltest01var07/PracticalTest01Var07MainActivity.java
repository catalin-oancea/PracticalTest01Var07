package practicaltest01var07.eim.systems.cs.pub.ro.practicaltest01var07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var07MainActivity extends AppCompatActivity {

    private Button add_btn, compute_btn;
    private EditText next_term, all_terms;
    private String text_all;
    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    class MyButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            switch(v.getId()) {
                //add button
                case R.id.button2:
                    String nt = next_term.getText().toString();
                    int ntint = 0;
                    try {
                        ntint = Integer.parseInt(nt);
                        if (text_all == "") {
                            text_all = String.valueOf(ntint);
                        } else {
                            text_all = text_all + "+" + String.valueOf(ntint);
                        }
                        all_terms.setText(text_all, TextView.BufferType.EDITABLE);
                    } catch (Exception e) {

                    }

                    break;
                //compute button
                case R.id.button3:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var07SecondaryActivity.class);
                    intent.putExtra("allTerms", text_all);
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;


            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);

        text_all = "";
        View.OnClickListener mybtnlistener = new MyButtonListener();

        add_btn = (Button)findViewById(R.id.button2);
        add_btn.setOnClickListener(mybtnlistener);

        compute_btn = (Button)findViewById(R.id.button3);
        compute_btn.setOnClickListener(mybtnlistener);

        next_term = (EditText)findViewById(R.id.editText3);
        all_terms = (EditText)findViewById(R.id.editText5);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("next_value", next_term.getText().toString());
        savedInstanceState.putString("all_values", all_terms.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("next_value")) {
            next_term.setText(savedInstanceState.getString("next_value"));
        }
        if (savedInstanceState.containsKey("all_values")) {
            all_terms.setText(savedInstanceState.getString("all_values"));
        }
    }
}
