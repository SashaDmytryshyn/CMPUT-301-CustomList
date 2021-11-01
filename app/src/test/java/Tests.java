import android.content.Context;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        CustomList cityList = mockCustomList();
        assertTrue(cityList.hasCity(mockCity()));
    }

    @Test
    void testDelete(){
        CustomList cityList = mockCustomList();
        cityList.delete(mockCity());
        assertEquals(0,cityList.countCities());
        assertThrows(IllegalArgumentException.class,() -> {
            cityList.delete(mockCity());
        });
    }

    @Test
    void testCountCities(){
        CustomList cityList = mockCustomList();
        assertEquals(1,cityList.countCities());
        cityList.delete(mockCity());
        assertEquals(0,cityList.countCities());
    }
}

