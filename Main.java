import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        MonthData monthData = new MonthData();
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            int command = checkInt();
            while (true) {
                if (command <= 0) {
                    System.out.println("Введите номер команды от 1 до 4");
                    command = checkInt();
                } else {
                    break;
                }
            }
                if (command == 1) {
                    System.out.println("Введите номер месяца от 1 до 12");
                    int month = checkMonth();
                    System.out.println("Введите номер дня от 1 до 30");
                    int day = checkInt();
                    while (true) {
                        if ((day <= 0) || (day > 30)) {
                            System.out.println("Некорректный ввод. Пожалуйста, введите номер дня от 1 до 30");
                            day = checkInt();
                        } else {
                            break;
                        }
                    }
                    System.out.println("Введите количество шагов");
                    int steps = checkInt();
                    while (true) {
                        if (steps < 0) {
                            System.out.println("Некорректный ввод. Пожалуйста, введите положительное число.");
                            steps = checkInt();
                        } else {
                            break;
                        }
                    }
                    stepTracker.updateStatistics(month, day, steps);
                    System.out.println("Продолжайте в том же духе! " + steps + " шагов за " + day + "-й день " + month + "-го месяца сохранено.");
                } else if (command == 2) {
                    System.out.println("Введите номер месяца от 1 до 12");
                    int month = checkMonth();
                    System.out.println("Статистика за месяц: " + month);
                    stepTracker.printStatistics(month);
                    System.out.println("Всего вы прошли " + stepTracker.monthToData.get(month).countSteps() + " шагов.");
                    System.out.println("Максимальное число шагов в день: " + stepTracker.monthToData.get(month).maxSteps());
                    System.out.println("Среднее число шагов: " + stepTracker.monthToData.get(month).averageSteps());
                    stepTracker.monthToData.get(month).convertSteps();
                    stepTracker.bestDays(month);
                } else if (command == 3) {
                    System.out.println("Введите новую цель");
                    int goal = scanner.nextInt();
                    stepTracker.goalForSteps = goal;
                    System.out.println("Цель изменена. Ваша новая цель - " + goal);
                } else if (command == 4) {
                    System.out.println("Программа завершена");
                    break;
                } else {
                    System.out.println("Вы ввели несуществующую команду. Пожалуйста, введите число от 1 до 4.");
                }
            }
            }
    private static int checkInt() {
        Scanner scanner = new Scanner(System.in);
        int number;
        while (true) {
            number = 0;
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                break;
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите положительное число.");
                scanner.next();
            }
        }
        return number;
    }
    private static int checkMonth() {
        int month = checkInt();
        while (true) {
            if ((month <= 0) || (month > 12)) {
                System.out.println("Некорректный ввод. Пожалуйста, введите номер месяца от 1 до 12");
                month = checkInt();
            } else {
                break;
            }
        }
        return month;
    }

        private static void printMenu() {
            System.out.println("Выберите команду");
            System.out.println("1 - Ввести количество шагов за день");
            System.out.println("2 - Напечать статистику за месяц");
            System.out.println("3 - Изменить цель по количеству шагов");
            System.out.println("4 - Выйти из приложения");
        }
    }