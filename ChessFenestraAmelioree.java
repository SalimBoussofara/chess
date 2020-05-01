package cms_chess;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.regex.PatternSyntaxException;


class ChessFenestraAmelioree extends JFrame implements MouseListener{
	public void sound(File path) {
		try{
			Clip clip= AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(path));
			clip.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	String message;
	
	ImageIcon roiBlack = new ImageIcon(new ImageIcon("roiBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	
	ImageIcon reineBlack = new ImageIcon(new ImageIcon("reineBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	
	ImageIcon fouBlack = new ImageIcon(new ImageIcon("fouBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon fouBlack2 = new ImageIcon (new ImageIcon("fouBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	
	ImageIcon cavalierBlack = new ImageIcon(new ImageIcon("cavalierBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon cavalierBlack2 = new ImageIcon(new ImageIcon("cavalierBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	
	ImageIcon tourBlack = new ImageIcon(new ImageIcon("tourBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon tourBlack2 =new ImageIcon(new ImageIcon("tourBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	
	ImageIcon pionBlack1 = new ImageIcon(new ImageIcon("pionBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionBlack2 = new ImageIcon(new ImageIcon("pionBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionBlack3 = new ImageIcon(new ImageIcon("pionBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionBlack4 = new ImageIcon(new ImageIcon("pionBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionBlack5 = new ImageIcon(new ImageIcon("pionBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionBlack6 = new ImageIcon(new ImageIcon("pionBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionBlack7 = new ImageIcon(new ImageIcon("pionBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionBlack8 = new ImageIcon(new ImageIcon("pionBlack.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));

	ImageIcon roiWhite = new ImageIcon(new ImageIcon("roiWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	
	ImageIcon reineWhite = new ImageIcon(new ImageIcon("reineWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	
	ImageIcon fouWhite = new ImageIcon(new ImageIcon("fouWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon fouWhite2 = new ImageIcon(new ImageIcon("fouWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	
	ImageIcon cavalierWhite = new ImageIcon(new ImageIcon("cavalierWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon cavalierWhite2 = new ImageIcon(new ImageIcon("cavalierWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	
	ImageIcon tourWhite = new ImageIcon(new ImageIcon("tourWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon tourWhite2 = new ImageIcon(new ImageIcon("tourWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	
	ImageIcon pionWhite1 = new ImageIcon(new ImageIcon("pionWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionWhite2 = new ImageIcon(new ImageIcon("pionWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionWhite3 = new ImageIcon(new ImageIcon("pionWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionWhite4 = new ImageIcon(new ImageIcon("pionWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionWhite5 = new ImageIcon(new ImageIcon("pionWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionWhite6 = new ImageIcon(new ImageIcon("pionWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionWhite7 = new ImageIcon(new ImageIcon("pionWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon pionWhite8 = new ImageIcon(new ImageIcon("pionWhite.jpg").getImage().getScaledInstance(75, 70, Image.SCALE_DEFAULT));
	ImageIcon imageBougee;
	ImageIcon imageEffacee;
	
	ImageIcon[] tabPiece= {roiWhite,reineWhite,fouWhite,fouWhite2,tourWhite,tourWhite2,cavalierWhite,cavalierWhite2,pionWhite1,pionWhite2,
			pionWhite3,pionWhite4,pionWhite5,pionWhite6,pionWhite7,pionWhite8, 
			roiBlack,reineBlack,fouBlack,fouBlack2,tourBlack,tourBlack2,cavalierBlack,cavalierBlack2,pionBlack1,pionBlack2,
			pionBlack3,pionBlack4,pionBlack5,pionBlack6,pionBlack7,pionBlack8,imageBougee,imageEffacee
		};

	/*
	 * roiWhite=0;
	 * reineWhite=1;
	 * fouWhite=2;fouWhite2=3;
	 * tourWhite=4;tourWhite2=5;
	 * cavalierWhite=6;cavalierWhite2=7;
	 * pionWhite:  8-->15;
	 * roiBlack=16;reineBlack=17;
	 * fouBlack=18,fouBlack2=19;
	 * tourWhite=20;tourWhite2=21;
	 * cavalierBlack=22;cavalierBlack=23;
	 * pionBlack:  24-->31; 
	 * imageBougee=32
	 * 
	 */
	
	int[][] tabPos=new int[34][2];
	int width=600/8;
	int height=560/8;
	{tabPos[0][1]=height*7+37;tabPos[0][0]=width*4;
	tabPos[1][1]=height*7+37;tabPos[1][0]=width*3;
	tabPos[2][1]=height*7+37;tabPos[2][0]=width*2;
	tabPos[3][1]=height*7+37;tabPos[3][0]=width*5;
	tabPos[4][1]=height*7+37;tabPos[4][0]=0;
	tabPos[5][1]=height*7+37;tabPos[5][0]=width*7;
	tabPos[6][1]=height*7+37;tabPos[6][0]=width*6;
	tabPos[7][1]=height*7+37;tabPos[7][0]=width;
	tabPos[8][0]=0;tabPos[8][1]=height*6+37;
	tabPos[9][0]=width;tabPos[9][1]=height*6+37;
	tabPos[10][0]=width*3;tabPos[10][1]=height*6+37;
	tabPos[11][0]=width*4;tabPos[11][1]=height*6+37;
	tabPos[12][0]=width*5;tabPos[12][1]=height*6+37;
	tabPos[13][0]=width*6;tabPos[13][1]=height*6+37;
	tabPos[14][0]=width*7;tabPos[14][1]=height*6+37;
	tabPos[15][0]=width*2;tabPos[15][1]=height*6+37;
	tabPos[16][1]=37;tabPos[16][0]=width*4;
	tabPos[17][1]=37;tabPos[17][0]=width*3;
	tabPos[18][1]=37;tabPos[18][0]=width*2;
	tabPos[19][1]=37;tabPos[19][0]=width*5;
	tabPos[20][1]=37;tabPos[20][0]=0;
	tabPos[21][1]=37;tabPos[21][0]=width*7;
	tabPos[22][1]=37;tabPos[22][0]=width*6;
	tabPos[23][1]=37;tabPos[23][0]=width;
	tabPos[24][0]=width*1;tabPos[24][1]=height+37;
	tabPos[25][0]=width*2;tabPos[25][1]=height+37;
	tabPos[26][0]=width*3;tabPos[26][1]=height+37;
	tabPos[27][0]=width*4;tabPos[27][1]=height+37;
	tabPos[28][0]=width*5;tabPos[28][1]=height+37;
	tabPos[29][0]=width*6;tabPos[29][1]=height+37;
	tabPos[30][0]=width*7;tabPos[30][1]=height+37;
	tabPos[31][0]=0;tabPos[31][1]=height+37;
	//tabPos[32][0]=0;tabPos[31][1]=0;
	//tabPos[33][0]=0;tabPos[31][1]=0;
	}
	
	
	int indBougee;
	int posXRectEchec=0,posYRectEchec=0;
	

	public ChessFenestraAmelioree() {
		Toolkit tkit=Toolkit.getDefaultToolkit();
		Dimension dimMoniteur=tkit.getScreenSize();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(dimMoniteur.width/2-600/2,dimMoniteur.height/2-610/2,600,610);
		setResizable(false);
		setVisible(true);
		addMouseListener(this);
		setVisible(true);	
		
	}
	/*il faut trouver un moyen pour intégrer remove à echec (si possible après intégrer échec à déplacementAutorisé)
	 * le probleme est que colorerect vient avant le deplacement de la piece et doit anticiper tous les deplacements de la piece 
	 * ainsi que la suppresion de l'éventuelle pièce qu'elle pourrait supprimer si elle choissisait de se déplacer sur ce rectangle
	 *  en somme, il faut trouver comment faire colorerRect en tenant compte de l'échec et donc implicitement l'éventuelle remove
	 *+ trouver ce qui cloche avec fouWhite2;
	 *+vérifier si l'appel d'echecMat est juste ou non
	 *+trouver un moyen facile pour que si echecMath retourne false, les rectangles retrouvent leurs positions
	 *le problème apparait clairement quand on ouvre la fenêtre et qu'on trouve les rectangles de cavalierBlack dessiné
	 *puisque c'est le premier à retourner false ++ peut-etre envisagé d'ajouter une méthode qui est comme colorerRect 
	 *mais qui donne des positions fictives (peut-être que ça pourrait tout régler)
	 */
	
	
	public void paint(Graphics g) {
		super.paint(g);
		for(int i=0;i<32;i++) {
			if(tabPos[i][0]<700) {
				tabPiece[i].paintIcon(this, g, tabPos[i][0],tabPos[i][1]);
			}
		}
				
		((Graphics2D)g).setStroke(new BasicStroke(4.0f));
		g.setColor(Color.DARK_GRAY);
		g.drawLine(width, 0, width, 597);
		g.drawLine(width*2, 0, width*2, 597);
		g.drawLine(width*3, 0, width*3, 597);
		g.drawLine(width*4, 0, width*4, 597);
		g.drawLine(width*5, 0, width*5, 597);
		g.drawLine(width*6, 0, width*6, 597);
		g.drawLine(width*7, 0, width*7, 597);
	
		g.fillRect(0, 0, 600, 37);
		g.fillRect(0, 0, 10, 600);
		g.fillRect(590, 0, 10, 600);
		g.fillRect(0, 595, 600, 15);
		g.drawLine(0, height+37, 600, height+37);
		g.drawLine(0, height*2+37, 600, height*2+37);
		g.drawLine(0, height*3+37, 600, height*3+37);
		g.drawLine(0, height*4+37, 600, height*4+37);
		g.drawLine(0, height*5+37, 600, height*5+37);
		g.drawLine(0, height*6+37, 600, height*6+37);
		g.drawLine(0, height*7+37, 600, height*7+37);
			
		
		g.setColor(Color.blue);
		((Graphics2D)g).setStroke(new BasicStroke(5.0f));
		if(intBool==1 || intBool==3) {
			int[][] tabVerif=deplacementsVerifiees(indBougee);
			for(int i=0;i<tabVerif.length;i++) {
				if(tabVerif[i][0]<700) {
					System.out.println(tabVerif[i][0]+"  "+tabVerif[i][1]);
					g.drawRect(tabVerif[i][0],tabVerif[i][1],width,height);
				}
			}
		}else if(intBool==0) {
			for(int i=0;i<16;i++) {
				if(tabPos[i][0]<700) {
					g.drawRect(tabPos[i][0],tabPos[i][1],width,height);
				}
			}
		}else {
			for(int i=16;i<32;i++) {
				if(tabPos[i][0]<700)
					g.drawRect(tabPos[i][0],tabPos[i][1],width,height);
			}
		}
		
		g.setColor(Color.red);
		if(posYRectEchec>35)
			g.drawRect(posXRectEchec, posYRectEchec, width, height);
	}

	int intBool=0;
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
			double x=e.getX();
			double y=e.getY();
			boolean bool=true;
			
		
			if(message!="Les Blancs ont perdu" && message!="Les Noirs ont perdu") {	
				if(intBool==0) {
					int kx=((int) Math.floor(x/width))*width;
					int	ky=((int) Math.floor((y-37)/height))*height+37;
					intBool=1;
					bool=false;
					for(int i=0;i<16;i++) {
						if(kx==tabPos[i][0] && ky==tabPos[i][1]) {
							tabPiece[32]=tabPiece[i];
							tabPos[32][0]=kx;
							tabPos[32][1]=ky;
							indBougee=i;
							bool=true;
						}
					}
					
					if(!bool){
						intBool=0;
						System.out.println("Choisissez une pièce blanche");
						sound(new File("Warning.WAV"));
						
					}
					if(intBool==1) {
						repaint();
					}
				}
				
				
				//********************************************
				else if(intBool==1) {

						intBool=2;
						int kx=((int) Math.floor(x/width))*width;
						int	ky=((int) Math.floor((y-37)/height))*height+37;
						if(!verifVerif(indBougee, kx, ky)){
							intBool=0;
							sound(new File("Warning.WAV"));
						}
						else {
								tabPos[indBougee][0]=kx;
								tabPos[indBougee][1]=ky;
								remove(indBougee);
							}
							
						if(intBool==2) {
							if(echec(tabPiece[16])) {
								posXRectEchec=tabPos[16][0];
								posYRectEchec=tabPos[16][1];
							}else {
								posXRectEchec=0;posYRectEchec=0;
							}
							imageEffacee=null;
							
						}/*else {
							anteRemove();
							imageEffacee=null;
						}*/
						repaint();
						if(echecMat()==true) {	
							message="Les Noirs ont perdu";
							sound(new File("tada.WAV"));
							new replayFenestra(message);
						}
					}
					
				
				//***************************************************
				if(intBool==2) {
					int kx=((int) Math.floor(x/width))*width;
					int	ky=((int) Math.floor((y-37)/height))*height+37;
					intBool=3;
					bool=false;
					for(int i=16;i<32;i++) {
						if(kx==tabPos[i][0] && ky==tabPos[i][1]) {
							tabPiece[32]=tabPiece[i];
							tabPos[32][0]=kx;
							tabPos[32][1]=ky;
							indBougee=i;
							bool=true;
						}
					}
					
					if(!bool){
						intBool=2;
						System.out.println("Choisissez une pièce blanche");
						sound(new File("Warning.WAV"));
					}
					if(intBool==3) {
						repaint();
					}
				}
				
				
				//********************************************
				else if(intBool==3) {

						intBool=0;
						int kx=((int) Math.floor(x/width))*width;
						int	ky=((int) Math.floor((y-37)/height))*height+37;
						if(!verifVerif(indBougee, kx, ky)){
							intBool=2;
							sound(new File("Warning.WAV"));
						}
						else {
								tabPos[indBougee][0]=kx;
								tabPos[indBougee][1]=ky;
								remove(indBougee);
							}
							
						if(intBool==0) {
							if(echec(tabPiece[0])) {
								posXRectEchec=tabPos[0][0];
								posYRectEchec=tabPos[0][1];
							}else {
								posXRectEchec=0;posYRectEchec=0;
							}
							imageEffacee=null;
							
						}/*else {
							anteRemove();
							imageEffacee=null;
						}*/
						repaint();
						if(echecMat()==true) {	
							message="Les Noirs ont perdu";
							sound(new File("tada.WAV"));
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
	
	
	
	
	public boolean verifBlack(int x,int y) {
		for(int i=16;i<32;i++) {
			if(x==tabPos[i][0] && y==tabPos[i][1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean verifWhite(int x,int y) {
		for(int i=0;i<16;i++) {
			if(x==tabPos[i][0] && y==tabPos[i][1]) {
				return true;
			}
		}
		return false;
	}
	public boolean verifBlackAndWhite(int x,int y){
		if(verifBlack(x,y) || verifWhite(x,y))
			return true;
		return false;
	}
	
	
	
	public int[][][] deplacementsAutorises() {
		int[][][] tabAutor=new int[32][56][2];
		int x,y;
		int k=0;
		while(k<=16) {
				//********roiWhite****
				x=tabPos[k][0];y=tabPos[k][1];
				tabAutor[k+0][0][0]=x+width+9999 ; tabAutor[k+0][0][1]=y+9999 ; 
				tabAutor[k+0][1][0]=x-width+9999 ; tabAutor[k+0][1][1]=y+9999 ; 
				tabAutor[k+0][2][0]=x ; tabAutor[k+0][2][1]=y+9999-height ; 
				tabAutor[k+0][3][0]=x+width+9999 ; tabAutor[k+0][3][1]=y+9999+height;
				tabAutor[k+0][4][0]=x ; tabAutor[k+0][4][1]=y+9999+height; 
				tabAutor[k+0][6][0]=x-width+9999 ; tabAutor[k+0][6][1]=y+9999+height;
				tabAutor[k+0][5][0]=x+width+9999 ; tabAutor[k+0][5][1]=y+9999-height ; 
				tabAutor[k+0][7][0]=x-width+9999 ; tabAutor[k+0][7][1]=y+9999-height ;

				//***********reineWhite************
				x=tabPos[1+k][0];y=tabPos[k+1][1];
				tabAutor[k+1][0][0]=x+9999+width ; tabAutor[k+1][0][1]=y+9999;	
				 if(!verifBlackAndWhite(x+width, y))
					 {tabAutor[k+1][1][0]=x+9999+width*2 ; tabAutor[k+1][1][1]=y+9999;}
				if(!verifBlackAndWhite(x+width*2, y) && !verifBlackAndWhite(x+width,y)) 
					{tabAutor[k+1][2][0]=x+9999+width*3 ; tabAutor[k+1][2][1]=y+9999;}
				if(!verifBlackAndWhite(x+width*3, y) && !verifBlackAndWhite(x+width*2, y) && !verifBlackAndWhite(x+width,y))
					{tabAutor[k+1][3][0]=x+9999+width*4 ; tabAutor[k+1][3][1]=y+9999;}
				if(!verifBlackAndWhite(x+width*4, y)&& !verifBlackAndWhite(x+width*3, y) && !verifBlackAndWhite(x+width*2, y) && !verifBlackAndWhite(x+width,y)) 
					{tabAutor[k+1][4][0]=x+9999+width*5 ; tabAutor[k+1][4][1]=y+9999;}
				if(!verifBlackAndWhite(x+width*5, y) && !verifBlackAndWhite(x+width*4, y)&& !verifBlackAndWhite(x+width*3, y) && !verifBlackAndWhite(x+width*2, y) && !verifBlackAndWhite(x+width,y)) 
					{tabAutor[k+1][5][0]=x+9999+width*6 ; tabAutor[k+1][5][1]=y+9999;}
				if( !verifBlackAndWhite(x+width*6, y)&&!verifBlackAndWhite(x+width*5, y) && !verifBlackAndWhite(x+width*4, y)&& !verifBlackAndWhite(x+width*3, y) && !verifBlackAndWhite(x+width*2, y) && !verifBlackAndWhite(x+width,y)) 
					{tabAutor[k+1][6][0]=x+9999+width*7 ; tabAutor[k+1][6][1]=y+9999;}
					
				tabAutor[k+1][13][0]=x+9999-width ; tabAutor[k+1][13][1]=y+9999;
				if(!verifBlackAndWhite(x-width, y))
					{tabAutor[k+1][7][0]=x+9999-width*2 ; tabAutor[k+1][7][1]=y+9999;}
				if(!verifBlackAndWhite(x-width, y) && !verifBlackAndWhite(x-width*2, y))
					{tabAutor[k+1][8][0]=x+9999-width*3 ; tabAutor[k+1][8][1]=y+9999;}
				if(!verifBlackAndWhite(x-width, y) && !verifBlackAndWhite(x-width*2, y) && !verifBlackAndWhite(x-width*3, y))
					{tabAutor[k+1][9][0]=x+9999-width*4 ; tabAutor[k+1][9][1]=y+9999;}
				if(!verifBlackAndWhite(x-width, y) && !verifBlackAndWhite(x-width*2, y) && !verifBlackAndWhite(x-width*3, y)&& !verifBlackAndWhite(x-width*4, y)) 
					{tabAutor[k+1][10][0]=x+9999-width*5 ; tabAutor[k+1][10][1]=y+9999;}
				if(!verifBlackAndWhite(x-width, y) && !verifBlackAndWhite(x-width*2, y) && !verifBlackAndWhite(x-width*3, y)&& !verifBlackAndWhite(x-width*4, y) && !verifBlackAndWhite(x-width*5, y))
					{tabAutor[k+1][11][0]=x+9999-width*6 ; tabAutor[k+1][11][1]=y+9999;}
				if(!verifBlackAndWhite(x-width, y) && !verifBlackAndWhite(x-width*2, y) && !verifBlackAndWhite(x-width*3, y)&& !verifBlackAndWhite(x-width*4, y) && !verifBlackAndWhite(x-width*5, y) && !verifBlackAndWhite(x-width*6, y)) 
					{tabAutor[k+1][12][0]=x+9999-width*7 ; tabAutor[k+1][12][1]=y+9999;}
					
				tabAutor[k+1][14][1]=y+9999+height ; tabAutor[k+1][14][0]=x+9999; 	
				if(!verifBlackAndWhite(x, y+height)) 
					{tabAutor[k+1][27][1]=y+9999+height*2 ; tabAutor[k+1][27][0]=x+9999;} 
				if(!verifBlackAndWhite(x, y+height)  && !verifBlackAndWhite(x, y+height*2)) 
					{tabAutor[k+1][15][1]=y+9999+height*3 ; tabAutor[k+1][15][0]=x+9999;} 
				if( !verifBlackAndWhite(x, y+height)  && !verifBlackAndWhite(x, y+height*2) && !verifBlackAndWhite(x, y+height*3))
					{tabAutor[k+1][16][1]=y+9999+height*4 ; tabAutor[k+1][16][0]=x+9999;} 
				if(!verifBlackAndWhite(x, y+height)  && !verifBlackAndWhite(x, y+height*2) && !verifBlackAndWhite(x, y+height*3) && !verifBlackAndWhite(x, y+height*4))
					{tabAutor[k+1][17][1]=y+9999+height*5 ; tabAutor[k+1][17][0]=x+9999;} 
				if(!verifBlackAndWhite(x, y+height)  && !verifBlackAndWhite(x, y+height*2) && !verifBlackAndWhite(x, y+height*3) && !verifBlackAndWhite(x, y+height*4) && !verifBlackAndWhite(x, y+height*5))
					{tabAutor[k+1][18][1]=y+9999+height*6 ; tabAutor[k+1][18][0]=x+9999;} 
				if(!verifBlackAndWhite(x, y+height)  && !verifBlackAndWhite(x, y+height*2) && !verifBlackAndWhite(x, y+height*3) && !verifBlackAndWhite(x, y+height*4) && !verifBlackAndWhite(x, y+height*5) && !verifWhite(x, y+height*6)) 
					{tabAutor[k+1][19][1]=y+9999+height*7 ; tabAutor[k+1][19][0]=x+9999;} 
					
					
				tabAutor[k+1][20][1]=y+9999-height ; tabAutor[k+1][20][0]=x+9999 ;	
				if(!verifBlackAndWhite(x, y-height))
					{tabAutor[k+1][21][1]=y+9999-height*2 ; tabAutor[k+1][21][0]=x+9999 ;}
				if(!verifBlackAndWhite(x, y-height) && !verifBlackAndWhite(x, y-height*2))
					{tabAutor[k+1][22][1]=y+9999-height*3 ; tabAutor[k+1][22][0]=x+9999 ;}
				if(!verifBlackAndWhite(x, y-height) && !verifBlackAndWhite(x, y-height*2) && !verifBlackAndWhite(x, y-height*3))
					{tabAutor[k+1][23][1]=y+9999-height*4 ; tabAutor[k+1][23][0]=x+9999;}
				if(!verifBlackAndWhite(x, y-height) && !verifBlackAndWhite(x, y-height*2) && !verifBlackAndWhite(x, y-height*3) && !verifBlackAndWhite(x, y-height*4)) 
					{tabAutor[k+1][24][1]=y+9999-5*height ; tabAutor[k+1][24][0]=x+9999 ;}
				if( !verifBlackAndWhite(x, y-height) && !verifBlackAndWhite(x, y-height*2) && !verifBlackAndWhite(x, y-height*3) && !verifBlackAndWhite(x, y-height*4) && !verifBlackAndWhite(x, y-height*5))
					{tabAutor[k+1][25][1]=y+9999-6*height ; tabAutor[k+1][25][0]=x+9999;}
				if( !verifBlackAndWhite(x, y-height) && !verifBlackAndWhite(x, y-height*2) && !verifBlackAndWhite(x, y-height*3) && !verifBlackAndWhite(x, y-height*4)  && !verifBlackAndWhite(x, y-height*5)&& !verifBlackAndWhite(x, y-height*6))
					{tabAutor[k+1][26][1]=y+9999-height*7 ; tabAutor[k+1][26][0]=x+9999;}
					
				tabAutor[k+1][28][0]=x+9999+width;tabAutor[k+1][28][1]=y+9999+height;	
				if( !verifBlackAndWhite(x+width, y+height))
					{tabAutor[k+1][29][0]=x+9999+width*2 ; tabAutor[k+1][29][1]=y+9999+height*2;}
				if(!verifBlackAndWhite(x+width, y+height) && !verifBlackAndWhite(x+width*2, y+height*2))
					{tabAutor[k+1][30][0]=x+9999+width*3 ; tabAutor[k+1][30][1]=y+9999+height*3 ;}
				if( !verifBlackAndWhite(x+width, y+height) && !verifBlackAndWhite(x+width*2, y+height*2) && !verifBlackAndWhite(x+width*3, y+height*3))
					{tabAutor[k+1][31][0]=x+9999+width*4 ; tabAutor[k+1][31][1]=y+9999+4*height ;}
				if(!verifBlackAndWhite(x+width, y+height) && !verifBlackAndWhite(x+width*2, y+height*2) && !verifBlackAndWhite(x+width*3, y+height*3)  && !verifBlackAndWhite(x+width*4, y+height*4)) 
					{tabAutor[k+1][32][0]=x+9999+width*5 ; tabAutor[k+1][32][1]=y+9999+height*5 ;}
					
				if(!verifBlackAndWhite(x+width, y+height) && !verifBlackAndWhite(x+width*2, y+height*2) && !verifBlackAndWhite(x+width*3, y+height*3)  && !verifBlackAndWhite(x+width*4, y+height*4) && !verifWhite(x+width*5, y+height*5))
					{tabAutor[k+1][33][0]=x+9999+width*6 ; tabAutor[k+1][33][1]=y+9999+height*6 ;}
				if(!verifBlackAndWhite(x+width, y+height) && !verifBlackAndWhite(x+width*2, y+height*2) && !verifBlackAndWhite(x+width*3, y+height*3)  && !verifBlackAndWhite(x+width*4, y+height*4) && !verifWhite(x+width*5, y+height*5) && !verifWhite(x+width*6, y+height*6)) 
					{tabAutor[k+1][34][0]=x+9999+width*7 ; tabAutor[k+1][34][1]=y+9999+height*7;}
				
				tabAutor[k+1][35][0]=x+9999-width ; tabAutor[k+1][35][1]=y+9999+height;
					
				if(!verifBlackAndWhite(x-width, y+height))
					{tabAutor[k+1][36][0]=x+9999-width*2 ; tabAutor[k+1][36][1]=y+9999+height*2;}
				if(!verifBlackAndWhite(x-width, y+height) && !verifWhite(x-width*2, y+height*2)) 
					{tabAutor[k+1][37][0]=x+9999-width*3 ; tabAutor[k+1][37][1]=y+9999+height*3;}
				if(!verifBlackAndWhite(x-width, y+height) && !verifWhite(x-width*2, y+height*2) && !verifBlackAndWhite(x-width*3, y+height*3))
					{tabAutor[k+1][38][0]=x+9999-width*4 ; tabAutor[k+1][38][1]=y+9999+4*height;}
				if(!verifBlackAndWhite(x-width, y+height) && !verifWhite(x-width*2, y+height*2) && !verifBlackAndWhite(x-width*3, y+height*3)  && !verifBlackAndWhite(x-width*4, y+height*4))
					{tabAutor[k+1][39][0]=x+9999-width*5 ; tabAutor[k+1][39][1]=y+9999+height*5;}
				if(!verifBlackAndWhite(x-width, y+height) && !verifWhite(x-width*2, y+height*2) && !verifBlackAndWhite(x-width*3, y+height*3)  && !verifBlackAndWhite(x-width*4, y+height*4) && !verifBlackAndWhite(x-width*5, y+height*5))
					{tabAutor[k+1][40][0]= x-width*6 ; tabAutor[k+1][40][1]=y+9999+height*6;}
				if(!verifBlackAndWhite(x-width, y+height) && !verifWhite(x-width*2, y+height*2) && !verifBlackAndWhite(x-width*3, y+height*3)  && !verifBlackAndWhite(x-width*4, y+height*4) && !verifBlackAndWhite(x-width*5, y+height*5) && !verifBlackAndWhite(x-width*6, y+height*6)) 
					{tabAutor[k+1][41][0]=x+9999-width*7  ; tabAutor[k+1][41][1]=y+9999+height*7 ;}
				
				tabAutor[k+1][42][0]=x+9999+width ; tabAutor[k+1][42][1]=y+9999-height; 
					
				if(!verifBlackAndWhite(x+width, y-height))
					{tabAutor[k+1][43][0]=x+9999+width*2 ; tabAutor[k+1][43][1]=y+9999-height*2;}
				if(!verifBlackAndWhite(x+width, y-height) && !verifBlackAndWhite(x+width*2, y-height*2))
					{tabAutor[k+1][44][0]=x+9999+width*3 ; tabAutor[k+1][44][1]=y+9999-height*3;}
				if(!verifBlackAndWhite(x+width, y-height) && !verifBlackAndWhite(x+width*2, y-height*2) && !verifBlackAndWhite(x+width*3, y-height*3))
					{tabAutor[k+1][45][0]=x+9999+width*4 ; tabAutor[k+1][45][1]=y+9999-4*height;}
				if(!verifBlackAndWhite(x+width, y-height) && !verifBlackAndWhite(x+width*2, y-height*2) && !verifBlackAndWhite(x+width*3, y-height*3) && !verifBlackAndWhite(x+width*4, y-height*4))
					{tabAutor[k+1][46][0]=x+9999+width*5 ; tabAutor[k+1][46][1]=y+9999-height*5;}
				if(!verifBlackAndWhite(x+width, y-height) && !verifBlackAndWhite(x+width*2, y-height*2) && !verifBlackAndWhite(x+width*3, y-height*3) && !verifBlackAndWhite(x+width*4, y-height*4) && !verifBlackAndWhite(x+width*5, y-height*5)) 
					{tabAutor[k+1][47][0]=x+9999+width*6 ; tabAutor[k+1][47][1]=y+9999-height*6;} 
				if(!verifBlackAndWhite(x+width, y-height) && !verifBlackAndWhite(x+width*2, y-height*2) && !verifBlackAndWhite(x+width*3, y-height*3) && !verifBlackAndWhite(x+width*4, y-height*4) && !verifBlackAndWhite(x+width*5, y-height*5) && !verifBlackAndWhite(x+width*6, y-height*6))
					{tabAutor[k+1][48][0]=x+9999+width*7 ; tabAutor[k+1][48][1]= y-height*7;}
					
				tabAutor[k+1][49][0]=x+9999-width ; tabAutor[k+1][49][1]=y+9999-height;
					
				if(!verifBlackAndWhite(x-width, y-height))
					{tabAutor[k+1][50][0]=x+9999-width*2 ; tabAutor[k+1][50][1]=y+9999-height*2;}
				if(!verifBlackAndWhite(x-width, y-height) && !verifBlackAndWhite(x-width*2, y-height*2)) 
					{tabAutor[k+1][51][0]=x+9999-width*3; ; tabAutor[k+1][51][1]=y+9999-height*3;}
				if(!verifBlackAndWhite(x-width, y-height) && !verifBlackAndWhite(x-width*2, y-height*2) && !verifBlackAndWhite(x-width*3, y-height*3))
					{tabAutor[k+1][52][0]=x+9999-width*4; ; tabAutor[k+1][52][1]=y+9999-height*4;}
				if(!verifBlackAndWhite(x-width, y-height) && !verifBlackAndWhite(x-width*2, y-height*2) && !verifBlackAndWhite(x-width*3, y-height*3) && !verifBlackAndWhite(x-width*4, y-height*4))
					{tabAutor[k+1][53][0]=x+9999-width*5; ; tabAutor[k+1][53][1]=y+9999-height*5;}
				if(!verifBlackAndWhite(x-width, y-height) && !verifBlackAndWhite(x-width*2, y-height*2) && !verifBlackAndWhite(x-width*3, y-height*3) && !verifBlackAndWhite(x-width*4, y-height*4) && !verifBlackAndWhite(x-width*5, y-height*5)) 
					{tabAutor[k+1][54][0]=x+9999-height*6 ; tabAutor[k+1][54][1]=y+9999-height*6;}
				if(!verifBlackAndWhite(x-width, y-height) && !verifBlackAndWhite(x-width*2, y-height*2) && !verifBlackAndWhite(x-width*3, y-height*3) && !verifBlackAndWhite(x-width*4, y-height*4) && !verifBlackAndWhite(x-width*5, y-height*5) && !verifWhite(x-width*6, y-height*6))
					{tabAutor[k+1][55][0]=x+9999-width*7 ; tabAutor[k+1][55][1]=y+9999-height*7;}
				
			
				//********fouWhite******************
				for(int i=2;i<4;i++) {
					x=tabPos[i+k][0];y=tabPos[i+k][1];
					tabAutor[k+i][0][0]=x+9999+width ; tabAutor[k+i][0][1]=y+9999+height;
						
					if( !verifBlackAndWhite(x+width, y+height))
						{tabAutor[k+i][1][0]=x+9999+width*2 ; tabAutor[k+i][1][1]=y+9999+height*2  ;}
						
					if(!verifBlackAndWhite(x+width, y+height) && !verifBlackAndWhite(x+width*2, y+height*2))
						{tabAutor[k+i][2][0]=x+9999+width*3 ; tabAutor[k+i][2][1]=y+9999+height*3 ;}
					if( !verifBlackAndWhite(x+width, y+height) && !verifBlackAndWhite(x+width*2, y+height*2) && !verifBlackAndWhite(x+width*3, y+height*3))
						{tabAutor[k+i][3][0]=x+9999+width*4 ; tabAutor[k+i][3][1]=y+9999+4*height ;}
					if(!verifBlackAndWhite(x+width, y+height) && !verifBlackAndWhite(x+width*2, y+height*2) && !verifBlackAndWhite(x+width*3, y+height*3)  && !verifBlackAndWhite(x+width*4, y+height*4)) 
						{tabAutor[k+i][4][0]=x+9999+width*5 ; tabAutor[k+i][4][1]=y+9999+height*5 ;}
						
					if(!verifBlackAndWhite(x+width, y+height) && !verifBlackAndWhite(x+width*2, y+height*2) && !verifBlackAndWhite(x+width*3, y+height*3)  && !verifBlackAndWhite(x+width*4, y+height*4) && !verifWhite(x+width*5, y+height*5))
						{tabAutor[k+i][5][0]=x+9999+width*6 ; tabAutor[k+i][5][1]=y+9999+height*6 ;}
					if(!verifBlackAndWhite(x+width, y+height) && !verifBlackAndWhite(x+width*2, y+height*2) && !verifBlackAndWhite(x+width*3, y+height*3)  && !verifBlackAndWhite(x+width*4, y+height*4) && !verifWhite(x+width*5, y+height*5) && !verifWhite(x+width*6, y+height*6)) 
						{tabAutor[k+i][6][0]=x+9999+width*7 ; tabAutor[k+i][6][1]=y+9999+height*7;}
					
					tabAutor[k+i][7][0]=x+9999-width ; tabAutor[k+i][7][1]=y+9999+height;
						
					if(!verifBlackAndWhite(x-width, y+height))
						{tabAutor[k+i][8][0]=x+9999-width*2 ; tabAutor[k+i][8][1]=y+9999+height*2;}
						
					if(!verifBlackAndWhite(x-width, y+height) && !verifWhite(x-width*2, y+height*2)) 
						{tabAutor[k+i][9][0]=x+9999-width*3 ; tabAutor[k+i][9][1]=y+9999+height*3;}
						
					if(!verifBlackAndWhite(x-width, y+height) && !verifWhite(x-width*2, y+height*2) && !verifBlackAndWhite(x-width*3, y+height*3))
						{tabAutor[k+i][10][0]=x+9999-width*4 ; tabAutor[k+i][10][1]=y+9999+4*height;}
					if(!verifBlackAndWhite(x-width, y+height) && !verifWhite(x-width*2, y+height*2) && !verifBlackAndWhite(x-width*3, y+height*3)  && !verifBlackAndWhite(x-width*4, y+height*4))
						{tabAutor[k+i][11][0]=x+9999-width*5 ; tabAutor[k+i][11][1]=y+9999+height*5;}
					if(!verifBlackAndWhite(x-width, y+height) && !verifWhite(x-width*2, y+height*2) && !verifBlackAndWhite(x-width*3, y+height*3)  && !verifBlackAndWhite(x-width*4, y+height*4) && !verifBlackAndWhite(x-width*5, y+height*5))
						{tabAutor[k+i][12][0]=x+9999-width*6 ; tabAutor[k+i][12][1]=y+9999+height*6;}
					if(!verifBlackAndWhite(x-width, y+height) && !verifWhite(x-width*2, y+height*2) && !verifBlackAndWhite(x-width*3, y+height*3)  && !verifBlackAndWhite(x-width*4, y+height*4) && !verifBlackAndWhite(x-width*5, y+height*5) && !verifBlackAndWhite(x-width*6, y+height*6)) 
						{tabAutor[k+i][13][0]=x+9999-width*7  ; tabAutor[k+i][13][1]=y+9999+height*7 ;}
					
					tabAutor[k+i][14][0]=x+9999+width ; tabAutor[k+i][14][1]=y+9999-height; 
						
					if(!verifBlackAndWhite(x+width, y-height))
						{tabAutor[k+i][15][0]=x+9999+width*2 ; tabAutor[k+i][15][1]=y+9999-height*2;}
					if(!verifBlackAndWhite(x+width, y-height) && !verifBlackAndWhite(x+width*2, y-height*2))
						{tabAutor[k+i][16][0]=x+9999+width*3 ; tabAutor[k+i][16][1]=y+9999-height*3;}
					if(!verifBlackAndWhite(x+width, y-height) && !verifBlackAndWhite(x+width*2, y-height*2) && !verifBlackAndWhite(x+width*3, y-height*3))
						{tabAutor[k+i][17][0]=x+9999+width*4 ; tabAutor[k+i][17][1]=y+9999-4*height;}
					if(!verifBlackAndWhite(x+width, y-height) && !verifBlackAndWhite(x+width*2, y-height*2) && !verifBlackAndWhite(x+width*3, y-height*3) && !verifBlackAndWhite(x+width*4, y-height*4))
						{tabAutor[k+i][18][0]=x+9999+width*5 ; tabAutor[k+i][18][1]=y+9999-height*5;}
					if(!verifBlackAndWhite(x+width, y-height) && !verifBlackAndWhite(x+width*2, y-height*2) && !verifBlackAndWhite(x+width*3, y-height*3) && !verifBlackAndWhite(x+width*4, y-height*4) && !verifBlackAndWhite(x+width*5, y-height*5)) 
						{tabAutor[k+i][19][0]=x+9999+width*6 ; tabAutor[k+i][19][1]=y+9999-height*6; }
					if(!verifBlackAndWhite(x+width, y-height) && !verifBlackAndWhite(x+width*2, y-height*2) && !verifBlackAndWhite(x+width*3, y-height*3) && !verifBlackAndWhite(x+width*4, y-height*4) && !verifBlackAndWhite(x+width*5, y-height*5) && !verifBlackAndWhite(x+width*6, y-height*6))
						{tabAutor[k+i][20][0]=x+9999+width*7 ; tabAutor[k+i][20][1]=y+9999+9999-height*7;}
						
					tabAutor[k+i][21][0]=x+9999-width ; tabAutor[k+i][21][1]=y+9999-height;
						
					if(!verifBlackAndWhite(x-width, y-height))
						{tabAutor[k+i][22][0]=x+9999-width*2 ; tabAutor[k+i][22][1]=y+9999-height*2;}
					if(!verifBlackAndWhite(x-width, y-height) && !verifBlackAndWhite(x-width*2, y-height*2)) 
						{tabAutor[k+i][23][0]=x+9999-width*3; ; tabAutor[k+i][23][1]=y+9999-height*3;}
					if(!verifBlackAndWhite(x-width, y-height) && !verifBlackAndWhite(x-width*2, y-height*2) && !verifBlackAndWhite(x-width*3, y-height*3))
						{tabAutor[k+i][24][0]=x+9999-width*4; ; tabAutor[k+i][24][1]=y+9999-height*4;}
					if(!verifBlackAndWhite(x-width, y-height) && !verifBlackAndWhite(x-width*2, y-height*2) && !verifBlackAndWhite(x-width*3, y-height*3) && !verifBlackAndWhite(x-width*4, y-height*4))
						{tabAutor[k+i][25][0]=x+9999-width*5; ; tabAutor[k+i][25][1]=y+9999-height*5;}
					if(!verifBlackAndWhite(x-width, y-height) && !verifBlackAndWhite(x-width*2, y-height*2) && !verifBlackAndWhite(x-width*3, y-height*3) && !verifBlackAndWhite(x-width*4, y-height*4) && !verifBlackAndWhite(x-width*5, y-height*5)) 
						{tabAutor[k+i][26][0]=y+9999-height*6 ; tabAutor[k+i][26][1]=y+9999-height*6;}
					if(!verifBlackAndWhite(x-width, y-height) && !verifBlackAndWhite(x-width*2, y-height*2) && !verifBlackAndWhite(x-width*3, y-height*3) && !verifBlackAndWhite(x-width*4, y-height*4) && !verifBlackAndWhite(x-width*5, y-height*5) && !verifWhite(x-width*6, y-height*6))
						{tabAutor[k+i][27][0]=x+9999-width*7 ; tabAutor[k+i][27][1]=y+9999-height*7;}
				}
			
			
				//****************tour**************
				for(int i=4;i<6;i++) {	
					x=tabPos[i+k][0];y=tabPos[i+k][1];
					tabAutor[k+i][0][0]=x+9999+width ; tabAutor[k+i][0][1]=y+9999;	
					 if(!verifBlackAndWhite(x+width, y))
						 {tabAutor[k+i][1][0]=x+9999+width*2 ; tabAutor[k+i][1][1]=y+9999;}
					if(!verifBlackAndWhite(x+width*2, y) && !verifBlackAndWhite(x+width,y)) 
						{tabAutor[k+i][2][0]=x+9999+width*3 ; tabAutor[k+i][2][1]=y+9999;}
					if(!verifBlackAndWhite(x+width*3, y) && !verifBlackAndWhite(x+width*2, y) && !verifBlackAndWhite(x+width,y))
						{tabAutor[k+i][3][0]=x+9999+width*4 ; tabAutor[k+i][3][1]=y+9999;}
					if(!verifBlackAndWhite(x+width*4, y)&& !verifBlackAndWhite(x+width*3, y) && !verifBlackAndWhite(x+width*2, y) && !verifBlackAndWhite(x+width,y)) 
						{tabAutor[k+i][4][0]=x+9999+width*5 ; tabAutor[k+i][4][1]=y+9999;}
					if(!verifBlackAndWhite(x+width*5, y) && !verifBlackAndWhite(x+width*4, y)&& !verifBlackAndWhite(x+width*3, y) && !verifBlackAndWhite(x+width*2, y) && !verifBlackAndWhite(x+width,y)) 
						{tabAutor[k+i][5][0]=x+9999+width*6 ; tabAutor[k+i][5][1]=y+9999;}
					if( !verifBlackAndWhite(x+width*6, y) &&!verifBlackAndWhite(x+width*5, y) && !verifBlackAndWhite(x+width*4, y)&& !verifBlackAndWhite(x+width*3, y) && !verifBlackAndWhite(x+width*2, y) && !verifBlackAndWhite(x+width,y)) 
						{tabAutor[k+i][6][0]=x+9999+width*7 ; tabAutor[k+i][6][1]=y+9999;}
						
					tabAutor[k+i][13][0]=x+9999-width ; tabAutor[k+i][13][1]=y+9999;
					if(!verifBlackAndWhite(x-width, y))
						{tabAutor[k+i][7][0]=x+9999-width*2 ; tabAutor[k+i][7][1]=y+9999;}
					if(!verifBlackAndWhite(x-width, y) && !verifBlackAndWhite(x-width*2, y))
						{tabAutor[k+i][8][0]=x+9999-width*3 ; tabAutor[k+i][8][1]=y+9999;}
					if(!verifBlackAndWhite(x-width, y) && !verifBlackAndWhite(x-width*2, y) && !verifBlackAndWhite(x-width*3, y))
						{tabAutor[k+i][9][0]=x+9999-width*4 ; tabAutor[k+i][9][1]=y+9999;}
					if(!verifBlackAndWhite(x-width, y) && !verifBlackAndWhite(x-width*2, y) && !verifBlackAndWhite(x-width*3, y)&& !verifBlackAndWhite(x-width*4, y)) 
						{tabAutor[k+i][10][0]=x+9999-width*5 ; tabAutor[k+i][10][1]=y+9999;}
					if(!verifBlackAndWhite(x-width, y) && !verifBlackAndWhite(x-width*2, y) && !verifBlackAndWhite(x-width*3, y)&& !verifBlackAndWhite(x-width*4, y) && !verifBlackAndWhite(x-width*5, y))
						{tabAutor[k+i][11][0]=x+9999-width*6 ; tabAutor[k+i][11][1]=y+9999;}
					if(!verifBlackAndWhite(x-width, y) && !verifBlackAndWhite(x-width*2, y) && !verifBlackAndWhite(x-width*3, y)&& !verifBlackAndWhite(x-width*4, y) && !verifBlackAndWhite(x-width*5, y) && !verifBlackAndWhite(x-width*6, y)) 
						{tabAutor[k+i][12][0]=x+9999-width*7 ; tabAutor[k+i][12][1]=y+9999;}
						
					tabAutor[k+i][14][1]=y+9999+height ; tabAutor[k+i][14][0]=x+9999;
					if(!verifBlackAndWhite(x, y+height)) 
						{tabAutor[k+i][27][1]=y+9999+height*2 ; tabAutor[k+i][27][0]=x+9999;} 
					if(!verifBlackAndWhite(x, y+height)  && !verifBlackAndWhite(x, y+height*2)) 
						{tabAutor[k+i][15][1]=y+9999+height*3 ; tabAutor[k+i][15][0]=x+9999;} 
					if( !verifBlackAndWhite(x, y+height)  && !verifBlackAndWhite(x, y+height*2) && !verifBlackAndWhite(x, y+height*3))
						{tabAutor[k+i][16][1]=y+9999+height*4 ; tabAutor[k+i][16][0]=x+9999;} 
					if(!verifBlackAndWhite(x, y+height)  && !verifBlackAndWhite(x, y+height*2) && !verifBlackAndWhite(x, y+height*3) && !verifBlackAndWhite(x, y+height*4))
						{tabAutor[k+i][17][1]=y+9999+height*5 ; tabAutor[k+i][17][0]=x+9999;} 
					if(!verifBlackAndWhite(x, y+height)  && !verifBlackAndWhite(x, y+height*2) && !verifBlackAndWhite(x, y+height*3) && !verifBlackAndWhite(x, y+height*4) && !verifBlackAndWhite(x, y+height*5))
						{tabAutor[k+i][18][1]=y+9999+height*6 ; tabAutor[k+i][18][0]=x+9999;} 
					if(!verifBlackAndWhite(x, y+height)  && !verifBlackAndWhite(x, y+height*2) && !verifBlackAndWhite(x, y+height*3) && !verifBlackAndWhite(x, y+height*4) && !verifBlackAndWhite(x, y+height*5) && !verifBlackAndWhite(x, y+height*6)) 
						{tabAutor[k+i][19][1]=y+9999+height*7 ; tabAutor[k+i][19][0]=x+9999;} 
						
						
					tabAutor[k+i][20][1]=y+9999-height ; tabAutor[k+i][20][0]=x+9999 ;	
					if(!verifBlackAndWhite(x, y-height))
						{tabAutor[k+i][21][1]=y+9999-height*2 ; tabAutor[k+i][21][0]=x+9999 ;}
					if(!verifBlackAndWhite(x, y-height) && !verifBlackAndWhite(x, y-height*2))
						{tabAutor[k+i][22][1]=y+9999-height*3 ; tabAutor[k+i][22][0]=x+9999 ;}
					if(!verifBlackAndWhite(x, y-height) && !verifBlackAndWhite(x, y-height*2) && !verifBlackAndWhite(x, y-height*3))
						{tabAutor[k+i][23][1]=y+9999-height*4 ; tabAutor[k+i][23][0]=x+9999;}
					if(!verifBlackAndWhite(x, y-height) && !verifBlackAndWhite(x, y-height*2) && !verifBlackAndWhite(x, y-height*3) && !verifBlackAndWhite(x, y-height*4)) 
						{tabAutor[k+i][4][1]=y+9999-5*height ; tabAutor[k+i][4][0]=x+9999 ;}
					if( !verifBlackAndWhite(x, y-height) && !verifBlackAndWhite(x, y-height*2) && !verifBlackAndWhite(x, y-height*3) && !verifBlackAndWhite(x, y-height*4) && !verifBlackAndWhite(x, y-height*5))
						{tabAutor[k+i][25][1]=y+9999-6*height ; tabAutor[k+i][25][0]=x+9999;}
					if( !verifBlackAndWhite(x, y-height) && !verifBlackAndWhite(x, y-height*2) && !verifBlackAndWhite(x, y-height*3) && !verifBlackAndWhite(x, y-height*4)  && !verifBlackAndWhite(x, y-height*5)&& !verifBlackAndWhite(x, y-height*6))
						{tabAutor[k+i][26][1]=y+9999-height*7 ; tabAutor[k+i][26][0]=x+9999;}
				}	
				//******************cavalier*********	
				x=tabPos[6+k][0];y=tabPos[6+k][1];
				tabAutor[k+6][0][0]=x+9999+2*width ; tabAutor[k+6][0][1]=y+9999+height;
				tabAutor[k+6][1][0]=x+9999+2*width ; tabAutor[k+6][1][1]=y+9999-height;
				tabAutor[k+6][2][0]=x+9999-2*width ; tabAutor[k+6][2][1]=y+9999+height;
				tabAutor[k+6][3][0]=x+9999-2*width ; tabAutor[k+6][3][1]=y+9999-height;
				tabAutor[k+6][4][0]=x+9999+width ;  tabAutor[k+6][4][1]=y+9999+2*height;
				tabAutor[k+6][5][0]=x+9999+width ; tabAutor[k+6][5][1]=y+9999-2*height;
				tabAutor[k+6][6][0]=x+9999-width ; tabAutor[k+6][6][1]=y+9999+2*height;
				tabAutor[k+6][7][0]=x+9999-width ; tabAutor[k+6][7][1]=y+9999-2*height;
				
				//cavalierWhite2;
				x=tabPos[7+k][0];y=tabPos[7+k][1];
				tabAutor[k+7][0][0]=x+9999+2*width ; tabAutor[k+7][0][1]=y+9999+height;
				tabAutor[k+7][1][0]=x+9999+2*width ; tabAutor[k+7][1][1]=y+9999-height;
				tabAutor[k+7][2][0]=x+9999-2*width ; tabAutor[k+7][2][1]=y+9999+height;
				tabAutor[k+7][3][0]=x+9999-2*width ; tabAutor[k+7][3][1]=y+9999-height;
				tabAutor[k+7][4][0]=x+9999+width ;  tabAutor[k+7][4][1]=y+9999+2*height;
				tabAutor[k+7][5][0]=x+9999+width ; tabAutor[k+7][5][1]=y+9999-2*height;
				tabAutor[k+7][6][0]=x+9999-width ; tabAutor[k+7][6][1]=y+9999+2*height;
				tabAutor[k+7][7][0]=x+9999-width ; tabAutor[k+7][7][1]=y+9999-2*height;
			
			k+=16;	
	}	
				

		for(int i=8;i<16;i++) {
			x=tabPos[i][0];y=tabPos[i][1];
			if(y==height*6+37 && !verifBlackAndWhite(x, y-height*2) &&!verifBlackAndWhite(x, y-height)) 
				{tabAutor[i][0][1]=y+9999-height*2 ; tabAutor[i][0][0]=x+9999;}
			if(!verifBlackAndWhite(x, y-height)) 
				{tabAutor[i][1][1]=y+9999-height ; tabAutor[i][1][0]=x+9999;}
			if(verifBlack(x+width,y-height))
				{tabAutor[i][2][0]=x+9999+width ; tabAutor[i][2][1]=y+9999-height ;}
			if(verifBlack(x-width,y-height)) 
				{tabAutor[i][3][0]=x+9999-width ; tabAutor[i][3][1]=y+9999-height ;}
		}
		for(int i=24;i<32;i++) {
			x=tabPos[i][0];y=tabPos[i][1];
			if(y==height+37 && !verifBlackAndWhite(x, y+height*2) &&!verifBlackAndWhite(x, y+height)) 
				{tabAutor[i][0][1]=y+9999+height*2 ; tabAutor[i][0][0]=x+9999 ;}
			if( !verifBlackAndWhite(x, y+height)) 
				{tabAutor[i][1][1]=y+9999+height ; tabAutor[i][1][0]=x+9999;}
			if(verifWhite(x+width,y+height))
				{tabAutor[i][2][0]=x+9999+width ; tabAutor[i][2][1]=y+9999+height ;}
			if(verifWhite(x-width,y+height)) 
				{tabAutor[i][3][0]=x+9999-width ; tabAutor[i][3][1]=y+9999+height ;}
		}	
		for(int i=0;i<16;i++) {
			for(int j=0;j<56;j++) {
				if(tabAutor[i][j][0]>=9999 && tabAutor[i][j][1]>=9999) {
					tabAutor[i][j][0]-=9999;
					tabAutor[i][j][1]-=9999;
				}
				else {
					tabAutor[i][j][0]=2000;
					tabAutor[i][j][1]=2000;
				}
				if(verifWhite(tabAutor[i][j][0], tabAutor[i][j][1])|| tabAutor[i][j][0]>width*7 || tabAutor[i][j][0]<0 || tabAutor[i][j][1]>height*7+37 || tabAutor[i][j][1]<37) {
					tabAutor[i][j][0]=2000;
					tabAutor[i][j][1]=2000;
				}
			}
		}
		for(int i=16;i<32;i++) {
			for(int j=0;j<56;j++) {
				if(tabAutor[i][j][0]>=9999 && tabAutor[i][j][1]>=9999) {
					tabAutor[i][j][0]-=9999;
					tabAutor[i][j][1]-=9999;
				}
				else {
					tabAutor[i][j][0]=2000;
					tabAutor[i][j][1]=2000;
				}
				if(verifBlack(tabAutor[i][j][0], tabAutor[i][j][1])|| tabAutor[i][j][0]>width*7 || tabAutor[i][j][0]<0 || tabAutor[i][j][1]>height*7+37 || tabAutor[i][j][1]<37) {
					tabAutor[i][j][0]=2000;
					tabAutor[i][j][1]=2000;
				}
			}
		}
		return tabAutor;
	}

	public void remove(int j) {
		boolean bool=false;
		for(int i=1;i<32;i++) {
			if(tabPiece[j]!=tabPiece[i] && tabPos[j][0]==tabPos[i][0] && tabPos[j][1]==tabPos[i][1]) {
				tabPos[i][0]+=9999;
				tabPos[i][1]+=9999;
				tabPiece[33]=tabPiece[i];
				bool=true;
			}
		}	
		if(!bool)
			tabPiece[33]=null;
	}
	
	public void anteRemove() {
		boolean bool=false;
		for (int i=1;i<32;i++) {
			if(tabPiece[33]==tabPiece[i]) {
				tabPos[i][0]-=9999;
				tabPos[i][1]-=9999;
			bool=true;
			}
		}
		if(!bool)
			imageEffacee=null;
	}
	 
	
	public boolean echec(ImageIcon roi) {
		int[][][] tabAutor=deplacementsAutorises();
		if(roi==tabPiece[0]) {
			for(int i=16;i<32;i++) {
				int[][] tab=tabAutor[i];
				for(int j=0;j<56;j++) {
					if(tab[j][0]==tabPos[0][0] && tab[j][1]==tabPos[0][1]) {
						return true;
					}
				}
			}
			return false;
		}
		else if(roi==tabPiece[16]) {
			for(int i=0;i<16;i++) {
				int[][] tab=tabAutor[i];
				for(int j=0;j<56;j++) {
					if(tab[j][0]==tabPos[16][0] && tab[j][1]==tabPos[16][1]) {
						return true;
					}
				}
			}
			return false;
		}
		return false;
	}
	
	
	public boolean echecMat() {
		if(piecesAppuyables().length>0)
			return false;
		return true;
	}

	public int[][] deplacementsVerifiees(int j){
		int[][] tabVerif=new int[56][2];
		int x=tabPos[j][0],y=tabPos[j][1];
		int k=0;
		boolean bool=true;
		int[][] tabAutor=deplacementsAutorises()[j];
		for(int i=0;i<56;i++) {
			tabPos[j][0]=tabAutor[i][0];
			tabPos[j][1]=tabAutor[i][1];
			remove(j);
			if(j<16) {
				bool=echec(tabPiece[0]);
			}
			else bool=echec(tabPiece[16]);
			if(!bool && tabAutor[i][0]<700 && tabAutor[i][1]>35) {
				tabVerif[k][0]=tabAutor[i][0];
				tabVerif[k][1]=tabAutor[i][1];
				k++;
			}
			anteRemove();
			tabPos[j][0]=x;
			tabPos[j][1]=y;
		}
		int[][] tabVerifFin=new int[k][2];
		for(int i=0;i<k;i++) {
			tabVerifFin[i]=tabVerif[i];
		}
		return tabVerif;
	}
	
	public boolean verifVerif(int j,int x,int y) {
		int[][] tabVerif=deplacementsVerifiees(j);
		for(int i=0;i<tabVerif.length;i++) {
			if(tabVerif[i][0]==x && tabVerif[i][1]==y)
				return true;
		}
		return false;
	}
	
	//VERIFIER CE QUI SUIT
	public ImageIcon[] piecesAppuyables() {
		int[][] tabVerif;
		ImageIcon[] tab = new ImageIcon[16];
		int k=0;
		ImageIcon[] tabAppuyable;
		if(intBool==0||intBool==1) {
			for(int i=0;i<16;i++) {
				tabVerif=deplacementsVerifiees(i);
				if(tabVerif.length>0) {
					tab[k]=tabPiece[i];
					k++;
				}
			}
		}
		
		else if(intBool==3||intBool==2) {
			for(int i=16;i<32;i++) {
				tabVerif=deplacementsVerifiees(i);
				tabVerif=deplacementsVerifiees(i);
				if(tabVerif.length>0) {
					tab[i-16]=tabPiece[i];
					k++;
				}		
			}
		}
		tabAppuyable=new ImageIcon[k];
		for(int i=0;i<k;i++) {
			tabAppuyable[i]=tab[i];
		}
		return tabAppuyable;
	}
	public boolean verifAppuyable(int j) {
		ImageIcon[] tabAppuyable=piecesAppuyables();
		for(int i=0;i<tabAppuyable.length;i++) {
			if(tabPiece[j]==tabAppuyable[i]) {
				return true;
			}
		}
		return false;
	}
}
	
