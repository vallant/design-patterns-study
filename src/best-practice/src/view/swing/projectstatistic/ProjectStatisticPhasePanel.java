package view.swing.projectstatistic;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by stephan on 17/07/17.
 */
public class ProjectStatisticPhasePanel extends JPanel{

    final JPanel pHeader;

    final JComboBox<String> cbPeriod;

    final ProjectStatisticTableModel tblProjectsModel;
    final JTable tblPhases;
    final JScrollPane scrpTable;
    final JButton btBack;

    public ProjectStatisticPhasePanel() {
        super(new BorderLayout(5,5));
        this.pHeader = new JPanel(new FlowLayout(5));

        this.cbPeriod = new JComboBox<>();
        cbPeriod.addItem("All Time");
        cbPeriod.addItem("Last Year");
        cbPeriod.addItem("Last Month");
        cbPeriod.addItem("Last Week");
        cbPeriod.addItem("Last Day");


        btBack = new JButton("Back");

        this.tblProjectsModel = new ProjectStatisticTableModel("Phasename");
        this.tblPhases = new JTable(tblProjectsModel);
        scrpTable = new JScrollPane(tblPhases);

        tblPhases.setBorder(new LineBorder(Color.black, 1));
        pHeader.add(btBack);
        pHeader.add(cbPeriod);
        add(pHeader, BorderLayout.NORTH);
        add(scrpTable, BorderLayout.CENTER);

    }
}
