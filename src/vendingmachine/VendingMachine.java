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
public class VendingMachine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Pepsi p = new Pepsi();
        List<Coin> coins = new ArrayList<>();
        coins.add(new Quarter());
        coins.add(new Dime());
        coins.add(new Penny());
        
        VendingMachineService vms = new VendingMachineService();
        vms.setProduct(p);
        vms.setCoins(coins);
        List<Coin> change = vms.dispenseProduct();
        if(change == null){
            System.out.println("No change to dispense");
        }else{
            for(Coin c : change){
            System.out.println(c.getName() + " : " + c.getValue());
         }
        }
        
    }
    
}
