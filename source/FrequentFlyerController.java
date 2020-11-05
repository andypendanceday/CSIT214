package source;

import java.util.ArrayList;
//import java.io.File;
import java.io.IOException;
//import java.util.Scanner;

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
    
    //Had issues with io.File - my java is rusty, implementation was only for demonstration anyway
    protected void getUsersFromFile() throws IOException
    {
        users.add(new User("Justin", "Timberlake", "20/05/1997", "12 Crymeriver St, Wollongong", "jtnoodlehair@gmail.com"));
        users.add(new User("Jayden", "Fish", "17/09/1990", "24 Curtis Lane, St Marys", "fishy@gmail.com"));
        users.add(new User("Andrew", "Andre", "09/09/1997", "3 Church Hill Rd, Lethbridge Park", "andyande@gmail.com"));
        users.add(new User("Levi", "Ackerman", "04/07/1985", "13 Wallmaria Ave, Sydney", "scoutreg@gmail.com"));
        /*
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

        scan.close();*/
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

    public void demonstrate()
    {
        memberships.get(0).spendPoints(1560);
        memberships.get(1).addPoints(3470);
        memberships.get(2).spendPoints(450);
        memberships.get(3).addPoints(10000);
        displayMemberships();
    }
}