package ru.limtu.aboutme2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Павел on 20.12.2016.
 */

public class Contacts extends MainActivity {

    public static final String emailAddress = "pavloniym@gmail.com"; //Email адрес для отправки мне сообщений
    public static final String phoneNumber = "+79818904766"; //
    public static final String VKProfileID = "pasharypov"; //

    private Context context;

    public Contacts (Context c){
        context = c;
    }

    /**
     * Проверяем можно ли открыть такой интент
     * @param intent - интент
     * @return - true or false
     */

    private boolean isIntentSafe(Intent intent){

        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        return activities.size() > 0;
    }

    /**
     * Отправляем по почту
     */
    public void sendEmail (){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri. fromParts("mailto", emailAddress, null)) ;
        emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        emailIntent.putExtra(Intent. EXTRA_TEXT, "Здравствуйте, Павел! Я установил себе ваше приложение!") ;

        if(isIntentSafe(emailIntent)){
            context.startActivity(emailIntent);
        } else{
            Toast.makeText(new MainActivity().getApplicationContext(), "К сожалению, не удалось отправить мне сообщение. Но Вы можете позвонить!", Toast.LENGTH_LONG).show();
        }
    }


    public void makeCall() {
        Uri number = Uri. parse("tel:" + phoneNumber) ;
        Intent callIntent = new Intent(Intent. ACTION_DIAL, number) ;
        callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        if(isIntentSafe(callIntent)){
            context.startActivity(callIntent);
        } else{
            Toast.makeText(getApplicationContext(), "К сожалению, не удалось позвонить", Toast.LENGTH_LONG).show();
        }
    }

    public void openVK (){

        Uri webpage = Uri.parse("https://m.vk.com/" + VKProfileID) ;
        Intent webIntent = new Intent(Intent. ACTION_VIEW, webpage) ;
        webIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        if(isIntentSafe(webIntent)){
            context.startActivity(webIntent);
        } else{
            Toast.makeText(getApplicationContext(), "К сожалению, нет браузера", Toast.LENGTH_LONG).show();
        }
    }
}
