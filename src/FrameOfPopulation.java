
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class FrameOfPopulation extends JFrame
{
	public FrameOfPopulation(int An, int Pl, Work work)
	{
		setSize(W,H);
		setTitle("Популяция");
		pan = new ViewPanel(An, Pl, work);
		add(pan);
	}
	
	public FrameOfPopulation(Work work)
	{
		setSize(W,H);
		setTitle("Популяция");
		pan =  new ViewPanel(work);
		add(pan);
	}
	
	private int W = 1020, H = 820;
	public ViewPanel pan; 
}

class ViewPanel extends JPanel
{
	public ViewPanel(int An, int Pl, Work work)
	{
		this.work = work;
		setBackground(new Color(15,159,11));
		this.work.setAn(An); this.work.setPl(Pl);
		this.work.createLife();
	}
	
	public ViewPanel(Work work)
	{
		this.work = work;
		setBackground(new Color(15,159,11));
		this.work.setRand();
		this.work.createLife();
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//рисуем растения
		g2.setPaint(Color.YELLOW);
		for(int i=0;i<work.AmountPl;i++)
		{
			ObjPl = work.pl.get(i);
			plant = new Rectangle2D.Double(ObjPl.x-sizeOfUnit/2, 
					ObjPl.y-sizeOfUnit/2, sizeOfUnit, sizeOfUnit);
			g2.setPaint(Color.YELLOW);
			g2.fill(plant);
			g2.draw(plant);
		}
		//хищников
		g2.setPaint(Color.RED);
		for(int i=0;i<work.AmountAnP;i++)
		{
			ObjAn = work.anP.get(i);
			predator = new Rectangle2D.Double(ObjAn.x-sizeOfUnit/2, 
					ObjAn.y-sizeOfUnit/2,sizeOfUnit, sizeOfUnit);
			g2.fill(predator);
			g2.draw(predator);
		}
		//травоядных
		g2.setPaint(Color.BLUE);
		for(int i=0;i<work.AmountAnH;i++)
		{
			ObjAn = work.anH.get(i);
			herbivorous = new Rectangle2D.Double(ObjAn.x-sizeOfUnit/2, 
					ObjAn.y-sizeOfUnit/2, sizeOfUnit, sizeOfUnit);
			g2.fill(herbivorous);
			g2.draw(herbivorous);
		}
		
		
		work.interaction();
		repaint();
	}
	
	private Work work;
	private Rectangle2D herbivorous;//травоядное
	private Rectangle2D predator;//хищник
	private Rectangle2D plant;//растение
	private Animals ObjAn;
	private Plants ObjPl;
	private int sizeOfUnit = 3;
}