public class ExceptionHandling {
    public static void trycatchBlock(){
        try{
            System.out.print("A"); 
            int num = 99/0; 
            System.out.print("B"); 
        }
        catch (ArithmeticException ex){
            System.out.print("C"); 
        }
        catch (Exception ex){
            System.out.print("D"); 
        }
        System.out.print("E"); 
    }

    public static void trycatchfinallyBlock(){
        try{
            System.out.print("A"); 
            int num = 99/0; 
            System.out.print("B"); 
        }
        catch (ArithmeticException ex){
            System.out.print("C"); 
        }
        catch (Exception ex){
            System.out.print("D"); 
        }
        finally{
            System.out.print("E");
        }  
        System.out.print("F"); 
    }
    public static void tcf1(){
        try{
            System.out.print("A"); 
            throw new Exception(); 
        }catch(Exception e){
            System.out.print("B"); 
        }finally{
            System.out.print("C"); 
            int num = 7/0;
            System.out.print("D"); 
        }
        System.out.print("E"); 
    }
    public static void tcf2(){
        // Nested tcf
        try{
            System.out.print("X"); 
            throw new Exception(); 
        }catch(Exception e){
            try{
                try{
                    throw new Exception(); 
                }catch(Exception ex){
                    System.out.print("Y"); 
                }
                throw new Exception() ; 
            }catch(Exception exc){
                System.out.print("Z"); 
            }finally{
                System.out.print("AA"); 
            }
        }finally {
            System.out.print("BB"); 
        }System.out.print("CC"); 
    }
    public static void main(String args[]){
        trycatchBlock(); 
        System.out.println(""); 
        trycatchfinallyBlock(); 
        System.out.println(""); 
        tcf1(); 
        System.out.println(""); 
        tcf2(); 
    }
}
