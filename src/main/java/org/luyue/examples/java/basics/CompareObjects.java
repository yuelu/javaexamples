package org.luyue.examples.java.basics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareObjects {

    public static void main(String[] args) {

        Car audiQ72014 = new Car("Audi", "Q7", 2014);
        Car audiQ52015 = new Car("Audi", "Q5", 2015);
        Car fordFocus2015 = new Car("Ford", "Focus", 2015);

        List<Car> cars = Arrays.asList(audiQ72014, audiQ52015, fordFocus2015);

        Collections.sort(cars);
        print("sort by year", cars);

        Collections.sort(cars, new MakerComparator());
        print("sort by maker", cars);

        Collections.sort(cars, new ModelComparator());
        print("sort by model", cars);
    }

    private static void print(String title, List<Car> cars) {
        System.out.println("************ " + title + " ****************");
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}

class Car implements Comparable<Car> {

    private final String maker;
    private final String model;
    private final int year;

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    Car(String maker, String model, int year) {
        this.maker = maker;
        this.model = model;
        this.year = year;
    }

    @Override
    public int compareTo(Car anotherCar) {
        if (this.year > anotherCar.year)
            return 1;
        else if (this.year < anotherCar.year)
            return -1;
        return 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + year;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        if (year != other.year)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Car [maker=" + maker + ", model=" + model + ", year=" + year + "]";
    }
}

class MakerComparator implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        return car1.getMaker().compareTo(car2.getMaker());
    }
}

class ModelComparator implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        return car1.getModel().compareTo(car2.getModel());
    }
}