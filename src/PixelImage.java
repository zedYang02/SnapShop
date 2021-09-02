
import java.awt.image.*;

/**
 * Provides an interface to a picture as an array of Pixels
 */
public class PixelImage {
	private BufferedImage myImage;
	private int width;
	private int height;

	/**
	 * Map this PixelImage to a real image
	 * 
	 * @param bi
	 *            The image
	 */
	public PixelImage(BufferedImage bi) {
		// initialise instance variables
		this.myImage = bi;
		this.width = bi.getWidth();
		this.height = bi.getHeight();
	}

	/**
	 * Return the width of the image
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Return the height of the image
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * Return the BufferedImage of this PixelImage
	 */
	public BufferedImage getImage() {
		return this.myImage;
	}

	/**
	 * Return the image's pixel data as an array of Pixels. The first coordinate
	 * is the x-coordinate, so the size of the array is [width][height], where
	 * width and height are the dimensions of the array
	 * 
	 * @return The array of pixels
	 */
	public Pixel[][] getData() {
		Raster r = this.myImage.getRaster();
		Pixel[][] data = new Pixel[r.getHeight()][r.getWidth()];
		int[] samples = new int[3];

		for (int row = 0; row < r.getHeight(); row++) {
			for (int col = 0; col < r.getWidth(); col++) {
				samples = r.getPixel(col, row, samples);
				Pixel newPixel = new Pixel(samples[0], samples[1], samples[2]);
				data[row][col] = newPixel;
			}
		}

		return data;
	}

	/**
	 * Set the image's pixel data from an array. This array matches that
	 * returned by getData(). It is an error to pass in an array that does not
	 * match the image's dimensions or that has pixels with invalid values (not
	 * 0-255)
	 * 
	 * @param data
	 *            The array to pull from
	 */
	public void setData(Pixel[][] data) {
		int[] pixelValues = new int[3]; // a temporary array to hold r,g,b
										// values
		WritableRaster wr = this.myImage.getRaster();

		if (data.length != wr.getHeight()) {
			throw new IllegalArgumentException("Array size does not match");
		} else if (data[0].length != wr.getWidth()) {
			throw new IllegalArgumentException("Array size does not match");
		}

		for (int row = 0; row < wr.getHeight(); row++) {
			for (int col = 0; col < wr.getWidth(); col++) {
				pixelValues[0] = data[row][col].red;
				pixelValues[1] = data[row][col].green;
				pixelValues[2] = data[row][col].blue;
				wr.setPixel(col, row, pixelValues);
			}
		}
	}

	
	// add a method to compute a new image given weighted averages
	public void imageTransformation(int [][] co) {
		
		Pixel [][] oldImage = getData();
		Pixel [][] newImage = getData();
		int sum=0;
		for(int m=0;m<3;m++) {
			for(int n=0;n<3;n++) {
				sum += co[m][n];
			}
		}
		if(sum==0) {
			sum=1;
		}
		
		
		for(int row=1;row<getHeight()-1;row++) {
			for(int col=1;col<getWidth()-1;col++) {
				int redSum=0;
				int blueSum=0;
				int greenSum=0;
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						blueSum+=oldImage[row+i-1][col+j-1].blue *
								co[i][j];
						
						redSum+=oldImage[row+i-1][col+j-1].red *
								co[i][j];
						
						
						greenSum+=oldImage[row+i-1][col+j-1].green *
								co[i][j];
						
					}
				}
				
				blueSum/= sum;
				redSum/= sum;
				greenSum/= sum;
				if(blueSum<0) {
					blueSum=0;
				}else if(blueSum>255) {
					blueSum=255;
				}
				if(redSum<0) {
					redSum=0;
				}else if(redSum>255) {
					redSum=255;
				}
				if(greenSum<0) {
					greenSum=0;
				}else if(greenSum>255) {
					greenSum=255;
				}
				newImage[row][col].blue = blueSum;
				newImage[row][col].red = redSum;
				newImage[row][col].green = greenSum;
				
			}
			
	}
		setData(newImage);
		
}
	
public Pixel[][] getMaximum(Pixel[][] oldImage) {
		
		Pixel [][] newImage = oldImage;
		for(int row=1;row<getHeight()-1;row++) {
			for(int col=1;col<getWidth()-1;col++) {
				int maxBlue = oldImage[row-1][col-1].blue;
				int maxRed = oldImage[row-1][col-1].red;
				int maxGreen = oldImage[row-1][col-1].green;
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						if(oldImage[row+i-1][col+j-1].blue>maxBlue) {
							maxBlue=oldImage[row+i-1][col+j-1].blue;
						}
						if(oldImage[row+i-1][col+j-1].red>maxRed) {
							maxRed=oldImage[row+i-1][col+j-1].red;
						}
						if(oldImage[row+i-1][col+j-1].green>maxGreen) {
							maxGreen=oldImage[row+i-1][col+j-1].green;
						}
					}
			}
				newImage[row][col].blue=maxBlue;
				newImage[row][col].red=maxRed;
				newImage[row][col].green=maxGreen;
		
}
}
		return newImage;
}
public Pixel[][] getMinimum(Pixel[][] oldImage) {
	
	Pixel [][] newImage = oldImage;
	for(int row=1;row<getHeight()-1;row++) {
		for(int col=1;col<getWidth()-1;col++) {
			int minBlue = oldImage[row-1][col-1].blue;
			int minRed = oldImage[row-1][col-1].red;
			int minGreen = oldImage[row-1][col-1].green;
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					if(oldImage[row+i-1][col+j-1].blue<minBlue) {
						minBlue=oldImage[row+i-1][col+j-1].blue;
					}
					if(oldImage[row+i-1][col+j-1].red<minRed) {
						minRed=oldImage[row+i-1][col+j-1].red;
					}
					if(oldImage[row+i-1][col+j-1].green<minGreen) {
						minGreen=oldImage[row+i-1][col+j-1].green;
					}
				}
		}
			newImage[row][col].blue=minBlue;
			newImage[row][col].red=minRed;
			newImage[row][col].green=minGreen;
	
}
}
	return newImage;
}
}

