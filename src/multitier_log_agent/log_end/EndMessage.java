package multitier_log_agent.log_end;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class EndMessage implements Externalizable {
    ConfigInfo configInfo;
    String message;

    public EndMessage(ConfigInfo configInfo, String message) {
        this.configInfo = configInfo;
        this.message = message;
    }

    public ConfigInfo getConfigInfo() {
        return configInfo;
    }

    public void setConfigInfo(ConfigInfo configInfo) {
        this.configInfo = configInfo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public void readExternal(ObjectInput in) throws IOException {
        configInfo=new ConfigInfo();
        configInfo.readExternal(in);
        message=in.readUTF();
    }
    public void writeExternal(ObjectOutput out) throws IOException {
        configInfo.writeExternal(out);
        out.writeUTF(message);
    }
    public void fromByteArray(byte[] objectBytes)
            throws ClassNotFoundException, IOException {
        Externalize.fromByteArray(objectBytes, this);
    }
    public byte[] toByteArray() {
        return Externalize.toByteArray(this);
    }
}
