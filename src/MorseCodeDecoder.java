import com.phidget22.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class MorseCodeDecoder extends javax.swing.JFrame {

    VoltageRatioInput ch;
    //VoltageInput ch2;
    
     ArrayList<Double> levels = new ArrayList<Double>();
     ArrayList<String> signalDetect = new ArrayList<String>(); //index contains each signal in groups
     private String detect = "";
     private ArrayList <String> code = new ArrayList <String>();
     private String word;

    
     private int unit = 100;
     private int difference = 10; //how many times sensor checks for each flash unit; 1/100 per unit
    private int wDot = difference; // single unit flahsed by coder is 
    private int wDash = 3*wDot;
    private int bLetter = 3*wDot;
    private int bWord = 7*wDot;
    
        private int delayTime = unit/difference;

    private double tolerance = difference/(2); //+- how many num signals (0 or 1) can be off
    
    
    public MorseCodeDecoder() {
        initComponents();
        detect = "";
        buttonRead.setEnabled(false);
        buttonDecode.setEnabled(false);
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonActivateSensor = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        textValue = new javax.swing.JTextField();
        buttonRead = new javax.swing.JButton();
        panelDraw = new javax.swing.JPanel();
        buttonDecode = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textDecoded = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonActivateSensor.setText("activate sensor");
        buttonActivateSensor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActivateSensorActionPerformed(evt);
            }
        });

        jButton1.setText("get value 0");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonRead.setText("Read Morse Code");
        buttonRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDrawLayout = new javax.swing.GroupLayout(panelDraw);
        panelDraw.setLayout(panelDrawLayout);
        panelDrawLayout.setHorizontalGroup(
            panelDrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelDrawLayout.setVerticalGroup(
            panelDrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
        );

        buttonDecode.setText("decode");
        buttonDecode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDecodeActionPerformed(evt);
            }
        });

        textDecoded.setColumns(20);
        textDecoded.setRows(5);
        jScrollPane1.setViewportView(textDecoded);

        jLabel1.setText("DECODED:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelDraw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(buttonActivateSensor, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(buttonRead))
                                        .addGap(61, 61, 61)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textValue, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton1)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(buttonDecode)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonActivateSensor)
                    .addComponent(jButton1))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRead))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDecode)
                .addGap(26, 26, 26)
                .addComponent(panelDraw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActivateSensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActivateSensorActionPerformed
        try {
             ch = new VoltageRatioInput();
             //ch2 = new VoltageInput();                 //not correct one for rotation sensor...
             //ch.setDeviceSerialNumber(283033);  //dont use...
             ch.setChannel(0);
             //ch2.setChannel(1);
             ch.open(5000);
            //ch2.open(5000);
             System.out.println("connected");
             buttonRead.setEnabled(true);
             
             buttonActivateSensor.setEnabled(false);

        }catch(Exception e)  { 
            System.out.println("connect fail UG!");
        }
    }//GEN-LAST:event_buttonActivateSensorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
           double val;
           val = ch.getSensorValue();
           //val2=ch2.getSensorValue();
           //textValue.setText(""+val + "      " + val2);
        }
        catch(Exception e) {
            System.out.println("error reading sensor value");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReadActionPerformed
    levels.clear();
    
    double time=0;
    int count=0;
    
    do{
        try {
           double val;
           val = ch.getSensorValue();
           System.out.println("Adding " + val + " at " + time/1000);
           levels.add(val);
           time+=delayTime;
           Thread.sleep(delayTime);
        }
        catch(Exception e) {
            System.out.println("error in reading loop!");
        }
        
        if ((levels.get(levels.size()-1))<=(levels.get(0)+0.1) && (levels.get(levels.size()-1))>= (levels.get(0)-0.1)){
            count++;
        }
        else{
            count=0;
        }
    }while(count<=bWord+(tolerance*3));
    
    System.out.println("sensor reading ended");
   
    //drawing out the graph
    Graphics g = panelDraw.getGraphics();
    g.setColor(Color.WHITE);
    g.fillRect(0,0,panelDraw.getWidth(), panelDraw.getHeight() );
    g.setColor(Color.BLACK);
    for(int k=0; k<levels.size()-1; k++) {
        double h1=levels.get(k);
        double h2=levels.get(k+1);
        g.drawLine(k, (int)(h1*100), k+1, (int)(h2*100));
    }
    
  
    //get max level
   double max=levels.get(0);
   for(int k=1;k<levels.size()-1;k++){
       if(levels.get(k)>max){
           max=levels.get(k);
       }
   }
   System.out.println("max:"+max);
    
   //get min level
      double min=levels.get(1);
   for(int k=1;k<levels.size()-1;k++){
       if(levels.get(k)<min){
           min=levels.get(k);
       }
   }
    System.out.println("min:"+min);

       //getting the average light level
      double ave=(max+min)/2;
     System.out.println("ave:"+ave);
     
     //setting standardh and standardl
     double quarter =(max-min)/4;
     double standardh=ave+quarter;
     double standardl=ave-quarter;
     
     //show standardl and standardh on graph
    g.setColor(Color.RED);
    for(int k=0; k<levels.size()-1; k++) {
        g.drawLine(k, (int)(standardh*100), k+1, (int)(standardh*100));
        g.drawLine(k, (int)(standardl*100), k+1, (int)(standardl*100));
    }
    
    //show average on graph
     g.setColor(Color.ORANGE);
    for(int k=0; k<levels.size()-1; k++) {
        g.drawLine(k, (int)(ave*100), k+1, (int)(ave*100));
    }
     
     //puts info into black(0) or white(1) into a single string detect
     for(int k=0;k<levels.size();k++){
         if(levels.get(k)<standardl){
           detect+="0";
        }
         else if(levels.get(k)>standardh){
           detect+="1";
        }
     }
     System.out.println("light signal detected: ");
     System.out.println(detect);
 
     buttonDecode.setEnabled(true);
     buttonRead.setEnabled(false);
    
    }//GEN-LAST:event_buttonReadActionPerformed
    
    //changes grouped numbers in each index of signalDectect into - or *
    public void numsToDash(ArrayList <String> s){
        code.clear();
        
        for (int k=0; k<s.size(); k++){
            String group = "";
            while(k<s.size() && s.get(k).length()<bWord-tolerance){//stop if black is greater than 7 units (bword)
                
                if(s.get(k).substring(0,1).equals("0") && s.get(k).length()>=bLetter-tolerance){
                        group+="/";
                }
                else if (s.get(k).substring(0,1).equals("1")){
                    if (s.get(k).length()<=wDot+tolerance){//single unit flash
                        group+="*";
                    }
                    else {//dash flash
                        group+="-";
                    }
                }
                k++;
            }
            code.add(group+"/");
        }
    }    
    
    
    private void buttonDecodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDecodeActionPerformed
      //signalDetect groups each bunch of same numbers into each index
        signalDetect.clear();
        code.clear();
       for (int k=0; k<detect.length(); k++){
            String group = detect.substring(k,k+1);
            while( k<detect.length()-1 && detect.substring(k, k+1).equals(detect.substring(k+1, k+2))){
                group +=detect.substring(k+1, k+2);
                k++;
            }
            signalDetect.add(group);
        }
        
        
        //print out singalDetect
        System.out.println("Printing signals detected...");
        for (String s: signalDetect){
            System.out.println(s);
        }
        
        //convert nums to dot dash
       numsToDash(signalDetect);
       
       //print out dash and dot code
       System.out.println("Printing dash and dot code...");
        for (String s: code){
            System.out.println(s);
        }
        
       //convert dot and dash to words
        System.out.println("Converting to words...");
       word=DashToWord.convert(code);
       System.out.println("Conversion:");
       System.out.print(word);
       
       //put decoded words in textDecoded
       textDecoded.setText(word);
       
       buttonDecode.setEnabled(false);
       buttonRead.setEnabled(true);
        
        
    }//GEN-LAST:event_buttonDecodeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MorseCodeDecoder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MorseCodeDecoder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MorseCodeDecoder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MorseCodeDecoder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MorseCodeDecoder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonActivateSensor;
    private javax.swing.JButton buttonDecode;
    private javax.swing.JButton buttonRead;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelDraw;
    private javax.swing.JTextArea textDecoded;
    private javax.swing.JTextField textValue;
    // End of variables declaration//GEN-END:variables
}
