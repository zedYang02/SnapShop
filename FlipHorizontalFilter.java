/**
 * Filter that flips the image horizontally. 
 */
public class FlipHorizontalFilter implements Filter {
	public void filter(PixelImage pi) {
		Pixel[][] data = pi.getData();

		for (int row = 0; row < pi.getHeight(); row++) {
			for (int col = 0; col < pi.getWidth() / 2; col++) {
				Pixel temp = data[row][col];
				data[row][col] = data[row][pi.getWidth() - col - 1];
				data[row][pi.getWidth() - col - 1] = temp;
			}
		}

		pi.setData(data);
	}
}
