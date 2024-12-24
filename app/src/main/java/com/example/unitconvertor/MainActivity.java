package com.example.unitconvertor;

import android.icu.text.ListFormatter;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView Inches;
    Button convert;

    EditText cm;
    String result,formated;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            Inches =findViewById(R.id.Main_Activity_inch);
            convert = findViewById(R.id.Main_Activity_convert);
            cm=findViewById(R.id.Main_Activity_cm);
            Editable centimeter= cm.getText();
            convert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    result=(String.valueOf(Double.parseDouble(centimeter.toString())/2.54));
                  formated= String.format("%.2f",Double.parseDouble(result));
                  Inches.setText(formated +" inch");

                }
            });

            return insets;
        });
    }
}