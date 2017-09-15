/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableCellRendererColor extends DefaultTableCellRenderer {

    /**
     *
     * @author elaprendiz - jleod7 <http://www.youtube.com/user/jleod7>
     */
    private JLabel componente;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        componente = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        componente.setForeground(Color.white);
        if (row % 2 == 0) {
            componente.setBackground(Color.BLACK);
        } else {
            componente.setBackground(Color.blue);
        }
        if (isSelected) {
            componente.setBackground(Color.lightGray);
        }

        return componente;
    }
}
