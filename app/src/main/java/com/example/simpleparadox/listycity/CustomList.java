package com.example.simpleparadox.listycity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities){
        super(context,0, cities);
        this.cities = cities;
        this.context = context;
    }

    public int getCount(){
        return cities.size();
    }

    public void addCity(City city){
        cities.add(city);
        return;
    }

    // NOTE: I AM USING MY OWN CODE FROM LAB 6 FOR THE NEXT 3 FUNCTIONS.


    /**
     * This returns true or false depending on whether
     *      cities contains the city given as a parameter
     * @param city string
     * @return boolean
     */
    public boolean hasCity(City city){
        for (City city2: cities)
        {
            if(city.getCityName().equals(city2.getCityName())){
                if(city.getProvinceName().equals(city2.getProvinceName())){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This deletes a city from cities if cities contains it, else it throws an exception
     * @param city City object
     */
    public void delete(City city){
        for (City city2: cities)
        {
            if(city.getCityName().equals(city2.getCityName())){
                if(city.getProvinceName().equals(city2.getProvinceName())){
                    cities.remove(city2);
                    return;
                }
            }
        }
        throw new IllegalArgumentException();

    }

    /**
     * This returns the number of cities in cities
     * @return size of cities
     */
    public  int countCities(){
        return -1;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;



    }
}
