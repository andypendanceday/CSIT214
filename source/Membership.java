package fdafrequentflyer;

public class Membership
{
    private int id;
    private static int counter;
    private User user;
    private String email;
    private int points;
    
    //Email from user registration is kept in this class as user credential
    public Membership(User user)
    {
        this.id = counter++;
        this.user = user;
        this.email = user.getEmail();
        this.points = 0;
    }

    public int getID()
    {
        return id;
    }

    public void setID(int id)
    {
        this.id = id;
    }

    public String getEmail()
    {
        return email;
    }

    //Sets for user class as well - data parity
    public void setEmail(String email)
    {
        this.email = email;
        user.setEmail(email);
    }

    public void getPoints()
    {
        return points;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }
}