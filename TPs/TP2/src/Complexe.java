public class Complexe implements Comparable {
	private float re;
	private float im;
	public Complexe(float r,float i) {
		re = r;
		im=i;
	}
	

public int compareTo(Complexe A) {
	if(re == A.re && im == A.im)
		return 1;
	else
		return 0;
}


@Override
public int compareTo(Object arg0) {
	if (this.getClass().equals(arg0.getClass()))
		return 1;
	return 0;
}



}