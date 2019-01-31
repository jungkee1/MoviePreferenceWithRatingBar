package org.keetech.moviepreferencewithratingbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("Vote Result");

        //get the result of vote from previous screen
        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        //9 TextView, RatingBar object array
        TextView tv[] = new TextView[imageName.length]; //pic name
        RatingBar rbar[] = new RatingBar[imageName.length]; // rating bar

        //9 TextView, RatingBar ID array
        Integer tvID[] = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9 };
        Integer rbarID[] = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9};

        //TextView, find RatingBar.
        for (int i=0;i<voteResult.length;i++){
            tv[i] = findViewById(tvID[i]);
            rbar[i] = findViewById(rbarID[i]);
        }

        // put sent parameter into each TextView and RatingBar
        for(int i=0;i<voteResult.length;i++){
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float) voteResult[i]);
        }

        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
