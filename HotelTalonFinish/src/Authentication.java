import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Authentication {
    static List<User> users;
    static List<HotelNumber> hotelNumbers;
    static List<Number> numbers;
    Scanner scanner = new Scanner(System.in);
    public Authentication() {
        hotelNumbers = new ArrayList<>();
        numbers = new ArrayList<>();
        hotelNumbers.add(new HotelNumber(1, 3, 3000, true));
        hotelNumbers.add(new HotelNumber(2, 2, 2000, true));
        hotelNumbers.add(new HotelNumber(3, 4, 4000, true));
        hotelNumbers.add(new HotelNumber(4, 1, 1000, true));
        hotelNumbers.add(new HotelNumber(5, 5, 5000, true));
        users = new ArrayList<>();
        users.add(new Administrator("Яценко Даниил Романович", "soulless", "1234"));
    }
    public void SignUP() {
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
                for (User user : users) {
                    if (user.GetLogin().equals(Login)) {
                        UserDetect = true;
                        System.out.println("Пользователь с таким логином уже существует");
                    }
                }
                if (!UserDetect) {
                    users.add(new Client(FullName, Login, Password));
                    System.out.println("Регистация успешна");
                    break;
                }
            } else {
                System.out.println("Неверный пароль");
            }
        }
    }

    public void SignIN() {
        while (true) {
            System.out.println("Введите логин");
            String Login = scanner.next().toLowerCase();
            System.out.println("Введите пароль");
            String Password = scanner.next();
            for (User user : users) {
                if (user.GetLogin().equals(Login) && user.GetPassword().equals(Password)) {
                    System.out.println("Вход успешен");
                    switch (user) {
                        case Client client -> {
                            System.out.println("Вы зашли как клиент");
                            client.ClientCapabilities();
                        }
                        case Worker worker -> {
                            System.out.println("Вы зашли как работник");
                            worker.WorkerCapabilities();
                        }
                        case Administrator administrator -> {
                            System.out.println("Вы зашли как админ");
                            administrator.AdminCapabilities();
                        }
                        default -> System.out.println("Неизвестная ошибка");
                    }
                    return;
                }
            }
            System.out.println("Неверный логин или пароль");
        }
    }

    public static void ViewUser() {
        for (User user : users) {
            switch (user) {
                case Client client -> {
                    int index = users.indexOf(client);
                    System.out.println("ID: " + index);
                    System.out.println("Тип пользователя: Клиент");
                    System.out.println("Пользователь: " + client.GetFullName());
                    System.out.println("Логин: " + client.GetLogin());
                    int number = client.GetPassword().length();
                    String repeatedSymbol = new String(new char[number]).replace('\0', '*');
                    System.out.println("Пароль: "+ repeatedSymbol);
                }
                case Worker worker -> {
                    int index = users.indexOf(worker);
                    System.out.println("ID: " + index);
                    System.out.println("Тип пользователя: Работник");
                    System.out.println("Пользователь: " + worker.GetFullName());
                    System.out.println("Должность: " + worker.GetSpeciality());
                    System.out.println("Логин: " + worker.GetLogin());
                    int number = worker.GetPassword().length();
                    char symbol = '*';
                    String repeatedSymbol = new String(new char[number]).replace('\0', symbol);
                    System.out.println("Пароль: " + repeatedSymbol);
                }
                case Administrator administrator -> {
                    int index = users.indexOf(administrator);
                    System.out.println("ID: " + index);
                    System.out.println("Тип пользователя: Админ");
                    System.out.println("Пользователь: " + administrator.GetFullName());
                    System.out.println("Логин: " + administrator.GetLogin());
                    int number = administrator.GetPassword().length();
                    char symbol = '*';
                    String repeatedSymbol = new String(new char[number]).replace('\0', symbol);
                    System.out.println("Пароль: " + repeatedSymbol);
                }
                default -> System.out.println("Неизвестная ошибка");
            }
        }
        while (true){
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("1 - удалить пользователя, 2 - выйти из списка пользователей ");
            String choise = scanner1.next();
            switch (choise){
                case "1":
                    System.out.println("Введите ID пользователя");
                    int delUser = Integer.parseInt(scanner1.next());
                    if (delUser > 0 && delUser < users.size()){
                        System.out.println("Пользователь удалён");
                        users.remove(delUser);
                        return;
                    }
                    else if (delUser == 0){
                        System.out.println("Нельзя удалить главного админа");
                    }
                    break;
                case "2":
                    return;
            }
        }
    }

    public static void ViewHotelNumber() {
        for (HotelNumber hotelNumber : hotelNumbers) {
            String repeatedSymbol = new String(new char[15]).replace('\0', '-');
            System.out.println(repeatedSymbol);
            System.out.println("Номер: " + hotelNumber.getHotelNumber());
            System.out.println("Число комнат: " + hotelNumber.getRoomsNumber());
            System.out.println("Цена: " + hotelNumber.getPrice());
            boolean freedom = hotelNumber.getFreedom();
            if (freedom) {
                System.out.println("Номер: свободен");
            } else {
                System.out.println("Номер: занят");
            }
            System.out.println(repeatedSymbol);
        }
    }

    public static void ViewCoupons() {
        for (Number number : numbers) {
            String repeatedSymbol = new String(new char[15]).replace('\0', '-');
            System.out.println(repeatedSymbol);
            System.out.println("ID записи: " + number.GetNumberID());
            System.out.println("Клиент: " + number.GetName());
            System.out.println("Талон номера: " + number.GetNumber());
            if (number.GetIssued()){
                System.out.println("Выдан");
            }
            if (!number.GetIssued()){
                System.out.println("Ждёт выдачи");
            }
            System.out.println(repeatedSymbol);
        }
    }
}