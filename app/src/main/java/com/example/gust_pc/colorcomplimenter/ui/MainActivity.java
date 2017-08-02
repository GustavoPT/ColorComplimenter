package com.example.gust_pc.colorcomplimenter.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gust_pc.colorcomplimenter.R;

public class MainActivity extends AppCompatActivity {

    private EditText favoriteColorField;
    private Button favoriteColorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        favoriteColorField = (EditText)findViewById(R.id.favoriteColorField);
        favoriteColorButton = (Button) findViewById(R.id.favoriteColorButton);

        favoriteColorButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String favoriteColor = favoriteColorField.getText().toString();
                goToCompliment(favoriteColor);
//                Toast.makeText(MainActivity.this,favoriteColor,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goToCompliment(String favoriteColor) {

        Intent intent = new Intent(this,ComplimentActivity.class);
        Resources resources = getResources();
        String main_field_name = resources.getString(R.string.favorite_color_input);
        intent.putExtra(main_field_name,favoriteColor);
        startActivity(intent);

    }
}
