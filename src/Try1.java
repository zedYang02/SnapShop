
import java.util.Random;

public class Try1 implements Filter{
 
 public void filter(PixelImage pi) {
  Pixel[][] data = pi.getData();
  for (int i=4; i< pi.getHeight()-6; i++) {
   for (int j=4; j<pi.getWidth()-6; j++) {
    int value1= new Random().nextInt(6);
    int value2= new Random().nextInt(6);
    data[i][j].red = data[i+value1][j+value2].red;
    data[i][j].green = data[i+value1][j+value2].green;
    data[i][j].blue = data[i+value1][j+value2].blue;
    
   }
  }
  pi.setData(data);
 }
   }