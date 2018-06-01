package org.example.beans;

import java.util.Calendar;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoHtml;
import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.example.beans.Documenttype;
import org.example.beans.Typeandcategory;

@HippoEssentialsGenerated(internalName = "dynamicvaluelistpoc:contentdocument")
@Node(jcrType = "dynamicvaluelistpoc:contentdocument")
public class ContentDocument extends BaseDocument {
    @HippoEssentialsGenerated(internalName = "dynamicvaluelistpoc:introduction")
    public String getIntroduction() {
        return getProperty("dynamicvaluelistpoc:introduction");
    }

    @HippoEssentialsGenerated(internalName = "dynamicvaluelistpoc:title")
    public String getTitle() {
        return getProperty("dynamicvaluelistpoc:title");
    }

    @HippoEssentialsGenerated(internalName = "dynamicvaluelistpoc:content")
    public HippoHtml getContent() {
        return getHippoHtml("dynamicvaluelistpoc:content");
    }

    @HippoEssentialsGenerated(internalName = "dynamicvaluelistpoc:publicationdate")
    public Calendar getPublicationDate() {
        return getProperty("dynamicvaluelistpoc:publicationdate");
    }

    @HippoEssentialsGenerated(internalName = "dynamicvaluelistpoc:typeandcategory")
    public Typeandcategory getTypeandcategory() {
        return getBean("dynamicvaluelistpoc:typeandcategory",
                Typeandcategory.class);
    }
}
