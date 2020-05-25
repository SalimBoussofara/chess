package cms_chess;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;

class ChessFenestraAmelioree extends JFrame implements MouseListener, KeyListener {
	public void sound(File path) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(path));
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Thread thread;
	String message;

	ImageIcon roiBlack = new ImageIcon(
			new ImageIcon("roiBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));

	ImageIcon reineBlack = new ImageIcon(
			new ImageIcon("reineBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));

	ImageIcon fouBlack = new ImageIcon(
			new ImageIcon("fouBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon fouBlack2 = new ImageIcon(
			new ImageIcon("fouBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));

	ImageIcon cavalierBlack = new ImageIcon(
			new ImageIcon("cavalierBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon cavalierBlack2 = new ImageIcon(
			new ImageIcon("cavalierBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));

	ImageIcon tourBlack = new ImageIcon(
			new ImageIcon("tourBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon tourBlack2 = new ImageIcon(
			new ImageIcon("tourBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));

	ImageIcon pionBlack1 = new ImageIcon(
			new ImageIcon("pionBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionBlack2 = new ImageIcon(
			new ImageIcon("pionBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionBlack3 = new ImageIcon(
			new ImageIcon("pionBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionBlack4 = new ImageIcon(
			new ImageIcon("pionBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionBlack5 = new ImageIcon(
			new ImageIcon("pionBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionBlack6 = new ImageIcon(
			new ImageIcon("pionBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionBlack7 = new ImageIcon(
			new ImageIcon("pionBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionBlack8 = new ImageIcon(
			new ImageIcon("pionBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));

	ImageIcon roiWhite = new ImageIcon(
			new ImageIcon("roiWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));

	ImageIcon reineWhite = new ImageIcon(
			new ImageIcon("reineWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));

	ImageIcon fouWhite = new ImageIcon(
			new ImageIcon("fouWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon fouWhite2 = new ImageIcon(
			new ImageIcon("fouWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));

	ImageIcon cavalierWhite = new ImageIcon(
			new ImageIcon("cavalierWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon cavalierWhite2 = new ImageIcon(
			new ImageIcon("cavalierWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));

	ImageIcon tourWhite = new ImageIcon(
			new ImageIcon("tourWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon tourWhite2 = new ImageIcon(
			new ImageIcon("tourWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));

	ImageIcon pionWhite1 = new ImageIcon(
			new ImageIcon("pionWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionWhite2 = new ImageIcon(
			new ImageIcon("pionWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionWhite3 = new ImageIcon(
			new ImageIcon("pionWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionWhite4 = new ImageIcon(
			new ImageIcon("pionWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionWhite5 = new ImageIcon(
			new ImageIcon("pionWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionWhite6 = new ImageIcon(
			new ImageIcon("pionWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionWhite7 = new ImageIcon(
			new ImageIcon("pionWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionWhite8 = new ImageIcon(
			new ImageIcon("pionWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon imageBougee;
	ImageIcon imageEffacee;
	JPanel pan = new JPanel();

	ImageIcon[] tabPiece = { roiWhite, reineWhite, fouWhite, fouWhite2, tourWhite, tourWhite2, cavalierWhite,
			cavalierWhite2, pionWhite1, pionWhite2, pionWhite3, pionWhite4, pionWhite5, pionWhite6, pionWhite7,
			pionWhite8, roiBlack, reineBlack, fouBlack, fouBlack2, tourBlack, tourBlack2, cavalierBlack, cavalierBlack2,
			pionBlack1, pionBlack2, pionBlack3, pionBlack4, pionBlack5, pionBlack6, pionBlack7, pionBlack8,
			imageEffacee, imageEffacee };

	/*
	 * roiWhite=0; reineWhite=1; fouWhite=2;fouWhite2=3; tourWhite=4;tourWhite2=5;
	 * cavalierWhite=6;cavalierWhite2=7; pionWhite: 8-->15;
	 * roiBlack=16;reineBlack=17; fouBlack=18,fouBlack2=19;
	 * tourWhite=20;tourWhite2=21; cavalierBlack=22;cavalierBlack=23; pionBlack:
	 * 24-->31; imageBougee=32
	 * 
	 */

	int[][] tabPos = new int[34][2];
	int width = 600 / 8;
	int height = 560 / 8;
	{
		tabPos[0][1] = height * 7 + 37;
		tabPos[0][0] = width * 4;
		tabPos[1][1] = height * 7 + 37;
		tabPos[1][0] = width * 3;
		tabPos[2][1] = height * 7 + 37;
		tabPos[2][0] = width * 2;
		tabPos[3][1] = height * 7 + 37;
		tabPos[3][0] = width * 5;
		tabPos[4][1] = height * 7 + 37;
		tabPos[4][0] = 0;
		tabPos[5][1] = height * 7 + 37;
		tabPos[5][0] = width * 7;
		tabPos[6][1] = height * 7 + 37;
		tabPos[6][0] = width * 6;
		tabPos[7][1] = height * 7 + 37;
		tabPos[7][0] = width;
		tabPos[8][0] = 0;
		tabPos[8][1] = height * 6 + 37;
		tabPos[9][0] = width;
		tabPos[9][1] = height * 6 + 37;
		tabPos[10][0] = width * 3;
		tabPos[10][1] = height * 6 + 37;
		tabPos[11][0] = width * 4;
		tabPos[11][1] = height * 6 + 37;
		tabPos[12][0] = width * 5;
		tabPos[12][1] = height * 6 + 37;
		tabPos[13][0] = width * 6;
		tabPos[13][1] = height * 6 + 37;
		tabPos[14][0] = width * 7;
		tabPos[14][1] = height * 6 + 37;
		tabPos[15][0] = width * 2;
		tabPos[15][1] = height * 6 + 37;
		tabPos[16][1] = 37;
		tabPos[16][0] = width * 4;
		tabPos[17][1] = 37;
		tabPos[17][0] = width * 3;
		tabPos[18][1] = 37;
		tabPos[18][0] = width * 2;
		tabPos[19][1] = 37;
		tabPos[19][0] = width * 5;
		tabPos[20][1] = 37;
		tabPos[20][0] = 0;
		tabPos[21][1] = 37;
		tabPos[21][0] = width * 7;
		tabPos[22][1] = 37;
		tabPos[22][0] = width * 6;
		tabPos[23][1] = 37;
		tabPos[23][0] = width;
		tabPos[24][0] = width * 1;
		tabPos[24][1] = height + 37;
		tabPos[25][0] = width * 2;
		tabPos[25][1] = height + 37;
		tabPos[26][0] = width * 3;
		tabPos[26][1] = height + 37;
		tabPos[27][0] = width * 4;
		tabPos[27][1] = height + 37;
		tabPos[28][0] = width * 5;
		tabPos[28][1] = height + 37;
		tabPos[29][0] = width * 6;
		tabPos[29][1] = height + 37;
		tabPos[30][0] = width * 7;
		tabPos[30][1] = height + 37;
		tabPos[31][0] = 0;
		tabPos[31][1] = height + 37;
	}

	ArrayList<String> listPos = new ArrayList<String>();
	int[][] tabPionTrans = new int[16][2];
	{
		for (int i = 0; i < 16; i++) {
			tabPionTrans[i][0] = 35;
			tabPionTrans[i][1] = 35;
		}
	}
	int indBougee;
	int posXRectEchec = 0, posYRectEchec = 0;
	Toolkit tkit=Toolkit.getDefaultToolkit();
	Dimension dimMoniteur=tkit.getScreenSize();
	
	public ChessFenestraAmelioree() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(dimMoniteur.width/2-600/2,dimMoniteur.height/2-610/2,600,610);
		setResizable(false);
		setVisible(true);
		addMouseListener(this);
		addKeyListener(this);
		add(pan,"East");
		
		setVisible(true);	
	}

	public void paint(Graphics g) {
		try {
			thread.sleep(10);
		}catch(InterruptedException exp ) {
		
		}
		super.paint(g);
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				if (j % 2 == 0 && i % 2 == 0 || j % 2 == 1 && i % 2 == 1) {
					g.setColor(Color.black);
				} else
					g.setColor(Color.white);
				g.fillRect(width * j, height * i + 37, width, height);
			}
		}
		for (int i = 0; i < 32; i++) {
			if (tabPos[i][0] < 700) {
				tabPiece[i].paintIcon(this, g, tabPos[i][0], tabPos[i][1]);
			}
		}

		((Graphics2D) g).setStroke(new BasicStroke(4.0f));
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 600, 37);
		g.fillRect(0, 0, 10, 600);
		g.fillRect(590, 0, 10, 600);
		g.fillRect(0, 595, 600, 15);
		g.drawLine(0, 37, 0, height * 8 + 37);
		g.drawLine(width, 37, width, height * 8 + 37);
		g.drawLine(width * 2, 37, width * 2, height * 8 + 37);
		g.drawLine(width * 3, 37, width * 3, height * 8 + 37);
		
		g.drawLine(width * 4, 37, width * 4, height * 8 + 37);
		g.drawLine(width * 5, 37, width * 5, height * 8 + 37);
		g.drawLine(width * 6, 37, width * 6, height * 8 + 37);
		g.drawLine(width * 7, 37, width * 7, height * 8 + 37);
		g.drawLine(0, 37 + height, width * 8, 37 + height);
		g.drawLine(0, 37 + height * 2, width * 8, 37 + height * 2);
		g.drawLine(0, 37 + height * 3, width * 8, 37 + height * 3);
		g.drawLine(0, 37 + height * 4, width * 8, 37 + height * 4);
		g.drawLine(0, 37 + height * 5, width * 8, 37 + height * 5);
		g.drawLine(0, 37 + height * 6, width * 8, 37 + height * 6);
		g.drawLine(0, 37 + height * 7, width * 8, 37 + height * 7);

		g.setColor(Color.blue);
		((Graphics2D) g).setStroke(new BasicStroke(5.0f));
		if (intBool == 1 || intBool == 3) {
			int[][] tabVerif = deplacementsVerifiees(indBougee);
			for (int i = 0; i < tabVerif.length; i++) {
				if (tabVerif[i][0] < 700) {
					if (indBougee == 0 && tabPos[0][0] == width * 4 && tabPos[0][1] == height * 7 + 37
							&& tabVerif[i][0] == width * 6) {
						g.setColor(Color.YELLOW);
						g.drawRect(width * 6, height * 7 + 37, width, height);
						g.setColor(Color.blue);
					} else if (indBougee == 16 && tabPos[16][0] == width * 4 && tabPos[16][1] == 37
							&& tabVerif[i][0] == width * 6) {
						g.setColor(Color.YELLOW);
						g.drawRect(width * 6, 37, width, height);
						g.setColor(Color.blue);
					} else
						g.drawRect(tabVerif[i][0], tabVerif[i][1], width, height);
				}
			}
		} else if (intBool == 0) {
			for (int i = 0; i < 16; i++) {
				if (tabPos[i][0] < 700 && deplacementsVerifiees(i).length > 0) {
					g.drawRect(tabPos[i][0], tabPos[i][1], width, height);
				}
			}
		} else {
			for (int i = 16; i < 32; i++) {
				if (tabPos[i][0] < 700 && deplacementsVerifiees(i).length > 0)
					g.drawRect(tabPos[i][0], tabPos[i][1], width, height);
			}
		}

		g.setColor(Color.red);
		if (posYRectEchec > 35)
			g.drawRect(posXRectEchec, posYRectEchec, width, height);
	}

	int intBool = 0;
	int l = 0;
	int indModif = 0;

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		double x = e.getX();
		double y = e.getY();
		boolean bool = true;
		if (message != "Les Blancs ont perdu" && message != "Les Noirs ont perdu") {
			if (intBool == 0) {
				int kx = ((int) Math.floor(x / width)) * width;
				int ky = ((int) Math.floor((y - 37) / height)) * height + 37;
				intBool = 1;
				bool = false;
				for (int i = 0; i < 16; i++) {
					if (kx == tabPos[i][0] && ky == tabPos[i][1]) {
						indBougee = i;
						bool = true;
					}
				}
				if (!bool || deplacementsVerifiees(indBougee).length == 0) {
					intBool = 0;
					System.out.println("Choisissez une pièce parmi celles en surbrillance");
					sound(new File("Warning.WAV"));
				}
				if (intBool == 1) {
					repaint();
				}
			}

			// ********************************************
			else if (intBool == 1) {

				intBool = 2;
				int kx = ((int) Math.floor(x / width)) * width;
				int ky = ((int) Math.floor((y - 37) / height)) * height + 37;
				if (!verifVerif(indBougee, kx, ky)) {
					intBool = 0;
					sound(new File("Warning.WAV"));
				} else {
					listPos.add(indBougee + "%" + tabPos[indBougee][0] + "#" + tabPos[indBougee][1]);
					if (indBougee == 0 && kx == width * 6 && tabPos[0][0] == width * 4) {
						tabPos[5][0] = width * 5;
					}
					tabPos[indBougee][0] = kx;
					tabPos[indBougee][1] = ky;

					int k = removeN(indBougee);
					if (tabPiece[32] != null) {
						listPos.set(listPos.size() - 1, listPos.get(listPos.size() - 1) + "+" + k);
					}
				}
				
				if (intBool == 2) {
					if (indBougee < 16 && indBougee >= 8) {
						if (ky == 37  && indModif==0) {
							pan.setLayout(new GridLayout(4,1));
							setBounds(dimMoniteur.width/2-800/2,dimMoniteur.height/2-610/2,800,610);
							pan.setBounds(700, 37, 100, height * 8);
							pan.setVisible(true);
							pan.setPreferredSize(new Dimension(100,height*4));
							JButton boutonReine = new JButton("Reine", reineWhite);
							pan.add(boutonReine);
							JButton boutonFou = new JButton("Fou", fouWhite);
							pan.add(boutonFou);
							JButton boutonTour = new JButton("Tour", tourWhite);
							pan.add(boutonTour);
							JButton boutonCavalier = new JButton("Cavalier", cavalierWhite);
							pan.add(boutonCavalier);
							
							//while(indModif==0) {
								
							boutonReine.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									indModif = 1;
								}
							});
							boutonFou.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									indModif = 2;
								}
							});
							boutonTour.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									indModif = 4;
								}
							});
							boutonCavalier.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									indModif = 6;
								}
							});
							//}
							//if(indModif!=0) {
							tabPiece[indBougee].setImage(tabPiece[indModif].getImage());
							tabPionTrans[l][0] = indBougee;
							tabPionTrans[l][1] = indModif;
							l++;
							//indModif=0;
							listPos.set(listPos.size() - 1, listPos.get(listPos.size() - 1) + "T");
							//}
						}
					}
					//setBounds(dimMoniteur.width/2-600/2,dimMoniteur.height/2-610/2,600,610);
					//pan.setVisible(false);
					if (echec(16)) {
						posXRectEchec = tabPos[16][0];
						posYRectEchec = tabPos[16][1];
					} else {
						posXRectEchec = 0;
						posYRectEchec = 0;
					}
				}
				repaint();
				if (echecMat(16) == true) {
					message = "Les Noirs ont perdu";
					sound(new File("tada.WAV"));
					dispose();
					new replayFenestra(message);
				}
			}

			// ***************************************************
			else if (intBool == 2) {
				int kx = ((int) Math.floor(x / width)) * width;
				int ky = ((int) Math.floor((y - 37) / height)) * height + 37;
				intBool = 3;
				bool = false;
				for (int i = 16; i < 32; i++) {
					if (kx == tabPos[i][0] && ky == tabPos[i][1]) {
						indBougee = i;
						bool = true;
					}
				}
				if (!bool || deplacementsVerifiees(indBougee).length == 0) {
					intBool = 2;
					System.out.println("Choisissez une pièce parmi celles en surbrillance");
					sound(new File("Warning.WAV"));
				}
				if (intBool == 3) {
					repaint();
				}
			}

			// ********************************************
			else if (intBool == 3) {

				intBool = 0;
				int kx = ((int) Math.floor(x / width)) * width;
				int ky = ((int) Math.floor((y - 37) / height)) * height + 37;
				if (!verifVerif(indBougee, kx, ky)) {
					intBool = 2;
					sound(new File("Warning.WAV"));
				} else {
					listPos.add(indBougee + "%" + tabPos[indBougee][0] + "#" + tabPos[indBougee][1]);
					if (indBougee == 16 && kx == width * 6 && tabPos[16][0] == width * 4) {
						tabPos[21][0] = width * 5;
					}
					tabPos[indBougee][0] = kx;
					tabPos[indBougee][1] = ky;
					int k = removeN(indBougee);
					if (tabPiece[32] != null) {
						listPos.set(listPos.size() - 1, listPos.get(listPos.size() - 1) + "+" + k);
					}
				}

				if (intBool == 0) {
					if (indBougee >= 24) {
						if (ky == height * 7 + 37) {
							/*
							 * int indModif; pan.setLayout(new FlowLayout()); pan.setVisible(true); JButton
							 * boutonReineBlack=new JButton("Reine", reineBlack); pan.add(boutonReineBlack);
							 * JButton boutonFouBlack=new JButton("Fou", fouBlack); pan.add(boutonFouBlack);
							 * JButton boutonTourBlack=new JButton("Tour",tourBlack);
							 * pan.add(boutonTourBlack); JButton boutonCavalierBlack=new JButton("Cavalier",
							 * cavalierBlack); pan.add(boutonCavalierBlack);
							 * boutonReineBlack.addActionListener(new ActionListener() {
							 * 
							 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
							 * method stub
							 * 
							 * } }); boutonFou.addActionListener(new ActionListener() {
							 * 
							 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
							 * method stub indModif=2; } }); boutonTour.addActionListener(new
							 * ActionListener() {
							 * 
							 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
							 * method stub indModif=4; } }); boutonCavalier.addActionListener(new
							 * ActionListener() {
							 * 
							 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
							 * method stub indModif=6; } });
							 */
							tabPiece[indBougee].setImage(tabPiece[17].getImage());
							tabPionTrans[l][0] = indBougee;
							tabPionTrans[l][1] = 17;
							// modifier quand on aura fait le panel
							l++;
							listPos.set(listPos.size() - 1, listPos.get(listPos.size() - 1) + "T");

						}
					}
					if (echec(0)) {
						posXRectEchec = tabPos[0][0];
						posYRectEchec = tabPos[0][1];
					} else {
						posXRectEchec = 0;
						posYRectEchec = 0;
					}
				}
				repaint();
				if (echecMat(0) == true) {
					message = "Les Noirs ont perdu";
					sound(new File("tada.WAV"));
					dispose();
					new replayFenestra(message);
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public boolean verifBlack(int x, int y) {
		for (int i = 16; i < 32; i++) {
			if (x == tabPos[i][0] && y == tabPos[i][1]) {
				return true;
			}
		}
		return false;
	}

	public boolean verifWhite(int x, int y) {
		for (int i = 0; i < 16; i++) {
			if (x == tabPos[i][0] && y == tabPos[i][1]) {
				return true;
			}
		}
		return false;
	}

	public boolean verifBlackAndWhite(int x, int y) {
		if (verifBlack(x, y) || verifWhite(x, y))
			return true;
		return false;
	}

	boolean boolRoiWhite = true;
	boolean boolRoiBlack = true;

	public int[][] deplacementsAutorises(int j) {
		int[][] tabAutor = new int[56][2];
		int x, y;
		x = tabPos[j][0];
		y = tabPos[j][1];
		int k = parcoursTabPionTrans(j);
		if (k < 16) {
			j = tabPionTrans[k][1];
		}
		// ********roi****
		if (j == 0 || j == 16) {
			tabAutor[0][0] = x + width + 9999;
			tabAutor[0][1] = y + 9999;
			tabAutor[1][0] = x - width + 9999;
			tabAutor[1][1] = y + 9999;
			tabAutor[2][0] = x + 9999;
			tabAutor[2][1] = y + 9999 - height;
			tabAutor[3][0] = x + width + 9999;
			tabAutor[3][1] = y + 9999 + height;
			tabAutor[4][0] = x + 9999;
			tabAutor[4][1] = y + 9999 + height;
			tabAutor[6][0] = x - width + 9999;
			tabAutor[6][1] = y + 9999 + height;
			tabAutor[5][0] = x + width + 9999;
			tabAutor[5][1] = y + 9999 - height;
			tabAutor[7][0] = x - width + 9999;
			tabAutor[7][1] = y + 9999 - height;
			if (j == 0) {
				if (boolRoiWhite) {
					boolRoiWhite = deplacementSpecialRoi(0);
					if (boolRoiWhite && !verifBlackAndWhite(width * 5, height * 7 + 37)
							&& !verifBlackAndWhite(width * 6, height * 7 + 37)) {
						tabAutor[8][0] = width * 6 + 9999;
						tabAutor[8][1] = 9999 + height * 7 + 37;
					}
				}
			} else {
				if (boolRoiBlack) {
					boolRoiBlack = deplacementSpecialRoi(16);
					if (boolRoiBlack && !verifBlackAndWhite(width * 5, 37) && !verifBlackAndWhite(width * 6, 37)) {
						tabAutor[8][0] = width * 6 + 9999;
						tabAutor[8][1] = 9999 + 37;
					}
				}
			}
		}

		// ***********reine************
		if (j == 1 || j == 17) {
			tabAutor[0][0] = x + 9999 + width;
			tabAutor[0][1] = y + 9999;
			if (!verifBlackAndWhite(x + width, y)) {
				tabAutor[1][0] = x + 9999 + width * 2;
				tabAutor[1][1] = y + 9999;
			}
			if (!verifBlackAndWhite(x + width * 2, y) && !verifBlackAndWhite(x + width, y)) {
				tabAutor[2][0] = x + 9999 + width * 3;
				tabAutor[2][1] = y + 9999;
			}
			if (!verifBlackAndWhite(x + width * 3, y) && !verifBlackAndWhite(x + width * 2, y)
					&& !verifBlackAndWhite(x + width, y)) {
				tabAutor[3][0] = x + 9999 + width * 4;
				tabAutor[3][1] = y + 9999;
			}
			if (!verifBlackAndWhite(x + width * 4, y) && !verifBlackAndWhite(x + width * 3, y)
					&& !verifBlackAndWhite(x + width * 2, y) && !verifBlackAndWhite(x + width, y)) {
				tabAutor[4][0] = x + 9999 + width * 5;
				tabAutor[4][1] = y + 9999;
			}
			if (!verifBlackAndWhite(x + width * 5, y) && !verifBlackAndWhite(x + width * 4, y)
					&& !verifBlackAndWhite(x + width * 3, y) && !verifBlackAndWhite(x + width * 2, y)
					&& !verifBlackAndWhite(x + width, y)) {
				tabAutor[5][0] = x + 9999 + width * 6;
				tabAutor[5][1] = y + 9999;
			}
			if (!verifBlackAndWhite(x + width * 6, y) && !verifBlackAndWhite(x + width * 5, y)
					&& !verifBlackAndWhite(x + width * 4, y) && !verifBlackAndWhite(x + width * 3, y)
					&& !verifBlackAndWhite(x + width * 2, y) && !verifBlackAndWhite(x + width, y)) {
				tabAutor[6][0] = x + 9999 + width * 7;
				tabAutor[6][1] = y + 9999;
			}

			tabAutor[13][0] = x + 9999 - width;
			tabAutor[13][1] = y + 9999;
			if (!verifBlackAndWhite(x - width, y)) {
				tabAutor[7][0] = x + 9999 - width * 2;
				tabAutor[7][1] = y + 9999;
			}
			if (!verifBlackAndWhite(x - width, y) && !verifBlackAndWhite(x - width * 2, y)) {
				tabAutor[8][0] = x + 9999 - width * 3;
				tabAutor[8][1] = y + 9999;
			}
			if (!verifBlackAndWhite(x - width, y) && !verifBlackAndWhite(x - width * 2, y)
					&& !verifBlackAndWhite(x - width * 3, y)) {
				tabAutor[9][0] = x + 9999 - width * 4;
				tabAutor[9][1] = y + 9999;
			}
			if (!verifBlackAndWhite(x - width, y) && !verifBlackAndWhite(x - width * 2, y)
					&& !verifBlackAndWhite(x - width * 3, y) && !verifBlackAndWhite(x - width * 4, y)) {
				tabAutor[10][0] = x + 9999 - width * 5;
				tabAutor[10][1] = y + 9999;
			}
			if (!verifBlackAndWhite(x - width, y) && !verifBlackAndWhite(x - width * 2, y)
					&& !verifBlackAndWhite(x - width * 3, y) && !verifBlackAndWhite(x - width * 4, y)
					&& !verifBlackAndWhite(x - width * 5, y)) {
				tabAutor[11][0] = x + 9999 - width * 6;
				tabAutor[11][1] = y + 9999;
			}
			if (!verifBlackAndWhite(x - width, y) && !verifBlackAndWhite(x - width * 2, y)
					&& !verifBlackAndWhite(x - width * 3, y) && !verifBlackAndWhite(x - width * 4, y)
					&& !verifBlackAndWhite(x - width * 5, y) && !verifBlackAndWhite(x - width * 6, y)) {
				tabAutor[12][0] = x + 9999 - width * 7;
				tabAutor[12][1] = y + 9999;
			}

			tabAutor[14][1] = y + 9999 + height;
			tabAutor[14][0] = x + 9999;
			if (!verifBlackAndWhite(x, y + height)) {
				tabAutor[27][1] = y + 9999 + height * 2;
				tabAutor[27][0] = x + 9999;
			}
			if (!verifBlackAndWhite(x, y + height) && !verifBlackAndWhite(x, y + height * 2)) {
				tabAutor[15][1] = y + 9999 + height * 3;
				tabAutor[15][0] = x + 9999;
			}
			if (!verifBlackAndWhite(x, y + height) && !verifBlackAndWhite(x, y + height * 2)
					&& !verifBlackAndWhite(x, y + height * 3)) {
				tabAutor[16][1] = y + 9999 + height * 4;
				tabAutor[16][0] = x + 9999;
			}
			if (!verifBlackAndWhite(x, y + height) && !verifBlackAndWhite(x, y + height * 2)
					&& !verifBlackAndWhite(x, y + height * 3) && !verifBlackAndWhite(x, y + height * 4)) {
				tabAutor[17][1] = y + 9999 + height * 5;
				tabAutor[17][0] = x + 9999;
			}
			if (!verifBlackAndWhite(x, y + height) && !verifBlackAndWhite(x, y + height * 2)
					&& !verifBlackAndWhite(x, y + height * 3) && !verifBlackAndWhite(x, y + height * 4)
					&& !verifBlackAndWhite(x, y + height * 5)) {
				tabAutor[18][1] = y + 9999 + height * 6;
				tabAutor[18][0] = x + 9999;
			}
			if (!verifBlackAndWhite(x, y + height) && !verifBlackAndWhite(x, y + height * 2)
					&& !verifBlackAndWhite(x, y + height * 3) && !verifBlackAndWhite(x, y + height * 4)
					&& !verifBlackAndWhite(x, y + height * 5) && !verifWhite(x, y + height * 6)) {
				tabAutor[19][1] = y + 9999 + height * 7;
				tabAutor[19][0] = x + 9999;
			}

			tabAutor[20][1] = y + 9999 - height;
			tabAutor[20][0] = x + 9999;
			if (!verifBlackAndWhite(x, y - height)) {
				tabAutor[21][1] = y + 9999 - height * 2;
				tabAutor[21][0] = x + 9999;
			}
			if (!verifBlackAndWhite(x, y - height) && !verifBlackAndWhite(x, y - height * 2)) {
				tabAutor[22][1] = y + 9999 - height * 3;
				tabAutor[22][0] = x + 9999;
			}
			if (!verifBlackAndWhite(x, y - height) && !verifBlackAndWhite(x, y - height * 2)
					&& !verifBlackAndWhite(x, y - height * 3)) {
				tabAutor[23][1] = y + 9999 - height * 4;
				tabAutor[23][0] = x + 9999;
			}
			if (!verifBlackAndWhite(x, y - height) && !verifBlackAndWhite(x, y - height * 2)
					&& !verifBlackAndWhite(x, y - height * 3) && !verifBlackAndWhite(x, y - height * 4)) {
				tabAutor[24][1] = y + 9999 - 5 * height;
				tabAutor[24][0] = x + 9999;
			}
			if (!verifBlackAndWhite(x, y - height) && !verifBlackAndWhite(x, y - height * 2)
					&& !verifBlackAndWhite(x, y - height * 3) && !verifBlackAndWhite(x, y - height * 4)
					&& !verifBlackAndWhite(x, y - height * 5)) {
				tabAutor[25][1] = y + 9999 - 6 * height;
				tabAutor[25][0] = x + 9999;
			}
			if (!verifBlackAndWhite(x, y - height) && !verifBlackAndWhite(x, y - height * 2)
					&& !verifBlackAndWhite(x, y - height * 3) && !verifBlackAndWhite(x, y - height * 4)
					&& !verifBlackAndWhite(x, y - height * 5) && !verifBlackAndWhite(x, y - height * 6)) {
				tabAutor[26][1] = y + 9999 - height * 7;
				tabAutor[26][0] = x + 9999;
			}

			tabAutor[28][0] = x + 9999 + width;
			tabAutor[28][1] = y + 9999 + height;
			if (!verifBlackAndWhite(x + width, y + height)) {
				tabAutor[29][0] = x + 9999 + width * 2;
				tabAutor[29][1] = y + 9999 + height * 2;
			}
			if (!verifBlackAndWhite(x + width, y + height) && !verifBlackAndWhite(x + width * 2, y + height * 2)) {
				tabAutor[30][0] = x + 9999 + width * 3;
				tabAutor[30][1] = y + 9999 + height * 3;
			}
			if (!verifBlackAndWhite(x + width, y + height) && !verifBlackAndWhite(x + width * 2, y + height * 2)
					&& !verifBlackAndWhite(x + width * 3, y + height * 3)) {
				tabAutor[31][0] = x + 9999 + width * 4;
				tabAutor[31][1] = y + 9999 + 4 * height;
			}
			if (!verifBlackAndWhite(x + width, y + height) && !verifBlackAndWhite(x + width * 2, y + height * 2)
					&& !verifBlackAndWhite(x + width * 3, y + height * 3)
					&& !verifBlackAndWhite(x + width * 4, y + height * 4)) {
				tabAutor[32][0] = x + 9999 + width * 5;
				tabAutor[32][1] = y + 9999 + height * 5;
			}

			if (!verifBlackAndWhite(x + width, y + height) && !verifBlackAndWhite(x + width * 2, y + height * 2)
					&& !verifBlackAndWhite(x + width * 3, y + height * 3)
					&& !verifBlackAndWhite(x + width * 4, y + height * 4)
					&& !verifWhite(x + width * 5, y + height * 5)) {
				tabAutor[33][0] = x + 9999 + width * 6;
				tabAutor[33][1] = y + 9999 + height * 6;
			}
			if (!verifBlackAndWhite(x + width, y + height) && !verifBlackAndWhite(x + width * 2, y + height * 2)
					&& !verifBlackAndWhite(x + width * 3, y + height * 3)
					&& !verifBlackAndWhite(x + width * 4, y + height * 4) && !verifWhite(x + width * 5, y + height * 5)
					&& !verifWhite(x + width * 6, y + height * 6)) {
				tabAutor[34][0] = x + 9999 + width * 7;
				tabAutor[34][1] = y + 9999 + height * 7;
			}

			tabAutor[35][0] = x + 9999 - width;
			tabAutor[35][1] = y + 9999 + height;

			if (!verifBlackAndWhite(x - width, y + height)) {
				tabAutor[36][0] = x + 9999 - width * 2;
				tabAutor[36][1] = y + 9999 + height * 2;
			}
			if (!verifBlackAndWhite(x - width, y + height) && !verifWhite(x - width * 2, y + height * 2)) {
				tabAutor[37][0] = x + 9999 - width * 3;
				tabAutor[37][1] = y + 9999 + height * 3;
			}
			if (!verifBlackAndWhite(x - width, y + height) && !verifWhite(x - width * 2, y + height * 2)
					&& !verifBlackAndWhite(x - width * 3, y + height * 3)) {
				tabAutor[38][0] = x + 9999 - width * 4;
				tabAutor[38][1] = y + 9999 + 4 * height;
			}
			if (!verifBlackAndWhite(x - width, y + height) && !verifWhite(x - width * 2, y + height * 2)
					&& !verifBlackAndWhite(x - width * 3, y + height * 3)
					&& !verifBlackAndWhite(x - width * 4, y + height * 4)) {
				tabAutor[39][0] = x + 9999 - width * 5;
				tabAutor[39][1] = y + 9999 + height * 5;
			}
			if (!verifBlackAndWhite(x - width, y + height) && !verifWhite(x - width * 2, y + height * 2)
					&& !verifBlackAndWhite(x - width * 3, y + height * 3)
					&& !verifBlackAndWhite(x - width * 4, y + height * 4)
					&& !verifBlackAndWhite(x - width * 5, y + height * 5)) {
				tabAutor[40][0] = x - width * 6;
				tabAutor[40][1] = y + 9999 + height * 6;
			}
			if (!verifBlackAndWhite(x - width, y + height) && !verifWhite(x - width * 2, y + height * 2)
					&& !verifBlackAndWhite(x - width * 3, y + height * 3)
					&& !verifBlackAndWhite(x - width * 4, y + height * 4)
					&& !verifBlackAndWhite(x - width * 5, y + height * 5)
					&& !verifBlackAndWhite(x - width * 6, y + height * 6)) {
				tabAutor[41][0] = x + 9999 - width * 7;
				tabAutor[41][1] = y + 9999 + height * 7;
			}

			tabAutor[42][0] = x + 9999 + width;
			tabAutor[42][1] = y + 9999 - height;

			if (!verifBlackAndWhite(x + width, y - height)) {
				tabAutor[43][0] = x + 9999 + width * 2;
				tabAutor[43][1] = y + 9999 - height * 2;
			}
			if (!verifBlackAndWhite(x + width, y - height) && !verifBlackAndWhite(x + width * 2, y - height * 2)) {
				tabAutor[44][0] = x + 9999 + width * 3;
				tabAutor[44][1] = y + 9999 - height * 3;
			}
			if (!verifBlackAndWhite(x + width, y - height) && !verifBlackAndWhite(x + width * 2, y - height * 2)
					&& !verifBlackAndWhite(x + width * 3, y - height * 3)) {
				tabAutor[45][0] = x + 9999 + width * 4;
				tabAutor[45][1] = y + 9999 - 4 * height;
			}
			if (!verifBlackAndWhite(x + width, y - height) && !verifBlackAndWhite(x + width * 2, y - height * 2)
					&& !verifBlackAndWhite(x + width * 3, y - height * 3)
					&& !verifBlackAndWhite(x + width * 4, y - height * 4)) {
				tabAutor[46][0] = x + 9999 + width * 5;
				tabAutor[46][1] = y + 9999 - height * 5;
			}
			if (!verifBlackAndWhite(x + width, y - height) && !verifBlackAndWhite(x + width * 2, y - height * 2)
					&& !verifBlackAndWhite(x + width * 3, y - height * 3)
					&& !verifBlackAndWhite(x + width * 4, y - height * 4)
					&& !verifBlackAndWhite(x + width * 5, y - height * 5)) {
				tabAutor[47][0] = x + 9999 + width * 6;
				tabAutor[47][1] = y + 9999 - height * 6;
			}
			if (!verifBlackAndWhite(x + width, y - height) && !verifBlackAndWhite(x + width * 2, y - height * 2)
					&& !verifBlackAndWhite(x + width * 3, y - height * 3)
					&& !verifBlackAndWhite(x + width * 4, y - height * 4)
					&& !verifBlackAndWhite(x + width * 5, y - height * 5)
					&& !verifBlackAndWhite(x + width * 6, y - height * 6)) {
				tabAutor[48][0] = x + 9999 + width * 7;
				tabAutor[48][1] = y - height * 7;
			}

			tabAutor[49][0] = x + 9999 - width;
			tabAutor[49][1] = y + 9999 - height;

			if (!verifBlackAndWhite(x - width, y - height)) {
				tabAutor[50][0] = x + 9999 - width * 2;
				tabAutor[50][1] = y + 9999 - height * 2;
			}
			if (!verifBlackAndWhite(x - width, y - height) && !verifBlackAndWhite(x - width * 2, y - height * 2)) {
				tabAutor[51][0] = x + 9999 - width * 3;
				;
				tabAutor[51][1] = y + 9999 - height * 3;
			}
			if (!verifBlackAndWhite(x - width, y - height) && !verifBlackAndWhite(x - width * 2, y - height * 2)
					&& !verifBlackAndWhite(x - width * 3, y - height * 3)) {
				tabAutor[52][0] = x + 9999 - width * 4;
				;
				tabAutor[52][1] = y + 9999 - height * 4;
			}
			if (!verifBlackAndWhite(x - width, y - height) && !verifBlackAndWhite(x - width * 2, y - height * 2)
					&& !verifBlackAndWhite(x - width * 3, y - height * 3)
					&& !verifBlackAndWhite(x - width * 4, y - height * 4)) {
				tabAutor[53][0] = x + 9999 - width * 5;
				;
				tabAutor[53][1] = y + 9999 - height * 5;
			}
			if (!verifBlackAndWhite(x - width, y - height) && !verifBlackAndWhite(x - width * 2, y - height * 2)
					&& !verifBlackAndWhite(x - width * 3, y - height * 3)
					&& !verifBlackAndWhite(x - width * 4, y - height * 4)
					&& !verifBlackAndWhite(x - width * 5, y - height * 5)) {
				tabAutor[54][0] = x + 9999 - width * 6;
				tabAutor[54][1] = y + 9999 - height * 6;
			}
			if (!verifBlackAndWhite(x - width, y - height) && !verifBlackAndWhite(x - width * 2, y - height * 2)
					&& !verifBlackAndWhite(x - width * 3, y - height * 3)
					&& !verifBlackAndWhite(x - width * 4, y - height * 4)
					&& !verifBlackAndWhite(x - width * 5, y - height * 5)
					&& !verifWhite(x - width * 6, y - height * 6)) {
				tabAutor[55][0] = x + 9999 - width * 7;
				tabAutor[55][1] = y + 9999 - height * 7;
			}
		}

		// ********fouWhite******************
		if (j == 2 || j == 3 || j == 18 || j == 19) {
			tabAutor[0][0] = x + 9999 + width;
			tabAutor[0][1] = y + 9999 + height;
			if (!verifBlackAndWhite(x + width, y + height)) {
				tabAutor[1][0] = x + 9999 + width * 2;
				tabAutor[1][1] = y + 9999 + height * 2;
			}

			if (!verifBlackAndWhite(x + width, y + height) && !verifBlackAndWhite(x + width * 2, y + height * 2)) {
				tabAutor[2][0] = x + 9999 + width * 3;
				tabAutor[2][1] = y + 9999 + height * 3;
			}
			if (!verifBlackAndWhite(x + width, y + height) && !verifBlackAndWhite(x + width * 2, y + height * 2)
					&& !verifBlackAndWhite(x + width * 3, y + height * 3)) {
				tabAutor[3][0] = x + 9999 + width * 4;
				tabAutor[3][1] = y + 9999 + 4 * height;
			}
			if (!verifBlackAndWhite(x + width, y + height) && !verifBlackAndWhite(x + width * 2, y + height * 2)
					&& !verifBlackAndWhite(x + width * 3, y + height * 3)
					&& !verifBlackAndWhite(x + width * 4, y + height * 4)) {
				tabAutor[4][0] = x + 9999 + width * 5;
				tabAutor[4][1] = y + 9999 + height * 5;
			}

			if (!verifBlackAndWhite(x + width, y + height) && !verifBlackAndWhite(x + width * 2, y + height * 2)
					&& !verifBlackAndWhite(x + width * 3, y + height * 3)
					&& !verifBlackAndWhite(x + width * 4, y + height * 4)
					&& !verifWhite(x + width * 5, y + height * 5)) {
				tabAutor[5][0] = x + 9999 + width * 6;
				tabAutor[5][1] = y + 9999 + height * 6;
			}
			if (!verifBlackAndWhite(x + width, y + height) && !verifBlackAndWhite(x + width * 2, y + height * 2)
					&& !verifBlackAndWhite(x + width * 3, y + height * 3)
					&& !verifBlackAndWhite(x + width * 4, y + height * 4) && !verifWhite(x + width * 5, y + height * 5)
					&& !verifWhite(x + width * 6, y + height * 6)) {
				tabAutor[6][0] = x + 9999 + width * 7;
				tabAutor[6][1] = y + 9999 + height * 7;
			}

			tabAutor[7][0] = x + 9999 - width;
			tabAutor[7][1] = y + 9999 + height;

			if (!verifBlackAndWhite(x - width, y + height)) {
				tabAutor[8][0] = x + 9999 - width * 2;
				tabAutor[8][1] = y + 9999 + height * 2;
			}

			if (!verifBlackAndWhite(x - width, y + height) && !verifWhite(x - width * 2, y + height * 2)) {
				tabAutor[9][0] = x + 9999 - width * 3;
				tabAutor[9][1] = y + 9999 + height * 3;
			}

			if (!verifBlackAndWhite(x - width, y + height) && !verifWhite(x - width * 2, y + height * 2)
					&& !verifBlackAndWhite(x - width * 3, y + height * 3)) {
				tabAutor[10][0] = x + 9999 - width * 4;
				tabAutor[10][1] = y + 9999 + 4 * height;
			}
			if (!verifBlackAndWhite(x - width, y + height) && !verifWhite(x - width * 2, y + height * 2)
					&& !verifBlackAndWhite(x - width * 3, y + height * 3)
					&& !verifBlackAndWhite(x - width * 4, y + height * 4)) {
				tabAutor[11][0] = x + 9999 - width * 5;
				tabAutor[11][1] = y + 9999 + height * 5;
			}
			if (!verifBlackAndWhite(x - width, y + height) && !verifWhite(x - width * 2, y + height * 2)
					&& !verifBlackAndWhite(x - width * 3, y + height * 3)
					&& !verifBlackAndWhite(x - width * 4, y + height * 4)
					&& !verifBlackAndWhite(x - width * 5, y + height * 5)) {
				tabAutor[13][0] = x + 9999 - width * 7;
				tabAutor[13][1] = y + 9999 + height * 6;
			}
			if (!verifBlackAndWhite(x - width, y + height) && !verifWhite(x - width * 2, y + height * 2)
					&& !verifBlackAndWhite(x - width * 3, y + height * 3)
					&& !verifBlackAndWhite(x - width * 4, y + height * 4)
					&& !verifBlackAndWhite(x - width * 5, y + height * 5)
					&& !verifBlackAndWhite(x - width * 6, y + height * 6)) {
				tabAutor[13][0] = x + 9999 - width * 7;
				tabAutor[13][1] = y + 9999 + height * 7;
			}

			tabAutor[14][0] = x + 9999 + width;
			tabAutor[14][1] = y + 9999 - height;

			if (!verifBlackAndWhite(x + width, y - height)) {
				tabAutor[15][0] = x + 9999 + width * 2;
				tabAutor[15][1] = y + 9999 - height * 2;
			}
			if (!verifBlackAndWhite(x + width, y - height) && !verifBlackAndWhite(x + width * 2, y - height * 2)) {
				tabAutor[16][0] = x + 9999 + width * 3;
				tabAutor[16][1] = y + 9999 - height * 3;
			}
			if (!verifBlackAndWhite(x + width, y - height) && !verifBlackAndWhite(x + width * 2, y - height * 2)
					&& !verifBlackAndWhite(x + width * 3, y - height * 3)) {
				tabAutor[17][0] = x + 9999 + width * 4;
				tabAutor[17][1] = y + 9999 - 4 * height;
			}
			if (!verifBlackAndWhite(x + width, y - height) && !verifBlackAndWhite(x + width * 2, y - height * 2)
					&& !verifBlackAndWhite(x + width * 3, y - height * 3)
					&& !verifBlackAndWhite(x + width * 4, y - height * 4)) {
				tabAutor[18][0] = x + 9999 + width * 5;
				tabAutor[18][1] = y + 9999 - height * 5;
			}
			if (!verifBlackAndWhite(x + width, y - height) && !verifBlackAndWhite(x + width * 2, y - height * 2)
					&& !verifBlackAndWhite(x + width * 3, y - height * 3)
					&& !verifBlackAndWhite(x + width * 4, y - height * 4)
					&& !verifBlackAndWhite(x + width * 5, y - height * 5)) {
				tabAutor[19][0] = x + 9999 + width * 6;
				tabAutor[19][1] = y + 9999 - height * 6;
			}
			if (!verifBlackAndWhite(x + width, y - height) && !verifBlackAndWhite(x + width * 2, y - height * 2)
					&& !verifBlackAndWhite(x + width * 3, y - height * 3)
					&& !verifBlackAndWhite(x + width * 4, y - height * 4)
					&& !verifBlackAndWhite(x + width * 5, y - height * 5)
					&& !verifBlackAndWhite(x + width * 6, y - height * 6)) {
				tabAutor[20][0] = x + 9999 + width * 7;
				tabAutor[20][1] = y + 9999 + 9999 - height * 7;
			}

			tabAutor[21][0] = x + 9999 - width;
			tabAutor[21][1] = y + 9999 - height;

			if (!verifBlackAndWhite(x - width, y - height)) {
				tabAutor[22][0] = x + 9999 - width * 2;
				tabAutor[22][1] = y + 9999 - height * 2;
			}
			if (!verifBlackAndWhite(x - width, y - height) && !verifBlackAndWhite(x - width * 2, y - height * 2)) {
				tabAutor[23][0] = x + 9999 - width * 3;
				;
				tabAutor[23][1] = y + 9999 - height * 3;
			}
			if (!verifBlackAndWhite(x - width, y - height) && !verifBlackAndWhite(x - width * 2, y - height * 2)
					&& !verifBlackAndWhite(x - width * 3, y - height * 3)) {
				tabAutor[24][0] = x + 9999 - width * 4;
				;
				tabAutor[24][1] = y + 9999 - height * 4;
			}
			if (!verifBlackAndWhite(x - width, y - height) && !verifBlackAndWhite(x - width * 2, y - height * 2)
					&& !verifBlackAndWhite(x - width * 3, y - height * 3)
					&& !verifBlackAndWhite(x - width * 4, y - height * 4)) {
				tabAutor[25][0] = x + 9999 - width * 5;
				;
				tabAutor[25][1] = y + 9999 - height * 5;
			}
			if (!verifBlackAndWhite(x - width, y - height) && !verifBlackAndWhite(x - width * 2, y - height * 2)
					&& !verifBlackAndWhite(x - width * 3, y - height * 3)
					&& !verifBlackAndWhite(x - width * 4, y - height * 4)
					&& !verifBlackAndWhite(x - width * 5, y - height * 5)) {
				tabAutor[26][0] = x + 9999 - height * 6;
				tabAutor[26][1] = y + 9999 - height * 6;
			}
			if (!verifBlackAndWhite(x - width, y - height) && !verifBlackAndWhite(x - width * 2, y - height * 2)
					&& !verifBlackAndWhite(x - width * 3, y - height * 3)
					&& !verifBlackAndWhite(x - width * 4, y - height * 4)
					&& !verifBlackAndWhite(x - width * 5, y - height * 5)
					&& !verifWhite(x - width * 6, y - height * 6)) {
				tabAutor[27][0] = x + 9999 - width * 7;
				tabAutor[27][1] = y + 9999 - height * 7;
			}
		}

		// ****************tour**************
		if (j == 4 || j == 5 || j == 20 || j == 21) {
			tabAutor[0][0] = x + 9999 + width;
			tabAutor[0][1] = y + 9999;
			if (!verifBlackAndWhite(x + width, y)) {
				tabAutor[1][0] = x + 9999 + width * 2;
				tabAutor[1][1] = y + 9999;
			}
			if (!verifBlackAndWhite(x + width * 2, y) && !verifBlackAndWhite(x + width, y)) {
				tabAutor[2][0] = x + 9999 + width * 3;
				tabAutor[2][1] = y + 9999;
			}
			if (!verifBlackAndWhite(x + width * 3, y) && !verifBlackAndWhite(x + width * 2, y)
					&& !verifBlackAndWhite(x + width, y)) {
				tabAutor[3][0] = x + 9999 + width * 4;
				tabAutor[3][1] = y + 9999;
			}
			if (!verifBlackAndWhite(x + width * 4, y) && !verifBlackAndWhite(x + width * 3, y)
					&& !verifBlackAndWhite(x + width * 2, y) && !verifBlackAndWhite(x + width, y)) {
				tabAutor[4][0] = x + 9999 + width * 5;
				tabAutor[4][1] = y + 9999;
			}
			if (!verifBlackAndWhite(x + width * 5, y) && !verifBlackAndWhite(x + width * 4, y)
					&& !verifBlackAndWhite(x + width * 3, y) && !verifBlackAndWhite(x + width * 2, y)
					&& !verifBlackAndWhite(x + width, y)) {
				tabAutor[5][0] = x + 9999 + width * 6;
				tabAutor[5][1] = y + 9999;
			}
			if (!verifBlackAndWhite(x + width * 6, y) && !verifBlackAndWhite(x + width * 5, y)
					&& !verifBlackAndWhite(x + width * 4, y) && !verifBlackAndWhite(x + width * 3, y)
					&& !verifBlackAndWhite(x + width * 2, y) && !verifBlackAndWhite(x + width, y)) {
				tabAutor[6][0] = x + 9999 + width * 7;
				tabAutor[6][1] = y + 9999;
			}

			tabAutor[13][0] = x + 9999 - width;
			tabAutor[13][1] = y + 9999;
			if (!verifBlackAndWhite(x - width, y)) {
				tabAutor[7][0] = x + 9999 - width * 2;
				tabAutor[7][1] = y + 9999;
			}
			if (!verifBlackAndWhite(x - width, y) && !verifBlackAndWhite(x - width * 2, y)) {
				tabAutor[8][0] = x + 9999 - width * 3;
				tabAutor[8][1] = y + 9999;
			}
			if (!verifBlackAndWhite(x - width, y) && !verifBlackAndWhite(x - width * 2, y)
					&& !verifBlackAndWhite(x - width * 3, y)) {
				tabAutor[9][0] = x + 9999 - width * 4;
				tabAutor[9][1] = y + 9999;
			}
			if (!verifBlackAndWhite(x - width, y) && !verifBlackAndWhite(x - width * 2, y)
					&& !verifBlackAndWhite(x - width * 3, y) && !verifBlackAndWhite(x - width * 4, y)) {
				tabAutor[10][0] = x + 9999 - width * 5;
				tabAutor[10][1] = y + 9999;
			}
			if (!verifBlackAndWhite(x - width, y) && !verifBlackAndWhite(x - width * 2, y)
					&& !verifBlackAndWhite(x - width * 3, y) && !verifBlackAndWhite(x - width * 4, y)
					&& !verifBlackAndWhite(x - width * 5, y)) {
				tabAutor[11][0] = x + 9999 - width * 6;
				tabAutor[11][1] = y + 9999;
			}
			if (!verifBlackAndWhite(x - width, y) && !verifBlackAndWhite(x - width * 2, y)
					&& !verifBlackAndWhite(x - width * 3, y) && !verifBlackAndWhite(x - width * 4, y)
					&& !verifBlackAndWhite(x - width * 5, y) && !verifBlackAndWhite(x - width * 6, y)) {
				tabAutor[12][0] = x + 9999 - width * 7;
				tabAutor[12][1] = y + 9999;
			}

			tabAutor[14][1] = y + 9999 + height;
			tabAutor[14][0] = x + 9999;
			if (!verifBlackAndWhite(x, y + height)) {
				tabAutor[27][1] = y + 9999 + height * 2;
				tabAutor[27][0] = x + 9999;
			}
			if (!verifBlackAndWhite(x, y + height) && !verifBlackAndWhite(x, y + height * 2)) {
				tabAutor[15][1] = y + 9999 + height * 3;
				tabAutor[15][0] = x + 9999;
			}
			if (!verifBlackAndWhite(x, y + height) && !verifBlackAndWhite(x, y + height * 2)
					&& !verifBlackAndWhite(x, y + height * 3)) {
				tabAutor[16][1] = y + 9999 + height * 4;
				tabAutor[16][0] = x + 9999;
			}
			if (!verifBlackAndWhite(x, y + height) && !verifBlackAndWhite(x, y + height * 2)
					&& !verifBlackAndWhite(x, y + height * 3) && !verifBlackAndWhite(x, y + height * 4)) {
				tabAutor[17][1] = y + 9999 + height * 5;
				tabAutor[17][0] = x + 9999;
			}
			if (!verifBlackAndWhite(x, y + height) && !verifBlackAndWhite(x, y + height * 2)
					&& !verifBlackAndWhite(x, y + height * 3) && !verifBlackAndWhite(x, y + height * 4)
					&& !verifBlackAndWhite(x, y + height * 5)) {
				tabAutor[18][1] = y + 9999 + height * 6;
				tabAutor[18][0] = x + 9999;
			}
			if (!verifBlackAndWhite(x, y + height) && !verifBlackAndWhite(x, y + height * 2)
					&& !verifBlackAndWhite(x, y + height * 3) && !verifBlackAndWhite(x, y + height * 4)
					&& !verifBlackAndWhite(x, y + height * 5) && !verifBlackAndWhite(x, y + height * 6)) {
				tabAutor[19][1] = y + 9999 + height * 7;
				tabAutor[19][0] = x + 9999;
			}

			tabAutor[20][1] = y + 9999 - height;
			tabAutor[20][0] = x + 9999;
			if (!verifBlackAndWhite(x, y - height)) {
				tabAutor[21][1] = y + 9999 - height * 2;
				tabAutor[21][0] = x + 9999;
			}
			if (!verifBlackAndWhite(x, y - height) && !verifBlackAndWhite(x, y - height * 2)) {
				tabAutor[22][1] = y + 9999 - height * 3;
				tabAutor[22][0] = x + 9999;
			}
			if (!verifBlackAndWhite(x, y - height) && !verifBlackAndWhite(x, y - height * 2)
					&& !verifBlackAndWhite(x, y - height * 3)) {
				tabAutor[23][1] = y + 9999 - height * 4;
				tabAutor[23][0] = x + 9999;
			}
			if (!verifBlackAndWhite(x, y - height) && !verifBlackAndWhite(x, y - height * 2)
					&& !verifBlackAndWhite(x, y - height * 3) && !verifBlackAndWhite(x, y - height * 4)) {
				tabAutor[4][1] = y + 9999 - 5 * height;
				tabAutor[4][0] = x + 9999;
			}
			if (!verifBlackAndWhite(x, y - height) && !verifBlackAndWhite(x, y - height * 2)
					&& !verifBlackAndWhite(x, y - height * 3) && !verifBlackAndWhite(x, y - height * 4)
					&& !verifBlackAndWhite(x, y - height * 5)) {
				tabAutor[25][1] = y + 9999 - 6 * height;
				tabAutor[25][0] = x + 9999;
			}
			if (!verifBlackAndWhite(x, y - height) && !verifBlackAndWhite(x, y - height * 2)
					&& !verifBlackAndWhite(x, y - height * 3) && !verifBlackAndWhite(x, y - height * 4)
					&& !verifBlackAndWhite(x, y - height * 5) && !verifBlackAndWhite(x, y - height * 6)) {
				tabAutor[26][1] = y + 9999 - height * 7;
				tabAutor[26][0] = x + 9999;
			}
		}
		// ******************cavalier*********
		if (j == 6 || j == 7 || j == 22 || j == 23) {
			tabAutor[0][0] = x + 9999 + 2 * width;
			tabAutor[0][1] = y + 9999 + height;
			tabAutor[1][0] = x + 9999 + 2 * width;
			tabAutor[1][1] = y + 9999 - height;
			tabAutor[2][0] = x + 9999 - 2 * width;
			tabAutor[2][1] = y + 9999 + height;
			tabAutor[3][0] = x + 9999 - 2 * width;
			tabAutor[3][1] = y + 9999 - height;
			tabAutor[4][0] = x + 9999 + width;
			tabAutor[4][1] = y + 9999 + 2 * height;
			tabAutor[5][0] = x + 9999 + width;
			tabAutor[5][1] = y + 9999 - 2 * height;
			tabAutor[6][0] = x + 9999 - width;
			tabAutor[6][1] = y + 9999 + 2 * height;
			tabAutor[7][0] = x + 9999 - width;
			tabAutor[7][1] = y + 9999 - 2 * height;
		}

		if (j == 8 || j == 9 || j == 10 || j == 11 || j == 12 || j == 13 || j == 14 || j == 15) {
			if (y == height * 6 + 37 && !verifBlackAndWhite(x, y - height * 2) && !verifBlackAndWhite(x, y - height)) {
				tabAutor[0][1] = y + 9999 - height * 2;
				tabAutor[0][0] = x + 9999;
			}
			if (!verifBlackAndWhite(x, y - height)) {
				tabAutor[1][1] = y + 9999 - height;
				tabAutor[1][0] = x + 9999;
			}
			if (verifBlack(x + width, y - height)) {
				tabAutor[2][0] = x + 9999 + width;
				tabAutor[2][1] = y + 9999 - height;
			}
			if (verifBlack(x - width, y - height)) {
				tabAutor[3][0] = x + 9999 - width;
				tabAutor[3][1] = y + 9999 - height;
			}
		}
		if (j == 24 || j == 25 || j == 26 || j == 27 || j == 28 || j == 29 || j == 30 || j == 31) {
			if (y == height + 37 && !verifBlackAndWhite(x, y + height * 2) && !verifBlackAndWhite(x, y + height)) {
				tabAutor[0][1] = y + 9999 + height * 2;
				tabAutor[0][0] = x + 9999;
			}
			if (!verifBlackAndWhite(x, y + height)) {
				tabAutor[1][1] = y + 9999 + height;
				tabAutor[1][0] = x + 9999;
			}
			if (verifWhite(x + width, y + height)) {
				tabAutor[2][0] = x + 9999 + width;
				tabAutor[2][1] = y + 9999 + height;
			}
			if (verifWhite(x - width, y + height)) {
				tabAutor[3][0] = x + 9999 - width;
				tabAutor[3][1] = y + 9999 + height;
			}
		}
		if (j < 16) {
			for (int i = 0; i < 56; i++) {
				if (tabAutor[i][0] >= 9999 && tabAutor[i][1] >= 9999) {
					tabAutor[i][0] -= 9999;
					tabAutor[i][1] -= 9999;
				} else {
					tabAutor[i][0] = 2000;
					tabAutor[i][1] = 2000;
				}
				if (verifWhite(tabAutor[i][0], tabAutor[i][1]) || tabAutor[i][0] > width * 7 || tabAutor[i][0] < 0
						|| tabAutor[i][1] > height * 7 + 37 || tabAutor[i][1] < 37) {
					tabAutor[i][0] = 2000;
					tabAutor[i][1] = 2000;
				}
			}
		} else if (j < 32) {
			for (int i = 0; i < 56; i++) {
				if (tabAutor[i][0] >= 9999 && tabAutor[i][1] >= 9999) {
					tabAutor[i][0] -= 9999;
					tabAutor[i][1] -= 9999;
				} else {
					tabAutor[i][0] = 2000;
					tabAutor[i][1] = 2000;
				}
				if (verifBlack(tabAutor[i][0], tabAutor[i][1]) || tabAutor[i][0] > width * 7 || tabAutor[i][0] < 0
						|| tabAutor[i][1] > height * 7 + 37 || tabAutor[i][1] < 37) {
					tabAutor[i][0] = 2000;
					tabAutor[i][1] = 2000;
				}
			}
		}
		return tabAutor;
	}

	public int removeN(int j) {
		int i = 1;
		while (i < 32
				&& !(tabPiece[j] != tabPiece[i] && tabPos[j][0] == tabPos[i][0] && tabPos[j][1] == tabPos[i][1])) {
			i++;
		}
		if (tabPiece[j] != tabPiece[i] && tabPos[j][0] == tabPos[i][0] && tabPos[j][1] == tabPos[i][1]) {
			tabPos[i][0] += 9999;
			tabPos[i][1] += 9999;
			tabPiece[32] = tabPiece[i];
		} else
			tabPiece[32] = null;

		return i;
	}

	public void anteRemove(int j) {
		int i = 1;
		while (i < 32 && !(tabPiece[j] == tabPiece[i])) {
			i++;
		}
		if (tabPiece[j] == tabPiece[i]) {
			tabPos[i][0] -= 9999;
			tabPos[i][1] -= 9999;
		} else
			tabPiece[j] = null;
	}

	public boolean echec(int j) {
		if (j == 0) {
			for (int i = 16; i < 32; i++) {
				int[][] tab = deplacementsAutorises(i);
				for (int k = 0; k < 56; k++) {
					if (tab[k][0] == tabPos[0][0] && tab[k][1] == tabPos[0][1]) {
						return true;
					}
				}
			}
			return false;
		} else if (j == 16) {
			for (int i = 0; i < 16; i++) {
				int[][] tab = deplacementsAutorises(i);
				for (int k = 0; k < 56; k++) {
					if (tab[k][0] == tabPos[16][0] && tab[k][1] == tabPos[16][1]) {
						return true;
					}
				}
			}
			return false;
		}
		return false;
	}

	public boolean echecMat(int r) {
		/*
		 * if(piecesAppuyables().length>0) return false;
		 */
		if (r == 0) {
			for (int i = 0; i < 16; i++) {
				if (deplacementsVerifiees(i).length > 0) {
					return false;
				}
			}
		}
		if (r == 16) {
			for (int i = 16; i < 32; i++) {
				if (deplacementsVerifiees(i).length > 0) {
					return false;
				}
			}
		}
		return true;
	}

	public int[][] deplacementsVerifiees(int j) {
		int[][] tabVerif = new int[56][2];
		int x = tabPos[j][0], y = tabPos[j][1];
		int k = 0;
		boolean bool = true;
		int[][] tabAutor = deplacementsAutorises(j);
		for (int i = 0; i < 56; i++) {
			tabPos[j][0] = tabAutor[i][0];
			tabPos[j][1] = tabAutor[i][1];
			removeN(j);
			if (j < 16) {
				bool = echec(0);
			} else
				bool = echec(16);
			if (!bool && tabAutor[i][0] < 700 && tabAutor[i][1] > 35) {
				tabVerif[k][0] = tabAutor[i][0];
				tabVerif[k][1] = tabAutor[i][1];
				k++;
			}
			anteRemove(32);
			tabPos[j][0] = x;
			tabPos[j][1] = y;
		}
		int[][] tabVerifFin = new int[k][2];
		for (int i = 0; i < k; i++) {
			tabVerifFin[i] = tabVerif[i];
		}
		return tabVerifFin;
	}

	public boolean verifVerif(int j, int x, int y) {
		int[][] tabVerif = deplacementsVerifiees(j);
		for (int i = 0; i < tabVerif.length; i++) {
			if (tabVerif[i][0] == x && tabVerif[i][1] == y)
				return true;
		}
		return false;
	}

	public boolean deplacementSpecialRoi(int roi) {
		int i = 0;
		while (i < listPos.size()) {
			String ch = listPos.get(i).substring(0, listPos.get(i).indexOf("%"));
			int e = Integer.parseInt(ch);
			if (roi == 0) {
				if (e == 0 || e == 5) {
					return false;
				}
			} else if (roi == 16) {
				if (e == 16 || e == 21) {
					return false;
				}
			}
			i++;
		}
		return true;
	}

	public int parcoursTabPionTrans(int j) {
		int i = 0;
		while (i < tabPionTrans.length) {
			if (tabPionTrans[i][0] == j) {
				return i;
			}
			i++;
		}
		return 35;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			if (listPos.size() > 0) {
				String ch = listPos.get(listPos.size() - 1);
				int i = Integer.parseInt(ch.substring(0, ch.indexOf("%")));
				int x = Integer.parseInt(ch.substring(ch.indexOf("%") + 1, ch.indexOf("#")));
				int y;
				if (ch.indexOf("+") != -1 && ch.indexOf("T") == -1) {
					y = Integer.parseInt(ch.substring(ch.indexOf("#") + 1, ch.indexOf("+")));
					anteRemove(Integer.parseInt(ch.substring(ch.indexOf("+") + 1)));
				} else if (ch.indexOf("+") != -1 && ch.indexOf("T") != -1) {
					y = Integer.parseInt(ch.substring(ch.indexOf("#") + 1, ch.indexOf("+")));
					anteRemove(Integer.parseInt(ch.substring(ch.indexOf("+") + 1, ch.length() - 1)));
				} else if (ch.indexOf("+") == -1 && ch.indexOf("T") != -1) {
					y = Integer.parseInt(ch.substring(ch.indexOf("#") + 1, ch.length() - 1));
				} else {
					y = Integer.parseInt(ch.substring(ch.indexOf("#") + 1));
				}
				int k = parcoursTabPionTrans(i);
				if (i == 0 && tabPos[0][0] == width * 6 && x == width * 4) {
					tabPos[5][0] = width * 7;
					boolRoiWhite = true;
				} else if (i == 16 && tabPos[16][0] == width * 6 && x == width * 4) {
					tabPos[21][0] = width * 7;
					boolRoiBlack = true;
				} else if (k < 16 && ch.indexOf("T") != -1) {
					int j = tabPionTrans[k][0];
					l--;
					if (j < 16) {
						tabPiece[j].setImage(new ImageIcon("pionWhite.jpg").getImage().getScaledInstance(75, 70,
								Image.SCALE_DEFAULT));
					} else
						tabPiece[j].setImage(new ImageIcon("pionBlack.jpg").getImage().getScaledInstance(75, 70,
								Image.SCALE_DEFAULT));
					tabPionTrans[k][0] = 35;
					tabPionTrans[k][1] = 35;
				}
				tabPos[i][0] = x;
				tabPos[i][1] = y;
				tabPiece[33] = null;
				listPos.remove(listPos.size() - 1);
				if (intBool == 2)
					intBool = 0;
				else if (intBool == 0)
					intBool = 2;
				if (echec(0)) {
					posXRectEchec = tabPos[0][0];
					posYRectEchec = tabPos[0][1];
				} else if (echec(16)) {
					posXRectEchec = tabPos[16][0];
					posYRectEchec = tabPos[16][1];
				} else {
					posXRectEchec = 0;
					posYRectEchec = 0;
				}
				repaint();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	// VERIFIER CE QUI SUIT
	/*
	 * public int[] piecesAppuyables() { int[] tab = new int[16]; int k=0; int[]
	 * tabAppuyable; if(intBool==0||intBool==1) { for(int i=0;i<16;i++) {
	 * if(deplacementsVerifiees(i).length>0) { tab[k]=i; k++; } } }
	 * 
	 * else if(intBool==3||intBool==2) { for(int i=16;i<32;i++) {
	 * if(deplacementsVerifiees(i).length>0) { tab[i-16]=i; k++; } } }
	 * tabAppuyable=new int[k]; for(int i=0;i<k;i++) { tabAppuyable[i]=tab[i]; }
	 * return tabAppuyable; } public boolean verifAppuyable(int j) { int[]
	 * tabAppuyable=piecesAppuyables(); for(int i=0;i<tabAppuyable.length;i++) {
	 * if(tabPiece[j]==tabPiece[i]) { return true; } } return false; }
	 */

}
