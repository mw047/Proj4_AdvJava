/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waiteproj4;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import org.jdesktop.swingx.JXDatePicker;


/**
 *
 * @author mw047
 */
public class customGUI extends JFrame implements ActionListener{
    
    StoreItem[] inventory = new StoreItem[1];
    StoreItem x;
    int i = 0;
    JButton[] buttonList = new JButton[1]; 
    int numDisplayed = 0;
    JLabel invCount = new JLabel("There are " + (inventory.length-1) + " items in inventory.");
    
//create panels to hold various fields
    JPanel common = new JPanel(new GridLayout(6, 2, 5, 5));
    JPanel options = new JPanel(new GridLayout(8, 2, 5, 5));
    JPanel display = new JPanel(new GridLayout());
    JPanel selection = new JPanel();
    JPanel action = new JPanel();
    JPanel invList = new JPanel();
    JPanel info = new JPanel();
    
    JTextArea invInfo = new JTextArea();
                
    
    //RadioButtons
    JRadioButton movie = new JRadioButton("Edit Movie Inventory");
    JRadioButton book = new JRadioButton("Edit Book Inventory");
    JRadioButton painting = new JRadioButton("Edit Painting Inventory");
    ButtonGroup buttonGroup = new ButtonGroup();
    
    JLabel errorMessage = new JLabel();
    
    JLabel title = new JLabel("Title", SwingConstants.RIGHT);
    JLabel author = new JLabel("Author", SwingConstants.RIGHT);
    JLabel dateAcq = new JLabel("Date Acquired", SwingConstants.RIGHT);
    JLabel dateRel = new JLabel("Date Released", SwingConstants.RIGHT);
    JLabel pPrice = new JLabel("Purchase Price", SwingConstants.RIGHT);
    JLabel aPrice = new JLabel("Asking Price", SwingConstants.RIGHT);
    //JLabel qty = new JLabel("Quantity", SwingConstants.RIGHT);        
    JLabel director = new JLabel("Director", SwingConstants.RIGHT);
    JLabel actor = new JLabel("Actors", SwingConstants.RIGHT);
    JLabel genre = new JLabel("Genre", SwingConstants.RIGHT);
    JLabel high = new JLabel("Height", SwingConstants.RIGHT);
    JLabel wide = new JLabel("Width", SwingConstants.RIGHT);
    JLabel media = new JLabel("Media", SwingConstants.RIGHT);
    
    JTextField highT = new JTextField("");
    JTextField wideT = new JTextField("");
    JTextField mediaT = new JTextField("");

    JXDatePicker acq = new JXDatePicker();
    JXDatePicker rel = new JXDatePicker();
    
//    JTextField qtyT = new JTextField("");
    JTextField directorT = new JTextField("");
    JTextField actorT = new JTextField("");
    JTextField genreT = new JTextField("");
    JTextField titleT = new JTextField("");
    JTextField authorT = new JTextField("");
    JTextField pPriceT = new JTextField("");
    JTextField aPriceT = new JTextField("");
    
    JButton add = new JButton("Add");
    JButton remove = new JButton("Remove");
    
    Dimension ps = new Dimension(200, 25);
        
    
    public customGUI(){
        super("My Bookstore");
        this.setLayout(new FlowLayout());
        
        titleT.setPreferredSize(ps);
        titleT.setEnabled(false);
        titleT.setBackground(Color.darkGray);
        authorT.setPreferredSize(ps);
        authorT.setEnabled(false);
        authorT.setBackground(Color.darkGray);
        pPriceT.setPreferredSize(ps);
        pPriceT.setEnabled(false);
        pPriceT.setBackground(Color.darkGray);
        aPriceT.setPreferredSize(ps);
        aPriceT.setEnabled(false);
        aPriceT.setBackground(Color.darkGray);
        genreT.setPreferredSize(ps);
        genreT.setEnabled(false);
        genreT.setBackground(Color.darkGray);
//        actorT.setInputVerifier(inputVerifier);
        actorT.setPreferredSize(ps);
        actorT.setEnabled(false);
        actorT.setBackground(Color.darkGray);
        directorT.setPreferredSize(ps);
        directorT.setEnabled(false);
        directorT.setBackground(Color.darkGray);
//        qtyT.setPreferredSize(ps);
//        qtyT.setEnabled(false);
//        qtyT.setBackground(Color.darkGray);
        mediaT.setPreferredSize(ps);
        mediaT.setEnabled(false);
        mediaT.setBackground(Color.darkGray);
        highT.setPreferredSize(ps);
        highT.setEnabled(false);
        highT.setBackground(Color.darkGray);
        wideT.setPreferredSize(ps);
        wideT.setEnabled(false);
        wideT.setBackground(Color.darkGray);
        acq.setEnabled(false);
        acq.setBackground(Color.darkGray);
        rel.setEnabled(false);
        rel.setBackground(Color.darkGray);
        
        setCommon(); //add labels and text fields
        setSelection(); //set Options panel and set Actions Panel and add them both to selection panel
        setDisplay();   //initialize display pane
        this.add(common);
        this.add(selection);
        this.add(display);
        this.setVisible(true);

    }

