/**
 * Jordan Marx
 * 
 * Class for manipulating a loaded image 90 degrees counter clockwise
 */


public class ManipulateImage90cc
{
  
  public static void main (String[] args) 
  {
    // Create and open a picture
    String filename1 = FileChooser.pickAFile();
    Picture pic1 = new Picture(filename1);
    
    // Create a picture and modify it
    Picture pic2;
    pic2 = rotateCC90Deg(pic1);
    
    // Show the picture
    pic2.show();
    
    // Save the picture
    String filename2;
    filename2 = FileChooser.pickAFile();
    pic2.write(filename2);

  }
  
  public static Picture rotateCC90Deg (Picture pic)
  {
    // Get the width and height of the picture
    int width = pic.getWidth();
    int height = pic.getHeight();
    System.out.println("Width: " + width + ", Height: " + height);
    
    // Create the new Picture that will be returned
    Picture resultPicture;
    resultPicture = new Picture(height * 2, width * 2);
    
    
    int xPos;
    int yPos;
    int xNew;
    int yNew;
    Pixel pix;
    Pixel pix2;   
    int red;
    int green;
    int blue;
    
    // Loop to access all the pixels
    for ( xPos = 0 ; xPos < width ; ++xPos )
    {
      for ( yPos = 0 ; yPos < height ; ++yPos )
      { 
        // Access the pixel to be modifed
        pix = pic.getPixel(xPos, yPos);
        
        xNew = height - yPos;
        yNew = xPos;
        pix2 = resultPicture.getPixel (xNew, yNew);
        
        // Get the color values from the original pixel
        red = pix.getRed();
        green = pix.getGreen();
        blue = pix.getBlue();
        
        // Set the color values into the result pixel
        pix2.setRed(red);
        pix2.setGreen(green);
        pix2.setBlue(blue);
      }
    }
    
    return resultPicture;
  } 
  
}