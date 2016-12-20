package ru.limtu.aboutme2;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectsFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener  {

    private SliderLayout projectsSlider = null;

    public ProjectsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_projects, container, false);
    }

    @Override
    public void onStop() {
        projectsSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onDetach() {
        projectsSlider.stopAutoCycle();
        super.onDetach();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        try{
            projectsSlider = (SliderLayout) getView().findViewById(R.id.slider);
        }catch (Exception e){
            e.printStackTrace();
        }

        if (projectsSlider != null){

            ProjectsSlider sliderItem;

            sliderItem = new ProjectsSlider(getContext());
            sliderItem.name("Патронус — университетская система управления учебным процессом");
            sliderItem.description("Социальная сеть для студентов, преподавателей и всех категорий сотрудников. В настоящий момент реализован модуль управления университетским расписанием, включая версии для мобильных устройств под iOS и Andorid. Система успешно протестирована на СПб кампусе НИУ ВШЭ.");
            sliderItem.link("http://patronus.portfolio.nwdeer.com/");
            sliderItem.setScaleType(BaseSliderView.ScaleType.CenterCrop);
            sliderItem.image(R.drawable.slider_patronus);
            projectsSlider.addSlider(sliderItem);

            sliderItem = new ProjectsSlider(getContext());
            sliderItem.name("Итинерариум");
            sliderItem.description("Интерактивная карта Итинерариум представляет собой систему поэтажных планов учебных площадок с возможностью отображения различной информации с привязкой к планам.");
            sliderItem.link("http://itinerarium.portfolio.nwdeer.com/");
            sliderItem.setScaleType(BaseSliderView.ScaleType.CenterCrop);
            sliderItem.image(R.drawable.slider_itinerarium);
            projectsSlider.addSlider(sliderItem);

            sliderItem = new ProjectsSlider(getContext());
            sliderItem.name("Автомойка Подорожник — сервис записи на автомойку");
            sliderItem.description("Комплексная система для владельцев автомойки, которая позволяет вести полный учет загруженности боксов, систематизировать список предоставляемых услуг и выстраивать гибкую ценовую политику.");
            sliderItem.link("http://podkomi.portfolio.nwdeer.com/");
            sliderItem.setScaleType(BaseSliderView.ScaleType.CenterCrop);
            sliderItem.image(R.drawable.slider_podkomi);
            projectsSlider.addSlider(sliderItem);

            sliderItem = new ProjectsSlider(getContext());
            sliderItem.name("Петербургские Парковки");
            sliderItem.description("Система оформления парковочных разрешений для Санкт-Петербурга. Конкурсный проект, разработанный в рамках хакатона 'электронного правительства Code4piter. \n" + "Победитель в номинации \"Лучшая реализация\".");
            sliderItem.link("http://parking.portfolio.nwdeer.com/");
            sliderItem.setScaleType(BaseSliderView.ScaleType.CenterCrop);
            sliderItem.image(R.drawable.slider_parking);
            projectsSlider.addSlider(sliderItem);

            projectsSlider.setPresetTransformer(SliderLayout.Transformer.Default);
            projectsSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            projectsSlider.setCustomAnimation(new DescriptionAnimation());
            projectsSlider.stopAutoCycle();
        }
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
