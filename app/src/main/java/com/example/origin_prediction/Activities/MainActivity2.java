package com.example.origin_prediction.Activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.example.origin_prediction.Pojo.Car;
import com.example.origin_prediction.Algorithms.*;
import com.example.origin_prediction.R;


import java.util.List;


public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button myButton = findViewById(R.id.Button);


        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.RadioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RelativeLayout radio = findViewById(R.id.Kinput);
                View knn = findViewById(R.id.knn);
                View dt = findViewById(R.id.dt);

                ViewGroup.MarginLayoutParams KnnParams = (ViewGroup.MarginLayoutParams) knn.getLayoutParams();
                ViewGroup.MarginLayoutParams DtParams = (ViewGroup.MarginLayoutParams) dt.getLayoutParams();

                if(checkedId==R.id.knn){
                    DtParams.topMargin = (int) (90 *  getResources().getDisplayMetrics().density);
                    dt.setLayoutParams(DtParams);

                    KnnParams.topMargin = (int) (250 *  getResources().getDisplayMetrics().density);
                    knn.setLayoutParams(KnnParams);
                    radio.setVisibility(View.VISIBLE);
                }else{
                    DtParams.topMargin = (int) (20 *  getResources().getDisplayMetrics().density);
                    dt.setLayoutParams(DtParams);

                    KnnParams.topMargin = (int) (300 *  getResources().getDisplayMetrics().density);
                    knn.setLayoutParams(KnnParams);
                    radio.setVisibility(View.GONE);
                }
            }
        });


        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                List<Car> cars = Car.getCars(v.getContext());
                System.out.println(cars);
                Intent intent = getIntent();
                Car car = (Car) intent.getSerializableExtra("car");

                RadioGroup radioGroup = findViewById(R.id.RadioGroup);
                int selectedRadio = radioGroup.getCheckedRadioButtonId();

                if(radioGroup.getCheckedRadioButtonId()!=-1){
                    String origin = "";

                    if (selectedRadio==R.id.knn) {
                        try{
                            EditText editText = findViewById(R.id.editText4);
                            int k = Integer.parseInt(editText.getText().toString());
                            origin = Knn.predict(cars, car, k);
                        }catch (NumberFormatException e){
                            Toast.makeText(getApplicationContext(), "Please enter a valid number in the field", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    } else if (selectedRadio==R.id.bayes) {
                        origin = Bayes.predict(cars, car);
                    } else {
                        origin = DT.predict(car);
                    }
                    Intent intent2 = new Intent(MainActivity2.this, MainActivity3.class);
                    intent2.putExtra("origin", origin);
                    startActivity(intent2);

                }else{
                    Toast.makeText(getApplicationContext(), "Please select a ML algorithm", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
