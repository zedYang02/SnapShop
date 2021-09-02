
public class Laplacian implements Filter {

	public void filter(PixelImage pi) {
		
		int[][] coefficients = {{-1,-1,-1},{-1,8,-1},{-1,-1,-1}};
		pi.imageTransformation(coefficients);
		
}
}
