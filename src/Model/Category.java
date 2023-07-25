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
public class Category {
    private int id;
    private String name;
    private String created;
    private String updated;

    public Category() {
    }
    
    public Category(int id){
        this.id=id;
    }
    
    public Category(int id,String name){
        this.id=id;
        this.name=name;
    }

    public Category(int id, String name, String created, String updated) {
        this.id = id;
        this.name = name;
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
    public String toString(){
        return name;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj==null){
            return true;
        }else{
            return this.id==(((Category)obj).id);
        }
    }
}
