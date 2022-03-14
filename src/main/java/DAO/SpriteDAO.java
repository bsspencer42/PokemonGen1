package DAO;

import Objects.Tile;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class  SpriteDAO {

    // Get tileSet
    public ArrayList<Tile> getTileSet(){
        // Get img
        String spriteMaster = "/Objects/tilesets.png";
        String spriteCSV = "tileSetData.csv";
        BufferedImage img = importImg(spriteMaster);
        // Return Value
        ArrayList<Tile> sprites = new ArrayList<>();
        // Get CSV Data
        List<List<String>> spriteStringArray = new csvDAO(spriteCSV).readFile();

        // Parse tileSet
        for (int i = 1; i < spriteStringArray.size(); i++){
            List<String> spriteData = spriteStringArray.get(i);
            String name = spriteData.get(0);
            int x = Integer.parseInt(spriteData.get(1));
            int y = Integer.parseInt(spriteData.get(2));
            int width = Integer.parseInt(spriteData.get(3));
            int height = Integer.parseInt(spriteData.get(4));
            BufferedImage currentImg = reScaleImage(img.getSubimage(x,y,width,height));
            boolean canMove = Boolean.parseBoolean(spriteData.get(5));
            int id = Integer.parseInt(spriteData.get(6));
            Tile currentSprite = new Tile(name,width,height,canMove,currentImg);
            sprites.add(id,currentSprite);
        }
        return sprites;
    }

    // Read Sprites from CSV
    private BufferedImage importImg(String fileName) {
        InputStream is = getClass().getResourceAsStream(fileName);
        BufferedImage img = null;
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    // Rescales image x2
    private BufferedImage reScaleImage(BufferedImage before){
        int w = before.getWidth();
        int h = before.getHeight();
        BufferedImage after = new BufferedImage(w*2, h*2, BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale(2.0, 2.0);
        AffineTransformOp scaleOp =
                new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        after = scaleOp.filter(before, after);
        return after;
    }



}
