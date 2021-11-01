import android.content.Context;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Tests {


    private CustomList list;
    private ArrayList<City> cities;
    private Context context;

    public void createList(){
        list = new CustomList(null,new ArrayList<City>());
    }

    private CustomList mockCustomList() {
        CustomList cityList = new CustomList(context,cities);
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void addCityTest(){
        createList();
        int listSize = list.getCount();
        list.addCity(new City("Halifax","NS"));
        assertEquals(list.getCount(),listSize+1);
    }

    @Test
    void testHasCity(){
        createList();
        list.addCity(new City("Halifax","NS"));
        assertTrue(list.hasCity(new City("Halifax","NS")));
    }
}
