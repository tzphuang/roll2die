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
            /*
            Resource.resources.put("t1img", read(Objects.requireNonNull(TRE.class.getClassLoader().getResource("tankred.png"))));
            Resource.resources.put("t2img", read(Objects.requireNonNull(TRE.class.getClassLoader().getResource("tankblue.png"))));
            Resource.resources.put("unBreakWall", read(Objects.requireNonNull(TRE.class.getClassLoader().getResource("unbreakable.png"))));
            Resource.resources.put("breakWall", read(Objects.requireNonNull(TRE.class.getClassLoader().getResource("breakable.png"))));
            Resource.resources.put("heavyMgun", read(Objects.requireNonNull(TRE.class.getClassLoader().getResource("heavy machine gun.png"))));
            Resource.resources.put("rLauncher", read(Objects.requireNonNull(TRE.class.getClassLoader().getResource("rocket launcher.png"))));
            Resource.resources.put("godMode", read(Objects.requireNonNull(TRE.class.getClassLoader().getResource("tankgold.png"))));
            Resource.resources.put("mgBulletImg",read(Objects.requireNonNull(TRE.class.getClassLoader().getResource("bullet.png"))));
            Resource.resources.put("rocketBulletImg",read(Objects.requireNonNull(TRE.class.getClassLoader().getResource("rocket.png"))));*/

            //Resource.resources.put("playerFightImg",read(Objects.requireNonNull(MonsterFightEnvironment.class.getClassLoader().getResource("rocket.png"))));
            Resource.resources.put("titleScreen",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("roll2diedice.png"))));
            Resource.resources.put("endScreen",read(Objects.requireNonNull(Launcher.class.getClassLoader().getResource("Die2RollRip.png"))));

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static BufferedImage getResourceImg(String key){
        return Resource.resources.get(key);
    }

}
