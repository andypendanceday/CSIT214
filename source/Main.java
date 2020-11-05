package source;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        FrequentFlyerController controller = new FrequentFlyerController();
        controller.displayMemberships();
        controller.demonstrate();
    }
}
