package com.example.gust_pc.colorcomplimenter.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gust_pc.colorcomplimenter.R;

import org.w3c.dom.Text;

public class ComplimentActivity extends AppCompatActivity {

    private String favoriteColor;
    private TextView responseTextView;
    private String responseText;
    private String temporaryResponseText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compliment);

        Intent intent = getIntent();
        favoriteColor = intent.getStringExtra(getString(R.string.favorite_color_input));


        Log.v("ComplimentActivity","favoriteColor " + favoriteColor);

        if(favoriteColor == null || favoriteColor.isEmpty()){
            favoriteColor = "";
            Toast.makeText(this,"favoriteColor is null or empty",Toast.LENGTH_SHORT).show();
        }

        // Get the text view from the activity_complement xml thru id
        responseTextView = (TextView)findViewById(R.id.response_text);

       // responseText = responseTextView.getText().toString();

        temporaryResponseText = getResources().getString(R.string.response_text);
        responseText = String.format(temporaryResponseText,favoriteColor);

        responseTextView.setText(responseText);
        Log.v("ComplimentActivity",responseText);
//        Toast.makeText(this,responseText,Toast.LENGTH_SHORT).show();
        // Add the favorite_color into the text of it
        // Accesss the string resource and add the text inplace of the placeholders

//        Toast.makeText(this,favoriteColor,Toast.LENGTH_SHORT).show();

    }

}
