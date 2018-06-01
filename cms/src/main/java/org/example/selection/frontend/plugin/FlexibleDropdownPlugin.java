package org.example.selection.frontend.plugin;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.ItemNotFoundException;
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
    protected ValueList getValueList(final String configuredValueListName) {

        String valueListName = configuredValueListName;

        Map<String, String> typeMap = new HashMap<>();
        IPluginConfig clusterOptionsConfig = getPluginConfig().getPluginConfig("cluster.options");
        if (clusterOptionsConfig != null) {
            String[] valuelist = clusterOptionsConfig.getStringArray("valuelist");
            String[] nodeType = clusterOptionsConfig.getStringArray("nodetype");

            if (valuelist != null && nodeType != null && valuelist.length == nodeType.length) {
                for (int i = 0; i < nodeType.length; i++) {
                    typeMap.put(nodeType[i], valuelist[i]);
                }
            }
        }
        if (!typeMap.isEmpty()) {

            try {
                String propertyPath = this.getValueModel().getJcrPropertymodel().getProperty().getPath();
                Session session = obtainSession();
                String nodePath = propertyPath.substring(0, propertyPath.lastIndexOf('/'));
                Node node = session.getNode(nodePath);
                while (node != null && !node.isNodeType("hippostd:folder") && !node.isNodeType("hippo:handle")) {

                    String nodeName = node.getPrimaryNodeType().getName();
                    if (typeMap.containsKey( node.getPrimaryNodeType().getName())) {
                        valueListName = typeMap.get(nodeName);
                        break;
                    } else {
                        try {
                            node = node.getParent();
                        } catch (ItemNotFoundException e) {
                            break;
                        }
                    }
                }

            } catch (RepositoryException e) {
                log.error("Error accessing the repository", e);
            }
        }

        return super.getValueList(valueListName);
    }

    private Session obtainSession() {
        UserSession userSession = (UserSession) org.apache.wicket.Session.get();
        return userSession.getJcrSession();
    }
}
