package main.java;

import java.util.Scanner;

public class CaloryTracker {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1){
                stepTracker.takeAmountOfStep();
            } else if (userInput == 2){
                System.out.println("Введите номер месяца, за который нужно вывести статистику: ");
                int monthStat = scanner.nextInt();
                stepTracker.statistic(monthStat);
                stepTracker.sumForMonth(monthStat);
                stepTracker.maxAmountSteps(monthStat);
                stepTracker.averageAmountStep(monthStat);
                stepTracker.distance(monthStat);
                stepTracker.energy(monthStat);
                stepTracker.bestResult(monthStat);
            } else if (userInput == 3){
                stepTracker.changeAverageSteps();
            }else if (userInput == 4){
                break;
            } else {
                System.out.println("Пункт меню отсутствует, просьба ввести цифру от 1 до 4 включительно");
            }
        }
        System.out.println("Программа завершена");
    }
    private static void printMenu() {
        System.out.println("Введите нужную цифру:");
        System.out.println("1. Ввести количество шагов за определённый день;");
        System.out.println("2. Напечатать статистику за определённый месяц;");
        System.out.println("3. Изменить цель по количеству шагов в день;");
        System.out.println("4. Выйти из приложения.");
    }
}