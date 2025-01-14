package Observer;

import java.util.ArrayList;
import java.util.List;

interface Follower{
    void update(String celebrityName, String post);
}


interface Celebrity{
    void addFollower(Follower follower);
    void removeFollower(Follower follower);
    void notifyFollower(String post);
}

// concerte subject

class CelebrityAccount implements  Celebrity{

    private String name;
    private List<Follower> followerList = new ArrayList<>();

    public CelebrityAccount(String name){
        this.name=name;
    }


    @Override

    public  void  addFollower(Follower follower){
        followerList.add(follower);
    }

    @Override

    public  void  removeFollower(Follower follower){
        followerList.remove(follower);
    }


    @Override
    public  void notifyFollower(String post){

        for(Follower follower:followerList){
            follower.update(name,post);
        }
    }


    // method to post the content

    public void post(String content){
        System.out.println(name +" " + content);
        notifyFollower(content);
    }


}



class User implements Follower{

    private String username;

    public User(String username){
        this.username=username;
    }


    @Override
    public void update(String celebrityName, String post){
        System.out.print(username + "  received   " + celebrityName + "  Post  " + post);
    }
}



public class SocialMediaPlatform {

    public static void main(String[] args) {


        CelebrityAccount celebrityAccount = new CelebrityAccount("MS Dhoni");

        Follower user1 = new User("Sandeep");

        celebrityAccount.addFollower(user1);

        celebrityAccount.post("EK CHAAKE NE HI WC JITYA HAI QKI MERE ALWA KISI  NE SIX NHI MARA - MC Gambhir");



    }
}
