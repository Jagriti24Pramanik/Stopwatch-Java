import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Stopwatch1 implements ActionListener {

    JFrame frame ;
    JButton startButton = new JButton(" START ");
    JButton resetButton = new JButton(" RESET ");
    JLabel timeLabel = new JLabel();
    int elTime = 0;
    int sec=0;
    int min=0;
    int hr=0;
    int day=0;
    boolean s=false;
    String secStr = String.format("%02d", sec);
    String minStr = String.format("%02d", min);
    String hrStr = String.format("%02d", hr);
    String dayStr = String.format("%02d", day);

    Timer timer = new Timer(1000, new ActionListener() {

        public void actionPerformed(ActionEvent e) {

              elTime=elTime+1000;
              day=(elTime/(3600000*24));
              hr=(elTime/3600000);
              min=(elTime/60000)%60;
              sec=(elTime/1000)%60;
              secStr=String.format("%02d", sec);
              minStr=String.format("%02d", min);
              hrStr=String.format("%02d", hr);
              dayStr = String.format( "%02d", day);
              timeLabel.setText(dayStr + " : "  + hrStr + " : " + minStr + " : " + secStr);
        }
    });

    Stopwatch1() {
        
        frame = new JFrame(" JAGRITI STOPWATCH ");
        timeLabel.setText( dayStr + " : " + hrStr + " : " + minStr + " : " + secStr);
        timeLabel.setBounds(100, 100, 300, 100);
        timeLabel.setFont(new Font("Verdana",Font.ITALIC,30));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(100,250,150,50);
        startButton.setFont(new Font("Ink Free",Font.ITALIC,30));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        resetButton.setBounds(250,250,150,50);
        resetButton.setFont(new Font("Ink Free",Font.ITALIC,30));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        
        frame.add(startButton);
        frame.add(resetButton);
        frame.add(timeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Stopwatch1 sw= new Stopwatch1();
    }

    public void actionPerformed( ActionEvent e){

        if(e.getSource()==startButton) {

            if(s==false) {
                s=true;
                startButton.setText("STOP");
                start();
            }
            else {
                s=false;
                startButton.setText("START");
                stop();
            }
        }
        if(e.getSource()==resetButton) {
            s=false;
            resetButton.setText("RESET");
            reset();
        }
    }
    void start() {
        timer.start();
    }
    void stop() {
         timer.stop();
    }
    void reset() {
        timer.stop();
        elTime=0;
        day=0;
        sec=0;
        min=0;
        hr=0;
        secStr= String.format("%02d", sec);
        minStr=String.format("%02d", min);
        hrStr= String.format("%02d", hr);
        dayStr=String.format("%02d", day);
        timeLabel.setText(dayStr + " : " + hrStr + " : " + minStr + " : " + secStr);
    }
}