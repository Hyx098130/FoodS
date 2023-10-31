package com.example.fooddiary;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.res.AssetManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String foodName = editText.getText().toString();
                searchFood(foodName);
            }
        });
    }

    private void searchFood(String foodName) {
        List<Food> foods = loadFoodData();
        for (Food food : foods) {
            if (food.getName().equals(foodName)) {
                String text = "名称：" + food.getName() + "\n" +
                        "热量：" + food.getCalories() + " kcal\n" +
                        "蛋白质：" + food.getProtein() + " g\n" +
                        "脂肪：" + food.getFat() + " g\n" +
                        "碳水化合物：" + food.getCarbohydrates() + " g";
                textView.setText(text);
                return;
            }
        }
        textView.setText("未找到相关食物");
    }

    private List<Food> loadFoodData() {
        AssetManager assetManager = getAssets();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(assetManager.open("food
