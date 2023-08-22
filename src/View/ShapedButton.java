package View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShapedButton {

 private static JFrame frame;

 public Component createComponents() {

  // Tres botones para probar diferentes efectos
  JButton roundButton = new JButton("Redondo");
  JButton squareButton = new JButton("Cuadrado");
  JButton polygonButton = new JButton("Poligonal");

  // Establecemos un UI específico
  ShapedButtonUI roundUI = new ShapedButtonUI();
  roundUI.setShape(ButtonShape.ROUND, roundButton);
  roundButton.setUI(roundUI);
  roundButton.setPreferredSize(new Dimension(100, 100));
  ShapedButtonUI squareUI = new ShapedButtonUI();
  squareUI.setShape(ButtonShape.SQUARE, squareButton);
  squareButton.setUI(squareUI);
  squareButton.setPreferredSize(new Dimension(100, 100));
  ShapedButtonUI polygonUI = new ShapedButtonUI();
  polygonUI.setShape(ButtonShape.POLYGON, polygonButton);
  polygonButton.setUI(polygonUI);
  polygonButton.setPreferredSize(new Dimension(100, 100));

  // Añadimos nuestros componentes
  JPanel panel = new JPanel();
  panel.add(roundButton);
  panel.add(squareButton);
  panel.add(polygonButton);

  return panel;
 }

 /**
  * Definimos tres posibles formas para los botones
  */
 public enum ButtonShape {
  ROUND,
  SQUARE,
  POLYGON
 }

 private static void createAndShowGUI() {

  // Create and set up the window.
  frame = new JFrame("Shaped button");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  ShapedButton app = new ShapedButton();
  Component contents = app.createComponents();
  frame.getContentPane().add(contents, BorderLayout.CENTER);

  // Display the window.
  frame.pack();
  frame.setLocationByPlatform(true);
  frame.setVisible(true);
 }

 public static void main(String[] args) {
  // Schedule a job for the event dispatch thread:
  // creating and showing this application's GUI.
  javax.swing.SwingUtilities.invokeLater(new Runnable() {
   public void run() {
    createAndShowGUI();
   }
  });
 }
}