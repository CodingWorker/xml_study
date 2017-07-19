package com.example;

import com.sun.javafx.scene.NodeHelper;
import org.dom4j.*;
import org.dom4j.dom.DOMElement;
import org.dom4j.dom.DOMNodeHelper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by daiya on 2017/7/19.
 */
public class Main {
    public static void main(String[] args)throws DocumentException,IOException{
        String xmlPath="F:\\my\\mygit\\xml_study\\codes\\src\\main\\resources\\xmlsample\\book.xml";
        String fileContent=readFile(xmlPath);
        Document document= DocumentHelper.parseText(fileContent);
        Node books=document.selectSingleNode("/");
        List<Node> bookArr=document.selectNodes("/bookstore/book");
        for(Node book:bookArr){
            Node title=book.selectSingleNode("title");
            Node price=book.selectSingleNode("price");

        }

//        buildXML();
        System.exit(0);
    }

    public static void buildXML(){
        DocumentFactory docFactory=DocumentFactory.getInstance();
        Document doc=docFactory.createDocument();
        Element books=new DOMElement("books");
        Element book=books.addElement("book");
        book.setText("a good book");
        Element price=books.addElement("price");
        price.setText("12");
        doc.add(books);

        System.out.println(doc.asXML());

    }

    public static String readFile(String filePath)throws IOException{
        BufferedReader reader=new BufferedReader(new FileReader(filePath));
        StringBuilder sb=new StringBuilder();
        while(true){
            String line=reader.readLine();
            if(line==null){
                break;
            }

            sb.append(line);
        }

        return sb.toString();
    }
}
