package com.davis.uzaspeedy;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentUser;
    private RecyclerAdapter mAdapter;
    private RecyclerView recyclerView;
    @TargetApi(Build.VERSION_CODES.O)
    private ArrayList<FarmersData> farmersList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spannable text = new SpannableString(Objects.requireNonNull(getSupportActionBar()).getTitle());
        text.setSpan(new ForegroundColorSpan(Color.WHITE), 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        Objects.requireNonNull(getSupportActionBar()).setTitle(text);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        recyclerView = findViewById(R.id.recycler_view);
        mAdapter = new RecyclerAdapter(farmersList);
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        DataPrepare();
        //firebase instances
        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser();

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void DataPrepare(){
        FarmersData data = new FarmersData(R.drawable.one,"Bahati Farms", "Nairobi, Ngong-Rd","07********");
        farmersList.add(data);
         data = new FarmersData(R.drawable.two,"Bahati Farms", "Nairobi, Ngong-Rd","07********");
        farmersList.add(data);
        data = new FarmersData(R.drawable.three,"Bahati Farms", "Nairobi, Ngong-Rd","07********");
        farmersList.add(data);
        data = new FarmersData(R.drawable.four,"Bahati Farms", "Nairobi, Ngong-Rd","07********");
        farmersList.add(data);
        data = new FarmersData(R.drawable.four,"Bahati Farms", "Nairobi, Ngong-Rd","07********");
        farmersList.add(data);
        data = new FarmersData(R.drawable.four,"Bahati Farms", "Nairobi, Ngong-Rd","07********");
        farmersList.add(data);
        Collections.sort(farmersList, new Comparator<FarmersData>() {
            @Override
            public int compare(FarmersData farmersData, FarmersData t1) {
                return farmersData.getFarmName().compareTo(t1.getFarmName());
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        if(mCurrentUser == null){
            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
            loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(loginIntent);
            finish();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.action_logout){
            //logout user
            logoutUser();
            return true;

        }
        return super.onOptionsItemSelected(item);
    }
    private void logoutUser(){
        mAuth.signOut();
        Intent logOutIntent = new Intent(MainActivity.this, LoginActivity.class);
        logOutIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(logOutIntent);
        finish();
    }
}