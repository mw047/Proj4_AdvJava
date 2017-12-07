/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waiteproj4;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Katie
 */
public class CardLayoutFrame extends JFrame{

    JPanel cardPanel;
    Container contain = new Container();
        
    //titles for cardPanel cards
    final static String MOVIE = "Edit Movie Inventory";
    final static String BOOK = "Edit Book Inventory";
    final static String PAINTING = "Edit Painting Inventory";
    
    //Create cards for cardPanel
    JPanel movies = new JPanel(new GridBagLayout());
    JPanel books = new JPanel(new GridBagLayout());
    JPanel paintings = new JPanel(new GridBagLayout());
    JPanel common = new JPanel(new GridBagLayout());
    
    //layout for cardPanel
    CardLayout cl = new CardLayout();
    
    private static final String[] CBOXITEMS = {MOVIE, BOOK, PAINTING};
    
    JPanel movieD;
    JPanel bookD;
    JPanel paintingD;
    
    JLabel errorMessage = new JLabel();
    JLabel title = new JLabel("Title", SwingConstants.RIGHT);
    JLabel author = new JLabel("Author", SwingConstants.RIGHT);
    JLabel dateAcq = new JLabel("Date Acquired", SwingConstants.RIGHT);
    JLabel dateRel = new JLabel("Date Released", SwingConstants.RIGHT);
    JLabel pPrice = new JLabel("Purchase Price", SwingConstants.RIGHT);
    JLabel aPrice = new JLabel("Asking Price", SwingConstants.RIGHT);

    JTextField titleT = new JTextField("");
    JTextField authorT = new JTextField("");
    JTextField dateAcqT = new JTextField("");
    JTextField dateRelT = new JTextField("");
    JTextField pPriceT = new JTextField("");
    JTextField aPriceT = new JTextField("");
    
 
    public CardLayoutFrame(){
        super("My Bookstore");
        cl.setVgap(5);
        contain.setLayout(new BoxLayout(contain, BoxLayout.Y_AXIS));
        defineComboBox(contain);
        commonPanel(contain);
        defineCardPanel(contain); 
        defineDisplay(contain);
        this.add(contain);
        this.pack();

    }

    private void defineCardPanel(Container contain) {
        cardPanel = new JPanel();
        cardPanel.setLayout(cl);
        cardPanel.setPreferredSize(new Dimension(1000, 200));
        cardPanel.setMaximumSize(new Dimension(1500, 300));
        cardPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        
        titleT.setPreferredSize(new Dimension(125, 25));
        authorT.setPreferredSize(new Dimension(125, 25));
        dateAcqT.setPreferredSize(new Dimension(125, 25));
        dateRelT.setPreferredSize(new Dimension(125, 25));
        pPriceT.setPreferredSize(new Dimension(125, 25));
        aPriceT.setPreferredSize(new Dimension(125, 25));
        //initialize cardPanel.
        movieCard(contain);
//        bookCard(contain);
//        paintCard(contain);
 
        //add cards to cardPanel
        cardPanel.add(movies, MOVIE);
//        cardPanel.add(books, BOOK);
//        cardPanel.add(paintings, PAINTING);
        
        cardPanel.setVisible(true);
        contain.add(cardPanel);
    
        if(movies.isShowing())
            cardPanel.setBorder(BorderFactory.createTitledBorder(MOVIE));
        else if(books.isShowing())
            cardPanel.setBorder(BorderFactory.createTitledBorder(BOOK));
        else if(paintings.isShowing())
            cardPanel.setBorder(BorderFactory.createTitledBorder(PAINTING));
    }
  
    private void defineComboBox(Container contain) {
        JPanel cBoxPane = new JPanel();
        JLabel selectedPane = new JLabel();
        
        errorMessage.setForeground(Color.red);
        errorMessage.setFont(new Font("Courier New", Font.BOLD, 14));
//        cBoxPane.setBackground(Color.yellow);
  //      cBoxPane.setBorder(BorderFactory.createDashedBorder(Color.RED));
        cBoxPane.setPreferredSize(new Dimension(1000, 25));
        JComboBox cb = new JComboBox(CBOXITEMS);
        JLabel instructions = new JLabel("What would you like to do?");
        cb.setPreferredSize(new Dimension(300, 25));
        cb.setSelectedIndex(0);
        cb.setEditable(false);
        cBoxPane.add(instructions);
        cb.addItemListener(new ComboBoxHandler());
        cBoxPane.add(cb);
        cBoxPane.add(errorMessage);
        cBoxPane.setVisible(true);
        
        contain.add(cBoxPane);
    }        

