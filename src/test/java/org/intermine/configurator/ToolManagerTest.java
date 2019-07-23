package org.intermine.configurator;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ToolManagerTest {

    @Test
    public void testToolList() {
        List tools = ToolManager.getAllTools();
        // there should be lots of tools
        assertTrue(tools.size() >= 10);
    }

    private static final List<String> TOOLS = new ArrayList<>();

    static {
        TOOLS.add("@intermine/bluegenes-cytoscape-interaction-network-viewer@1.1.0");
        TOOLS.add("@intermine/bluegenes-protvista@1.1.1");
    }

    @Test
    public void testGetDataTools() {
        List tools = ToolManager.getDataTools(TOOLS);
        assertEquals(2, tools.size());
    }
}