/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.SimpleMessage;

/**
 *
 * @author PIERO
 */
import java.awt.Color;
import java.awt.Component;
import net.miginfocom.layout.LayoutCallback;

/**
 *
 * @author Raven
 */
public interface Option {

    public LayoutCallback getLayoutCallBack(Component parent);

    public String getLayout(Component parent, float animate);

    public boolean closeWhenClickOutside();

    public boolean blockBackground();

    public Color background();

    public float opacity();

    public int duration();

    public float getAnimate();

    void setAnimate(float animate);
}