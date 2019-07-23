package org.intermine.configurator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.DataTool;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Manages the tools available for the InterMine wizard.
 *
 * TODO gets the list of tools from a URL that might not be production ready!
 */
public class ToolManager {

    private static final String URL = "http://bluegenes.apps.intermine.org/api/tools/all";
    private static Map<String, DataTool> dataTools = new HashMap<String, DataTool>();

    /**
     * Based on the list from Bluegenes, return a list of all available tools.
     *
     * @return list of data tools available
     */
    public static List<DataTool> getAllTools() {
        if (dataTools.isEmpty()) {
            try {
                populateToolMap();
            } catch (IOException e) {
                throw new RuntimeException("couldn't load map " + e);
            }
        }
        return new ArrayList<>(dataTools.values());
    }

    /**
     * Transform the toolIDs into a list of DataTools they represent
     *
     * @param selectedToolIds the IDs of tools selected by the user
     * @return list of data tools
     */
    public static List<DataTool> getDataTools(List<String> selectedToolIds) {
        if (selectedToolIds == null || selectedToolIds.isEmpty()) {
            return null;
        }
        List<DataTool> selectedTools = new ArrayList<DataTool>();
        // for each selected id, get the matching object
        for (String toolId : selectedToolIds) {
            DataTool tool = dataTools.get(toolId);
            if (tool == null) {
                continue;
            }
            selectedTools.add(tool);
        }
        return selectedTools;
    }

    /**
     * read in contents of URL into a string
     *
     * @param requestURL URL to read from
     * @return String
     * @throws IOException if URL can't be reached
     */
    private static String readStringFromURL(String requestURL) throws IOException {
        try (Scanner scanner = new Scanner(new URL(requestURL).openStream(),
                StandardCharsets.UTF_8.toString())) {
            scanner.useDelimiter("\\A");
            if (scanner.hasNext()) {
                String jsonString = scanner.next();
                scanner.close();
                return jsonString;
            }
            scanner.close();
            return null;
        }
    }

    private static void populateToolMap() throws IOException {
        String jsonString = readStringFromURL(URL);
        jsonString = jsonString.replace("\"package\":", "\"packageName\":");
        ToolShed toolshed = new ObjectMapper().readValue(jsonString, ToolShed.class);

        ArrayList<Tool> tools = toolshed.tools;
        for (Tool tool : tools) {
            processTool(tool);
        }
    }

    private static void processTool(Tool tool) {
        String preview = tool.hasimage;
        ToolName names = tool.names;
        ToolPackage packageName = tool.packageName;

        String toolId = packageName._id;

        DataTool dataTool = new DataTool();
        dataTool.setToolId(toolId);
        dataTool.setToolName(names.human);
        dataTool.setToolDescription(packageName.description);
        dataTool.setToolPreview(preview);

        dataTools.put(toolId, dataTool);
    }
}

class ToolShed
{
    @JsonProperty("tools")
    ArrayList<Tool> tools;
}

@JsonIgnoreProperties({"config"})
class Tool
{
    @JsonProperty("hasimage")
    String hasimage;
    @JsonProperty("names")
    ToolName names;
    @JsonProperty("packageName")
    ToolPackage packageName;
}

class ToolName
{
    @JsonProperty("human")
    String human;
    @JsonProperty("cljs")
    String cljs;
    @JsonProperty("npm")
    String npm;
}

@JsonIgnoreProperties({"_requiredBy", "_requested", "repository", "license", "homepage", "name", "_resolved", "scripts", "bundleDependencies", "_integrity", "_location", "_spec", "bugs", "keywords", "author", "_where", "devDependencies", "deprecated", "_phantomChildren", "_inBundle", "version", "main", "dependencies", "_shasum", "_from", "lint-staged", "husky"})
class ToolPackage
{
    @JsonProperty("description")
    String description;
    @JsonProperty("_id")
    String _id;
}
