
public class Sepia implements Filter{

	public void filter(PixelImage pi)  {
		  Pixel[][] data1 = pi.getData();
		  Pixel[][] data2 = pi.getData();
		  for (int i = 0;i<pi.getHeight();i++){
		   for(int j = 0; j<pi.getWidth();j++){
			   data2[i][j].red=(int)(0.393*data1[i][j].red+0.769*data1[i][j].green
					   +0.189*data1[i][j].blue);
			   data2[i][j].green=(int)(0.349*data1[i][j].red+0.686*data1[i][j].green
					   +0.168*data1[i][j].blue);
			   data2[i][j].blue=(int)(0.272*data1[i][j].red+0.534*data1[i][j].green
					   +0.131*data1[i][j].blue);
			   if(data2[i][j].red>255) {
				   data2[i][j].red=255;
			   }
			   if(data2[i][j].green>255) {
				   data2[i][j].green=255;
			   }
			   if(data2[i][j].blue>255) {
				   data2[i][j].blue=255;
			   }
		   }
		  }
		  pi.setData(data2);
	}
}
