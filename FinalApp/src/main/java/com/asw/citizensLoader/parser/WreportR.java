package com.asw.citizensLoader.parser;

import com.asw.citizensLoader.reportwritter.SingletonReporter;
import com.asw.citizensLoader.reportwritter.WriteReport;



/**
 * Created by Pelayo Garcia Lartategui on 10/02/2017.
 * Puerto r de escritura de reportes
 */
public class WreportR implements WriteReport{

    @Override
    public void report(String... problemas) {
        //new WreportP().report(problemas);
        SingletonReporter.getInstance().getWreportP().report(problemas);
    }
}
