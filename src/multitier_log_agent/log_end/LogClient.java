package multitier_log_agent.log_end;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

public class LogClient {
    private static boolean isInit = false;

    private static boolean useTCP = true;

    private static InetAddress ia = null;
    private static final int serverPort = 9126;

    private static DatagramSocket socketUDP = null;

    private static Socket socketTCP = null;

    private static ObjectOutputStream socketOut = null;
    public static void doInit() throws UnknownHostException {
        ia=InetAddress.getByName("localhost");
        if (!isInit) {
            try {
                if (useTCP) {
                    // TCP
                    socketTCP = new Socket(ia, serverPort);
                    socketOut = new ObjectOutputStream(socketTCP.getOutputStream());
                } else {
                    // UDP
                    socketUDP = new DatagramSocket();
                }
                isInit = true;
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void SendEnd(EndMessage endMessage) throws UnknownHostException {
        doInit();
        if (isInit) {
            try {
                if (useTCP) {
                    // TCP
                    synchronized (socketOut) {
                        endMessage.writeExternal(socketOut);
                        socketOut.flush();
                    }
                } else {
                    // UDP
                    byte[] bytes = endMessage.toByteArray();
                    java.net.DatagramPacket dgp = new java.net.DatagramPacket(bytes, bytes.length, ia, serverPort);
                    socketUDP.send(dgp);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
