package resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ActivityPanel extends JPanel implements ActionListener {
    ImageIcon rock_icon, paper_icon, scissor_icon, reset_icon;
    JButton button_rock, button_paper, button_scissor;
    JButton button_rock_1, button_paper_1, button_scissor_1;
    JButton reset;
    JLabel label, score_p, score_c;
    int score_player, score_computer;

    public ActivityPanel() {
        rock_icon = new ImageIcon(new ImageIcon("src\\resources\\images\\rock.png").getImage()
                .getScaledInstance(80, 80, Image.SCALE_DEFAULT));

        paper_icon = new ImageIcon(new ImageIcon("src\\resources\\images\\paper.png").getImage()
                .getScaledInstance(80, 80, Image.SCALE_DEFAULT));

        scissor_icon = new ImageIcon(new ImageIcon("src\\resources\\images\\scissor.png").getImage()
                .getScaledInstance(80, 80, Image.SCALE_DEFAULT));

        reset_icon = new ImageIcon(new ImageIcon("src\\resources\\images\\reset.png").getImage()
                .getScaledInstance(65, 65, Image.SCALE_DEFAULT));

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 600));
        init();

        JPanel reset_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        reset = new JButton(reset_icon);
        reset_panel.add(reset);
        reset.addActionListener(this);
        add(reset_panel, BorderLayout.EAST);

        JPanel label_panel = new JPanel(new GridBagLayout());
        label_panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        label = new JLabel();
        label.setFont(new Font("century gothic", Font.BOLD, 32));

        label_panel.add(label);

        add(label_panel, BorderLayout.CENTER);

        JPanel score_panel = new JPanel(new GridLayout(2, 1));
        score_p = new JLabel("Player score: " + score_player);
        score_c = new JLabel("Computer score: " + score_computer);

        score_panel.add(score_c);
        score_panel.add(score_p);

        add(score_panel, BorderLayout.WEST);
    }

    private void init() {
        JPanel player_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 5));
        JPanel non_player_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 5));
        Font font = new Font("Californian FB", Font.PLAIN, 14);

        button_rock = new JButton("rock", rock_icon);
        button_rock.setVerticalTextPosition(SwingConstants.BOTTOM);
        button_rock.setHorizontalTextPosition(SwingConstants.CENTER);
        button_rock.setFont(font);

        button_paper = new JButton("paper", paper_icon);
        button_paper.setVerticalTextPosition(SwingConstants.BOTTOM);
        button_paper.setHorizontalTextPosition(SwingConstants.CENTER);
        button_paper.setFont(font);

        button_scissor = new JButton("scissor", scissor_icon);
        button_scissor.setVerticalTextPosition(SwingConstants.BOTTOM);
        button_scissor.setHorizontalTextPosition(SwingConstants.CENTER);
        button_scissor.setFont(font);

        button_rock_1 = new JButton("rock", rock_icon);
        button_rock_1.setVerticalTextPosition(SwingConstants.BOTTOM);
        button_rock_1.setHorizontalTextPosition(SwingConstants.CENTER);
        button_rock_1.setFont(font);

        button_paper_1 = new JButton("paper", paper_icon);
        button_paper_1.setVerticalTextPosition(SwingConstants.BOTTOM);
        button_paper_1.setHorizontalTextPosition(SwingConstants.CENTER);
        button_paper_1.setFont(font);

        button_scissor_1 = new JButton("scissor", scissor_icon);
        button_scissor_1.setVerticalTextPosition(SwingConstants.BOTTOM);
        button_scissor_1.setHorizontalTextPosition(SwingConstants.CENTER);
        button_scissor_1.setFont(font);

        player_panel.add(button_rock);
        player_panel.add(button_paper);
        player_panel.add(button_scissor);

        non_player_panel.add(button_rock_1);
        non_player_panel.add(button_paper_1);
        non_player_panel.add(button_scissor_1);

        add(non_player_panel, BorderLayout.NORTH);
        add(player_panel, BorderLayout.SOUTH);

        button_rock_1.setEnabled(false);
        button_paper_1.setEnabled(false);
        button_scissor_1.setEnabled(false);

        button_rock.addActionListener(this);
        button_paper.addActionListener(this);
        button_scissor.addActionListener(this);
    }

    private void calculate(String player) {
        int random = new Random().nextInt(3);
        String[] list = { "rock", "paper", "scissor" };

        String computer = list[random];

        System.out.println("Computer: " + computer);
        System.out.println("Player: " + player);

        switch (random) {
            case 0:
                button_rock_1.setEnabled(true);
                button_rock_1.setBackground(Color.GREEN);
                break;

            case 1:
                button_paper_1.setEnabled(true);
                button_paper_1.setBackground(Color.GREEN);
                break;

            case 2:
                button_scissor_1.setEnabled(true);
                button_scissor_1.setBackground(Color.GREEN);
                break;
        }

        if (computer.equals(player)) {
            label.setText("Its Draw");
        } else if (computer.equals("rock")) {
            if (player.equals("paper")) {
                label.setText("Player Wins!");
                score_player++;
            } else {
                label.setText("Computer Wins!");
                score_computer++;
            }
        } else if (computer.equals("paper")) {
            if (player.equals("scissor")) {
                label.setText("Player Wins!");
                score_player++;
            } else {
                label.setText("Computer Wins!");
                score_computer++;
            }
        } else if (computer.equals("scissor")) {
            if (player.equals("rock")) {
                label.setText("Player Wins!");
                score_player++;
            } else {
                label.setText("Computer Wins!");
                score_computer++;
            }
        }

        score_c.setText("Computer score: " + score_computer);
        score_p.setText("Player score: " + score_player);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button_rock) {
            button_rock.setBackground(Color.GREEN);
            button_paper.setEnabled(false);
            button_scissor.setEnabled(false);
            calculate(button_rock.getText());
        }

        if (e.getSource() == button_paper) {
            button_paper.setBackground(Color.GREEN);
            button_rock.setEnabled(false);
            button_scissor.setEnabled(false);
            calculate(button_paper.getText());
        }
        if (e.getSource() == button_scissor) {
            button_scissor.setBackground(Color.GREEN);
            button_rock.setEnabled(false);
            button_paper.setEnabled(false);
            calculate(button_scissor.getText());
        }

        if (e.getSource() == reset) {
            // player
            button_rock.setEnabled(true);
            button_paper.setEnabled(true);
            button_scissor.setEnabled(true);

            button_rock.setBackground(Color.WHITE);
            button_paper.setBackground(Color.WHITE);
            button_scissor.setBackground(Color.WHITE);

            // Computer
            button_rock_1.setEnabled(false);
            button_paper_1.setEnabled(false);
            button_scissor_1.setEnabled(false);

            button_rock_1.setBackground(Color.WHITE);
            button_paper_1.setBackground(Color.WHITE);
            button_scissor_1.setBackground(Color.WHITE);

            // resetting label
            label.setText("");
        }
    }
}
