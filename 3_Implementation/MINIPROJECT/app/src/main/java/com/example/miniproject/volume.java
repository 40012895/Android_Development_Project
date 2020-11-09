package com.example.miniproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class volume extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    TextView textView_ans;
    EditText editText;
    String name;
    double temp;

    String[] country = { "Liter","US liquid pint", "US legel cup", "Mililiter","Imperial gallon","Imperial Quart", "Imperial pint", "Cubic foot"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

        Intent intent = getIntent();

        TextView textView=(TextView)findViewById(R.id.textView2) ;
        editText=(EditText)findViewById(R.id.editText) ;
        textView_ans=(TextView)findViewById(R.id.textview_ans) ;
        TextView textView2=(TextView)findViewById(R.id.textView_length2) ;

        Spinner spin = (Spinner) findViewById(R.id.spinner_volume);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        double val=4.546,te=1.137,la=28.317;
        name =editText.getText().toString();
        try {
            temp=Double.parseDouble(name);
        }catch (NumberFormatException ex) {
            textView_ans.setText("Given String is not parsable to double");
        }

        String selectedClass = parent.getItemAtPosition(position).toString();
        switch (selectedClass)
        {
            case "Liter":
                textView_ans.setText(""+temp);
                break;

            case "US liquid pint":
                textView_ans.setText(""+(temp*2.113));
                break;

            case "US legel cup":
                textView_ans.setText(""+(temp*4.167));
                break;

            case "Mililiter":
                textView_ans.setText(""+temp*1000);
                break;

            case "Imperial gallon":
                textView_ans.setText(""+(temp/val));
                break;

            case "Imperial Quart":
                textView_ans.setText(""+(temp/te));
                break;

            case "Imperial pint":
                textView_ans.setText(""+temp*1.76);
                break;

            case "Cubic foot":
                textView_ans.setText(""+(temp/la));
                break;



            default:
                throw new IllegalStateException("Unexpected value: " + selectedClass);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}