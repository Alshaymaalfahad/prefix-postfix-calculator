import java.util.Stack;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
 
public class projectData extends JFrame {
       private JLabel label;
       private JLabel label1;
       private JTextField text;
       private JButton button;
       private JTextField text2;
       private JButton button2;
       private JLabel label2;
       private Font font;
 
public projectData() {
setTitle("Prefix and Postfix Project");
setLayout(null);
 
 
label=new JLabel("Enter the expression in prefix");
font =new Font("Serif",Font.BOLD,30);
label.setFont(font);
label.setSize(label.getPreferredSize());
label.setBounds(880,150,800,80);
label.setForeground(Color.white);
add(label);
 
text=new JTextField(22);
font =new Font("Serif",Font.PLAIN,30);
text.setFont(font);
text.setBounds(980,235,150,30);
add(text);
 
button=new JButton("Calculate Prefix");
font =new Font("Serif",Font.PLAIN,20);
button.setFont(font);
button.setBounds(930,300,250,30);
Color color1=new Color(255,255,255);
button.setBackground(color1);
button.setForeground(Color.black);
add(button);
 
label2=new JLabel("Enter the expression in postfix");
font =new Font("Serif",Font.BOLD,30);
label2.setFont(font);
label2.setBounds(880,350,800,80);
label2.setForeground(Color.white);
add(label2);
 
text2=new JTextField(22);
font =new Font("Serif",Font.PLAIN,30);
text2.setFont(font);
text2.setBounds(980,435,150,30);
add(text2);
 
button2=new JButton("Calculate Postfix");
font =new Font("Serif",Font.PLAIN,20);
button2.setFont(font);
button2.setBounds(930,500,250,30);
button2.setBackground(color1);
button2.setForeground(Color.black);
add(button2);
 
Icon bug=new ImageIcon(getClass().getResource("/codee.png"));
label1=new JLabel("");
label1.setIcon(bug);
label1.setBounds(0,0,50000000,700);
add(label1);
 
Handller handller=new Handller();
button.addActionListener(handller);
button2.addActionListener(handller);
 
}
private class Handller implements ActionListener{
public void actionPerformed(ActionEvent e) {
 
if(e.getSource()==button) {
String expression=text.getText();
int PrefixResult=Prefix(expression);
JOptionPane.showMessageDialog(null,"The result of Prefix:" +PrefixResult);}
 
else if(e.getSource()==button2){
String express=text2.getText();
int PostfixResult=Postfix(express);
JOptionPane.showMessageDialog(null,"The result of Postfix:"+PostfixResult); }
}
}
 
static Boolean Operand(char c){       
       
       if(c>=48 && c<=57)              
 
           return true;               
       else
           return false;           
 
   }
   static int Prefix(String expression){
      
       Stack<Integer> Stack = new Stack<>();  
       
       for(int j=expression.length()-1;j>=0;j--){  
           
           if(Operand(expression.charAt(j)))
               
               Stack.push((int)(expression.charAt(j)-48));  
           else{
               if(expression.charAt(j)==' '){    
 
                   continue;        
 
               }
 
               else{              
 
                   int o1 = Stack.peek();
 
                   Stack.pop();
 
                   int o2 = Stack.peek();
 
                   Stack.pop();
 
                   switch(expression.charAt(j)){         
 
                       case '+':                 
 
                           Stack.push(o1 + o2);       
 
                           break;
 
                       case '-':                 
 
                           Stack.push(o1 - o2);   
 
                           break;
 
                       case '*':                 
 
                           Stack.push(o1 * o2);  
 
                           break;
 
                       case '/':                  
 
                           Stack.push(o1 / o2);   
 
                           break;
 
                       case '%':                  
 
                           Stack.push(o1%o2);      
 
                           break;
                   }
 
               }
 
           }
 
       }
 
       return Stack.peek();      
   }
  
   static Boolean Operand2(char c2){
       
       
       if(c2>=48 && c2<=57)              
 
           return true;              
       else
           return false;           
 
   }
   static int Postfix(String express){
      
       Stack<Integer> Stacks = new Stack<>();  
       
       for(int i=0;i<express.length();i++){
        
           if(Operand2(express.charAt(i)))
               
               Stacks.push((int)(express.charAt(i)-'0'));  
           else{
               if(express.charAt(i)==' '){    
 
                   continue;        
 
               }
 
               else{              
 
                  int o1 = Stacks.peek();
 
                   o1= Stacks.pop();
                  int o2 = Stacks.peek();
 
                  o2=  Stacks.pop();
 
                   switch(express.charAt(i)){         
 
                       case '+':                 
 
                           Stacks.push(o2 + o1);       
 
                           break;
 
                       case '-':                 
 
                           Stacks.push(o2 - o1);   
 
                           break;
 
                       case '*':                 
 
                           Stacks.push(o2 * o1);  
 
                           break;
 
                       case '/':                  
 
                           Stacks.push(o2 / o1);   
 
                           break;
 
                       case '%':                  
 
                           Stacks.push(o2%o1);      
 
                           break;
                   }
 
               }
 
           }
        }
 
 
       return Stacks.pop();
       }
  
     
 
 
 
 
 
}
