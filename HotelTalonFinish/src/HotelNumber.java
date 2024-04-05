public class HotelNumber{
    private final int HotelNumber;
    private final int RoomsNumber;
    private final int Price;
    private boolean Freedom;

    public HotelNumber(int hotelNumber, int roomsNumber, int price, boolean freedom){
        this.HotelNumber = hotelNumber;
        this.RoomsNumber = roomsNumber;
        this.Price = price;
        this.Freedom = freedom;
    }

    public int getHotelNumber(){
        return HotelNumber;
    }

    public int getRoomsNumber(){
        return RoomsNumber;
    }

    public int getPrice(){
        return Price;
    }

    public Boolean getFreedom(){
        return Freedom;
    }

    public void setFreedom(boolean freedom) {
        Freedom = freedom;
    }
}
