package space.pandawithflowers.exercises.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import space.pandawithflowers.exercises.CustomArrayAdapter;
import space.pandawithflowers.exercises.ListItemClass;
import space.pandawithflowers.exercises.R;
import space.pandawithflowers.exercises.Settings;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ListView listView;
    private String[] headline, desc;
    private CustomArrayAdapter arrayAdapter;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private int category;
    private int[] exerciseNeckPic = new int[]{R.drawable.exercise1_neck, R.drawable.exercise2_neck, R.drawable.exercise3_neck, R.drawable.exercise4_neck, R.drawable.exercise5_neck, R.drawable.exercise6_neck};
    private int[] exerciseBackPic = new int[]{R.drawable.exercise1_back, R.drawable.exercise2_back, R.drawable.exercise3_back, R.drawable.exercise4_back, R.drawable.exercise5_back, R.drawable.exercise6_back, R.drawable.exercise7_back, R.drawable.exercise8_back, R.drawable.exercise9_back};
    private int[] exercisesHandsPic = new int[]{R.drawable.exercise1_hands, R.drawable.exercise2_hands, R.drawable.exercise3_hands, R.drawable.exercise4_hands,};
    private int[] exercisesPressPic = new int[]{R.drawable.exercise1_press, R.drawable.exercise2_press, R.drawable.exercise3_press, R.drawable.exercise4_press, R.drawable.exercise5_press, R.drawable.exercise6_press, R.drawable.exercise7_press};
    private int[] exercisesHipsPic = new int[]{R.drawable.exercise1_hips, R.drawable.exercise2_hips, R.drawable.exercise3_hips, R.drawable.exercise4_hips, R.drawable.exercise5_hips, R.drawable.exercise6_hips, R.drawable.exercise7_hips};
    private int[] exercisesLegsPic = new int[]{R.drawable.exercise1_legs, R.drawable.exercise2_legs, R.drawable.exercise3_legs, R.drawable.exercise4_legs, R.drawable.exercise5_legs, R.drawable.exercise6_legs};
    private List<ListItemClass> listItemMain = new ArrayList<>();
    private ListItemClass listItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.menu_neck);
        listView = findViewById(R.id.listView);
        headline = getResources().getStringArray(R.array.neck_exercises_array);
        desc = getResources().getStringArray(R.array.neck_exercises_array2);
        for (int i = 0; i < headline.length; i++) {
            listItem = new ListItemClass();
            listItem.setHeadline(headline[i]);
            listItem.setDesc(desc[i]);
            listItem.setPic(exerciseNeckPic[i]);
            listItemMain.add(listItem);
        }
        arrayAdapter = new CustomArrayAdapter(this, R.layout.list_view_item, listItemMain, getLayoutInflater());
        listView.setAdapter(arrayAdapter);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, TextContent.class);
                intent.putExtra("category", category);
                intent.putExtra("position", i);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.menu_neck) {
            headline = getResources().getStringArray(R.array.neck_exercises_array);
            desc = getResources().getStringArray(R.array.neck_exercises_array2);
            fillArray(R.string.menu_neck, headline, desc, exerciseNeckPic, 0);
        } else if (id == R.id.menu_back) {
            headline = getResources().getStringArray(R.array.back_exercises_array);
            desc = getResources().getStringArray(R.array.back_exercises_array2);
            fillArray(R.string.menu_back, headline, desc, exerciseBackPic, 1);

        } else if (id == R.id.menu_hands) {
            headline = getResources().getStringArray(R.array.hands_exercises_array);
            desc = getResources().getStringArray(R.array.hands_exercises_array2);
            fillArray(R.string.menu_hands, headline, desc, exercisesHandsPic, 2);

        } else if (id == R.id.menu_press) {
            headline = getResources().getStringArray(R.array.press_exercises_array);
            desc = getResources().getStringArray(R.array.press_exercises_array2);
            fillArray(R.string.menu_press, headline, desc, exercisesPressPic, 3);

        } else if (id == R.id.menu_hips) {
            headline = getResources().getStringArray(R.array.hips_exercises_array);
            desc = getResources().getStringArray(R.array.hips_exercises_array2);
            fillArray(R.string.menu_hips, headline, desc, exercisesHipsPic, 4);

        } else if (id == R.id.menu_legs) {
            headline = getResources().getStringArray(R.array.back_exercises_array);
            desc = getResources().getStringArray(R.array.back_exercises_array2);
            fillArray(R.string.menu_legs, headline, desc, exercisesLegsPic, 5);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void fillArray(int title, String[] nameArray, String[] descArray, int[] picArray, int index) {
        if (arrayAdapter != null) {
            arrayAdapter.clear();
        }
        for (int i = 0; i < nameArray.length; i++) {
            listItem = new ListItemClass();
            listItem.setHeadline(nameArray[i]);
            listItem.setDesc(descArray[i]);
            listItem.setPic(picArray[i]);
            listItemMain.add(listItem);
        }
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
        category = index;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, Settings.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}