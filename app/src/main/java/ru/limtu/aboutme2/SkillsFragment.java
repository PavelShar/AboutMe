package ru.limtu.aboutme2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class SkillsFragment extends Fragment {

    RecyclerView skillRecycler;
    private Skills[] skillsData;
    String[] skillNames;
    String[] skillTimes;
    int[] skillImages;


    public SkillsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        skillRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_skills, container, false);

        initializeData();
        initializeAdapter();

        return skillRecycler;
    }

    private void initializeData() {


        skillsData = new Skills[]{
                new Skills("PHP", "Более 5 лет активной разработки", R.drawable.skills_php),
                new Skills("MySQL/MariaDB", "Более 5 лет использования в проектах различного масштаба", R.drawable.skills_mysql),
                new Skills("JavaScript", "Более 5 лет, углубленное изучение на протяжении полугода", R.drawable.skills_js),
                new Skills("HTML", "Более 5 лет", R.drawable.skills_html),
                new Skills("CSS", "Более 5 лет", R.drawable.skills_css),
                new Skills("GIT", "Около полугода активного использования", R.drawable.skills_git),
                new Skills("Docker", "Около полугода активного использования", R.drawable.skills_docker),
                new Skills("jQuery", "Более 4 лет", R.drawable.skills_jquery),
                new Skills("MS Visual Basic", "Курсовая на 3 курсе", R.drawable.skills_vba),
                new Skills("Adobe Photoshop", "Более 10 лет", R.drawable.skills_photoshop),
                new Skills("Adobe Illustrator", "Базовые знания", R.drawable.skills_illustrator),
                new Skills("Adobe After Effects", "Поверхностные знания", R.drawable.skills_ae),
                new Skills("Sony Vegas", "Базовые знания", R.drawable.skills_vegas),
        };

        skillNames = new String[skillsData.length];
        for (int i = 0; i < skillNames.length; i++) {
            skillNames[i] = skillsData[i].getName();
        }

        skillTimes = new String[skillsData.length];
        for (int i = 0; i < skillTimes.length; i++) {
            skillTimes[i] = skillsData[i].getTime();
        }

        skillImages = new int[skillsData.length];
        for (int i = 0; i < skillImages.length; i++) {
            skillImages[i] = skillsData[i].getPhotoId();
        }


    }

    private void initializeAdapter() {
        SkillsAdapter adapter = new SkillsAdapter(skillNames, skillTimes, skillImages);
        skillRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        skillRecycler.setLayoutManager(layoutManager);
    }
}
