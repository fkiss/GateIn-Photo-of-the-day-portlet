/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gatein.simpleportlet;

import java.io.IOException;
import java.net.URL;
import javax.portlet.*;

/**
 *
 * @author fkiss
 */
public class PhotoChanger extends GenericPortlet {
    
    @Override
    public void doEdit(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        
        PortletRequestDispatcher prd =getPortletContext().getRequestDispatcher("/WEB-INF/jsp/Changer_edit.jsp");
        prd.include(request, response);
        
    }
    
    @Override
    public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        
        PortletRequestDispatcher prd =getPortletContext().getRequestDispatcher("/WEB-INF/jsp/Changer_view.jsp");
        prd.include(request, response);
        
    }
    
    @Override
    public void doHelp(RenderRequest request, RenderResponse response) throws PortletException, IOException {
    
        PortletRequestDispatcher prd =getPortletContext().getRequestDispatcher("/WEB-INF/jsp/Changer_help.jsp");
        prd.include(request, response);
        
    }
    
    public void processAction(ActionRequest req, ActionResponse res)
    throws IOException, PortletException {
    
        PortletPreferences prefs = req.getPreferences();
        String url = req.getParameter("url");
        
        res.setRenderParameter("url", url);
    }
}
