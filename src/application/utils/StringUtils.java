/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.utils;

public class StringUtils {
    
    public static String getInitialsFullName(String fullName) {
        String initials = String.valueOf(fullName.charAt(0));

        for (int i = 1; i < fullName.length() - 1; i++){
            if (fullName.charAt(i) == ' '){
                initials = initials + String.valueOf(fullName.charAt(i + 1));
            }                
        }
        return initials.toUpperCase();
    }
}
