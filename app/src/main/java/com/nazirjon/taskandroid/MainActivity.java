package com.nazirjon.taskandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.nazirjon.taskandroid.adapter.BunAdapter;
import com.nazirjon.taskandroid.model.Bun;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random rand;
    final int max = 100;
    final int min = 10;
    int count_rand, count_for_new;
    double price_rand;
    ArrayList<Bun> buns1 = new ArrayList<Bun>();
    ArrayList<Bun> buns2 = new ArrayList<Bun>();
    ArrayList<Bun> buns3 = new ArrayList<Bun>();

    Long minutesAgo = new Long(60);
    Long minutesNew = new Long(60);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rand = new Random();
        price_rand = rand.nextInt(max- min + 1) + min;
        count_rand = rand.nextInt(max- min + 1) + min;

        count_for_new = rand.nextInt(min- 1 + 1) + 1;

        // начальная инициализация списка
        setInitialData1();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // создаем адаптер
        BunAdapter bunAdapter = new BunAdapter(this, buns1);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(bunAdapter);

        setInitialData2();
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recycler2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        // создаем адаптер
        BunAdapter bunAdapter2 = new BunAdapter(this, buns2);
        // устанавливаем для списка адаптер
        recyclerView2.setAdapter(bunAdapter2);

        setInitialData3();
        RecyclerView recyclerView3 = (RecyclerView) findViewById(R.id.recycler3);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));
        // создаем адаптер
        BunAdapter bunAdapter3 = new BunAdapter(this, buns3);
        // устанавливаем для списка адаптер
        recyclerView3.setAdapter(bunAdapter3);
    }

    private void setInitialData1() {
        buns1.add(new Bun("Круассан", count_rand, getTimeOld(), price_rand));
        buns1.add(new Bun("Крендель", count_rand, getTimeOld(), price_rand));
        buns1.add(new Bun("Багет", count_rand, getTimeOld(), price_rand));
        buns1.add(new Bun("Сметанник", count_rand, getTimeOld(), price_rand));
        buns1.add(new Bun("Батон", count_rand, getTimeOld(), price_rand));
    }

    private void setInitialData2() {
        buns2.add(new Bun("Круассан", getCount(count_rand), getTime(), getPriceTwo(price_rand)));
        buns2.add(new Bun("Крендель", getCount(count_rand), getTime(), getPriceTwice(price_rand)));
        buns2.add(new Bun("Багет", getCount(count_rand), getTime(), getPriceTwo(price_rand)));
        buns2.add(new Bun("Сметанник", getCount(count_rand), getTime(), getPriceDouble(price_rand)));
        buns2.add(new Bun("Батон", getCount(count_rand), getTime(), getPriceTwo(price_rand)));
    }

    private void setInitialData3() {
        buns3.add(new Bun("Круассан", getCount(count_rand), getTimeNew(), getPriceTwo(getPriceTwo(price_rand))));
        buns3.add(new Bun("Крендель", getCount(count_rand), getTimeNew(), getPriceTwice(getPriceTwice(price_rand))));
        buns3.add(new Bun("Багет", getCount(count_rand), getTimeNew(), getPriceTwo(getPriceTwo(price_rand))));
        buns3.add(new Bun("Сметанник", getCount(count_rand), getTimeNew(), getPriceDouble(getPriceDouble(price_rand))));
        buns3.add(new Bun("Батон", getCount(count_rand), getTimeNew(), getPriceTwo(getPriceTwo(price_rand))));
    }

    private int getCount(int count){
        return count-count_for_new;
    }


    private String getTimeOld() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        Date dateIn_X_MinAgo = new Date (date.getTime() - minutesAgo*60*1000);
        return dateFormat.format(dateIn_X_MinAgo);
    }

    private String getTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }

    private String getTimeNew() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        Date dateIn_X_MinNew = new Date (date.getTime() + minutesNew*60*1000);
        return dateFormat.format(dateIn_X_MinNew);
    }

    private double getPriceTwice(double price){
        return price/2;
    }

    private double getPriceTwo(double price){
        return price * 98/ 100;
    }

    private double getPriceDouble(double price){
        return price * 96/ 100;
    }
}