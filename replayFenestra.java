package cms_chess;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class replayFenestra extends JFrame implements ActionListener{
	JButton boutonRejouer = new JButton("Rejouer");
	String ch;
	public replayFenestra(String str) {
		ch=str;
		Toolkit tkit=Toolkit.getDefaultToolkit();
		Dimension dimMoniteur=tkit.getScreenSize();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(dimMoniteur.width/2-400/2,dimMoniteur.height/2-200/2,400,200);
		setResizable(false);
		setVisible(true);
		repaint();
		add(boutonRejouer,"South");
		boutonRejouer.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new ChessFenestraAmelioree();
	}
	public void paint(Graphics g) {
		if(ch=="Les Blancs ont perdu") {
			g.setColor(Color.black);
			g.fillRect(0, 0, 400,200);
			g.setColor(Color.white);
			
		}else {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, 400, 200);
			g.setColor(Color.black);
		}
		g.setFont(new Font("Arial",Font.BOLD,36));
		g.drawString(ch, 20, 100);
	}

}




