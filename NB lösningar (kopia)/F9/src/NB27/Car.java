package NB27;

public class Car implements Comparable<Car> {
    public String carBrand;
    public int yearModel;
    public int nrOfMiles;

    public Car(String carBrand, int yearModel, int nrOfMiles) {
        this.carBrand = carBrand;
        this.yearModel = yearModel;
        this.nrOfMiles = nrOfMiles;
    }

    @Override
    public int compareTo(Car o) {
        return this.carBrand.compareTo(o.carBrand);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(carBrand + " ").append( yearModel + " ").append(nrOfMiles);
        return sb.toString();
    }
}
