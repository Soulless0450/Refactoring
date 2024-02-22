public class Main {
    public static void main(String[] args) {
        DeviceFactory factory = getFactoryByCountryCode("En");
        Mouse m = factory.getMouse();
        Keyboard k = factory.getKeyboard();
        Tochpad t = factory.getTouchpad();

        m.click();
        k.print();
        k.println();
        t.track(10, 35);
    }

    private static DeviceFactory getFactoryByCountryCode(String lang) {
        switch (lang) {
            case "Ru":
                return new RuDeviceFactory();
            case "En":
                return new EnDeviceFactory();
            default:
                throw new RuntimeException("Unsupported Country Code" + lang);
        }



    }
}

interface Mouse{
    void click();
    void dublclick();
    void scroll(int direction);
}
interface Keyboard{
    void print();
    void println();
}
interface Tochpad{
    void track(int deltaX, int deltaY);
}
interface DeviceFactory{
    Mouse getMouse();
    Keyboard getKeyboard();
    Tochpad getTouchpad();
}
