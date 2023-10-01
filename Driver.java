public class Driver {
public static void main(String [] args) {
Polynomial p = new Polynomial();
System.out.println(p.evaluate(3));
double [] c1 = {2,3};
int [] c2 ={0, 1};
Polynomial p1 = new Polynomial(c1, c2);
double [] d1 = {2,3,4};
int [] d2 = {1,2,3};
Polynomial p2 = new Polynomial(d1, d2);
Polynomial s = p1.add(p2);
System.out.println("the Polynomial s (2 + 5x + 3x^2 + 4x^3) when x=2 is " + s.evaluate(2));
if(s.hasRoot(1))
System.out.println("1 is a root of s");
else
System.out.println("1 is not a root of s");

Polynomial mutiplied = p1.multiply(p2);

System.out.println("the Polynomial p1 (2+3x) mutiplied by Polynomial p2 (2x+3x^2+4x^3), when x = 2 is " + mutiplied.evaluate(2));

//p2.saveToFile("C:\\Users\\56377\\b07lab1\\saving.txt");
//Polynomial reading = new Polynomial("C:\\Users\\56377\\b07lab1\\testing.txt");

System.out.println("I completed the saveToFile method and the constructor with File parameter, but I couldn't figure out how to test them");


}
}