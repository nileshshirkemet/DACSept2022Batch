import advertisement.*;

class BannerTest{
	public static double BannerPrice(Banner b, int copies){
		float rate = copies < 5 ? 0.8f  : 0.75f;
		return rate * copies * b.area();
	}


	public static void main(String[] args){
		Banner bn = new Banner();
        System.out.printf("Price of Regular Banner %f", BannerPrice(bn, 5)); 

		CurvedBanner cb = new CurvedBanner(0.5f);
        System.out.printf("Price of Regular Banner %f", BannerPrice(cb, 5)); 

	}




}
