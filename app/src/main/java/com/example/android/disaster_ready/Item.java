package com.example.android.disaster_ready;

public class Item
{
    private String description;
   private int quantity;


   public Item(String description)
   {
       this.description = description;
   }

    public Item(String description, int quantity)
    {
        this.description = description;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
