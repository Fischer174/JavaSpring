package base.example.Mod1;

public class SummCalc {
    public static void main(String[] args) {
        int summ = 0; // Инициализация переменной для хранения суммы
        for (int i = 0; i <= 1000; i++) {  // Цикл от 0 до 1000
            if (i % 3 == 0 || i % 5 == 0) {  // Проверка кратности
                summ += i;  // Прибавление кратного числа
            }
        }
        System.out.println(summ);
    }
}
