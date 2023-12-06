package base.example.Mod4;



public class Main {
    public static void main(String[] args) {
        DB db = new DB();
        try {
            db.createTables();
            db.printOrdersForJohn();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}