public class Converter {
    int convertIntoKm(int sum) {
        int km = sum * 75 / 100000;
        return km;

    }

    int convertIntoCalories (int sum) {
        int calories = sum * 50 / 1000;
        return calories;
    }
}

