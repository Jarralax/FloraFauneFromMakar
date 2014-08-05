
import java.util.*;

public class Work 
{
	//функции задающие кол-во животных и растений
	public void setAn(int q){AmountAn = q;}
	public void setPl(int q){AmountPl = q;}
	public void setRand()
	{
		Random rand = new Random();
		AmountAn = rand.nextInt(MaxAmountAn);//задается максимальное кол-во жив-х
		AmountPl = rand.nextInt(MaxAmountPl);//задается максимальное кол-во раст-ий
	}
	
	//функция для создания всех животных и растений
	public void createLife()
	{
		Random rand = new Random();
		Animals tempA; Plants tempP;
		//если не задано соотношение между хищниками и травоядными
		if(ratioOfPredatorToAll==0)
		{
			for(int i=0;i<AmountAn;i++)
			{//создаем животных
				tempA = new Animals(rand.nextDouble()*998, rand.nextDouble()*799);
				if(tempA.species==1)
					anP.add(tempA);
				else
					anH.add(tempA);
			}
			//сколько получилось хищников и травоядных
			AmountAnP = anP.size();
			AmountAnH = anH.size();
		}
		else
		{
			for(int i=0;i<AmountAn*(1-ratioOfPredatorToAll);i++)
			{//создаем травоядных
				tempA = new Animals(rand.nextDouble()*998, rand.nextDouble()*799,0);
				anH.add(tempA);
			}
			for(int i=0;i<AmountAn*ratioOfPredatorToAll;i++)
			{//создаем хищников
				tempA = new Animals(rand.nextDouble()*998, rand.nextDouble()*799,1);
				anP.add(tempA);
			}
			//сколько получилось хищников и травоядных
			AmountAnP = anP.size();
			AmountAnH = anH.size();
		}
		for(int i=0;i<AmountPl;i++)
		{//создаем растения
			tempP = new Plants(rand.nextDouble()*998, rand.nextDouble()*799);
			pl.add(tempP);
		}
	}
	
	//фейковая функция взаимодействия
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
	
	public int AmountAn;//кол-во животных
	public int AmountPl;//кол-во растений
	private int MaxAmountAn=100;//максимальное кол-во животных
	private int MaxAmountPl=50;//максимальное кол-во растений
	public int AmountAnP;//кол-во хищников
	public int AmountAnH;//кол-во травоядных
	public ArrayList<Animals> anP = new ArrayList<Animals>();
	public ArrayList<Animals> anH = new ArrayList<Animals>();
	public ArrayList<Plants> pl = new ArrayList<Plants>();
	public double ratioOfPredatorToAll = 0;
}
