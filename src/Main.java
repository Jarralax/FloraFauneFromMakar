
import javax.swing.*;

public class Main 
{
	public static void main(String[] args)
	{
		Work work = new Work();
		work.AmountAn = 1000;
		work.AmountPl = 500;
		work.ratioOfPredatorToAll = 0.01;
		int An = 1000;//��������� ���-�������� ��������
		int Pl = 500;//��������� ���-�� ��������
		FrameOfPopulation frame = new FrameOfPopulation(An, Pl, work);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}