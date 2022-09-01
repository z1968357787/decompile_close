package multitier_log_agent.log_end;

import java.io.*;

public class ConfigInfo implements Serializable {
    private String version=version_note;
    private String projectName=projectName_note;
    private String useCaseScenario=useCaseScenario_note;

    private static final String version_note="<--log_agent版本号-->";
    private static final String projectName_note="<--项目名称-->";
    private static final String useCaseScenario_note="<--用例场景-->";

    public ConfigInfo(String version, String projectName, String useCaseScenario) {
        this.version = version;
        this.projectName = projectName;
        this.useCaseScenario = useCaseScenario;
    }

    public ConfigInfo() {
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getUseCaseScenario() {
        return useCaseScenario;
    }

    public void setUseCaseScenario(String useCaseScenario) {
        this.useCaseScenario = useCaseScenario;
    }

    public String getVersion_note(){
        return version_note+version;
    }
    private String getProjectName_note(){
        return projectName_note+projectName;
    }
    private String getUseCaseScenario_note(){
        return useCaseScenario_note+useCaseScenario;
    }
    public void OutputBasicInformation(PrintWriter pw){
        String sum=getVersion_note()+"\n"+getProjectName_note()+"\n"+getUseCaseScenario_note();
        pw.println(sum);
        pw.flush();
    }
    public String getFileName(){
        return version+"."+projectName+"."+useCaseScenario+".txt";
    }

    public void readExternal(ObjectInput in) throws IOException {
        version=in.readUTF();
        projectName=in.readUTF();
        useCaseScenario=in.readUTF();
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(version);
        out.writeUTF(projectName);
        out.writeUTF(useCaseScenario);
    }

}
