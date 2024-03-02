public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        for(int i = 0; i < 10; i++)
        //Ошибка в 4 строке, магическое число 10, вместо этого нужно использовать array.length
        {
            array[i] = i;
            System.out.println(i);
        }
    }
}