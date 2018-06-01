package org.example.beans;

import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoDocument;

@HippoEssentialsGenerated(internalName = "dynamicvaluelistpoc:documenttype")
@Node(jcrType = "dynamicvaluelistpoc:documenttype")
public class Documenttype extends HippoDocument {
    @HippoEssentialsGenerated(internalName = "dynamicvaluelistpoc:type")
    public String getType() {
        return getProperty("dynamicvaluelistpoc:type");
    }
}
