import java.util.Scanner;
public class Administrator extends User {
    Scanner scanner = new Scanner(System.in);
    public Administrator(String fullName, String login, String password) {
        super(fullName, login, password);
    }

    public void AdminCapabilities() {
        while (true) {
            System.out.println("1 - Добавить админа, 2 - Добавить работника, 3 - Список пользователей, 4 - Список номеров, 5 - Выйти из аккаунта");
            String AdminAction = scanner.next();
            switch (AdminAction) {
                case "1":
                    System.out.println("Добавление админа");
                    AddAdmin();
                    break;
                case "2":
                    System.out.println("Добавление работника");
                    AddWorker();
                    break;
                case "3":
                    System.out.println("Просмотр пользователетей");
                    Authentication.ViewUser();
                    break;
                case "4":
                    System.out.println("Просмотр номеров отеля");
                    Authentication.ViewHotelNumber();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Ошибка ввода");
                    break;
            }
        }
    }
    public void AddAdmin() {
        while (true) {
            System.out.println("Введите фамилию");
            String Surname = scanner.next();
            System.out.println("Введите имя");
            String Name = scanner.next();
            System.out.println("Введите отчество");
            String Patronymic = scanner.next();
            String FullName = Surname + " " + Name + " " + Patronymic;
            System.out.println("Введите логин");
            String Login = scanner.next().toLowerCase();
            System.out.println("Введите пароль");
            String Password = scanner.next();
            System.out.println("Введите пароль ещё раз");
            String AgainPassword = scanner.next();
            if (AgainPassword.equals(Password)) {
                boolean UserDetect = false;
                for (User user : Authentication.users) {
                    if (user.GetLogin().equals(Login)) {
                        UserDetect = true;
                        System.out.println("Пользователь с таким логином уже существует");
                    }
                }
                if (!UserDetect) {
                    Authentication.users.add(new Administrator(FullName, Login, Password));
                    System.out.println("Админ добавлен");
                    break;
                }
            } else {
                System.out.println("Неверный пароль");
            }
        }
    }
    public void AddWorker() {
        while (true) {
            System.out.println("Введите фамилию");
            String Surname = scanner.next();
            System.out.println("Введите имя");
            String Name = scanner.next();
            System.out.println("Введите отчество");
            String Patronymic = scanner.next();
            String FullName = Surname + " " + Name + " " + Patronymic;
            scanner.nextLine();
            System.out.println("Введите должность");
            String JobTitle = scanner.nextLine();
            System.out.println("Введите логин");
            String Login = scanner.next().toLowerCase();
            System.out.println("Введите пароль");
            String Password = scanner.next();
            System.out.println("Введите пароль ещё раз");
            String AgainPassword = scanner.next();
            if (AgainPassword.equals(Password)) {
                boolean UserDetect = false;
                for (User user : Authentication.users) {
                    if (user.GetLogin().equals(Login)) {
                        UserDetect = true;
                        System.out.println("Пользователь с таким логином уже существует");
                    }
                }
                if (!UserDetect) {
                    Authentication.users.add(new Worker(FullName, Login, Password, JobTitle));
                    System.out.println("Работник добавлен");
                    break;
                }
            } else {
                System.out.println("Неверный пароль");
            }
        }
    }
}