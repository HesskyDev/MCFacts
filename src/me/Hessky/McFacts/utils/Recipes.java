package me.Hessky.McFacts.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;

public class Recipes {
	
		@Deprecated
		public static void Recipe() {
			
			ShapedRecipe facts = new ShapedRecipe(Constants.FACT_BOOK, Items.factbook());
	
			facts.shape("PLP","LNL","PLP");
			
			facts.setIngredient('P', Material.PAPER);
			facts.setIngredient('L', Material.LEATHER);
			facts.setIngredient('N', Material.NETHER_STAR);
			
			Bukkit.addRecipe(facts);
		}
}