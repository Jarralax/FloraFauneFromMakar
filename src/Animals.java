
import java.util.*;

public class Animals 
{
	public Animals(int a, int b, int c, int d, int e, int f, int g, int h)
	{
		species = a;
		size = b;
		appetite = c;
		radiusOfVisibility = d;
		floor = e;
		speed = f;
		endurance = g;
		radiusOfUse = h;
	}
	public Animals(double x, double y)
	{
		this.x = x; this.y = y; 
		Random rand = new Random();
		if(rand.nextBoolean())
			species = 1;
		
	}
	public Animals(double x, double y, int q)
	{
		species = q;//1-������, 0-����������
		this.x = x; this.y = y; 
		Random rand = new Random();
		species = rand.nextInt()%2;
	}
	public int species = 0;//���
	private int size;//������
	private int appetite ;//�������
	private int radiusOfVisibility ;//������ ���������
	private int floor;//��� - �� ��� "���"
	private int speed;//��������
	private int endurance;//������������
	private int radiusOfUse;//������ ��������������
	public double x;
	public double y;
}
