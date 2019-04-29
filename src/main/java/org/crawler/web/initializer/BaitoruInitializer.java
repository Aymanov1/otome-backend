package org.crawler.web.initializer;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class BaitoruInitializer.
 * 
 * @author Hanios
 */
public class BaitoruInitializer extends AbstractInitializer {

	/** The Constant BAITORU_INITIALIZER. */
	private static final AbstractInitializer BAITORU_INITIALIZER = new BaitoruInitializer();

	/**
	 * Instantiates a new baitoru initializer.
	 * 
	 * @author Hanios
	 */
	private BaitoruInitializer() {
		initializeBasicsURLWebsite(basicsURLWebsite);
		initializeJobMap(jobMap);
	}

	/**
	 * Gets the single instance of BaitoruInitializer.
	 * 
	 * @author Hanios
	 * @return single instance of BaitoruInitializer
	 */
	public static AbstractInitializer getInstance() {
		return BAITORU_INITIALIZER;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.crawler.web.Initializer.AbstractInitializer#initializeBasicsURLWebsite(
	 * java.util.List)
	 */
	@Override
	public void initializeBasicsURLWebsite(Map<String, String> basicsURLWebsite) {
		basicsURLWebsite.put("kansai", "https://www.baitoru.com/kansai/jlist/");
		basicsURLWebsite.put("tokyo", "https://www.baitoru.com/kanto/jlist/tokyo/");
		basicsURLWebsite.put("kanto", "https://www.baitoru.com/kanto/jlist/");
		basicsURLWebsite.put("tokai", "https://www.baitoru.com/tokai/jlist/");
		basicsURLWebsite.put("tohoku", "https://www.baitoru.com/tohoku/jlist/");
		basicsURLWebsite.put("koshinetsu", "https://www.baitoru.com/koshinetsu/jlist/");
		basicsURLWebsite.put("chushikoku", "https://www.baitoru.com/chushikoku/jlist/");
		basicsURLWebsite.put("kyushu", "https://www.baitoru.com/kyushu/jlist/");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.crawler.web.Initializer.AbstractInitializer#initializeJobMap(java.util.
	 * HashMap)
	 */
	@Override
	public void initializeJobMap(HashMap<String, String> list) {
		list.put("sales", "sales");
		list.put("clean-housekeeper-disinfection-guestroomclean", "cleaning");
		list.put("conveni-supermarket-drugstore-homecenter", "store");
		list.put("food", "food");
		list.put("izakaya", "izakaya");
		// list.put("nurseaide-carevisit-facilitycare-geriatrichealthservices",
		// "healthcare");
		// list.put("sorting-picking-packing-inventory-inspection-warehousing-materialtransport-forklift",
		// "factory");
		list.put("clean", "clean");
		// list.put("housekeeper", "housekeeper");
		// list.put("disinfection", "disinfection");
		// list.put("guestroomclean", "guestroomclean");
		// list.put("lightwork", "lightwork");
		// list.put("production", "production");
		// list.put("event", "event");
		// list.put("business", "business");
		// list.put("office", "office");
		// list.put("creative", "creative");
		// list.put("education", "education");
		// list.put("medicalcare", "medicalcare");
		// list.put("beauty", "beauty");
		// list.put("investigation", "investigation");
		// list.put("professional", "professional");
		// list.put("gamecenter", "gamecenter");
		// list.put("bowling", "bowling");
		// list.put("karaoke", "karaoke");
		// list.put("battingcenter", "battingcenter");
		// list.put("comiccafe", "comiccafe");
		// list.put("theater", "theater");
		// list.put("amusementpark", "amusementpark");
		// list.put("artgallery", "artgallery");
		// list.put("librarian", "librarian");
		// list.put("zoo", "zoo");
		// list.put("mahjongclub", "mahjongclub");
		// list.put("caddy", "caddy");
		// list.put("golfcourse", "golfcourse");
		// list.put("hotspring", "hotspring");
		// list.put("streetstall", "streetstall");
		// list.put("skislope", "skislope");
		// list.put("lifeguard", "lifeguard");
		// list.put("pool", "pool");
		// list.put("stationattendant", "stationattendant");
		// list.put("airport", "airport");
		// list.put("tourconductor", "tourconductor");
		// list.put("hotel", "hotel");
		// list.put("bridal", "bridal");
		// list.put("undertaker", "undertaker");
		// list.put("gasstation", "gasstation");
		// list.put("carwash", "carwash");
		// list.put("rentalcar", "rentalcar");
		// list.put("equipmentmanagement", "equipmentmanagement");
		// list.put("automobilemechanic", "automobilemechanic");
		// list.put("buildingmaintenance", "buildingmaintenance");
		// list.put("serviceleader", "serviceleader");
		// list.put("information", "information");
		// list.put("publicfacilities", "publicfacilities");
		// list.put("cleaning", "cleaning");
		// list.put("serviceetc", "serviceetc");
	}

}
