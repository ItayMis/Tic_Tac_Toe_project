package com.example.tictactoeproject;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements Iview{

    private Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(this);
        displayMessage(presenter.getTurnMsg());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void updateBoard(View view) {
        if(presenter.isGameOver()){
            return;
        }
        String clicked_id = getResources().getResourceEntryName(view.getId());
        int x = clicked_id.charAt(5) - '0';
        int y = clicked_id.charAt(6) - '0';
        displayMessage(presenter.getTurnMsg());
        String image_name = presenter.userMove(x,y);

        ImageView clicked_image = findViewById(view.getId());
        int imageResId = getResources().getIdentifier(image_name, "drawable", getPackageName());
        clicked_image.setImageResource(imageResId);
        clicked_image.setClickable(false);
        if(presenter.isGameOver()){
            displayMessage(presenter.getWinMsg());
        }




    }

    public void restartGame(View view) {
        presenter.resetGame();

        ViewGroup parentLayout = findViewById(R.id.tableLayout);
        for (int i = 0; i < parentLayout.getChildCount(); i++) {
            View child = parentLayout.getChildAt(i);
            if (child instanceof ImageView) {
                ImageView imageView = (ImageView) child;
                imageView.setImageResource(R.drawable.square);
                //imageView.setOnClickListener(this); // Re-enable click listener
            }
        }


        displayMessage("New Game Started\n" + presenter.getTurnMsg());
    }

    @Override
    public void updateBoard(int x, int y) {

    }

    @Override
    public void displayMessage(String msg) {
        TextView player_display = findViewById(R.id.player_display);
        player_display.setText(msg);
    }
}