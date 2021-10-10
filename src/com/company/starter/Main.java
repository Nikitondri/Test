package com.company.starter;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import com.company.core.DataCounting;
import com.company.core.IOInfo;
import com.company.struct.system.Galaxy;
import org.xml.sax.SAXException;

import static com.company.core.FillInfo.fillInfoGalaxy;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException {
        Galaxy galaxy = fillInfoGalaxy();
        DataCounting.countData(galaxy);
        IOInfo.inputFile(galaxy);
    }
}

