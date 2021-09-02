
public class SmoothImage implements Filter {
  public void filter(PixelImage pi) {
   Pixel[][] data = pi.getData();
   for (int i = 1;i<pi.getHeight()-1;i++){
    for(int j = 1; j<pi.getWidth()-1;j++){
     if (data[i][j].red < 128) {
      data[i][j].red = 255 - data[i][j].red;
     }
     if (data[i][j].blue < 128) {
      data[i][j].blue = 255 - data[i][j].blue;
     }
     if (data[i][j].green < 128) {
      data[i][j].green = 255 - data[i][j].green;
     }
     
    }
   }
   pi.setData(data);
  }
  
}