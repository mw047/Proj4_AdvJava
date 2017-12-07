package waiteproj4;

import java.util.Date;

/**
 *
 * @author mw047
 */
public class StoreItem {

    private static int      itemCount;

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int aItemCount) {
        itemCount = aItemCount;
    }

    public StoreItem(){
        
    }
    public StoreItem(String title, String author, Date dateAcquired, int purchasePrice, int askingPrice, int count) {
        this.title = title;
        this.author = author;
        this.dateAcquired = dateAcquired;
        this.purchasePrice = purchasePrice;
        this.askingPrice = askingPrice;
        this.itemCount = count;
    }

    protected String    title;
    protected String    author;
    private Date      dateAcquired;
    private int   purchasePrice;
    private int   askingPrice;
    private int   profit;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }    
    
    public Date getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(Date dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getAskingPrice() {
        return askingPrice;
    }

    public void setAskingPrice(int askingPrice) {
        this.askingPrice = askingPrice;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }
    
    /**************************************************
     * Method Name: remove()
     * Method Author:  Mary Waite
     **************************************************
     * Purpose of the Method:  decrement count
     * Method Inputs:  int quantity
     * Return value:  none
     **************************************************
     * Date:  30 September 2017
     * @param quantity
     **************************************************/    
    protected void remove(int quantity) // called when removing an item, decrements the bookCount
    {
        itemCount-=quantity;
    }
    
    
    /**************************************************
     * Method Name: printString()
     * Method Author:  Mary Waite
     **************************************************
     * Purpose of the Method:  return object as printable line item
     * Method Inputs:  none
     * Return value:  String p
     **************************************************
     * Date:  30 September 2017
     * @return 
     **************************************************/
    protected String printableString()
    {
        String p = String.format("%-25s", "Title") + title 
            + String.format("%-25s", "\nAuthor" ) + author 
            + String.format("%-25s", "\nDate Acquired" ) + dateAcquired 
             + String.format("%-25s", "\nPurchase Price") + purchasePrice  
            + String.format("%-25s", "\nAsking Price ") + askingPrice;

        return p;
    }
    
}
