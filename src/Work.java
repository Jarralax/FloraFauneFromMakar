
import java.util.*;

public class Work 
{
	//������� �������� ���-�� �������� � ��������
	public void setAn(int q){AmountAn = q;}
	public void setPl(int q){AmountPl = q;}
	public void setRand()
	{
		Random rand = new Random();
		AmountAn = rand.nextInt(MaxAmountAn);//�������� ������������ ���-�� ���-�
		AmountPl = rand.nextInt(MaxAmountPl);//�������� ������������ ���-�� ����-��
	}
	
	//������� ��� �������� ���� �������� � ��������
	public void createLife()
	{
		Random rand = new Random();
		Animals tempA; Plants tempP;
		//���� �� ������ ����������� ����� ��������� � �����������
		if(ratioOfPredatorToAll==0)
		{
			for(int i=0;i<AmountAn;i++)
			{//������� ��������
				tempA = new Animals(rand.nextDouble()*998, rand.nextDouble()*799);
				if(tempA.species==1)
					anP.add(tempA);
				else
					anH.add(tempA);
			}
			//������� ���������� �������� � ����������
			AmountAnP = anP.size();
			AmountAnH = anH.size();
		}
		else
		{
			for(int i=0;i<AmountAn*(1-ratioOfPredatorToAll);i++)
			{//������� ����������
				tempA = new Animals(rand.nextDouble()*998, rand.nextDouble()*799,0);
				anH.add(tempA);
			}
			for(int i=0;i<AmountAn*ratioOfPredatorToAll;i++)
			{//������� ��������
				tempA = new Animals(rand.nextDouble()*998, rand.nextDouble()*799,1);
				anP.add(tempA);
			}
			//������� ���������� �������� � ����������
			AmountAnP = anP.size();
			AmountAnH = anH.size();
		}
		for(int i=0;i<AmountPl;i++)
		{//������� ��������
			tempP = new Plants(rand.nextDouble()*998, rand.nextDouble()*799);
			pl.add(tempP);
		}
	}
	
	//�������� ������� ��������������
	public void interaction()
	{
		Random rand = new Random();
		Animals tempA; Plants tempP;
		for(int i=0;i<AmountAnP;i++)
		{
			tempA = anP.get(i);
			tempA.x += rand.nextDouble()*8-4; 
			tempA.y += rand.nextDouble()*8-4;
			anP.set(i, tempA);
		}
		
		for(int i=0;i<AmountAnH;i++)
		{
			tempA = anH.get(i);
			tempA.x += rand.nextDouble()*8-4; 
			tempA.y += rand.nextDouble()*8-4;
			anH.set(i, tempA);
		}
		
		/*
		for(int i=0;i<AmountPl;i++)
		{
			tempP = pl.get(i);
			tempP.x++; tempP.y++;
			pl.set(i, tempP);
		}//*/
		try{Thread.sleep(1);}
		catch(Exception e){}
	}
	
	public int AmountAn;//���-�� ��������
	public int AmountPl;//���-�� ��������
	private int MaxAmountAn=100;//������������ ���-�� ��������
	private int MaxAmountPl=50;//������������ ���-�� ��������
	public int AmountAnP;//���-�� ��������
	public int AmountAnH;//���-�� ����������
	public ArrayList<Animals> anP = new ArrayList<Animals>();
	public ArrayList<Animals> anH = new ArrayList<Animals>();
	public ArrayList<Plants> pl = new ArrayList<Plants>();
	public double ratioOfPredatorToAll = 0;
}
