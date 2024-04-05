public class Number {

    private final int NumberID;
    private final int Number;
    private boolean issued = false;
    private final String Name;

    public Number(int number, String name, int numberID){
        this.Name = name;
        this.Number = number;
        this.NumberID = numberID;
    }

    public int GetNumber(){
        return Number;
    }

    public int GetNumberID(){
        return NumberID;
    }

    public String GetName(){
        return Name;
    }

    public Boolean GetIssued(){
        return issued;
    }

    public void SetIssued(Boolean issued){
        this.issued = issued;
    }
}
