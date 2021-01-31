
public class Exp3 implements Filter{
	public void filter(PixelImage pi) {
		Pixel[][] data = pi.getData();
		for (int i = 1;i<pi.getHeight()-1;i++){
			for(int j = 1; j<pi.getWidth()-1;j++){
				data[i][j].red = (data[i][j].blue +data[i-1][j-1].red+data[i+1][j+1].green)/3;
				data[i][j].blue =(data[i][j].blue +data[i-1][j-1].red+data[i+1][j+1].green)/3;
				data[i][j].green = (data[i][j].blue +data[i-1][j-1].red+data[i+1][j+1].green)/3;
			}
		}
		pi.setData(data);
	}
}
