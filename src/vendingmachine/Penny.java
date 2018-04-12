/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

/**
 *
 * @author rm4806
 */
public class Penny implements Coin{

    private final String name = "Penny";
    private final int value = 1;
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return value;
    }
    
}
