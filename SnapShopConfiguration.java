

/**
 * A class to configure the SnapShop application
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class SnapShopConfiguration {
	/**
	 * Method to configure the SnapShop. Call methods like addFilter and
	 * setDefaultFilename here.
	 * 
	 * @param theShop
	 *            A pointer to the application
	 */
	public static void configure(SnapShop theShop) {

		theShop.setDefaultFilename("billg.jpg");
		theShop.addFilter(new FlipHorizontalFilter(), "Flip Horizontal");
		theShop.addFilter(new FilpVerticalFilter(), "Flip Vertical");
		theShop.addFilter(new NegativeFilter(),"Negative");
		theShop.addFilter(new Gaussian(),"Gaussian");
		theShop.addFilter(new Laplacian(),"Laplacian");
		theShop.addFilter(new UnsharpMasking(),"Unsharp masking");
		theShop.addFilter(new Edgy(),"Edgy");
		theShop.addFilter(new BlackAndWhite(),"BlackAndWhite");
		theShop.addFilter(new Exp3(),"Exp3");
		theShop.addFilter(new Exp1(),"Exp1");
		theShop.addFilter(new Exp2(),"Exp2");
		theShop.addFilter(new Emboss(),"Emboss");
		theShop.addFilter(new SmoothImage(),"Smooth");
		theShop.addFilter(new Sepia(),"Sepia");
	}
}
