/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waiteproj4;

import java.awt.BorderLayout;
import java.awt.Color;
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
import org.jdesktop.swingx.JXDatePicker;


/**
 *
 * @author mw047
 */
public class customGUI extends JFrame implements ActionListener{
    
    StoreItem[] inventory = new StoreItem[1];   //count overall inventory items
    StoreItem x;                          //create inventory item
    int i = 0;                          //count for StoreItem[]
 
    JButton[] buttonList = new JButton[1];      //buttons to display inventory items
    //int numDisplayed = 0;
    JLabel invCount = new JLabel("There are " + StoreItem.getItemCount() + " items in inventory.");     //label to display count
    JLabel bookCount = new JLabel("There are " + Book.getBookCount() + " books in inventory.");
    JLabel movieCount = new JLabel("There are " + Movie.getMovieCount() + " movies in inventory.");
    JLabel paintingCount = new JLabel("There are " + Painting.getPaintingCount() + " paintings in inventory.");
    
    
//create panels to hold various fields
    JPanel common = new JPanel(new GridLayout(12, 2, 5, 5));     //displays input attributes to inventory
//    JPanel options = new JPanel(new GridLayout(8, 2, 5, 5));    //displays attributes specific to inventory types
    JPanel display = new JPanel(new GridLayout());              //container for output
    JPanel selection = new JPanel();                    //holds button array to select/display inventory items
    JPanel action = new JPanel(new GridLayout(5, 1, 5, 5));               //holds radio buttons and add/remove buttons
    JPanel invList = new JPanel();              //
    JPanel info = new JPanel();
    
    JTextArea invInfo = new JTextArea();        //displays inventory information for selected inventory item
               
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
        authorT.setPreferredSize(ps);
        pPriceT.setPreferredSize(ps);
        aPriceT.setPreferredSize(ps);
        genreT.setPreferredSize(ps);
        actorT.setPreferredSize(ps);
        directorT.setPreferredSize(ps);
        mediaT.setPreferredSize(ps);
        highT.setPreferredSize(ps);
        wideT.setPreferredSize(ps);
        disableFields();
        
