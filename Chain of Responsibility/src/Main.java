public class Main {

    public static void main(String[] args) {
        ValidateTransaction firstValidation = new MinLimit();
        ValidateTransaction secondValidation = new MaxLimit();

        firstValidation.setNext(secondValidation);
        firstValidation.check(new MoneyTransaction(20000));

    }
}