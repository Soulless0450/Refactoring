import java.util.Scanner;

public class Client extends User{

    private int Number = 1;
    private int ClientWallet = 0;
    Scanner scanner = new Scanner(System.in);
    public Client(String fullName, String login, String password) {
        super(fullName, login, password);
    }
    public void ClientCapabilities(){
        while (true){
            System.out.println("1 - Забронировать номер, 2 - Пополнить баланс("+ ClientWallet + " Рублей),3 - Выйти из аккаунта");
            String ClientAction = scanner.next();
            switch (ClientAction){
                case "1":
                    OrderNumber();
                    break;
                case "2":
                    System.out.println("Введите сумму пополнения");
                    try {
                        int ClientInput = Integer.parseInt(scanner.next());
                        this.ClientWallet += ClientInput;
                    } catch(NumberFormatException e) {
                        System.out.println("Ошибка конвертации строки в число: " +e.getMessage());
                        break;
                    }
                    System.out.println("У вас на балансе " + this.ClientWallet + " рублей");
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Ошибка ввода");
                    break;
            }
        }
    }

    public void OrderNumber() {
        while (true) {
            Authentication.ViewHotelNumber();
            System.out.println("\nВведите номер для бронирования(0 - выйти из бронирования)");
            String Selection = scanner.next();
            int intSelection = Integer.parseInt(Selection);
            if (intSelection == 0){
                break;
            }
            for (HotelNumber hotelNumber : Authentication.hotelNumbers) {
                if (intSelection == hotelNumber.getHotelNumber() && ClientWallet >= hotelNumber.getPrice() && hotelNumber.getFreedom()){
                    hotelNumber.setFreedom(false);
                    Authentication.numbers.add(new Number(hotelNumber.getHotelNumber(),this.GetFullName(), Number));
                    Number++;
                    ClientWallet -= hotelNumber.getPrice();
                    System.out.println("Номер забронирован, ожидайте выдачи талона");
                    return;
                }
                else if (intSelection == hotelNumber.getHotelNumber() && ClientWallet < hotelNumber.getPrice() && hotelNumber.getFreedom()){
                    System.out.println("У вас недостаточно средств");
                    break;
                }
                else if (intSelection == hotelNumber.getHotelNumber() && !hotelNumber.getFreedom()){
                    System.out.println("Номер занят");
                    break;
                }
            }
        }
    }
}
