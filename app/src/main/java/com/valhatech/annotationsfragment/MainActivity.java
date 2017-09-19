package com.valhatech.annotationsfragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.valhatech.annotationsfragment.fragment.MainFragment;
import com.valhatech.annotationsfragment.fragment.MainFragment_;
import com.valhatech.annotationsfragment.fragment.ParamsFragment;
import com.valhatech.annotationsfragment.fragment.ParamsFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener, ParamsFragment.OnFragmentInteractionListener{

    @ViewById(R.id.navigation)
    protected BottomNavigationView bottomNavigationView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    MainFragment mainFragment = new MainFragment_();
                    getSupportFragmentManager().beginTransaction().replace(R.id.relativeLayout, mainFragment).commit();
                    return true;


                case R.id.navigation_dashboard:
                    ParamsFragment paramsFragment = new ParamsFragment_();
                    getSupportFragmentManager().beginTransaction().replace(R.id.relativeLayout, paramsFragment).commit();

                    return true;

            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @AfterViews
    void calledAfterViewInjection() {
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        MainFragment mainFragment = new MainFragment_();
        getSupportFragmentManager().beginTransaction().replace(R.id.relativeLayout, mainFragment).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
