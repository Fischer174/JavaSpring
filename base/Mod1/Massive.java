package base.example.Mod1;

public class Massive {
    public static void main(String[] args) {
        int[][] x = {{20, 34, 2}, {9, 12, 18}, {3, 4, 5}};
        int min = findMin(x);
        System.out.println("Минимальный элемент в массиве: " + min);
    }

    public static int findMin(int[][] array) {
        int min = array[0][0];  // Инициализируем переменную min
        for (int i = 0; i < array.length; i++) {  // Цикл по строкам массива
            for (int j = 0; j < array[i].length; j++) {  // Цикл по столбцам массива
                if (array[i][j] < min) {  // Сравниваем текущий элемент с минимальным элементом
                    min = array[i][j];  // Если текущий элемент меньше, обновляем min
                }
            }
        }
        return min;
    }
}
