import java.util.*;

public class CarSalesman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Engine>> engines = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] engineData = scanner.nextLine().split("\\s+");
            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);
            int displacement = 0;
            String efficiency = "n/a";
            if (engineData.length == 3) {
                try {
                    displacement = Integer.parseInt(engineData[2]);
                } catch (Exception e) {
                    efficiency = engineData[2];
                }
            } else if (engineData.length == 4) {
                displacement = Integer.parseInt(engineData[2]);
                efficiency = engineData[3];
            }
            Engine engine = new Engine(model, power, displacement, efficiency);
            engines.putIfAbsent(model, new ArrayList<>());
            engines.get(model).add(engine);
        }
        Map<Integer, List<Car>> cars = new HashMap<>();
        n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] carData = scanner.nextLine().split(" ");
            String model = carData[0];
            String engineModel = carData[1];
            int weight = 0;
            String color = "n/a";
            if (carData.length == 3) {
                try {
                    weight = Integer.parseInt(carData[2]);
                } catch (Exception e) {
                    color = carData[2];
                }
            } else if (carData.length == 4) {
                weight = Integer.parseInt(carData[2]);
                color = carData[3];
            }
            Engine engine = getEngine(engineModel, engines);
            Car car = new Car(model, engine, weight, color);
            cars.putIfAbsent(i, new ArrayList<>());
            cars.get(i).add(car);
        }
        for (Map.Entry<Integer, List<Car>> currentElement : cars.entrySet()) {
            List<Car> list = currentElement.getValue();
            String displacement = "n/a";
            String weight = "n/a";
            for (Car car : list) {
                if (car.engine.displacement > 0) {
                    displacement = String.valueOf(car.engine.displacement);
                }
                if (car.weight > 0) {
                    weight = String.valueOf(car.weight);
                }
            }
            String finalDisplacement = displacement;
            String finalWeight = weight;
            currentElement.getValue().forEach(f -> System.out.printf("%s:" + "\n" + "  %s:\n" +
                            "    Power: %s\n" +
                            "    Displacement: %s\n" +
                            "    Efficiency: %s\n" +
                            "  Weight: %s\n" +
                            "  Color: %s%n", f.getModel(),
                    f.getEngine().getModel(),
                    f.getEngine().getPower(),
                    finalDisplacement,
                    f.getEngine().getEfficiency(),
                    finalWeight, f.getColor()));
        }
    }

    private static Engine getEngine(String engine, Map<String, List<Engine>> engineParameters) {
        for (Map.Entry<String, List<Engine>> element : engineParameters.entrySet()) {
            String modelCurrent = element.getKey();
            if (modelCurrent.equals(engine)) {
                String specificModel = element.getValue().get(0).getModel();
                int power = element.getValue().get(0).getPower();
                int displacement = element.getValue().get(0).getDisplacement();
                String efficiency = element.getValue().get(0).getEfficiency();
                return new Engine(specificModel, power, displacement, efficiency);
            }
        }
        return null;
    }

    private static class Car {
        String model;
        Engine engine;
        int weight;
        String color;

        public String getModel() {
            return model;
        }

        public Engine getEngine() {
            return engine;
        }

        public String getColor() {
            return color;
        }

        public Car(String model, Engine engine, int weight, String color) {
            this.model = model;
            this.engine = engine;
            this.weight = weight;
            this.color = color;
        }
    }

    private static class Engine {
        String model;
        int power;
        int displacement;
        String efficiency;

        public int getPower() {
            return power;
        }

        public int getDisplacement() {
            return displacement;
        }

        public String getEfficiency() {
            return efficiency;
        }

        public Engine(String model, int power, int displacement, String efficiency) {
            this.model = model;
            this.power = power;
            this.displacement = displacement;
            this.efficiency = efficiency;
        }

        public String getModel() {
            return model;
        }
    }
}