    private void setCommon() {
        
        common.setSize(new Dimension(350, 200));
        common.add(title);
        common.add(titleT);
        common.add(author);
        common.add(authorT);
        common.add(dateAcq);
        common.add(acq);
        common.add(dateRel);
        common.add(rel);
        common.add(pPrice);
        common.add(pPriceT);
        common.add(aPrice);
        common.add(aPriceT);
    }
    
    private void setOptions() {
        options.setSize(350, 200);
        options.add(actor);
        options.add(actorT);
        options.add(director);
        options.add(directorT);
        options.add(genre);
        options.add(genreT);
        options.add(media);
        options.add(mediaT);
        options.add(wide);
        options.add(wideT);
        options.add(high);
        options.add(highT);
//        options.add(qty);
//        options.add(qtyT);
    }

    private void setDisplay() {
        display.setPreferredSize(new Dimension(550, 200));
        display.setMinimumSize(new Dimension(550, 200));
        invList.setPreferredSize(new Dimension(300, 200));
        invList.setMinimumSize(new Dimension(300, 200));
        invList.setAlignmentX(LEFT_ALIGNMENT);
        info.setPreferredSize(new Dimension(250, 200));
        info.setMinimumSize(new Dimension(250, 200));
        invList.add(invCount);
        display.add(invList);
        display.add(info);   
        info.add(invInfo);
    }

    private void setSelection() {
        selection.setSize(400, 300);
        selection.setLayout(new BoxLayout(selection, BoxLayout.Y_AXIS));
        setOptions();   //set type specific labels and text fields
        setActions();   //set radio buttons and add/remove buttons for actions
        selection.add(options);
        selection.add(action);
        
    }

    private void setActions() {
        action.setSize(250, 100);
        action.setLayout(new BoxLayout(action, BoxLayout.Y_AXIS));
        action.setAlignmentX(CENTER_ALIGNMENT);
        add.setAlignmentX(Component.CENTER_ALIGNMENT);
        remove.setAlignmentX(Component.CENTER_ALIGNMENT);
                
        buttonGroup.add(movie);
        buttonGroup.add(book);
        buttonGroup.add(painting);
        movie.setAlignmentX(Component.CENTER_ALIGNMENT);
        book.setAlignmentX(Component.CENTER_ALIGNMENT);
        painting.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        //action.add(Box.createHorizontalStrut(10));
        action.add(movie);        
        action.add(book);
        action.add(painting);   
        action.add(add);
        action.add(remove);
        
        //disable and enable fields as radio buttons are selected
        movie.addActionListener(this);
        book.addActionListener(this);
        painting.addActionListener(this);
        add.addActionListener(this);
        remove.addActionListener(this);

    }

    private void disableFields() {
        genreT.setEnabled(false);
        genreT.setBackground(Color.darkGray);
        directorT.setEnabled(false);
        directorT.setBackground(Color.darkGray);
        actorT.setEnabled(false);
        actorT.setBackground(Color.darkGray);
        mediaT.setEnabled(false);
        mediaT.setBackground(Color.darkGray);
        highT.setEnabled(false);
        highT.setBackground(Color.darkGray);
        wideT.setEnabled(false);
        wideT.setBackground(Color.darkGray);
    }

    private void activateFields() {
        rel.setEnabled(true);
        rel.setBackground(Color.white);
        aPriceT.setEnabled(true);
        aPriceT.setBackground(Color.white);
        pPriceT.setEnabled(true);
        pPriceT.setBackground(Color.white);
        titleT.setEnabled(true);
        titleT.setBackground(Color.white);
        acq.setEnabled(true);
        acq.setBackground(Color.white);
        authorT.setEnabled(true);
        authorT.setBackground(Color.white);
//        qtyT.setEnabled(true);
//        qtyT.setBackground(Color.white);
    }
    
    private void setFields(){

        inventory[i].setAskingPrice(Integer.parseInt(aPriceT.getText()));
        inventory[i].setTitle(titleT.getText());
        inventory[i].setDateAcquired(acq.getDate());
        inventory[i].setDateAcquired(rel.getDate());
        inventory[i].setPurchasePrice(Integer.parseInt(pPriceT.getText()));
        inventory[i].setAuthor(authorT.getText());
//        inventory[i].setItemCount(Integer.parseInt(qtyT.getText()));
        setInvDisplay();
//        
//            JTextArea invInfo = new JTextArea();
//            invInfo.setText(inventory[i].printableString());
//            info.add(invInfo);
        i++;
       
        titleT.setText("");
        authorT.setText("");
        rel.getEditor().setText("");
        acq.getEditor().setText("");
        aPriceT.setText("");
        pPriceT.setText("");
//        qtyT.setText("");
        directorT.setText("");
        actorT.setText("");
        genreT.setText("");
        highT.setText("");
        wideT.setText("");
        mediaT.setText("");
   
    }

