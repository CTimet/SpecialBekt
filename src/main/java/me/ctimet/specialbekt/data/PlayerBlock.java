package me.ctimet.specialbekt.data;

import org.bukkit.Material;

import java.io.Serializable;

public record PlayerBlock(String json, Material material) implements Serializable {
    @java.io.Serial
    private static final long serialVersionUID = 202208241312L;
}
