package fdafrequentflyer;

import java.util.ArrayList;

public class FrequentFlyerView
{
    public FrequentFlyerView(){}

    public void displayMemberships(ArrayList<Membership> memberships)
    {
        for(Membership m : memberships)
        {
            System.out.println(m.toString());
        }
    }
}