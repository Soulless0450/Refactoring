public abstract class User{
    private final String Login;
    private final String Password;
    private final String FullName;

    public User(String fullName, String login, String password){
        this.FullName = fullName;
        this.Login = login;
        this.Password = password;
    }
    public String GetLogin(){
        return Login;
    }

    public String GetPassword(){
        return Password;
    }

    public String GetFullName(){
        return FullName;
    }

}
