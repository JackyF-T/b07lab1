//lab 2 polynomial code

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
	
	public Polynomial add(Polynomial p1)
	{	
		int len = 0;
		
		for(int i=0; i<this.exponent.length; i++)
		{
			
		}

		double [] temp = new double[len];
		double [] tempExp = new int[len];
		
		for(int i = 0; i<len; i++){
			temp[i]=0.0;
			tempExp[i]=0;
		}
		for(int i = 0; i<this.exponent.length; i++){
			temp[i]+=this.array[i];
			tempExp[i]+=this.exponent[i];

		}
		
		
		for(int i = 0; i<p1.exponent.length; i++){
			for(int j=0;j<this.exponent.length; j++){
				boolean sameExp=false;
				if(this.exponent[j]==p1.exponent[i]){
					this.array[j]+=p1.array[i];
					sameExp = true;
					break;
				}

			}
		}
		
		return new Polynomial(temp, tempExp);
		
	}
	
	public double evaluate(double x){
		double result = 0.0;
		for(int i = 0; i<this.array.length; i++){
			result += array[i]*(Math.pow(x, i));
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















