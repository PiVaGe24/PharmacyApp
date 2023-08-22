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
public class Employee {
    private int id;
    private String full_name;
    private String username;
    private String address;
    private String telephone;
    private String email;
    private String password;
    private int id_rol;
    private String rol_name;
    private String created;
    private String update;

    public Employee() {
    }

    public Employee(int id, String full_name, String username, String address, String telephone, String email, String password, int id_rol,String rol_name, String created, String update) {
        this.id = id;
        this.full_name = full_name;
        this.username = username;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
        this.id_rol = id_rol;
        this.rol_name=rol_name;
        this.created = created;
        this.update = update;
    }

    public String getRol_name() {
        return rol_name;
    }

    public void setRol_name(String rol_name) {
        this.rol_name = rol_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }
    
    
}
