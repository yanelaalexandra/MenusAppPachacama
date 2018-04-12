package com.pachacama.menus.menusapppachacama;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuToobarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_toobar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_home:
                Toast.makeText(this, "Regresando al inicio...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, DummyActivity.class));
                return true;
            case R.id.action_takepicture:
                Toast.makeText(this, "Tomando una foto...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_day_view:
                item.setChecked(true);
                Toast.makeText(this, "Primer fragmento seleccionado...", Toast.LENGTH_SHORT).show();
                FragmentManager fragmentManager = getSupportFragmentManager();
                // Create FirstFragment
                Fragment fragment = new FirstFragment();
                // Replace content
                fragmentManager.beginTransaction().replace(R.id.content, fragment).addToBackStack("tag").commit();

                return true;
            case R.id.action_week_view:
                item.setChecked(true);
                Toast.makeText(this, "Segundo fragmento seleccionado...", Toast.LENGTH_SHORT).show();

                FragmentManager fragmentManager2 = getSupportFragmentManager();
                // Create FirstFragment
                Fragment fragment2 = new SecondFragment();
                // Send 'param1' argument to Fragment
                Bundle args = new Bundle();
                args.putString("param1", "Hello Fragment!");
                fragment2.setArguments(args);
                // Replace content
                fragmentManager2.beginTransaction().replace(R.id.content, fragment2).addToBackStack("tag").commit();

                return true;
            case R.id.action_month_view:
                item.setChecked(true);
                Toast.makeText(this, "Tercer fragmento seleccionado...", Toast.LENGTH_SHORT).show();

                FragmentManager fragmentManager3 = getSupportFragmentManager();
                // Create FirstFragment with factory
                Fragment fragment3 = ThirdFragment.newInstance("Hello Again!");
                // Replace content
                fragmentManager3.beginTransaction().replace(R.id.content, fragment3).addToBackStack("tag").commit();

                return true;
            case R.id.action_toggle:
                if(item.isChecked()){
                    item.setChecked(false);
                    Toast.makeText(this, "Modo offline desactivado...", Toast.LENGTH_SHORT).show();
                }else{
                    item.setChecked(true);
                    Toast.makeText(this, "Modo offline activado...", Toast.LENGTH_SHORT).show();
                }
                return true;
            case R.id.action_about:
                Toast.makeText(this, "Acerca de...", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
