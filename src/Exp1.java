
public class Exp1 implements Filter{

	public void filter(PixelImage pi) {
		Pixel[][] data = pi.getData();
		Pixel[][] data1 = pi.getData();
		for (int i = 1;i<pi.getHeight()-1;i++){
			for(int j = 1; j<pi.getWidth()-1;j++){
				data1[i][j].red=(data[i][j].green+data[i-1][j-1].green+data[i+1][j+1].green
						+data[i-1][j].green+data[i-1][j+1].green+data[i][j-1].green
						+data[i][j+1].green+data[i+1][j-1].green+data[i+1][j].green)/9;
				data1[i][j].blue=(data[i][j].red+data[i-1][j-1].red+data[i+1][j+1].red
						+data[i-1][j].red+data[i-1][j+1].red+data[i][j-1].red
						+data[i][j+1].red+data[i+1][j-1].red+data[i+1][j].red)/9;
				data1[i][j].green=(data[i][j].blue+data[i-1][j-1].blue+data[i+1][j+1].blue
						+data[i-1][j].blue+data[i-1][j+1].blue+data[i][j-1].blue
						+data[i][j+1].blue+data[i+1][j-1].blue+data[i+1][j].blue)/9;
			}
		}
		pi.setData(data1);
	}
}
