import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RawData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String model = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            Engine engine = new Engine(engineSpeed, enginePower);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            double tireOnePressure = Double.parseDouble(data[5]);
            int tireOneAge = Integer.parseInt(data[6]);
            double tireTwoPressure = Double.parseDouble(data[7]);
            int tireTwoAge = Integer.parseInt(data[8]);
            double tireThreePressure = Double.parseDouble(data[9]);
            int tireThreeAge = Integer.parseInt(data[10]);
            double tireFourPressure = Double.parseDouble(data[11]);
            int tireFourAge = Integer.parseInt(data[12]);
            Tires tires = new Tires(tireOnePressure, tireOneAge, tireTwoPressure, tireTwoAge, tireThreePressure, tireThreeAge, tireFourPressure, tireFourAge);
            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }
        String cmd = scanner.nextLine();
        if (cmd.equals("fragile")) {
            cars.stream().filter(car -> car.cargoInfo.type.equals("fragile") && car.tiresInfo.isFragile()).forEach(System.out::println);
        } else if (cmd.equals("flamable")) {
            cars.stream().filter(car -> car.engineInfo.power > 250).forEach(System.out::println);
        }
    }

    private static class Car {
        String model;
        Engine engineInfo;
        Cargo cargoInfo;
        Tires tiresInfo;

        public Car(String model, Engine engineInfo, Cargo cargoInfo, Tires tiresInfo) {
            this.model = model;
            this.engineInfo = engineInfo;
            this.cargoInfo = cargoInfo;
            this.tiresInfo = tiresInfo;
        }

        @Override
        public String toString() {
            return model;
        }
    }

    private static class Engine {
        int speed;
        int power;

        public Engine(int speed, int power) {
            this.speed = speed;
            this.power = power;
        }
    }

    private static class Cargo {
        public Cargo(int weight, String type) {
            this.weight = weight;
            this.type = type;
        }

        int weight;
        String type;
    }

    private static class Tires {
        double tireOnePressure;
        int tireOneAges;
        double tireTwoPressure;
        int tireTwoAges;
        double tireThreePressure;
        int tireThreeAges;
        double tireFourPressure;
        int tireFourAges;

        public Tires(double tireOnePressure, int tireOneAges, double tireTwoPressure, int tireTwoAges, double tireThreePressure, int tireThreeAges, double tireFourPressure, int tireFourAges) {
            this.tireOnePressure = tireOnePressure;
            this.tireOneAges = tireOneAges;
            this.tireTwoPressure = tireTwoPressure;
            this.tireTwoAges = tireTwoAges;
            this.tireThreePressure = tireThreePressure;
            this.tireThreeAges = tireThreeAges;
            this.tireFourPressure = tireFourPressure;
            this.tireFourAges = tireFourAges;
        }

        private boolean isFragile() {
            return this.tireOnePressure < 1 || this.tireTwoPressure < 1 || this.tireThreePressure < 1 || this.tireFourPressure < 1;
        }
    }
}
