public class RuTochpad implements Tochpad{
    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaY, 2));
        System.out.println("Передвинуть на " + s + "пикселей");
    }
}
