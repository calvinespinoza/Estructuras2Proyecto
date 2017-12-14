/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import jxl.write.WriteException;
import Clases.WriteExcel;

/**
 *
 * @author calvinespinoza
 */
public class MainExcel {

    public static void main(String[] args) throws IOException, WriteException {
        Archivos a = new Archivos("Test Excel");
        for (int i = 0; i < 10; i++) {
            Campos c = new Campos("This.Pelotas" + i, "" + i + i, 2, true);
            a.addCampo(c);
        }

        WriteExcel test = new WriteExcel();

        test.setFileName(a.getName());
        
        test.setOutputFile("./lars.xls");
        test.write();
        System.out
                .println("Please check the result file under ./lars.xls ");

    }

}
