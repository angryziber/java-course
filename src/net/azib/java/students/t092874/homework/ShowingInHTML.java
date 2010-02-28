package net.azib.java.students.t092874.homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

/**
 * ShowingInHTML
 * 
 * @author Aleksandr Gladki
 */
class ShowingInHTML {
	private String fileOrPath = "";

	ShowingInHTML(String fileOrPath) {
		this.fileOrPath = fileOrPath;
	}

	/**
	 * @return the fileOrPath
	 */
	public String getFileOrPath() {
		if (fileOrPath.contains("/")) {
			return System.getProperty("user.dir") + fileOrPath;
		}
		else {
			return System.getProperty("user.dir") + "/" + fileOrPath;
		}
	}

	/**
	 * 
	 * @param create
	 *            html file from source List<Result>
	 */
	public void createHTML(List<Result> list) {
		try {
			File theDir = new File(Util.getDirFromString(getFileOrPath()));
			// if the directory does not exist, create it
			if (!theDir.getName().isEmpty() && !theDir.exists()) {
				theDir.mkdir();
			}
			String nameXml = "/tmp/"
					+ getFileOrPath().substring(getFileOrPath().lastIndexOf("/") + 1, getFileOrPath().indexOf(".") + 1) + "xml";
			ShowingInXML xml = new ShowingInXML(nameXml);
			xml.createXml(list);
			TransformerFactory tFactory = TransformerFactory.newInstance();

			Transformer transformer = tFactory.newTransformer(new javax.xml.transform.stream.StreamSource(System
					.getProperty("user.dir")+Constants.MY_PATH
					+ "results.xsl"));

			transformer.transform(new javax.xml.transform.stream.StreamSource(xml.getFileOrPath()),
					new javax.xml.transform.stream.StreamResult(new FileOutputStream(getFileOrPath())));

			deleteTemporyDir(xml);// created in this dir xml and after created
									// html delete this xml file and dir
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (TransformerException e) {
			e.printStackTrace();
		}

	}

	private void deleteTemporyDir(ShowingInXML xml) {
		File theDir = new File(xml.getFileOrPath());
		theDir.delete();
		theDir = new File(Util.getDirFromString(xml.getFileOrPath()));
		theDir.delete();
	}
}
