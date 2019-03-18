package org.crawler.web.initializer;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class JsenInitializer.
 */
public class JsenInitializer extends AbstractInitializer {

	/** The Constant BAITORU_INITIALIZER. */
	private static final AbstractInitializer BAITORU_INITIALIZER = new JsenInitializer();

	/**
	 * Instantiates a new baitoru initializer.
	 * 
	 * @author Hanios
	 */
	private JsenInitializer() {
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
	 * org.crawler.web.initializer.AbstractInitializer#initializeBasicsURLWebsite(
	 * java.util.Map)
	 */
	@Override
	public void initializeBasicsURLWebsite(Map<String, String> basicsURLWebsite) {
		basicsURLWebsite.put("kanto", "&q[ac][]=kanto&q[ahs]&q[ems]&q[eh]&q[fw]=");
		basicsURLWebsite.put("kansai", "&q[ac][]=kansai&q[ahs]&q[ems]&q[eh]&q[fw]=");
		basicsURLWebsite.put("tohoku", "&q[ac][]=tohoku&q[ahs]&q[ems]&q[eh]&q[fw]=");
		basicsURLWebsite.put("hokuriku", "&q[ac][]=hokuriku&q[ahs]&q[ems]&q[eh]&q[fw]=");
		basicsURLWebsite.put("tokai", "&q[ac][]=tokai&q[ahs]&q[ems]&q[eh]&q[fw]=");
		basicsURLWebsite.put("chugoku", "&q[ac][]=chugoku&q[ahs]&q[ems]&q[eh]&q[fw]=");
		basicsURLWebsite.put("kyushu", "&q[ac][]=kyusyu&q[ahs]&q[ems]&q[eh]&q[fw]=");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.crawler.web.initializer.AbstractInitializer#initializeJobMap(java.util.
	 * HashMap)
	 */
	@Override
	public void initializeJobMap(HashMap<String, String> jobMap) {
		jobMap.put("restaurant", "https://j-sen.jp/works?q[kw]&q[jti][]=1&q[cc][]=foreigner");
		jobMap.put("store", "https://j-sen.jp/works?q[kw]&q[jti][]=143&q[jti][]=138&q[cc][]=foreigner");
		jobMap.put("factory", "https://j-sen.jp/works?q[kw]&q[jti][]=328&q[cc][]=foreigner");
		jobMap.put("cleaning",
				"https://j-sen.jp/works?q[kw]&q[jti][]=351=&q[jti][]=352=&q[jti][]=353&q[cc][]=foreigner");
		jobMap.put("others", " https://j-sen.jp/works?q[kw]&q[jti][]=198&q[cc][]=foreigner");
	}

}
