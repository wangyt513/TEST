/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wenmeng;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author wyt
 */
public class WXRT {

     public static String getJSON(String url) {
        URL u;
        InputStream in = null;
        try {
            u = new URL(url);
            byte[] b = new byte[256];

            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            try {
                in = u.openStream();
                int i;
                while ((i = in.read(b)) != -1) {
                    bo.write(b, 0, i);
                }
                String result = bo.toString("utf-8");
                bo.reset();
                return result;


            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public static String getJSON(String url, String msg) {
        URL u;
        InputStream in = null;
        OutputStream out = null;
        URLConnection open = null;
        try {
            u = new URL(url);
            byte[] b = new byte[256];

            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            try {
                open = u.openConnection();
                open.setDoInput(true);
                open.setDoOutput(true);
                out = open.getOutputStream();
                out.write(msg.getBytes("utf-8"));
                out.flush();
                in = open.getInputStream();
                int i;
                while ((i = in.read(b)) != -1) {
                    bo.write(b, 0, i);
                }
                String result = bo.toString("utf-8");
                bo.reset();
                return result;


            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String getJSON1(String url, String msg) {
        URL u;
        InputStream in = null;
        OutputStream out = null;
        URLConnection open = null;
        try {
            u = new URL(url);
            byte[] b = new byte[256];

            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            try {
                open = u.openConnection();
                open.setRequestProperty("Content-Type","application/json;charest=UTF-8");
                open.setDoInput(true);
                open.setDoOutput(true);
                out = open.getOutputStream();
                out.write(msg.getBytes("utf-8"));
                out.flush();
                in = open.getInputStream();
                int i;
                while ((i = in.read(b)) != -1) {
                    bo.write(b, 0, i);
                }
                String result = bo.toString("utf-8");
                bo.reset();
                return result;


            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
