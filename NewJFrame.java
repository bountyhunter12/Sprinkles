/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Sprinkles;

import javax.swing.JOptionPane;
import AppPackage.AnimationClass;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author DELL
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    Connection conn;
    Statement stmt =null;
    ResultSet rs=null;
     Vector<String> CartProduct = new Vector<>(); 
    Vector<String>CartType = new Vector<>(); 
    Vector<Integer> CartQuantity = new Vector<>(); 
    Vector<Integer> CartPrice = new Vector<>();
     public double total=0.0;
    private int x=0,y=0;
    private double tax=0;
    private DefaultListModel mod;
    AnimationClass ac = new AnimationClass();
    public NewJFrame() {
        initComponents();
        
       // slidershow();
       conn =DBconnection.getConnection();
       createAndShowGUI();
        this.bindData();
         setTime();
         menu1.add(panel2);
         menu.add(panel);
         mod = new DefaultListModel();
        list.setModel(mod);
    }
    DefaultTableModel model;
    String po = "SELECT CatName FROM category WHERE CatName LIKE ?";
    boolean b = false;
    boolean b1 = false;
    public String[] retrieveSuggestionsFromDatabase(String searchTerm) {
        List<String> suggestionsList = new ArrayList<>();
        
        try (Connection connection = DBconnection.getConnection();
           
             
             PreparedStatement preparedStatement = connection.prepareStatement(po)) {

            if( b1 == true)preparedStatement.setString(1, "%" + searchTerm + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    if( b == false)suggestionsList.add(resultSet.getString("CatName"));
                
                    else suggestionsList.add(resultSet.getString("CatName")+" "+resultSet.getString("Price")+"tk");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suggestionsList.toArray(new String[0]);
    }
    private ArrayList<String> getStars()
    {
    //ArrayList stars=new ArrayList();
        ArrayList<String> stars = new ArrayList<>();

    stars.add("Vanilla Cake");
    stars.add("Cheese Cake");
    stars.add("Chocolate Cake");
    stars.add("Oreo Cake");
    stars.add("Macaron");
    stars.add("Jar Cake");
    stars.add("Cupcake");
    stars.add("Ice-Cream Cake");
    stars.add("Flower HeartBox");
    stars.add("Flower Basket");
    stars.add("Sunflower");
    stars.add("Lilly");
    stars.add("Rose Boquet1");
    stars.add("Pink Roses");
    stars.add("Rose Boquet2");
    stars.add("Hydragaena");
    stars.add("White Roses");
    stars.add("Red Roses");
    stars.add("Orange Cake");
    stars.add("Ferrero Rocher Cake");
   // stars.add("Rose Boquet2");
    return stars;
    }
    private void bindData() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        List<String> starsList = getStars();
        Stream<String> starStream = starsList.stream();
        DefaultListModel<String> defaultListModel = new DefaultListModel<>();

        starStream.forEach((star) -> {
            defaultListModel.addElement(star);
        });
        //ListModel<String> defaultListModel = null;

//        jList1.setModel(defaultListModel);
//        jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }   
class jPanelGradient extends JPanel{
        protected void paintComponent(Graphics g){
            Graphics2D g2d=(Graphics2D) g;
            int width= getWidth();
            int height=getHeight();
            
            Color color1=new Color(4,111,117);
            Color color2=new Color(102,0,102);
            GradientPaint gp=new GradientPaint(0,0,color1,180,height,color2);
            g2d.setPaint(gp);
            g2d.fillRect(0,0,width,height);
        }
        
    }
class jPanelGradient1 extends JPanel{
        protected void paintComponent(Graphics g){
            Graphics2D g2d=(Graphics2D) g;
            int width= getWidth();
            int height=getHeight();
            
            Color color1=new Color(0,102,102);
            Color color2=new Color(51,0,51);
            GradientPaint gp=new GradientPaint(0,0,color1,180,height,color2);
            g2d.setPaint(gp);
            g2d.fillRect(0,0,width,height);
        }
        
    }
class jPanelGradientt extends JPanel{
        protected void paintComponent(Graphics g){
            Graphics2D g2d=(Graphics2D) g;
            int width= getWidth();
            int height=getHeight();
            
            Color color1=new Color(8,61,65);
            Color color2=new Color(51,0,51);
            GradientPaint gp=new GradientPaint(0,0,color1,180,height,color2);
            g2d.setPaint(gp);
            g2d.fillRect(0,0,width,height);
        }
        
    }
ImageIcon page1 = new ImageIcon(getClass().getResource("/Sprinkles/cARD.png"));
    ImageIcon page2 = new ImageIcon(getClass().getResource("/Sprinkles/COVER.png"));
    ImageIcon page3 = new ImageIcon(getClass().getResource("/Sprinkles/adv.png"));
    
     ImageIcon[] imagePaths = {page1,page2,page3};
     int currentIndex = 0; 
        public void createAndShowGUI()
        {
           
          

        
        int delay = 1000; // 2 seconds (in milliseconds)
        Timer timer;
        timer = new Timer(delay, (ActionEvent e) -> {
            // Set the next icon from the array
            
            img1.setIcon(imagePaths[currentIndex]);
            
            
            // Increment the index or loop back to the beginning
            currentIndex = (currentIndex + 1) % imagePaths.length;
        });

        // Start the timer
        timer.start();

        //frame.setVisible(true);
    }
public void init()
    {
        setTime();
    }
    public boolean qtyzero(int qty)
    {
        if(qty==0)
        {
            JOptionPane.showMessageDialog(null,"Please increase the item quantity" );
            return false;
        }
        return true;
    }
    public void reset()
    {
        total = 0.0;
        x=0;
        tax=0.0;
        jButton1.setEnabled(true);
        //jSpinner11.setValue(0);
        //jSpinner12.setValue(0);
        //jSpinner13.setValue(0);
        jSpinner14.setValue(0);
        jSpinner15.setValue(0);
        jSpinner16.setValue(0);
        jSpinner17.setValue(0);
        jSpinner18.setValue(0);
        jSpinner19.setValue(0);
        jSpinner2.setValue(0);
        caktax.setText("0.0");
         caksubtot1.setText("0.0");
          caktot1.setText("0.0");
          memo.setText("");
         // jCheckBox11.setSelected(false);
          //jCheckBox12.setSelected(false);
          //jCheckBox13.setSelected(false);
          //jCheckBox14.setSelected(false);
          jCheckBox15.setSelected(false);
          
          jCheckBox17.setSelected(false);
          jCheckBox18.setSelected(false);
          jCheckBox19.setSelected(false);
          jCheckBox2.setSelected(false);
    }
    public void dudatec(){
        caktax.setText(String.valueOf(tax));
        caksubtot2.setText(String.valueOf(total));
        caktot2.setText(String.valueOf(total+tax));
    }
     public void dudatef(){
        caktax1.setText(String.valueOf(tax));
        caksubtot1.setText(String.valueOf(total));
        caktot1.setText(String.valueOf(total+tax));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        menu = new javax.swing.JPopupMenu();
        panel2 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        rSButtonHover1 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover2 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover3 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover4 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover5 = new rojeru_san.complementos.RSButtonHover();
        jLabel403 = new javax.swing.JLabel();
        rSButtonHover6 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover7 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover8 = new rojeru_san.complementos.RSButtonHover();
        menu1 = new javax.swing.JPopupMenu();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new jPanelGradient();
        jPanel27 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        chocobutton = new javax.swing.JButton();
        flowerbutton = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        container = new javax.swing.JPanel();
        img1 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        ss = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        rSPanelImage2 = new rojerusan.RSPanelImage();
        jPanel1 = new jPanelGradientt();
        title = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel405 = new javax.swing.JLabel();
        jLabel408 = new javax.swing.JLabel();
        jLabel409 = new javax.swing.JLabel();
        jLabel410 = new javax.swing.JLabel();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        rSPanelImage3 = new rojerusan.RSPanelImage();
        jPanel2 = new javax.swing.JPanel();
        jPanel38 = new jPanelGradient();
        jPanel39 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jSpinner14 = new javax.swing.JSpinner();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jPanel40 = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jSpinner15 = new javax.swing.JSpinner();
        jLabel107 = new javax.swing.JLabel();
        jCheckBox15 = new javax.swing.JCheckBox();
        jLabel108 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jSpinner16 = new javax.swing.JSpinner();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel42 = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jSpinner17 = new javax.swing.JSpinner();
        jLabel121 = new javax.swing.JLabel();
        jCheckBox17 = new javax.swing.JCheckBox();
        jLabel122 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jSpinner18 = new javax.swing.JSpinner();
        jLabel128 = new javax.swing.JLabel();
        jCheckBox18 = new javax.swing.JCheckBox();
        jLabel129 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jSpinner19 = new javax.swing.JSpinner();
        jLabel135 = new javax.swing.JLabel();
        jCheckBox19 = new javax.swing.JCheckBox();
        jLabel136 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jSpinner20 = new javax.swing.JSpinner();
        jLabel142 = new javax.swing.JLabel();
        jCheckBox20 = new javax.swing.JCheckBox();
        jLabel143 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jSpinner21 = new javax.swing.JSpinner();
        jLabel149 = new javax.swing.JLabel();
        jCheckBox21 = new javax.swing.JCheckBox();
        jLabel150 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jSpinner22 = new javax.swing.JSpinner();
        jLabel156 = new javax.swing.JLabel();
        jCheckBox22 = new javax.swing.JCheckBox();
        jLabel157 = new javax.swing.JLabel();
        caktax = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        memo = new javax.swing.JTextArea();
        txttime1 = new javax.swing.JLabel();
        txtdate1 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        cart3 = new javax.swing.JButton();
        cart4 = new javax.swing.JButton();
        cart5 = new javax.swing.JButton();
        cart6 = new javax.swing.JButton();
        cart7 = new javax.swing.JButton();
        cart8 = new javax.swing.JButton();
        cart9 = new javax.swing.JButton();
        cart10 = new javax.swing.JButton();
        cart11 = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        caksubtot2 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        caktot2 = new javax.swing.JLabel();
        rSButtonHover9 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover10 = new rojeru_san.complementos.RSButtonHover();
        jPanel8 = new javax.swing.JPanel();
        jPanel48 = new jPanelGradient();
        jPanel49 = new javax.swing.JPanel();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jSpinner23 = new javax.swing.JSpinner();
        jLabel163 = new javax.swing.JLabel();
        jCheckBox23 = new javax.swing.JCheckBox();
        jLabel164 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        jLabel165 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jSpinner24 = new javax.swing.JSpinner();
        jLabel170 = new javax.swing.JLabel();
        jCheckBox24 = new javax.swing.JCheckBox();
        jLabel171 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jLabel172 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jSpinner25 = new javax.swing.JSpinner();
        jLabel177 = new javax.swing.JLabel();
        jCheckBox25 = new javax.swing.JCheckBox();
        jLabel178 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        jLabel179 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        jLabel181 = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
        jSpinner26 = new javax.swing.JSpinner();
        jLabel184 = new javax.swing.JLabel();
        jCheckBox26 = new javax.swing.JCheckBox();
        jLabel185 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        jLabel186 = new javax.swing.JLabel();
        jLabel187 = new javax.swing.JLabel();
        jLabel188 = new javax.swing.JLabel();
        jLabel189 = new javax.swing.JLabel();
        jLabel190 = new javax.swing.JLabel();
        jSpinner27 = new javax.swing.JSpinner();
        jLabel191 = new javax.swing.JLabel();
        jCheckBox27 = new javax.swing.JCheckBox();
        jLabel192 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jLabel193 = new javax.swing.JLabel();
        jLabel194 = new javax.swing.JLabel();
        jLabel195 = new javax.swing.JLabel();
        jLabel196 = new javax.swing.JLabel();
        jLabel197 = new javax.swing.JLabel();
        jSpinner28 = new javax.swing.JSpinner();
        jLabel198 = new javax.swing.JLabel();
        jCheckBox28 = new javax.swing.JCheckBox();
        jLabel199 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        jLabel200 = new javax.swing.JLabel();
        jLabel201 = new javax.swing.JLabel();
        jLabel202 = new javax.swing.JLabel();
        jLabel203 = new javax.swing.JLabel();
        jLabel204 = new javax.swing.JLabel();
        jSpinner29 = new javax.swing.JSpinner();
        jLabel205 = new javax.swing.JLabel();
        jCheckBox29 = new javax.swing.JCheckBox();
        jLabel206 = new javax.swing.JLabel();
        jPanel56 = new javax.swing.JPanel();
        jLabel207 = new javax.swing.JLabel();
        jLabel208 = new javax.swing.JLabel();
        jLabel209 = new javax.swing.JLabel();
        jLabel210 = new javax.swing.JLabel();
        jLabel211 = new javax.swing.JLabel();
        jSpinner30 = new javax.swing.JSpinner();
        jLabel212 = new javax.swing.JLabel();
        jCheckBox30 = new javax.swing.JCheckBox();
        jLabel213 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel22 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        caksubtot1 = new javax.swing.JTextField();
        caktot1 = new javax.swing.JTextField();
        caktax1 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        memo1 = new javax.swing.JTextArea();
        txttime = new javax.swing.JLabel();
        txtdate = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        rSButtonHover11 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover12 = new rojeru_san.complementos.RSButtonHover();
        jPanel6 = new jPanelGradient();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel7 = new jPanelGradient();
        jLabel11 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel10 = new jPanelGradient();
        jPanel57 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel214 = new javax.swing.JLabel();
        jLabel215 = new javax.swing.JLabel();
        jLabel216 = new javax.swing.JLabel();
        jLabel217 = new javax.swing.JLabel();
        jLabel218 = new javax.swing.JLabel();
        jSpinner31 = new javax.swing.JSpinner();
        jLabel219 = new javax.swing.JLabel();
        jCheckBox31 = new javax.swing.JCheckBox();
        jLabel220 = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jLabel221 = new javax.swing.JLabel();
        jLabel222 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        jLabel225 = new javax.swing.JLabel();
        jSpinner32 = new javax.swing.JSpinner();
        jLabel226 = new javax.swing.JLabel();
        jCheckBox32 = new javax.swing.JCheckBox();
        jLabel227 = new javax.swing.JLabel();
        jPanel59 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jLabel228 = new javax.swing.JLabel();
        jLabel229 = new javax.swing.JLabel();
        jLabel230 = new javax.swing.JLabel();
        jLabel231 = new javax.swing.JLabel();
        jLabel232 = new javax.swing.JLabel();
        jSpinner33 = new javax.swing.JSpinner();
        jLabel233 = new javax.swing.JLabel();
        jCheckBox33 = new javax.swing.JCheckBox();
        jLabel234 = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jLabel235 = new javax.swing.JLabel();
        jLabel236 = new javax.swing.JLabel();
        jLabel237 = new javax.swing.JLabel();
        jLabel238 = new javax.swing.JLabel();
        jLabel239 = new javax.swing.JLabel();
        jSpinner34 = new javax.swing.JSpinner();
        jLabel240 = new javax.swing.JLabel();
        jCheckBox34 = new javax.swing.JCheckBox();
        jLabel241 = new javax.swing.JLabel();
        jPanel61 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jLabel242 = new javax.swing.JLabel();
        jLabel243 = new javax.swing.JLabel();
        jLabel244 = new javax.swing.JLabel();
        jLabel245 = new javax.swing.JLabel();
        jLabel246 = new javax.swing.JLabel();
        jSpinner35 = new javax.swing.JSpinner();
        jLabel247 = new javax.swing.JLabel();
        jCheckBox35 = new javax.swing.JCheckBox();
        jLabel248 = new javax.swing.JLabel();
        jPanel62 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jLabel249 = new javax.swing.JLabel();
        jLabel250 = new javax.swing.JLabel();
        jLabel251 = new javax.swing.JLabel();
        jLabel252 = new javax.swing.JLabel();
        jLabel253 = new javax.swing.JLabel();
        jSpinner36 = new javax.swing.JSpinner();
        jLabel254 = new javax.swing.JLabel();
        jCheckBox36 = new javax.swing.JCheckBox();
        jLabel255 = new javax.swing.JLabel();
        jPanel63 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel256 = new javax.swing.JLabel();
        jLabel257 = new javax.swing.JLabel();
        jLabel258 = new javax.swing.JLabel();
        jLabel259 = new javax.swing.JLabel();
        jLabel260 = new javax.swing.JLabel();
        jSpinner37 = new javax.swing.JSpinner();
        jLabel261 = new javax.swing.JLabel();
        jCheckBox37 = new javax.swing.JCheckBox();
        jLabel262 = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jLabel263 = new javax.swing.JLabel();
        jLabel264 = new javax.swing.JLabel();
        jLabel265 = new javax.swing.JLabel();
        jLabel266 = new javax.swing.JLabel();
        jLabel267 = new javax.swing.JLabel();
        jSpinner38 = new javax.swing.JSpinner();
        jLabel268 = new javax.swing.JLabel();
        jCheckBox38 = new javax.swing.JCheckBox();
        jLabel269 = new javax.swing.JLabel();
        jPanel65 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel270 = new javax.swing.JLabel();
        jLabel271 = new javax.swing.JLabel();
        jLabel272 = new javax.swing.JLabel();
        jLabel273 = new javax.swing.JLabel();
        jLabel274 = new javax.swing.JLabel();
        jSpinner39 = new javax.swing.JSpinner();
        jLabel275 = new javax.swing.JLabel();
        jCheckBox39 = new javax.swing.JCheckBox();
        jLabel276 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel11 = new jPanelGradientt();
        jPanel66 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jLabel277 = new javax.swing.JLabel();
        jLabel278 = new javax.swing.JLabel();
        jLabel279 = new javax.swing.JLabel();
        jLabel280 = new javax.swing.JLabel();
        jLabel281 = new javax.swing.JLabel();
        jSpinner40 = new javax.swing.JSpinner();
        jLabel282 = new javax.swing.JLabel();
        jCheckBox40 = new javax.swing.JCheckBox();
        jLabel283 = new javax.swing.JLabel();
        jPanel67 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jLabel284 = new javax.swing.JLabel();
        jLabel285 = new javax.swing.JLabel();
        jLabel286 = new javax.swing.JLabel();
        jLabel287 = new javax.swing.JLabel();
        jLabel288 = new javax.swing.JLabel();
        jSpinner41 = new javax.swing.JSpinner();
        jLabel289 = new javax.swing.JLabel();
        jCheckBox41 = new javax.swing.JCheckBox();
        jLabel290 = new javax.swing.JLabel();
        jPanel68 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel291 = new javax.swing.JLabel();
        jLabel292 = new javax.swing.JLabel();
        jLabel293 = new javax.swing.JLabel();
        jLabel294 = new javax.swing.JLabel();
        jLabel295 = new javax.swing.JLabel();
        jSpinner42 = new javax.swing.JSpinner();
        jLabel296 = new javax.swing.JLabel();
        jCheckBox42 = new javax.swing.JCheckBox();
        jLabel297 = new javax.swing.JLabel();
        jPanel69 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jLabel298 = new javax.swing.JLabel();
        jLabel299 = new javax.swing.JLabel();
        jLabel300 = new javax.swing.JLabel();
        jLabel301 = new javax.swing.JLabel();
        jLabel302 = new javax.swing.JLabel();
        jSpinner43 = new javax.swing.JSpinner();
        jLabel303 = new javax.swing.JLabel();
        jCheckBox43 = new javax.swing.JCheckBox();
        jLabel304 = new javax.swing.JLabel();
        jPanel70 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel305 = new javax.swing.JLabel();
        jLabel306 = new javax.swing.JLabel();
        jLabel307 = new javax.swing.JLabel();
        jLabel308 = new javax.swing.JLabel();
        jLabel309 = new javax.swing.JLabel();
        jSpinner44 = new javax.swing.JSpinner();
        jLabel310 = new javax.swing.JLabel();
        jCheckBox44 = new javax.swing.JCheckBox();
        jLabel311 = new javax.swing.JLabel();
        jPanel71 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jLabel312 = new javax.swing.JLabel();
        jLabel313 = new javax.swing.JLabel();
        jLabel314 = new javax.swing.JLabel();
        jLabel315 = new javax.swing.JLabel();
        jLabel316 = new javax.swing.JLabel();
        jSpinner45 = new javax.swing.JSpinner();
        jLabel317 = new javax.swing.JLabel();
        jCheckBox45 = new javax.swing.JCheckBox();
        jLabel318 = new javax.swing.JLabel();
        jPanel72 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jLabel319 = new javax.swing.JLabel();
        jLabel320 = new javax.swing.JLabel();
        jLabel321 = new javax.swing.JLabel();
        jLabel322 = new javax.swing.JLabel();
        jLabel323 = new javax.swing.JLabel();
        jSpinner46 = new javax.swing.JSpinner();
        jLabel324 = new javax.swing.JLabel();
        jCheckBox46 = new javax.swing.JCheckBox();
        jLabel325 = new javax.swing.JLabel();
        jPanel73 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jLabel326 = new javax.swing.JLabel();
        jLabel327 = new javax.swing.JLabel();
        jLabel328 = new javax.swing.JLabel();
        jLabel329 = new javax.swing.JLabel();
        jLabel330 = new javax.swing.JLabel();
        jSpinner47 = new javax.swing.JSpinner();
        jLabel331 = new javax.swing.JLabel();
        jCheckBox47 = new javax.swing.JCheckBox();
        jLabel332 = new javax.swing.JLabel();
        jPanel74 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jLabel333 = new javax.swing.JLabel();
        jLabel334 = new javax.swing.JLabel();
        jLabel335 = new javax.swing.JLabel();
        jLabel336 = new javax.swing.JLabel();
        jLabel337 = new javax.swing.JLabel();
        jSpinner48 = new javax.swing.JSpinner();
        jLabel338 = new javax.swing.JLabel();
        jCheckBox48 = new javax.swing.JCheckBox();
        jLabel339 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel12 = new jPanelGradient();
        jPanel75 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jLabel340 = new javax.swing.JLabel();
        jLabel341 = new javax.swing.JLabel();
        jLabel342 = new javax.swing.JLabel();
        jLabel343 = new javax.swing.JLabel();
        jLabel344 = new javax.swing.JLabel();
        jSpinner49 = new javax.swing.JSpinner();
        jLabel345 = new javax.swing.JLabel();
        jCheckBox49 = new javax.swing.JCheckBox();
        jLabel346 = new javax.swing.JLabel();
        jPanel76 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jLabel347 = new javax.swing.JLabel();
        jLabel348 = new javax.swing.JLabel();
        jLabel349 = new javax.swing.JLabel();
        jLabel350 = new javax.swing.JLabel();
        jLabel351 = new javax.swing.JLabel();
        jSpinner50 = new javax.swing.JSpinner();
        jLabel352 = new javax.swing.JLabel();
        jCheckBox50 = new javax.swing.JCheckBox();
        jLabel353 = new javax.swing.JLabel();
        jPanel77 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jLabel354 = new javax.swing.JLabel();
        jLabel355 = new javax.swing.JLabel();
        jLabel356 = new javax.swing.JLabel();
        jLabel357 = new javax.swing.JLabel();
        jLabel358 = new javax.swing.JLabel();
        jSpinner51 = new javax.swing.JSpinner();
        jLabel359 = new javax.swing.JLabel();
        jCheckBox51 = new javax.swing.JCheckBox();
        jLabel360 = new javax.swing.JLabel();
        jPanel78 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        jLabel361 = new javax.swing.JLabel();
        jLabel362 = new javax.swing.JLabel();
        jLabel363 = new javax.swing.JLabel();
        jLabel364 = new javax.swing.JLabel();
        jLabel365 = new javax.swing.JLabel();
        jSpinner52 = new javax.swing.JSpinner();
        jLabel366 = new javax.swing.JLabel();
        jCheckBox52 = new javax.swing.JCheckBox();
        jLabel367 = new javax.swing.JLabel();
        jPanel79 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jLabel368 = new javax.swing.JLabel();
        jLabel369 = new javax.swing.JLabel();
        jLabel370 = new javax.swing.JLabel();
        jLabel371 = new javax.swing.JLabel();
        jLabel372 = new javax.swing.JLabel();
        jSpinner53 = new javax.swing.JSpinner();
        jLabel373 = new javax.swing.JLabel();
        jCheckBox53 = new javax.swing.JCheckBox();
        jLabel374 = new javax.swing.JLabel();
        jPanel80 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        jLabel375 = new javax.swing.JLabel();
        jLabel376 = new javax.swing.JLabel();
        jLabel377 = new javax.swing.JLabel();
        jLabel378 = new javax.swing.JLabel();
        jLabel379 = new javax.swing.JLabel();
        jSpinner54 = new javax.swing.JSpinner();
        jLabel380 = new javax.swing.JLabel();
        jCheckBox54 = new javax.swing.JCheckBox();
        jLabel381 = new javax.swing.JLabel();
        jPanel81 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jLabel382 = new javax.swing.JLabel();
        jLabel383 = new javax.swing.JLabel();
        jLabel384 = new javax.swing.JLabel();
        jLabel385 = new javax.swing.JLabel();
        jLabel386 = new javax.swing.JLabel();
        jSpinner55 = new javax.swing.JSpinner();
        jLabel387 = new javax.swing.JLabel();
        jCheckBox55 = new javax.swing.JCheckBox();
        jLabel388 = new javax.swing.JLabel();
        jPanel82 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jLabel389 = new javax.swing.JLabel();
        jLabel390 = new javax.swing.JLabel();
        jLabel391 = new javax.swing.JLabel();
        jLabel392 = new javax.swing.JLabel();
        jLabel393 = new javax.swing.JLabel();
        jSpinner56 = new javax.swing.JSpinner();
        jLabel394 = new javax.swing.JLabel();
        jCheckBox56 = new javax.swing.JCheckBox();
        jLabel395 = new javax.swing.JLabel();
        jPanel83 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        jLabel396 = new javax.swing.JLabel();
        jLabel397 = new javax.swing.JLabel();
        jLabel398 = new javax.swing.JLabel();
        jLabel399 = new javax.swing.JLabel();
        jLabel400 = new javax.swing.JLabel();
        jSpinner57 = new javax.swing.JSpinner();
        jLabel401 = new javax.swing.JLabel();
        jCheckBox57 = new javax.swing.JCheckBox();
        jLabel402 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        prof = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel15 = new jPanelGradient1();
        jPanel17 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        PP = new javax.swing.JMenuItem();
        TC = new javax.swing.JMenuItem();
        RR = new javax.swing.JMenuItem();
        WC = new javax.swing.JMenuItem();
        About = new javax.swing.JMenu();

        jScrollPane3.setViewportView(list);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(0, 102, 102));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Select Your Preferred Category");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(204, 255, 255));

        rSButtonHover1.setBackground(new java.awt.Color(204, 255, 255));
        rSButtonHover1.setForeground(new java.awt.Color(0, 102, 102));
        rSButtonHover1.setText("FLOWERS");
        rSButtonHover1.setColorHover(new java.awt.Color(255, 102, 102));
        rSButtonHover1.setColorText(new java.awt.Color(0, 102, 102));
        rSButtonHover1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        rSButtonHover2.setBackground(new java.awt.Color(204, 255, 255));
        rSButtonHover2.setForeground(new java.awt.Color(0, 102, 102));
        rSButtonHover2.setText("CAKES");
        rSButtonHover2.setColorHover(new java.awt.Color(255, 102, 102));
        rSButtonHover2.setColorText(new java.awt.Color(0, 102, 102));
        rSButtonHover2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rSButtonHover2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover2ActionPerformed(evt);
            }
        });

        rSButtonHover3.setBackground(new java.awt.Color(204, 255, 255));
        rSButtonHover3.setForeground(new java.awt.Color(0, 102, 102));
        rSButtonHover3.setText("CHOCOLATES");
        rSButtonHover3.setColorHover(new java.awt.Color(255, 102, 102));
        rSButtonHover3.setColorText(new java.awt.Color(0, 102, 102));
        rSButtonHover3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rSButtonHover3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover3ActionPerformed(evt);
            }
        });

        rSButtonHover4.setBackground(new java.awt.Color(204, 255, 255));
        rSButtonHover4.setForeground(new java.awt.Color(0, 102, 102));
        rSButtonHover4.setText("DRESS");
        rSButtonHover4.setColorHover(new java.awt.Color(255, 102, 102));
        rSButtonHover4.setColorText(new java.awt.Color(0, 102, 102));
        rSButtonHover4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rSButtonHover4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover4ActionPerformed(evt);
            }
        });

        rSButtonHover5.setBackground(new java.awt.Color(204, 255, 255));
        rSButtonHover5.setForeground(new java.awt.Color(0, 102, 102));
        rSButtonHover5.setText("WATCHES");
        rSButtonHover5.setColorHover(new java.awt.Color(255, 102, 102));
        rSButtonHover5.setColorText(new java.awt.Color(0, 102, 102));
        rSButtonHover5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rSButtonHover5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover5ActionPerformed(evt);
            }
        });

        jLabel403.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel403.setForeground(new java.awt.Color(0, 102, 102));
        jLabel403.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel403.setText("PRICEWISE");

        rSButtonHover6.setBackground(new java.awt.Color(204, 255, 255));
        rSButtonHover6.setForeground(new java.awt.Color(0, 102, 102));
        rSButtonHover6.setText("Within 2000TK");
        rSButtonHover6.setColorHover(new java.awt.Color(255, 102, 102));
        rSButtonHover6.setColorText(new java.awt.Color(0, 102, 102));
        rSButtonHover6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover6ActionPerformed(evt);
            }
        });

        rSButtonHover7.setBackground(new java.awt.Color(204, 255, 255));
        rSButtonHover7.setForeground(new java.awt.Color(0, 102, 102));
        rSButtonHover7.setText("Within 1000TK");
        rSButtonHover7.setColorHover(new java.awt.Color(255, 102, 102));
        rSButtonHover7.setColorText(new java.awt.Color(0, 102, 102));
        rSButtonHover7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover7ActionPerformed(evt);
            }
        });

        rSButtonHover8.setBackground(new java.awt.Color(204, 255, 255));
        rSButtonHover8.setForeground(new java.awt.Color(0, 102, 102));
        rSButtonHover8.setText("Within 500TK");
        rSButtonHover8.setColorHover(new java.awt.Color(255, 102, 102));
        rSButtonHover8.setColorText(new java.awt.Color(0, 102, 102));
        rSButtonHover8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(rSButtonHover5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rSButtonHover1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rSButtonHover2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rSButtonHover4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(rSButtonHover3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSButtonHover8, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSButtonHover7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSButtonHover6, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel403)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(rSButtonHover2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rSButtonHover1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel403)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSButtonHover6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(rSButtonHover3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rSButtonHover4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSButtonHover5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(rSButtonHover7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(rSButtonHover8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(8, 61, 65));

        jPanel27.setBackground(new java.awt.Color(8, 61, 65));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sprinkles/cake (2).png"))); // NOI18N
        jLabel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel48MouseClicked(evt);
            }
        });
        jPanel27.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, 180));

        jPanel28.setBackground(new java.awt.Color(8, 61, 65));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel29.setBackground(new java.awt.Color(8, 61, 65));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel28.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, 180));

        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\dress.png")); // NOI18N
        jPanel28.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, 190));

        jPanel30.setBackground(new java.awt.Color(8, 61, 65));
        jPanel30.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Sprinkle\\src\\Sprinkles\\flower-bouquet (1).png")); // NOI18N
        jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel50MouseClicked(evt);
            }
        });
        jPanel30.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 180));

        jPanel32.setBackground(new java.awt.Color(8, 61, 65));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\books.png")); // NOI18N
        jPanel32.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 180));

        jButton1.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(8, 61, 65));
        jButton1.setText("C A K E S");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        chocobutton.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        chocobutton.setForeground(new java.awt.Color(8, 61, 65));
        chocobutton.setText("C H O C O L A T E S");
        chocobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chocobuttonActionPerformed(evt);
            }
        });

        flowerbutton.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        flowerbutton.setText(" F L O W E R S");
        flowerbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flowerbuttonActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(8, 61, 65));
        jButton6.setText("D R E S S E S");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(8, 61, 65));
        jButton8.setText("B O O K S");

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setPreferredSize(new java.awt.Dimension(748, 401));

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(img1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel32.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 204, 204));
        jLabel32.setText("©2023 SPRINKLES. All Rights Reserved");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(204, 204, 204));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Find Things You Will Love, Only On SPRINKLES !");

        ss.setText("Search");
        ss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssActionPerformed(evt);
            }
        });
        ss.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ssKeyReleased(evt);
            }
        });

        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Search Your Item Here");

        jPanel5.setBackground(new java.awt.Color(8, 61, 65));

        rSPanelImage2.setImagen(new javax.swing.ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Sprinkle\\src\\Sprinkles\\icons8-candy-100.png")); // NOI18N

        javax.swing.GroupLayout rSPanelImage2Layout = new javax.swing.GroupLayout(rSPanelImage2);
        rSPanelImage2.setLayout(rSPanelImage2Layout);
        rSPanelImage2Layout.setHorizontalGroup(
            rSPanelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        rSPanelImage2Layout.setVerticalGroup(
            rSPanelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(rSPanelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(rSPanelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        title.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 204, 204));
        title.setText("S P R I N K L E S");

        jLabel24.setForeground(new java.awt.Color(255, 153, 153));
        jLabel24.setText("Welcome to  S P R I N K L E S !");

        jLabel25.setForeground(new java.awt.Color(255, 153, 153));
        jLabel25.setText("Step into a world of thoughtful surprises ");

        jLabel26.setForeground(new java.awt.Color(255, 153, 153));
        jLabel26.setText("and delightful treasures.");

        jLabel27.setForeground(new java.awt.Color(255, 153, 153));
        jLabel27.setText("Our shelves are filled with unique finds ");

        jLabel28.setForeground(new java.awt.Color(255, 153, 153));
        jLabel28.setText(" waiting to bring smiles");

        jLabel29.setForeground(new java.awt.Color(255, 153, 153));
        jLabel29.setText("Thank you for choosing us ");

        jLabel30.setForeground(new java.awt.Color(255, 153, 153));
        jLabel30.setText("to be part of your special moments. ");

        jLabel31.setFont(new java.awt.Font("Tempus Sans ITC", 3, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 153, 153));
        jLabel31.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\shoppingbag.png")); // NOI18N
        jLabel31.setText("Happy  Shopping !");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel25)
                            .addComponent(jLabel29)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel28)))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(title)
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addGap(49, 49, 49)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addGap(20, 20, 20))
        );

        jLabel405.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\order.gif")); // NOI18N

        jLabel408.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\soon.gif")); // NOI18N

        jLabel409.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\arriv.png")); // NOI18N

        jLabel410.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\deliv.gif")); // NOI18N

        rSPanelImage1.setImagen(new javax.swing.ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Sprinkle\\src\\Sprinkles\\icons8-search-50.png")); // NOI18N
        rSPanelImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSPanelImage1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        rSPanelImage1Layout.setVerticalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        rSPanelImage3.setImagen(new javax.swing.ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Sprinkle\\src\\Sprinkles\\icons8-expand-arrow-100.png")); // NOI18N
        rSPanelImage3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSPanelImage3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout rSPanelImage3Layout = new javax.swing.GroupLayout(rSPanelImage3);
        rSPanelImage3.setLayout(rSPanelImage3Layout);
        rSPanelImage3Layout.setHorizontalGroup(
            rSPanelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        rSPanelImage3Layout.setVerticalGroup(
            rSPanelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel56)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(flowerbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chocobutton, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 3791, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel409, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel405)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(267, 267, 267)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel410, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel408, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(3771, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(335, 335, 335)
                .addComponent(rSPanelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(ss, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rSPanelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel410, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel408, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, Short.MAX_VALUE)
                                    .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
                                .addGap(43, 43, 43)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel405, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel409, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rSPanelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ss, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(83, 83, 83))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(rSPanelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)))
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(flowerbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chocobutton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1027, 1027, 1027))
        );

        jTabbedPane1.addTab("tab1", jPanel3);

        jPanel38.setMaximumSize(new java.awt.Dimension(1540, 1200));

        jPanel39.setBackground(new java.awt.Color(0, 51, 51));
        jPanel39.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));

        jLabel95.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 204, 204));
        jLabel95.setText("Name :");

        jLabel96.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 204, 204));
        jLabel96.setText("Price :");

        jLabel97.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(255, 204, 204));
        jLabel97.setText("Quantity :");

        jLabel98.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 204, 204));
        jLabel98.setText("Ferrero Rocher Cake");

        jLabel99.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(255, 204, 204));
        jLabel99.setText("10000");

        jSpinner14.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));

        jLabel100.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(255, 204, 204));
        jLabel100.setText("Purchase :");

        jLabel101.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\ferrero.jpg")); // NOI18N

        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel39Layout.createSequentialGroup()
                                .addComponent(jLabel97)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel39Layout.createSequentialGroup()
                                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel95, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                    .addComponent(jLabel96, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel98)
                                    .addGroup(jPanel39Layout.createSequentialGroup()
                                        .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95)
                    .addComponent(jLabel98))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel96)
                    .addComponent(jLabel99))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel97)
                    .addComponent(jSpinner14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel100)
                    .addComponent(jCheckBox4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel40.setBackground(new java.awt.Color(0, 51, 51));
        jPanel40.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));

        jLabel102.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(255, 204, 204));
        jLabel102.setText("Name :");

        jLabel103.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(255, 204, 204));
        jLabel103.setText("Price :");

        jLabel104.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(255, 204, 204));
        jLabel104.setText("Quantity :");

        jLabel105.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(255, 204, 204));
        jLabel105.setText("Cheese Cake");

        jLabel106.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(255, 204, 204));
        jLabel106.setText("3000");

        jSpinner15.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        jLabel107.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(255, 204, 204));
        jLabel107.setText("Purchase :");

        jCheckBox15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox15ActionPerformed(evt);
            }
        });

        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel108.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\cheese.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel104))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(jLabel107)
                        .addGap(26, 26, 26)
                        .addComponent(jCheckBox15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 186, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel102)
                    .addComponent(jLabel105))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel103)
                    .addComponent(jLabel106))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel107)))
        );

        jPanel41.setBackground(new java.awt.Color(0, 51, 51));
        jPanel41.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));

        jLabel109.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(255, 204, 204));
        jLabel109.setText("Name :");

        jLabel110.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(255, 204, 204));
        jLabel110.setText("Price :");

        jLabel111.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(255, 204, 204));
        jLabel111.setText("Quantity :");

        jLabel112.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(255, 204, 204));
        jLabel112.setText("Chocolate Cake");

        jLabel113.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(255, 204, 204));
        jLabel113.setText("2000");

        jSpinner16.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));

        jLabel114.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(255, 204, 204));
        jLabel114.setText("Purchase :");

        jLabel115.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\chococake.jpg")); // NOI18N

        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel111))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jLabel114)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel115, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel112, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel109, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel113)
                    .addComponent(jLabel110))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jLabel111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jSpinner16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel114)
                    .addComponent(jCheckBox1)))
        );

        jPanel42.setBackground(new java.awt.Color(0, 51, 51));
        jPanel42.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));

        jLabel116.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(255, 204, 204));
        jLabel116.setText("Name :");

        jLabel117.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(255, 204, 204));
        jLabel117.setText("Price :");

        jLabel118.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(255, 204, 204));
        jLabel118.setText("Quantity :");

        jLabel119.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(255, 204, 204));
        jLabel119.setText("Cupcake");

        jLabel120.setBackground(new java.awt.Color(0, 51, 51));
        jLabel120.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(255, 204, 204));
        jLabel120.setText("200.0");

        jSpinner17.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jLabel121.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(255, 204, 204));
        jLabel121.setText("Purchase :");

        jCheckBox17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox17ActionPerformed(evt);
            }
        });

        jLabel122.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel122.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\cupcake.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel122, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel118))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinner17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addComponent(jLabel121)
                                .addGap(26, 26, 26)
                                .addComponent(jCheckBox17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel122, javax.swing.GroupLayout.PREFERRED_SIZE, 184, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel119, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel116, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel120)
                    .addComponent(jLabel117))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(jLabel118, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(jSpinner17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox17, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel121)))
        );

        jPanel43.setBackground(new java.awt.Color(0, 51, 51));
        jPanel43.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));

        jLabel123.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(255, 204, 204));
        jLabel123.setText("Name :");

        jLabel124.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(255, 204, 204));
        jLabel124.setText("Price :");

        jLabel125.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(255, 204, 204));
        jLabel125.setText("Quantity :");

        jLabel126.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(255, 204, 204));
        jLabel126.setText("Ice-Cream Cake");

        jLabel127.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(255, 204, 204));
        jLabel127.setText("3000.0");

        jSpinner18.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));

        jLabel128.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(255, 204, 204));
        jLabel128.setText("Purchase :");

        jCheckBox18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox18ActionPerformed(evt);
            }
        });

        jLabel129.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\icecream.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(jLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel124, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel125))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(jLabel128)
                        .addGap(26, 26, 26)
                        .addComponent(jCheckBox18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 186, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel126, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel123, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel124)
                    .addComponent(jLabel127))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(jLabel125, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(jSpinner18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox18, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel128)))
        );

        jPanel44.setBackground(new java.awt.Color(0, 51, 51));
        jPanel44.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));

        jLabel130.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(255, 204, 204));
        jLabel130.setText("Name :");

        jLabel131.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(255, 204, 204));
        jLabel131.setText("Price :");

        jLabel132.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(255, 204, 204));
        jLabel132.setText("Quantity :");

        jLabel133.setBackground(new java.awt.Color(0, 51, 51));
        jLabel133.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(255, 204, 204));
        jLabel133.setText("Jar Cake");

        jLabel134.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(255, 204, 204));
        jLabel134.setText("300.0");

        jSpinner19.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        jLabel135.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel135.setForeground(new java.awt.Color(255, 204, 204));
        jLabel135.setText("Purchase :");

        jCheckBox19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox19ActionPerformed(evt);
            }
        });

        jLabel136.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\jarrcake.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel132))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addComponent(jLabel135)
                        .addGap(26, 26, 26)
                        .addComponent(jCheckBox19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 174, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel130)
                    .addComponent(jLabel133))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel134)
                    .addComponent(jLabel131))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addComponent(jLabel132, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addComponent(jSpinner19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox19, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel135)))
        );

        jPanel45.setBackground(new java.awt.Color(0, 51, 51));
        jPanel45.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));

        jLabel137.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(255, 204, 204));
        jLabel137.setText("Name :");

        jLabel138.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel138.setForeground(new java.awt.Color(255, 204, 204));
        jLabel138.setText("Price :");

        jLabel139.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(255, 204, 204));
        jLabel139.setText("Quantity :");

        jLabel140.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel140.setForeground(new java.awt.Color(255, 204, 204));
        jLabel140.setText("Vanilla Cake");

        jLabel141.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel141.setForeground(new java.awt.Color(255, 204, 204));
        jLabel141.setText("1000.0");

        jSpinner20.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));

        jLabel142.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel142.setForeground(new java.awt.Color(255, 204, 204));
        jLabel142.setText("Purchase :");

        jLabel143.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\vanillacake.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addComponent(jLabel142)
                        .addGap(26, 26, 26)
                        .addComponent(jCheckBox20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel143, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel139)
                            .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel140)
                            .addComponent(jSpinner20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel143, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel137)
                    .addComponent(jLabel140))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel138)
                    .addComponent(jLabel141))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addComponent(jLabel139, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addComponent(jSpinner20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox20, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel142)))
        );

        jPanel46.setBackground(new java.awt.Color(0, 51, 51));
        jPanel46.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));

        jLabel144.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel144.setForeground(new java.awt.Color(255, 204, 204));
        jLabel144.setText("Name :");

        jLabel145.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel145.setForeground(new java.awt.Color(255, 204, 204));
        jLabel145.setText("Price :");

        jLabel146.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel146.setForeground(new java.awt.Color(255, 204, 204));
        jLabel146.setText("Quantity :");

        jLabel147.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel147.setForeground(new java.awt.Color(255, 204, 204));
        jLabel147.setText("Oreo Cake");

        jLabel148.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel148.setForeground(new java.awt.Color(255, 204, 204));
        jLabel148.setText("500.0");

        jSpinner21.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jLabel149.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel149.setForeground(new java.awt.Color(255, 204, 204));
        jLabel149.setText("Purchase :");

        jLabel150.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\oreo.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel147, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel146))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(jLabel149)
                        .addGap(26, 26, 26)
                        .addComponent(jCheckBox21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel150, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel150, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel144)
                    .addComponent(jLabel147))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel148)
                    .addComponent(jLabel145))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(jLabel146, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(jSpinner21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox21, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel149)))
        );

        jPanel47.setBackground(new java.awt.Color(0, 51, 51));
        jPanel47.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));

        jLabel151.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(255, 204, 204));
        jLabel151.setText("Name :");

        jLabel152.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel152.setForeground(new java.awt.Color(255, 204, 204));
        jLabel152.setText("Price :");

        jLabel153.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel153.setForeground(new java.awt.Color(255, 204, 204));
        jLabel153.setText("Quantity :");

        jLabel154.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel154.setForeground(new java.awt.Color(255, 204, 204));
        jLabel154.setText("Macaron");

        jLabel155.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel155.setForeground(new java.awt.Color(255, 204, 204));
        jLabel155.setText("1,500 TK");

        jSpinner22.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        jLabel156.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel156.setForeground(new java.awt.Color(255, 204, 204));
        jLabel156.setText("Purchase :");

        jLabel157.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\macaron.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(jLabel151, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel154, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel152, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel153))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel155, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(jLabel156)
                        .addGap(26, 26, 26)
                        .addComponent(jCheckBox22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel157, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel157, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel154, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel151, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel155)
                    .addComponent(jLabel152))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(jLabel153, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(jSpinner22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox22, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel156)))
        );

        caktax.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        caktax.setText("0.0");
        caktax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caktaxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Tax(Tk)");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("M E N U   I T E M S");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(204, 204, 204));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Y O U R    R E C E I P T");

        memo.setColumns(20);
        memo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        memo.setRows(5);
        memo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jScrollPane2.setViewportView(memo);

        txttime1.setBackground(new java.awt.Color(255, 0, 0));
        txttime1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        txttime1.setForeground(new java.awt.Color(255, 255, 255));

        txtdate1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtdate1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(204, 204, 204));
        jLabel60.setText("Time :");

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(204, 204, 204));
        jLabel61.setText("Date :");

        cart3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cart3.setText("Add to Cart");
        cart3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cart3MouseClicked(evt);
            }
        });
        cart3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cart3ActionPerformed(evt);
            }
        });

        cart4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cart4.setText("Add to Cart");
        cart4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cart4MouseClicked(evt);
            }
        });
        cart4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cart4ActionPerformed(evt);
            }
        });

        cart5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cart5.setText("Add to Cart");
        cart5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cart5MouseClicked(evt);
            }
        });
        cart5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cart5ActionPerformed(evt);
            }
        });

        cart6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cart6.setText("Add to Cart");
        cart6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cart6MouseClicked(evt);
            }
        });
        cart6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cart6ActionPerformed(evt);
            }
        });

        cart7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cart7.setText("Add to Cart");
        cart7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cart7MouseClicked(evt);
            }
        });
        cart7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cart7ActionPerformed(evt);
            }
        });

        cart8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cart8.setText("Add to Cart");
        cart8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cart8MouseClicked(evt);
            }
        });
        cart8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cart8ActionPerformed(evt);
            }
        });

        cart9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cart9.setText("Add to Cart");
        cart9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cart9MouseClicked(evt);
            }
        });
        cart9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cart9ActionPerformed(evt);
            }
        });

        cart10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cart10.setText("Add to Cart");
        cart10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cart10MouseClicked(evt);
            }
        });
        cart10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cart10ActionPerformed(evt);
            }
        });

        cart11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cart11.setText("Add to Cart");
        cart11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cart11MouseClicked(evt);
            }
        });
        cart11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cart11ActionPerformed(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel62.setText("Sub Total (Tk)");

        caksubtot2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        caksubtot2.setText("0.0");
        caksubtot2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caksubtot2ActionPerformed(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel63.setText("Total (Tk)");

        rSButtonHover9.setBackground(new java.awt.Color(255, 0, 51));
        rSButtonHover9.setText("Place Order");
        rSButtonHover9.setColorHover(new java.awt.Color(153, 0, 0));
        rSButtonHover9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover9ActionPerformed(evt);
            }
        });

        rSButtonHover10.setBackground(new java.awt.Color(0, 153, 255));
        rSButtonHover10.setText("Receipt");
        rSButtonHover10.setColorHover(new java.awt.Color(0, 102, 153));
        rSButtonHover10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(cart3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(cart4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(cart5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(cart6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(cart7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(cart8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel62)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(caksubtot2, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(caktax, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(caktot2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(169, 169, 169))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel38Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txttime1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(93, 93, 93)
                                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel38Layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(cart9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(cart11, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(cart10, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 682, Short.MAX_VALUE))
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                                .addComponent(rSButtonHover9, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(rSButtonHover10, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(179, 179, 179))
                            .addGroup(jPanel38Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80))))))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel38Layout.createSequentialGroup()
                                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cart5)
                                    .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cart3)
                                        .addComponent(cart4))))
                            .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cart7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cart8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cart6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cart10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cart9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cart11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(1089, 1089, 1089))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttime1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(caktax, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(caksubtot2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(caktot2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rSButtonHover9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSButtonHover10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1446, 1446, 1446))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3739, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, 2077, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        jPanel48.setMaximumSize(new java.awt.Dimension(1540, 1200));
        jPanel48.setPreferredSize(new java.awt.Dimension(1284, 1894));

        jPanel49.setBackground(new java.awt.Color(0, 51, 51));
        jPanel49.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));

        jLabel158.setBackground(new java.awt.Color(0, 51, 51));
        jLabel158.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel158.setForeground(new java.awt.Color(255, 204, 204));
        jLabel158.setText("Name :");

        jLabel159.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(255, 204, 204));
        jLabel159.setText("Price :");

        jLabel160.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel160.setForeground(new java.awt.Color(255, 204, 204));
        jLabel160.setText("Quantity :");

        jLabel161.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel161.setForeground(new java.awt.Color(255, 204, 204));
        jLabel161.setText("Flower HeartBox");

        jLabel162.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel162.setForeground(new java.awt.Color(255, 204, 204));
        jLabel162.setText("10000 .0");

        jSpinner23.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));

        jLabel163.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(255, 204, 204));
        jLabel163.setText("Purchase :");

        jCheckBox23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox23ActionPerformed(evt);
            }
        });

        jLabel164.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\rosebox.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addComponent(jLabel158, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel161, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel159, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel160))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel162, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(jSpinner23)))
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addComponent(jLabel163)
                        .addGap(26, 26, 26)
                        .addComponent(jCheckBox23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel164, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel164, javax.swing.GroupLayout.PREFERRED_SIZE, 186, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel161, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel158, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel162)
                    .addComponent(jLabel159))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addComponent(jLabel160, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addComponent(jSpinner23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox23, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel163)))
        );

        jPanel50.setBackground(new java.awt.Color(0, 51, 51));
        jPanel50.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));

        jLabel165.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel165.setForeground(new java.awt.Color(255, 204, 204));
        jLabel165.setText("Name :");

        jLabel166.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(255, 204, 204));
        jLabel166.setText("Price :");

        jLabel167.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel167.setForeground(new java.awt.Color(255, 204, 204));
        jLabel167.setText("Quantity :");

        jLabel168.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel168.setForeground(new java.awt.Color(255, 204, 204));
        jLabel168.setText("Sunflower");

        jLabel169.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(255, 204, 204));
        jLabel169.setText("3000.0");

        jSpinner24.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        jLabel170.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel170.setForeground(new java.awt.Color(255, 204, 204));
        jLabel170.setText("Purchase :");

        jCheckBox24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox24ActionPerformed(evt);
            }
        });

        jLabel171.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel171.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\sunflower.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addComponent(jLabel165, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel168, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel166, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel167))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel169, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(jSpinner24)))
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addComponent(jLabel170)
                        .addGap(26, 26, 26)
                        .addComponent(jCheckBox24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel171, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel171, javax.swing.GroupLayout.PREFERRED_SIZE, 186, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel165)
                    .addComponent(jLabel168))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel166)
                    .addComponent(jLabel169))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel167, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox24, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel170)))
        );

        jPanel51.setBackground(new java.awt.Color(0, 51, 51));
        jPanel51.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));

        jLabel172.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel172.setForeground(new java.awt.Color(255, 204, 204));
        jLabel172.setText("Name :");

        jLabel173.setBackground(new java.awt.Color(255, 204, 204));
        jLabel173.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel173.setForeground(new java.awt.Color(255, 204, 204));
        jLabel173.setText("Price :");

        jLabel174.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel174.setForeground(new java.awt.Color(255, 204, 204));
        jLabel174.setText("Quantity :");

        jLabel175.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel175.setForeground(new java.awt.Color(255, 204, 204));
        jLabel175.setText("Flower Basket");

        jLabel176.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel176.setForeground(new java.awt.Color(255, 204, 204));
        jLabel176.setText("2000.0");

        jSpinner25.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));

        jLabel177.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel177.setForeground(new java.awt.Color(255, 204, 204));
        jLabel177.setText("Purchase :");

        jCheckBox25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox25ActionPerformed(evt);
            }
        });

        jLabel178.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\basket.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(jLabel172, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel175, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel173, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel174))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel176, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner25, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(jLabel177)
                        .addGap(26, 26, 26)
                        .addComponent(jCheckBox25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel178, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel178, javax.swing.GroupLayout.PREFERRED_SIZE, 186, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel175, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel172, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel176)
                    .addComponent(jLabel173))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(jLabel174, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(jSpinner25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox25, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel177)))
        );

        jPanel52.setBackground(new java.awt.Color(0, 51, 51));
        jPanel52.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));

        jLabel179.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel179.setForeground(new java.awt.Color(255, 204, 204));
        jLabel179.setText("Name :");

        jLabel180.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel180.setForeground(new java.awt.Color(255, 204, 204));
        jLabel180.setText("Price :");

        jLabel181.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel181.setForeground(new java.awt.Color(255, 204, 204));
        jLabel181.setText("Quantity :");

        jLabel182.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel182.setForeground(new java.awt.Color(255, 204, 204));
        jLabel182.setText("Rose Bouquet1");

        jLabel183.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel183.setForeground(new java.awt.Color(255, 204, 204));
        jLabel183.setText("200.0");

        jSpinner26.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jLabel184.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel184.setForeground(new java.awt.Color(255, 204, 204));
        jLabel184.setText("Purchase :");

        jCheckBox26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox26ActionPerformed(evt);
            }
        });

        jLabel185.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel185.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\bouquet2.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel185, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel52Layout.createSequentialGroup()
                                .addComponent(jLabel179, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel182, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel52Layout.createSequentialGroup()
                                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel180, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel181))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinner26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel183, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel52Layout.createSequentialGroup()
                                .addComponent(jLabel184)
                                .addGap(26, 26, 26)
                                .addComponent(jCheckBox26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel185, javax.swing.GroupLayout.PREFERRED_SIZE, 184, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel182, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel179, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel183)
                    .addComponent(jLabel180))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addComponent(jLabel181, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addComponent(jSpinner26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox26, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel184)))
        );

        jPanel53.setBackground(new java.awt.Color(0, 51, 51));
        jPanel53.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));

        jLabel186.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel186.setForeground(new java.awt.Color(255, 204, 204));
        jLabel186.setText("Name :");

        jLabel187.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel187.setForeground(new java.awt.Color(255, 204, 204));
        jLabel187.setText("Price :");

        jLabel188.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel188.setForeground(new java.awt.Color(255, 204, 204));
        jLabel188.setText("Quantity :");

        jLabel189.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel189.setForeground(new java.awt.Color(255, 204, 204));
        jLabel189.setText("White Roses");

        jLabel190.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel190.setForeground(new java.awt.Color(255, 204, 204));
        jLabel190.setText("3000.0");

        jSpinner27.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));

        jLabel191.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel191.setForeground(new java.awt.Color(255, 204, 204));
        jLabel191.setText("Purchase :");

        jCheckBox27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox27ActionPerformed(evt);
            }
        });

        jLabel192.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\whiterose.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(jLabel186, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel189, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel187, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel188))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel190, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(jLabel191)
                        .addGap(26, 26, 26)
                        .addComponent(jCheckBox27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel192, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel192, javax.swing.GroupLayout.PREFERRED_SIZE, 186, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel189, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel186, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel190)
                    .addComponent(jLabel187))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(jLabel188, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(jSpinner27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox27, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel191)))
        );

        jPanel54.setBackground(new java.awt.Color(0, 51, 51));
        jPanel54.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));

        jLabel193.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel193.setForeground(new java.awt.Color(255, 204, 204));
        jLabel193.setText("Name :");

        jLabel194.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel194.setForeground(new java.awt.Color(255, 204, 204));
        jLabel194.setText("Price :");

        jLabel195.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel195.setForeground(new java.awt.Color(255, 204, 204));
        jLabel195.setText("Quantity :");

        jLabel196.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel196.setForeground(new java.awt.Color(255, 204, 204));
        jLabel196.setText("Hydragaena");

        jLabel197.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel197.setForeground(new java.awt.Color(255, 204, 204));
        jLabel197.setText("300.0");

        jSpinner28.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        jLabel198.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel198.setForeground(new java.awt.Color(255, 204, 204));
        jLabel198.setText("Purchase :");

        jLabel199.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\hydragaenia.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addComponent(jLabel193, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel196, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel194, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel195))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel197, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addComponent(jLabel198)
                        .addGap(26, 26, 26)
                        .addComponent(jCheckBox28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel199, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel199, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel196, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel193, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel197)
                    .addComponent(jLabel194))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addComponent(jLabel195, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addComponent(jSpinner28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox28, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel198)))
        );

        jPanel55.setBackground(new java.awt.Color(0, 51, 51));
        jPanel55.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));

        jLabel200.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel200.setForeground(new java.awt.Color(255, 204, 204));
        jLabel200.setText("Name :");

        jLabel201.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel201.setForeground(new java.awt.Color(255, 204, 204));
        jLabel201.setText("Price :");

        jLabel202.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel202.setForeground(new java.awt.Color(255, 204, 204));
        jLabel202.setText("Quantity :");

        jLabel203.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel203.setForeground(new java.awt.Color(255, 204, 204));
        jLabel203.setText("Rose Bouquet2");

        jLabel204.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel204.setForeground(new java.awt.Color(255, 204, 204));
        jLabel204.setText("1000.0");

        jSpinner29.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));

        jLabel205.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel205.setForeground(new java.awt.Color(255, 204, 204));
        jLabel205.setText("Purchase :");

        jLabel206.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\bouquet1.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addComponent(jLabel200, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel203, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel201, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel202))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel204, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addComponent(jLabel205)
                        .addGap(26, 26, 26)
                        .addComponent(jCheckBox29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel55Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel206, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel55Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel206, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel200)
                    .addComponent(jLabel203))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel201)
                    .addComponent(jLabel204))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addComponent(jLabel202, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addComponent(jSpinner29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox29, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel205)))
        );

        jPanel56.setBackground(new java.awt.Color(0, 51, 51));
        jPanel56.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));

        jLabel207.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel207.setForeground(new java.awt.Color(255, 204, 204));
        jLabel207.setText("Name :");

        jLabel208.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel208.setForeground(new java.awt.Color(255, 204, 204));
        jLabel208.setText("Price :");

        jLabel209.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel209.setForeground(new java.awt.Color(255, 204, 204));
        jLabel209.setText("Quantity :");

        jLabel210.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel210.setForeground(new java.awt.Color(255, 204, 204));
        jLabel210.setText("Pink Roses");

        jLabel211.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel211.setForeground(new java.awt.Color(255, 204, 204));
        jLabel211.setText("500.0");

        jSpinner30.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jLabel212.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel212.setForeground(new java.awt.Color(255, 204, 204));
        jLabel212.setText("Purchase :");

        jLabel213.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\pinkrose.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel56Layout.createSequentialGroup()
                        .addComponent(jLabel207, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel210, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel56Layout.createSequentialGroup()
                        .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel208, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel209))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel211, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel56Layout.createSequentialGroup()
                        .addComponent(jLabel212)
                        .addGap(26, 26, 26)
                        .addComponent(jCheckBox30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel213, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel213, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel210, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel207, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel211)
                    .addComponent(jLabel208))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel56Layout.createSequentialGroup()
                        .addComponent(jLabel209, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel56Layout.createSequentialGroup()
                        .addComponent(jSpinner30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox30, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel212)))
        );

        jPanel9.setBackground(new java.awt.Color(0, 51, 51));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));

        jLabel10.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 204, 204));
        jLabel10.setText("Name :");

        jLabel13.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 204, 204));
        jLabel13.setText("Price :");

        jLabel15.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 204, 204));
        jLabel15.setText("Quantity :");

        jLabel19.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 204, 204));
        jLabel19.setText("Lilly");

        jLabel21.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 204, 204));
        jLabel21.setText("1000.0");

        jLabel22.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 204, 204));
        jLabel22.setText("Purchase :");

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\y.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(26, 26, 26)
                        .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)))
        );

        caksubtot1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        caksubtot1.setText("0.0");
        caksubtot1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caksubtot1ActionPerformed(evt);
            }
        });

        caktot1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        caktot1.setText("0.0");
        caktot1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caktot1ActionPerformed(evt);
            }
        });

        caktax1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        caktax1.setText("0.0");
        caktax1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caktax1ActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel35.setText("Tax(Tk)");

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel36.setText("Sub Total (Tk)");

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel37.setText("Total (Tk)");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(204, 204, 204));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("M E N U   I T E M S");

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(204, 204, 204));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Y O U R    R E C E I P T");
        jLabel57.setName(""); // NOI18N

        memo1.setColumns(20);
        memo1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        memo1.setRows(5);
        memo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jScrollPane4.setViewportView(memo1);

        txttime.setBackground(new java.awt.Color(255, 0, 0));
        txttime.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        txttime.setForeground(new java.awt.Color(255, 255, 255));

        txtdate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtdate.setForeground(new java.awt.Color(255, 255, 255));

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(204, 204, 204));
        jLabel58.setText("Date :");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(204, 204, 204));
        jLabel59.setText("Time :");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Add to Cart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Add to Cart");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setText("Add to Cart");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setText("Add to Cart");

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton9.setText("Add to Cart");

        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton10.setText("Add to Cart");

        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton11.setText("Add to Cart");

        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton12.setText("Add to Cart");

        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton13.setText("Add to Cart");

        rSButtonHover11.setBackground(new java.awt.Color(255, 0, 51));
        rSButtonHover11.setText("Place Order");
        rSButtonHover11.setColorHover(new java.awt.Color(153, 0, 0));
        rSButtonHover11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover11ActionPerformed(evt);
            }
        });

        rSButtonHover12.setBackground(new java.awt.Color(0, 153, 255));
        rSButtonHover12.setText("Receipt");
        rSButtonHover12.setColorHover(new java.awt.Color(0, 102, 153));
        rSButtonHover12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel48Layout.createSequentialGroup()
                                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel48Layout.createSequentialGroup()
                                .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel48Layout.createSequentialGroup()
                                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel48Layout.createSequentialGroup()
                                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel48Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(129, 129, 129)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel48Layout.createSequentialGroup()
                                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel48Layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(rSButtonHover11, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel48Layout.createSequentialGroup()
                                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(122, 122, 122)
                                                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel36)
                                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(59, 59, 59)
                                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(caktax1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(caksubtot1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(caktot1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rSButtonHover12, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 78, Short.MAX_VALUE))
                            .addGroup(jPanel48Layout.createSequentialGroup()
                                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel48Layout.createSequentialGroup()
                                        .addGap(127, 127, 127)
                                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txttime, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(61, 61, 61))
                                    .addGroup(jPanel48Layout.createSequentialGroup()
                                        .addGap(164, 164, 164)
                                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel48Layout.createSequentialGroup()
                                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(caktot1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton9)
                            .addComponent(jButton10))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(txttime, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel57)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(caktax1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(caksubtot1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rSButtonHover11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSButtonHover12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11)
                    .addComponent(jButton12)
                    .addComponent(jButton13))
                .addGap(0, 891, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3753, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, 2077, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab3", jPanel8);

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\cake promo.gif")); // NOI18N

        jLabel41.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\choco promo.gif")); // NOI18N

        jLabel43.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\new promo.gif")); // NOI18N

        jLabel44.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\sale promo.gif")); // NOI18N

        jLabel45.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\chri.gif")); // NOI18N

        jLabel51.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\halo promo.gif")); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jScrollPane5.setViewportView(jPanel7);

        jPanel57.setBackground(new java.awt.Color(0, 51, 51));
        jPanel57.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel57.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel64.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF.gif")); // NOI18N
        jPanel57.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel214.setBackground(new java.awt.Color(0, 51, 51));
        jLabel214.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel214.setForeground(new java.awt.Color(255, 204, 204));
        jLabel214.setText("Name :");
        jPanel57.add(jLabel214, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel215.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel215.setForeground(new java.awt.Color(255, 204, 204));
        jLabel215.setText("Price :");
        jPanel57.add(jLabel215, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel216.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel216.setForeground(new java.awt.Color(255, 204, 204));
        jLabel216.setText("Quantity :");
        jPanel57.add(jLabel216, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel217.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel217.setForeground(new java.awt.Color(255, 204, 204));
        jLabel217.setText("Flower HeartBox");
        jPanel57.add(jLabel217, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel218.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel218.setForeground(new java.awt.Color(255, 204, 204));
        jLabel218.setText("10000 .0");
        jPanel57.add(jLabel218, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner31.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel57.add(jSpinner31, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel219.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel219.setForeground(new java.awt.Color(255, 204, 204));
        jLabel219.setText("Purchase :");
        jPanel57.add(jLabel219, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox31ActionPerformed(evt);
            }
        });
        jPanel57.add(jCheckBox31, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel220.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel220.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\rosebox.jpg")); // NOI18N
        jLabel220.setText("50% ");
        jPanel57.add(jLabel220, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel58.setBackground(new java.awt.Color(0, 51, 51));
        jPanel58.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel58.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel65.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF.gif")); // NOI18N
        jPanel58.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel221.setBackground(new java.awt.Color(0, 51, 51));
        jLabel221.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel221.setForeground(new java.awt.Color(255, 204, 204));
        jLabel221.setText("Name :");
        jPanel58.add(jLabel221, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel222.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel222.setForeground(new java.awt.Color(255, 204, 204));
        jLabel222.setText("Price :");
        jPanel58.add(jLabel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel223.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel223.setForeground(new java.awt.Color(255, 204, 204));
        jLabel223.setText("Quantity :");
        jPanel58.add(jLabel223, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel224.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel224.setForeground(new java.awt.Color(255, 204, 204));
        jLabel224.setText("Flower HeartBox");
        jPanel58.add(jLabel224, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel225.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel225.setForeground(new java.awt.Color(255, 204, 204));
        jLabel225.setText("10000 .0");
        jPanel58.add(jLabel225, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner32.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel58.add(jSpinner32, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel226.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel226.setForeground(new java.awt.Color(255, 204, 204));
        jLabel226.setText("Purchase :");
        jPanel58.add(jLabel226, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox32ActionPerformed(evt);
            }
        });
        jPanel58.add(jCheckBox32, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel227.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel227.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\basket.jpg")); // NOI18N
        jLabel227.setText("50% ");
        jPanel58.add(jLabel227, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel59.setBackground(new java.awt.Color(0, 51, 51));
        jPanel59.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel59.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel66.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF.gif")); // NOI18N
        jPanel59.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel228.setBackground(new java.awt.Color(0, 51, 51));
        jLabel228.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel228.setForeground(new java.awt.Color(255, 204, 204));
        jLabel228.setText("Name :");
        jPanel59.add(jLabel228, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel229.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel229.setForeground(new java.awt.Color(255, 204, 204));
        jLabel229.setText("Price :");
        jPanel59.add(jLabel229, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel230.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel230.setForeground(new java.awt.Color(255, 204, 204));
        jLabel230.setText("Quantity :");
        jPanel59.add(jLabel230, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel231.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel231.setForeground(new java.awt.Color(255, 204, 204));
        jLabel231.setText("Flower HeartBox");
        jPanel59.add(jLabel231, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel232.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel232.setForeground(new java.awt.Color(255, 204, 204));
        jLabel232.setText("10000 .0");
        jPanel59.add(jLabel232, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner33.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel59.add(jSpinner33, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel233.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel233.setForeground(new java.awt.Color(255, 204, 204));
        jLabel233.setText("Purchase :");
        jPanel59.add(jLabel233, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox33ActionPerformed(evt);
            }
        });
        jPanel59.add(jCheckBox33, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel234.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel234.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\bouquet2.jpg")); // NOI18N
        jLabel234.setText("50% ");
        jPanel59.add(jLabel234, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel60.setBackground(new java.awt.Color(0, 51, 51));
        jPanel60.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel60.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel67.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF.gif")); // NOI18N
        jPanel60.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel235.setBackground(new java.awt.Color(0, 51, 51));
        jLabel235.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel235.setForeground(new java.awt.Color(255, 204, 204));
        jLabel235.setText("Name :");
        jPanel60.add(jLabel235, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel236.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel236.setForeground(new java.awt.Color(255, 204, 204));
        jLabel236.setText("Price :");
        jPanel60.add(jLabel236, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel237.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel237.setForeground(new java.awt.Color(255, 204, 204));
        jLabel237.setText("Quantity :");
        jPanel60.add(jLabel237, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel238.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel238.setForeground(new java.awt.Color(255, 204, 204));
        jLabel238.setText("Flower HeartBox");
        jPanel60.add(jLabel238, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel239.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel239.setForeground(new java.awt.Color(255, 204, 204));
        jLabel239.setText("10000 .0");
        jPanel60.add(jLabel239, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 82, -1));

        jSpinner34.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel60.add(jSpinner34, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel240.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel240.setForeground(new java.awt.Color(255, 204, 204));
        jLabel240.setText("Purchase :");
        jPanel60.add(jLabel240, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox34ActionPerformed(evt);
            }
        });
        jPanel60.add(jCheckBox34, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel241.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel241.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\sunflower.jpg")); // NOI18N
        jLabel241.setText("50% ");
        jPanel60.add(jLabel241, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel61.setBackground(new java.awt.Color(0, 51, 51));
        jPanel61.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel61.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel68.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF.gif")); // NOI18N
        jPanel61.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel242.setBackground(new java.awt.Color(0, 51, 51));
        jLabel242.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel242.setForeground(new java.awt.Color(255, 204, 204));
        jLabel242.setText("Name :");
        jPanel61.add(jLabel242, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel243.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel243.setForeground(new java.awt.Color(255, 204, 204));
        jLabel243.setText("Price :");
        jPanel61.add(jLabel243, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel244.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel244.setForeground(new java.awt.Color(255, 204, 204));
        jLabel244.setText("Quantity :");
        jPanel61.add(jLabel244, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel245.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel245.setForeground(new java.awt.Color(255, 204, 204));
        jLabel245.setText("Flower HeartBox");
        jPanel61.add(jLabel245, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel246.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel246.setForeground(new java.awt.Color(255, 204, 204));
        jLabel246.setText("10000 .0");
        jPanel61.add(jLabel246, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner35.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel61.add(jSpinner35, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel247.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel247.setForeground(new java.awt.Color(255, 204, 204));
        jLabel247.setText("Purchase :");
        jPanel61.add(jLabel247, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox35ActionPerformed(evt);
            }
        });
        jPanel61.add(jCheckBox35, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel248.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel248.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\whiterose.jpg")); // NOI18N
        jLabel248.setText("50% ");
        jPanel61.add(jLabel248, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel62.setBackground(new java.awt.Color(0, 51, 51));
        jPanel62.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel62.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF.gif")); // NOI18N
        jPanel62.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel249.setBackground(new java.awt.Color(0, 51, 51));
        jLabel249.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel249.setForeground(new java.awt.Color(255, 204, 204));
        jLabel249.setText("Name :");
        jPanel62.add(jLabel249, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel250.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel250.setForeground(new java.awt.Color(255, 204, 204));
        jLabel250.setText("Price :");
        jPanel62.add(jLabel250, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel251.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel251.setForeground(new java.awt.Color(255, 204, 204));
        jLabel251.setText("Quantity :");
        jPanel62.add(jLabel251, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel252.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel252.setForeground(new java.awt.Color(255, 204, 204));
        jLabel252.setText("Flower HeartBox");
        jPanel62.add(jLabel252, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel253.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel253.setForeground(new java.awt.Color(255, 204, 204));
        jLabel253.setText("10000 .0");
        jPanel62.add(jLabel253, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner36.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel62.add(jSpinner36, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel254.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel254.setForeground(new java.awt.Color(255, 204, 204));
        jLabel254.setText("Purchase :");
        jPanel62.add(jLabel254, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox36ActionPerformed(evt);
            }
        });
        jPanel62.add(jCheckBox36, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel255.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel255.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\y.jpg")); // NOI18N
        jLabel255.setText("50% ");
        jPanel62.add(jLabel255, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel63.setBackground(new java.awt.Color(0, 51, 51));
        jPanel63.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel63.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel70.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF.gif")); // NOI18N
        jPanel63.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel256.setBackground(new java.awt.Color(0, 51, 51));
        jLabel256.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel256.setForeground(new java.awt.Color(255, 204, 204));
        jLabel256.setText("Name :");
        jPanel63.add(jLabel256, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel257.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel257.setForeground(new java.awt.Color(255, 204, 204));
        jLabel257.setText("Price :");
        jPanel63.add(jLabel257, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel258.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel258.setForeground(new java.awt.Color(255, 204, 204));
        jLabel258.setText("Quantity :");
        jPanel63.add(jLabel258, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel259.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel259.setForeground(new java.awt.Color(255, 204, 204));
        jLabel259.setText("Flower HeartBox");
        jPanel63.add(jLabel259, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel260.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel260.setForeground(new java.awt.Color(255, 204, 204));
        jLabel260.setText("10000 .0");
        jPanel63.add(jLabel260, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner37.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel63.add(jSpinner37, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel261.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel261.setForeground(new java.awt.Color(255, 204, 204));
        jLabel261.setText("Purchase :");
        jPanel63.add(jLabel261, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox37ActionPerformed(evt);
            }
        });
        jPanel63.add(jCheckBox37, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel262.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel262.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\hydragaenia.jpg")); // NOI18N
        jLabel262.setText("50% ");
        jPanel63.add(jLabel262, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel64.setBackground(new java.awt.Color(0, 51, 51));
        jPanel64.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel64.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel71.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF.gif")); // NOI18N
        jPanel64.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel263.setBackground(new java.awt.Color(0, 51, 51));
        jLabel263.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel263.setForeground(new java.awt.Color(255, 204, 204));
        jLabel263.setText("Name :");
        jPanel64.add(jLabel263, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel264.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel264.setForeground(new java.awt.Color(255, 204, 204));
        jLabel264.setText("Price :");
        jPanel64.add(jLabel264, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel265.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel265.setForeground(new java.awt.Color(255, 204, 204));
        jLabel265.setText("Quantity :");
        jPanel64.add(jLabel265, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel266.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel266.setForeground(new java.awt.Color(255, 204, 204));
        jLabel266.setText("Flower HeartBox");
        jPanel64.add(jLabel266, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel267.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel267.setForeground(new java.awt.Color(255, 204, 204));
        jLabel267.setText("10000 .0");
        jPanel64.add(jLabel267, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner38.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel64.add(jSpinner38, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel268.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel268.setForeground(new java.awt.Color(255, 204, 204));
        jLabel268.setText("Purchase :");
        jPanel64.add(jLabel268, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox38ActionPerformed(evt);
            }
        });
        jPanel64.add(jCheckBox38, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel269.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel269.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\bouquet1.jpg")); // NOI18N
        jLabel269.setText("50% ");
        jPanel64.add(jLabel269, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel65.setBackground(new java.awt.Color(0, 51, 51));
        jPanel65.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel65.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF.gif")); // NOI18N
        jPanel65.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel270.setBackground(new java.awt.Color(0, 51, 51));
        jLabel270.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel270.setForeground(new java.awt.Color(255, 204, 204));
        jLabel270.setText("Name :");
        jPanel65.add(jLabel270, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel271.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel271.setForeground(new java.awt.Color(255, 204, 204));
        jLabel271.setText("Price :");
        jPanel65.add(jLabel271, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel272.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel272.setForeground(new java.awt.Color(255, 204, 204));
        jLabel272.setText("Quantity :");
        jPanel65.add(jLabel272, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel273.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel273.setForeground(new java.awt.Color(255, 204, 204));
        jLabel273.setText("Flower HeartBox");
        jPanel65.add(jLabel273, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel274.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel274.setForeground(new java.awt.Color(255, 204, 204));
        jLabel274.setText("10000 .0");
        jPanel65.add(jLabel274, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner39.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel65.add(jSpinner39, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel275.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel275.setForeground(new java.awt.Color(255, 204, 204));
        jLabel275.setText("Purchase :");
        jPanel65.add(jLabel275, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox39ActionPerformed(evt);
            }
        });
        jPanel65.add(jCheckBox39, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel276.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel276.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\pinkrose.jpg")); // NOI18N
        jLabel276.setText("50% ");
        jPanel65.add(jLabel276, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jScrollPane6.setViewportView(jPanel10);

        jLabel73.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 204, 204));
        jLabel73.setText("50% OFF ON YOUR FAVOURITE FLOWERS AND BOUQUETS");

        jLabel74.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 204, 204));
        jLabel74.setText("30% OFF ON YOUR FAVOURITE CAKES AND PASTRIES\n");

        jPanel66.setBackground(new java.awt.Color(0, 51, 51));
        jPanel66.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel66.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel75.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF30.gif")); // NOI18N
        jPanel66.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel277.setBackground(new java.awt.Color(0, 51, 51));
        jLabel277.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel277.setForeground(new java.awt.Color(255, 204, 204));
        jLabel277.setText("Name :");
        jPanel66.add(jLabel277, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel278.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel278.setForeground(new java.awt.Color(255, 204, 204));
        jLabel278.setText("Price :");
        jPanel66.add(jLabel278, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel279.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel279.setForeground(new java.awt.Color(255, 204, 204));
        jLabel279.setText("Quantity :");
        jPanel66.add(jLabel279, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel280.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel280.setForeground(new java.awt.Color(255, 204, 204));
        jLabel280.setText("Flower HeartBox");
        jPanel66.add(jLabel280, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel281.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel281.setForeground(new java.awt.Color(255, 204, 204));
        jLabel281.setText("10000 .0");
        jPanel66.add(jLabel281, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner40.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel66.add(jSpinner40, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel282.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel282.setForeground(new java.awt.Color(255, 204, 204));
        jLabel282.setText("Purchase :");
        jPanel66.add(jLabel282, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox40ActionPerformed(evt);
            }
        });
        jPanel66.add(jCheckBox40, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel283.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel283.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\ferrero.jpg")); // NOI18N
        jLabel283.setText("50% ");
        jPanel66.add(jLabel283, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel67.setBackground(new java.awt.Color(0, 51, 51));
        jPanel67.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel67.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel76.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF30.gif")); // NOI18N
        jPanel67.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel284.setBackground(new java.awt.Color(0, 51, 51));
        jLabel284.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel284.setForeground(new java.awt.Color(255, 204, 204));
        jLabel284.setText("Name :");
        jPanel67.add(jLabel284, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel285.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel285.setForeground(new java.awt.Color(255, 204, 204));
        jLabel285.setText("Price :");
        jPanel67.add(jLabel285, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel286.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel286.setForeground(new java.awt.Color(255, 204, 204));
        jLabel286.setText("Quantity :");
        jPanel67.add(jLabel286, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel287.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel287.setForeground(new java.awt.Color(255, 204, 204));
        jLabel287.setText("Flower HeartBox");
        jPanel67.add(jLabel287, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel288.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel288.setForeground(new java.awt.Color(255, 204, 204));
        jLabel288.setText("10000 .0");
        jPanel67.add(jLabel288, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner41.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel67.add(jSpinner41, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel289.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel289.setForeground(new java.awt.Color(255, 204, 204));
        jLabel289.setText("Purchase :");
        jPanel67.add(jLabel289, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox41ActionPerformed(evt);
            }
        });
        jPanel67.add(jCheckBox41, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel290.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel290.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\chococake.jpg")); // NOI18N
        jLabel290.setText("50% ");
        jPanel67.add(jLabel290, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel68.setBackground(new java.awt.Color(0, 51, 51));
        jPanel68.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel68.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel77.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF30.gif")); // NOI18N
        jPanel68.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel291.setBackground(new java.awt.Color(0, 51, 51));
        jLabel291.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel291.setForeground(new java.awt.Color(255, 204, 204));
        jLabel291.setText("Name :");
        jPanel68.add(jLabel291, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel292.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel292.setForeground(new java.awt.Color(255, 204, 204));
        jLabel292.setText("Price :");
        jPanel68.add(jLabel292, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel293.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel293.setForeground(new java.awt.Color(255, 204, 204));
        jLabel293.setText("Quantity :");
        jPanel68.add(jLabel293, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel294.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel294.setForeground(new java.awt.Color(255, 204, 204));
        jLabel294.setText("Flower HeartBox");
        jPanel68.add(jLabel294, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel295.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel295.setForeground(new java.awt.Color(255, 204, 204));
        jLabel295.setText("10000 .0");
        jPanel68.add(jLabel295, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner42.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel68.add(jSpinner42, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel296.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel296.setForeground(new java.awt.Color(255, 204, 204));
        jLabel296.setText("Purchase :");
        jPanel68.add(jLabel296, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox42ActionPerformed(evt);
            }
        });
        jPanel68.add(jCheckBox42, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel297.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel297.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\jarrcake.jpg")); // NOI18N
        jLabel297.setText("50% ");
        jPanel68.add(jLabel297, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel69.setBackground(new java.awt.Color(0, 51, 51));
        jPanel69.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel69.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel78.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF30.gif")); // NOI18N
        jPanel69.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel298.setBackground(new java.awt.Color(0, 51, 51));
        jLabel298.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel298.setForeground(new java.awt.Color(255, 204, 204));
        jLabel298.setText("Name :");
        jPanel69.add(jLabel298, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel299.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel299.setForeground(new java.awt.Color(255, 204, 204));
        jLabel299.setText("Price :");
        jPanel69.add(jLabel299, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel300.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel300.setForeground(new java.awt.Color(255, 204, 204));
        jLabel300.setText("Quantity :");
        jPanel69.add(jLabel300, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel301.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel301.setForeground(new java.awt.Color(255, 204, 204));
        jLabel301.setText("Flower HeartBox");
        jPanel69.add(jLabel301, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel302.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel302.setForeground(new java.awt.Color(255, 204, 204));
        jLabel302.setText("10000 .0");
        jPanel69.add(jLabel302, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 82, -1));

        jSpinner43.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel69.add(jSpinner43, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel303.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel303.setForeground(new java.awt.Color(255, 204, 204));
        jLabel303.setText("Purchase :");
        jPanel69.add(jLabel303, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox43ActionPerformed(evt);
            }
        });
        jPanel69.add(jCheckBox43, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel304.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel304.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\cheese.jpg")); // NOI18N
        jLabel304.setText("50% ");
        jPanel69.add(jLabel304, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel70.setBackground(new java.awt.Color(0, 51, 51));
        jPanel70.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel70.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel79.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF30.gif")); // NOI18N
        jPanel70.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel305.setBackground(new java.awt.Color(0, 51, 51));
        jLabel305.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel305.setForeground(new java.awt.Color(255, 204, 204));
        jLabel305.setText("Name :");
        jPanel70.add(jLabel305, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel306.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel306.setForeground(new java.awt.Color(255, 204, 204));
        jLabel306.setText("Price :");
        jPanel70.add(jLabel306, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel307.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel307.setForeground(new java.awt.Color(255, 204, 204));
        jLabel307.setText("Quantity :");
        jPanel70.add(jLabel307, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel308.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel308.setForeground(new java.awt.Color(255, 204, 204));
        jLabel308.setText("Flower HeartBox");
        jPanel70.add(jLabel308, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel309.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel309.setForeground(new java.awt.Color(255, 204, 204));
        jLabel309.setText("10000 .0");
        jPanel70.add(jLabel309, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner44.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel70.add(jSpinner44, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel310.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel310.setForeground(new java.awt.Color(255, 204, 204));
        jLabel310.setText("Purchase :");
        jPanel70.add(jLabel310, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox44ActionPerformed(evt);
            }
        });
        jPanel70.add(jCheckBox44, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel311.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel311.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\icecream.jpg")); // NOI18N
        jLabel311.setText("50% ");
        jPanel70.add(jLabel311, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel71.setBackground(new java.awt.Color(0, 51, 51));
        jPanel71.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel71.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel80.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF30.gif")); // NOI18N
        jPanel71.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel312.setBackground(new java.awt.Color(0, 51, 51));
        jLabel312.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel312.setForeground(new java.awt.Color(255, 204, 204));
        jLabel312.setText("Name :");
        jPanel71.add(jLabel312, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel313.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel313.setForeground(new java.awt.Color(255, 204, 204));
        jLabel313.setText("Price :");
        jPanel71.add(jLabel313, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel314.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel314.setForeground(new java.awt.Color(255, 204, 204));
        jLabel314.setText("Quantity :");
        jPanel71.add(jLabel314, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel315.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel315.setForeground(new java.awt.Color(255, 204, 204));
        jLabel315.setText("Flower HeartBox");
        jPanel71.add(jLabel315, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel316.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel316.setForeground(new java.awt.Color(255, 204, 204));
        jLabel316.setText("10000 .0");
        jPanel71.add(jLabel316, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner45.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel71.add(jSpinner45, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel317.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel317.setForeground(new java.awt.Color(255, 204, 204));
        jLabel317.setText("Purchase :");
        jPanel71.add(jLabel317, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox45ActionPerformed(evt);
            }
        });
        jPanel71.add(jCheckBox45, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel318.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel318.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\macaron.jpg")); // NOI18N
        jLabel318.setText("50% ");
        jPanel71.add(jLabel318, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel72.setBackground(new java.awt.Color(0, 51, 51));
        jPanel72.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel72.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel81.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF.gif")); // NOI18N
        jPanel72.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel319.setBackground(new java.awt.Color(0, 51, 51));
        jLabel319.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel319.setForeground(new java.awt.Color(255, 204, 204));
        jLabel319.setText("Name :");
        jPanel72.add(jLabel319, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel320.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel320.setForeground(new java.awt.Color(255, 204, 204));
        jLabel320.setText("Price :");
        jPanel72.add(jLabel320, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel321.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel321.setForeground(new java.awt.Color(255, 204, 204));
        jLabel321.setText("Quantity :");
        jPanel72.add(jLabel321, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel322.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel322.setForeground(new java.awt.Color(255, 204, 204));
        jLabel322.setText("Flower HeartBox");
        jPanel72.add(jLabel322, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel323.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel323.setForeground(new java.awt.Color(255, 204, 204));
        jLabel323.setText("10000 .0");
        jPanel72.add(jLabel323, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner46.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel72.add(jSpinner46, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel324.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel324.setForeground(new java.awt.Color(255, 204, 204));
        jLabel324.setText("Purchase :");
        jPanel72.add(jLabel324, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox46ActionPerformed(evt);
            }
        });
        jPanel72.add(jCheckBox46, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel325.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel325.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\vanillacake.jpg")); // NOI18N
        jLabel325.setText("50% ");
        jPanel72.add(jLabel325, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel73.setBackground(new java.awt.Color(0, 51, 51));
        jPanel73.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel73.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel82.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF.gif")); // NOI18N
        jPanel73.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel326.setBackground(new java.awt.Color(0, 51, 51));
        jLabel326.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel326.setForeground(new java.awt.Color(255, 204, 204));
        jLabel326.setText("Name :");
        jPanel73.add(jLabel326, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel327.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel327.setForeground(new java.awt.Color(255, 204, 204));
        jLabel327.setText("Price :");
        jPanel73.add(jLabel327, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel328.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel328.setForeground(new java.awt.Color(255, 204, 204));
        jLabel328.setText("Quantity :");
        jPanel73.add(jLabel328, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel329.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel329.setForeground(new java.awt.Color(255, 204, 204));
        jLabel329.setText("Flower HeartBox");
        jPanel73.add(jLabel329, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel330.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel330.setForeground(new java.awt.Color(255, 204, 204));
        jLabel330.setText("10000 .0");
        jPanel73.add(jLabel330, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner47.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel73.add(jSpinner47, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel331.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel331.setForeground(new java.awt.Color(255, 204, 204));
        jLabel331.setText("Purchase :");
        jPanel73.add(jLabel331, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox47ActionPerformed(evt);
            }
        });
        jPanel73.add(jCheckBox47, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel332.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel332.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\cupcake.jpg")); // NOI18N
        jLabel332.setText("50% ");
        jPanel73.add(jLabel332, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel74.setBackground(new java.awt.Color(0, 51, 51));
        jPanel74.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel74.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel83.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF.gif")); // NOI18N
        jPanel74.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel333.setBackground(new java.awt.Color(0, 51, 51));
        jLabel333.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel333.setForeground(new java.awt.Color(255, 204, 204));
        jLabel333.setText("Name :");
        jPanel74.add(jLabel333, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel334.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel334.setForeground(new java.awt.Color(255, 204, 204));
        jLabel334.setText("Price :");
        jPanel74.add(jLabel334, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel335.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel335.setForeground(new java.awt.Color(255, 204, 204));
        jLabel335.setText("Quantity :");
        jPanel74.add(jLabel335, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel336.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel336.setForeground(new java.awt.Color(255, 204, 204));
        jLabel336.setText("Flower HeartBox");
        jPanel74.add(jLabel336, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel337.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel337.setForeground(new java.awt.Color(255, 204, 204));
        jLabel337.setText("10000 .0");
        jPanel74.add(jLabel337, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner48.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel74.add(jSpinner48, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel338.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel338.setForeground(new java.awt.Color(255, 204, 204));
        jLabel338.setText("Purchase :");
        jPanel74.add(jLabel338, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox48ActionPerformed(evt);
            }
        });
        jPanel74.add(jCheckBox48, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel339.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel339.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\oreo.jpg")); // NOI18N
        jLabel339.setText("50% ");
        jPanel74.add(jLabel339, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel67, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel71, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel72, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel73, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jScrollPane7.setViewportView(jPanel11);

        jLabel84.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 204, 204));
        jLabel84.setText("75% OFF ON YOUR FAVOURITE CHOCOLATES AND CANDIES\n\n");

        jPanel75.setBackground(new java.awt.Color(0, 51, 51));
        jPanel75.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel75.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel85.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF75.gif")); // NOI18N
        jPanel75.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel340.setBackground(new java.awt.Color(0, 51, 51));
        jLabel340.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel340.setForeground(new java.awt.Color(255, 204, 204));
        jLabel340.setText("Name :");
        jPanel75.add(jLabel340, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel341.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel341.setForeground(new java.awt.Color(255, 204, 204));
        jLabel341.setText("Price :");
        jPanel75.add(jLabel341, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel342.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel342.setForeground(new java.awt.Color(255, 204, 204));
        jLabel342.setText("Quantity :");
        jPanel75.add(jLabel342, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel343.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel343.setForeground(new java.awt.Color(255, 204, 204));
        jLabel343.setText("Flower HeartBox");
        jPanel75.add(jLabel343, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel344.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel344.setForeground(new java.awt.Color(255, 204, 204));
        jLabel344.setText("10000 .0");
        jPanel75.add(jLabel344, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner49.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel75.add(jSpinner49, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel345.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel345.setForeground(new java.awt.Color(255, 204, 204));
        jLabel345.setText("Purchase :");
        jPanel75.add(jLabel345, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox49ActionPerformed(evt);
            }
        });
        jPanel75.add(jCheckBox49, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel346.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel346.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\chocobar.jpg")); // NOI18N
        jLabel346.setText("50% ");
        jPanel75.add(jLabel346, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel76.setBackground(new java.awt.Color(0, 51, 51));
        jPanel76.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel76.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel86.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF75.gif")); // NOI18N
        jPanel76.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel347.setBackground(new java.awt.Color(0, 51, 51));
        jLabel347.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel347.setForeground(new java.awt.Color(255, 204, 204));
        jLabel347.setText("Name :");
        jPanel76.add(jLabel347, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel348.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel348.setForeground(new java.awt.Color(255, 204, 204));
        jLabel348.setText("Price :");
        jPanel76.add(jLabel348, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel349.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel349.setForeground(new java.awt.Color(255, 204, 204));
        jLabel349.setText("Quantity :");
        jPanel76.add(jLabel349, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel350.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel350.setForeground(new java.awt.Color(255, 204, 204));
        jLabel350.setText("Flower HeartBox");
        jPanel76.add(jLabel350, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel351.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel351.setForeground(new java.awt.Color(255, 204, 204));
        jLabel351.setText("10000 .0");
        jPanel76.add(jLabel351, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner50.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel76.add(jSpinner50, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel352.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel352.setForeground(new java.awt.Color(255, 204, 204));
        jLabel352.setText("Purchase :");
        jPanel76.add(jLabel352, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox50ActionPerformed(evt);
            }
        });
        jPanel76.add(jCheckBox50, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel353.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel353.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\cookie.jpg")); // NOI18N
        jLabel353.setText("50% ");
        jPanel76.add(jLabel353, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel77.setBackground(new java.awt.Color(0, 51, 51));
        jPanel77.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel77.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel87.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF75.gif")); // NOI18N
        jPanel77.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel354.setBackground(new java.awt.Color(0, 51, 51));
        jLabel354.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel354.setForeground(new java.awt.Color(255, 204, 204));
        jLabel354.setText("Name :");
        jPanel77.add(jLabel354, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel355.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel355.setForeground(new java.awt.Color(255, 204, 204));
        jLabel355.setText("Price :");
        jPanel77.add(jLabel355, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel356.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel356.setForeground(new java.awt.Color(255, 204, 204));
        jLabel356.setText("Quantity :");
        jPanel77.add(jLabel356, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel357.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel357.setForeground(new java.awt.Color(255, 204, 204));
        jLabel357.setText("Flower HeartBox");
        jPanel77.add(jLabel357, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel358.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel358.setForeground(new java.awt.Color(255, 204, 204));
        jLabel358.setText("10000 .0");
        jPanel77.add(jLabel358, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner51.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel77.add(jSpinner51, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel359.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel359.setForeground(new java.awt.Color(255, 204, 204));
        jLabel359.setText("Purchase :");
        jPanel77.add(jLabel359, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox51ActionPerformed(evt);
            }
        });
        jPanel77.add(jCheckBox51, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel360.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel360.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\lindor.jpg")); // NOI18N
        jLabel360.setText("50% ");
        jPanel77.add(jLabel360, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel78.setBackground(new java.awt.Color(0, 51, 51));
        jPanel78.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel78.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel88.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF75.gif")); // NOI18N
        jPanel78.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel361.setBackground(new java.awt.Color(0, 51, 51));
        jLabel361.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel361.setForeground(new java.awt.Color(255, 204, 204));
        jLabel361.setText("Name :");
        jPanel78.add(jLabel361, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel362.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel362.setForeground(new java.awt.Color(255, 204, 204));
        jLabel362.setText("Price :");
        jPanel78.add(jLabel362, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel363.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel363.setForeground(new java.awt.Color(255, 204, 204));
        jLabel363.setText("Quantity :");
        jPanel78.add(jLabel363, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel364.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel364.setForeground(new java.awt.Color(255, 204, 204));
        jLabel364.setText("Flower HeartBox");
        jPanel78.add(jLabel364, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel365.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel365.setForeground(new java.awt.Color(255, 204, 204));
        jLabel365.setText("10000 .0");
        jPanel78.add(jLabel365, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 82, -1));

        jSpinner52.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel78.add(jSpinner52, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel366.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel366.setForeground(new java.awt.Color(255, 204, 204));
        jLabel366.setText("Purchase :");
        jPanel78.add(jLabel366, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox52ActionPerformed(evt);
            }
        });
        jPanel78.add(jCheckBox52, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel367.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel367.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\chocojar.jpg")); // NOI18N
        jLabel367.setText("50% ");
        jPanel78.add(jLabel367, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel79.setBackground(new java.awt.Color(0, 51, 51));
        jPanel79.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel79.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel89.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF75.gif")); // NOI18N
        jPanel79.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel368.setBackground(new java.awt.Color(0, 51, 51));
        jLabel368.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel368.setForeground(new java.awt.Color(255, 204, 204));
        jLabel368.setText("Name :");
        jPanel79.add(jLabel368, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel369.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel369.setForeground(new java.awt.Color(255, 204, 204));
        jLabel369.setText("Price :");
        jPanel79.add(jLabel369, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel370.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel370.setForeground(new java.awt.Color(255, 204, 204));
        jLabel370.setText("Quantity :");
        jPanel79.add(jLabel370, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel371.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel371.setForeground(new java.awt.Color(255, 204, 204));
        jLabel371.setText("Flower HeartBox");
        jPanel79.add(jLabel371, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel372.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel372.setForeground(new java.awt.Color(255, 204, 204));
        jLabel372.setText("10000 .0");
        jPanel79.add(jLabel372, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner53.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel79.add(jSpinner53, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel373.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel373.setForeground(new java.awt.Color(255, 204, 204));
        jLabel373.setText("Purchase :");
        jPanel79.add(jLabel373, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox53ActionPerformed(evt);
            }
        });
        jPanel79.add(jCheckBox53, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel374.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel374.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\heartbox1.jpg")); // NOI18N
        jLabel374.setText("50% ");
        jPanel79.add(jLabel374, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel80.setBackground(new java.awt.Color(0, 51, 51));
        jPanel80.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel80.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel90.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF75.gif")); // NOI18N
        jPanel80.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel375.setBackground(new java.awt.Color(0, 51, 51));
        jLabel375.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel375.setForeground(new java.awt.Color(255, 204, 204));
        jLabel375.setText("Name :");
        jPanel80.add(jLabel375, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel376.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel376.setForeground(new java.awt.Color(255, 204, 204));
        jLabel376.setText("Price :");
        jPanel80.add(jLabel376, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel377.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel377.setForeground(new java.awt.Color(255, 204, 204));
        jLabel377.setText("Quantity :");
        jPanel80.add(jLabel377, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel378.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel378.setForeground(new java.awt.Color(255, 204, 204));
        jLabel378.setText("Flower HeartBox");
        jPanel80.add(jLabel378, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel379.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel379.setForeground(new java.awt.Color(255, 204, 204));
        jLabel379.setText("10000 .0");
        jPanel80.add(jLabel379, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner54.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel80.add(jSpinner54, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel380.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel380.setForeground(new java.awt.Color(255, 204, 204));
        jLabel380.setText("Purchase :");
        jPanel80.add(jLabel380, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox54ActionPerformed(evt);
            }
        });
        jPanel80.add(jCheckBox54, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel381.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel381.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\lollypop.jpg")); // NOI18N
        jLabel381.setText("50% ");
        jPanel80.add(jLabel381, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel81.setBackground(new java.awt.Color(0, 51, 51));
        jPanel81.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel81.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel91.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF75.gif")); // NOI18N
        jPanel81.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel382.setBackground(new java.awt.Color(0, 51, 51));
        jLabel382.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel382.setForeground(new java.awt.Color(255, 204, 204));
        jLabel382.setText("Name :");
        jPanel81.add(jLabel382, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel383.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel383.setForeground(new java.awt.Color(255, 204, 204));
        jLabel383.setText("Price :");
        jPanel81.add(jLabel383, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel384.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel384.setForeground(new java.awt.Color(255, 204, 204));
        jLabel384.setText("Quantity :");
        jPanel81.add(jLabel384, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel385.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel385.setForeground(new java.awt.Color(255, 204, 204));
        jLabel385.setText("Flower HeartBox");
        jPanel81.add(jLabel385, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel386.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel386.setForeground(new java.awt.Color(255, 204, 204));
        jLabel386.setText("10000 .0");
        jPanel81.add(jLabel386, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner55.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel81.add(jSpinner55, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel387.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel387.setForeground(new java.awt.Color(255, 204, 204));
        jLabel387.setText("Purchase :");
        jPanel81.add(jLabel387, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox55ActionPerformed(evt);
            }
        });
        jPanel81.add(jCheckBox55, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel388.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel388.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\oreoo.jpg")); // NOI18N
        jLabel388.setText("50% ");
        jPanel81.add(jLabel388, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel82.setBackground(new java.awt.Color(0, 51, 51));
        jPanel82.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel82.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel92.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF75.gif")); // NOI18N
        jPanel82.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel389.setBackground(new java.awt.Color(0, 51, 51));
        jLabel389.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel389.setForeground(new java.awt.Color(255, 204, 204));
        jLabel389.setText("Name :");
        jPanel82.add(jLabel389, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel390.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel390.setForeground(new java.awt.Color(255, 204, 204));
        jLabel390.setText("Price :");
        jPanel82.add(jLabel390, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel391.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel391.setForeground(new java.awt.Color(255, 204, 204));
        jLabel391.setText("Quantity :");
        jPanel82.add(jLabel391, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel392.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel392.setForeground(new java.awt.Color(255, 204, 204));
        jLabel392.setText("Flower HeartBox");
        jPanel82.add(jLabel392, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel393.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel393.setForeground(new java.awt.Color(255, 204, 204));
        jLabel393.setText("10000 .0");
        jPanel82.add(jLabel393, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner56.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel82.add(jSpinner56, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel394.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel394.setForeground(new java.awt.Color(255, 204, 204));
        jLabel394.setText("Purchase :");
        jPanel82.add(jLabel394, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox56ActionPerformed(evt);
            }
        });
        jPanel82.add(jCheckBox56, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel395.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel395.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\heartbox2.jpg")); // NOI18N
        jLabel395.setText("50% ");
        jPanel82.add(jLabel395, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        jPanel83.setBackground(new java.awt.Color(0, 51, 51));
        jPanel83.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(8, 61, 65), 4, true));
        jPanel83.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel93.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\OFF75.gif")); // NOI18N
        jPanel83.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 69));

        jLabel396.setBackground(new java.awt.Color(0, 51, 51));
        jLabel396.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel396.setForeground(new java.awt.Color(255, 204, 204));
        jLabel396.setText("Name :");
        jPanel83.add(jLabel396, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 48, -1));

        jLabel397.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel397.setForeground(new java.awt.Color(255, 204, 204));
        jLabel397.setText("Price :");
        jPanel83.add(jLabel397, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, 37, -1));

        jLabel398.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel398.setForeground(new java.awt.Color(255, 204, 204));
        jLabel398.setText("Quantity :");
        jPanel83.add(jLabel398, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, -1, -1));

        jLabel399.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel399.setForeground(new java.awt.Color(255, 204, 204));
        jLabel399.setText("Flower HeartBox");
        jPanel83.add(jLabel399, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 202, 82, -1));

        jLabel400.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel400.setForeground(new java.awt.Color(255, 204, 204));
        jLabel400.setText("10000 .0");
        jPanel83.add(jLabel400, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 223, 82, -1));

        jSpinner57.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel83.add(jSpinner57, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 82, -1));

        jLabel401.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel401.setForeground(new java.awt.Color(255, 204, 204));
        jLabel401.setText("Purchase :");
        jPanel83.add(jLabel401, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, -1, -1));

        jCheckBox57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox57ActionPerformed(evt);
            }
        });
        jPanel83.add(jCheckBox57, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 272, 30, 14));

        jLabel402.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel402.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\kitkat.jpg")); // NOI18N
        jLabel402.setText("50% ");
        jPanel83.add(jLabel402, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 148, 186));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel75, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel76, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel78, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel77, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel79, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel80, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel81, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel82, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jPanel83, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jScrollPane8.setViewportView(jPanel12);

        jLabel94.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 204, 204));
        jLabel94.setText("©2023 SPRINKLES. All Rights Reserved");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1278, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(3697, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel94)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(361, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel94)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab4", jPanel6);

        jScrollPane1.setViewportView(jTabbedPane1);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\logout.png")); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 203, 190));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Sprinkle\\src\\Sprinkles\\gift-box (1).png")); // NOI18N
        jLabel5.setText("S P R I N K L E S");

        prof.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        prof.setForeground(new java.awt.Color(255, 255, 255));
        prof.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prof.setText("HELLO USER");
        prof.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profMouseClicked(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Sprinkle\\src\\Sprinkles\\add-in-shopping-cart.png")); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\heartu.png")); // NOI18N

        jLabel1.setFont(new java.awt.Font("Rockwell Condensed", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\ques.png")); // NOI18N
        jLabel1.setText("FAQ");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jPanel15.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setBackground(new java.awt.Color(8, 61, 65));

        jLabel16.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 203, 190));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("D R E S S E S");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel15.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 230, 40));

        jPanel18.setBackground(new java.awt.Color(8, 61, 65));

        jLabel39.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 203, 190));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("C H O C O L A T E S");
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel15.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 230, 40));

        jPanel19.setBackground(new java.awt.Color(8, 61, 65));

        jLabel40.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 203, 190));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("F L O W E R S");
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel15.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 230, 40));

        jPanel21.setBackground(new java.awt.Color(8, 61, 65));

        jLabel42.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 203, 190));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("C A K E S");
        jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel42MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel15.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 230, 40));

        jPanel22.setBackground(new java.awt.Color(8, 61, 65));

        jLabel47.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 204, 204));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("D A S H B O A R D");
        jLabel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel47MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 230, 40));

        jPanel25.setBackground(new java.awt.Color(8, 61, 65));

        jLabel46.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 203, 190));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("O F F E R S");
        jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel46MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel15.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 230, 40));

        jLabel17.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 203, 190));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Sprinkle\\src\\Sprinkles\\gift-box (1).png")); // NOI18N
        jLabel17.setText("S P R I N K L E S");
        jPanel15.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\clock.png")); // NOI18N
        jLabel18.setText("Sat - Fri / 9:00 AM - 10:00 PM");
        jPanel15.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 190, 30));

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\loc.png")); // NOI18N
        jLabel20.setText("Kaptai, Highway Rawzan ");
        jPanel15.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 170, 30));

        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("Pahartali Road, Chattogram 4349");
        jPanel15.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 190, 30));

        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\phone.png")); // NOI18N
        jLabel54.setText("Phone: +880 1971 971 520");
        jPanel15.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 190, 30));

        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\mail.png")); // NOI18N
        jLabel55.setText(" Email: co.sprinkles@gmail.com");
        jPanel15.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 200, 30));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(358, 358, 358)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(286, 286, 286)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(prof, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1833, 1833, 1833))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(prof, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(659, 659, 659))
        );

        jMenuBar1.setBackground(new java.awt.Color(51, 0, 51));

        jMenu1.setText("Main Features");
        jMenu1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jMenu1MouseMoved(evt);
            }
        });

        jMenuItem1.setText("Cakes");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Flowers");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Chocolates");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Dresses");
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Books");
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Watches");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setText("Lifestyle");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem8.setText("Offers");
        jMenu1.add(jMenuItem8);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Useful Links");

        PP.setText("Privacy Policy");
        PP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PPActionPerformed(evt);
            }
        });
        jMenu2.add(PP);

        TC.setText("Terms & Conditions");
        TC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TCActionPerformed(evt);
            }
        });
        jMenu2.add(TC);

        RR.setText("Return & Refund Policy");
        RR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RRActionPerformed(evt);
            }
        });
        jMenu2.add(RR);

        WC.setText("Warranty Guide");
        WC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WCActionPerformed(evt);
            }
        });
        jMenu2.add(WC);

        jMenuBar1.add(jMenu2);

        About.setText("About Us");
        About.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AboutMouseClicked(evt);
            }
        });
        About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutActionPerformed(evt);
            }
        });
        jMenuBar1.add(About);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jLabel47MouseClicked

    private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jLabel42MouseClicked

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jLabel40MouseClicked

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
        // TODO add your handling code here:
        //new Chocolates().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel39MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner24.getValue()!=0){
            CartProduct.add("Sunflower");
            CartPrice.add(3000);
            CartQuantity.add((Integer) jSpinner24.getValue());
            JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner25.getValue()!=0){
            CartProduct.add("Flower Basket");
            CartPrice.add(2000);
            CartQuantity.add((Integer) jSpinner25.getValue());
            JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner23.getValue()!=0){
            CartProduct.add("Rose HeartBox");
            CartPrice.add(10000);
            CartQuantity.add((Integer) jSpinner23.getValue());
            JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void caktax1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caktax1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caktax1ActionPerformed

    private void caktot1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caktot1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caktot1ActionPerformed

    private void caksubtot1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caksubtot1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caksubtot1ActionPerformed

    private void jCheckBox27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox27ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner27.getValue().toString());
        if(qtyzero(qty)&& jCheckBox27.isSelected()){
            x++;
            if(x== 1)
            {
                royalsprinkle1();
            }
            double price = qty*3000.0;
            total += price;
            getTax(total);
            memo1.setText(memo1.getText()+x+". "+jLabel189.getText()+"\t\t"+price+"\n");
            dudatef();
        }else{
            jCheckBox27.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox27ActionPerformed

    private void jCheckBox26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox26ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner26.getValue().toString());
        if(qtyzero(qty)&& jCheckBox26.isSelected()){
            x++;
            if(x== 1)
            {
                royalsprinkle1();
            }
            double price = qty*200.0;
            total += price;
            getTax(total);
            memo1.setText(memo1.getText()+x+". "+jLabel182.getText()+"\t\t\t"+price+"\n");
            dudatef();
        }else{
            jCheckBox26.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox26ActionPerformed

    private void jCheckBox25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox25ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner25.getValue().toString());
        if(qtyzero(qty)&& jCheckBox25.isSelected()){
            x++;
            if(x== 1)
            {
                royalsprinkle1();
            }
            double price = qty*2000.0;
            total += price;
            getTax(total);
            memo1.setText(memo1.getText()+x+". "+jLabel175.getText()+"\t\t"+price+"\n");
            dudatef();
        }else{
            jCheckBox25.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox25ActionPerformed

    private void jCheckBox24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox24ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner24.getValue().toString());
        if(qtyzero(qty)&& jCheckBox24.isSelected()){
            x++;
            if(x== 1)
            {
                royalsprinkle1();
            }
            double price = qty*3000.0;
            total += price;
            getTax(total);
            memo1.setText(memo1.getText()+x+". "+jLabel168.getText()+"\t\t\t"+price+"\n");
            dudatef();
        }else{
            jCheckBox24.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox24ActionPerformed

    private void jCheckBox23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox23ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner23.getValue().toString());
        if(qtyzero(qty)&& jCheckBox23.isSelected()){
            x++;
            if(x== 1)
            {
                royalsprinkle1();
            }
            double price = qty*10000.0;
            total += price;
            getTax(total);
            memo1.setText(memo1.getText()+x+". "+jLabel161.getText()+"\t\t"+price+"\n");
            dudatef();
        }else{
            jCheckBox23.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox23ActionPerformed

    private void caksubtot2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caksubtot2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caksubtot2ActionPerformed

    private void cart11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cart11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cart11ActionPerformed

    private void cart11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cart11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cart11MouseClicked

    private void cart10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cart10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cart10ActionPerformed

    private void cart10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cart10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cart10MouseClicked

    private void cart9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cart9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cart9ActionPerformed

    private void cart9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cart9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cart9MouseClicked

    private void cart8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cart8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cart8ActionPerformed

    private void cart8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cart8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cart8MouseClicked

    private void cart7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cart7ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner18.getValue()!=0){
            CartProduct.add("Ice-cream Cake");
            CartPrice.add(3000);
            CartQuantity.add((Integer) jSpinner18.getValue());
            JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_cart7ActionPerformed

    private void cart7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cart7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cart7MouseClicked

    private void cart6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cart6ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner19.getValue()!=0){
            CartProduct.add("Jar Cake");
            CartPrice.add(300);
            CartQuantity.add((Integer) jSpinner19.getValue());
            JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_cart6ActionPerformed

    private void cart6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cart6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cart6MouseClicked

    private void cart5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cart5ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner15.getValue()!=0){
            CartProduct.add("Cheese Cake");
            CartPrice.add(3000);
            CartQuantity.add((Integer) jSpinner15.getValue());
            JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_cart5ActionPerformed

    private void cart5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cart5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cart5MouseClicked

    private void cart4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cart4ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner16.getValue()!=0){
            CartProduct.add("Chocolate Cake");
            CartPrice.add(2000);
            CartQuantity.add((Integer) jSpinner16.getValue());
            JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_cart4ActionPerformed

    private void cart4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cart4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cart4MouseClicked

    private void cart3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cart3ActionPerformed
        // TODO add your handling code here:
        if((Integer)jSpinner14.getValue()!=0){
            CartProduct.add("Ferrero Rocher Cake");
            CartPrice.add(10000);
            CartQuantity.add((Integer) jSpinner14.getValue());
            JOptionPane.showMessageDialog(null,"Added To Cart");
        }
    }//GEN-LAST:event_cart3ActionPerformed

    private void cart3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cart3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cart3MouseClicked

    private void caktaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caktaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caktaxActionPerformed

    private void jCheckBox18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox18ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner18.getValue().toString());
        if(qtyzero(qty)&& jCheckBox18.isSelected()){
            x++;
            if(x== 1)
            {
                royalsprinkle();
            }
            double price = qty*3000.0;
            total += price;
            getTax(total);
            memo.setText(memo.getText()+x+". "+jLabel126.getText()+"\t\t"+price+"\n");
            dudatec();
        }else{
            jCheckBox18.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox18ActionPerformed

    private void jCheckBox17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox17ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner17.getValue().toString());
        if(qtyzero(qty)&& jCheckBox17.isSelected()){
            x++;
            if(x== 1)
            {
                royalsprinkle();
            }
            double price = qty*200.0;
            total += price;
            getTax(total);
            memo.setText(memo.getText()+x+". "+jLabel119.getText()+"\t\t\t"+price+"\n");
            dudatec();
        }else{
            jCheckBox17.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox17ActionPerformed

    private void jCheckBox15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox15ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner15.getValue().toString());
        if(qtyzero(qty)&& jCheckBox15.isSelected()){
            x++;
            if(x== 1)
            {
                royalsprinkle();
            }
            double price = qty*3000.0;
            total += price;
            getTax(total);
            memo.setText(memo.getText()+x+". "+jLabel105.getText()+"\t\t\t"+price+"\n");
            dudatec();
            String tk=jLabel106.getText();
        int tk1=Integer.parseInt(tk);
        //ImageIcon image = new ImageIcon(getClass().getResource("/cactus/page 1.jpeg"));
        String name=jLabel105.getText();

        insertorder(tk1,name);
        String e=jLabel106.getText();
        int p = Integer.parseInt(e);
        p = p+120;
        String pp = String.valueOf(p);
        order hh = new order();
                
                hh.show();
                hh.item.setText(e);
                hh.total.setText(pp);
        }else{
            jCheckBox15.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox15ActionPerformed

    private void ssKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ssKeyReleased
        // TODO add your handling code here:
       // searchFilter(String.valueOf(ss.getText()));
       try {
        // Remove any existing timers
        if (delayTimer != null && delayTimer.isRunning()) {
            delayTimer.stop();
        }

        // Set up a new timer
        delayTimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Timer has elapsed, perform the desired action
                try {
                    String search = ss.getText().trim();
                    if (!search.equals("")) {
                        b1 = true;b = false;
                        po =  "SELECT CatName FROM category WHERE CatName LIKE ?";
                        mod.removeAllElements();
                        for (String item : retrieveSuggestionsFromDatabase(search)) {
                            mod.addElement(item.toString());
                        }
                        menu.show(ss, 0, ss.getHeight());
                        // showPopupMenu();
                    }
                } catch (Exception ex) {  
                    ex.printStackTrace();
                }
            }
        });

        // Start the timer after a delay
        delayTimer.setRepeats(false); // Set to false for a one-time execution
        delayTimer.start();
        
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // User has selected an item, copy it to the text field
                    String selectedValue = list.getSelectedValue();
                    ss.setText(selectedValue);

                    // Hide the suggestion menu or perform any other desired action
                    menu.setVisible(false);
                }
            }
        });

    } catch (Exception e) {
        e.printStackTrace();
    }
          
       
    
    }//GEN-LAST:event_ssKeyReleased

    private void ssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ssActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void flowerbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flowerbuttonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_flowerbuttonActionPerformed

    private void chocobuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chocobuttonActionPerformed
        // TODO add your handling code here:
        //new Chocolates().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_chocobuttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //this.toBack();

       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jLabel50MouseClicked

    private void jLabel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jLabel48MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        new FAQ().setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        
        Cart c = new Cart(CartProduct,CartPrice,CartQuantity);
        c.setVisible(true);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void profMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profMouseClicked
        // TODO add your handling code here:
        profile pp = new profile();
        pp.setVisible(true);
        
    }//GEN-LAST:event_profMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
       try {
    stmt = conn.createStatement();
    String sql = "DELETE FROM profile";
    stmt.executeUpdate(sql);
    new LoginPage().setVisible(true);
    this.dispose();
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}

    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jLabel46MouseClicked

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenu1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MouseMoved

    private void PPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PPActionPerformed
        // TODO add your handling code here:
        new Policy().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_PPActionPerformed

    private void TCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TCActionPerformed
        // TODO add your handling code here:
        new Aboutt().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_TCActionPerformed

    private void RRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RRActionPerformed
        // TODO add your handling code here:
        new Return().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_RRActionPerformed

    private void WCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WCActionPerformed
        // TODO add your handling code here:
        new Return().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_WCActionPerformed

    private void AboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AboutMouseClicked
        // TODO add your handling code here:
        new Aboutt().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AboutMouseClicked

    private void AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutActionPerformed
        // TODO add your handling code here:
        new Aboutt().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AboutActionPerformed
public void insertorder(int tk, String Name) {
    int customerid = 1;
    String status = "Pending";
    String cusn = "fari";
    int quantity = 1;

    try {
        conn = DBconnection.getConnection();
        String sql = "insert into cusord(Item, Price, status, ID, Name) values(?, ?, ?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, Name);  // Set 'itna' as the first parameter
        pst.setInt(2, tk);       // Set 'itprice' as the second parameter
        pst.setString(3, status);
        pst.setInt(4, customerid);
        pst.setString(5, cusn);

        int UpdatedRowCount = pst.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    private void jCheckBox31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox31ActionPerformed

    private void jCheckBox32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox32ActionPerformed

    private void jCheckBox33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox33ActionPerformed

    private void jCheckBox34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox34ActionPerformed

    private void jCheckBox35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox35ActionPerformed

    private void jCheckBox36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox36ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox36ActionPerformed

    private void jCheckBox37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox37ActionPerformed

    private void jCheckBox38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox38ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox38ActionPerformed

    private void jCheckBox39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox39ActionPerformed

    private void jCheckBox40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox40ActionPerformed

    private void jCheckBox41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox41ActionPerformed

    private void jCheckBox42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox42ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox42ActionPerformed

    private void jCheckBox43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox43ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox43ActionPerformed

    private void jCheckBox44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox44ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox44ActionPerformed

    private void jCheckBox45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox45ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox45ActionPerformed

    private void jCheckBox46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox46ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox46ActionPerformed

    private void jCheckBox47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox47ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox47ActionPerformed

    private void jCheckBox48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox48ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox48ActionPerformed

    private void jCheckBox49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox49ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox49ActionPerformed

    private void jCheckBox50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox50ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox50ActionPerformed

    private void jCheckBox51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox51ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox51ActionPerformed

    private void jCheckBox52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox52ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox52ActionPerformed

    private void jCheckBox53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox53ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox53ActionPerformed

    private void jCheckBox54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox54ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox54ActionPerformed

    private void jCheckBox55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox55ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox55ActionPerformed

    private void jCheckBox56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox56ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox56ActionPerformed

    private void jCheckBox57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox57ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox57ActionPerformed

    private void jCheckBox19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox19ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner16.getValue().toString());
        if(qtyzero(qty)&& jCheckBox1.isSelected()){
            x++;
            if(x== 1)
            {
                royalsprinkle();
            }
            double price = qty*2000.0;
            total += price;
            getTax(total);
            memo.setText(memo.getText()+x+". "+jLabel112.getText()+"\t\t\t"+price+"\n");
            dudatec();
            String tk=jLabel113.getText();
        int tk1=Integer.parseInt(tk);
        //ImageIcon image = new ImageIcon(getClass().getResource("/cactus/page 1.jpeg"));
        String name=jLabel112.getText();

        insertorder(tk1,name);
        String e=jLabel113.getText();
        int p = Integer.parseInt(e);
        p = p+120;
        String pp = String.valueOf(p);
        order hh = new order();
                
                hh.show();
                hh.item.setText(e);
                hh.total.setText(pp);
        }else{
            jCheckBox1.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void rSPanelImage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSPanelImage1MouseClicked
        // TODO add your handling code here:
        if(ss.getText().startsWith("Cakes")) {
        
        jTabbedPane1.setSelectedIndex(1);
             
        }
        else if(ss.getText().startsWith("Flowers")) {
        
        jTabbedPane1.setSelectedIndex(2);
             
        }
         else if(ss.getText().startsWith("Chocolate Cake")) {
        
        new ChocolateCake().setVisible(true);
             
        }
        else if(ss.getText().startsWith("Oreo Cake")) {
        
        new OreoCake().setVisible(true);
             
        }
        else if(ss.getText().startsWith("Sunflower")) {
        
        new Sunflower().setVisible(true);
             
        }
        else if(ss.getText().startsWith("Red Rose")) {
        
        new redrose().setVisible(true);
             
        }
        else if(ss.getText().contains("Bouquet")) {
        
        new bouquets().setVisible(true);
             
        }
         
    }//GEN-LAST:event_rSPanelImage1MouseClicked

    private void rSButtonHover2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonHover2ActionPerformed

    private void rSButtonHover3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonHover3ActionPerformed

    private void rSButtonHover4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonHover4ActionPerformed

    private void rSButtonHover5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonHover5ActionPerformed

    private void rSButtonHover6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonHover6ActionPerformed

    private void rSButtonHover7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonHover7ActionPerformed

    private void rSButtonHover8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonHover8ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(jSpinner14.getValue().toString());
        if(qtyzero(qty)&& jCheckBox4.isSelected()){
            x++;
            if(x== 1)
            {
                royalsprinkle();
            }
            double price = qty*10000.0;
            total += price;
            getTax(total);
            memo.setText(memo.getText()+x+". "+jLabel98.getText()+"\t\t\t"+price+"\n");
            dudatec();
            String tk=jLabel99.getText();
        int tk1=Integer.parseInt(tk);
        //ImageIcon image = new ImageIcon(getClass().getResource("/cactus/page 1.jpeg"));
        String name=jLabel98.getText();

        insertorder(tk1,name);
        String e=jLabel99.getText();
        int p = Integer.parseInt(e);
        p = p+120;
        String pp = String.valueOf(p);
        order hh = new order();
                
                hh.show();
                hh.item.setText(e);
                hh.total.setText(pp);
        
        }else{
            jCheckBox4.setSelected(false);
        }
        
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void rSPanelImage3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSPanelImage3MouseClicked
        // TODO add your handling code here:
         menu1.show(jLabel2,0,ss.getHeight());
        b1 = false;
        rSButtonHover2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                po = "SELECT CatName FROM category WHERE ID>500 && ID<600  "; 
                mod.removeAllElements();
                for (String item : retrieveSuggestionsFromDatabase("")) {
                    mod.addElement(item.toString());
                }
                menu.show(ss, 0, ss.getHeight());
                list.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        // User has selected an item, copy it to the text field
                        String selectedValue = list.getSelectedValue();
                        ss.setText(selectedValue);

                        // Hide the suggestion menu or perform any other desired action
                        menu.setVisible(false);
                    }
                }
            });
        }
       
        });
        rSButtonHover1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                po = "SELECT CatName FROM category WHERE ID>600 && ID<700  "; 
                mod.removeAllElements();
                for (String item : retrieveSuggestionsFromDatabase("")) {
                    mod.addElement(item.toString());
                }
                menu.show(ss, 0, ss.getHeight());
                list.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        // User has selected an item, copy it to the text field
                        String selectedValue = list.getSelectedValue();
                        ss.setText(selectedValue);

                        // Hide the suggestion menu or perform any other desired action
                        menu.setVisible(false);
                        
                    }
                }
            });
            }
        });
        rSButtonHover4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                po = "SELECT CatName FROM category WHERE ID>600 && ID<700  ";
                b = true;
                mod.removeAllElements();
                for (String item : retrieveSuggestionsFromDatabase("")) {
                    mod.addElement(item.toString());
                }
                menu.show(ss, 0, ss.getHeight());
                list.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        // User has selected an item, copy it to the text field
                        String selectedValue = list.getSelectedValue();
                        ss.setText(selectedValue);

                        // Hide the suggestion menu or perform any other desired action
                        menu.setVisible(false);
                    }
                }
            });
                
            }
        });
        rSButtonHover6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                po = "SELECT CatName,price FROM category WHERE price<=2000 ";
                b = true;
                mod.removeAllElements();
                for (String item : retrieveSuggestionsFromDatabase("")) {
                    mod.addElement(item.toString());
                }
                menu.show(ss, 0, ss.getHeight());
                list.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        // User has selected an item, copy it to the text field
                        String selectedValue = list.getSelectedValue();
                        ss.setText(selectedValue);

                        // Hide the suggestion menu or perform any other desired action
                        menu.setVisible(false);
                    }
                }
            });
                
            }
        });
        rSButtonHover7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                po = "SELECT CatName,price FROM category WHERE price<=1000 ";
                b = true;
                mod.removeAllElements();
                for (String item : retrieveSuggestionsFromDatabase("")) {
                    mod.addElement(item.toString());
                }
                menu.show(ss, 0, ss.getHeight());
                list.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        // User has selected an item, copy it to the text field
                        String selectedValue = list.getSelectedValue();
                        ss.setText(selectedValue);

                        // Hide the suggestion menu or perform any other desired action
                        menu.setVisible(false);
                    }
                }
            });
                
            }
        });
        rSButtonHover8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                po = "SELECT CatName,price FROM category WHERE price<=500 ";
                b = true;
                mod.removeAllElements();
                for (String item : retrieveSuggestionsFromDatabase("")) {
                    mod.addElement(item.toString());
                }
                menu.show(ss, 0, ss.getHeight());
                list.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        // User has selected an item, copy it to the text field
                        String selectedValue = list.getSelectedValue();
                        ss.setText(selectedValue);

                        // Hide the suggestion menu or perform any other desired action
                        menu.setVisible(false);
                    }
                }
            });
                
            }
        });
    }//GEN-LAST:event_rSPanelImage3MouseClicked

    private void rSButtonHover9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover9ActionPerformed
       try {
        String e = caktot2.getText();
        double p = Double.parseDouble(e);
        p = p + 120;

        // Assuming 'order' is a class with 'item' and 'total' components
        order hh = new order();

        // Set the values in the 'order' instance
        hh.item.setText(e);
        hh.total.setText(String.valueOf((int) p)); // Convert double to int

        // Show the 'order' frame
        hh.setVisible(true);
    } catch (NumberFormatException ex) {
        // Handle the case where the text in caktot2 is not a valid number
        System.err.println("Invalid input: " + ex.getMessage());
    }//GEN-LAST:event_rSButtonHover9ActionPerformed
    }
    private void rSButtonHover10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover10ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "You'll receive a receipt through mail");
    }//GEN-LAST:event_rSButtonHover10ActionPerformed

    private void rSButtonHover11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover11ActionPerformed
        // TODO add your handling code here:
         try {
        String e = caktot2.getText();
        double p = Double.parseDouble(e);
        p = p + 120;

        // Assuming 'order' is a class with 'item' and 'total' components
        order hh = new order();

        // Set the values in the 'order' instance
        hh.item.setText(e);
        hh.total.setText(String.valueOf((int) p)); // Convert double to int

        // Show the 'order' frame
        hh.setVisible(true);
    } catch (NumberFormatException ex) {
        // Handle the case where the text in caktot2 is not a valid number
        System.err.println("Invalid input: " + ex.getMessage());
    }                       
    }//GEN-LAST:event_rSButtonHover11ActionPerformed

    private void rSButtonHover12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover12ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "You'll receive a receipt through mail");
    }//GEN-LAST:event_rSButtonHover12ActionPerformed
public void royalsprinkle()
    {
        int purchaseid = 15020 + (int)(Math.random()*80800);
        memo.setText("************************S P R I N K L E S************************\n"
                        +"Time: "+txttime1.getText()+"Date: "+txtdate1.getText()+"\n"
                                +"Purchase ID: " + purchaseid+"\n"
                        +"*****************************************************************\n"
                        +"Item Name:\t\t\t"+"Price(Tk)\n");
        
    }
public void royalsprinkle1()
    {
        int purchaseid = 15020 + (int)(Math.random()*80800);
       
                       // +"Item Name:\t\t\t"+"Price(Tk)\n");
        memo1.setText("************************S P R I N K L E S************************\n"
                        +"Time: "+txttime.getText()+"Date: "+txtdate.getText()+"\n"
                                +"Purchase ID: " + purchaseid+"\n"
                        +"*****************************************************************\n"
                        +"Item Name:\t\t\t"+"Price(Tk)\n");
    }                                       

                                              

                                           
    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        Cart c = new Cart(CartProduct,CartPrice,CartQuantity); 
        c.setVisible(true); 
        
    }
    private DefaultListModel<String>originalListModel;
    private DefaultListModel<String>filteredListModel;
    private void searchFilter(String searchText) {
//        DefaultListModel<String> listModel = (DefaultListModel<String>) jList1.getModel();
//            //Object originalListModel = null;
//            //searchField.getDocument().addDocumentListener(new DocumentListener() {
//            // String searchText = searchField.getText().toLowerCase();
//    if (originalListModel == null) {
//            // Store the original list model the first time
//            originalListModel = listModel;
//        }
//            //Object filteredListModel = null;
//
//        if (filteredListModel == null) {
//            // Create a filtered list model if it doesn't exist
//            filteredListModel = new DefaultListModel<>();
//        } else {
//            // Clear the filtered list model from previous searches
//            filteredListModel.clear();
//            for (int i = 0; i < originalListModel.size(); i++) {
//                filteredListModel.addElement(originalListModel.get(i));
//            }
//        }
//        if (!searchText.isEmpty()) 
//            // If the search text is empty, show all items
//           {
//            DefaultListModel<String> filteredModel = new DefaultListModel<>();
//
//            // Filter the items in the list based on the search text
//            for (int i = 0; i < listModel.size(); i++) {
//                String item = listModel.get(i);
//                if (item.toLowerCase().contains(searchText.toLowerCase())) {
//                    filteredModel.addElement(item);
//                }
//            }
//
//            // Set the filtered model to your JList
//            jList1.setModel(filteredModel);
//        }
//        else{
//            jList1.setModel(originalListModel);
//        }
    }
    public void getTax(double t){
       if(t>100.0 && t<=500.0){
           tax=30.0;
       }else if(t>500.0 && t<=1000.0){
           tax=40.0;
           
       }else if(t>1000.0 && t<=5000.0){
           tax=50.0;
       }else {
           tax=60.0;
       }
   }
public void setTime()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        //Logger.getLogger(Cakes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    Date date= new Date();
                    SimpleDateFormat tf= new SimpleDateFormat("h:mm:ss aa");
                    SimpleDateFormat df=new SimpleDateFormat("EEEE, dd-MM-YYYY");
                    String time=tf.format(date);
                    txttime.setText(time.split(" ")[0]+" "+time.split(" ")[1]);
                    txtdate.setText(df.format(date));
                    txttime1.setText(time.split(" ")[0]+" "+time.split(" ")[1]);
                    txtdate1.setText(df.format(date));
                }
            }
        }).start();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    private Timer delayTimer;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu About;
    private javax.swing.JMenuItem PP;
    private javax.swing.JMenuItem RR;
    private javax.swing.JMenuItem TC;
    private javax.swing.JMenuItem WC;
    private javax.swing.JTextField caksubtot1;
    private javax.swing.JTextField caksubtot2;
    private javax.swing.JTextField caktax;
    private javax.swing.JTextField caktax1;
    private javax.swing.JTextField caktot1;
    public javax.swing.JLabel caktot2;
    private javax.swing.JButton cart10;
    private javax.swing.JButton cart11;
    private javax.swing.JButton cart3;
    private javax.swing.JButton cart4;
    private javax.swing.JButton cart5;
    private javax.swing.JButton cart6;
    private javax.swing.JButton cart7;
    private javax.swing.JButton cart8;
    private javax.swing.JButton cart9;
    private javax.swing.JButton chocobutton;
    private javax.swing.JPanel container;
    private javax.swing.JButton flowerbutton;
    private javax.swing.JLabel img1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox22;
    private javax.swing.JCheckBox jCheckBox23;
    private javax.swing.JCheckBox jCheckBox24;
    private javax.swing.JCheckBox jCheckBox25;
    private javax.swing.JCheckBox jCheckBox26;
    private javax.swing.JCheckBox jCheckBox27;
    private javax.swing.JCheckBox jCheckBox28;
    private javax.swing.JCheckBox jCheckBox29;
    private javax.swing.JCheckBox jCheckBox30;
    private javax.swing.JCheckBox jCheckBox31;
    private javax.swing.JCheckBox jCheckBox32;
    private javax.swing.JCheckBox jCheckBox33;
    private javax.swing.JCheckBox jCheckBox34;
    private javax.swing.JCheckBox jCheckBox35;
    private javax.swing.JCheckBox jCheckBox36;
    private javax.swing.JCheckBox jCheckBox37;
    private javax.swing.JCheckBox jCheckBox38;
    private javax.swing.JCheckBox jCheckBox39;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox40;
    private javax.swing.JCheckBox jCheckBox41;
    private javax.swing.JCheckBox jCheckBox42;
    private javax.swing.JCheckBox jCheckBox43;
    private javax.swing.JCheckBox jCheckBox44;
    private javax.swing.JCheckBox jCheckBox45;
    private javax.swing.JCheckBox jCheckBox46;
    private javax.swing.JCheckBox jCheckBox47;
    private javax.swing.JCheckBox jCheckBox48;
    private javax.swing.JCheckBox jCheckBox49;
    private javax.swing.JCheckBox jCheckBox50;
    private javax.swing.JCheckBox jCheckBox51;
    private javax.swing.JCheckBox jCheckBox52;
    private javax.swing.JCheckBox jCheckBox53;
    private javax.swing.JCheckBox jCheckBox54;
    private javax.swing.JCheckBox jCheckBox55;
    private javax.swing.JCheckBox jCheckBox56;
    private javax.swing.JCheckBox jCheckBox57;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    public javax.swing.JLabel jLabel105;
    public javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    public javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel220;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel226;
    private javax.swing.JLabel jLabel227;
    private javax.swing.JLabel jLabel228;
    private javax.swing.JLabel jLabel229;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel235;
    private javax.swing.JLabel jLabel236;
    private javax.swing.JLabel jLabel237;
    private javax.swing.JLabel jLabel238;
    private javax.swing.JLabel jLabel239;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel240;
    private javax.swing.JLabel jLabel241;
    private javax.swing.JLabel jLabel242;
    private javax.swing.JLabel jLabel243;
    private javax.swing.JLabel jLabel244;
    private javax.swing.JLabel jLabel245;
    private javax.swing.JLabel jLabel246;
    private javax.swing.JLabel jLabel247;
    private javax.swing.JLabel jLabel248;
    private javax.swing.JLabel jLabel249;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel250;
    private javax.swing.JLabel jLabel251;
    private javax.swing.JLabel jLabel252;
    private javax.swing.JLabel jLabel253;
    private javax.swing.JLabel jLabel254;
    private javax.swing.JLabel jLabel255;
    private javax.swing.JLabel jLabel256;
    private javax.swing.JLabel jLabel257;
    private javax.swing.JLabel jLabel258;
    private javax.swing.JLabel jLabel259;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel260;
    private javax.swing.JLabel jLabel261;
    private javax.swing.JLabel jLabel262;
    private javax.swing.JLabel jLabel263;
    private javax.swing.JLabel jLabel264;
    private javax.swing.JLabel jLabel265;
    private javax.swing.JLabel jLabel266;
    private javax.swing.JLabel jLabel267;
    private javax.swing.JLabel jLabel268;
    private javax.swing.JLabel jLabel269;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel270;
    private javax.swing.JLabel jLabel271;
    private javax.swing.JLabel jLabel272;
    private javax.swing.JLabel jLabel273;
    private javax.swing.JLabel jLabel274;
    private javax.swing.JLabel jLabel275;
    private javax.swing.JLabel jLabel276;
    private javax.swing.JLabel jLabel277;
    private javax.swing.JLabel jLabel278;
    private javax.swing.JLabel jLabel279;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel280;
    private javax.swing.JLabel jLabel281;
    private javax.swing.JLabel jLabel282;
    private javax.swing.JLabel jLabel283;
    private javax.swing.JLabel jLabel284;
    private javax.swing.JLabel jLabel285;
    private javax.swing.JLabel jLabel286;
    private javax.swing.JLabel jLabel287;
    private javax.swing.JLabel jLabel288;
    private javax.swing.JLabel jLabel289;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel290;
    private javax.swing.JLabel jLabel291;
    private javax.swing.JLabel jLabel292;
    private javax.swing.JLabel jLabel293;
    private javax.swing.JLabel jLabel294;
    private javax.swing.JLabel jLabel295;
    private javax.swing.JLabel jLabel296;
    private javax.swing.JLabel jLabel297;
    private javax.swing.JLabel jLabel298;
    private javax.swing.JLabel jLabel299;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel300;
    private javax.swing.JLabel jLabel301;
    private javax.swing.JLabel jLabel302;
    private javax.swing.JLabel jLabel303;
    private javax.swing.JLabel jLabel304;
    private javax.swing.JLabel jLabel305;
    private javax.swing.JLabel jLabel306;
    private javax.swing.JLabel jLabel307;
    private javax.swing.JLabel jLabel308;
    private javax.swing.JLabel jLabel309;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel310;
    private javax.swing.JLabel jLabel311;
    private javax.swing.JLabel jLabel312;
    private javax.swing.JLabel jLabel313;
    private javax.swing.JLabel jLabel314;
    private javax.swing.JLabel jLabel315;
    private javax.swing.JLabel jLabel316;
    private javax.swing.JLabel jLabel317;
    private javax.swing.JLabel jLabel318;
    private javax.swing.JLabel jLabel319;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel320;
    private javax.swing.JLabel jLabel321;
    private javax.swing.JLabel jLabel322;
    private javax.swing.JLabel jLabel323;
    private javax.swing.JLabel jLabel324;
    private javax.swing.JLabel jLabel325;
    private javax.swing.JLabel jLabel326;
    private javax.swing.JLabel jLabel327;
    private javax.swing.JLabel jLabel328;
    private javax.swing.JLabel jLabel329;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel330;
    private javax.swing.JLabel jLabel331;
    private javax.swing.JLabel jLabel332;
    private javax.swing.JLabel jLabel333;
    private javax.swing.JLabel jLabel334;
    private javax.swing.JLabel jLabel335;
    private javax.swing.JLabel jLabel336;
    private javax.swing.JLabel jLabel337;
    private javax.swing.JLabel jLabel338;
    private javax.swing.JLabel jLabel339;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel340;
    private javax.swing.JLabel jLabel341;
    private javax.swing.JLabel jLabel342;
    private javax.swing.JLabel jLabel343;
    private javax.swing.JLabel jLabel344;
    private javax.swing.JLabel jLabel345;
    private javax.swing.JLabel jLabel346;
    private javax.swing.JLabel jLabel347;
    private javax.swing.JLabel jLabel348;
    private javax.swing.JLabel jLabel349;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel350;
    private javax.swing.JLabel jLabel351;
    private javax.swing.JLabel jLabel352;
    private javax.swing.JLabel jLabel353;
    private javax.swing.JLabel jLabel354;
    private javax.swing.JLabel jLabel355;
    private javax.swing.JLabel jLabel356;
    private javax.swing.JLabel jLabel357;
    private javax.swing.JLabel jLabel358;
    private javax.swing.JLabel jLabel359;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel360;
    private javax.swing.JLabel jLabel361;
    private javax.swing.JLabel jLabel362;
    private javax.swing.JLabel jLabel363;
    private javax.swing.JLabel jLabel364;
    private javax.swing.JLabel jLabel365;
    private javax.swing.JLabel jLabel366;
    private javax.swing.JLabel jLabel367;
    private javax.swing.JLabel jLabel368;
    private javax.swing.JLabel jLabel369;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel370;
    private javax.swing.JLabel jLabel371;
    private javax.swing.JLabel jLabel372;
    private javax.swing.JLabel jLabel373;
    private javax.swing.JLabel jLabel374;
    private javax.swing.JLabel jLabel375;
    private javax.swing.JLabel jLabel376;
    private javax.swing.JLabel jLabel377;
    private javax.swing.JLabel jLabel378;
    private javax.swing.JLabel jLabel379;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel380;
    private javax.swing.JLabel jLabel381;
    private javax.swing.JLabel jLabel382;
    private javax.swing.JLabel jLabel383;
    private javax.swing.JLabel jLabel384;
    private javax.swing.JLabel jLabel385;
    private javax.swing.JLabel jLabel386;
    private javax.swing.JLabel jLabel387;
    private javax.swing.JLabel jLabel388;
    private javax.swing.JLabel jLabel389;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel390;
    private javax.swing.JLabel jLabel391;
    private javax.swing.JLabel jLabel392;
    private javax.swing.JLabel jLabel393;
    private javax.swing.JLabel jLabel394;
    private javax.swing.JLabel jLabel395;
    private javax.swing.JLabel jLabel396;
    private javax.swing.JLabel jLabel397;
    private javax.swing.JLabel jLabel398;
    private javax.swing.JLabel jLabel399;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel400;
    private javax.swing.JLabel jLabel401;
    private javax.swing.JLabel jLabel402;
    private javax.swing.JLabel jLabel403;
    private javax.swing.JLabel jLabel405;
    private javax.swing.JLabel jLabel408;
    private javax.swing.JLabel jLabel409;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel410;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    public javax.swing.JLabel jLabel98;
    public javax.swing.JLabel jLabel99;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    public javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSpinner jSpinner14;
    private javax.swing.JSpinner jSpinner15;
    private javax.swing.JSpinner jSpinner16;
    private javax.swing.JSpinner jSpinner17;
    private javax.swing.JSpinner jSpinner18;
    private javax.swing.JSpinner jSpinner19;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner20;
    private javax.swing.JSpinner jSpinner21;
    private javax.swing.JSpinner jSpinner22;
    private javax.swing.JSpinner jSpinner23;
    private javax.swing.JSpinner jSpinner24;
    private javax.swing.JSpinner jSpinner25;
    private javax.swing.JSpinner jSpinner26;
    private javax.swing.JSpinner jSpinner27;
    private javax.swing.JSpinner jSpinner28;
    private javax.swing.JSpinner jSpinner29;
    private javax.swing.JSpinner jSpinner30;
    private javax.swing.JSpinner jSpinner31;
    private javax.swing.JSpinner jSpinner32;
    private javax.swing.JSpinner jSpinner33;
    private javax.swing.JSpinner jSpinner34;
    private javax.swing.JSpinner jSpinner35;
    private javax.swing.JSpinner jSpinner36;
    private javax.swing.JSpinner jSpinner37;
    private javax.swing.JSpinner jSpinner38;
    private javax.swing.JSpinner jSpinner39;
    private javax.swing.JSpinner jSpinner40;
    private javax.swing.JSpinner jSpinner41;
    private javax.swing.JSpinner jSpinner42;
    private javax.swing.JSpinner jSpinner43;
    private javax.swing.JSpinner jSpinner44;
    private javax.swing.JSpinner jSpinner45;
    private javax.swing.JSpinner jSpinner46;
    private javax.swing.JSpinner jSpinner47;
    private javax.swing.JSpinner jSpinner48;
    private javax.swing.JSpinner jSpinner49;
    private javax.swing.JSpinner jSpinner50;
    private javax.swing.JSpinner jSpinner51;
    private javax.swing.JSpinner jSpinner52;
    private javax.swing.JSpinner jSpinner53;
    private javax.swing.JSpinner jSpinner54;
    private javax.swing.JSpinner jSpinner55;
    private javax.swing.JSpinner jSpinner56;
    private javax.swing.JSpinner jSpinner57;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList<String> list;
    private javax.swing.JTextArea memo;
    private javax.swing.JTextArea memo1;
    private javax.swing.JPopupMenu menu;
    private javax.swing.JPopupMenu menu1;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel2;
    public javax.swing.JLabel prof;
    private rojeru_san.complementos.RSButtonHover rSButtonHover1;
    private rojeru_san.complementos.RSButtonHover rSButtonHover10;
    private rojeru_san.complementos.RSButtonHover rSButtonHover11;
    private rojeru_san.complementos.RSButtonHover rSButtonHover12;
    private rojeru_san.complementos.RSButtonHover rSButtonHover2;
    private rojeru_san.complementos.RSButtonHover rSButtonHover3;
    private rojeru_san.complementos.RSButtonHover rSButtonHover4;
    private rojeru_san.complementos.RSButtonHover rSButtonHover5;
    private rojeru_san.complementos.RSButtonHover rSButtonHover6;
    private rojeru_san.complementos.RSButtonHover rSButtonHover7;
    private rojeru_san.complementos.RSButtonHover rSButtonHover8;
    private rojeru_san.complementos.RSButtonHover rSButtonHover9;
    private rojerusan.RSPanelImage rSPanelImage1;
    private rojerusan.RSPanelImage rSPanelImage2;
    private rojerusan.RSPanelImage rSPanelImage3;
    private javax.swing.JTextField ss;
    private javax.swing.JLabel title;
    private javax.swing.JLabel txtdate;
    private javax.swing.JLabel txtdate1;
    private javax.swing.JLabel txttime;
    private javax.swing.JLabel txttime1;
    // End of variables declaration//GEN-END:variables
    
}
