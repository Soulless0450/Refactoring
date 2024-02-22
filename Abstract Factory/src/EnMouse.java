public class EnMouse implements Mouse{
    @Override
    public void click() {
        System.out.println("Mouse click");

    }

    @Override
    public void dublclick() {
        System.out.println("Mouse double click");
    }

    @Override
    public void scroll(int direction) {
        if(direction>0)
            System.out.println("Scroll up");
        else if(direction<0)
            System.out.println("Scroll down");
        else
            System.out.println("No Scrolling");
    }
}
