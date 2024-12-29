public class Cards{

   String cardType;
   int number = 0;
   
   public Cards(String type, int num){
      cardType = type;
      number = num;
   }
   
   public String getType(){
      return cardType;
   }
   
   public int getNumber(){
      return number;
   }
}