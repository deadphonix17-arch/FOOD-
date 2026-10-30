package addon.butchersfoods;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class FoodsAddon implements ModInitializer {
    public static final String NS = "butchersdelightfoods";
    private static final List<Item> ALL = new ArrayList<>();

    private static void reg(String name, int hunger, float sat) {
        Item item = new Item(new Item.Settings().food(
            new FoodComponent.Builder().hunger(hunger).saturationModifier(sat).meat().build()));
        Registry.register(Registries.ITEM, new Identifier(NS, name), item);
        ALL.add(item);
    }

    @Override
    public void onInitialize() {
        reg("legcow", 3, 0.3f);
        reg("cooked_legcow", 8, 0.8f);
        reg("beefribs", 3, 0.3f);
        reg("cooked_beefribs", 8, 0.8f);
        reg("beeftenderloin", 3, 0.3f);
        reg("cooked_beeftenderloin", 8, 0.8f);
        reg("ham", 3, 0.3f);
        reg("cooked_ham", 8, 0.8f);
        reg("porkloin", 3, 0.3f);
        reg("cooked_porkloin", 8, 0.8f);
        reg("porkribs", 3, 0.3f);
        reg("cooked_porkribs", 8, 0.8f);
        reg("sheeploin", 2, 0.3f);
        reg("cooked_sheeploin", 6, 0.8f);
        reg("sheeprack", 2, 0.3f);
        reg("cooked_sheeprack", 6, 0.8f);
        reg("sheepshank", 2, 0.3f);
        reg("cooked_sheepshank", 6, 0.8f);
        reg("goatrack", 2, 0.3f);
        reg("cooked_goatrack", 6, 0.8f);
        reg("goat_loin", 2, 0.3f);
        reg("cooked_goat_loin", 6, 0.8f);
        reg("goat_shank", 2, 0.3f);
        reg("cooked_goat_shank", 6, 0.8f);
        reg("llama_leg", 2, 0.3f);
        reg("cooked_llama_leg", 6, 0.8f);
        reg("llama_loin", 2, 0.3f);
        reg("cooked_llama_loin", 6, 0.8f);
        reg("llamma_ribs", 2, 0.3f);
        reg("cooked_llamma_ribs", 6, 0.8f);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(e -> ALL.forEach(e::add));
    }
}
