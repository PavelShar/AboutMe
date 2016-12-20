package ru.limtu.aboutme2;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private final String emailAddress = "pavloniym@gmail.com"; //Email адрес для отправки мне сообщений
    private final String phoneNumber = "+79818904766"; //
    private final String VKProfileID = "pasharypov"; //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Загружаем основной фаргмент
        replaceFragment(new MainFragment());
        //Делаем прозрачным туллбар
        hideToolbar();


        findViewById(R.id.menu_email).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
        findViewById(R.id.menu_phone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall();
            }
        });
        findViewById(R.id.menu_vk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVK();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.menu_user :
                replaceFragment(new MainFragment());
                hideToolbar();
                break;

            case R.id.menu_skills:
                replaceFragment(new SkillsFragment());
                showToolbar();
                break;

            case R.id.menu_education:
                replaceFragment(new EducationFragment());
                showToolbar();
                break;

            default:
                return true;

        }

        item.setChecked(true);
        setTitle(item.getTitle());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }


    private void hideToolbar(){


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbarlayout);

        toolbar.setElevation(0);
        appBarLayout.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent));
        toolbar.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent));

    }


    private void showToolbar (){

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbarlayout);

        toolbar.setElevation(1);
        appBarLayout.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimary, null));
        toolbar.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimaryDark, null));

    }


    /**
     * Проверяем можно ли открыть такой интент
     * @param intent - интент
     * @return - true or false
     */

    private boolean isIntentSafe(Intent intent){

        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        return activities.size() > 0;
    }

    /**
     * Отправляем по почту
     */
    private void sendEmail (){
        Intent emailIntent = new Intent(Intent. ACTION_SENDTO, Uri. fromParts("mailto", emailAddress, null)) ;
        emailIntent.putExtra(Intent. EXTRA_TEXT, "Здравствуйте, Павел! Я установил себе ваше приложение!") ;

        if(isIntentSafe(emailIntent)){

            startActivity(emailIntent);

        } else{

            Toast.makeText(getApplicationContext(), "К сожалению, не удалось отправить мне сообщение. Но Вы можете позвонить!", Toast.LENGTH_LONG).show();
        }
    }


    private void makeCall() {
        Uri number = Uri. parse("tel:" + phoneNumber) ;
        Intent callIntent = new Intent(Intent. ACTION_DIAL, number) ;
        if(isIntentSafe(callIntent)){
            startActivity(callIntent);
        } else{
            Toast.makeText(getApplicationContext(), "К сожалению, не удалось позвонить", Toast.LENGTH_LONG).show();
        }
    }

    private void openVK (){

        Uri webpage = Uri.parse("https://m.vk.com/" + VKProfileID) ;
        Intent webIntent = new Intent(Intent. ACTION_VIEW, webpage) ;

        if(isIntentSafe(webIntent)){
            startActivity(webIntent);
        } else{
            Toast.makeText(getApplicationContext(), "К сожалению, нет браузера", Toast.LENGTH_LONG).show();
        }
    }

}
