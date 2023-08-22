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
public class Rol {
    private int id;
    private String name;

    public Rol() {
    }
    
    public Rol(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return this.name;//super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
        /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Rol otherArea = (Rol) obj;
        return id == otherArea.id;
        /*if(obj==null){
            return true;
        }else{
            return this.id==(((Rol)obj).id);
        }*/
    }
    

}
