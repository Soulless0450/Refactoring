public class MaxLimit extends  ValidateTransaction{

    public void check(MoneyTransaction moneyTransaction) {
        if (moneyTransaction.getAmount() > 10000) {
            System.out.println("Превышен макс. размер транкзации");
        }
    }
}
