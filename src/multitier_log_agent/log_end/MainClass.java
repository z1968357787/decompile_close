package multitier_log_agent.log_end;

import java.net.UnknownHostException;

public class MainClass {
    public static void main(String[] args) throws UnknownHostException {
        LogClient.doInit();
        new MyFrame();
    }
}
