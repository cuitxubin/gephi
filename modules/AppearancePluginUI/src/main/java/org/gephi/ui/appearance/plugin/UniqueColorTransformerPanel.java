/*
 Copyright 2008-2013 Gephi
 Authors : Mathieu Bastian <mathieu.bastian@gephi.org>
 Website : http://www.gephi.org

 This file is part of Gephi.

 DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

 Copyright 2013 Gephi Consortium. All rights reserved.

 The contents of this file are subject to the terms of either the GNU
 General Public License Version 3 only ("GPL") or the Common
 Development and Distribution License("CDDL") (collectively, the
 "License"). You may not use this file except in compliance with the
 License. You can obtain a copy of the License at
 http://gephi.org/about/legal/license-notice/
 or /cddl-1.0.txt and /gpl-3.0.txt. See the License for the
 specific language governing permissions and limitations under the
 License.  When distributing the software, include this License Header
 Notice in each file and include the License files at
 /cddl-1.0.txt and /gpl-3.0.txt. If applicable, add the following below the
 License Header, with the fields enclosed by brackets [] replaced by
 your own identifying information:
 "Portions Copyrighted [year] [name of copyright owner]"

 If you wish your version of this file to be governed by only the CDDL
 or only the GPL Version 3, indicate your decision by adding
 "[Contributor] elects to include this software in this distribution
 under the [CDDL or GPL Version 3] license." If you do not indicate a
 single choice of license, a recipient has the option to distribute
 your version of this file under either the CDDL, the GPL Version 3 or
 to extend the choice of license to its licensees as provided above.
 However, if you add GPL Version 3 code and therefore, elected the GPL
 Version 3 license, then the option applies only if the new code is
 made subject to such option by the copyright holder.

 Contributor(s):

 Portions Copyrighted 2013 Gephi Consortium.
 */
package org.gephi.ui.appearance.plugin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import net.java.dev.colorchooser.ColorChooser;
import org.gephi.appearance.api.SimpleFunction;
import org.gephi.appearance.plugin.UniqueElementColorTransformer;

/**
 *
 * @author mbastian
 */
public class UniqueColorTransformerPanel extends javax.swing.JPanel {

    private UniqueElementColorTransformer transformer;

    /**
     * Creates new form UniqueNodeColorTransformerPanel
     */
    public UniqueColorTransformerPanel() {
        initComponents();

        colorChooser.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals(ColorChooser.PROP_COLOR)) {
                    if (!transformer.getColor().equals(colorChooser.getColor())) {
                        transformer.setColor(colorChooser.getColor());
                        colorLabel.setText(getHex(colorChooser.getColor()));
                    }
                }
            }
        });
    }

    public void setup(SimpleFunction function) {
        transformer = (UniqueElementColorTransformer) function.getTransformer();
        colorChooser.setColor(transformer.getColor());
        colorLabel.setText(getHex(transformer.getColor()));
    }

    private String getHex(Color color) {
        return "#" + String.format("%06x", color.getRGB() & 0x00FFFFFF);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        colorChooser = new net.java.dev.colorchooser.ColorChooser();
        colorLabel = new javax.swing.JLabel();

        colorChooser.setMinimumSize(new java.awt.Dimension(14, 14));
        colorChooser.setPreferredSize(new java.awt.Dimension(14, 14));
        colorChooser.setToolTipText(org.openide.util.NbBundle.getMessage(UniqueColorTransformerPanel.class, "UniqueColorTransformerPanel.colorChooser.toolTipText")); // NOI18N

        javax.swing.GroupLayout colorChooserLayout = new javax.swing.GroupLayout(colorChooser);
        colorChooser.setLayout(colorChooserLayout);
        colorChooserLayout.setHorizontalGroup(
            colorChooserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        colorChooserLayout.setVerticalGroup(
            colorChooserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(colorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(colorLabel)
                    .addComponent(colorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(278, 278, 278))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private net.java.dev.colorchooser.ColorChooser colorChooser;
    private javax.swing.JLabel colorLabel;
    // End of variables declaration//GEN-END:variables
}
