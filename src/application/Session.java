package application;

public class Session {
    private static int id;
    private static int level;
    
    public static void setId(int id){
        Session.id = id;
    }
    
    public static int getId(){
        return id;
    }
    
    public static void setLevel(int level){
        Session.level = level;
    }
    
    public static int getLevel(){
        return level;
    }
}
