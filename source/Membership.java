package source;

public class Membership
{
    private int id;
    private static int counter;
    private User user;
    private String email;
    private int points;
    private MembershipType type;
    private double fee;
    
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

    public int getPoints()
    {
        return points;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }

    public void addPoints(int newPoints)
    {
        this.points += newPoints;
    }

    public MembershipType getType()
    {
        return type;
    }

    //Membership Type dictates fee cost and bonus sign-up points
    public void setType(MembershipType type)
    {
        this.type = type;

        switch(type) {
            case BASIC:
                setFee(100.00);
                addPoints(5000);
                break;

            case EXCLUSIVE:
                setFee(200.00);
                addPoints(8000);
                break;
        }
    }

    public double getFee()
    {
        return fee;
    }

    public void setFee(double fee)
    {
        this.fee = fee;
    }

    public String toString()
    {
        return String.format("User ID: %s \n Name: %s %s \n Email: %s \n Membership Type: %s \n Points: %s", id, user.getFirstName(), user.getLastName(), email, type.toString(), points);
    }
}