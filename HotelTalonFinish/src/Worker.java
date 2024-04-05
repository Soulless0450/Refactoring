import java.util.Scanner;

public class Worker extends User{
    private final String Speciality;
    Scanner scanner = new Scanner(System.in);
    public Worker(String fullName, String login, String password, String speciality) {
        super(fullName, login, password);
        this.Speciality = speciality;
    }
    public void WorkerCapabilities() {
        while (true) {
            System.out.println("1 - Выдать талон, 2 - Выйти из аккаунта");
            String WorkerAction = scanner.next();
            switch (WorkerAction) {
                case "1":
                    while (true){
                        Authentication.ViewCoupons();
                        System.out.println("1 - Выбрать номер талона, 2 - Выйти");
                        String choice = scanner.next();
                        switch (choice){
                            case "1":
                                System.out.println("Введите номер талона для выдачи");
                                int TalonNumber = Integer.parseInt(scanner.next());
                                for (Number number : Authentication.numbers) {
                                    if (TalonNumber == number.GetNumberID()){
                                        if (!number.GetIssued()) {
                                            number.SetIssued(true);
                                            break;
                                        } else if (number.GetIssued()) {
                                            System.out.println("Талон уже выдан");
                                        }
                                    }
                                }
                                break;
                            case "2":
                                return;
                        }
                    }
                case "2":
                    return;
                default:
                    System.out.println("Ошибка ввода");
                    break;
            }
        }
    }
    public String GetSpeciality(){
        return Speciality;
    }
}
