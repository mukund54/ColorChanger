package com.example.mukund.colorchanger;

/**
 * Created by mukund on 9/4/2017.
 */

        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;

        import java.awt.image.BufferedImage;
        import java.awt.image.DataBufferByte;
        import java.io.*;
        import javax.imageio.ImageIO;
        import java.util.*;

        import static com.example.mukund.colorchanger.R.id.image;

/**
 * Created by mukund on 9/3/2017.
 */

public class colorremover {

    static File file;
    static PrintWriter jj;
    public static void main(String[] args) throws Exception {
        Bitmap icon = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.lll);
        int[] pixels = new int[icon.getHeight() * icon.getWidth()];
        icon.getPixels(pixels, 0, icon.getWidth(), 0, 0, icon.getWidth(),icon.getHeight());

        //          Scanner pp=new Scanner(System.in);
        //        file=new File("mmt.txt");
        //      jj=new PrintWriter(file);

//            BufferedImage hugeImage = ImageIO.read(uu.class.getResource("images2.jpg"));

        //    final boolean hasAlphaChannel = hugeImage.getAlphaRaster() != null;
        //   int[][] result = convertTo2DWithoutUsingGetRGB(hugeImage);
        //  System.out.println("enter a number\n");
        // int n=pp.nextInt();
        //diffcolor(result,n,hasAlphaChannel);




        // private static int[][] convertTo2DWithoutUsingGetRGB(BufferedImage image)throws Exception {

        //    final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        //  final int width = image.getWidth();
        //final int height = image.getHeight();
        //   System.out.println("height="+height);
        //  System.out.println("width="+width);

        // final boolean hasAlphaChannel = image.getAlphaRaster() != null;

        int[][] result = new int[icon.getHeight()][icon.getWidth()];
                /*if (hasAlphaChannel) {
                    //       System.out.println("hasAlphaChannel");
                    final int pixelLength = 4;
                    for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
                        int argb = 0;
                        argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
                        argb += ((int) pixels[pixel + 1] & 0xff); // blue
                        argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
                        argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red
                        result[row][col] = argb;
                        col++;
                        if (col == width) {
                            col = 0;
                            row++;
                        }
                    }

                } else {*/
//System.out.println("hasnoAlphaChannel");
        final int pixelLength = 3;
        int pixel = 0, row = 0, col = 0;
        for (pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
            int argb = 0;
            argb += -16777216; // 255 alpha
            argb += ((int) pixels[pixel] & 0xff); // blue
            argb += (((int) pixels[pixel + 1] & 0xff) << 8); // green
            argb += (((int) pixels[pixel + 2] & 0xff) << 16); // red
            result[row][col] = argb;
            //print(argb);

            col++;
            if (col == icon.getWidth()) {
                col = 0;
                row++;
            }
        }
//jj.close();
//System.out.println("row="+row);
        diffcolor(result,n/*,hasAlphaChannel*/);

    }
/*for (int row = 0; row < height/5; row++) {
         for (int col = 0; col < width/5; col++) {
            System.out.print(result[row][col]);
         }
        System.out.println();
      }
    System.out.println(result[height-1][width-1]);
  inssss
  */



//


    private static void diffcolor(int [][]result,int n,boolean t)throws Exception
    {
        int height=result.length;
        int width=result[0].length;
//System.out.println("height="+height);
        //     System.out.println("width="+width);

        BufferedImage image = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);

        int i,j,a,r,g,b,color;
        int curr;
        for(i=0;i<height;i++)
        {
            for(j=0;j<width;j++)
            {
                print(result[i][j]);
                if(comp(result[i][j],n))
                {
                    //        System.out.println("hoorah");
                    image.setRGB(j, i, result[i][j]);
                }
                else
                {
                    //  a = (result[height][width]>>24) & 0xff;
                    a=255;
   /* r = (result[i][j]>>16) & 0xff;
    g = (result[i][j]>>8) & 0xff;
    b = result[i][j] & 0xff;*/
                    r=0;
                    g=0;
                    b=0;

                    color = (a << 24) | (r << 16) | (g << 8) | b;
                    image.setRGB(j, i, color);
                }
            }
        }
        jj.close();
        ImageIO.write(image, "png", new File("oop3.png"));
    }
    private static boolean comp(int p,int n)
    {
        int a = (p>>24) & 0xff;
        int r = (p>>16) & 0xff;
        int g = (p>>8) & 0xff;
        int b = p & 0xff;
        int a1 = (n>>24) & 0xff;
        int r1 = (n>>16) & 0xff;
        int g1 = (n>>8) & 0xff;
        int b1 = n & 0xff;
        //  System.out.print("r="+r);
// System.out.println("r1="+r1);

        if(r<=r1+30 && r>=r1-30)
        {
            //       System.out.println("red pass");
            if(g<=g1+30 && g>=g1-30)
            {
                //System.out.println("red pass");
                if(b<=b1+30 && b>=b1-30)
                {
// System.out.println("red pass");
                    return true;
                }

            }

        }
        return false;
    }
    private static void print(int p)throws Exception
    {
        int a = (p>>24) & 0xff;
        int r = (p>>16) & 0xff;
        int g = (p>>8) & 0xff;
        int b = p & 0xff;
        //jj.println("a="+a+" r="+r+" g="+g+" b="+b);


    }


}

















}