    private void movieCard(Container contain) {
        int invID = 0;
        
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        movies.setAlignmentY(Component.TOP_ALIGNMENT);
        GridBagConstraints c1 = new GridBagConstraints(); //using oracle.com as GridBagLayout example
        GridBagConstraints c2 = new GridBagConstraints(); //using oracle.com as GridBagLayout example
        
        c1.fill = GridBagConstraints.BOTH;
       c1.insets = new Insets(5, 10, 5, 0);
        c1.ipadx = 100;
        
        
        c2.fill = GridBagConstraints.BOTH;
        c2.insets = new Insets(5, 5, 5, 10);
        c2.ipadx = 200;
        
        JButton add = new JButton("Add");
        JButton remove = new JButton("Remove");

        JLabel qty = new JLabel("Quantity", SwingConstants.RIGHT);        
        JLabel director = new JLabel("Director", SwingConstants.RIGHT);
        JLabel actor = new JLabel("Actors", SwingConstants.RIGHT);
        JLabel genreM = new JLabel("Genre", SwingConstants.RIGHT);

        JTextField qtyT = new JTextField("");
        JTextField directorT = new JTextField("");
        JTextField actorT = new JTextField("");
        JTextField genreTM = new JTextField("");
                        
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
            
            private void addActionPerformed(ActionEvent evt) {
                try{
                    if(qtyT.getText().trim().isEmpty())
                    {
                        throw new Exception("You did not enter a quantity!");
                    }
                    int quantity = Integer.parseInt(qtyT.getText());
                    String director = directorT.getText();
                    String[] array = actorT.getText().split(", ");
                    String genre = genreTM.getText();
                    
                    if(titleT.getText().trim().isEmpty())
                    {
                        throw new Exception("You did not enter a Title!");
                    }
                    String title = titleT.getText();                
                    String author = authorT.getText();
                    
                    if(dateAcqT.getText().trim().isEmpty())
                    {
                        throw new Exception("You did not enter the Date Acquired!");
                    }
                    Date dAcq = df.parse(dateAcqT.getText());
                    Date dRel = df.parse(dateRelT.getText());
                    
                    if(pPrice.getText().trim().isEmpty())
                    {
                        throw new Exception("You did not enter a Purchase Price!");
                    }
                    int purchase = Integer.parseInt(pPriceT.getText());
                    if(aPrice.getText().trim().isEmpty())
                    {
                        throw new Exception("You did not enter an Asking Price!");
                    }
                    int asking = Integer.parseInt(aPriceT.getText());
                   
                }
 
                catch(ParseException e){
                    
                    errorMessage.setText("ERROR: Invalid data was Entered!");         
                }
                
                catch(Exception e){
                    errorMessage.setText("ERROR: " + e);
                }
                
                c1.gridx = 0;
                c1.gridy = (invID+1);
               // movieD.add();
                
            }
        });
