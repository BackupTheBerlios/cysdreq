/*
 * Created on 20/07/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.cysdreq.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.struts.util.LabelValueBean;

/**
 * @author Nacirita
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LabelAndValueListHelper {

	private static final String SEP = "|";

	public static String add(String list, String element) {
		String result;
		if (element != null && element.trim().length() > 0) {
			result = list + SEP + element.trim();
		} else {
			result = list;
		}

		return result;
	}

	public static String remove(String list, String element) {
		if (element != null && element.trim().length() > 0 && !element.startsWith("<")) {
			StringBuffer estadosIng = new StringBuffer();
	
			StringTokenizer st = new StringTokenizer(list, SEP);
			String token;
			while (st.hasMoreTokens()) {
				token = st.nextToken();
				if (!element.equals(token)) {
					estadosIng.append(SEP);
					estadosIng.append(token);
				}
			}
			return estadosIng.toString();
		} else {
			return list;
		}
	}

	public static ArrayList parseBeansList(String list, String emptyMsg) {
		ArrayList result = new ArrayList();

		StringTokenizer st = new StringTokenizer(list, SEP);
		String token;
		while (st.hasMoreTokens()) {
			token = st.nextToken();
			result.add(new LabelValueBean(token, token));
		}

		if (result.size() == 0 && emptyMsg != null) {
			result.add(new LabelValueBean(emptyMsg, emptyMsg));
		}

		return result;
	}

	public static ArrayList parseStringList(String list) {
		ArrayList result = new ArrayList();

		StringTokenizer st = new StringTokenizer(list, SEP);
		String token;
		while (st.hasMoreTokens()) {
			token = st.nextToken();
			result.add(token);
		}

		return result;
	}

	/**
	 * @param list
	 * @param string
	 * @return
	 */
	public static boolean existsOnLabelValueArray(ArrayList list, String string) {
		return indexOnLabelValueArray(list, string) > -1;
	}

	/**
	 * @param list
	 * @param string
	 * @return
	 */
	public static int indexOnLabelValueArray(ArrayList list, String string) {
		int index = 0; 
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			LabelValueBean bean = (LabelValueBean) iter.next();
			
			if (bean.getValue().equals(string)) {
				return index;
			}
			index++;
		}
		return -1;
	}
}
