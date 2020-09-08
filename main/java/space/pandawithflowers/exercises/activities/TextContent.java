package space.pandawithflowers.exercises.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import space.pandawithflowers.exercises.R;

public class TextContent extends AppCompatActivity {
    private int category = 0;
    private int position = 0;
    private Typeface typeface;
    private int[] arrayExercisesNeck = {R.string.exercise1_neck, R.string.exercise2_neck, R.string.exercise3_neck, R.string.exercise4_neck, R.string.exercise5_neck, R.string.exercise6_neck};
    private int[] arrayExercisesNeckImage = {R.drawable.exercise1_neck, R.drawable.exercise2_neck, R.drawable.exercise3_neck, R.drawable.exercise4_neck, R.drawable.exercise5_neck, R.drawable.exercise6_neck};
    private String[] arrayExercisesNeckTitle = {"Растяжка шеи", "Повороты шеи", "Наклоны в стороны", "Наклоны вперёд", "Наклоны назад", "Круговые вращения"};
    private int[] arrayExercisesBack = {R.string.exercise1_back, R.string.exercise2_back, R.string.exercise3_back, R.string.exercise4_back, R.string.exercise5_back, R.string.exercise6_back, R.string.exercise7_back, R.string.exercise8_back, R.string.exercise9_back};
    private int[] arrayExercisesBackImage = {R.drawable.exercise1_back, R.drawable.exercise2_back, R.drawable.exercise3_back, R.drawable.exercise4_back, R.drawable.exercise5_back, R.drawable.exercise6_back, R.drawable.exercise7_back, R.drawable.exercise8_back, R.drawable.exercise9_back};
    private String[] arrayExercisesBackTitle = {"Низкий выпад", "Наклон с руками за спиной", "Опора на стену", "Подъём рук и ног в положении стола", "Захват ноги в положении стола", "Скручивание в положении стола", "Собака мордой вниз", "Поза верблюда", "Поза перевёрнутого стола"};
    private int[] arrayExercisesHands = {R.string.exercise1_hands, R.string.exercise2_hands, R.string.exercise3_hands, R.string.exercise4_hands};
    private int[] arrayExercisesHandsImage = {R.drawable.exercise1_hands, R.drawable.exercise2_hands, R.drawable.exercise3_hands, R.drawable.exercise4_hands, };
    private String[] arrayExercisesHandsTitle = {"Отжимания", "Джампинг Джек", "Сжимание мячика ладонями", "Планка" };
    private int[] arrayExercisesPress = {R.string.exercise1_press, R.string.exercise2_press, R.string.exercise3_press, R.string.exercise4_press, R.string.exercise5_press, R.string.exercise6_press, R.string.exercise7_press };
    private int[] arrayExercisesPressImage = {R.drawable.exercise1_press, R.drawable.exercise2_press, R.drawable.exercise3_press, R.drawable.exercise4_press, R.drawable.exercise5_press, R.drawable.exercise6_press, R.drawable.exercise7_press};
    private String[] arrayExercisesPressTitle = {"Складка к ногам", "Ножницы", "Скручивания лягушкой", "Велосипед", "Обратные скручивания", "Подъём рук к ногам", "Медленный подъём ног"};
   private int[] arrayExercisesHips = {R.string.exercise1_hips, R.string.exercise2_hips, R.string.exercise3_hips, R.string.exercise4_hips, R.string.exercise5_hips, R.string.exercise6_hips, R.string.exercise7_hips };
    private int[] arrayExercisesHipsImage = {R.drawable.exercise1_hips, R.drawable.exercise2_hips, R.drawable.exercise3_hips, R.drawable.exercise4_hips, R.drawable.exercise5_hips, R.drawable.exercise6_hips, R.drawable.exercise7_hips};
    private String[] arrayExercisesHipsTitle = {"Приседания", "Приседания с упором сзади", "Выпады", "Махи", "Махи из положения лежа", "Поднимание ягодиц из положения лежа", "Ножницы с согнутыми коленями"};
   private int[] arrayExercisesLegs = {R.string.exercise1_legs, R.string.exercise2_legs, R.string.exercise3_legs, R.string.exercise4_legs, R.string.exercise5_legs, R.string.exercise6_legs };
    private int[] arrayExercisesLegsImage = {R.drawable.exercise1_legs, R.drawable.exercise2_legs, R.drawable.exercise3_legs, R.drawable.exercise4_legs, R.drawable.exercise5_legs, R.drawable.exercise6_legs};
    private String[] arrayExercisesLegsTitle = {"Воздушные приседания", "Приседания с весом", "Ягодичный мостик", "Взрывные прыжки вверх", "Зашагивания на тумбу", "Стульчик у стены"};
    private TextView textContent;
    private ImageView imageView;
    private ActionBar actionBar;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        init();
        receiveIntent();
        chooseCategory();
    }

    private void receiveIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            category = intent.getIntExtra("category", 0);
            position = intent.getIntExtra("position", 0);
        }
    }


    private void chooseCategory() {
        switch (category) {
            case 0:
                textContent.setText(arrayExercisesNeck[position]);
                imageView.setImageResource(arrayExercisesNeckImage[position]);
                actionBar.setTitle(arrayExercisesNeckTitle[position]);
                break;
            case 1:
                textContent.setText(arrayExercisesBack[position]);
                imageView.setImageResource(arrayExercisesBackImage[position]);
                actionBar.setTitle(arrayExercisesBackTitle[position]);
                break;
            case 2:
                textContent.setText(arrayExercisesHands[position]);
                imageView.setImageResource(arrayExercisesHandsImage[position]);
                actionBar.setTitle(arrayExercisesHandsTitle[position]);
                break;
            case 3:
                textContent.setText(arrayExercisesPress[position]);
                imageView.setImageResource(arrayExercisesPressImage[position]);
                actionBar.setTitle(arrayExercisesPressTitle[position]);
                break;
            case 4:
                textContent.setText(arrayExercisesHips[position]);
                imageView.setImageResource(arrayExercisesHipsImage[position]);
                actionBar.setTitle(arrayExercisesHipsTitle[position]);
                break;
            case 5:
                textContent.setText(arrayExercisesLegs[position]);
                imageView.setImageResource(arrayExercisesLegsImage[position]);
                actionBar.setTitle(arrayExercisesLegsTitle[position]);
                break;
        }
    }

    private void init() {
        textContent = findViewById(R.id.text_description);
        imageView = findViewById(R.id.imageDescription);
        typeface = Typeface.createFromAsset(this.getAssets(), "fonts/Pangolin-Regular.ttf");
        textContent.setTypeface(typeface);
        actionBar = getSupportActionBar();
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        String textSize = pref.getString("text_size", "Средний шрифт");
        if (textSize != null) {
            switch (textSize) {
                case "Крупный шрифт":
                    textContent.setTextSize(24);
                    break;
                case "Средний шрифт":
                    textContent.setTextSize(20);
                    break;
                case "Мелкий шрифт":
                    textContent.setTextSize(16);
                    break;
            }
        }
    }
}
