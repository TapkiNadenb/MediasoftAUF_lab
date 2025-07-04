import java.util.stream.Collectors;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] carYears = {
                2015, 2014, 2000, 2001, 2014, 2018, 2023, 2009, 2012, 2021,
                2010, 2009, 2021, 2009, 2017, 2009, 2010, 2016, 2021, 2020,
                2009, 2005, 2003, 2009, 2016, 2023, 2017, 2024, 2008, 2017,
                2014, 2022, 2006, 2025, 2001, 2006, 2020, 2009, 2012, 2010,
                2020, 2007, 2007, 2021, 2010, 2010, 2011, 2009, 2011, 2019
        };

        System.out.println("Машины, выпущенные после 2015 года:");
        for (int year : carYears){
            if (year > 2015){
                System.out.println(year + " ");
            }
        }
        System.out.println();

        int sumAges = 0;

        for (int year : carYears) {
            sumAges += (2025 - year);
        }

        int averageAge = sumAges / carYears.length;
        System.out.println("Средний возраст авто: " + averageAge + " лет");

        List<String> models = Arrays.asList(
                "Toyota Camry",
                "BMW X5",
                "Daewoo Matiz",
                "Shaha",
                "BMW X3",
                "Lada Granta",
                "Lada Priora",
                "Wolkswagen Polo",
                "Audi Q7",
                "Renault Logan",
                "Tesla",
                "BMW X3"
        );

        Set<String> uniqueModels = new LinkedHashSet<>(models);

        List<String> sortModels = new ArrayList<>();

        for (String model : uniqueModels){
            if (model.contains("Tesla")){
                sortModels.add("ELECTRO_CAR");
            } else {
                sortModels.add(model);
            }
        }

        sortModels.sort(Collections.reverseOrder());

        System.out.println("Уникальные модели:");
        for (String x : sortModels){
            System.out.println(x);
        }

        Set<String> modelSet = new HashSet<>(sortModels);

        System.out.println();

        Car car1 = new Car("1HGCM82633A004352", "Camry", "Toyota", 2018, 30000, 15000);
        Car car2 = new Car("WBA3A5C50DF354651", "X5",    "BMW",    2020, 30000, 45000);
        Car car3 = new Car("1HGCM82633A004352", "Corolla","Toyota", 2017, 40000, 13000);
        Car car4 = new Car("3FAHP0HA7AR123456", "Priora",  "Lada",   2015, 60000,  9000);
        Car car5 = new Car("3FAHP0HA7AR123466", "Granta",  "Lada",   2025, 67000,  10000);
        Car car6 = new Car("3FAHP0HA7AR123452", "Ceed",  "Kia",   2017, 40000,  15000);

        Set<Car> garage = new HashSet<>();
        garage.add(car1);
        garage.add(car2);
        garage.add(car3);
        garage.add(car4);
        garage.add(car5);
        garage.add(car6);

        System.out.println("В гараже (HashSet) хранится " + garage.size() + " уникальных машины:");
        for (Car c : garage) {
            System.out.println("  " + c);
        }

        System.out.println("Машины с пробегом < 50_000 км, отсортированные по убыванию цены:");
        List<Car> filteredSortedCars = garage.stream().filter(car -> car.getMileage() < 50_000).sorted(Comparator.comparingDouble(Car::getPrice).reversed()).collect(Collectors.toList());

        filteredSortedCars.forEach(System.out::println);

        System.out.println("Топ-3 самых дорогих машины с пробегом < 50_000 км:");
        filteredSortedCars.stream().limit(3).forEach(System.out::println);

        double averageMileage = garage.stream().mapToInt(Car::getMileage).average().orElse(0);

        System.out.printf("%nСредний пробег всех машин: %.2f км%n", averageMileage);

        Map<String, List<Car>> carsByManufacturer = garage.stream()
                .collect(Collectors.groupingBy(Car::getManufacturer));

        System.out.println("Машины, сгруппированные по производителю:");
        for (Map.Entry<String, List<Car>> entry : carsByManufacturer.entrySet()) {
            String manufacturer = entry.getKey();
            List<Car> cars = entry.getValue();
            System.out.println(manufacturer + ":");
            for (Car c : cars) {
                System.out.println("  " + c);
            }
        }
    }
}
