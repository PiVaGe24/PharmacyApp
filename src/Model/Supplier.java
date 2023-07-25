/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author PIERO
 */
public class Supplier {
    private int id;
    private String name;
    private String description;
    private String telephone;
    private String address;
    private String email;
    private String city;
    private String created;
    private String updated;

    public Supplier() {
    }
    
    public Supplier(int id, String name){
        this.id=id;
        this.name=name;
    }
    
    public Supplier(int id){
        this.id=id;
    }

    public Supplier(int id, String name, String description, String telephone, String address, String email, String city, String created, String updated) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.telephone = telephone;
        this.address = address;
        this.email = email;
        this.city = city;
        this.created = created;
        this.updated = updated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return true;
        }else{
            return this.id==(((Supplier)obj).id); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    
    
}
