package com.millcitymade.cartersteffen.millcitymade;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ActionBar toolbar;
    private Fragment fragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    toolbar.setTitle(R.string.title_shop);
                    fragment = new ShopFragment();
                    loadFragment(fragment);
                    mTextMessage.setText("");
                    //mTextMessage.setText(R.string.title_shop);
                    return true;
                case R.id.navigation_dashboard:
                    toolbar.setTitle(R.string.title_contact);
                    fragment = new ContactFragment();
                    loadFragment(fragment);
                    mTextMessage.setText(R.string.title_contact);
                    return true;
                case R.id.navigation_notifications:
                    toolbar.setTitle(R.string.title_notifications);
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbar = getSupportActionBar();
        getSupportActionBar().setTitle("Title");
        //getSupportActionBar().setSubtitle("Subtitle");
        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME |
                ActionBar.DISPLAY_SHOW_TITLE | ActionBar.DISPLAY_USE_LOGO); // Customize if you need to

        getSupportActionBar().setIcon(R.mipmap.ic_launcher_foreground);


        //mTextMessage.setText(R.string.title_shop);
        toolbar.setTitle(R.string.title_shop);
        loadFragment(new ShopFragment());
    }


    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
