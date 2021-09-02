
public class Edgy implements Filter {
	
	public void filter(PixelImage pi) {
		
		int[][] coefficients = {{-1,-1,-1},{-1,9,-1},{-1,-1,-1}};
	    pi.imageTransformation(coefficients);
		

}
}
