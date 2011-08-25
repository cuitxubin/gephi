/*
Copyright 2008-2011 Gephi
Authors : Antonio Patriarca <antoniopatriarca@gmail.com>
Website : http://www.gephi.org

This file is part of Gephi.

Gephi is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

Gephi is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gephi.visualization.api.selection;

import java.awt.Point;
import java.util.Collection;
import javax.swing.event.ChangeListener;
import org.gephi.graph.api.Edge;
import org.gephi.graph.api.Node;
import org.gephi.visualization.api.VisualizationController;

/**
 * Manager for handling selection queries.
 *
 * This is a singleton class and is provided by the {@link VisualizationController}.
 * 
 * @see VisualizationController#getSelectionManager()
 * 
 * @author Antonio Patriarca <antoniopatriarca@gmail.com>
 * @author Vojtech Bardiovsky <vojtech.bardiovsky@gmail.com>
 */
public interface SelectionManager {

    void initialize();

    /**
     * Returns every selected node.
     */
    Collection<Node> getSelectedNodes();

    /**
     * Returns <code>true</code> if any node is selected.
     */
    boolean isNodeSelected();
    
    /**
     * Adds or removes nodes from inside the shape to a permanent selection.
     * @param shape     the shape for applying the selection.
     */
    void applySelection(Shape shape);

    /**
     * Adds nodes from inside the shape to a temporary selection.
     * @param shape     the shape for applying the temporary selection.
     * @see #cancelContinuousSelection()
     */
    void applyContinuousSelection(Shape shape);

    /**
     * Cancels temporary selection.
     */
    void cancelContinuousSelection();

    /**
     * Adds or removes single node from a permanent selection.
     * @param point the point to determine the closest node.
     * @param select true to select, false to deselect.
     */
    void selectSingle(Point point, boolean select);

    /**
     * Adds or removes single node from a temporary selection.
     * @param point the point to determine the closest node.
     * @param select true to select, false to deselect.
     * @return true if node has been selected.
     */
    boolean selectContinuousSingle(Point point, boolean select);

    /**
     * Select an edge.
     */
    void selectEdge(Edge edge);

    /**
     * Select edges.
     */
    void selectEdges(Edge[] edges);

    /**
     * Select a node.
     */
    void selectNode(Node node);

    /**
     * Select nodes.
     */
    void selectNodes(Node[] nodes);
    
    /**
     * Deselects all selected nodes.
     */
    void clearSelection();
    
    /**
     * Deselects all selected nodes and disables the selection.
     */
    void disableSelection();

    /**
     * Returns the shape that is drawn around the pointer for single selection,
     * usually a zero radius circle.
     */
    Shape getNodePointerShape();

    boolean isDirectMouseSelection();

    boolean isDraggingEnabled();

    boolean isSelectionEnabled();

    boolean isNodeDraggingEnabled();

    void setDirectMouseSelection();

    void setDraggingEnabled(boolean enabled);

    void setNodeDraggingEnabled();

    SelectionType getSelectionType();
    
    void setSelectionType(SelectionType selectionType);

    /**
     * Called when the spatial information or graph have changed to rebuild used
     * data structure.
     */
    void refresh();
    
    // Events
    void addChangeListener(ChangeListener changeListener);
    
    void removeChangeListener(ChangeListener changeListener);

}
