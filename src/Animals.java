
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
		species = rand.nextInt()%2;
	}
	public Animals(double x, double y, int q)
	{
		species = q;//1-хищник, 0-травоядное
		this.x = x; this.y = y; 
		Random rand = new Random();
		species = rand.nextInt()%2;
	}
	public int species;//вид
	private int size;//размер
	private int appetite ;//аппетит
	private int radiusOfVisibility ;//радиус видимости
	private int floor;//пол - не тот "пол"
	private int speed;//скорость
	private int endurance;//выносливость
	private int radiusOfUse;//радиус взаимодействия
	public double x;
	public double y;
}
