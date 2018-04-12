/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rm4806
 */
public class VendingMachineService {
    
    private Product product;
    private List<Coin> coins;

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }
    
    public List<Coin> dispenseProduct() throws Exception{
        List<Coin> changeBack = new ArrayList<>();
        //calculate total cash inserted by user
        int amount = 0;
        for(Coin c : coins){
            amount += c.getValue();
        }
        if(product.getAmount() > amount){
            throw new Exception("Sorry! Product costs more than cash inserted");     // product cannot be dispensed... less cash 
        }else{
            //we can dispense the product, calculate change 
            int change = amount - product.getAmount();
            System.out.println(product.getName() + " dispensed!");
            if(change == 0){
                return null;   // no change to be given back
            }else{
              while(change > 0){
                  if(change >= 25){
                      changeBack.add(new Quarter());
                      change -= 25;
                  }else if(change >= 10){
                      changeBack.add(new Dime());
                      change -= 10;
                  }else if(change >= 5){
                      changeBack.add(new Nickle());
                      change -= 5;
                  }else{
                      changeBack.add(new Penny());
                      change -= 1;
                  }
              }
            }
        }
        return changeBack;
    }
    
    public List<Coin> cancelRequest(){
        return coins;
    }
}
