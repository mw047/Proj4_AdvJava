/*The Book class should have the properties that are 
  unique to Books (genre, title author, etc). 

Book class extends StoreItem
- bookCount : int Static
- title : String
- genre : String
+ Book(title: String, author :String, dateAcquired :date, purchasePrice: int, askingPrice : int, genre : String)
(add get and set properties)
+ remove()  // called when removing a book item, decrements the bookCount
+ printableString(): string

 */
package waiteproj4;

import java.util.Date;

/**
 *
 * @author mw047
 */
public class Book extends StoreItem  
{
    private static int bookCount;
    private String  genre;          

    public Book(String genre, String title, String author, Date dateAcquired, int purchasePrice, int askingPrice, int bc) {
        super(title, author, dateAcquired, purchasePrice, askingPrice, bc);
        this.genre = genre;
    }

    public Book() {
        super();
        this.genre = "";
    }
    
    public void setBookCount(int bc){
        bookCount = bc;
    }
    
    public int getBookCount(){
        return bookCount;
    }
    
    /**************************************************
     * Method Name: setGenre()
     * Method Author:  Mary Waite
     **************************************************
     * Purpose of the Method:  set genre value
     * Method Inputs:  String g
     * Return value:  none
     **************************************************
     * Date:  30 September 2017
     * @param g
     **************************************************/
    public void setGenre(String g)
    {
        this.genre = g;
    }
    
    /**************************************************
     * Method Name: getGenre()
     * Method Author:  Mary Waite
     **************************************************
     * Purpose of the Method:  return genre value
     * Method Inputs:  none
     * Return value:  String genre
     **************************************************
     * Date:  30 September 2017
     * @return 
     **************************************************/
    public String getGenre()
    {
        return this.genre;
    }

    /**************************************************
     * Method Name: printableString()
     * Method Author:  Mary Waite
     **************************************************
     * Purpose of the Method:  return object as printable line item
     * Method Inputs:  none
     * Return value:  String 
     **************************************************
     * Date:  30 September 2017
     * @return 
     **************************************************/
    @Override
    public String printableString()
    {
        String p = super.printableString()
                + String.format("%-25s", "\nGenre") + genre 
                + String.format("%-25s","\nQuantity") + getItemCount();
        
        return p;
    }
}
