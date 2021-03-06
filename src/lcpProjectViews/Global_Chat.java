/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcpProjectViews;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextArea;

/**
 *
 * @author Berkay
 */
public class Global_Chat extends javax.swing.JFrame {

    /**
     * Creates new form Global_Chat
     */
    
    public ArrayList<String> users = new ArrayList<>();    
    Socket sock;
    BufferedReader reader;
    PrintWriter writer;
    public static DefaultListModel<String> model;
    
    
    String ip_adress = SocketManager.IP_ADRESS;
    int portNumber = SocketManager.PORT_GLOBAL;
    
    
    
    
    public Global_Chat() {
        
        initComponents();
        forOmer();       
        initialized();
        
    }   
    
    
    
    public void forOmer(){
        try {
                    sock = new Socket(ip_adress, portNumber);
                    InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
                    reader = new BufferedReader(streamReader);
                    writer = new PrintWriter(sock.getOutputStream());
                    String temp = User.LoggedUSER.getUserName() + ":" + "has connected." + ":" + "Connect";
                    writer.println(temp);
                    writer.flush();
                } catch (Exception e) {
                    System.err.println("Cannot Connect...");
                }
        ListenThread();
    }
    public  void initialized(){
        setResizable(false);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);
        txt_area.setEditable(false);
    }
    
   
    
   public class IncomingReader implements Runnable
    {
        @Override
        public void run() 
        {
            String[] data;
            String stream;

            try 
            {
                while (!(stream = reader.readLine()).equals("")) 
                {
                     data = stream.split(":");
                     System.err.println(stream);
                     
                     
                     
                      if (data[2].equals("Chat")) 
                     {
                        txt_area.append(data[0] + ": " + data[1] + "\n");
                        txt_area.setCaretPosition(txt_area.getDocument().getLength());
                     } 
                     else if (data[2].equals("Connect"))
                     {
                        txt_area.removeAll();
                        addUser(data[0]);
                         System.err.println("connecte girdi");
                     } 
                     else if (data[2].equals("Disconnect")) 
                     {
                         removeUser(data[0]);
                     } 
                     else if (data[2].equals("Done")) 
                     {
                        writeUser();
                        users.clear();
                     }
                     else{
                          System.err.println("bakalım");
                     }                     
                }
           }catch(Exception e) {
               e.printStackTrace();
           }
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        center_panel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_area = new javax.swing.JTextArea();
        txt_msg = new javax.swing.JTextField();
        btn_send = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        west_panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        user_list = new javax.swing.JList<>();
        btn_announ = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        btn_back = new javax.swing.JButton();
        name_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_area.setColumns(20);
        txt_area.setRows(5);
        jScrollPane2.setViewportView(txt_area);

        txt_msg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_msgMouseClicked(evt);
            }
        });
        txt_msg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_msgKeyPressed(evt);
            }
        });

        btn_send.setText("Send");
        btn_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout center_panelLayout = new javax.swing.GroupLayout(center_panel);
        center_panel.setLayout(center_panelLayout);
        center_panelLayout.setHorizontalGroup(
            center_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(center_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(center_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane2)
                    .addGroup(center_panelLayout.createSequentialGroup()
                        .addComponent(txt_msg, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_send, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)))
                .addContainerGap())
        );
        center_panelLayout.setVerticalGroup(
            center_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(center_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(center_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_msg)
                    .addComponent(btn_send, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        getContentPane().add(center_panel, java.awt.BorderLayout.CENTER);

        jScrollPane1.setViewportView(user_list);

        btn_announ.setText("Announcements");
        btn_announ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_announMouseClicked(evt);
            }
        });

        jToolBar1.setRollover(true);

        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lcpProjectViews/Logos/direction.png"))); // NOI18N
        btn_back.setFocusable(false);
        btn_back.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_back.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_back);
        jToolBar1.add(name_label);

        javax.swing.GroupLayout west_panelLayout = new javax.swing.GroupLayout(west_panel);
        west_panel.setLayout(west_panelLayout);
        west_panelLayout.setHorizontalGroup(
            west_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(west_panelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(west_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_announ, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                .addContainerGap())
        );
        west_panelLayout.setVerticalGroup(
            west_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, west_panelLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_announ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(west_panel, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_msgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_msgMouseClicked

    }//GEN-LAST:event_txt_msgMouseClicked

    private void btn_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendActionPerformed

        String nothing = "";
        if((txt_msg.getText()).equals(nothing)){
            txt_msg.setText("");
            txt_msg.requestFocus();
        }
        else{
            try {
                writer.println(User.LoggedUSER.getUserName() + ":" + txt_msg.getText() + ":" + "Chat");
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
                txt_area.append("Message was not sent !!\n");
            }
            txt_msg.setText(nothing);
            txt_msg.requestFocus();
        }
        txt_msg.setText(nothing);
            txt_msg.requestFocus();
    }//GEN-LAST:event_btn_sendActionPerformed

    private void btn_announMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_announMouseClicked
        //setVisible(false);
        if(User.LoggedUSER.isPresident()){
            GlobalPresidentAnnouncements globalPresident = new GlobalPresidentAnnouncements();
            globalPresident.setVisible(true);
        }else{
            Global_Chat_Announcements globalChatAnnouncements = new Global_Chat_Announcements();
            globalChatAnnouncements.setVisible(true);
        }
        
    }//GEN-LAST:event_btn_announMouseClicked

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        disconnectedSend();
        Disconnect();
        dispose();
        Chat_Selection chatselect = new Chat_Selection();
        chatselect.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void txt_msgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_msgKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            String nothing = "";
        if((txt_msg.getText()).equals(nothing)){
            txt_msg.setText("");
            txt_msg.requestFocus();
        }
        else{
            try {
                writer.println(User.LoggedUSER.getUserName() + ":" + txt_msg.getText() + ":" + "Chat");
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
                txt_area.append("Message was not sent !!\n");
            }
            txt_msg.setText(nothing);
            txt_msg.requestFocus();
        }
        txt_msg.setText(nothing);
            txt_msg.requestFocus();
        }
    }//GEN-LAST:event_txt_msgKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
         
      

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Global_Chat().setVisible(true);
               
                
               
            }
        });
    }
    
    
    public void ListenThread(){
        Thread IncomingReader = new Thread(new IncomingReader());
        IncomingReader.start();
    }
    
    public void addUser(String data){
        users.add(data);
    }
    
    public void removeUser(String data){
        txt_area.append(data + " is disconnected");
    }
    
    public void writeUser(){
        model = new DefaultListModel<>();
        user_list.setModel(model);
        for(String member : users){
            model.addElement(member);
        }
    }
    
    public void disconnectedSend(){
        String dc = (User.LoggedUSER.getUserName() + ": :Disconnect");
        try {
            writer.println(dc);
            writer.flush();
        } catch (Exception e) {
            txt_area.append("Cannot send messages...");
        }
    }
    
    public void Disconnect(){
        try {
            txt_area.append("Disconnected\n");
            sock.close();
        } catch (Exception e) {
            txt_area.append("Cannot disconnect");
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_announ;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_send;
    private javax.swing.JPanel center_panel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel name_label;
    private javax.swing.JTextArea txt_area;
    private javax.swing.JTextField txt_msg;
    public static javax.swing.JList<String> user_list;
    private javax.swing.JPanel west_panel;
    // End of variables declaration//GEN-END:variables
}
