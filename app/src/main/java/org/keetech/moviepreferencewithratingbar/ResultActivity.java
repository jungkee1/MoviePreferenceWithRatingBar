package org.keetech.moviepreferencewithratingbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("Vote Result");

        //get the result of vote from previous screen
        Intent intent = getIntent(); //보낼때 만든거를 받는거니깐 new가 필요없음
        final int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        //9 TextView, RatingBar object array
        TextView tv[] = new TextView[imageName.length]; //pic name
        RatingBar rbar[] = new RatingBar[imageName.length]; // rating bar

        //9 TextView, RatingBar ID array
        Integer tvID[] = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9 };
        Integer rbarID[] = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9};

        //9 images
        Integer imageField[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};



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

        ImageView img;
        img = findViewById(R.id.img);
        //int max = 0;
        int max_index =0;
        for(int i=0;i<voteResult.length;i++){

            if(voteResult[i] > voteResult[max_index]) {// 최대값을 구할대는 배열을 돌리면서 좌항과 우항(초기값 0)을 두고 좌 우를 비교해서 좌항이 크다면 새로 받는 값에 좌항을 던져주는 3줄짜리 코드로 완벽하게 커버가능. if에 걸리지 않으면 max는 이전의 값이 그대로 고정이기 때문에 다만 이 문제에서 마지막에 신경쓸 부분은 배열[i] 값을 찾게 아니라 i 값을 찾아야함 그래서 max_index를 따로만들어서 '배열.[i]' 의 값을 받아 낼 때 'i'도 같이받아냄
               // max = voteResult[i];
                max_index = i;
            }
        }
        img.setImageResource(imageField[max_index]);


        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                for(int i=0;i<voteResult.length;i++){
//                    voteResult[i] = 0;
//                }
//                Intent intent1 = new Intent();
//                intent1.putExtra("voteResult", voteResult);
                //여기서 return할때 투표값들을 모두 초기화 시켜서 원상태로 만들려고했는데
                //선생님이 이걸 쉽게 약간 login 순서는 안맞지만 오히려 main에서 넘어올때 화면으로 값 전송하고 거기서
                //바로 초기화를 미리 시켜버렸는데도 문제없이 작동함. 아마도 화면만 띄우는 느낌이라
                // 화면 띄우고 뒤에서는 자기 할 일 열심히 하는듯;

                finish();
            }
        });
    }
}
