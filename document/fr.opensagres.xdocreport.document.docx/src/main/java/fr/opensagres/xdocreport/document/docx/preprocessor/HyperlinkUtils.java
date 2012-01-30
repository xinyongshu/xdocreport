package fr.opensagres.xdocreport.document.docx.preprocessor;

import java.util.Map;

import fr.opensagres.xdocreport.core.utils.StringUtils;

/**
 * Utilities for Hyperlink.
 * 
 */
public class HyperlinkUtils {

	private static final String[] DOT_SLASH = new String[] { ".", "/" };
	private static final String[] UNDERSCORE_UNDERSCORE = new String[] { "_",
			"_" };
	private static final String[] RELS = new String[] { ".rels", "/_rels" };
	private static final String[] BLANCK = new String[] { "", "" };

	/**
	 * 
	 * @param entryName
	 * @param sharedContext
	 * @return
	 */
	public static InitialHyperlinkMap getInitialHyperlinkMap(String entryName,
			Map<String, Object> sharedContext) {
		if (sharedContext == null) {
			return null;
		}
		return (InitialHyperlinkMap) sharedContext
				.get(getHyperlinkRegistryKey(entryName));
	}

	/**
	 * 
	 * @param entryName
	 * @param sharedContext
	 * @param hyperlinkMap
	 */
	public static void putInitialHyperlinkMap(String entryName,
			Map<String, Object> sharedContext, InitialHyperlinkMap hyperlinkMap) {
		sharedContext.put(getHyperlinkRegistryKey(entryName), hyperlinkMap);
	}

	/**
	 * 
	 * @param entryName
	 * @return
	 */
	public static String getHyperlinkRegistryKey(String entryName) {
		entryName = StringUtils.replaceEach(entryName, DOT_SLASH,
				UNDERSCORE_UNDERSCORE);
		return HyperlinkRegistry.KEY + entryName;
	}

	/**
	 * 
	 * @param relsEntryName
	 * @return
	 */
	public static String getEntryNameWithoutRels(String relsEntryName) {
		return StringUtils.replaceEach(relsEntryName, RELS, BLANCK);
	}
}
