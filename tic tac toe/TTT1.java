import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TTT1 extends JFrame implements ActionListener {
  int i, j, ii, jj, x, y, yesnull;
  int a[][] = { { 10, 1, 2, 3, 11 }, { 10, 1, 4, 7, 11 }, { 10, 1, 5, 9, 11 }, { 10, 2, 5, 8, 11 },
      { 10, 3, 5, 7, 11 }, { 10, 3, 6, 9, 11 }, { 10, 4, 5, 6, 11 }, { 10, 7, 8, 9, 11 } };
  int a1[][] = { { 10, 1, 2, 3, 11 }, { 10, 1, 4, 7, 11 }, { 10, 1, 5, 9, 11 }, { 10, 2, 5, 8, 11 },
      { 10, 3, 5, 7, 11 }, { 10, 3, 6, 9, 11 }, { 10, 4, 5, 6, 11 }, { 10, 7, 8, 9, 11 } };

  boolean state, type, set;

  Icon ic1, ic2, icon, ic11, ic22;
  Checkbox c1, c2;
  JLabel l1, l2;
  JButton b[] = new JButton[9];
  JButton reset;
  JButton exit;
  JButton tombolVsKomputer;
  JButton tombolVsTeman;

  public void showButton() {

    x = 10;
    y = 10;
    j = 0;
    for (i = 0; i <= 8; i++, x += 100, j++) {
      b[i] = new JButton();
      if (j == 3) {
        j = 0;
        y += 100;
        x = 10;
      }
      b[i].setBounds(x, y, 100, 100);
      add(b[i]);
      b[i].addActionListener(this);
    } // eof for

    reset = new JButton("RESET");
    reset.setBounds(50, 350, 100, 50);
    reset.setBackground(Color.WHITE);
    add(reset);
    reset.addActionListener(this);

    exit = new JButton("EXIT");
    exit.setBounds(160, 350, 100, 50);
    exit.setBackground(Color.WHITE);
    add(exit);
    exit.addActionListener(this);

    tombolVsKomputer = new JButton("vs Komputer");
    tombolVsKomputer.setBounds(120, 80, 100, 40);
    tombolVsKomputer.addActionListener(this);
    add(tombolVsKomputer);

    tombolVsTeman = new JButton("vs Teman");
    tombolVsTeman.setBounds(120, 150, 100, 40);
    tombolVsTeman.addActionListener(this);
    add(tombolVsTeman);
  }// eof showButton

  /*********************************************************/
  public void check(int num1) {
    for (ii = 0; ii <= 7; ii++) {
      for (jj = 1; jj <= 3; jj++) {
        if (a[ii][jj] == num1) {
          a[ii][4] = 11;
        }

      } // eof for jj

    } // eof for ii
  }// eof check

  /**********************************************************/

  /*********************************************************/

  public void complogic(int num) {

    for (i = 0; i <= 7; i++) {
      for (j = 1; j <= 3; j++) {
        if (a[i][j] == num) {
          a[i][0] = 11;
          a[i][4] = 10;
        }
      }
    }
    for (i = 0; i <= 7; i++) { // for 1
      set = true;
      if (a[i][4] == 10) { // if 1
        int count = 0;
        for (j = 1; j <= 3; j++) { // for 2
          if (b[(a[i][j] - 1)].getIcon() != null) { // if 2
            count++;
          } // eof if 2
          else {
            yesnull = a[i][j];
          }
        } // eof for 2
        if (count == 2) { // if 2
          b[yesnull - 1].setIcon(ic2);
          this.check(yesnull);
          set = false;
          break;
        } // eof if 2
      } // eof if 1
      else if (a[i][0] == 10) {
        for (j = 1; j <= 3; j++) { // for2
          if (b[(a[i][j] - 1)].getIcon() == null) { // if 1
            b[(a[i][j] - 1)].setIcon(ic2);
            this.check(a[i][j]);
            set = false;
            break;
          } // eof if1
        } // eof for 2
        if (set == false)
          break;
      } // eof elseif

      if (set == false)
        break;
    } // eof for 1

  }// eof complogic

  /*********************************************************/

  TTT1() {
    super("tic tac toe by Ahmad Fawwaz");

    getContentPane().setBackground(Color.WHITE);

    tombolVsKomputer = new JButton("vs Komputer");
    tombolVsKomputer.setBounds(100, 80, 120, 40);
    tombolVsKomputer.addActionListener(this);
    tombolVsKomputer.setFocusPainted(false); // Menghilangkan border fokus
    tombolVsKomputer.setBackground(new Color(51, 153, 255)); // Warna latar belakang tombol
    tombolVsKomputer.setForeground(Color.WHITE); // Warna teks tombol
    tombolVsKomputer.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        tombolVsKomputer.setBackground(new Color(31, 122, 205)); // Warna latar belakang saat hover
      }

      public void mouseExited(java.awt.event.MouseEvent evt) {
        tombolVsKomputer.setBackground(new Color(51, 153, 255)); // Warna latar belakang kembali
      }
    });
    add(tombolVsKomputer);

    tombolVsTeman = new JButton("vs Teman");
    tombolVsTeman.setBounds(100, 150, 120, 40);
    tombolVsTeman.addActionListener(this);
    tombolVsTeman.setFocusPainted(false);
    tombolVsTeman.setBackground(new Color(255, 102, 102));
    tombolVsTeman.setForeground(Color.WHITE);
    tombolVsTeman.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        tombolVsTeman.setBackground(new Color(255, 51, 51));
      }

      public void mouseExited(java.awt.event.MouseEvent evt) {
        tombolVsTeman.setBackground(new Color(255, 102, 102));
      }
    });
    add(tombolVsTeman);

    state = true;
    type = true;
    set = true;
    ic1 = new ImageIcon("ic1.jpg");
    ic2 = new ImageIcon("ic2.jpg");
    ic11 = new ImageIcon("ic11.jpg");
    ic22 = new ImageIcon("ic22.jpg");

    setLayout(null);
    setSize(330, 450);
    setVisible(true);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }// eof constructor

  /*************************************************************/
  public void itemStateChanged(ItemEvent e) {
    if (c1.getState()) {
      type = false;
    }

    else if (c2.getState()) {
      type = true;
    }
    remove(c1);
    remove(c2);
    repaint(0, 0, 330, 450);
    showButton();
  }// eof itemstate

  /************************************************************/

  public void actionPerformed(ActionEvent e) {
    /********************************/
    if (type == true)// logicfriend
    {
      if (e.getSource() == reset) {
        for (i = 0; i <= 8; i++) {
          b[i].setIcon(null);
        } // eof for
      } else {
        for (i = 0; i <= 8; i++) {
          if (e.getSource() == b[i]) {

            if (b[i].getIcon() == null) {
              if (state == true) {
                icon = ic2;
                state = false;
              } else {
                icon = ic1;
                state = true;
              }
              b[i].setIcon(icon);
            }
          }
        } // eof for
      } // eof else
    } // eof logicfriend
    else if (type == false) { // complogic
      if (e.getSource() == reset) {
        for (i = 0; i <= 8; i++) {
          b[i].setIcon(null);
        } // eof for
        for (i = 0; i <= 7; i++)
          for (j = 0; j <= 4; j++)
            a[i][j] = a1[i][j]; // again initialsing array
      } else { // complogic
        for (i = 0; i <= 8; i++) {
          if (e.getSource() == b[i]) {
            if (b[i].getIcon() == null) {
              b[i].setIcon(ic1);
              if (b[4].getIcon() == null) {
                b[4].setIcon(ic2);
                this.check(5);
              } else {
                this.complogic(i);
              }
            }
          }
        } // eof for
      }
    } // eof complogic

    if (e.getSource() == tombolVsKomputer) {
      type = false;
      remove(tombolVsKomputer);
      remove(tombolVsTeman);
      repaint(0, 0, 330, 450);
      showButton();
    } else if (e.getSource() == tombolVsTeman) {
      type = true;
      remove(tombolVsKomputer);
      remove(tombolVsTeman);
      repaint(0, 0, 330, 450);
      showButton();
    }

    for (i = 0; i <= 7; i++) {

      Icon icon1 = b[(a[i][1] - 1)].getIcon();
      Icon icon2 = b[(a[i][2] - 1)].getIcon();
      Icon icon3 = b[(a[i][3] - 1)].getIcon();
      if ((icon1 == icon2) && (icon2 == icon3) && (icon1 != null)) {
        if (icon1 == ic1) {
          b[(a[i][1] - 1)].setIcon(ic11);
          b[(a[i][2] - 1)].setIcon(ic11);
          b[(a[i][3] - 1)].setIcon(ic11);
          JOptionPane.showMessageDialog(TTT1.this, "KAMU MENANG!!! klik reset untuk mulai ulang");
          break;
        } else if (icon1 == ic2) {
          b[(a[i][1] - 1)].setIcon(ic22);
          b[(a[i][2] - 1)].setIcon(ic22);
          b[(a[i][3] - 1)].setIcon(ic22);
          JOptionPane.showMessageDialog(TTT1.this, "KOMPUTER MENANG!!! klik reset untuk mulai ulang");
          break;
        }
      }
    }

    if (e.getSource() == exit) {
      UIManager.put("OptionPane.yesButtonText", "Ya");
      UIManager.put("OptionPane.noButtonText", "Tidak");
      int option = JOptionPane.showConfirmDialog(TTT1.this, "Apakah Ingin Keluar?", "Keluar",
          JOptionPane.YES_NO_OPTION);
      if (option == JOptionPane.YES_OPTION) {
        System.exit(0);
      }
    }

  }// eof actionperformed

  /************************************************************/

  public static void main(String[] args) {
    new TTT1();
  }// eof main
}// eof class