package org.example.selection.frontend.plugin;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.hippoecm.frontend.plugin.IPluginContext;
import org.hippoecm.frontend.plugin.config.IPluginConfig;
import org.hippoecm.frontend.session.UserSession;
import org.onehippo.forge.selection.frontend.model.ValueList;
import org.onehippo.forge.selection.frontend.plugin.DynamicDropdownPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlexibleDropdownPlugin extends DynamicDropdownPlugin {

    private static final Logger log = LoggerFactory.getLogger(FlexibleDropdownPlugin.class);

    public FlexibleDropdownPlugin(final IPluginContext context, final IPluginConfig config) {
        super(context, config);
    }

    @Override
    protected String getValueListName(final Object objectValue) {
        return super.getValueListName(objectValue);
    }

    @Override
    protected ValueList getValueList(final String configuredValueListName) {
        String valueListName = configuredValueListName;
        IPluginConfig config = getPluginConfig().getPluginConfig("cluster.options");
        String[] valuelist = config.getStringArray("valuelist");
        String[] parentType = config.getStringArray("parentType");
        if (valuelist.length == parentType.length) {
            Map<String, String> parentTypeMap = new HashMap<>();
            for(int i = 0; i<parentType.length; i++ ){
                parentTypeMap.put(parentType[i], valuelist[i]);
            }
            try {
                String propertyPath = this.getValueModel().getJcrPropertymodel().getProperty().getPath();
                Session session = obtainSession();
                String nodePath = propertyPath.substring(0, propertyPath.lastIndexOf('/'));
                Node node = session.getNode(nodePath);
                String parentNodeName = node.getParent().getPrimaryNodeType().getName();
                if(parentTypeMap.containsKey(parentNodeName)){
                    valueListName = parentTypeMap.get(parentNodeName);
                }

            } catch (RepositoryException e) {
                log.error("");
            }
        }

        return super.getValueList(valueListName);
    }

    private Session obtainSession() {
        UserSession userSession = (UserSession) org.apache.wicket.Session.get();
        return userSession.getJcrSession();
    }
}
