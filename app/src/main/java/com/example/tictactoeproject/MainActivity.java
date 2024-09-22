package com.example.tictactoeproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Logic logic = new Logic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void updateBoard(View view) {
        String clicked_id = getResources().getResourceEntryName(view.getId());
        int x = clicked_id.charAt(5) - '0';
        int y = clicked_id.charAt(6) - '0';

        logic.updateBoard(x, y);

        TextView player_display = (TextView) findViewById(R.id.player_display);
        player_display.setText(String.valueOf(logic.getPlayer()));

        ImageView clicked_image= (ImageView) findViewById(view.getId());
        int curr_player = logic.getPlayer();
        if (curr_player == 1) {
            clicked_image.setImageResource(R.drawable.blue_x);
        } else if (curr_player == -1) {
            clicked_image.setImageResource(R.drawable.blue_circle);
        }
    }
}