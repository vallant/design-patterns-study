package view.swing;

import controller.interfaces.SideBarController;
import data.User;
import view.interfaces.SideBarView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by stephan on 08.07.17.
 */
public class SideBarViewSwing implements SideBarView {

    private final JFrame frame;

    private final JButton btProjects;
    private final JButton btStatistics;
    private final JButton btAdministration;
    private final JButton btSettings;

    private final JPanel pSideBar;
    private final JPanel pFloatPanel;
    //private final JButton btHelp;

    private SideBarController controller;
    public SideBarViewSwing(JFrame frame) {
        this.frame = frame;

        pSideBar = new JPanel(new GridLayout(4,1,5,5));
        pSideBar.setBorder(new EmptyBorder(5,5,5,5));
        btProjects = new JButton("Manage Projects");
        btStatistics = new JButton("Personal Statistics");
        btAdministration = new JButton("Administration");
        btSettings = new JButton("Settings");

        pFloatPanel = new JPanel(new FlowLayout(5));
        pSideBar.add(btProjects);
        pSideBar.add(btStatistics);
        pSideBar.add(btSettings);

        pFloatPanel.add(pSideBar);
        setListeners();
        //pSideBar.add(btAdministration);

    }

    private void setListeners() {
        btProjects.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.projectsClicked();
            }
        });
        btStatistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.statisticsClicked();
            }
        });
        btAdministration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.administrationClicked();
            }
        });

        btSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.settingsClicked();
            }
        });
    }

    @Override
    public void setController(SideBarController controller) {
        this.controller = controller;
    }

    @Override
    public void show(User.ROLE role) {
        if(role == User.ROLE.ADMIN)
            pSideBar.add(btAdministration);
        else
            pSideBar.remove(btAdministration);

        frame.getContentPane().add(pFloatPanel, BorderLayout.WEST);
    }
}