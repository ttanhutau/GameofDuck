import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class PlateauJeu {
	
	JFrame frame = new JFrame();
	
	JeuDeLoie joueur1 = new JeuDeLoie();
	JeuDeLoie joueur2 = new JeuDeLoie();
	
	JMenuBar menuBar = new JMenuBar();
	JMenu menu = new JMenu("Menu");
	JMenu des = new JMenu("Joueur 1");
	JMenu des1 = new JMenu("Joueur 2");
	JMenuItem menuItem = new JMenuItem("Start");
	JMenuItem menuItem1 = new JMenuItem("Nouvelle Partie", new ImageIcon("src/image/img.png"));
	JMenuItem desItem = new JMenuItem("Lancer les des");
	JMenuItem desItem1 = new JMenuItem("Lancer les des");
	
	public PlateauJeu() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Le jeu de l'oie");
		frame.setLayout(new GridLayout(7,9));
		
		ArrayList<JButton> Listbt = new ArrayList<JButton>();
		
		for (int i = 1 ; i < 64 ;i++) {
			
			JButton bt = new JButton("CASE "+ i);
			bt.setBackground(new Color(107, 106, 104));
			bt.setOpaque(true);
			bt.setBorderPainted(true);
			Listbt.add(bt);
			frame.add(bt);
			
			if (((i % 9) == 0) && i != 63) {
				
				ImageIcon image = new ImageIcon("src/image/oie1.gif");
				bt.setIcon(image);
				frame.add(bt);
			
			}else if(i == 6 || i == 19 ||i == 31 ||i == 42 ||i == 52 ||i == 58){
			
				ImageIcon image = new ImageIcon("src/image/img00.png");
				bt.setIcon(image);
				frame.add(bt);
			
			}else if(i == 63){
			
				ImageIcon image = new ImageIcon("src/image/img31.png");
				bt.setIcon(image);
				frame.add(bt);
				
		}
	}
		
		//frame.setPreferredSize(new Dimension(900,1000));
		frame.pack();
		menuBar.add(menu);
		menuBar.add(des);
		menuBar.add(des1);
		menu.add(menuItem);
		menu.add(menuItem1);
		des1.add(desItem1);
		des.add(desItem);
		
		frame.setJMenuBar(menuBar);
		
		frame.setVisible(true);
		
		// START
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int valeurde = joueur1.lancerDe();
				int valeurde2 = joueur1.lancerDe();
				
				joueur1.jouerJeuDeLoie(joueur1.position, valeurde, valeurde2);
	
				if(joueur1.position !=0) {
					ImageIcon image = new ImageIcon("src/image/joueur.png");
					Listbt.get(joueur1.position -1).setIcon(image);
					
				}
				desItem1.setEnabled(true);
				menuItem.setEnabled(false);
				menuItem1.setEnabled(true);
				
			}
		});
		
		// joueur1
		desItem.setEnabled(false);
		desItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				desItem.setEnabled(false);
				
				int valeurde = joueur1.lancerDe();
				int valeurde2 = joueur1.lancerDe();
				boolean tour = false;
				
				ImageIcon des = new ImageIcon("src/image/dice.png");
				JOptionPane.showMessageDialog(null, "des 1 : " + valeurde + " des 2 : " + valeurde2, "Lancer de des", JOptionPane.INFORMATION_MESSAGE  ,des);
				
				 if (joueur1.position != 0 && tour == false){
					
					Listbt.get(joueur1.position -1).setIcon(null);
				}
				 
				 if(tour == false) {
					 joueur1.jouerJeuDeLoie(joueur1.position, valeurde, valeurde2);
					 tour = true;
				 }
				 
				 if (tour == true) {
					 
					 if (joueur1.position == 6) {
							JOptionPane.showMessageDialog(null, "le pont", "le pont", JOptionPane.INFORMATION_MESSAGE);
							System.out.println(" le pont ");
						}
						if (joueur1.position == 19) {	
							JOptionPane.showMessageDialog(null, "l'hotel", "l'hotel", JOptionPane.INFORMATION_MESSAGE);
							System.out.println(" l'hotel ");
						}
						if (joueur1.position == 31) {
							JOptionPane.showMessageDialog(null, "le piege", "le piege", JOptionPane.INFORMATION_MESSAGE);
							System.out.println(" le piege ");
						}
						if (joueur1.position == 42) {
							JOptionPane.showMessageDialog(null, "le labyrinthe", "le labyrinthe", JOptionPane.INFORMATION_MESSAGE);
							System.out.println(" le labyrinthe ");
						}
						if (joueur1.position == 52) {
							JOptionPane.showMessageDialog(null, "le train", "le train", JOptionPane.INFORMATION_MESSAGE);
							System.out.println(" le train ");
						}
						if (joueur1.position == 58) {
							
							JOptionPane.showMessageDialog(null, "la mort", "la mort", JOptionPane.INFORMATION_MESSAGE);
							System.out.println(" la mort ");
						}
						
						joueur1.caseSurprises(joueur1.position);
						System.out.println(joueur1.position);
						if(joueur1.position !=0) {
							
							ImageIcon image = new ImageIcon("src/image/joueur.png");
							Listbt.get(joueur1.position -1).setIcon(image);
							
						}
						if(joueur1.position == joueur2.position) {
							JOptionPane.showMessageDialog(null, "le joueur 2 a manger le joueur 1 le joueur 1 retourne a la case 0" , "J2 mange J1", JOptionPane.INFORMATION_MESSAGE);
							joueur2.position = 1;
						}
					 tour = false;
				 }
				desItem1.setEnabled(true);
			}
		});
		
		//// joueur2
		desItem1.setEnabled(false);
		desItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				desItem1.setEnabled(false);
				
				int valeurde = joueur2.lancerDe();
				int valeurde2 = joueur2.lancerDe();
				boolean tour = false;
				
				ImageIcon des = new ImageIcon("src/image/dice.png");
				JOptionPane.showMessageDialog(null, "des 1 : " + valeurde + " des 2 : " + valeurde2, "Lancer de des", JOptionPane.INFORMATION_MESSAGE  ,des);
				
				 if (joueur2.position != 0 && tour == false){
					
					Listbt.get(joueur2.position -1).setIcon(null);
				}
				 
				 if(tour == false) {
					 joueur2.jouerJeuDeLoie(joueur2.position, valeurde, valeurde2);
					 tour = true;
				 }
				 
				 if (tour == true) {
					 
					 if (joueur2.position == 6) {
							JOptionPane.showMessageDialog(null, "le pont", "le pont", JOptionPane.INFORMATION_MESSAGE);
							System.out.println(" le pont ");
						}
						if (joueur2.position == 19) {	
							JOptionPane.showMessageDialog(null, "l'hotel", "l'hotel", JOptionPane.INFORMATION_MESSAGE);
							System.out.println(" l'hotel ");
						}
						if (joueur2.position == 31) {
							JOptionPane.showMessageDialog(null, "le piege", "le piege", JOptionPane.INFORMATION_MESSAGE);
							System.out.println(" le piege ");
						}
						if (joueur2.position == 42) {
							JOptionPane.showMessageDialog(null, "le labyrinthe", "le labyrinthe", JOptionPane.INFORMATION_MESSAGE);
							System.out.println(" le labyrinthe ");
						}
						if (joueur2.position == 52) {
							JOptionPane.showMessageDialog(null, "le train", "le train", JOptionPane.INFORMATION_MESSAGE);
							System.out.println(" le train ");
						}
						if (joueur2.position == 58) {
							
							JOptionPane.showMessageDialog(null, "la mort", "la mort", JOptionPane.INFORMATION_MESSAGE);
							System.out.println(" la mort ");
						}
						
						joueur2.caseSurprises(joueur2.position);
						System.out.println(joueur2.position);
						if(joueur2.position !=0) {
							
							ImageIcon image = new ImageIcon("src/image/joueur2.png");
							Listbt.get(joueur2.position -1).setIcon(image);
							
						}
						if(joueur2.position == joueur1.position) {
							JOptionPane.showMessageDialog(null, "le joueur 2 a manger le joueur 1 le joueur 1 retourne a la case 0" , "J2 mange J1", JOptionPane.INFORMATION_MESSAGE);
							joueur1.position = 1;
						}
				 }
				desItem.setEnabled(true);
			}
		});
		//Recommencer
		menuItem1.setEnabled(false);
		menuItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int reply = JOptionPane.showConfirmDialog(null, "Veux-tu recommencer ?", "Nouvelle partie", JOptionPane.YES_NO_OPTION);
				
		        if (reply == JOptionPane.YES_OPTION) {
		        	
			        desItem.setEnabled(false);
					desItem1.setEnabled(false);
					menuItem.setEnabled(true);
					menuItem1.setEnabled(false);
					
					if(joueur1.position !=0 && joueur2.position !=0) {
						
						Listbt.get(joueur1.position -1).setIcon(null);
						Listbt.get(joueur2.position -1).setIcon(null);
						
						if (joueur2.position % 9 == 0 && joueur2.position != 0){
							
							ImageIcon image = new ImageIcon("src/image/oie1.gif");
							Listbt.get(joueur2.position -1).setIcon(image);
							
						}
						if(joueur1.position % 9 == 0 && joueur2.position != 0) {
							ImageIcon image = new ImageIcon("src/image/oie1.gif");
							Listbt.get(joueur1.position -1).setIcon(image);
						}
						
					}
						
						joueur1.position = 0;
						joueur2.position = 0;
					
		        }	
			}					
		});
	}
}