package client.data;/*..
 * client.data
 * Created by HuynhBaHuy
 * Date 1/13/2022 9:54 AM
 * Description:...
 */

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class Boxchat {
    String username;
    JTextPane boxchat;
    public Boxchat(String username){
        this.username = username;
        boxchat = new JTextPane();
        boxchat.setEditable(false);
    }
    public JTextPane getBoxchat(){
        return boxchat;
    }
    public void receiveMessage(String message){
        StyledDocument doc = boxchat.getStyledDocument();
        SimpleAttributeSet leftAttr = new SimpleAttributeSet();
        StyleConstants.setForeground(leftAttr, Color.BLUE);
        StyleConstants.setAlignment(leftAttr, StyleConstants.ALIGN_LEFT);
        try {
            doc.insertString(doc.getLength(),message+"\n",leftAttr);
        } catch (BadLocationException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void sendMessage(String message){
        StyledDocument doc = boxchat.getStyledDocument();
        SimpleAttributeSet rightAttr = new SimpleAttributeSet();
        StyleConstants.setAlignment(rightAttr, StyleConstants.ALIGN_RIGHT);
        try {
            doc.insertString(doc.getLength(),message+"\n",rightAttr);
        } catch (BadLocationException ex) {
            System.out.println(ex.getMessage());
        }
    }
}