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

public class weight extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    TextView textView_ans;
    EditText editText;
    String name;
    double temp;

    String[] country = { "Miles per Hour", "Foot per Second", "Meter per second","KM per hour","Knot"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);


        Intent intent = getIntent();

        TextView textView=(TextView)findViewById(R.id.textView2) ;
        editText=(EditText)findViewById(R.id.editText) ;
        textView_ans=(TextView)findViewById(R.id.textview_ans) ;
        TextView textView2=(TextView)findViewById(R.id.textView_length2) ;

        Spinner spin = (Spinner) findViewById(R.id.spinner_speed);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        double val=2.237,kn=1.151;
        name =editText.getText().toString();
        try {
            temp=Double.parseDouble(name);
        }catch (NumberFormatException ex) {
            textView_ans.setText("Given String is not parsable to double");
        }

        String selectedClass = parent.getItemAtPosition(position).toString();
        switch (selectedClass)
        {
            case "Miles per Hour":
                textView_ans.setText(""+temp);
                break;

            case "Foot per Second":
                textView_ans.setText(""+(temp*1.467));
                break;

            case "Meter per second":
                textView_ans.setText(""+(temp/val));
                break;

            case "KM per hour":
                textView_ans.setText(""+(temp*1.609));
                break;

            case "Knot":
                textView_ans.setText(""+(temp/kn));
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + selectedClass);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}