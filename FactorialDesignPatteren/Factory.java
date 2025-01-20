package FactorialDesignPatteren;

abstract class Product{
    public  abstract  void display();
}

class ProductA extends  Product {
    @Override

    public void display(){
        System.out.println("This is product A ");
    }
}


class ProductB extends  Product{

    @Override

    public void display(){
        System.out.println("This Is product B");
    }
}


abstract  class  Creator{
    public abstract  Product factoryMethod();
}


class ConcreataA extends  Creator{
    @Override

    public Product factoryMethod(){
        return  new ProductA();
    }
}



class ConcreateB extends  Creator{
    @Override

    public Product factoryMethod(){
        return new ProductB();
    }
}
public class Factory {

    public static void main(String[] args) {

        /*
        Factory design pattern
        - it is creational design patteren that talks about the create of object

        - its is patteren

        - creation of object on the based on condition

        - factory method


        class1 -
                obj1 - (c1 == c2 ) - then return

                shape - interface
                             - circle (is-a)
                             - squre  (is-a)
                             - circle (is-a)



     code

     - e-commerec website
       - electronics
       - clothings
       - books






        */


        Creator creatorA = new ConcreataA();
        Product product= creatorA.factoryMethod();
        product.display();

        Creator creatorB = new ConcreateB();
        Product product1 = creatorB.factoryMethod();
        product1.display();





    }
}
