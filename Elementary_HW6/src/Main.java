import java.util.*;
public class Main {

    public static void main(String[] args) {
        List<Car> carList = createListOfCars();
        showCarCollection(carList);
        System.out.println();
        Set<Car> carSet = createSetOfCars();
        showCarCollection(carSet);
        System.out.println();
        System.out.println("Максимальный год в листе: " + findMaxYear(carList));
        System.out.println();
        showCarCollection(mergeIntoCollection(carList,carSet));
    }

    public static List<Car> createListOfCars() {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            carList.add(new Car("code" + i, "reg" + i, "mark" + i, "model" + i, (short) (1970 + Math.random() * 35), (int) (Math.random() * 300000)));
        }
        return carList;
    }

    public static Set<Car> createSetOfCars() {
        Set<Car> carSet = new HashSet<>();
        for (int i = 10; i < 22; i++) {
            carSet.add(new Car("code" + i, "reg" + i, "mark" + i, "model" + i, (short) (1990 + Math.random() * 25), (int) (Math.random() * 300000)));
        }
        return carSet;
    }

    public static void showCarCollection(Collection<Car> carCollection) {
        int i = 1;
        for (Car car: carCollection) {
            System.out.print(i + ". VIN = " + car.getVin() + "\t" + "Reg = " + car.getRegNumber() + "\t" + "Mark = " + "\t" + car.getBrand() + "\t" + "Model = " + car.getModel() + "\t" + "Year = " + car.getYear() + "\t" + "Mileage = " + car.getMileage() + "\n");
            i++;
        }
    }

    public static Collection<Car> mergeIntoCollection (List<Car> carList, Set<Car> carSet) {
        Collection<Car> mergedCollection = new ArrayList<>();
        ((ArrayList<Car>) mergedCollection).addAll(carList);
        short maxYear = findMaxYear(carList);
        for (Car car : carSet) {
            if (car.getYear() > maxYear) {
                mergedCollection.add(car);
            }
        }
        return mergedCollection;
    }

    public static short findMaxYear (Collection<Car> carCollection) {
        short maxYear = 0;
        for (Car car : carCollection) {
            if (car.getYear() > maxYear) {
                maxYear = car.getYear();
            }
        }
        return maxYear;
    }
}

