
import java.util.ArrayList;


public class WordToDash {
    
    private static ArrayList<String> code; 
    
    public static ArrayList<String> convert(ArrayList <String> s){
        code = new ArrayList <String>();
        
        for (int k=0; k<s.size(); k++){
            String i = "";
            for (int q=0; q<s.get(k).length(); q++){
                if (AlphaList(s.get(k).substring(q, q+1)).equals("error")==false){
                    i +=AlphaList(s.get(k).substring(q, q+1))+"/";
                }
                else{
                    System.out.println("error converting words to dash at word #"+k+" letter #"+q);
                    System.out.println("***symbols and numbers cannot be converted to morse code***");
                    System.exit(0);
                }
            }
            code.add(i);
        }
        
        return(code);
        
    }
    
    public static String AlphaList(String l){
        if (l.compareToIgnoreCase("a")==0){
            return("*-");
        }
        else if(l.compareToIgnoreCase("b")==0){
            return("-***");
        }
        else if(l.compareToIgnoreCase("c")==0){
            return("-*-*");
        }
        else if(l.compareToIgnoreCase("d")==0){
            return("-**");
        }
        else if(l.compareToIgnoreCase("e")==0){
            return("*");
        }
        else if(l.compareToIgnoreCase("f")==0){
            return("**-*");
        }
        else if(l.compareToIgnoreCase("g")==0){
            return("--*");
        }
        else if(l.compareToIgnoreCase("h")==0){
            return("****");
        }
        else if(l.compareToIgnoreCase("i")==0){
            return("**");
        }
        else if(l.compareToIgnoreCase("j")==0){
            return("*---");
        }
        else if(l.compareToIgnoreCase("k")==0){
            return("-*-");
        }
        else if(l.compareToIgnoreCase("l")==0){
            return("*-**");
        }
        else if(l.compareToIgnoreCase("m")==0){
            return("--");
        }
        else if(l.compareToIgnoreCase("n")==0){
            return("-*");
        }
        else if(l.compareToIgnoreCase("o")==0){
            return("---");
        }
        else if(l.compareToIgnoreCase("p")==0){
            return("*--*");
        }
        else if(l.compareToIgnoreCase("q")==0){
            return("--*-");
        }
        else if(l.compareToIgnoreCase("r")==0){
            return("*-*");
        }
        else if(l.compareToIgnoreCase("s")==0){
            return("***");
        }
        else if(l.compareToIgnoreCase("t")==0){
            return("-");
        }
        else if(l.compareToIgnoreCase("u")==0){
            return("**-");
        }
        else if(l.compareToIgnoreCase("v")==0){
            return("***-");
        }
        else if(l.compareToIgnoreCase("w")==0){
            return("*--");
        }
        else if(l.compareToIgnoreCase("x")==0){
            return("-**-");
        }
        else if(l.compareToIgnoreCase("y")==0){
            return("-*--");
        }
        else if(l.compareToIgnoreCase("z")==0){
            return("--**");
        }
        return("error");
        
    }
    
    
}