        setCommon(); //add labels and text fields
        setSelection(); //set Options panel and set Actions Panel and add them both to selection panel
        setDisplay();   //initialize display pane
        this.add(common);
        this.add(selection);
        this.add(display);
        this.setVisible(true);
    }

    private void setCommon() {
        
        common.setSize(new Dimension(350, 500));
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
        common.add(actor);
        common.add(actorT);
        common.add(director);
        common.add(directorT);
        common.add(genre);
        common.add(genreT);
        common.add(media);
        common.add(mediaT);
        common.add(wide);
        common.add(wideT);
        common.add(high);
        common.add(highT);
    }

    private void setDisplay() {
        display.setPreferredSize(new Dimension(550, 200));
        display.setMinimumSize(new Dimension(550, 200));
        invList.setPreferredSize(new Dimension(300, 200));
        invList.setMinimumSize(new Dimension(300, 200));
        invList.setAlignmentX(LEFT_ALIGNMENT);
        info.setPreferredSize(new Dimension(250, 200));
        info.setMinimumSize(new Dimension(250, 200));
        //invList.add(invCount);
        display.add(invList);
        display.add(info);   
        info.add(invInfo);
    }

    private void setSelection() {
        selection.setPreferredSize(new Dimension(350, 300));
        selection.setLayout(new BoxLayout(selection, BoxLayout.Y_AXIS));

//        setOptions();   //set type specific labels and text fields
        setActions();   //set radio buttons and add/remove buttons for actions
//        selection.add(options);
        selection.add(action, new BorderLayout());
        updateCounts();
        
        selection.add(invCount);
        selection.add(movieCount);
        selection.add(bookCount);
        selection.add(paintingCount);
        
    }

    private void setActions() {
        selection.setBackground(Color.lightGray);
//        action.setBackground(Color.red);
        action.setSize(new Dimension(350, 50));
        
        buttonGroup.add(movie);
        buttonGroup.add(book);
        buttonGroup.add(painting);

        //action.add(Box.createVerticalStrut(1));
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
        titleT.setEnabled(false);
        titleT.setBackground(Color.lightGray);
        authorT.setEnabled(false);
        authorT.setBackground(Color.lightGray);
        acq.setEnabled(false);
        acq.setBackground(Color.lightGray);
        rel.setEnabled(false);
        rel.setBackground(Color.lightGray);
        pPriceT.setEnabled(false);
        pPriceT.setBackground(Color.lightGray);
        aPriceT.setEnabled(false);
        aPriceT.setBackground(Color.lightGray);
        genreT.setEnabled(false);
        genreT.setBackground(Color.lightGray);
        directorT.setEnabled(false);
        directorT.setBackground(Color.lightGray);
        actorT.setEnabled(false);
        actorT.setBackground(Color.lightGray);
        mediaT.setEnabled(false);
        mediaT.setBackground(Color.lightGray);
        highT.setEnabled(false);
        highT.setBackground(Color.lightGray);
        wideT.setEnabled(false);
        wideT.setBackground(Color.lightGray);
    }

    private void activateFields() {
        add.setEnabled(true);
        remove.setEnabled(true);
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
        inventory[i].setDateReleased(rel.getDate());
        inventory[i].setPurchasePrice(Integer.parseInt(pPriceT.getText()));
        inventory[i].setAuthor(authorT.getText());
//        inventory[i].setItemCount(Integer.parseInt(qtyT.getText()));
        setInvDisplay();
        clearFields();
    }

    private void setInvDisplay() {
        
        JButton item = new JButton();
        item.setEnabled(true);
        item.addActionListener(this);
        item.setPreferredSize(ps);
        StoreItem[] temp = new StoreItem[inventory.length];
        JButton[] temp1 = new JButton[buttonList.length];
//        labelList = new JLabel[inventory.length];
        buttonList[i] = item;
        invList.add(buttonList[i]);
        
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
        
        i++;
    }
    
    private void setInfo(String text){
        //search for StoreItem
        for (int count = 0; count < inventory.length-1; count++) {
            
            if(inventory[count].getTitle().equalsIgnoreCase(text)) {    //if found
                invInfo.setText(inventory[count].printableString());    //display printableString
                
                if(inventory[count].getClass().getName().equalsIgnoreCase("waiteproj4.Book")){
                    book.setSelected(true);
                    titleT.setText(inventory[count].getTitle());
                    authorT.setText(inventory[count].getAuthor());
                    genreT.setText(((Book)inventory[count]).getGenre());
                    acq.setDate(inventory[count].getDateAcquired());
                    rel.setDate(inventory[count].getDateReleased());
                    pPriceT.setText(Integer.toString(inventory[count].getPurchasePrice()));
                    aPriceT.setText(Integer.toString(inventory[count].getAskingPrice()));
                }   
                else if(inventory[count].getClass().getName().equalsIgnoreCase("waiteproj4.Movie")){
                    movie.setSelected(true);
                    titleT.setText(inventory[count].getTitle());
                    authorT.setText(inventory[count].getAuthor());
                    actorT.setText(((Movie)inventory[count]).getActor());
                    directorT.setText(((Movie)inventory[count]).getDirector());
                    genreT.setText(((Movie)inventory[count]).getGenre());
                    acq.setDate(inventory[count].getDateAcquired());
                    rel.setDate(inventory[count].getDateReleased());
                    pPriceT.setText(Integer.toString(inventory[count].getPurchasePrice()));
                    aPriceT.setText(Integer.toString(inventory[count].getAskingPrice()));
                }
                else if(inventory[count].getClass().getName().equalsIgnoreCase("waiteproj4.Painting")){
                    painting.setSelected(true);
                    titleT.setText(inventory[count].getTitle());
                    authorT.setText(inventory[count].getAuthor());
                    acq.setDate(inventory[count].getDateAcquired());
                    rel.setDate(inventory[count].getDateReleased());
                    pPriceT.setText(Integer.toString(inventory[count].getPurchasePrice()));
                    aPriceT.setText(Integer.toString(inventory[count].getAskingPrice()));
                    mediaT.setText(((Painting)inventory[count]).getMedia());
                    wideT.setText(Integer.toString(((Painting)inventory[count]).getWidth()));
                    highT.setText(Integer.toString(((Painting)inventory[count]).getHeight()));
                }
            }
        }
      
    }
    
    private void updateCounts() {
        invCount.setText("There are " + StoreItem.getItemCount() + " TOTAL items in inventory.");     //label to display count
        bookCount.setText("There are " + Book.getBookCount() + " BOOKS in inventory.");             //display book count
        movieCount.setText("There are " + Movie.getMovieCount() + " MOVIES in inventory.");         //display movie count
        paintingCount.setText("There are " + Painting.getPaintingCount() + " PAINTINGS in inventory.");     //display painting count
    }

    private void clearFields() {
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
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource().equals(movie))
        {
            disableFields();
            activateFields();
            clearFields();
            invInfo.setText("");
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
            clearFields();
            invInfo.setText("");
            genreT.setEnabled(true);
            genreT.setBackground(Color.white);
        }               
        
        if(ae.getSource().equals(painting))
        {
            disableFields();
            activateFields();
            clearFields();
            invInfo.setText("");
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
                    Movie.increaseMovieCount();
                }
                else if(book.isSelected()){
                    x = new Book();
                    ((Book)x).setGenre(genreT.getText());
                    Book.increaseBookCount();
                }
                else if(painting.isSelected()){
                    x = new Painting();
                    ((Painting)x).setHeight(Integer.parseInt(highT.getText()));
                    ((Painting)x).setWidth(Integer.parseInt(wideT.getText()));
                    ((Painting)x).setMedia(mediaT.getText());
                    Painting.increasePaintingCount();
                }
                else
                throw new Exception();
            }
            catch(Exception ex){
                errorMessage.setText("ERROR: No category selected!");
            }
            
            updateCounts();
            inventory[i]=x;
            setFields();

        }
        
        if(ae.getSource().equals(remove)){
        for (int count = 0; count < inventory.length-1; count++) {     //find inventory item location in array
                        
            if(inventory[count].getTitle().equalsIgnoreCase(titleT.getText())){     //when found
                if(inventory[count].getClass().getName().equalsIgnoreCase("waiteproj4.Book"))
                    Book.decreaseBookCount();
                else if(inventory[count].getClass().getName().equalsIgnoreCase("waiteproj4.Movie"))
                    Movie.decreaseMovieCount();
                else if(inventory[count].getClass().getName().equalsIgnoreCase("waiteproj4.Painting"))
                    Painting.decreasePaintingCount();
                
                invList.remove(buttonList[count]);
                invList.revalidate();
                invList.repaint();

                    //create temp storeItem array
                StoreItem[] temp = new StoreItem[inventory.length-1];          
                    //create temp button array
                JButton[] temp1 = new JButton[buttonList.length-1];
                    //copy inventory and buttonList to temp arrays
                for(int c = 0; c<count; c++){
                    temp1[c] = buttonList[c];
                    temp[c] = inventory[c];
                }
                    //remove selected inventory and corresponding button and shift inventory items accordingly
                for(int pivot = count; pivot < temp.length-1; pivot++){
                    temp[pivot]=inventory[pivot+1];
                    temp1[pivot]=buttonList[pivot+1];
                }
                    //removeButton(buttonList[count].getText());
                buttonList = new JButton[temp1.length];
                inventory = new StoreItem[temp.length];
                System.arraycopy(temp, 0, inventory, 0, inventory.length);
                System.arraycopy(temp1, 0, buttonList, 0, buttonList.length);

                i--; 
                
                updateCounts();
                break;
                }
            }
            invInfo.setText("");
            remove.setEnabled(false);
            clearFields();
        }
        
        //specific inventory item has been selected to be displayed
        for(int count = 0; count < buttonList.length; count++)
        {
            if(ae.getSource().equals(buttonList[count]))
            {
                setInfo(buttonList[count].getText());
                add.setEnabled(false);
                remove.setEnabled(true);
                disableFields();
            }
    }
}   
  
}
