package com.tinkerpop.furnace.algorithms;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.furnace.util.QueryHelper;
import com.tinkerpop.furnace.util.QueryTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class DegreeCentrality implements GlobalGraphRank<Map<Vertex, Long>> {

    public Map<Vertex, Long> compute(final Graph graph, final QueryTemplate query) {
        final Map<Vertex, Long> rank = new HashMap<Vertex, Long>();
        for (final Vertex vertex : graph.getVertices()) {
            rank.put(vertex, QueryHelper.createQuery(vertex, query).count());
        }
        return rank;
    }
}