    private void setInvDisplay() {
        JButton item = new JButton();
        item.setEnabled(true);
        item.addActionListener(this);
        item.setPreferredSize(ps);
        StoreItem[] temp = new StoreItem[inventory.length];
        JButton[] temp1 = new JButton[buttonList.length];
//        labelList = new JLabel[inventory.length];
        invList.add(item);
        buttonList[i] = item;
        
        
        //set temp items
        for(int count=0; count < temp.length; count++)
        {
            temp[count] = inventory[count];
            item.setText(temp[count].getTitle());
//            labelList[count] = item;  
            temp1[count] = buttonList[count];
        }
        
        buttonList = new JButton[temp1.length+1];
        inventory = new StoreItem[temp.length+1];        
                
        System.arraycopy(temp, 0, inventory, 0, inventory.length-1);
        System.arraycopy(temp1, 0, buttonList, 0, buttonList.length-1);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource().equals(movie))
        {
            disableFields();
            activateFields();
            genreT.setEnabled(true);
            genreT.setBackground(Color.white);
            actorT.setEnabled(true);
            actorT.setBackground(Color.white);
            directorT.setEnabled(true);
            directorT.setBackground(Color.white);
        }
        
        if(ae.getSource().equals(book))
        {
            disableFields();
            activateFields();
            genreT.setEnabled(true);
            genreT.setBackground(Color.white);
        }               
        
        if(ae.getSource().equals(painting))
        {
            disableFields();
            activateFields();
            mediaT.setEnabled(true);
            mediaT.setBackground(Color.white);
            highT.setEnabled(true);
            highT.setBackground(Color.white);
            wideT.setEnabled(true);
            wideT.setBackground(Color.white);
        }
        
        if(ae.getSource().equals(add))
        {
                   //verify dates
            try{
                if (rel.getDate().after(acq.getDate()))
                    throw new Exception();
                if (rel.getDate().after(Date.from(Instant.now())))
                    throw new Exception();
                if (acq.getDate().after(Date.from(Instant.now())))
                    throw new Exception();
            }
            catch(Exception ex){
                errorMessage.setText("ERROR: Invalid Dates!");
            }
            //verify text input
            try{
                if(genreT.isEnabled()&& genreT.getText().trim().isEmpty())
                    throw new Exception();
                if(directorT.isEnabled()&& directorT.getText().trim().isEmpty())
                    throw new Exception();
                if(actorT.isEnabled()&& actorT.getText().trim().isEmpty())
                    throw new Exception();
                if(mediaT.isEnabled()&& mediaT.getText().trim().isEmpty())
                    throw new Exception();
                if(highT.isEnabled()&& highT.getText().trim().isEmpty())
                    throw new Exception();
                if(wideT.isEnabled()&& wideT.getText().trim().isEmpty())
                    throw new Exception();
                if(aPriceT.getText().trim().isEmpty())
                    throw new Exception();
                if(titleT.getText().trim().isEmpty())
                    throw new Exception();
                if(pPriceT.getText().trim().isEmpty())
                    throw new Exception();
            }
            catch(Exception ex)
            {
                errorMessage.setText("ERROR: Please fill in all required fields");
            }
            
            //check for errors
            //verify selection
            try{
                if(movie.isSelected()){
                    x = new Movie();           
                    ((Movie)x).setGenre(genreT.getText());     
                    ((Movie)x).setDirector(directorT.getText());
                    ((Movie)x).setActor(actorT.getText());
                }
                else if(book.isSelected()){
                    x = new Book();
                    ((Book)x).setGenre(genreT.getText());
                }
                else if(painting.isSelected()){
                    x = new Painting();
                    ((Painting)x).setHeight(Integer.parseInt(highT.getText()));
                    ((Painting)x).setWidth(Integer.parseInt(wideT.getText()));
                    ((Painting)x).setMedia(mediaT.getText());
                }
                else
                throw new Exception();
            }
            catch(Exception ex){
                errorMessage.setText("ERROR: No category selected!");
            }
            System.out.println(x.printableString());
            
     
            inventory[i]=x;
            setFields();

        }
        
        if(ae.getSource().equals(remove))
        {for (int count = 0; count < inventory.length-1; count++) {

                
            }   
        }
        
        //specific inventory item has been selected to be displayed
        for(int count = 0; count < buttonList.length; count++)
        {
            if(ae.getSource().equals(buttonList[count]))
            {
                setInfo(buttonList[count].getText());
            }
    }
}

    private void setInfo(String text) {
        for (int count = 0; count < inventory.length-1; count++) {
            //System.out.println(inventory[0].getTitle());
            
            if(inventory[count].getTitle().equalsIgnoreCase(text)) {
                numDisplayed = count;
                //System.out.println("FOUND");
                invInfo.setText(inventory[count].printableString());
                
                //******FIX THIS********
                if(inventory[count].getClass().getName().equalsIgnoreCase("Book"))
                    book.setSelected(true);                
            }
        }
      
    }}
