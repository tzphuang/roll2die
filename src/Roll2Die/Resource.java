package Roll2Die;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static javax.imageio.ImageIO.read;

public class Resource {
    private static Map<String, BufferedImage> resources;

    static {
        Resource.resources = new HashMap<>();

        try {
            //Resource.resources.put("playerFightImg",read(Objects.requireNonNull(MonsterFightEnvironment.class.getClassLoader().getResource("rocket.png"))));

            //panel images
            Resource.resources.put("titleScreen",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("roll2diedice.png"))));
            Resource.resources.put("endScreen",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("Die2RollRip.png"))));
            Resource.resources.put("winnerScreen",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("winnerpic.png"))));
            Resource.resources.put("creditScreen",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("creditsPic.png"))));

            //overWorld images
            Resource.resources.put("overworld player img",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("Over world PlayerImg.png"))));
            Resource.resources.put("tile0",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("tile 0.png"))));
            Resource.resources.put("tile1",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("tile 1.png"))));
            Resource.resources.put("tile2",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("tile 2.png"))));
            Resource.resources.put("tile3",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("tile 3.png"))));
            Resource.resources.put("tile4",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("tile 4.png"))));
            Resource.resources.put("tile5",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("tile 5.png"))));
            Resource.resources.put("tile6",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("tile 6.png"))));
            Resource.resources.put("tile7",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("tile 7.png"))));
            Resource.resources.put("tile8",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("tile 8.png"))));

            //overWorld dice images
            Resource.resources.put("2d6",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("2d6 icon.png"))));
            Resource.resources.put("d4",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("d4 icon.png"))));
            Resource.resources.put("d20",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("d20 icon.png"))));

            //overWorld activatable tile images
            Resource.resources.put("buff",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("bufftile.png"))));
            Resource.resources.put("debuff",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("debufftile.png"))));
            Resource.resources.put("treasure",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("treasure img.png"))));
            Resource.resources.put("trap",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("traptile.png"))));

            Resource.resources.put("fireball",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("fireball.png"))));


        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static BufferedImage getResourceImg(String key){
        return Resource.resources.get(key);
    }

}
