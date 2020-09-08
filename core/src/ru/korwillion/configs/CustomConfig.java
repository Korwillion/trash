package ru.korwillion.configs;

import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import ru.korwillion.main.survival;


public class CustomConfig {

    private YamlConfiguration yml;
    private File file;

    CustomConfig(String name) {
        this.file = new File(survival.plugin().getDataFolder().getAbsolutePath(), "playerdata/" + name+".yml");
        yml = YamlConfiguration.loadConfiguration(file);
        this.file.getParentFile().mkdirs();
    }

    public FileConfiguration get() {
        return yml;
    }

    public void save() {
        try {
            yml.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reload() {
        try {
            yml.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
