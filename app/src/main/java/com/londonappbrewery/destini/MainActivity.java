package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mUpButton;
    Button mDownButton;
    int mIndex;

    QueAns[] storyBank = {
            new QueAns(R.string.T1_Story,R.string.T1_Ans1,R.string.T1_Ans2),
            new QueAns(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2),
            new QueAns(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2),
            new QueAns(R.string.T4_End),
            new QueAns(R.string.T5_End),
            new QueAns(R.string.T6_End)

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mUpButton = (Button) findViewById(R.id.buttonTop);
        mDownButton = (Button) findViewById(R.id.buttonBottom);

        if (savedInstanceState != null){
            mIndex = savedInstanceState.getInt("IndexKey");
            switch (mIndex){
                case 0:
                case 1:
                case 2:
                    updateQuestion(mIndex);
                    break;
                default:endQuestion(mIndex);
            }
        }
        else{
            mIndex =0;
        }



        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index =storyBank[mIndex].getUpText();
                if (index == R.string.T1_Ans1){
                    mIndex =2;
                    updateQuestion(mIndex);
                }else if (index == R.string.T3_Ans1){
                    mIndex=5;
                    endQuestion(mIndex);
                }else if (index == R.string.T2_Ans1){
                    mIndex =2;
                    updateQuestion(mIndex);

                }


            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index =storyBank[mIndex].getDownText();
                if (index == R.string.T1_Ans2){
                    mIndex =1;
                    updateQuestion(mIndex);
                }else if (index == R.string.T2_Ans2){
                    mIndex = 3;
                    endQuestion(mIndex);
                }else if (index == R.string.T3_Ans2){
                    mIndex = 4;
                    endQuestion(mIndex);

                }

            }
        });


    }
    private void updateQuestion(int index){
        mStoryTextView.setText(storyBank[index].getQuestion());
        mUpButton.setText(storyBank[index].getUpText());
        mDownButton.setText(storyBank[index].getDownText());

    }
    private void endQuestion(int index){
        mStoryTextView.setText(storyBank[index].getQuestion());
        mUpButton.setVisibility(GONE);
        mDownButton.setVisibility(GONE);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("IndexKey",mIndex);
        super.onSaveInstanceState(outState);
    }
}
