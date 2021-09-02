
public class NegativeFilter implements Filter {
	public void filter(PixelImage pi) {
		Pixel[][] data = pi.getData();
		
		for(int row=0;row<pi.getHeight();row++) {
			for(int col=0;col<pi.getWidth();col++) {
				data[row][col].blue = 255-data[row][col].blue;
				data[row][col].red = 255-data[row][col].red;
				data[row][col].green = 255-data[row][col].green;
			}
		}
		pi.setData(data);
	}
}
