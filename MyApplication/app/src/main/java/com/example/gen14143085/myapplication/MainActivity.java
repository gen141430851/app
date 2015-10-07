package com.example.gen14143085.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnTrue;
    private Button btnFalse;
    private TextView lblQuestion;
    private ImageView imgPicture;

    private List<QuestionObject> questions;

    private QuestionObject currentQuestion;
    private int index;
    private int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTrue = (Button)findViewById(R.id.btnTrue);
        btnFalse = (Button)findViewById(R.id.btnFalse);
        lblQuestion = (TextView)findViewById(R.id.lblQuestion);
        imgPicture = (ImageView)findViewById(R.id.imgPicture);

        lblQuestion.setText("Is London the capital of England?");
        imgPicture.setImageResource(R.drawable.englandflag);

        index = 0;
        score = 0;

        //onclick listeners
        btnFalse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                determineButtonPress(false);
            }
        });

        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                determineButtonPress(true);
            }
        });
    }
    generateQuestions();
    setUpQuestion();
    }

   private void generateQuestions(){

       questions = new ArrayList<>();

       questions.add(new QuestionObject("Is the capital of France Paris?", true, R.drawable.franceflag));
       questions.add(new QuestionObject("Is the capital of Egypt Giza?", false, R.drawable.egyptflag));
       questions.add(new QuestionObject("Is the capital of Czech Republic Prague?", true, R.drawable.czechflag));
       questions.add(new QuestionObject("Is the capital of Argentina Córdoba?", false, R.drawable.argentinaflag));
       questions.add(new QuestionObject("Is the capital of Liechtenstein Vaduz?", true, R.drawable.liechtensteinflag));
       questions.add(new QuestionObject("Is the capital of Iceland Reykjavík?", true, R.drawable.icelandflag));
       questions.add(new QuestionObject("Is the capital of Indonesia Jakarta?", true, R.drawable.indonesiaflag));
       questions.add(new QuestionObject("Is the capital of Cameroon Douala?", false, R.drawable.cameroonflag));
       questions.add(new QuestionObject("Is the capital of Uzbekistan Tashkent?", true, R.drawable.uzbekistanflag));


    }

    private void setUpQuestion(){

        if (index == questions.size()) {
            Log.d("DANIELLE_APP", "ended all the questions");
        }

        else {
            currentQuestion = questions.get(index);

            lblQuestion.setText(currentQuestion.getQuestion());
            imgPicture.setImageResource(currentQuestion.getPicture());

            index++;
        }
    }


    private void determineButtonPress(boolean answer){
        boolean expectedAnswer = currentQuestion.isAnswer();

        if (answer == expectedAnswer){
            Toast.makeText(MainActivity.this, "Correct!!", Toast.LENGTH_SHORT).show();
            score++;
        }

        else {
            Toast.makeText(MainActivity.this, "Wrong!!", Toast.LENGTH_SHORT).show()
        }

        setUpQuestion();
    }















    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
