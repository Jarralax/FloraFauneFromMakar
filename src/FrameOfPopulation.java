
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
		hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//полутона
		hints.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
		//выбор рендера
		hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		//выбор качества отрисовки цветов
		hints.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
	}
	
	public ViewPanel(Work work)
	{
		this.work = work;
		setBackground(new Color(15,159,11));
		this.work.createLife();
		hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//полутона
		hints.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
		//выбор рендера
		hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		//выбор качества отрисовки цветов
		hints.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		//параметры изображения
		g2.setRenderingHints(hints);
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
		
		//хищников
		/*
		g2.setPaint(Color.RED);
		for(int i=0;i<work.AmountAnP;i++)
		{
			ObjAn = work.anP.get(i);
			predator = new Rectangle2D.Double(ObjAn.x-sizeOfUnit/2, 
					ObjAn.y-sizeOfUnit/2,sizeOfUnit, sizeOfUnit);
			g2.fill(predator);
			g2.draw(predator);
		}//*/
		
		g2.setPaint(Color.RED);
		for(int i=0;i<work.AmountAnP;i++)
		{
			ObjAn = work.anP.get(i);
			predator = new GeneralPath();
			predator.moveTo(ObjAn.x, ObjAn.y-sizeOfPred);
			predator.lineTo(ObjAn.x+sizeOfPred*const1, ObjAn.y+0.5*sizeOfPred);
			predator.lineTo(ObjAn.x-sizeOfPred*const1, ObjAn.y+0.5*sizeOfPred);
			predator.closePath();
			g2.fill(predator);
			g2.draw(predator);
		}
		
		work.interaction();
		repaint();
	}
	
	private Work work;
	//параметры отрисовки
	private RenderingHints hints = new RenderingHints(null);
	private Rectangle2D herbivorous;//травоядное
	//private Rectangle2D predator;//хищник
	private GeneralPath predator;
	private Rectangle2D plant;//растение
	private Animals ObjAn;
	private Plants ObjPl;
	private int sizeOfUnit = 5;
	private double sizeOfPred = 2*sizeOfUnit/3.0;
	private double const1 = 0.866;//const для хищника = sqrt(3)/2
}