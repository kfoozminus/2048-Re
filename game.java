import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class game extends JFrame{
	
	JLabel comment, newg;
	JLabel[][] cell = new JLabel[4][4];
	int[][] val = new int[4][4];
	boolean keyFlag, change;
	int i, j, ind;
	
	public game()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints c= new GridBagConstraints();
		
		Border border = BorderFactory.createLineBorder(new Color(188,174,161), 5);
		
		for(i=0; i<4; i++)
		{
			for(j=0; j<4; j++)
			{
				cell[i][j]=new JLabel();
				c.fill = GridBagConstraints.HORIZONTAL;
				c.gridx = j;
				c.gridy = i;
				c.ipadx = 5;
				c.ipady = 5;
				cell[i][j].setPreferredSize(new Dimension(75, 75));
				cell[i][j].setMaximumSize(new Dimension(75, 75));
				cell[i][j].setMinimumSize(new Dimension(75, 75));
				cell[i][j].setFont(new Font("Arial", Font.BOLD, 25));
				cell[i][j].setHorizontalAlignment(JLabel.CENTER);
				cell[i][j].setVerticalAlignment(JLabel.CENTER);
				cell[i][j].setOpaque(true);
				cell[i][j].setBorder(border);
				add(cell[i][j], c);
			}
		}
		
		comment = new JLabel("");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		c.ipadx = 5;
		c.ipady = 5;
		c.gridwidth = 4;
		add(comment, c);
		comment.setHorizontalAlignment(JLabel.CENTER);
		comment.setVerticalAlignment(JLabel.CENTER);
		comment.setFont(new Font("Arial", Font.BOLD, 15));
		//comment.setForeground(new Color(114,104,94));
		
		newg = new JLabel("");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		c.ipadx = 5;
		c.ipady = 5;
		c.gridwidth = 4;
		add(newg, c);
		newg.setHorizontalAlignment(JLabel.CENTER);
		newg.setVerticalAlignment(JLabel.CENTER);
		newg.setText("Press F2 to start a new game.");
		newg.setFont(new Font("Arial", Font.BOLD, 15));
		//comment.setForeground(new Color(114,104,94));
		
		event e = new event();
		addKeyListener(e);
		
		start();
		
	}
	
	public class event implements KeyListener
	{

		@Override
		public void keyPressed(KeyEvent e) {
			
			//if(keyFlag)
			{
				change = false;
				int keyCode = e.getKeyCode();
				if(keyCode == KeyEvent.VK_UP)
				{
					for(i=0; i<4; i++)
					{
						ind=0;
						for(j=0; j<4; j++)
						{
							if(val[j][i]!=0)
							{
								val[ind][i]=val[j][i];
								if(ind!=j)
								{
									val[j][i]=0;
									change=true;
								}
								ind++;
							}
						}
						if(val[0][i]!=0 && val[0][i]==val[1][i])
						{
							val[0][i]*=2;
							val[1][i]=val[2][i];
							val[2][i]=val[3][i];
							val[3][i]=0;
							if(val[1][i]!=0 && val[1][i]==val[2][i])
							{
								val[1][i]*=2;
								val[2][i]=0;
							}
							change=true;
						}
						else if(val[1][i]!=0 && val[1][i]==val[2][i])
						{
							val[1][i]*=2;
							val[2][i]=val[3][i];
							val[3][i]=0;
							change=true;
						}
						else if(val[2][i]!=0 && val[2][i]==val[3][i])
						{
							val[2][i]*=2;
							val[3][i]=0;
							change=true;
						}
					}
				}
				else if(keyCode == KeyEvent.VK_DOWN)
				{
					for(i=0; i<4; i++)
					{
						ind=3;
						for(j=3; j>=0; j--)
						{
							if(val[j][i]!=0)
							{
								val[ind][i]=val[j][i];
								if(ind!=j)
								{
									val[j][i]=0;
									change=true;
								}
								ind--;
							}
						}
						if(val[3][i]!=0 && val[3][i]==val[2][i])
						{
							val[3][i]*=2;
							val[2][i]=val[1][i];
							val[1][i]=val[0][i];
							val[0][i]=0;
							if(val[2][i]!=0 && val[2][i]==val[1][i])
							{
								val[2][i]*=2;
								val[1][i]=0;
							}
							change=true;
						}
						else if(val[2][i]!=0 && val[2][i]==val[1][i])
						{
							val[2][i]*=2;
							val[1][i]=val[0][i];
							val[0][i]=0;
							change=true;
						}
						else if(val[1][i]!=0 && val[1][i]==val[0][i])
						{
							val[1][i]*=2;
							val[0][i]=0;
							change=true;
						}
					}
				}
				else if(keyCode == KeyEvent.VK_LEFT)
				{
					for(i=0; i<4; i++)
					{
						ind=0;
						for(j=0; j<4; j++)
						{
							if(val[i][j]!=0)
							{
								val[i][ind]=val[i][j];
								if(ind!=j)
								{
									val[i][j]=0;
									change=true;
								}
								ind++;
							}
						}
						if(val[i][0]!=0 && val[i][0]==val[i][1])
						{
							val[i][0]*=2;
							val[i][1]=val[i][2];
							val[i][2]=val[i][3];
							val[i][3]=0;
							if(val[i][1]!=0 && val[i][1]==val[i][2])
							{
								val[i][1]*=2;
								val[i][2]=0;
							}
							change=true;
						}
						else if(val[i][1]!=0 && val[i][1]==val[i][2])
						{
							val[i][1]*=2;
							val[i][2]=val[i][3];
							val[i][3]=0;
							change=true;
						}
						else if(val[i][2]!=0 && val[i][2]==val[i][3])
						{
							val[i][2]*=2;
							val[i][3]=0;
							change=true;
						}
					}
				}
				else if(keyCode == KeyEvent.VK_RIGHT)
				{
					for(i=0; i<4; i++)
					{
						ind=3;
						for(j=3; j>=0; j--)
						{
							if(val[i][j]!=0)
							{
								val[i][ind]=val[i][j];
								if(ind!=j)
								{
									val[i][j]=0;
									change=true;
								}
								ind--;
							}
						}
						if(val[i][3]!=0 && val[i][3]==val[i][2])
						{
							val[i][3]*=2;
							val[i][2]=val[i][1];
							val[i][1]=val[i][0];
							val[i][0]=0;
							if(val[i][2]!=0 && val[i][2]==val[i][1])
							{
								val[i][2]*=2;
								val[i][1]=0;
							}
							change=true;
						}
						else if(val[i][2]!=0 && val[i][2]==val[i][1])
						{
							val[i][2]*=2;
							val[i][1]=val[i][0];
							val[i][0]=0;
							change=true;
						}
						else if(val[i][1]!=0 && val[i][1]==val[i][0])
						{
							val[i][1]*=2;
							val[i][0]=0;
							change=true;
						}
					}
				}
				else if(keyCode == KeyEvent.VK_F2)
				{
					start();
				}
				if(change)
				{
					newRandom();
					setPrint();
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			
		}
	}
	
	public void start()
	{
		keyFlag = true;
		for(i=0; i<4; i++)
		{
			for(j=0; j<4; j++)
			{
				val[i][j]=0;
			}
		}
		
		newRandom();
		newRandom();
		
		comment.setText("Use arrows to make move.");
		comment.setForeground(Color.black);
		
		setPrint();
		
	}
	
	public int status()
	{
		int stat=0;
		boolean nul=true;
		for(i=0; i<4; i++)
		{
			for(j=0; j<4; j++)
			{
				if(val[i][j]==2048)
				{
					stat=2;
					break;
				}
				if(val[i][j]==0)nul=false;
			}
		}
		if(nul)
		{
			stat=1;
		}
		if(stat==1)
		{
			for(i=0; i<4; i++)
			{
				for(j=1; j<4; j++)
				{
					if(val[i][j]==val[i][j-1] || val[j][i]==val[j-1][i])
					{
						stat=0;
						break;
					}
				}
				if(j<4)break;
			}
		}
		return stat;
	}
	
	public void newRandom()
	{
		int a = (int) (Math.random()*10) % 4;
		int b = (int) (Math.random()*10) % 4;
		if(val[a][b]!=0)newRandom();
		else val[a][b] = (((int) (Math.random()*10)%2)+1)*2;
	}
	
	public void setPrint()
	{
		int stat=status();
		for(i=0; i<4; i++)
		{
			for(j=0; j<4; j++)
			{
				if(val[i][j]==0)
				{
					cell[i][j].setBackground(new Color(205,193,179));
					cell[i][j].setForeground(Color.black);
					cell[i][j].setText(null);
				}
				else
				{
					cell[i][j].setText(String.valueOf(val[i][j]));
					switch(val[i][j])
					{
					case 2:
						cell[i][j].setBackground(new Color(238,228,218));
						cell[i][j].setForeground(new Color(114,104,94));
						break;
					case 4:
						cell[i][j].setBackground(new Color(236,224,200));
						cell[i][j].setForeground(new Color(110,107,92));
						break;
					case 8:
						cell[i][j].setBackground(new Color(242,177,121));
						cell[i][j].setForeground(new Color(255,248,231));
						break;
					case 16:
						cell[i][j].setBackground(new Color(245,150,96));
						cell[i][j].setForeground(new Color(252,248,237));
						break;
					case 32:
						cell[i][j].setBackground(new Color(255,117,106));
						cell[i][j].setForeground(new Color(252,248,237));
						break;
					case 64:
						cell[i][j].setBackground(new Color(246,93,59));
						cell[i][j].setForeground(new Color(252,248,237));
						break;
					case 128:
						cell[i][j].setBackground(new Color(223,174,72));
						cell[i][j].setForeground(new Color(252,248,237));
						break;
					case 256:
						cell[i][j].setBackground(new Color(228,169,51));
						cell[i][j].setForeground(new Color(252,248,237));
						break;
					case 512:
						cell[i][j].setBackground(new Color(225,168,37));
						cell[i][j].setForeground(new Color(252,248,237));
						break;
					case 1024:
						cell[i][j].setBackground(new Color(224,166,22));
						cell[i][j].setForeground(new Color(252,248,237));
						break;
					case 2048:
						cell[i][j].setBackground(new Color(236,194,48));
						cell[i][j].setForeground(new Color(252,248,237));
						break;
					}
				}
			}
		}
		if(stat==1)
		{
			comment.setText("Game Over! You lost!");
			comment.setForeground(new Color(246,93,59));
			keyFlag=false;
		}
		else if(stat==2)
		{
			comment.setText("Wow! You Win!");
			comment.setForeground(new Color(246,93,59));
			keyFlag=false;
		}
	}

	public static void main(String[] args) {
		
		game gui = new game();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		//gui.pack();
		gui.setSize(450, 450);
		gui.setTitle("2048");

	}

}