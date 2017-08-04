package com.example.gust_pc.colorcomplimenter.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
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
    private View mlayout;
    private String[] compliments = new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        compliments[0] = "depth and stability";
        compliments[1] = "renewal and energy";
        compliments[2] = "hope happiness and positivity";
        compliments[3] = "energy war danger strength and power";
        compliments[4] = "Hm,We don't know that color";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compliment);
        // find the layout view
        mlayout= findViewById(R.id.constraint_layout);

        Intent intent = getIntent();
        // get favorite_color_input
        favoriteColor = intent.getStringExtra(getString(R.string.favorite_color_input));

        Log.v("ComplimentActivity","favoriteColor " + favoriteColor);

        if(favoriteColor == null || favoriteColor.isEmpty()){
            favoriteColor = "";
            Toast.makeText(this,"favoriteColor is null or empty",Toast.LENGTH_SHORT).show();
        }

        // Make favorite color into lowercase
        favoriteColor = favoriteColor.toLowerCase();

        // Switch statement depending on the user input of color
        switch(favoriteColor){

            case ("blue"):
                mlayout.setBackgroundResource(R.drawable.blue);
//                mlayout.setBackgroundColor(Color.BLUE);
                setResponseText(favoriteColor,compliments[0]);
                break;
            case ("green"):
                 mlayout.setBackgroundResource(R.drawable.green);
//                mlayout.setBackgroundColor(Color.GREEN);
                setResponseText(favoriteColor,compliments[1]);
                break;
            case ("yellow"):
                mlayout.setBackgroundResource(R.drawable.yellow);
//                mlayout.setBackgroundColor(Color.GREEN);
                setResponseText(favoriteColor,compliments[2]);
                break;
            case ("red"):
                mlayout.setBackgroundResource(R.drawable.red);
//                mlayout.setBackgroundColor(Color.RED);
                setResponseText(favoriteColor,compliments[3]);
                break;
            default:
                mlayout.setBackgroundColor(Color.WHITE);
                setResponseText("white",compliments[4]);
                break;
        }

    }

    public void setResponseText(String favoriteColor, String compliment){



        // Get the text view from the activity_complement xml thru id
        responseTextView = (TextView)findViewById(R.id.response_text);
        // responseText = responseTextView.getText().toString();
        temporaryResponseText = getResources().getString(R.string.response_text);
        // format the string / replace the 1$s
        responseText = String.format(temporaryResponseText,favoriteColor,compliment);



        // If the color is white
        if(favoriteColor == "white"){
            responseTextView.setTextColor(Color.BLACK);
            responseText = compliment;
        }


        // set the text from response text
        responseTextView.setText(responseText);

    }

}
