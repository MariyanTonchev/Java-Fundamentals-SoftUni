import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Vehicle> vehicles = new ArrayList<>();
        while (!input.equals("End")) {
            String[] data = input.split(" ");
            Vehicle vehicle = new Vehicle(data[0], data[1], data[2], Integer.parseInt(data[3]));
            vehicles.add(vehicle);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("Close the Catalogue")) {
            Vehicle vehicle = Vehicle.getVehicle(vehicles, input);
            if (Vehicle.isExist(vehicles, vehicle)) {
                System.out.println(vehicle.toString());
            }
            input = scanner.nextLine();
        }
        int carsHP = 0;
        int trucksHP = 0;
        int countTrucks = 0;
        int countCars = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().equals("car")) {
                carsHP += vehicle.getHorsePower();
                countCars++;
            } else {
                trucksHP += vehicle.getHorsePower();
                countTrucks++;
            }
        }
        double trucksAverageHP = 0;
        double carsAverageHP = 0;
        if(countTrucks > 0){
            trucksAverageHP = (trucksHP * 1.0) / countTrucks;
        }
        if(countCars > 0){
            carsAverageHP = (carsHP * 1.0) / countCars;
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", carsAverageHP);
        System.out.printf("Trucks have average horsepower of: %.2f.", trucksAverageHP);
    }

    private static class Vehicle {
        String type;
        String model;
        String color;
        int horsePower;

        public Vehicle(String type, String model, String color, int horsePower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        private static boolean isExist(List<Vehicle> list, Vehicle vehicle) {
            for (Vehicle value : list) {
                if (value.getModel().equals(vehicle.getModel())) {
                    return true;
                }
            }
            return false;
        }

        private static Vehicle getVehicle(List<Vehicle> list, String model) {
            Vehicle vehicle = null;
            for (Vehicle vehicle1 : list) {
                if (vehicle1.getModel().equals(model)) {
                    vehicle = vehicle1;
                }
            }
            return vehicle;
        }

        public String getType() {
            return type;
        }

        public String getModel() {
            return model;
        }

        public int getHorsePower() {
            return horsePower;
        }

        @Override
        public String toString() {
            return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d", type.toUpperCase().charAt(0) + getType().substring(1), model, color, horsePower);
        }
    }
}
