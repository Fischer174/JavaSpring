package base.example.Mod3;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private String name;
    private String login;
    private int age;
    private List<String> hobbies;

    public User(String name, String login, int age, List<String> hobbies) {
        this.name = name;
        this.login = login;
        this.age = age;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public int getAge() {
        return age;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    @Override
    public String toString() {
        return "Пользователь: " + name +
                " с логином: " + login +
                ". Его возраст: " + age +
                ". Все хобби:\n" + String.join("\n", hobbies);
    }

}

//