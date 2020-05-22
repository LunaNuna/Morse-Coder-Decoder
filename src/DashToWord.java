
import java.util.ArrayList;


public class DashToWord {
    
    private static String words; 
    
    public static String convert(ArrayList <String> c){
        words = "";
         for (int k=0; k<c.size(); k++){
        
           String i = c.get(k);
           while(i.length()>0 && i.indexOf("/")!=-1){
               int pos = i.indexOf("/");
               words += AlphaList(i.substring(0, pos));
               i = i.substring(pos+1);
           }
           words+=" ";
           
       }
       return(words);
       
       
        /*
        for (int k=0; k<c.size(); k++){
            String i =c.get(k);
            int count=CountSlashes(i);
            System.out.println(count);
            int f=0;
            int pos=i.indexOf("/");
          
            while(count>0){
                words += AlphaList(i.substring(f,pos));
                f=pos+1;
                i=i.substring(f);
                System.out.println(i);
                pos=i.indexOf("/");
                count--;
             }
             words+=" ";
         }   

        return(words);
        */
    }
      
    
        //figure out how to get return of AlphaLIst per letter signal
        
        /*for (int k=0; k<c.size(); k++){
            int f=0;
            int pos=0;
            String i =c.get(k);
            for(int a=0;a<i.length();a++){
                if(i.substring(a,a+1).equals("/")){
                   pos=a;
               words+= AlphaList(i.substring(f,pos));
                     f=pos;
               pos=pos+1;
               }
                
            }
            //String i = "";
           //for(int i = 0; i); 
            //words+= AlphaList(c.get(k).substring()) +" "; 
         }
      */ 
    
    /*
    public static int CountSlashes (String a){
        int count=0;
        for(int k=0;k<a.length();k++){
            if(a.substring(k,k+1).equals("/")){
                count++;
            }    
        }
       return(count);
   }
*/
    
    
    
    public static String AlphaList(String l){
        if (l.equals("*-")){
            return("a");
        }
        else if(l.equals("-***")){
            return("b");
        }
        else if(l.equals("-*-*")){
            return("c");
        }
        else if(l.equals("-**")){
            return("d");
        }
        else if(l.equals("*")){
            return("e");
        }
        else if(l.equals("**-*")){
            return("f");
        }
        else if(l.equals("--*")){
            return("g");
        }
        else if(l.equals("****")){
            return("h");
        }
        else if(l.equals("**")){
            return("i");
        }
        else if(l.equals("*---")){
            return("j");
        }
        else if(l.equals("-*-")){
            return("k");
        }
        else if(l.equals("*-**")){
            return("l");
        }
        else if(l.equals("--")){
            return("m");
        }
        else if(l.equals("-*")){
            return("n");
        }
        else if(l.equals("---")){
            return("o");
        }
        else if(l.equals("*--*")){
            return("p");
        }
        else if(l.equals("--*-")){
            return("q");
        }
        else if(l.equals("*-*")){
            return("r");
        }
        else if(l.equals("***")){
            return("s");
        }
        else if(l.equals("-")){
            return("t");
        }
        else if(l.equals("**-")){
            return("u");
        }
        else if(l.equals("***-")){
            return("v");
        }
        else if(l.equals("*--")){
            return("w");
        }
        else if(l.equals("-**-")){
            return("x");
        }
        else if(l.equals("-*--")){
            return("y");
        }
        else if(l.equals("--**")){
            return("z");
        }
        else if (l.equals("")){
            return("");
        }
       
         System.out.println("error: could not find dash to word coversion");
        return("***");
    }
    
    
}
