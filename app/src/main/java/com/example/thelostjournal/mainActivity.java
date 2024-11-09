package com.example.thelostjournal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.yourname.thelostjournal.R;


public class mainActivity extends AppCompatActivity {

    private TextView storyText;
    private Button choice1, choice2;
    private int currentScene = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storyText = findViewById(R.id.storyText);
        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);

        loadScene();

        choice1.setOnClickListener(v -> makeChoice(1));

        choice2.setOnClickListener(v -> makeChoice(2));
    }

    private void loadScene() {
        switch (currentScene) {
            case 1:
                storyText.setText("You open the journal and flip to the first page. The writing is faded but legible, describing a hidden path that leads to an old church.");
                choice1.setText("Go to the church");
                choice2.setText("Continue reading the journal");
                break;
            case 2:
                storyText.setText("The church is quiet and empty. You find a scrap of paper with a note: ‘Ask the bartender about the night she vanished.’");
                choice1.setText("Visit the bartender");
                choice2.setText("Ignore the note and keep exploring");
                break;
            case 3:
                storyText.setText("The next entry mentions a bar downtown. It says, ‘The bartender knows something.’");
                choice1.setText("Visit the bartender");
                choice2.setText("Skip to the last journal entry");
                break;
            case 4:
                storyText.setText("The bartender seems uneasy when you ask about the missing person. She hands you a map and whispers, ‘Follow the trail beyond the old graveyard.’");
                choice1.setText("Follow the trail");
                choice2.setText("Ignore her warning and leave");
                break;
            case 5:
                storyText.setText("You reach the end of the trail and find the missing person’s belongings. The case is solved!");
                choice1.setText("Play Again");
                choice2.setVisibility(View.GONE);
                break;
            case 6:
                storyText.setText("You decide it’s too risky and leave. The case remains unsolved.");
                choice1.setText("Play Again");
                choice2.setVisibility(View.GONE);
                break;
        }
    }

    private void makeChoice(int choice) {
        if (currentScene == 1) {
            currentScene = (choice == 1) ? 2 : 3;
        } else if (currentScene == 2 || currentScene == 3) {
            currentScene = (choice == 1) ? 4 : 6;
        } else if (currentScene == 4) {
            currentScene = (choice == 1) ? 5 : 6;
        } else {
            currentScene = 1;
            choice2.setVisibility(View.VISIBLE);
        }
        loadScene();
    }
}
