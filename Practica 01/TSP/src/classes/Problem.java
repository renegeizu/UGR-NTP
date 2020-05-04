package classes;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Problem {

    // Declaration of Variables

    private ArrayList<City> cities;
    private Pattern pattern;
    private int numberOfCities;

    // -----------------------

    // Initialization Methods

    private void reserveMemory(String url) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(url), StandardCharsets.ISO_8859_1);

        Optional<String> dimension =
                lines
                        .filter(line -> line.contains("DIMENSION"))
                        .findFirst();

        dimension.ifPresentOrElse(
                (obj) -> {
                    String[] split = this.pattern.split(obj);
                    int size = Integer.parseInt(Arrays.asList(split).get(1));

                    this.cities = new ArrayList<>(size);
                },
                () -> this.cities = new ArrayList<>(0)
        );
    }

    private void createCityList(String url) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(url), StandardCharsets.ISO_8859_1);

        lines
                .filter(line -> !line.contains("DIMENSION"))
                .filter(line -> !line.contains("EOF"))
                .filter(line -> !line.trim().equals(""))
                .forEach(line -> {
                    List<String> element = Arrays.asList(this.pattern.split(line.trim()));

                    this.cities.add(new City(element));
                });

        this.numberOfCities = this.cities.size();
    }


    // -----------------------

    // Constructors

    public Problem(String url) throws IOException {
        pattern = Pattern.compile("\\s+");

        reserveMemory(url);
        createCityList(url);
    }

    // -----------------------

    // Getters and Setters

    public int getNumberOfCities() {
        return this.numberOfCities;
    }

    public City getCity(int number) {
        if (this.cities.size() > number) {
            return this.cities.get(number);
        }

        return null;
    }

    public City getCity(String label) {
        return this.cities.stream()
                .filter(city -> city.getLabel().equals(label))
                .findFirst()
                .orElse(null);
    }

    public int getIndex(String label) {
        return this.cities.indexOf(getCity(label));
    }

    public int getIndex(City city) {
        return this.cities.indexOf(city);
    }

    public ArrayList<City> getCities() {
        return this.cities;
    }

    public City getFirstCity() {
        return this.cities.get(0);
    }

    public City getLastCity() {
        return this.cities.get(this.numberOfCities - 1);
    }

}
