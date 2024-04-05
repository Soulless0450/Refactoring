import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean Running = true;
        Scanner scanner = new Scanner(System.in);
        Authentication auth = new Authentication();
        while (Running){
            System.out.println("1 - Регистрация, 2 - Вход, 3 - Выключить систему");
            String UserAction = scanner.next();
            switch (UserAction){
                case "1":
                    System.out.println("Регистрация");
                    auth.SignUP();
                    break;
                case "2":
                    System.out.println("Авторизация");
                    auth.SignIN();
                    break;
                case "3":
                    Running = false;
                    break;
                default:
                    System.out.println("Неверная операция");
                    break;
            }
        }
    }
}
