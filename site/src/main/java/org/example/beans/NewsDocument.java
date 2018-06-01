package org.example.beans;

import java.util.Calendar;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoDocument;
import org.hippoecm.hst.content.beans.standard.HippoGalleryImageSet;
import org.hippoecm.hst.content.beans.standard.HippoHtml;
import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.example.beans.Documenttype;
import org.example.beans.Typeandcategory;

@HippoEssentialsGenerated(internalName = "dynamicvaluelistpoc:newsdocument")
@Node(jcrType = "dynamicvaluelistpoc:newsdocument")
public class NewsDocument extends HippoDocument {
    /** 
     * The document type of the news document.
     */
    public final static String DOCUMENT_TYPE = "dynamicvaluelistpoc:newsdocument";
    private final static String TITLE = "dynamicvaluelistpoc:title";
    private final static String DATE = "dynamicvaluelistpoc:date";
    private final static String INTRODUCTION = "dynamicvaluelistpoc:introduction";
    private final static String IMAGE = "dynamicvaluelistpoc:image";
    private final static String CONTENT = "dynamicvaluelistpoc:content";
    private final static String LOCATION = "dynamicvaluelistpoc:location";
    private final static String AUTHOR = "dynamicvaluelistpoc:author";
    private final static String SOURCE = "dynamicvaluelistpoc:source";

    /** 
     * Get the title of the document.
     * @return the title
     */
    @HippoEssentialsGenerated(internalName = "dynamicvaluelistpoc:title")
    public String getTitle() {
        return getProperty(TITLE);
    }

    /** 
     * Get the date of the document.
     * @return the date
     */
    @HippoEssentialsGenerated(internalName = "dynamicvaluelistpoc:date")
    public Calendar getDate() {
        return getProperty(DATE);
    }

    /** 
     * Get the introduction of the document.
     * @return the introduction
     */
    @HippoEssentialsGenerated(internalName = "dynamicvaluelistpoc:introduction")
    public String getIntroduction() {
        return getProperty(INTRODUCTION);
    }

    /** 
     * Get the image of the document.
     * @return the image
     */
    @HippoEssentialsGenerated(internalName = "dynamicvaluelistpoc:image")
    public HippoGalleryImageSet getImage() {
        return getLinkedBean(IMAGE, HippoGalleryImageSet.class);
    }

    /** 
     * Get the main content of the document.
     * @return the content
     */
    @HippoEssentialsGenerated(internalName = "dynamicvaluelistpoc:content")
    public HippoHtml getContent() {
        return getHippoHtml(CONTENT);
    }

    /** 
     * Get the location of the document.
     * @return the location
     */
    @HippoEssentialsGenerated(internalName = "dynamicvaluelistpoc:location")
    public String getLocation() {
        return getProperty(LOCATION);
    }

    /** 
     * Get the author of the document.
     * @return the author
     */
    @HippoEssentialsGenerated(internalName = "dynamicvaluelistpoc:author")
    public String getAuthor() {
        return getProperty(AUTHOR);
    }

    /** 
     * Get the source of the document.
     * @return the source
     */
    @HippoEssentialsGenerated(internalName = "dynamicvaluelistpoc:source")
    public String getSource() {
        return getProperty(SOURCE);
    }

    @HippoEssentialsGenerated(internalName = "dynamicvaluelistpoc:typeandcategory")
    public Typeandcategory getTypeandcategory() {
        return getBean("dynamicvaluelistpoc:typeandcategory",
                Typeandcategory.class);
    }
}
