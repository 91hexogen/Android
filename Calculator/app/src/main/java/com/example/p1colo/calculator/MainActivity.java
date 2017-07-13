package com.example.p1colo.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

class CalculatorActivity extends Activity {

    private TextView TextView;
    private StringBuilder mMathString;
    private ButtonClickListener mClickListener;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the math string
        mMathString = new StringBuilder();

        // Enable javascript for the view
        TextView = (TextView) findViewById(R.id.textview);
        //TextView.getSettings().setJavaScriptEnabled(true);

        // Set the listener for all the buttons
        mClickListener = new ButtonClickListener();
        int idList[] = {R.id.button0, R.id.button1, R.id.button2,
                R.id.button3, R.id.button4, R.id.button5, R.id.button6,
                R.id.button7, R.id.button8, R.id.button9, R.id.buttonLeftParen,
                R.id.buttonRightParen, R.id.buttonPlus, R.id.buttonPlus,
                R.id.buttonMinus, R.id.buttonDivide, R.id.buttonTimes,
                R.id.buttonDecimal, R.id.buttonBackspace, R.id.buttonClear};

        for (int id : idList) {
            View v = findViewById(id);
            v.setOnClickListener(mClickListener);
        }

    }

    private class ButtonClickListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonBackspace:
                    if (mMathString.length() > 0)
                        mMathString.deleteCharAt(mMathString.length() - 1);
                    break;
                case R.id.buttonClear:
                    if (mMathString.length() > 0)
                        mMathString.delete(0, mMathString.length());
                    break;
                default:
                    mMathString.append(((Button) v).getText());
            }
        }
    }
}


