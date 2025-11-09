package com.zipcodewilmington.phonebook;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */

public class PhoneBook {                   

    private final Map<String, List<String>> phonebook;    // stores the phonebook as a map where keys are names and values are lists of phonenumbers 

    public PhoneBook(Map<String, List<String>> map) {       // creates a phonebook from existing map or creates empty one
        if (map == null){                                   // if the map is empty
            this.phonebook = new LinkedHashMap<>();         // create a new linked hash map
        } else {                                            // otherwise
            this.phonebook = map;                           // use the existing map
        }
    }

    public PhoneBook() {                                    // no-argument constructor: calls other constructor with null to create empty phonebook
        this(null);
    }

    public void add(String name, String phoneNumber) {          // method to add a phone number to name
        if (this.phonebook.containsKey(name)) {                 // if the phonebook contains the inputed name
            this.phonebook.get(name).add(phoneNumber);          // get that name, and add the phone number to it
        } else {                                                // otherwise
            List<String> phoneNumbersList = new ArrayList<>();  // create a new array list for the phone number
            phoneNumbersList.add(phoneNumber);                  // add the phone number to is
            this.phonebook.put(name, phoneNumbersList);         // add that phone number arraylist to that name
        }
    }

    public void addAll(String name, String... phoneNumbers) {
                for (int i = 0; i < phoneNumbers.length; i++)   // loop through the array of phonenumbers
                    this.add(name, phoneNumbers[i]);            // add each phone number in the array to the given name
        }

    public void remove(String name) {
        this.phonebook.remove(name);                        // remove the name in the phonebook
    }

    public Boolean hasEntry(String name) {
        return this.phonebook.containsKey(name);                        // checks if name exists in the phonebook
}

    public Boolean hasEntry(String name, String phoneNumber) {          // checks if name has specific phone number
        List<String> numbers = lookup(name);                            // get the list of numbers for this name
        
        if (numbers == null) {                                          // if the name doesnt exist
            return false;                                               // return false
        }
        return numbers.contains(phoneNumber);                           // check if the list contains the number
    }

    public List<String> lookup(String name) {           // look up name in the phonebook
        if (this.phonebook.containsKey(name)) {         // if the phonebook contains this name
            return this.phonebook.get(name);            // return list of numbers assosciated to this name
        } else {                                        // otherwise
            return null;                                // return nothing
        }
    }

    public String reverseLookup(String phoneNumber)  {
            for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {        // loop through each entry in the phone book
                String name = entry.getKey();                                           // extract the name
                List<String> numbers = entry.getValue();                                // extract the list of numbers
            
            if (numbers.contains(phoneNumber)) {                                        // check if this persons list has the number
                return name;                                                            // if yes, return name
            }
        }
        return null;                                                                    // if not, return null
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(phonebook.keySet());        // creates a new arraylist and returns all the keys(names) in the phonebook inside that arraylist
    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;                          // return the phonebook map
    }
}
