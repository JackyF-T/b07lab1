//lab 2 polynomial code

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Arrays;
public class Polynomial{
	double [] array;
	int [] exponent;

	public Polynomial(){
		this.array=new double[]{0.0};
		this.exponent= new int[]{0};
	}
	
	public Polynomial(double [] a1, int [] a2){
		this.array = a1;
		this.exponent = a2;
	}

	public Polynomial(File file) throws Exception{
		BufferedReader b = new BufferedReader(new FileReader(file));
		String line = b.readLine();
		String[] terms = line.split("\\+");

		this.array = new double[terms.length];
    	this.exponent = new int[terms.length];

		for (int i = 0; i < terms.length; i++) {
			String term = terms[i];
			String[] duo = term.split("x");
			if(duo.length>=1){
			this.array[i]=(Double.parseDouble(duo[0]));
			this.exponent[i]=(Integer.parseInt(duo[1]));
			}else{
				this.array[i]=(Double.parseDouble(duo[0]));
				this.exponent[i]=0;
			}
		}

		b.close();


	}


	public void saveToFile(String fileName) throws Exception {

		PrintStream output = new PrintStream(fileName);
		StringBuilder polynomialString = new StringBuilder();

		for(int i = 0; i<array.length;i++){
			if (array[i] < 0 && polynomialString.length() > 0) {
                polynomialString.append("-");
            }
            polynomialString.append(Math.abs(array[i]));
            
            
            if (exponent[i] != 0) {
                polynomialString.append("x");
            }
            
            if (exponent[i] > 1) {
                polynomialString.append(exponent[i]);
            }
            
            if (i < array.length - 1) {
                polynomialString.append("+");
            }
		}

		output.println(polynomialString);
		output.close();


	}
	
	public Polynomial add(Polynomial p1)
	{	
		int maxSize = Math.max(Arrays.stream(this.exponent).max().getAsInt(), Arrays.stream(p1.exponent).max().getAsInt()) + 1;

		double [] temp = new double[maxSize];
		int [] tempExp = new int[maxSize];
 		for (int i = 0; i < temp.length; i++) {
			temp[i]=0.0;
			tempExp[i]=0;
		}


		 for (int i = 0; i < array.length; i++) {
            temp[this.exponent[i]] += this.array[i];
            tempExp[this.exponent[i]] = this.exponent[i];
        }

		for (int i = 0; i < p1.array.length; i++) {
            temp[p1.exponent[i]] += p1.array[i];
            tempExp[p1.exponent[i]] = p1.exponent[i];
        }

		return new Polynomial(temp, tempExp);
	}

	public Polynomial multiply(Polynomial p1) {
        int maxSize = Arrays.stream(this.exponent).max().getAsInt() + Arrays.stream(p1.exponent).max().getAsInt() + 1;
        double[] temp = new double[maxSize];
        int[] tempExp = new int[maxSize];

 		for (int i = 0; i < temp.length; i++) {
			temp[i]=0.0;
			tempExp[i]=0;
		}


		 for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < p1.array.length; j++) {
                int exp = exponent[i] + p1.exponent[j];
                temp[exp] += array[i] * p1.array[j];
                tempExp[exp] = exp;
            }
        }




		return new Polynomial(temp, tempExp);
	}

	
	public double evaluate(double x){
		double result = 0.0;
		for(int i = 0; i<this.array.length; i++){
			result += array[i]*(Math.pow(x, exponent[i]));
		}
		return result;
	}
	
	public boolean hasRoot(double y){
		return (this.evaluate(y) == 0.0);
	}

}




//lab 1 code

// public class Polynomial{
// 	double [] array;

// 	public Polynomial(){
// 		this.array=new double[]{0.0};
// 	}
	
// 	public Polynomial(double [] a1){
// 		this.array = a1;
// 	}
	
// 	public Polynomial add(Polynomial p1)
// 	{	
// 		int len = 0;
		
// 		if(array.length<p1.array.length){
// 			len = p1.array.length;
// 		}else{
// 			len = array.length;
// 		}
// 		double [] temp = new double[len];
		
// 		for(int i = 0; i<len; i++){
// 			temp[i]=0.0;
// 		}
// 		for(int i = 0; i<this.array.length; i++){
// 			temp[i]+=this.array[i];
// 		}
		
		
// 		for(int i = 0; i<p1.array.length; i++){
// 			temp[i] +=p1.array[i];
// 		}
		
// 		return new Polynomial(temp);
		
// 	}
	
// 	public double evaluate(double x){
// 		double result = 0.0;
// 		for(int i = 0; i<this.array.length; i++){
// 			result += array[i]*(Math.pow(x, i));
// 		}
// 		return result;
// 	}
	
// 	public boolean hasRoot(double y){
// 		return (this.evaluate(y) == 0.0);
// 	}

// }















