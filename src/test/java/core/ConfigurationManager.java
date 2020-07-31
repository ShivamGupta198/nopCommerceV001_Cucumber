package core;

import java.util.Map;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.tree.xpath.XPathExpressionEngine;
import java.io.*;
import org.yaml.snakeyaml.*;
import java.util.*;

public class ConfigurationManager {
	private static PropertiesConfiguration propertiesConfiguration = null;
	private static XMLConfiguration xmlConfiguration = null;
	private static Map ymlConfiguration = null;
	private static Map scriptConfiguration = null;

	private ConfigurationManager() {

	}

	public static void loadProperties(String env) throws FileNotFoundException {
		String path = String.format("src/test/resources/properties-%s.yml", env);
		File dir = new File(path);
		Yaml yaml = new Yaml();
		InputStream file = new FileInputStream(dir);
		Object props = yaml.load(file);
		if (env.contains("script")) {
			scriptConfiguration = (Map<String, Map<String, String>>) props;
		} else {
			ymlConfiguration = (Map<String, Map<String, String>>) props;
		}
	}

	public static Map<String, String> getscriptConfiguration() {
		return scriptConfiguration;
	}

	public static Map<String, String> getBundle() {
		return ymlConfiguration;
	}

	public static PropertiesConfiguration getPropertiesconfig() {
		if (propertiesConfiguration == null) {

			propertiesConfiguration = new PropertiesConfiguration();
		}

		return propertiesConfiguration;
	}

	public static XMLConfiguration getTestData() {
		return xmlConfiguration;
	}

	public static Configuration getTestData(String keyID) {
		xmlConfiguration.setExpressionEngine(new XPathExpressionEngine());
		Configuration temp = xmlConfiguration.subset("testcase[@id='" + keyID + "']");
		Iterator<?> keys = temp.getKeys();
		while (keys.hasNext()) {
			String k = (String) keys.next();
			String v = temp.getString(k);
			String r = getV(v);
			temp.setProperty(k, r);
		}

		return temp;
	}

	public static String getV(String v) {
		if (!v.contains("$")) {
			return v;
		}

		else {
			v = xmlConfiguration.getString(v.substring(2, v.length() - 1));
			getV(v);
		}
		return v;
	}
}
