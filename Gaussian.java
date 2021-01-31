
public class Gaussian implements Filter {
	public void filter(PixelImage pi) {
		
		int[][] coefficients = {{1,2,1},{2,4,2},{1,2,1}};

		pi.imageTransformation(coefficients);
		
}
}
