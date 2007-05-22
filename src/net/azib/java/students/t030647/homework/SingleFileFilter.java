package net.azib.java.students.t030647.homework;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * 
 * SingleFileFilter
 * FileFilter that allows to choose files with accepted extension
 * @author Igor
 */
public class SingleFileFilter extends FileFilter {
    private String acceptedExtension;
    private String title;


    public String getTitle() {
        return title;
    }

    public String getAcceptedExtension() {
        return acceptedExtension;
    }

    public SingleFileFilter(String acceptedExtension, String title) {
        this.acceptedExtension = acceptedExtension;
        this.title = title;
    }

    //Accept all directories and all csv files.
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = GetExtension(f);
        if (extension != null) {
            return extension.equals(getAcceptedExtension());
        }

        return false;
    }

    private String GetExtension(File f) {
        int lastIndex = f.getName().lastIndexOf(".");
        return f.getName().substring(lastIndex + 1);
    }

    //The description of this filter
    public String getDescription() {
        return "*." + getAcceptedExtension();
    }
}