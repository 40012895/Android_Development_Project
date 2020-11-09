package com.lnt.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class lenght extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    TextView textView_ans;
    EditText editText;
    String name;
    double temp;

    String[] country = { "Meter", "Kilometer", "Inch", "Foot", "Mile"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lenght);
        Intent intent = getIntent();

        TextView textView=(TextView)findViewById(R.id.textView2) ;
        editText=(EditText)findViewById(R.id.editText) ;
        textView_ans=(TextView)findViewById(R.id.textview_ans) ;
        TextView textView2=(TextView)findViewById(R.id.textView_length2) ;

        Spinner spin = (Spinner) findViewById(R.id.spinner_length);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

       name =editText.getText().toString();
       try {
           temp=Double.parseDouble(name);
       }catch (NumberFormatException ex) {
           textView_ans.setText("Given String is not parsable to double");
       }

        String selectedClass = parent.getItemAtPosition(position).toString();
        switch (selectedClass)
        {
            case "Meter":
               textView_ans.setText(""+temp*0.001);
                break;

            case "Kilometer":
                textView_ans.setText(""+temp*1e-06);
                break;

            case "Inch":
                textView_ans.setText(""+temp*0.0393700787402);
                break;

            case "Foot":
                textView_ans.setText(""+temp*0.00328083989501);
                break;

            case "Mile":
                textView_ans.setText(""+temp*6.2137273665e-07);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + selectedClass);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}