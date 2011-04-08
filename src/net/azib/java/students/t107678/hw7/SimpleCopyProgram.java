package net.azib.java.students.t107678.hw7;

import net.azib.java.lessons.io.DataCopier;
import net.azib.java.lessons.io.FileCopier;

import java.io.*;

public class SimpleCopyProgram implements FileCopier, DataCopier{
    @Override
    public void copy(File src, File dest) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(src);
            outputStream = new FileOutputStream(dest);
            int c;

            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        }

        finally {
            if(inputStream!=null){
                inputStream.close();
            }
                else{
                    System.out.println("Problems opening source file!");
            }
            if(outputStream!=null){
                outputStream.close();
            }
                else{
                    System.out.println("Problems opening destination file!");
            }
        }
    }

    @Override
    public void copy(InputStream src, OutputStream dest) throws IOException {
        int c;
        InputStream inputStream = null;
        OutputStream outputStream = null;


        try{
            inputStream = src;
            outputStream = dest;

            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }


        } finally {

            if(inputStream!=null){
                inputStream.close();
            }
                else{
                    System.out.println("Problems opening source stream!");
            }
            if(outputStream!=null){
                outputStream.close();
            }
                else{
                    System.out.println("Problems opening destination stream!");
            }

        }
        }


    }





