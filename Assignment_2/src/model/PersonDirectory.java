/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author omkarsalian
 */
public class PersonDirectory {
    
    private ArrayList<Person> profiles;

    public PersonDirectory(){
        this.profiles = new ArrayList<Person>();
    }
    
    public ArrayList<Person> getProfile() {
       return profiles;
    }
    
    public void setProfile(ArrayList<Person> profiles){
        this.profiles = profiles;
    }
    
    public Person addProfile(){
        Person p = new Person();
        profiles.add(p);
        return p;
    }
    
    public void deleteProfile(Person profile){
        profiles.remove(profile);
    }
    public Person searchPerson(String searchTxt) {
        for (Person p : profiles){
            if (p.getFirstname().contains(searchTxt) || p.getLastname().contains(searchTxt) || p.getHomeAddress().getStreetaddress().contains(searchTxt) 
                    || p.getWorkAddress().getStreetaddress().contains(searchTxt)){
                return p;
            }
        }
        return null;
    }
}
