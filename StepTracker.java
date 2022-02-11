import java.util.HashMap;

public class StepTracker {
    int goalForSteps = 10000;
    HashMap<Integer, MonthData> monthToData = new HashMap<Integer, MonthData>();

    public StepTracker() {
        for (int i = 1; i <= 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    void updateStatistics(int month, int day, int steps) {
        MonthData monthInfo = monthToData.get(month);
        monthInfo.addSteps(day, steps);
    }

    void printStatistics(int month) {
        MonthData monthData = monthToData.get(month);
        for (int i = 1; i <= 30; i++) {
            System.out.println("День " + i + ". Количество шагов " + monthToData.get(month).stepsPerDay.get(i) + ".");
        }
    }

    void bestDays(int month) {
        int max = 0;
        int bestDays = 0;
        for (int i = 1; i <= 30; i++) {
            if (monthToData.get(month).stepsPerDay.get(i) >= goalForSteps) {
                bestDays++;
            } else {
                if (bestDays > max) {
                    max = bestDays;
                }
                bestDays = 0;
            }
        }
                System.out.println(max + " - дней подряд вы достигали или превышали цель.");
    }
}

    class MonthData {
        HashMap<Integer, Integer> stepsPerDay = new HashMap<>();

        //StepTracker stepTracker;
        public MonthData() {
            for (int i = 1; i <= 30; i++) {
                stepsPerDay.put(i, 0);
            }
        }

        void addSteps(int day, int steps) {
            stepsPerDay.put(day, steps);
        }

        int countSteps() {
            int sum = 0;
            for (int d : stepsPerDay.values()) {
                sum = sum + d;
            }
            return sum;
        }

        Integer maxSteps() {
            Integer maxSteps = 0;
            for (Integer steps : stepsPerDay.values()) {
                if (steps > maxSteps) {
                    maxSteps = steps;
                }
            }
            return maxSteps;
        }

        int averageSteps() {
            int sum = 0;
            for (int d : stepsPerDay.values()) {
                sum = sum + d;
            }
            int averageAm = sum / 30;
            return averageAm;
        }

        void convertSteps() {
            Converter converter = new Converter();
            int sum = 0;
            for (int d : stepsPerDay.values()) {
                sum = sum + d;
            }
            System.out.println("За месяц вы прошли: " + converter.convertIntoKm(sum) + " километров и потратили " + converter.convertIntoCalories(sum) + " килокалорий");
        }

    }
