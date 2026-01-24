public class PaaswordValidator {
    public static void main(String[] args) {
        

        String password="ABCVI@#890";

        boolean hasUpper=false;
        boolean hasLower=false;
        boolean hasDigit=false;
        boolean hasSpecial=false;


        if(password.length()<8){
            System.out.println("Password too short");
            return;
        }

        for(int i=0;i<password.length();i++){

            char ch=password.charAt(i);

            if(ch>='A' && ch<='Z'){
                hasUpper=true;
            }
            else if(ch>='a' && ch<='z'){
                hasLower=true;
            }
             
            else if(ch>='0' && ch<='9'){
                hasDigit=true;
            }
            else{
                hasSpecial=true;
            }
        }

        if(hasLower && hasUpper && hasSpecial && hasDigit){
            System.out.println("Password Validated!");
        }
        else{
            System.out.println("Password is Wrong");
        }
    }
}
