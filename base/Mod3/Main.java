package base.example.Mod3;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Ввод данных от пользователя //
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Введите имя: ");
            String name = reader.readLine();

            System.out.print("Введите логин: ");
            String login = reader.readLine();

            System.out.print("Введите возраст: ");
            int age = Integer.parseInt(reader.readLine());

            System.out.print("Введите хобби через запятую: ");
            List<String> hobbies = Arrays.asList(reader.readLine().split(","));

            User user = new User(name, login, age, hobbies);

            // Сериализация объекта
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.dat"));
            out.writeObject(user);
            out.close();

            // Десериализация объекта
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.dat"));
            User deserializedUser = (User) in.readObject();
            in.close();

            System.out.println(deserializedUser);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
