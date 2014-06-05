package net.minixalpha.chap18;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;

import javax.swing.text.Document;

import net.mindview.util.TextFile;
import nu.xom.Element;
import nu.xom.Serializer;

public class Ex32 {

	static void wordsStat(String fileName, String XMLFileName) throws Exception {
		List<String> list = getWordsList(fileName);
		Map<String, Integer> map = getWordsStat(list);
		saveToXML(map, XMLFileName);
	}

	static List<String> getWordsList(String filename) {
		TextFile file = new TextFile(filename, "\\W+");
		List<String> list = new ArrayList<>(file);
		System.out.println(list);
		return list;
	}

	static Map<String, Integer> getWordsStat(List<String> list) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String wd : list) {
			Integer value = map.get(wd);
			if (value == null) {
				value = 0;
			}
			map.put(wd, value + 1);
		}
		return map;
	}

	static Element getXMLElement(String content, Integer count) {
		Element word = new Element("word");
		Element contentName = new Element("content");
		contentName.appendChild(content);
		Element countName = new Element("count");
		countName.appendChild(count.toString());
		word.appendChild(contentName);
		word.appendChild(countName);
		return word;
	}

	static void format(OutputStream os, nu.xom.Document doc) throws Exception {
		Serializer serializer = new Serializer(os, "ISO-8859-1");
		serializer.setIndent(4);
		serializer.setMaxLength(60);
		serializer.write(doc);
		serializer.flush();
	}

	static void saveToXML(Map<String, Integer> map, String xmlFileName)
			throws Exception {
		Element root = new Element("wordsCount");
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			Element child = getXMLElement(entry.getKey(), entry.getValue());
			root.appendChild(child);
		}
		nu.xom.Document doc = new nu.xom.Document(root);
		format(System.out, doc);
		format(new BufferedOutputStream(new FileOutputStream(xmlFileName)), doc);
	}

	public static void main(String[] args) throws Exception {
		wordsStat("test.txt", "test.xml");
	}
}
