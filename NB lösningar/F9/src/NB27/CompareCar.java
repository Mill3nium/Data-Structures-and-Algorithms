package NB27;

import java.util.*;

public class CompareCar implements Comparator<Car> {

    @Override
    public int compare(Car other1, Car other2) {
        //If same year model, sort by name
        if( other1.yearModel == other2.yearModel){
            return other1.carBrand.compareTo(other2.carBrand);
        }else
            return other2.yearModel - other1.yearModel;
    }
}
