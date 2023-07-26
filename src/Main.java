import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

// Start    :24.07.23 15:47
// Pause    :0
// Finish   :24.07.23 17:12
public class Main {
    public static void main(String[] args) {
        System.out.println("Домашнее задание №7");
        System.out.println("Циклические операторы. Урок 2");
        int taskNumberRun;
        try {
            taskNumberRun = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Какое задание нужно выполнить? (1-10)"));
        } catch (Exception e) {
            taskNumberRun = 0;
            //e.printStackTrace(); // Выводит сообщение об ошибке
        }
        switch (taskNumberRun) {
            case 1 -> task1();    //Задание 1
//            case 2 -> task2();    //Задание 2
//            case 3 -> task3();    //Задание 3
//            case 4 -> task4();    //Задание 4
//            case 5 -> task5();    //Задание 5
//            case 6 -> task6();    //Задание 6
//            case 7 -> task7();    //Задание 7
//            case 8 -> task8();    //Задание 8
//            case 9 -> task9();    //Задание 9
            case 10 -> task10();    //Задание 10
            default -> System.out.println("Вы не выбрали задание!?: " + taskNumberRun);
        }
        System.out.println("_________");
        System.out.println("Домашка закончилась. Всем спасибо, все свободны.");
    }

    private static void task1() {
        System.out.println("Задание 1");
        // Вычислить накопительныйй вклад, без процентный, пополнение 15000/мес.
        // Вывести результат: «Месяц …, сумма накоплений равна … рублей»
        // #15:52-16:08
        //Инициализация
        int vkladFinish = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Какую сумму желаете накопить?"));
        int vkladMount = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Какую сумму готовы откладывать?"));
        int total = 0, mount = 0;
        //Вычисление
        while (total<=vkladFinish) {
            total=total+vkladMount;
            mount++;
        }
        System.out.println("Через "+mount+" месяцев вы накопите нужную сумму равную "+total+" рублей.");
    }

    private static void task10() {
        System.out.println("Задание 10");
        // Напишите программу, которая выводит в консоль таблицу умножения.
        // #17:11
        //Инициализация
        String outLine = "X\\Y \t";
        int focusTableX = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Среднее значение таблицы умножения Х=?"));
        int focusTableY = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Среднее значение таблицы умножения Y=?"));
        int radiusTable = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Радиус таблицы R=? [1-5]"));
        int startX = focusTableX-radiusTable, startY = focusTableY-radiusTable,
                stopX = focusTableX+radiusTable, stopY = focusTableY+radiusTable,
                gradientX = 1, gradientY = 1;
        //Решение
        for (int Yh = startY; Yh <= stopY; Yh++) outLine=outLine+Yh+"\t";
        System.out.println(outLine);
        for (int X=startX; X <= stopX; X++) {
            outLine = ""+X+"\t\t";
            for (int Y=startY; Y <= stopY; Y++) {
                outLine = outLine + X * Y + "\t";
            }
            //Вывод
            System.out.println(outLine);

        }
    }
}