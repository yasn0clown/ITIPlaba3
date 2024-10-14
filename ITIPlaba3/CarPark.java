import java.util.HashMap;
import java.util.Map;

// Класс для представления автомобиля
class Car {
    private String make;   // Марка автомобиля
    private String model;  // Модель автомобиля
    private int year;      // Год выпуска

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Геттеры для полей класса
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Car {" + "make='" + make + ", model='" + model + ", year=" + year + '}';
    }
}

// Основной класс для работы с HashMap
public class CarPark {
    // Хэш-таблица для учета автомобилей
    private Map<String, Car> carHashMap = new HashMap<>();

    // Метод для добавления автомобиля
    public void addCar(String licensePlate, Car car) {
        carHashMap.put(licensePlate, car);
    }

    // Метод для поиска автомобиля по номерному знаку
    public Car getCar(String licensePlate) {
        return carHashMap.get(licensePlate);
    }

    // Метод для удаления автомобиля по номерному знаку
    public void removeCar(String licensePlate) {
        carHashMap.remove(licensePlate);
    }

    public static void main(String[] args) {
        CarPark park = new CarPark();

        // Добавление автомобилей
        park.addCar("B456DE", new Car("Toyota", "Camry", 2020));
        park.addCar("R777RT", new Car("Mercedes-Benz", "CLA 250", 2023));

        // Поиск автомобиля
        System.out.println("Автомобиль с номером R777RT: " + park.getCar("R777RT"));

        // Удаление автомобиля
        park.removeCar("B456DE");

        System.out.println("Автомобиль с номером B456DE: " + park.getCar("B456DE"));
    }
}
