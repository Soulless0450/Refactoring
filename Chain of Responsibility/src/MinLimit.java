public class MinLimit extends ValidateTransaction {

    public void check(MoneyTransaction moneyTransaction) {
        if (moneyTransaction.getAmount() > 1000) {
            System.out.println("Необходимо ввсти пин-код");
        }

        checkNext(moneyTransaction);
    }
}
