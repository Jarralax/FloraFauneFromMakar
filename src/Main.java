
import javax.swing.*;

public class Main 
{
	public static void main(String[] args)
	{
		Work work = new Work();
		work.AmountAn = 1000;//начальное кол-личество животных
		work.AmountPl = 500;//начальное кол-во растений
		work.ratioOfPredatorToAll = 0.5;//если ==0, то случайным образом
		FrameOfPopulation frame = new FrameOfPopulation(work);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
