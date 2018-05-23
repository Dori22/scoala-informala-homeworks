package ro.siit.java10.evp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    private List<DatabaseElement> carsList;

    public Repository() {
        carsList = new ArrayList<DatabaseElement>();
        initializeCarsList();
    }

    public List<DatabaseElement> getCarsList() {
        return carsList;
    }

    private void initializeCarsList() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(
                "src\\main\\resources\\ElectricCarList.csv"), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                ElectricCar electricCar = new ElectricCar(tokens[0], Integer.parseInt(tokens[1]),
                        (tokens[2]), Boolean.parseBoolean(tokens[3]),
                        (tokens[4]), (tokens[5]), (tokens[6]), Integer.parseInt(tokens[7]), Integer.parseInt(tokens[8]),
                        Boolean.parseBoolean(tokens[9]));
                DatabaseElement element = new DatabaseElement(electricCar, Integer.parseInt(tokens[10]),
                        Double.parseDouble(tokens[11]));
                carsList.add(element);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
