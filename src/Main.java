
import javax.swing.*;

public class Main 
{
	public static void main(String[] args)
	{
		Work work = new Work();
		work.AmountAn = 1000;//��������� ���-�������� ��������
		work.AmountPl = 500;//��������� ���-�� ��������
		work.ratioOfPredatorToAll = 0.5;//���� ==0, �� ��������� �������
		FrameOfPopulation frame = new FrameOfPopulation(work);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
