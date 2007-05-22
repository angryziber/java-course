package net.azib.java.students.t030647.homework;

import javax.swing.*;
import java.io.File;
import java.awt.*;

/**
 * 
 * SingleFileSelector
 * FileSelector that allows to choose files with accepted extension
 * @author Igor
 */
public class SingleFileSelector {
    private File selectedFile;
    private File currentDirectoryToOpen;
    private String extension;
    private JFileChooser addFileChooser;
    private boolean fileSelected = false;
    public static final boolean OPEN = false;
    public static final boolean SAVE = true;

    public boolean isFileSelected() {
        return fileSelected;
    }

    public File getCurrentDirectoryToOpen() {
        return currentDirectoryToOpen;
    }

    public File getSelectedFile() {
        return selectedFile.getName().contains(extension) ?
                selectedFile :
                new File(selectedFile.getAbsolutePath() + "." + extension);
    }

    public SingleFileSelector(File currentDirectoryToOpen, Component parent, String extension, String title, boolean openSave, File proposedFile) {
        this.extension = extension;
        SingleFileFilter fileFilter = new SingleFileFilter(extension, title);
        addFileChooser = new JFileChooser();
        addFileChooser.addChoosableFileFilter(fileFilter);
        addFileChooser.setDialogTitle(fileFilter.getTitle());


        if (currentDirectoryToOpen == null) {                           //todo: currentDirectoryToOpen
            currentDirectoryToOpen = new File("c:" + File.separator);
        }
        addFileChooser.setCurrentDirectory(currentDirectoryToOpen);
        if (proposedFile != null) {
            addFileChooser.setSelectedFile(proposedFile);
        }
        int selection;
        if (openSave == OPEN) {
            selection = addFileChooser.showOpenDialog(parent);
        } else if (openSave == SAVE) {
            selection = addFileChooser.showSaveDialog(parent);
        } else {
            JOptionPane.showMessageDialog(parent,
                    "Wrong parameter for ShowDialog.\nMust be 'open' or 'save'. " ,
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (selection == JFileChooser.APPROVE_OPTION) {
            this.selectedFile = addFileChooser.getSelectedFile();
            this.currentDirectoryToOpen = new File(selectedFile.getParent());
            this.fileSelected = true;
        }
    }
}
