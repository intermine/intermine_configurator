package org.intermine.configurator;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.DataTool;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

/**
 * manages the tools
 */
public class ToolManager {

    private static final String URL = "http://bluegenes.apps.intermine.org/api/tools/all";
    private static Map<String, DataTool> dataTools = new HashMap<String, DataTool>();


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

    public static List<DataTool> getTools(List<String> toolIds) {
        List<DataTool> selectedTools = new ArrayList<DataTool>();
        for (String toolId : toolIds) {
            DataTool tool = dataTools.get(toolId);
            if (tool == null) {
                return null;
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

//couldn't load map com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException: Unrecognized field "tools" (class org.intermine.configurator.ToolShed), not marked as ignorable (0 known properties: ])
//        at [Source: (String)"{"tools":[{"names":{"human":"Protein Features","cljs":"bluegenesToolProtvista","npm":"@intermine/bluegenes-protvista"},"config":{"accepts":["id"],"classes":["Protein"],"columnMapping":{"Protein":{"id":"primaryAccession"}},"files":{"css":"dist/style.css","js":"dist/bundle.js"},"toolName":{"human":"Protein Features","cljs":"bluegenesToolProtvista"}},"packageName":{"description":"BlueGenes wrapper for protvista protein feature viewer","_id":"@intermine/bluegenes-protvista@1.1.1","_requiredBy":["/"]"[truncated 19155 chars]; line: 1, column: 11] (through reference chain: org.intermine.configurator.ToolShed["tools"])



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
