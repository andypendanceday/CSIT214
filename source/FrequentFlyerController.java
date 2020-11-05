package source;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FrequentFlyerController
{
    private FrequentFlyerView view;
    private ArrayList<User> users;
    private ArrayList<Membership> memberships;

    public FrequentFlyerController() throws IOException
    {
        this.view = new FrequentFlyerView();
        this.users = new ArrayList<User>();
        this.memberships = new ArrayList<Membership>();
        createMemberships();
        setTypes();
    }

    protected void getUsersFromFile() throws IOException
    {
        File file = new File("registration.txt");
        Scanner scan = new Scanner(file);

        if(scan.hasNext() == true)
        {
            String firstName = scan.nextLine();
            String lastName = scan.nextLine();
            String dob = scan.nextLine();
            String address = scan.nextLine();
            String email = scan.nextLine();
            users.add(new User(firstName, lastName, dob, address, email));
        }

        scan.close();
    }

    public void createMemberships() throws IOException
    {
        getUsersFromFile();
        for(User u : users)
        {
            memberships.add(new Membership(u));
        }
    }

    public void displayMemberships()
    {
        view.displayMemberships(memberships);
    }

    //Method for demonstration purposes - in practice user would enter desired type at sign-up
    public void setTypes()
    {
        int i = 0;

        for(Membership m : memberships)
        {
            if(i < 2)
            {
                m.setType(MembershipType.BASIC);
            }
            else
            {
                m.setType(MembershipType.EXCLUSIVE);
            }

            i++;
        }
    }
}