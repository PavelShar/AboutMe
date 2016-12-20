package ru.limtu.aboutme2;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SkillsAdapter extends RecyclerView.Adapter<SkillsAdapter.SkillsViewHolder>{

    private String[] name;
    private String[] time;
    private int[] imageId;

    public static class SkillsViewHolder extends RecyclerView.ViewHolder {

        private CardView cv;

        public SkillsViewHolder(CardView itemView) {
            super(itemView);
            cv = itemView;
        }

    }

    public SkillsAdapter(String[] name, String[] time, int[] imageId){
        this.name = name;
        this.time = time;
        this.imageId = imageId;

    }

    @Override
    public SkillsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.skill_card, parent, false);
        return new SkillsViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(SkillsViewHolder holder, int position) {

        CardView cv = holder.cv;
        ImageView imageView = (ImageView) cv.findViewById(R.id.skill_image);
        Drawable drawable = cv.getResources().getDrawable(imageId[position]);
        imageView.setImageDrawable(drawable);

        TextView skillName = (TextView) cv.findViewById(R.id.skill_name);
        skillName.setText(name[position]);

        TextView skillTime = (TextView) cv.findViewById(R.id.skill_time);
        skillTime.setText(time[position]);

    }

    @Override
    public int getItemCount() {
        return name.length;
    }

}
