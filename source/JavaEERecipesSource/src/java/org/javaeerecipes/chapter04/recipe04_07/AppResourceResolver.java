
package org.javaeerecipes.chapter04.recipe04_07;

import java.io.IOException;
import java.net.URL;
import javax.faces.application.Resource;
import javax.faces.view.facelets.FaceletsResourceResolver;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.ResourceResolver;

/**
 * Recipe 4-7
 * @author juneau
 */
// Uncomment and redeploy to activate resource resolver
//@FaceletsResourceResolver
public class AppResourceResolver extends ResourceResolver {
    private ResourceResolver parent;
    public AppResourceResolver(ResourceResolver parent) {
        this.parent = parent;
    }
    
    public URL resolveUrl(String path) {
        System.out.println("Using Custom Resource Resolver");
        URL url = parent.resolveUrl(path);
        if (url == null) {

            if (path.startsWith("/")) {
                path = path.substring(1);
            }
            url = parent.resolveUrl(path);
        }
        return url;
    }

   

}