public class Polynomial{
	double [] array;

	public Polynomial(){
		this.array=new double[]{0.0};
	}
	
	public Polynomial(double [] a1){
		this.array = a1;
	}
	
	public Polynomial add(Polynomial p1)
	{	
		int len = 0;
		
		if(array.length<p1.array.length){
			len = p1.array.length;
		}else{
			len = array.length;
		}
		double [] temp = new double[len];
		
		for(int i = 0; i<len; i++){
			temp[i]=0.0;
		}
		for(int i = 0; i<this.array.length; i++){
			temp[i]+=this.array[i];
		}
		
		
		for(int i = 0; i<p1.array.length; i++){
			temp[i] +=p1.array[i];
		}
		
		return new Polynomial(temp);
		
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















