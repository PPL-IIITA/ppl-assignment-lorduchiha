/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q10;

public abstract class Gifts {
    public String type;
    public int price;
    public int value;
}
class essential extends Gifts{

    public essential( int price, int value) {
       type = "ESSENTIAL";
       this.price = price;
       this.value = value;
    }

}
class luxury extends Gifts{

    public luxury(int price, int value) {
        type = "LUXURY";
        this.price = price;
        this.value = value;
    }

}
class utility extends Gifts{

    public utility( int price, int value) {
       type = "UTILITY";
        this.price = price;
        this.value = value;
    }

}
