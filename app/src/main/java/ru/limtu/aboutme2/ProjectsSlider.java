package ru.limtu.aboutme2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;

/**
 * Created by Павел on 20.12.2016.
 */

public class ProjectsSlider extends BaseSliderView {

    private String mName;
    private String mLink;

    public ProjectsSlider(Context context) {
        super(context);
    }



    public void name(String name){ mName = name; }
    public String getName(){
        return mName;
    }

    public void link(String link){ mLink = link; }
    public String getLink(){
        return mLink;
    }

    @Override
    public View getView() {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.projects_slider,null);
        ImageView target = (ImageView)v.findViewById(R.id.daimajia_slider_image);
        TextView description = (TextView)v.findViewById(R.id.description);
        description.setText(getDescription());

        TextView name = (TextView)v.findViewById(R.id.name);
        name.setText(getName());


        Button linkButton = (Button) v.findViewById(R.id.link);
        linkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getLink().length() > 0){
                    Uri portfolioURL = Uri.parse(getLink()) ;
                    Intent portfolioLink = new Intent(Intent.ACTION_VIEW, portfolioURL) ;
                    getContext().startActivity(portfolioLink);
                }

            }
        });

        bindEventAndShow(v, target);
        return v;
    }
}