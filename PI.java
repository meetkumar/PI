public class PI{
public static void main(String[] args)
{
        float xf= 1,xl=0,oldpi=0,newpi=0;
        int  n=1;
        n=trap(n,oldpi,newpi);
        mp(n,newpi,xf,xl);
        smp(n,newpi,xf,xl);
        mc();
}
public static float value(float v)
{
        //v=v*v;
        return (float) (4*Math.sqrt(1-(v*v)));
}
//Trapezoidal method for obtaining pi and number of intervals 
public static int trap(int n,float oldpi,float newpi)
{
 float interval;

 for(n=1;oldpi<=newpi;n++)
 {
	 oldpi=newpi;
     interval=(float)1/n;
     newpi=0;
     int i=1;
     while(i<=n)
     {
         newpi+=interval*((value((i-1) *interval) + value((i)*interval))/2.0);
         i++;
     }
     if(oldpi>=newpi)
     {
    	 System.out.println("Trapezoidal pi is "+oldpi);
         System.out.println("The number of intervals is "+n);
     }
}
return n;
}
//Mid-point method for pi value
public static void mp(int n,float newpi,float xf,float xl)
{

        float interval;
        n=n-1;
        interval=(float)1/n;
        while(n>0)
        {
                xf=xl;
                xl+=interval;
                newpi=newpi+ (xl-xf) * value((float) ((xf+xl)/2.0));
                n--;
        }
        System.out.println("MidPoint method pi is "+newpi);
}
//Simpsons method for pi value
public static void smp(int n,float newpi,float xf,float xl)
{
        float interval;
        //n=(int) (n/1.5);
        interval=(float)1/n;
        while(n>0)
        {
                xf=xl;
                xl+=interval;
                newpi=newpi+ ((xl-xf)/6) * (value(xf)+ (4*value((float) ((xf+xl)/2.0))) + value(xl));
                n--;
        }
        System.out.println("Simpsons pi is "+newpi);
}
//Monte-Carlo
public static void mc()
{
	int i;                                                               
  	 int nThrows = 0;                                             
  	 int nSuccess = 0;                                            
  									
  	 float x, y;                                                 
  									
  	 for (i = 0; i < 100000 ; i++)                         
  	 {                                                            
  	    x = (float) Math.random();      // Throw a dart                   
  	    y = (float) Math.random();                                                
  									
  	    nThrows++;                                                        
  									
  	    if ( x*x + y*y <= 1 )             
  	       nSuccess++;                                               
  	 }                                                            
  	 System.out.println("Monte Carlo Pi is " + 4*(float)nSuccess/(float)nThrows );
}
}