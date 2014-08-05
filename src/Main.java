
import javax.swing.*;

public class Main 
{
	public static void main(String[] args)
	{
		Work work = new Work();
		work.AmountAn = 1000;
		work.AmountPl = 500;
		work.ratioOfPredatorToAll = 0.01;
		int An = 1000;//начальное кол-личество животных
		int Pl = 500;//начальное кол-во растений
		FrameOfPopulation frame = new FrameOfPopulation(An, Pl, work);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
