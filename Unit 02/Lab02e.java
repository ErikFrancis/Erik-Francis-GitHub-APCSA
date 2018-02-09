//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

public class Lab02e
{
	
	public void areaofcircle(double rad) {
		double radius = rad;
		Circle area = new Circle();
		area.setRadius(radius);
		area.calculateArea();
		area.print();
		System.out.println();
	}
		
	public static void main( String[] args )
   {
		double radius1 = 7.5, radius2 = 10, radius3 = 72.534, radius4 = 55, radius5 = 101, radius6 = 99.952;
		
		Lab02e area = new Lab02e();
		
		area.areaofcircle(radius1);
		area.areaofcircle(radius2);
		area.areaofcircle(radius3);
		area.areaofcircle(radius4);
		area.areaofcircle(radius5);
		area.areaofcircle(radius6);
	
		
	}
}