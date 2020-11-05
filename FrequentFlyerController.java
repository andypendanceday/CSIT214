package fdafrequentflyer;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FrequentFlyerController
{
    private FrequentFlyerView view;
    private ArrayList<User> users;
    private ArrayList<Membership> memberships;

    public FrequentFlyerController()
    {
        this.view = new FrequentFlyerView();
        this.users = new ArrayList<User>();
        this.memberships = new ArrayList<Membership>();
    }

    protected void getUsersFromFile()
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
            users.add(User(firstName, lastName, dob, address, email));
        }

        scan.close();
    }

    public void createMemberships()
    {
        getUsersFromFile();
        for(User u : users)
        {
            memberships.add(Membership(u));
        }
    }
}