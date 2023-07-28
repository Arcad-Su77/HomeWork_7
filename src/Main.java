import javax.swing.*;
import java.util.Calendar;

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
            case 2 -> task2();    //Задание 2
            case 3 -> task3();    //Задание 3
            case 4 -> task4();    //Задание 4
            case 5 -> task5();    //Задание 5
            case 6 -> task6();    //Задание 6
            case 7 -> task7();    //Задание 7
            case 8 -> task8();    //Задание 8
            //case 9 -> task9();    //Задание 9
            case 10 -> task10();    //Задание 10
            default -> System.out.println("Вы не выбрали задание!?: " + taskNumberRun);
        }
        System.out.println("_________");
        System.out.println("Домашка закончилась. Всем спасибо, все свободны.");
    }

    private static void task8() {
        System.out.println("Задание 8");
        // Расчитать даты сдаци еженедельных отчетоа, каждую пчтницу..
        // Вывести результат: «Сегодня пятница, ...-е число. Необходимо подготовить отчет»
        // первая пятница dedLine=1..7
        // #13:50-13:55
        //Инициализация
        int yaerBefore = 200;
        int yaerAfter = 100;
        int toYaer = 2023;
        for (int yaer = 0; yaer<=(toYaer+yaerAfter); yaer+=79){
            if ((yaer>= (toYaer-yaerBefore) && yaer <= (toYaer+yaerAfter))) {
                System.out.println("Комета пролетит в: "+yaer);
            }
        }
    }

    private static void task7() {
        System.out.println("Задание 7");
        // Расчитать даты сдаци еженедельных отчетоа, каждую пчтницу..
        // Вывести результат: «Сегодня пятница, ...-е число. Необходимо подготовить отчет»
        // первая пятница dedLine=1..7
        // #00:28-00:40 10:00-13:40
        //Инициализация
        System.out.println("Напоминалка про отчет!");
        int dedLine = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Какой день недели отчетный?  [1-7, 1-ВС..7-СБ]"));
        // Рассчет
        Calendar today = Calendar.getInstance();
        int dayOfMonth = today.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
        String dayOfDedLine = switch ((dedLine-dayOfWeek)) {
            case 0 -> "сегодня";
            case 1,-6 -> "завтра";
            case 2,-5 -> "после завтра";
            case 3,-4 -> "через 3 дня";
            case 4,-3 -> "через 4 дня";
            case 5,-2 -> "через 5 дней";
            case 6,-1 -> "через 6 дней";
            default -> throw new IllegalStateException("Срок сдачи не верен: "
                    + dedLine + " " + dayOfWeek+ " " + ((dedLine+7)-(dayOfWeek)));
        };
        String dedLineOfWeek = switch (dedLine) {
            case 1 -> "воскресенье";
            case 2 -> "понедельник";
            case 3 -> "вторник";
            case 4 -> "среду";
            case 5 -> "четверг";
            case 6 -> "пятницу";
            case 7 -> "субботу";
            default -> throw new IllegalStateException("День сдачи отчета: " + dedLine);
        };
        String week = switch (today.get(Calendar.DAY_OF_WEEK)) {
            case 1 -> "воскресенье";
            case 2 -> "понедельник";
            case 3 -> "вторник";
            case 4 -> "среда";
            case 5 -> "четверг";
            case 6 -> "пятница";
            case 7 -> "суббота";
            default -> throw new IllegalStateException("Unexpected value: " + today.get(Calendar.DAY_OF_WEEK));
        };
        System.out.println("Сегодня " + dayOfMonth + "-e, " + week+ ", отчет сдавать в "
                +dedLineOfWeek+ " - " +dayOfDedLine+"!");

        System.out.println("\n\nРешение по критериям.");
        int dayFerstFR = dedLine; //Введенный день отчета = дата первой пятницы
        for (int day = 1; day<=31; day++){
            if ((dayFerstFR-day) % 7 == 0 || day == dayFerstFR) {
                System.out.println("Сегодня пятница, "+day+"-е число. Необходимо подготовить отчет");
            }
        }
    }

    private static void task6() {
        System.out.println("Задание 6");
        // Вычислить накопительныйй вклад, c 7% в месяц, пополнение 15000/мес.
        // Вывести результат: «Месяц …, сумма накоплений равна … рублей»
        // накопления за 6, 12, 18, 24-й и следующие месяцы за 9 лет.
        // #23:55-00:10
        //Инициализация
        int vkladFinish = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Какую сумму желаете накопить?"));
        int vkladMount = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Какую сумму готовы откладывать?"));
        int vkladProcent = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Какую процентную ставку дает вклад?"));
        int year = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Сколько лет в запасе?"));
        int total = 0, mount = 0;
        //Вычисление

        while ((total<vkladFinish || vkladFinish==0) && (mount/12)<year) {
            total=total+total*vkladProcent/100+vkladMount;
            if (mount % 6 == 0)
                System.out.println("Через "+mount+" месяцев вы накопите нужную сумму равную "+total+" рублей.");
            mount++;
        }
        System.out.println("В итоге, за "+mount+" месяцев вы накопите нужную сумму равную "+total+" рублей.");
    }

    private static void task5() {
        System.out.println("Задание 5");
        // Вычислить накопительныйй вклад, c 7% в месяц, пополнение 15000/мес.
        // Вывести результат: «Месяц …, сумма накоплений равна … рублей»
        // накопления за 6, 12, 18, 24-й и следующие месяцы.
        // #23:34-23:55
        //Инициализация
        int vkladFinish = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Какую сумму желаете накопить?"));
        int vkladMount = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Какую сумму готовы откладывать?"));
        int vkladProcent = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Какую процентную ставку дает вклад?"));
        int total = 0, mount = 0;
        //Вычисление
        while (total<vkladFinish) {
            total=total+total*vkladProcent/100+vkladMount;
            if (mount % 6 == 0)
                System.out.println("Через "+mount+" месяцев вы накопите нужную сумму равную "+total+" рублей.");
            mount++;
        }
        System.out.println("В итоге, за "+mount+" месяцев вы накопите нужную сумму равную "+total+" рублей.");
    }

    private static void task4() {
        System.out.println("Задание 4");
        // Вычислить накопительныйй вклад, c 7% в месяц, пополнение 15000/мес.
        // Вывести результат: «Месяц …, сумма накоплений равна … рублей»
        // #23:24-23:33
        //Инициализация
        int vkladFinish = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Какую сумму желаете накопить?"));
        int vkladMount = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Какую сумму готовы откладывать?"));
        int vkladProcent = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Какую процентную ставку дает вклад?"));
        int total = 0, mount = 0;
        //Вычисление
        while (total<vkladFinish) {
            total=total+total*vkladProcent/100+vkladMount;
            mount++;
        }
        System.out.println("Через "+mount+" месяцев вы накопите нужную сумму равную "+total+" рублей.");
    }

    private static void task3() {
        System.out.println("Задание 3");
        // В стране Y население равно 12 миллионов человек.
        // Рождаемость составляет 17 человек на 1000,
        // смертность — 8 человек.
        // Рассчитайте, какая численность населения будет через 10 лет,
        // если показатели рождаемости и смертности постоянны.
        // В консоль выведите результат операции на каждый год в формате:
        // «Год …, численность населения составляет …».
        // #16:56-17:07
        //Инициализация
        int Y = 12_000_000;
        int dR1000 = 17;
        int dS1000 = 8;
        int stepYear = 1;
        int year = Integer.parseInt(JOptionPane.showInputDialog(null,
                "На сколько лет требуется прогноз?"));
        // Решение
        while (stepYear<=year) {
            Y = Y + Y/1000*dR1000 - Y/1000*dS1000;
            System.out.println("Год "+(stepYear++)+", численность населения составляет "+Y+"!");
        }
    }

    private static void task2() {
        System.out.println("Задание 2");
        // Вывести циклами while и for 2 строки с числами от 1-10
        // 1 2 3 4 5 6 7 8 9 10
        // 10 9 8 7 6 5 4 3 2 1
        // #16:30-16:52
        //Инициализация
        int stepOut = 1;
        String outLine = stepOut+"\t";
        while (stepOut<10) {
            stepOut++;
            outLine=outLine+stepOut+"\t";
        }
        System.out.println(outLine);
        outLine = "";
        for (;stepOut>=1; stepOut--) {
            outLine=outLine+stepOut+"\t";
        }
        System.out.println(outLine);
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
        while (total<vkladFinish) {
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
                stopX = focusTableX+radiusTable, stopY = focusTableY+radiusTable;
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