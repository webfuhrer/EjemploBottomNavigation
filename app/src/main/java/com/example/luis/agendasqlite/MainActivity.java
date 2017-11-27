package com.example.luis.agendasqlite;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        Fragment fragmento_seleccionado;
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragmento_seleccionado=null;
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    fragmento_seleccionado=new FragmentBuscarContacto();

                    break;
                case R.id.navigation_dashboard:

                    fragmento_seleccionado=new FragmentInsertarContacto();
                    break;

            }
            FragmentTransaction transaccion=getSupportFragmentManager().beginTransaction();
            Bundle b=new Bundle();


            transaccion.replace(R.id.content, fragmento_seleccionado);
            transaccion.commit();
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, new FragmentBuscarContacto());
        transaction.commit();
       // mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
