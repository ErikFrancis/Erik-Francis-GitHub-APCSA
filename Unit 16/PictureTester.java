/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("F:\\Documents\\Eclipse\\Unit 16\\src\\images\\beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  public static void testKeepOnlyBlue()
  {
    Picture beach = new Picture("F:\\Documents\\Eclipse\\Unit 16\\src\\images\\beach.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }
  
  public static void testKeepOnlyRed()
  {
    Picture beach = new Picture("F:\\Documents\\Eclipse\\Unit 16\\src\\images\\beach.jpg");
    beach.explore();
    beach.keepOnlyRed();
    beach.explore();
  }
  
  public static void testKeepOnlyGreen()
  {
    Picture beach = new Picture("F:\\Documents\\Eclipse\\Unit 16\\src\\images\\beach.jpg");
    beach.explore();
    beach.keepOnlyGreen();
    beach.explore();
  }
  /** method to test Negate */
  public static void testNegate()
  {
    Picture beach = new Picture("F:\\Documents\\Eclipse\\Unit 16\\src\\images\\beach.jpg");
	beach.explore();
	beach.Negate();
	beach.explore();
  }
  
  public static void testGrayscale()
  {
    Picture beach = new Picture("F:\\Documents\\Eclipse\\Unit 16\\src\\images\\beach.jpg");
	beach.explore();
	beach.Grayscale();
	beach.explore();
  }
  
  /** testFixUnderwater */
  public static void testFixUnderwater()
  {
	 Picture water = new Picture("F:\\Documents\\Eclipse\\Unit 16\\src\\images\\water.jpg");
	 water.explore();
	 water.FixUnderwater();
	 water.explore();
  } 
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("F:\\Documents\\Eclipse\\Unit 16\\src\\images\\caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorHorizontal */
  public static void testMirrorHorizontal()
  {
    Picture caterpillar = new Picture("F:\\Documents\\Eclipse\\Unit 16\\src\\images\\redMotorcycle.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontal();
    caterpillar.explore();
  }
  
  /** Method to test testMirrorVerticalRightToLeft */
  public static void testMirrorVerticalRightToLeft()
  {
	Picture caterpillar = new Picture("F:\\Documents\\Eclipse\\Unit 16\\src\\images\\caterpillar.jpg");
	caterpillar.explore();
	caterpillar.MirrorVerticalRightToLeft();
	caterpillar.explore();
  }
  
  
  /** Method to test mirrorHorizontalBotToTop */
  public static void testmirrorHorizontalBotToTop()
  {
    Picture caterpillar = new Picture("F:\\Documents\\Eclipse\\Unit 16\\src\\images\\redMotorcycle.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontalBotToTop();
    caterpillar.explore();
  }
  
  /** Method to test mirrorDiagonal */
  public static void testMirrorDiagonal()
  {
    Picture caterpillar = new Picture("F:\\Documents\\Eclipse\\Unit 16\\src\\images\\beach.jpg");
    caterpillar.explore();
    caterpillar.mirrorDiagonal();
    caterpillar.explore();
  }
  
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("F:\\Documents\\Eclipse\\Unit 16\\src\\images\\temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test mirrorArms */
  public static void testMirrorArms()
  {
    Picture temple = new Picture("F:\\Documents\\Eclipse\\Unit 16\\src\\images\\snowman.jpg");
    temple.explore();
    temple.mirrorArms();
    temple.explore();
  }
  
  /** Method to test mirrorGull */
  public static void testMirrorGull()
  {
    Picture temple = new Picture("F:\\Documents\\Eclipse\\Unit 16\\src\\images\\seagull.jpg");
    temple.explore();
    temple.mirrorGull();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("F:\\Documents\\Eclipse\\Unit 16\\src\\images\\640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  public static void testMyCollage()
  {
    Picture canvas = new Picture("F:\\Documents\\Eclipse\\Unit 16\\src\\images\\640x480.jpg");
    canvas.myCollage();
    canvas.explore();
  }
  
  public static void testCopy()
  {
    Picture canvas = new Picture("F:\\Documents\\Eclipse\\Unit 16\\src\\images\\640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("F:\\Documents\\Eclipse\\Unit 16\\src\\images\\swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
	//testMirrorHorizontal();
	//testmirrorHorizontalBotToTop();
	//testMirrorVerticalRightToLeft();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
	//testMyCollage();
    testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }

}