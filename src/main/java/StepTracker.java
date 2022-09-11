package main.java;
import java.util.Scanner;

public class StepTracker {
    Converter converter = new Converter();
    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    public void takeAmountOfStep() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите номер месяца: ");
        int inputMonth = scanner.nextInt();
        System.out.println("Укажите номер дня: ");
        int inputDay = scanner.nextInt();
        int inputSteps = 0;
        while (true) {
            System.out.println("Укажите количество шагов в этот день: ");
            inputSteps = scanner.nextInt();
            if (inputSteps >= 0) {
                break;
            } else {
                System.out.println("Количество шагов не должно быть отрицательным числом");
            }
        }
        monthToData[inputMonth-1].stepsPerDay[inputDay-1] = inputSteps;
    }

    public int changeAverageSteps() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите цель по количеству шагов: ");
        int changeStep = scanner.nextInt();
        while (true){
            if (changeStep >= 0){
                break;
            } else {
                System.out.println("Введенное значение не должно быть отрицательным числом");
            }
        }
        return changeStep;
    }

    public void statistic(int monthStat){
        for (int i = 0; i < 30; i++) {
                System.out.print( (i+1) + " день: " + monthToData[monthStat-1].stepsPerDay[i] + ", ");
        }
        System.out.println();
    }

    public int sumForMonth(int monthStat){
        int sumSteps = 0;
        for (int i = 0; i < 30; i++) {
            sumSteps = sumSteps + monthToData[monthStat-1].stepsPerDay[i];
        }
        return sumSteps;
    }

    public void sumForMonthPrint(int monthStat){
        System.out.println("Сумма шагов за месяц: " + sumForMonth(monthStat));
    }

    public void maxAmountSteps(int monthStat){
        int maxStep = 0;
        for (int i = 0; i < 30; i++) {
            if(maxStep <= monthToData[monthStat-1].stepsPerDay[i]){
                maxStep = monthToData[monthStat-1].stepsPerDay[i];
            }
        }
        System.out.println("Максимальное пройденное количество шагов: " + maxStep);
    }

    public void averageAmountStep(int monthStat){
        int averageSteps = sumForMonth(monthStat) / 30;
        System.out.println("Среднее количество шагов: " + averageSteps);
    }

    public void distance(int monthStat){
        double dist = sumForMonth(monthStat) * converter.km;
        System.out.println("Пройденная дистанция в км: " + dist);
    }

    public void energy(int monthStat){
        int burnKkal = sumForMonth(monthStat) / converter.kkal;
        System.out.println("Количество сожженных килокалорий: " + burnKkal);
    }

    public void bestResult(int monthStat){
        int result=0;
        for (int i = 0; i < 30; i++) {
            if(monthToData[monthStat-1].stepsPerDay[i] >= 10000){
                result = result + 1;
            }
        }
        System.out.println("Лучшая серия " + result + " дней.");
        System.out.println();
    }

    class MonthData {
        // Заполните класс самостоятельно
        int[] stepsPerDay = new int[30];
    }
}
