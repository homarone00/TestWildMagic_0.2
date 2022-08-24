package Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column.HPpanels;

import Project_take1.MyCharacter;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class TemporaryHealthPanel extends AbstractHealthPanel{
    public TemporaryHealthPanel(MyCharacter myCharacter) {
        super(myCharacter);
        setCurrentHealth();

        nameLabel.setText("<html>temp<br>HP</html>");
        nameLabel.setFont(new Font("Comic Sans",Font.BOLD,18));

        currentHealthField.setFont(new Font("Comic Sans",Font.BOLD,20));

        addingField.addActionListener(actionValue -> {
            String content=addingField.getText();
            if(!content.isEmpty()){
                if(content.startsWith("+")||content.startsWith("-")){
                    int integer;
                    try{
                        integer=Integer.parseInt(content);
                        int a=getCurrentHealth();
                        a+=integer;
                        setCurrentHealth(a);
                        addingField.setText("");
                    } catch (NumberFormatException ignored) {

                    }
                }
            }

        });

        hpPanel.add(currentHealthPanel,BorderLayout.CENTER);
    }
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
        currentHealthField.setText(String.valueOf(currentHealth));
        myCharacter.setTemporary_hp(currentHealth);
    }
    @Override
    public void setCurrentHealth() {
        currentHealth=myCharacter.getTemporary_hp();
        if(currentHealth<0){
            throw new IllegalStateException("TemporaryHealthPanel found a negative value for tmp hp");
        }
        currentHealthField.setText(String.valueOf(currentHealth));

    }

    @Override
    public int getCurrentHealth() {
        return 0;
    }

    @Override
    public void updateColors() {

    }

    @Override
    public void updatePanel() {

    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource().equals(currentHealthField)) {
            if (currentHealthField.getText().isEmpty()) {
                setCurrentHealth();
            } else {
                setCurrentHealth(Integer.parseInt(currentHealthField.getText()));
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource().equals(currentHealthField)){
            char c=e.getKeyChar();
            {
                if(!Character.isDigit(c)||c==KeyEvent.VK_DELETE){
                    e.consume();
                }
                if (currentHealthField.getText().length() >= (3) && c != KeyEvent.VK_DELETE &&
                        (currentHealthField.getSelectedText()==null)) {
                    e.consume();
                }
            }
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    /*if(temporary){
        nameLabel.setText("<html>temp<br>HP</html>");
        nameLabel.setFont(new Font("Comic Sans",Font.BOLD,18));
    }*/
    @Override
    public void paintComponent(Graphics g){
        this.arcHeight=30;
        this.arcWidth=30;
        super.paintComponent(g);
    }
}
