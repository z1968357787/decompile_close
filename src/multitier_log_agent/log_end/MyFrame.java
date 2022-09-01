package multitier_log_agent.log_end;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;

public class MyFrame extends JFrame {
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    public MyFrame() throws HeadlessException {
        setBounds(500,300,600,200);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        ShowPanel();
    }
    private void ShowPanel(){

        class MyActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                String select=e.getActionCommand();
                String version=jTextField1.getText();
                String projectName=jTextField2.getText();
                String useCaseScenario=jTextField3.getText();
                jTextField1.setText(null);
                jTextField2.setText(null);
                jTextField3.setText(null);
                try {
                    EndMessage endMessage=new EndMessage(new ConfigInfo(version,projectName,useCaseScenario),select);
                    LogClient.SendEnd(endMessage);
                } catch (UnknownHostException ex) {
                    ex.printStackTrace();
                }
            }

        }
        JLabel jLabel1=new JLabel("版本号:");
        JLabel jLabel2=new JLabel("项目名:");
        JLabel jLabel3=new JLabel("用例场景:");
        jLabel1.setBounds(20,50,100,25);
        jLabel1.setFont(new Font("宋体", Font.BOLD, 15));
        jLabel2.setBounds(195,50,100,25);
        jLabel2.setFont(new Font("宋体", Font.BOLD, 15));
        jLabel3.setBounds(350,50,100,25);
        jLabel3.setFont(new Font("宋体", Font.BOLD, 15));

        jTextField1=new JTextField();
        jTextField2=new JTextField();
        jTextField3=new JTextField();
        jTextField1.setBounds(80,50,100,25);
        jTextField1.setFont(new Font("宋体", Font.BOLD, 15));
        jTextField2.setBounds(250,50,100,25);
        jTextField2.setFont(new Font("宋体", Font.BOLD, 15));
        jTextField3.setBounds(420,50,100,25);
        jTextField3.setFont(new Font("宋体", Font.BOLD, 15));

        add(jLabel1);
        add(jLabel2);
        add(jLabel3);
        add(jTextField1);
        add(jTextField2);
        add(jTextField3);

        JButton jButton=new JButton("close");
        jButton.setBounds(250,100,100,25);
        jButton.setFont(new Font("宋体", Font.BOLD, 15));
        MyActionListener myActionListener=new MyActionListener();
        jButton.addActionListener(myActionListener);

        add(jButton);
    }
}
