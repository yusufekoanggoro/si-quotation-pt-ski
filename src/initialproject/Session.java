package initialproject;

public class Session {
    private static int id;
    private static String level;
    
    public static void setId(int id){
        Session.id = id;
    }
    
    public static int getId(){
        return id;
    }
    
    public static void setLevel(String level){
        Session.level = level;
    }
    
    public static String getLevel(){
        return level;
    }
}
