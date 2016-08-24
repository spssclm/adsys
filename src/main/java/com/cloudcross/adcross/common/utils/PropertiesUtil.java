package com.cloudcross.adcross.common.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.cloudcross.adcross.common.utils.PropertiesUtil;

public class PropertiesUtil {

	private static final Logger LOG = Logger.getLogger(PropertiesUtil.class);

	private static Properties props = new Properties();

	static {
		try {
			props.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("errorInfo.properties"));
		} catch (FileNotFoundException e) {
			LOG.error(e.getMessage(), e);
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
		}
	}

	public static String getValue(String key) {
		String content = "";
		if (props.containsKey(key)) {
			content = props.getProperty(key);
		}
		return content;
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public static List<String> getKeys(String likeKey) {
		List<String> keys = new ArrayList<String>();
		String skey = null;
		Set<Map.Entry<Object, Object>> set = props.entrySet();
		Iterator<Entry<Object, Object>> it = set.iterator();
		while (it.hasNext()) {
			skey = (String) it.next().getKey();
			if (skey.contains(likeKey)) {
				keys.add(skey);
			}
		}
		return keys;
	}

	public static void updateProperties(String key, String value) {
		props.setProperty(key, value);
	}

	public static void main(String[] args) {
		System.out.println(getValue("baidu_2055"));
		System.out.println(props.toString());
		System.out.println(props.size());

		List<String> keys = getKeys("qq_");
		System.out.println(keys);

	}
}