//        
//        remove.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                removeActionPerformed(evt);
//            }
//            
//            private void removeActionPerformed(ActionEvent evt) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
        
        c1.gridx = 0;
        c1.gridy = 0;
        movies.add(director, c1);

        c2.gridx = 1;
        c2.gridy = 0;
        movies.add(directorT, c2);

        c1.gridx = 2;
        c1.gridy = 0;
        movies.add(actor, c1);

        c2.gridx = 3;
        c2.gridy = 0;
        movies.add(actorT, c2);

        c1.gridx = 4;
        c1.gridy = 0;
        movies.add(genreM, c1);

        c2.gridx = 5;
        c2.gridy = 0;
        movies.add(genreTM, c2);
        
        c1.fill = GridBagConstraints.NONE;
        c1.gridx = 1;
        c1.gridy = 1;
        movies.add(qty, c1);

        c2.fill = GridBagConstraints.NONE;
        c2.gridx = 2;
        c2.gridy = 1;
        movies.add(qtyT, c2);
       
        c1.gridx = 3;
        c1.gridy = 1;
        movies.add(add, c1);

        c1.gridx = 4;
        c1.gridy = 1;
        movies.add(remove, c1);

        contain.add(movies);
    }
    private void bookCard(Container contain) {
        books.setBorder(BorderFactory.createTitledBorder(BOOK));
        JPanel m = new JPanel(new GridBagLayout());
        //JPanel cp1 = commonPanel();
        
        m.setPreferredSize(new Dimension(1000, 100));
        //cp1.setPreferredSize(new Dimension(1000, 100));
        
        GridBagConstraints c1 = new GridBagConstraints(); //using oracle.com as GridBagLayout example
        GridBagConstraints c2 = new GridBagConstraints(); //using oracle.com as GridBagLayout example
        
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.insets = new Insets(5, 30, 5, 0);
        
        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.insets = new Insets(5, 5, 5, 30);

        JButton add = new JButton("Add");
        JButton remove = new JButton("Remove");
        
        JLabel qty = new JLabel("Quantity", SwingConstants.RIGHT);
        JLabel genreB = new JLabel("Genre", SwingConstants.RIGHT);
        JTextField qtyT = new JTextField("Enter Quantity");
        JTextField genreTB = new JTextField("Enter Genre");
        
        c1.gridx = 0;
        c1.gridy = 0;
        m.add(genreB, c1);

        c2.gridx = 1;
        c2.gridy = 0;
        m.add(genreTB, c2);
//
//        c1.gridx = 1;
//        c1.gridy = 1;
//        m.add(qty, c1);
//
//        c2.gridx = 2;
//        c2.gridy = 1;
//        m.add(qtyT, c2);
//        
//        c1.ipadx = 50;
//        c1.ipady = 25;
//        c1.gridx = 3;
//        c1.gridy = 1;
//        m.add(add, c1);
//
//        c1.ipadx = 50;
//        c1.ipady = 25;
//        c1.gridx = 4;
//        c1.gridy = 1;
//        m.add(remove, c1);

        
//        books.add(cp1);
//        books.add(m);
        contain.add(books);
}

    private void paintCard(Container contain) {
        paintings.setBorder(BorderFactory.createTitledBorder(PAINTING));
        JPanel m = new JPanel(new GridBagLayout());
//        JPanel cp2 = commonPanel();
        
        GridBagConstraints c1 = new GridBagConstraints(); //using oracle.com as GridBagLayout example
        GridBagConstraints c2 = new GridBagConstraints(); //using oracle.com as GridBagLayout example
        
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.insets = new Insets(5, 30, 5, 0);
        
        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.insets = new Insets(5, 5, 5, 30);    
    
//        JButton add = new JButton("Add");
//        JButton remove = new JButton("Remove");

        JLabel qty = new JLabel("Quantity", SwingConstants.RIGHT);        
        JLabel height = new JLabel("Height", SwingConstants.RIGHT);
        JLabel width = new JLabel("Width", SwingConstants.RIGHT);
        JLabel media = new JLabel("Media", SwingConstants.RIGHT);

        JTextField qtyT = new JTextField("Enter Quantity");
        JTextField heightT = new JTextField("Enter Height");
        JTextField widthT = new JTextField("Enter Width");
        JTextField mediaT = new JTextField("Enter Media");

        //JLabel[] labels = new JLabel[]{qty, height, width, media};
        //JTextField[] texts = new JTextField[]{qtyT, heightT, widthT, mediaT};
        
        c1.gridx = 0;
        c1.gridy = 0;
        m.add(height, c1);

        c2.gridx = 1;
        c2.gridy = 0;
        m.add(heightT, c2);

        c1.gridx = 2;
        c1.gridy = 0;
        m.add(width, c1);

        c2.gridx = 3;
        c2.gridy = 0;
        m.add(widthT, c2);

        c1.gridx = 4;
        c1.gridy = 0;
        m.add(media, c1);

        c2.gridx = 5;
        c2.gridy = 0;
        m.add(mediaT, c2);

//        c1.gridx = 1;
//        c1.gridy = 1;
//        m.add(qty, c1);
//
//        c2.gridx = 2;
//        c2.gridy = 1;
//        m.add(qtyT, c2);
//        
//        c1.ipadx = 50;
//        c1.ipady = 25;
//        c1.gridx = 3;
//        c1.gridy = 1;
//        m.add(add, c1);
//
//        c1.ipadx = 50;
//        c1.ipady = 25;
//        c1.gridx = 4;
//        c1.gridy = 1;
//        m.add(remove, c1);
//
//        
//        paintings.add(cp2);
//        paintings.add(m);
        contain.add(paintings);    
    }
 
    private void commonPanel(Container contain){
        common.setPreferredSize(new Dimension(1000, 100));
        common.setMaximumSize(new Dimension(1000, 100));
        GridBagConstraints c1 = new GridBagConstraints(); //using oracle.com as GridBagLayout example
        GridBagConstraints c2 = new GridBagConstraints(); //using oracle.com as GridBagLayout example
        common.setBackground(Color.red);
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.insets = new Insets(5, 30, 5, 0);
        
        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.insets = new Insets(5, 5, 5, 30);    
        
        c1.gridx = 0;
        c1.gridy = 1;
        common.add(title, c1);

        c2.gridx = 1;
        c2.gridy = 1;
        common.add(titleT, c2);
        
        c1.gridx = 2;
        c1.gridy = 1;
        common.add(author, c1);
        
        c2.gridx = 3;
        c2.gridy = 1;
        common.add(authorT, c2);
        
        c1.gridx = 4;
        c1.gridy = 1;
        common.add(dateAcq, c1);
        
        c2.gridx = 5;
        c2.gridy = 1;
        common.add(dateAcqT, c2);
        
        c1.gridx = 0;
        c1.gridy = 2;
        common.add(pPrice, c1);
        
        c2.gridx = 1;
        c2.gridy = 2;
        common.add(pPriceT, c2);
        
        c1.gridx = 2;
        c1.gridy = 2;
        common.add(aPrice, c1);
        
        c2.gridx = 3;
        c2.gridy = 2;
        common.add(aPriceT, c2);
        
        c1.gridx = 4;
        c1.gridy = 2;
        common.add(dateRel, c1);
        
        c2.gridx = 5;
        c2.gridy = 2;
        common.add(dateRelT, c2);
        
        contain.add(common);
    }

    private void defineDisplay(Container contain) {
        JPanel displayInv = new JPanel();
        displayInv.setBackground(Color.white);
        
        JLabel m = new JLabel("Movies: ");
        m.setFont(new Font("Courier New", Font.BOLD, 16));

        JLabel b = new JLabel("Books: ");
        b.setFont(new Font("Courier New", Font.BOLD, 16));

        JLabel p = new JLabel("Paintings: ");
        p.setFont(new Font("Courier New", Font.BOLD, 16));


        GridBagConstraints c1 = new GridBagConstraints(); //using oracle.com as GridBagLayout example
        GridBagConstraints c2 = new GridBagConstraints(); //using oracle.com as GridBagLayout example

        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.insets = new Insets(5, 30, 5, 30);

        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.insets = new Insets(5, 30, 5, 30);
        c2.ipadx = 30;

        String[] mHeader = new String[]{"Title", "Author", "Date Acquired", "Date Released", "Purchase Price", "Asking Price", "Genre", "Director", "Actors"};
        String[] bHeader = new String[]{"Title", "Author", "Date Acquired", "Date Released", "Purchase Price", "Asking Price", "Genre", "          ", "          "};
        String[] pHeader = new String[]{"Title", "Author", "Date Acquired", "Date Released", "Purchase Price", "Asking Price", "Media", "Height", "Width"};

        movieD = (setDisplayHeaders(mHeader));
        movieD.setBackground(Color.white);
        c1.gridx = 0;
        c1.gridy = 0;
        movieD.add(m, c1);

        bookD = (setDisplayHeaders(bHeader));
        bookD.setBackground(Color.white);
        c1.gridx = 0;
        c1.gridy = 0;
        bookD.add(b,c1);

        paintingD = (setDisplayHeaders(pHeader));
        paintingD.setBackground(Color.white);
        c1.gridx = 0;
        c1.gridy = 0;
        paintingD.add(p, c1);

        displayInv.add(movieD);
        displayInv.add(bookD);
        displayInv.add(paintingD);
        contain.add(displayInv);

    }
    
   private JPanel setDisplayHeaders(String[] h){
        JPanel header = new JPanel(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints(); //using oracle.com as GridBagLayout example
                
        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.insets = new Insets(5, 30, 5, 30);
        c2.ipadx = 30;

        for(int i = 0; i < h.length; i++)
        {
            JLabel a = new JLabel(h[i], SwingConstants.CENTER);
            c2.gridx = i;
            c2.gridy = 1;
            header.add(a, c2);       
        }       
        return header;
   } 
       
    private class ComboBoxHandler implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            CardLayout lay = (CardLayout)(cardPanel.getLayout());
            lay.show(cardPanel, (String)e.getItem());  
            
        }
     
    }
    
    
}
