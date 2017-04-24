package com.asw.citizensLoader.dbupdate;

import com.asw.citizensLoader.reportwritter.SingletonReporter;
import com.asw.citizensLoader.reportwritter.WriteReport;



/**
 * Created by Pelayo Garcia Lartategui on 10/02/2017.
 * Puerto R para la escritura de reportes
 */
public class WreportR implements WriteReport{

    @Override
    public void report(String... problemas) {
        //new WreportP().report(problemas);
    	SingletonReporter.getInstance().getWreportP().report(problemas);
    }
}




