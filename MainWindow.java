import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.util.Random;

public class MainWindow extends JFrame {
    
    private int remainingGuesses;
    private String wrongGuesses;
    private String word;
    private String visible;
    private boolean easyMode = true;
    public MainWindow(String toGuess) {
        remainingGuesses = 10;
        wrongGuesses = "";
        word = toGuess; //get rid if nothing works
        visible = "";
        
        for(int i = 0; i < word.length(); ++i) {
            visible += "_ ";
        }

        JPanel corePanel = new JPanel();
        corePanel.setLayout(new BorderLayout());
        
        final JLabel status = new JLabel("You have "+remainingGuesses+" remaining", SwingConstants.CENTER);
        final JLabel wrong = new JLabel("Wrong guesses so far: "+wrongGuesses);
        
        final JLabel visibleLabel = new JLabel(visible, SwingConstants.CENTER);
        final JTextField input = new JTextField(); 
        final JLabel mode = new JLabel("Mode (type e for easy and h for hard)");
        final JTextField modeEntered = new JTextField();
        
        JPanel southPanel = new JPanel(new GridLayout(10, 1));
        southPanel.add(status);
        southPanel.add(visibleLabel);
        southPanel.add(input);
        southPanel.add(wrong);
        southPanel.add(mode);
        southPanel.add(modeEntered);
        
        corePanel.add(southPanel, BorderLayout.SOUTH);
        
        final HangmanFigure hf = new HangmanFigure();
        corePanel.add(hf, BorderLayout.CENTER);

        this.add(corePanel, BorderLayout.CENTER);
        
        
      
          modeEntered.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String modeIn = modeEntered.getText();
                
                if(modeIn.equals("e")){
                    easyMode = true;
                    dispose();
                }
                else{
                    easyMode = false;
                    dispose();
                }
                MainWindow main = new MainWindow(getWord(easyMode));
                System.out.println("mode: " + easyMode);
                //modeEntered.setText("");
            }
        });
        
        
        input.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String text = input.getText();
                
                if(text.length()  == 1 && text.matches("[a-z]")) {
                    
                    boolean guessFound = false;
                    
                    for(int i = 0; i < word.length(); ++i) {
                        if(text.charAt(0) == word.charAt(i)) {
                            guessFound = true;
                            
                            String newVisible = "";
                            for(int j = 0; j < visible.length(); ++j) {
                                if(j == (i*2)) {
                                    newVisible += word.charAt(i);
                                }
                                else {
                                    newVisible += visible.charAt(j);
                                }
                            }
                            visible = newVisible;
                            visibleLabel.setText(visible);
                        }
                    }
                    
                    if(!guessFound) {
                        if(--remainingGuesses >= 0) {
                            status.setText("You have "+remainingGuesses+" guesses remaining");
                            wrongGuesses += text+" ";
                            wrong.setText("Wrong guesses so far: "+wrongGuesses);
                            hf.set();
                        }
                        else {
                            status.setText("You lost: the word was "+word);
                            input.setEnabled(false);
                        }
                    }
                    else {
                        String actualVisible = "";
                        for(int i = 0; i < visible.length(); i+=2) {
                            actualVisible += visible.charAt(i);
                        }
                        
                        if(actualVisible.equals(word)) {
                            status.setText("Congratulations, you have won!");
                            input.setEnabled(false);
                        }
                    }
                    
                }
                else {
                    System.out.println("Invalid input!");
                }
                
                input.setText("");
            }
            
        });
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
         MainWindow main = new MainWindow("cat");
    }
    
    public String getWord(boolean mode){
        String [] easyWords = {"cat", "dog", "java", "mouse", "hi", "code", "water", "phone", "tin", "beach", "yes", 
            "sweater", "person", "class", "bike", "shake", "sports","place", "ball", "fun", "shallow", "find", 
            "money" };
         String [] hardWords = {"encyclopedia", "minions", "induction", "integration", "february", "refrigerator", 
             "mosquito", "algorithm", "askew", "azure", "bayou",  "grandmother", "kindergarten", "manufacturing", 
             "dwarves", "foxglove", "explanation", "hyphen","mysterious","kiosk", "schizophrenia"};

        if(mode == true){
            Random rnd = new Random();
            int length = 0;
            length = easyWords.length;
            int index = rnd.nextInt(length);
            return easyWords[index];
        }
        else{
            Random rnd = new Random();
            int length = 0;
            length = hardWords.length;
            int index = rnd.nextInt(length);
            return hardWords[index];
        }
    }
}