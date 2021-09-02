
public class Emboss implements Filter{
	public void filter(PixelImage pi)  {
		  Pixel[][] data = pi.getData();
		  for (int i = 0;i<pi.getHeight()-1;i++){
		   for(int j = 0; j<pi.getWidth()-1;j++){
		    data[i][j].red= Math.min(Math.abs(data[i][j].red - data[i+1][j+1].red+100), 255);
		    data[i][j].blue= Math.min(Math.abs(data[i][j].blue - data[i+1][j+1].blue+100), 255);
		    data[i][j].green= Math.min(Math.abs(data[i][j].green - data[i+1][j+1].green+100), 255);
		 }
		   
		}
		  pi.setData(data);
		 }


}
