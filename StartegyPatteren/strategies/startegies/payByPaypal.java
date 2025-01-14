package StartegyPatteren.strategies.startegies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class payByPaypal implements payStartegy {

    private  static  final Map<String , String> Data_base = new HashMap<>();

    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    private  String email;
    private String password;

    private boolean singnedIn;


    static {
        Data_base.put("sandy","sandy@gmail.com");
        Data_base.put("qwerty","qwerty@gmail.com");
    }


    /*

    collect customer data
     */

    @Override
    public  void   collectpayementDetail(){
        try{
            while(!singnedIn){
                System.out.print("Enter the user name");
                email = READER.readLine();

                System.out.print("Enter the password");
                password = READER.readLine();


                if(verify()){
                    System.out.println("DATA is verify");
                }else{
                    System.out.println("DATA is Not verify");
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }


    }

    private boolean verify(){
        setSignedIn(email.equals(Data_base.get(password)));
        return singnedIn;
    }


    /*
    set customer data for payment
     */


    public  boolean pay(int payamount){
        if(singnedIn){
            System.out.println("Paying " + payamount + "using paypal");
            return  true;
        }else{
            return  false;
        }
    }


    private  void setSignedIn(boolean signedIn){
        this.singnedIn=signedIn;
    }
}
