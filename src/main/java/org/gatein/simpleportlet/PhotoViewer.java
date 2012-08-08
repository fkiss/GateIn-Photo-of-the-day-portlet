/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gatein.simpleportlet;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.portlet.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


/**
 *
 * @author fkiss
 */
public class PhotoViewer extends GenericPortlet{
    
    private String size;

    public PhotoViewer() {
    }
    
    @Override
    public void doEdit(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        
        PortletRequestDispatcher prd =getPortletContext().getRequestDispatcher("/WEB-INF/jsp/Viewer_edit.jsp");
        prd.include(request, response);
        
    }
    
    @Override
    public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        
            String rUrl = request.getParameter("url");
            switchUrl(rUrl, request);
            request.setAttribute("size", size);
            
            PortletRequestDispatcher prd =getPortletContext().getRequestDispatcher("/WEB-INF/jsp/Viewer_view.jsp");
            prd.include(request, response);
    }
    
    @Override
    public void doHelp(RenderRequest request, RenderResponse response) throws PortletException, IOException {
    
        PortletRequestDispatcher prd =getPortletContext().getRequestDispatcher("/WEB-INF/jsp/Viewer_help.jsp");
        prd.include(request, response);
        
    }
    
    public void processAction(ActionRequest req, ActionResponse res) throws IOException, PortletException {
    
        PortletPreferences prefs = req.getPreferences();
        size = req.getParameter("size");
        prefs.setValue("size", size);
    }
    
    public void switchUrl(String sUrl,RenderRequest request) throws MalformedURLException, IOException {
            
            if(null==sUrl) {
                request.setAttribute("infoUrl", "");
            }
            
            if("National Geographic".equals(sUrl)){
                String stringUrl ="http://photography.nationalgeographic.com/photography/photo-of-the-day/";
                URL url = new URL(stringUrl);
                String photoUrl = null;
                Document doc = Jsoup.parse(url,5000); 

                Elements photos = doc.select(".primary_photo img");
                photoUrl = photos.attr("src");
                
                request.setAttribute("infoUrl", stringUrl);
                request.setAttribute("info", "National Geographic");
                request.setAttribute("photoUrl", photoUrl);
            }
            
            if("ephoto".equals(sUrl)) {
                String stringUrl ="http://www.ephoto.sk";
                URL url = new URL(stringUrl);
                Document doc = Jsoup.parse(url,5000); 

                Elements photos = doc.select("#tab_foto_dna a.img");
            	String tmpUrl = photos.attr("href");
                URL tmpUrl2 = new URL("http://www.ephoto.sk" + tmpUrl);
                doc = Jsoup.parse(tmpUrl2, 5000);
                photos = doc.select("#photo_zoom img");
                String photoUrl = null;
                
                photoUrl = photos.attr("src");
                request.setAttribute("infoUrl", stringUrl);
                request.setAttribute("info", "ephoto");
                request.setAttribute("photoUrl", photoUrl);
            }  
            
            if("flickr".equals(sUrl)) {
                String stringUrl ="http://www.flickr.com/explore";
                URL url = new URL(stringUrl);
                String photoUrl = null;
                Document doc = Jsoup.parse(url,5000); 
            
                Elements photos = doc.select(".Interestingness img");
                
                photoUrl = photos.attr("src");
                request.setAttribute("infoUrl", stringUrl);
                request.setAttribute("info", "flickr");
                request.setAttribute("photoUrl", photoUrl);
            }
            if("xkcd".equals(sUrl)) {
                String stringUrl ="http://www.xkcd.com/";
                URL url = new URL(stringUrl);
                String photoUrl = null;
                Document doc = Jsoup.parse(url,5000); 

                Elements photos = doc.select("#comic img");
                
                photoUrl = photos.attr("src");
                request.setAttribute("infoUrl", stringUrl);
                request.setAttribute("info", "xkcd");
                request.setAttribute("photoUrl", photoUrl);
            
            }
            if("naturfoto".equals(sUrl)) {
                String stringUrl ="http://www.naturfoto.cz/";
                URL url = new URL(stringUrl);
                String photoUrl = null;
                Document doc = Jsoup.parse(url,5000); 

                Elements photos = doc.select(".item-big img");
                photoUrl = "http://www.naturfoto.cz" + photos.attr("src");
                
                request.setAttribute("infoUrl", stringUrl);
                request.setAttribute("info", "naturfoto");
                request.setAttribute("photoUrl", photoUrl);
            }
    }

}
