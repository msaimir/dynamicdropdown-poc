package org.example.beans;

import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoDocument;
import org.example.beans.Documenttype;

@HippoEssentialsGenerated(internalName = "dynamicvaluelistpoc:typeandcategory")
@Node(jcrType = "dynamicvaluelistpoc:typeandcategory")
public class Typeandcategory extends HippoDocument {
    @HippoEssentialsGenerated(internalName = "dynamicvaluelistpoc:category")
    public String getCategory() {
        return getProperty("dynamicvaluelistpoc:category");
    }

    @HippoEssentialsGenerated(internalName = "dynamicvaluelistpoc:type")
    public Documenttype getType() {
        return getBean("dynamicvaluelistpoc:type", Documenttype.class);
    }
}
