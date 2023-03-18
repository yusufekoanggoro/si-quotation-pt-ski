package initialproject.models;

public class User
{
    private int id;
    private String name;
    private int age;
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public int getAge(){
        return this.age;
    }
}